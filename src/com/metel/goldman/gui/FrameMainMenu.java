/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gui;

import com.metel.goldman.gamemap.impl.JTableGameMap;
import com.metel.goldman.gamemap.loader.abstracts.AbstractMapLoader;
import com.metel.goldman.gamemap.loader.impl.DBMapLoader;
import com.metel.goldman.objects.MapInfo;
import com.metel.goldman.sound.impl.WavPlayer;
import com.metel.goldman.objects.User;
import com.metel.goldman.score.impl.DbScoreSaver;
import com.metel.goldman.score.interfaces.ScoreSaver;
import com.metel.goldman.sound.interfaces.SoundPlayer;

/**
 *
 * @author Metel
 */
public class FrameMainMenu extends javax.swing.JFrame {

    private FrameGame frameGame;
    private FrameStat frameStat;
    private FrameSavedGames frameSavedGames;
    private ScoreSaver scoreSaver = new DbScoreSaver();
    private CustomDialog usernameDialog = new CustomDialog(this, "User name", "Enter your name:", true);;
    private JTableGameMap gameMap = new JTableGameMap();
    private AbstractMapLoader mapLoader = new DBMapLoader(gameMap);
    private SoundPlayer soundPlayer = new WavPlayer();
    private static final int MAP_LEVEL_ONE = 1;
    private User user;

    /**
     * Creates new form FrameMainMenu
     */
    public FrameMainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlMainMenu = new javax.swing.JPanel();
        jbtnNewGame = new javax.swing.JButton();
        jbtnLoadGame = new javax.swing.JButton();
        jbtnStatistics = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnNewGame.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jbtnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/new.png"))); // NOI18N
        jbtnNewGame.setText("New Game");
        jbtnNewGame.setToolTipText("Start new game");
        jbtnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewGameActionPerformed(evt);
            }
        });

        jbtnLoadGame.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jbtnLoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/load.png"))); // NOI18N
        jbtnLoadGame.setText("Load Game");
        jbtnLoadGame.setToolTipText("Load the game");
        jbtnLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoadGameActionPerformed(evt);
            }
        });

        jbtnStatistics.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jbtnStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/stat.png"))); // NOI18N
        jbtnStatistics.setText("Statistics");
        jbtnStatistics.setToolTipText("Show players' statistics");
        jbtnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStatisticsActionPerformed(evt);
            }
        });

        jbtnExit.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/exit.png"))); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setToolTipText("Quit the game");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlMainMenuLayout = new javax.swing.GroupLayout(jpnlMainMenu);
        jpnlMainMenu.setLayout(jpnlMainMenuLayout);
        jpnlMainMenuLayout.setHorizontalGroup(
            jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnStatistics)
                    .addComponent(jbtnExit)
                    .addComponent(jbtnLoadGame))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnlMainMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbtnExit, jbtnLoadGame, jbtnNewGame, jbtnStatistics});

        jpnlMainMenuLayout.setVerticalGroup(
            jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewGameActionPerformed
        if (!saveUser()) {
            return;
        }

        MapInfo mapInfo = new MapInfo();
        mapInfo.setLevelId(MAP_LEVEL_ONE);

        if (!mapLoader.loadMap(mapInfo)) {
            return;
        }

        createFrameGame();

        frameGame.showFrame(this);
    }//GEN-LAST:event_jbtnNewGameActionPerformed
    private void createFrameGame() {
        if (frameGame == null) {
            frameGame = new FrameGame(scoreSaver, mapLoader, soundPlayer);
        }
    }
    private void jbtnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStatisticsActionPerformed
        if (frameStat == null) {
            frameStat = new FrameStat();
        }

        frameStat.setList(scoreSaver.getScoreList());
        frameStat.showFrame(this);
    }//GEN-LAST:event_jbtnStatisticsActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        quit();
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoadGameActionPerformed
        if (!saveUser()) {
            return;
        }

        createFrameGame();

        if (frameSavedGames == null) {
            frameSavedGames = new FrameSavedGames(mapLoader, frameGame);
        }

        frameSavedGames.showFrame(this);
    }//GEN-LAST:event_jbtnLoadGameActionPerformed

    
    /**
     * quit game
     */
    private void quit() {
        System.exit(0);

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLoadGame;
    private javax.swing.JButton jbtnNewGame;
    private javax.swing.JButton jbtnStatistics;
    private javax.swing.JPanel jpnlMainMenu;
    // End of variables declaration//GEN-END:variables

    private String getUserNameDialog() {

        if (user != null && user.getUsername() != null) {
            usernameDialog.setUsername(user.getUsername());
        }

        usernameDialog.setVisible(true);

        return usernameDialog.getValidatedText();
    }

    
    private boolean saveUser() {// сохранить пользователя, получить его id

        String username = getUserNameDialog();

        if (username != null && !username.trim().equals("")) {
            
            if (user!=null && user.getUsername().equals(username)){// если ввел того же пользователя (т.е. ничего не менял)
                return true;
            }
            
            user = new User();
            user.setUsername(username);
            user.setId(mapLoader.getPlayerId(username));
            
            gameMap.getMapInfo().setUser(user);
            
            return true;
        } 
        return false;
    }
}
