/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import SqliteJDBC.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    Object [][] dfltSet;
    Task parentTask;
    ArrayList<Task> taskSet;
    String [] col = {"Title", "Priority", "Progress", "Timeframe", "Genre", "Task Type",
        "Created", "Started", "Completed", "Due Date"};
    DefaultTableModel model = new DefaultTableModel(dfltSet, col);

    public ViewPanel(JFrame jfrm, ArrayList<Task> tsks) {
        System.out.println("No Parent");
        this.jf = jfrm;
        this.taskSet = tsks;
        this.defineDfltSet(tsks);
        initComponents();
        this.returnParentButton.setVisible(false);
    }
    
    public ViewPanel(JFrame jfrm, ArrayList<Task> tsks, Task prnt) {
        System.out.println("PARENT: " + prnt);
        this.jf = jfrm;
        this.parentTask = prnt;
        this.taskSet = tsks;
        this.defineDfltSet(tsks);
        initComponents();
    }
    
    private void defineDfltSet(ArrayList<Task> tsks) {
        dfltSet = new Object[tsks.size()][11];
        
        for (int i = 0; i < tsks.size(); i++) {
            String[] task = new String[10];
            task[0] = tsks.get(i).getTitle();
            task[1] = tsks.get(i).getPriority();
            task[2] = tsks.get(i).getProgress();
            task[3] = tsks.get(i).getTimeframe();
            task[4] = tsks.get(i).getGenre();
            task[5] = tsks.get(i).getTaskType();
            task[6] = tsks.get(i).getCreatedDate();
            task[7] = tsks.get(i).getStartedDate();
            task[8] = tsks.get(i).getCompleted();
            task[9] = tsks.get(i).getDueDate();
            dfltSet[i] = task;
        }//end for
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnStartButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(model);
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descArea = new javax.swing.JTextArea();
        search = new javax.swing.JButton();
        viewTask = new javax.swing.JButton();
        returnParentButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        duplicateTask = new javax.swing.JButton();

        returnStartButton.setText("Return");
        returnStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnStartButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            this.dfltSet,
            this.col
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        returnParentButton.setText("Return to Parent");
        returnParentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnParentButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add Task");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        duplicateTask.setText("Duplicate Task");
        duplicateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicateTaskActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(returnStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(returnParentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(viewTask, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(duplicateTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duplicateTask)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnStartButton)
                    .addComponent(search)
                    .addComponent(returnParentButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnStartButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPanel strt = new StartPanel(fr);
        fr.add(strt);
        fr.pack();
        fr.setLocationRelativeTo(null);
        jf.dispose();
        fr.setVisible(true);
    }//GEN-LAST:event_returnStartButtonActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SelectPanel slct = new SelectPanel(fr);
        fr.add(slct);
        fr.pack();
        fr.setLocationRelativeTo(null);
        jf.dispose();
        fr.setVisible(true);
    }//GEN-LAST:event_searchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        descArea.setText(
            Task.retreiveTaskFromList(taskSet, (String) dfltSet[jTable1.getSelectedRow()][0]).getDescription()
                );
    }//GEN-LAST:event_jTable1MouseClicked

    private void viewTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTaskActionPerformed
        if (jTable1.getSelectedRow() > -1){
            JFrame fr = new JFrame("CountUp Task Manager");
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TaskPanel tsk = new TaskPanel(fr, Task.retreiveTaskFromList(taskSet, (String) dfltSet[jTable1.getSelectedRow()][0]));
            fr.add(tsk);
            fr.pack();
            fr.setLocationRelativeTo(null);
            jf.dispose();
            fr.setVisible(true);
        }
    }//GEN-LAST:event_viewTaskActionPerformed

    private void returnParentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnParentButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TaskPanel tsk = new TaskPanel(fr, this.parentTask);
        fr.add(tsk);
        fr.pack();
        fr.setLocationRelativeTo(null);
        jf.dispose();
        fr.setVisible(true);
    }//GEN-LAST:event_returnParentButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int pid = 0;
        AddEditPanel dddt;
        if (this.parentTask != null) {
            pid = this.parentTask.getTaskID();
            dddt = new AddEditPanel(fr, pid,
                this.parentTask.selectChildrenShort());
        } else {
            dddt = new AddEditPanel(fr);
        }
        fr.add(dddt);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        this.jf.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void duplicateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicateTaskActionPerformed
        String dialog = "You will duplicate the selected task as a new task.\n" + 
                "All children tasks of the root will also be duplicated.\n" +
                "Do you wish for the task to be a new root or under the same parent?";
        Object [] options = {"Root", "Same", "Cancel"};
        
        if (jTable1.getSelectedRow() >= 0) {//start if
            int opt = JOptionPane.showOptionDialog(null, dialog, "Confirm", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
                        null, options, options[0]);
            if (0 == opt) {
                Task.retreiveTaskFromList(taskSet, (String) dfltSet[jTable1.getSelectedRow()][0]).duplicateTaskSQL(0);
            } else if (1 == opt) {
                if (this.parentTask != null) {
                    Task.retreiveTaskFromList(taskSet, (String) dfltSet[jTable1.getSelectedRow()][0]).duplicateTaskSQL(this.parentTask.getTaskID());
                } else {
                    Task.retreiveTaskFromList(taskSet, (String) dfltSet[jTable1.getSelectedRow()][0]).duplicateTaskSQL(0);
                }
            }
        }//end if
        
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewPanel vw;
        if (this.parentTask != null) {
            vw = new ViewPanel(fr, this.parentTask.selectChildren(), this.parentTask);
        } else {
            vw = new ViewPanel(fr, Task.selectRootTasks());
        }
        fr.add(vw);
        fr.pack();
        fr.setLocationRelativeTo(null);
        jf.dispose();
        fr.setVisible(true);
        
    }//GEN-LAST:event_duplicateTaskActionPerformed

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
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea descArea;
    private javax.swing.JButton duplicateTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnParentButton;
    private javax.swing.JButton returnStartButton;
    private javax.swing.JButton search;
    private javax.swing.JButton viewTask;
    // End of variables declaration//GEN-END:variables
}
