/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gui;

import com.metel.goldman.abstracts.AbstractMovingObject;
import com.metel.goldman.enums.ActionResult;
import com.metel.goldman.enums.GameObjectType;
import com.metel.goldman.enums.MovingDirection;
import com.metel.goldman.interfaces.gamemap.DrawableMap;
import com.metel.goldman.objects.GoldMan;
import com.metel.goldman.objects.listeners.MoveResultListener;
import com.metel.goldman.utils.MessageManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Metel
 */
public class FrameGame extends BaseChildFrame implements ActionListener, KeyListener, MoveResultListener {

    private DrawableMap map; // передаем объект карты, которая умеет себя рисовать

    /**
     * Creates new form FrameGame
     */
    public FrameGame() {
        initComponents();
    }

    public void setMap(DrawableMap gameMap) {
        this.map = gameMap;
        gameMap.drawMap();
        
        gameMap.getGameMap().getGameCollection().addMoveListener(this); 

        jlabelTurnsLeft.setText(String.valueOf(gameMap.getGameMap().getTimeLimit()));
        jPanelMap.removeAll();
        jPanelMap.add(gameMap.getMapComponent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelMap = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jbtnUp = new javax.swing.JButton();
        jbtnLeft = new javax.swing.JButton();
        jbtnRight = new javax.swing.JButton();
        jbtnDown = new javax.swing.JButton();
        jlableScoreText = new javax.swing.JLabel();
        jlabelScore = new javax.swing.JLabel();
        jlabelTurnsLeftText = new javax.swing.JLabel();
        jlabelTurnsLeft = new javax.swing.JLabel();
        jbtnSave = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setName("FrameGame"); // NOI18N

        jPanelMap.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelMapLayout = new javax.swing.GroupLayout(jPanelMap);
        jPanelMap.setLayout(jPanelMapLayout);
        jPanelMapLayout.setHorizontalGroup(
            jPanelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanelMapLayout.setVerticalGroup(
            jPanelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/up.png"))); // NOI18N
        jbtnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpActionPerformed(evt);
            }
        });

        jbtnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/left.png"))); // NOI18N
        jbtnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLeftActionPerformed(evt);
            }
        });

        jbtnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/right.png"))); // NOI18N
        jbtnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRightActionPerformed(evt);
            }
        });

        jbtnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/down.png"))); // NOI18N
        jbtnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDownActionPerformed(evt);
            }
        });

        jlableScoreText.setText("Score");

        jlabelScore.setText("0");

        jlabelTurnsLeftText.setText("Moves left");

        jlabelTurnsLeft.setText("0");

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/save.png"))); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/metel/goldman/images/exit.png"))); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jbtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelTurnsLeftText)
                    .addComponent(jlableScoreText))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelScore)
                    .addComponent(jlabelTurnsLeft))
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jbtnUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnLeft)
                    .addComponent(jbtnRight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDown)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableScoreText)
                    .addComponent(jlabelScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelTurnsLeftText)
                    .addComponent(jlabelTurnsLeft))
                .addGap(26, 26, 26)
                .addComponent(jbtnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMap, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Save Game");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit Game");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Service");

        jMenuItem3.setText("Statistics");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(479, 404));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDownActionPerformed
        moveObject(MovingDirection.DOWN, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnDownActionPerformed

    private void jbtnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRightActionPerformed
        moveObject(MovingDirection.RIGHT, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnRightActionPerformed

    private void jbtnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLeftActionPerformed
        moveObject(MovingDirection.LEFT, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnLeftActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpActionPerformed
        moveObject(MovingDirection.UP, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnUpActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelMap;
    private javax.swing.JButton jbtnDown;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLeft;
    private javax.swing.JButton jbtnRight;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnUp;
    private javax.swing.JLabel jlabelScore;
    private javax.swing.JLabel jlabelTurnsLeft;
    private javax.swing.JLabel jlabelTurnsLeftText;
    private javax.swing.JLabel jlableScoreText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void moveObject(MovingDirection movingDirection, GameObjectType gameObjectType) {
        map.getGameMap().getGameCollection().moveObject(movingDirection, gameObjectType);
    }

    private void gameFinished(String message) {
        MessageManager.showInformMessage(null, message);
        closeFrame();
    }
    
    private static final String DIE_MESSAGE="You lost the game!";
    private static final String WIN_MESSAGE="You won! Your points:";

    @Override
    public void notifyActionResult(ActionResult actionResult, AbstractMovingObject movingObject) {

        if (movingObject.getType().equals(GameObjectType.GOLDMAN)) {
            GoldMan goldMan = (GoldMan) movingObject;
            checkGoldManActions(actionResult, goldMan);
        }
        checkCommonActions(actionResult);
        map.drawMap();
    }

    private void checkGoldManActions(ActionResult actionResult, GoldMan goldMan) {
        switch (actionResult) {
            case MOVE: {

                jlabelTurnsLeft.setText(String.valueOf(map.getGameMap().getTimeLimit() - goldMan.getTurnsNumber()));

                if (goldMan.getTurnsNumber() >= map.getGameMap().getTimeLimit()) {
                    gameFinished(DIE_MESSAGE);
                }

                break;
            }

            case WIN: {
                gameFinished(WIN_MESSAGE + goldMan.getTotalScore());
            }
            case COLLECT_TREASURE: {
                jlabelScore.setText(String.valueOf(goldMan.getTotalScore()));
                break;
            }
        }
    }

    private void checkCommonActions(ActionResult actionResult) {
        switch (actionResult) {

            case DIE: {
                gameFinished(DIE_MESSAGE);
                break;
            }
        }
    }
}