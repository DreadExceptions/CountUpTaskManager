/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SqliteJDBC.ViewMultiple;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marquis
 */
public class ViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewTasks
     */
    JFrame jf;
    String slctquery;
    ResultSet selection;
    Object [][] dfltSet = {};
    String [] col = {"Title", "Category", "Completeness", "Priority", "Timeframe", 
        "Created", "Started", "Completed", "Due Date"};
    DefaultTableModel model = new DefaultTableModel(dfltSet, col);
    
    public ViewPanel(JFrame jfrm) throws SQLException {
        this.jf = jfrm;
        this.slctquery = "SELECT * FROM TASKS;";
        //this.selection = ViewMultiple.selectQuery(slctquery);
        this.addResultSetRows(selection);
        initComponents();
    }

    public ViewPanel(JFrame jfrm, String qr) throws SQLException{
        this.jf = jfrm;
        this.slctquery = qr;
        //this.selection = ViewMultiple.selectQuery(slctquery);
        this.addResultSetRows(selection);
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

        returnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(model);
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descArea = new javax.swing.JTextArea();
        detailsButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        search = new javax.swing.JButton();
        viewTask = new javax.swing.JButton();

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        /*
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Category", "Completeness", "Priority", "Timeframe", "Created", "Started", "Completed", "Due Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        */
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Description:");

        descArea.setColumns(20);
        descArea.setRows(5);
        jScrollPane2.setViewportView(descArea);

        detailsButton.setText("View Details");
        detailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit Task");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        search.setText("New Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        viewTask.setText("View Task");
        viewTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(returnButton)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewTask, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detailsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton)
                    .addComponent(search))
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

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SelectPanel slct = new SelectPanel(fr);
        fr.add(slct);
        fr.pack();
        jf.dispose();
        fr.setVisible(true);
    }//GEN-LAST:event_searchActionPerformed

    private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
        try {
            int row = jTable1.getSelectedRow();
            selection.absolute(row);
            String tskID = selection.getString("TASKID");
            String details = "SELECT * FROM DETAIL WHERE TASKID = " + row + " ";
            
            JFrame fr = new JFrame("CountUp Task Manager");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DetailsPanel dtls = new DetailsPanel(fr, details);
            fr.add(dtls);
            fr.pack();
            fr.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_detailsButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EditPanel dt = new EditPanel(fr, this.jf, selection);
        fr.add(dt);
        fr.pack();
        jf.dispose();// should not dispose unless edit is made
        fr.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int row = jTable1.getSelectedRow();
            selection.absolute(row);
            
            descArea.setText(selection.getString("DESCRIPTION"));
        } catch (SQLException ex) {
            Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void viewTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTaskActionPerformed
        try {
            JFrame fr = new JFrame("CountUp Task Manager");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int row = jTable1.getSelectedRow();
            selection.absolute(row);
            TaskPanel dt = new TaskPanel(fr, selection);
            fr.add(dt);
            fr.pack();
            jf.dispose();// should not dispose unless edit is made
            fr.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewTaskActionPerformed

    private void addResultSetRows(ResultSet rs) throws SQLException {
        Object[] newRec = new Object[9];
        while (rs.next()) {
            newRec[0] = rs.getString("TITLE");
            newRec[1] = rs.getString("CATEGORY");
            newRec[2] = rs.getString("COMPLETENESS");
            newRec[3] = rs.getString("PRIORITY");
            newRec[4] = rs.getString("TIMEFRAME");
            newRec[5] = rs.getString("CREATED");
            newRec[6] = rs.getString("STARTED");
            newRec[7] = rs.getString("ENDED");
            newRec[8] = rs.getString("DUEDATE");
            model.addRow(newRec);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descArea;
    private javax.swing.JButton detailsButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton search;
    private javax.swing.JButton viewTask;
    // End of variables declaration//GEN-END:variables
}
