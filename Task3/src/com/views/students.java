package com.views;
import db.database;
import com.app.DAOStudentsImpl;

import static com.app.Interface.ShowJPanel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.app.DAOStudentsImpl;
import com.exceptions.studentException;
import com.interfaces.DAOStudents;
import com.models.Students;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class students extends javax.swing.JPanel {

    public students() {
        initComponents();
        loadData(tableStudents);
    }
    
    
    public void loadData(JTable studentsTable1){
        try{
            DefaultTableModel studentsTable = new DefaultTableModel();

            DAOStudents DAO = new DAOStudentsImpl();
            
            DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
            model.setRowCount(0);
            model.setColumnCount(0);

            ArrayList<Object> colNames = new ArrayList<>();
            colNames.removeAll(colNames);
            colNames.add("id");
            colNames.add("First Name");
            colNames.add("Last Name");
            colNames.add("Grade");
            colNames.add("RollNumber");

            for(Object column : colNames){
                studentsTable.addColumn(column);
            }
            for(com.models.Students data : DAO.showAll("")){
                studentsTable.addRow(new Object[]{
                    data.getId(),
                    data.getFirstName(),
                    data.getLastName(),
                    data.getGrade(),
                    data.getRollNumber(),
                }); 
            }
            studentsTable1.setModel(studentsTable);
        }catch (Exception e){
            System.out.println(e);
        }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        id_search = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(470, 518));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(470, 518));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Students");

        tableStudents.setBackground(new java.awt.Color(255, 255, 255));
        tableStudents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableStudents.setForeground(new java.awt.Color(102, 102, 102));
        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "First Name", "Last Name", "Grade", "Roll Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableStudents.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableStudents);

        id_search.setBackground(new java.awt.Color(255, 255, 255));
        id_search.setForeground(new java.awt.Color(153, 153, 153));
        id_search.setText("Insert the Id number of the student");
        id_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_searchActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(102, 0, 255));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search Student");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(102, 51, 255));
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("Edit Student");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                            .addComponent(edit)
                            .addGap(18, 18, 18)
                            .addComponent(delete)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(id_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    }//GEN-LAST:event_searchActionPerformed

    private void id_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_searchActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try{   
            DAOStudents DAO = new DAOStudentsImpl();
            if(tableStudents.getSelectedRow() == -1) throw new studentException("Error");
            int id = (int) tableStudents.getValueAt(tableStudents.getSelectedRow(), 0);
            ShowJPanel(new editStudent(DAO.search(id)));      
        } catch (studentException e){
            javax.swing.JOptionPane.showMessageDialog(this, "You have to select one student to edit it.\n", "ERROR", javax.swing.JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DAOStudents DAO = new DAOStudentsImpl();
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        try{
            if(tableStudents.getSelectedRows().length < 1 || tableStudents.getSelectedRow() == -1)throw new studentException("You have to select a user to delete it.");
            for(int i : tableStudents.getSelectedRows()){
                int id = (int)tableStudents.getModel().getValueAt(i, 0);
                DAO.delete(id);
                model.removeRow(i);
                javax.swing.JOptionPane.showMessageDialog(this, "Student has been deleted\n", "ERROR", javax.swing.JOptionPane.OK_OPTION);
            } 
        }catch (studentException e){
            javax.swing.JOptionPane.showMessageDialog(this, "You have to select a user to delete it.\n", "ERROR", javax.swing.JOptionPane.OK_OPTION);
        }catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteActionPerformed

        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField id_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    private javax.swing.JTable tableStudents;
    // End of variables declaration//GEN-END:variables
}
