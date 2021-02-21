/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import SqliteJDBC.Task;
import java.sql.ResultSet;
import javax.swing.JFrame;

/**
 *
 * @author marquis
 */
public class TaskPanel extends javax.swing.JPanel {

    /**
     * Creates new form TaskPanel
     */
    JFrame jf;
    Task viewTask;
    ResultSet rs;//delete! only did this so I can compile without fixing code
    public TaskPanel(JFrame jfrm, Task vw) { //hopefully, rsltst will keep it's pointer's position
        this.jf = jfrm;
        this.viewTask = vw;
        initComponents();
        if (viewTask.getStartedDate() == null) {jLabel2.setVisible(false);}
        if (viewTask.getCompleted() == null) {jLabel3.setVisible(false);}
        if (viewTask.getDueDate() == null) {jLabel4.setVisible(false);}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        created = new javax.swing.JLabel();
        started = new javax.swing.JLabel();
        ended = new javax.swing.JLabel();
        dueDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        progress = new javax.swing.JLabel();
        taskType = new javax.swing.JLabel();
        priority = new javax.swing.JLabel();
        timeframe = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        genre = new javax.swing.JLabel();
        markDownButton = new javax.swing.JButton();
        childrenViewButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        Title.setText(viewTask.getTitle());

        Description.setColumns(20);
        Description.setLineWrap(true);
        Description.setRows(5);
        Description.setText(viewTask.getDescription());
        Description.setWrapStyleWord(true);
        jScrollPane2.setViewportView(Description);

        jLabel1.setText("Created:");

        jLabel2.setText("Started:");

        jLabel3.setText("Completed:");

        jLabel4.setText("Due Date:");

        created.setText(viewTask.getCreatedDate());

        started.setText(viewTask.getStartedDate());

        ended.setText(viewTask.getCompleted());

        dueDate.setText(viewTask.getDueDate());

        jLabel5.setText("Progress:");

        jLabel6.setText("Priority:");

        jLabel7.setText("Timeframe:");

        jLabel8.setText("Task Type:");

        progress.setText(viewTask.getProgress());

        taskType.setText(viewTask.getTaskType());

        priority.setText(viewTask.getPriority());

        timeframe.setText(viewTask.getTimeframe());

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Genre:");

        genre.setText(viewTask.getGenre());

        markDownButton.setText("Markdown");
        markDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markDownButtonActionPerformed(evt);
            }
        });

        childrenViewButton.setText("View Sub-Tasks");
        childrenViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childrenViewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(priority, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(created, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(progress, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(timeframe, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(taskType, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(genre, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(markDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(childrenViewButton)
                                .addGap(18, 18, 18)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(started, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ended, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(created))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(started))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ended))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dueDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(priority))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(progress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(timeframe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(taskType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(genre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(childrenViewButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(markDownButton)
                    .addComponent(returnButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AddEditPanel dt = new AddEditPanel(fr, this.viewTask);
        fr.add(dt);
        fr.pack();
        fr.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        JFrame fr = new JFrame ("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (this.viewTask.getParentID() > 0) {
            System.out.println(this.viewTask.getParentID());
            TaskPanel tsk = new TaskPanel(fr, Task.selectTask(this.viewTask.getParentID()));
            fr.add(tsk);
        } else {
            StartPanel strt = new StartPanel(fr);
            fr.add(strt);
        }
        fr.pack();
        fr.setVisible(true);
        this.jf.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void markDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markDownButtonActionPerformed
        this.viewTask.taskToMarkDown();
    }//GEN-LAST:event_markDownButtonActionPerformed

    private void childrenViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childrenViewButtonActionPerformed
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewPanel vw = new ViewPanel(fr, viewTask.selectChildren(), viewTask);
        fr.add(vw);
        fr.pack();
        fr.setVisible(true);
        this.jf.dispose();
    }//GEN-LAST:event_childrenViewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Description;
    private javax.swing.JLabel Title;
    private javax.swing.JButton childrenViewButton;
    private javax.swing.JLabel created;
    private javax.swing.JLabel dueDate;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel ended;
    private javax.swing.JLabel genre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton markDownButton;
    private javax.swing.JLabel priority;
    private javax.swing.JLabel progress;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel started;
    private javax.swing.JLabel taskType;
    private javax.swing.JLabel timeframe;
    // End of variables declaration//GEN-END:variables
}
