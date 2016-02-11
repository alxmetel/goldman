/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.score.impl;

import com.metel.goldman.database.SQLiteConnection;
import com.metel.goldman.objects.User;
import com.metel.goldman.objects.UserScore;
import com.metel.goldman.score.interfaces.ScoreSaver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Metel
 */
public class DbScoreSaver implements ScoreSaver {

    private SQLiteConnection sqliteDB = SQLiteConnection.getInstance();
    
    @Override
    public ArrayList<UserScore> getScoreList() {

        PreparedStatement selectStmt = null;
        ArrayList<UserScore> list = new ArrayList<>();
        ResultSet rs = null;

        try {

            selectStmt = sqliteDB.getConnection().prepareStatement("select "
                    + "count(s.score) as play_count, "
                    + "s.score, "
                    + "s.play_date, "
                    + "p.username "
                    + "from score s inner join player p on p.id = s.player_id where s.score>0 "
                    + "group by p.username order by s.score desc, play_count asc limit 10");

            rs = selectStmt.executeQuery();

            while (rs.next()) {
                UserScore userScore = new UserScore();

                userScore.setUser(new User(rs.getString("username")));
                userScore.setPlayDate(rs.getLong("play_date"));
                userScore.setScore(rs.getInt("score"));
                userScore.setPlayDate(rs.getLong("play_date"));
                userScore.setPlayCount(rs.getInt("play_count"));

                list.add(userScore);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbScoreSaver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (selectStmt != null) {
                try {
                    if (selectStmt!=null) {
                        selectStmt.close();
                    }
                    if (rs!=null) {
                        rs.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DbScoreSaver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    private boolean saveAll(UserScore userScore) throws SQLException {


        PreparedStatement insertStmt = null;

        int result = 0;

        try {

            insertStmt = sqliteDB.getConnection().prepareStatement("insert into score(player_id, score, play_date) values(?,?,?)");

            insertStmt.setInt(1, userScore.getUser().getId());
            insertStmt.setInt(2, userScore.getScore());
            insertStmt.setLong(3, new Date().getTime());

            result = insertStmt.executeUpdate();

            if (result == 0) {
                return false;
            }
            return true;

        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }
    
    @Override
    public boolean saveScore(UserScore userScore) {
        try {

            sqliteDB.getConnection().setAutoCommit(false);

            if (saveAll(userScore)) {
                sqliteDB.getConnection().commit();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbScoreSaver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sqliteDB.closeConnection();
        }
        return false;
    } 
}
