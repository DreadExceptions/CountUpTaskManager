/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        categoryBox = new javax.swing.JComboBox<>();
        timeframeBox = new javax.swing.JComboBox<>();
        completenessBox = new javax.swing.JComboBox<>();
        priorityBox = new javax.swing.JComboBox<>();
        returnButton = new javax.swing.JButton();
        viewAllButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

        jLabel1.setText("Title");

        jLabel2.setText("Category");

        jLabel3.setText("Timeframe");

        jLabel4.setText("Completeness");

        jLabel5.setText("Priority");

        jTextField1.setText("32 Characters Maximum");

        try {
            SqliteJDBC.searchOptions choice = new SqliteJDBC.searchOptions(url);
            String[] options = choice.getReferenceNames("CATEGORY");
            categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(options));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);}

        try {
            SqliteJDBC.searchOptions choice = new SqliteJDBC.searchOptions(url);
            String[] options = choice.getReferenceNames("TIMEFRAME");
            timeframeBox.setModel(new javax.swing.DefaultComboBoxModel<>(options));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);}

        try {
            SqliteJDBC.searchOptions choice = new SqliteJDBC.searchOptions(url);
            String[] options = choice.getReferenceNames("COMPLETENESS");
            completenessBox.setModel(new javax.swing.DefaultComboBoxModel<>(options));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);}

        try {
            SqliteJDBC.searchOptions choice = new SqliteJDBC.searchOptions(url);
            String[] options = choice.getReferenceNames("PRIORITY");
            priorityBox.setModel(new javax.swing.DefaultComboBoxModel<>(options));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);}

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priorityBox, 0, 120, Short.MAX_VALUE)
                            .addComponent(timeframeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(completenessBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewAllButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(timeframeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(completenessBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priorityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(returnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
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
        if ((categoryBox.getSelectedIndex()+timeframeBox.getSelectedIndex()+
                completenessBox.getSelectedIndex()+priorityBox.getSelectedIndex() > 0))
        {//START FILTERS
            view += " WHERE ";
            
            if (categoryBox.getSelectedIndex() > 0) {
                view += "CATEGORY = " + categoryBox.getSelectedIndex();
            }
            //timeframe
            if (timeframeBox.getSelectedIndex() > 0) {
                if (!view.endsWith(" ")) {view+= ", ";}
                view += "TIMEFRAME = " + timeframeBox.getSelectedIndex();
            }
            //completeness
            if (completenessBox.getSelectedIndex() > 0) {
                if (!view.endsWith(" ")) {view+= ", ";}
                view += "COMPLETENESS = " + completenessBox.getSelectedIndex();
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

    private void verifyTimestampFTF(JFormattedTextField jftf){
        //When focus is lost
        //if text in jftf does not match format
        //reset text to format (YYYY-MM-DD 00:00:00)
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JComboBox<String> completenessBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> priorityBox;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> timeframeBox;
    private javax.swing.JButton viewAllButton;
    // End of variables declaration//GEN-END:variables
}
