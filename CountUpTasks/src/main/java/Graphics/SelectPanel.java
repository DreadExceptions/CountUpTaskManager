/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import SqliteJDBC.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

/**
 *
 * @author marquis
 */
public class SelectPanel extends javax.swing.JPanel {

    /**
     * Creates new form SelectPanel
     */
    JFrame jf;
    String url = "jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/CountUp.db";
    DateFormat tmstmpFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fieldCheck = "YYYY-MM-DD HH:MM:SS";
    String sortA = "";
    String sortB = "";
    String sortC = "";
    String filterCategory = "";
    String filterTimeframe = "";
    String filterCompleteness = "";
    String filterPriority = "";
    String view = "SELECT * FROM TASKS";
    
    public SelectPanel(JFrame jfrm) {
        this.jf = jfrm;
        //initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        taskTypeComboBox = new javax.swing.JComboBox<>();
        timeframeBox = new javax.swing.JComboBox<>();
        progressComboBox = new javax.swing.JComboBox<>();
        priorityBox = new javax.swing.JComboBox<>();
        returnButton = new javax.swing.JButton();
        viewAllButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        completedComboBox = new javax.swing.JComboBox<>();
        startedComboBox = new javax.swing.JComboBox<>();
        genreComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("Title");

        jLabel2.setText("Task Type");

        jLabel3.setText("Timeframe");

        jLabel4.setText("Progress");

        jLabel5.setText("Priority");

        jTextField1.setText("32 Characters Maximum");

        ArrayList<Reference> tasktypes = SqliteJDBC.Reference.referencesSQL("TASKTYPE");
        String[] tsktps = new String[tasktypes.size()];
        for (int i = 0; i < tsktps.length; i++) {
            tsktps[i] = tasktypes.get(i).getTitle();
        }
        taskTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(tsktps));

        ArrayList<Reference> timeframes = SqliteJDBC.Reference.referencesSQL("TIMEFRAME");
        String[] tmfrm = new String[timeframes.size()];
        for (int i = 0; i < tmfrm.length; i++) {
            tmfrm[i] = timeframes.get(i).getTitle();
        }
        timeframeBox.setModel(new javax.swing.DefaultComboBoxModel<>(tmfrm));

        ArrayList<Reference> progress = SqliteJDBC.Reference.referencesSQL("PROGRESS");
        String[] prgrss = new String[progress.size()];
        for (int i = 0; i < prgrss.length; i++) {
            prgrss[i] = progress.get(i).getTitle();
        }
        progressComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(prgrss));
        progressComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressComboBoxActionPerformed(evt);
            }
        });

        ArrayList<Reference> priorities = SqliteJDBC.Reference.referencesSQL("PRIORITY");
        String[] prrts = new String[priorities.size()];
        for (int i = 0; i < prrts.length; i++) {
            prrts[i] = priorities.get(i).getTitle();
        }
        priorityBox.setModel(new javax.swing.DefaultComboBoxModel<>(prrts));

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        viewAllButton.setText("View All");
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        completedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ignore", "Incomplete", "Completed" }));
        completedComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedComboBoxActionPerformed(evt);
            }
        });

        startedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ignore", "Not Started", "Started"}));
        startedComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startedComboBoxActionPerformed(evt);
            }
        });

        ArrayList<Reference> genres = SqliteJDBC.Reference.referencesSQL("GENRE");
        String[] gnrs = new String[genres.size()];
        for (int i = 0; i < gnrs.length; i++) {
            gnrs[i] = genres.get(i).getTitle();
        }
        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(gnrs));

        jLabel6.setText("Genre");

        jLabel7.setText("Started?");

        jLabel8.setText("Completed?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(completedComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startedComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(taskTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(genreComboBox, 0, 145, Short.MAX_VALUE)
                            .addComponent(timeframeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progressComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priorityBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(timeframeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(completedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(viewAllButton)
                    .addComponent(returnButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPanel strt = new StartPanel(fr);
        fr.add(strt);
        fr.pack();
        jf.dispose();
        fr.setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllButtonActionPerformed
        try {
            if (!sortA.isBlank()||!sortB.isBlank()||!sortC.isBlank()) {
                view += " SORT BY ";
            }
            if (!sortA.isBlank()) {
                view += sortA;
                if (!sortB.isBlank()||!sortC.isBlank()) {view += ", ";}
            } else if (!sortB.isBlank()) {
                view += sortB;
                if (!sortC.isBlank()) {view += ", ";}
            } else if (!sortC.isBlank()) {view += sortC;}
            view += ";";
            JFrame fr = new JFrame("CountUp Task Manager");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ViewPanel vw = new ViewPanel(fr, view);
            fr.add(vw);
            fr.pack();
            jf.dispose();
            fr.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SelectPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewAllButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //Must create Select Query
        //Add where clause, using filters
        if ((taskTypeComboBox.getSelectedIndex()+timeframeBox.getSelectedIndex()+
                progressComboBox.getSelectedIndex()+priorityBox.getSelectedIndex() > 0))
        {//START FILTERS
            view += " WHERE ";
            
            if (taskTypeComboBox.getSelectedIndex() > 0) {
                view += "CATEGORY = " + taskTypeComboBox.getSelectedIndex();
            }
            //timeframe
            if (timeframeBox.getSelectedIndex() > 0) {
                if (!view.endsWith(" ")) {view+= ", ";}
                view += "TIMEFRAME = " + timeframeBox.getSelectedIndex();
            }
            //completeness
            if (progressComboBox.getSelectedIndex() > 0) {
                if (!view.endsWith(" ")) {view+= ", ";}
                view += "COMPLETENESS = " + progressComboBox.getSelectedIndex();
            }
            //priority
            if (priorityBox.getSelectedIndex() > 0) {
                if (!view.endsWith(" ")) {view+= ", ";}
                view += "PRIORITY = " + priorityBox.getSelectedIndex();
            }
        }//END FILTERS
        
        //category
        //Add sort clause, using sorts

        //Call View Panel
        view += ";";
        try {
            JFrame fr = new JFrame("CountUp Task Manager");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ViewPanel vw;
            vw = new ViewPanel(fr, view);
            fr.add(vw);
            fr.pack();
            jf.dispose();
            fr.setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(SelectPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void completedComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completedComboBoxActionPerformed

    private void startedComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startedComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startedComboBoxActionPerformed

    private void progressComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_progressComboBoxActionPerformed

    private void verifyTimestampFTF(JFormattedTextField jftf){
        //When focus is lost
        //if text in jftf does not match format
        //reset text to format (YYYY-MM-DD 00:00:00)
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> completedComboBox;
    private javax.swing.JComboBox<String> genreComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> priorityBox;
    private javax.swing.JComboBox<String> progressComboBox;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> startedComboBox;
    private javax.swing.JComboBox<String> taskTypeComboBox;
    private javax.swing.JComboBox<String> timeframeBox;
    private javax.swing.JButton viewAllButton;
    // End of variables declaration//GEN-END:variables
}
