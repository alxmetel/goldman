/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gui;

import com.metel.goldman.enums.LocationType;
import com.metel.goldman.interfaces.gamemap.collections.MapCollection;
import com.metel.goldman.objects.gui.maps.JTableGameMap;

/**
 *
 * @author Metel
 */
public class FrameMainMenu extends javax.swing.JFrame {

    private FrameGame frameGame;
    private FrameStat frameStat = new FrameStat();
    private FrameSavedGames frameLoadGame = new FrameSavedGames();
    
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
        if (frameGame == null){
            frameGame = new FrameGame();
        }
        frameGame.setMap(new JTableGameMap(LocationType.FS, "game.map", new MapCollection()));
        frameGame.showFrame(this);
    }//GEN-LAST:event_jbtnNewGameActionPerformed

    private void jbtnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStatisticsActionPerformed
        frameStat.showFrame(this);
    }//GEN-LAST:event_jbtnStatisticsActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        quit();
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoadGameActionPerformed
        frameLoadGame.showFrame(this);
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
}
