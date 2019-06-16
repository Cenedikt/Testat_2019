/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import java.time.LocalDate;
import javax.swing.*;
/**
 *
 * @author Benedict
 */
public class CreateInstructorFrame extends javax.swing.JFrame {
    
    private String name;
    private String prename;
    private String speficication="";
    private String sex="";
    private String workrelation;
    private LocalDate birthdate;
    /**
     * Creates new form createInstructor
     */
    public CreateInstructorFrame() 
    {
        initComponents();
        workrealtionButtonGroup.add(externRadioButton);
        workrealtionButtonGroup.add(internRadioButton);
        sexButtonGroup.add(maleRadioButton1);
        sexButtonGroup.add(femaleRadioButton);
        sexButtonGroup.add(diversRadioButton);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexButtonGroup = new javax.swing.ButtonGroup();
        workrealtionButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        maleRadioButton1 = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        diversRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        externRadioButton = new javax.swing.JRadioButton();
        internRadioButton = new javax.swing.JRadioButton();
        createButton = new javax.swing.JButton();
        cancleButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        spesificationTextField = new javax.swing.JTextField();
        birthdateTextField = new javax.swing.JTextField();
        prenameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        coursIdScrollPane = new javax.swing.JScrollPane();
        coursIDTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creat Instructor");

        jLabel2.setText("Name:");

        jLabel3.setText("Prename:");

        jLabel4.setText("Birthdate:");

        jLabel5.setText("Spesification:");

        jLabel6.setText("Sex:");

        maleRadioButton1.setText("Male");
        maleRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButton1ActionPerformed(evt);
            }
        });

        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        diversRadioButton.setText("Divers");
        diversRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diversRadioButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Workrelation:");

        externRadioButton.setText("Extern");
        externRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externRadioButtonActionPerformed(evt);
            }
        });

        internRadioButton.setText("Intern");
        internRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internRadioButtonActionPerformed(evt);
            }
        });

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        cancleButton.setText("cancle");
        cancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("CoursID:");

        birthdateTextField.setText("JJJJ-MM-DD");

        coursIDTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        coursIdScrollPane.setViewportView(coursIDTable);
        if (coursIDTable.getColumnModel().getColumnCount() > 0) {
            coursIDTable.getColumnModel().getColumn(0).setHeaderValue("ID");
            coursIDTable.getColumnModel().getColumn(1).setHeaderValue("Name");
        }
        //coursData.getCoursForInstructor();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spesificationTextField)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(createButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancleButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(externRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(internRadioButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(maleRadioButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(femaleRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(diversRadioButton)))
                                .addGap(0, 38, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prenameTextField)
                                    .addComponent(birthdateTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(nameTextField)))
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(coursIdScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spesificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleRadioButton1)
                    .addComponent(femaleRadioButton)
                    .addComponent(diversRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(externRadioButton)
                    .addComponent(internRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coursIdScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(cancleButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maleRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButton1ActionPerformed
        // TODO add your handling code here:
        sex="Male";
    }//GEN-LAST:event_maleRadioButton1ActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
        sex="Female";
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void diversRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diversRadioButtonActionPerformed
        // TODO add your handling code here:
        sex="Divers";
    }//GEN-LAST:event_diversRadioButtonActionPerformed

    private void externRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_externRadioButtonActionPerformed
        // TODO add your handling code here:
        workrelation="Extern";
    }//GEN-LAST:event_externRadioButtonActionPerformed

    private void internRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internRadioButtonActionPerformed
        // TODO add your handling code here:
        workrelation="Intern";
    }//GEN-LAST:event_internRadioButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        boolean error=false;
        name=nameTextField.getText();
        prename=prenameTextField.getText();
        speficication=spesificationTextField.getText();
        int[] selectedRows = Gui.CreateInstructorFrame.coursIDTable.getSelectedRows();
        if(selectedRows.length == 0)
        {
            error = true;
            JOptionPane.showMessageDialog(new JFrame(), "Please select a course, if there are none please create some in the course menu", "Error",JOptionPane.ERROR_MESSAGE);
        }
        if(name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "The instructor has no name ");
            error=true;
        }
        
        if(prename.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "The instructor has no prename ");
            error=true;
        }
        if(speficication.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "The instructor has no spesification "); 
            error=true;
        }
        if(sex.equals(""))
        {
           JOptionPane.showMessageDialog(null, "The instructor has no sex ");
           error=true;
        }
        if(workrelation.equals(""))
        {
            JOptionPane.showMessageDialog(null, "The instructor has no workrelation ");
            error=true;
        }
        try
        {
          birthdate=LocalDate.parse(birthdateTextField.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "The birthdate is inncorect");
            error=true;
        }
        if(error==false)
        {
            if (selectedRows.length > 0) 
            {
//                instructorData.setInstructor(name, prename, birthdate, sex, speficication, workrelation);
                for (int i = selectedRows.length - 1; i >= 0; i--) 
                {              
                    String idString = (CreateInstructorFrame.coursIDTable.getValueAt(selectedRows[i], 0).toString());
                    int id = Integer.valueOf(idString);
//                    index = instructorData.getLastInstructorID();
//                    instructorData.setInstructorCourseId(index, id);                            
                }
            }
            dispose();
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void cancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();    
    }//GEN-LAST:event_cancleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birthdateTextField;
    private javax.swing.JButton cancleButton;
    public static javax.swing.JTable coursIDTable;
    private javax.swing.JScrollPane coursIdScrollPane;
    private javax.swing.JButton createButton;
    private javax.swing.JRadioButton diversRadioButton;
    private javax.swing.JRadioButton externRadioButton;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JRadioButton internRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton maleRadioButton1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField prenameTextField;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.JTextField spesificationTextField;
    private javax.swing.ButtonGroup workrealtionButtonGroup;
    // End of variables declaration//GEN-END:variables
}
