
package AGH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Taatheer
 */
public class LecturerJFrame extends javax.swing.JFrame {
    private String lecturerID;
    public DefaultTableModel model13;
    public DefaultTableModel model14;
    public DefaultTableModel model15;
    public DefaultTableModel model16;
    public DefaultTableModel model17;
    public DefaultTableModel model19;
    
    public LecturerJFrame(String ID) throws IOException {
        
        initComponents();
        
        lecturerID = ID;
        
        model13 = (DefaultTableModel)tblIntSup.getModel();
        model14 = (DefaultTableModel)tblIndSup.getModel();
        model15 = (DefaultTableModel)tblAssessSup.getModel();
        model16 = (DefaultTableModel)tblRepMark.getModel();
        model17 = (DefaultTableModel)tblViewRep.getModel();
        model19 = (DefaultTableModel)tblSecMark.getModel();
        
        loadIntakeLSupFromFile(ID);
        loadAssLSupFromFile(ID);
        loadIndLSupFromFile(ID);
        loadRepFromFile();
        loadSecMarkPres();
        
    }
    
    
    private void loadIntakeLSupFromFile(String LecID) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            
            clearTable13();
                  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    
                    String studID = data[2];
                    String intake = data[3];
                    String Supervisor = data[8];
                    String thedate = data[5];
                    
                    String status;
                    status = data[7];
                    
                    System.out.println(LecID + Supervisor);
                    
                    if (LecID.equals(Supervisor)){
                        model13.addRow(new Object[]{intake, studID,status, thedate});
                        boolean itemExists = false;
                        for (int i = 0; i < cboIntSup.getItemCount(); i++) {
                            if (cboIntSup.getItemAt(i).equals(intake)) {
                                itemExists = true;
                                break;
                            }
                        }
                        if (itemExists == false){cboIntSup.addItem(intake);}
                    }           
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void clearTable13() {
        model13.setRowCount(0);
    }

    private void clearTable14() {
        model14.setRowCount(0);
    }
    private void loadIndLSupFromFile(String LecID) {
        
        cboStudSup.removeAllItems();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            
            clearTable14();
            
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    
                    String studID = data[2];
                    String name = data[1];
                    String thedate = data[5];
                    String Supervisor = data[8];
                    String sm = data[9];
                    
                    String status;
                    status = data[7];
                    
                    if (LecID.equals(Supervisor)){
                        model14.addRow(new Object[]{studID,name, status, thedate});
  
                        cboStudSup.addItem(studID);
                    }           
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void clearTable15() {
        model15.setRowCount(0);
    }
    
    private void loadAssLSupFromFile(String LecID) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            
            clearTable15();
                  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    
                    String studID = data[2];
                    String intake = data[3];
                    String thedate = data[5];
                    String assessType = data[4];
                    String Supervisor = data[8];
                    
                    String status;
                    status = data[7];
                    
                    if (LecID.equals(Supervisor)){
                        model15.addRow(new Object[]{assessType, studID,status, thedate});
                        boolean itemExists = false;
                        for (int i = 0; i < cboAssSup.getItemCount(); i++) {
                            if (cboAssSup.getItemAt(i).equals(intake)) {
                                itemExists = true;
                                break;
                            }
                        }
                        if (itemExists == false){cboAssSup.addItem(intake);}
                    }           
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void loadRepFromFile() throws IOException {
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            
            clearTable16();
                  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    String RepID = data[0];
                    String studID = data[2];
                    
                    String status;
                    status = data[7];
                    

                    model16.addRow(new Object[]{RepID, studID,status});
                    
                    cboRepID.addItem(data[0]);                          
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void clearTable16() {
        model16.setRowCount(0);
    }
    
    
    private void loadViewRepStatus(String sstatus) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            
            String line;
            
            clearTable17();
                  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    String RepID = data[0];
                    String studID = data[2];
                    
                    String status;
                    status = data[7];
                    
                    if (sstatus.equals(status)){
                        model17.addRow(new Object[]{RepID, studID,status});
                    }
                    
                    
                    cboRepID.addItem(data[0]);                          
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    private void clearTable17() {
        model17.setRowCount(0);
    }
    
    
    private void loadSecMarkPres() throws IOException {
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt"))) {
            String line;
            
            clearTable19();
                  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    
                    String studID= data[0];
                    String date = data[1];
                    String SMs = data[2];
                    String lecID = data[3];
                    String SM = data[4];
                    
                    if (lecID.equals(lecturerID)){
                        model19.addRow(new Object[]{studID, date,SMs});
                    }                
            
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void clearTable19() {
        model19.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIndSup = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cboStudSup = new javax.swing.JComboBox<>();
        butViewInd = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIntSup = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cboIntSup = new javax.swing.JComboBox<>();
        butViewInt = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAssessSup = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboAssSup = new javax.swing.JComboBox<>();
        butViewAss = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSecMark = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRepMark = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cboRepID = new javax.swing.JComboBox<>();
        butMark = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblViewRep = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        butViewRep = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SUPERVISOR");

        jButton2.setText("Log out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel6.setLayout(null);

        tblIndSup.setBackground(new java.awt.Color(255, 255, 255));
        tblIndSup.setForeground(new java.awt.Color(0, 0, 0));
        tblIndSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblIndSup);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(150, 33, 598, 267);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Student ID:");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(310, 330, 80, 20);

        cboStudSup.setBackground(new java.awt.Color(255, 255, 255));
        cboStudSup.setForeground(new java.awt.Color(0, 0, 0));
        cboStudSup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel6.add(cboStudSup);
        cboStudSup.setBounds(410, 330, 167, 26);

        butViewInd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butViewInd.setForeground(new java.awt.Color(255, 255, 255));
        butViewInd.setText("View");
        butViewInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewIndActionPerformed(evt);
            }
        });
        jPanel6.add(butViewInd);
        butViewInd.setBounds(394, 403, 89, 39);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(0, 0, 890, 470);

        jTabbedPane2.addTab("Individual", jPanel6);

        jPanel7.setLayout(null);

        tblIntSup.setBackground(new java.awt.Color(255, 255, 255));
        tblIntSup.setForeground(new java.awt.Color(0, 0, 0));
        tblIntSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Intake", "Student ID", "Status"
            }
        ));
        jScrollPane2.setViewportView(tblIntSup);

        jPanel7.add(jScrollPane2);
        jScrollPane2.setBounds(153, 34, 577, 256);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Intake:");
        jPanel7.add(jLabel3);
        jLabel3.setBounds(310, 320, 50, 30);

        cboIntSup.setBackground(new java.awt.Color(255, 255, 255));
        cboIntSup.setForeground(new java.awt.Color(0, 0, 0));
        cboIntSup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel7.add(cboIntSup);
        cboIntSup.setBounds(370, 320, 179, 26);

        butViewInt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butViewInt.setText("View");
        butViewInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewIntActionPerformed(evt);
            }
        });
        jPanel7.add(butViewInt);
        butViewInt.setBounds(391, 405, 87, 35);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel7.add(jLabel11);
        jLabel11.setBounds(0, 0, 890, 470);

        jTabbedPane2.addTab("Intake", jPanel7);

        jPanel8.setLayout(null);

        tblAssessSup.setBackground(new java.awt.Color(255, 255, 255));
        tblAssessSup.setForeground(new java.awt.Color(0, 0, 0));
        tblAssessSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assessment Type", "Student ID", "Status"
            }
        ));
        jScrollPane3.setViewportView(tblAssessSup);

        jPanel8.add(jScrollPane3);
        jScrollPane3.setBounds(146, 41, 582, 242);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Assessment Type:");
        jPanel8.add(jLabel2);
        jLabel2.setBounds(280, 310, 117, 20);

        cboAssSup.setBackground(new java.awt.Color(255, 255, 255));
        cboAssSup.setForeground(new java.awt.Color(0, 0, 0));
        cboAssSup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel8.add(cboAssSup);
        cboAssSup.setBounds(410, 310, 177, 26);

        butViewAss.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butViewAss.setText("View");
        butViewAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewAssActionPerformed(evt);
            }
        });
        jPanel8.add(butViewAss);
        butViewAss.setBounds(378, 398, 95, 37);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel8.add(jLabel13);
        jLabel13.setBounds(0, 0, 890, 470);

        jTabbedPane2.addTab("Assessment", jPanel8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Dashboard", jPanel2);

        jPanel3.setLayout(null);

        tblSecMark.setBackground(new java.awt.Color(255, 255, 255));
        tblSecMark.setForeground(new java.awt.Color(0, 0, 0));
        tblSecMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student ID", "Date and Time", "Second Marker Status"
            }
        ));
        jScrollPane6.setViewportView(tblSecMark);

        jPanel3.add(jScrollPane6);
        jScrollPane6.setBounds(113, 31, 665, 290);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(384, 371, 101, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Taatheer\\Downloads\\WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg")); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(0, 0, 890, 510);

        jTabbedPane1.addTab("View Second Marker Acceptance", jPanel3);

        jPanel5.setLayout(null);

        tblRepMark.setBackground(new java.awt.Color(255, 255, 255));
        tblRepMark.setForeground(new java.awt.Color(0, 0, 0));
        tblRepMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Report ID", "Student ID", "Status"
            }
        ));
        jScrollPane4.setViewportView(tblRepMark);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(122, 40, 639, 251);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Report ID:");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(304, 349, 68, 20);

        cboRepID.setBackground(new java.awt.Color(255, 255, 255));
        cboRepID.setForeground(new java.awt.Color(0, 0, 0));
        cboRepID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel5.add(cboRepID);
        cboRepID.setBounds(390, 347, 177, 26);

        butMark.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butMark.setText("Mark");
        butMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMarkActionPerformed(evt);
            }
        });
        jPanel5.add(butMark);
        butMark.setBounds(365, 434, 98, 37);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(0, 0, 890, 510);

        jTabbedPane1.addTab("Evaluate Report", jPanel5);

        jPanel9.setLayout(null);

        tblViewRep.setBackground(new java.awt.Color(255, 255, 255));
        tblViewRep.setForeground(new java.awt.Color(0, 0, 0));
        tblViewRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Report ID", "Student ID", "Status"
            }
        ));
        jScrollPane5.setViewportView(tblViewRep);

        jPanel9.add(jScrollPane5);
        jScrollPane5.setBounds(108, 43, 678, 254);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Status:");
        jPanel9.add(jLabel9);
        jLabel9.setBounds(319, 342, 60, 20);

        cboStatus.setBackground(new java.awt.Color(255, 255, 255));
        cboStatus.setForeground(new java.awt.Color(0, 0, 0));
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Marked" }));
        jPanel9.add(cboStatus);
        cboStatus.setBounds(393, 340, 171, 26);

        butViewRep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butViewRep.setForeground(new java.awt.Color(255, 255, 255));
        butViewRep.setText("View");
        butViewRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewRepActionPerformed(evt);
            }
        });
        jPanel9.add(butViewRep);
        butViewRep.setBounds(370, 422, 100, 42);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        jPanel9.add(jLabel15);
        jLabel15.setBounds(0, 0, 890, 510);

        jTabbedPane1.addTab("View Report", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butViewAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewAssActionPerformed
        loadAssLSupFromFile(lecturerID);
    }//GEN-LAST:event_butViewAssActionPerformed

    private void butViewIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewIntActionPerformed
        loadIntakeLSupFromFile(lecturerID);
    }//GEN-LAST:event_butViewIntActionPerformed

    private void butViewIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewIndActionPerformed
        loadIndLSupFromFile(lecturerID);
    }//GEN-LAST:event_butViewIndActionPerformed

    private void butMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMarkActionPerformed
        String selectedRepID = (String) cboRepID.getSelectedItem();

        List<String> ReportsList = new ArrayList<>();
        List<String> presList = new ArrayList<>();
        
        
        boolean repUpdated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[0].equals(selectedRepID)) {
                                                          
                    data[7] = "Marked";
                    repUpdated = true;
                    
                }
                ReportsList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[0].equals(selectedRepID)) {
                                                          
                    data[2] = "Marked";
                    repUpdated = true;
                    
                }
                presList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (repUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
                for (String line : ReportsList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt"))) {
                for (String line : presList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
        
        if (repUpdated) {
            JOptionPane.showMessageDialog(this, "Report marked successfully.");

        } else {
            JOptionPane.showMessageDialog(this, "Report not found or no changes made.");
        }
        
        try {
            loadRepFromFile();
        } catch (IOException ex) {
            Logger.getLogger(LecturerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butMarkActionPerformed

    private void butViewRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewRepActionPerformed
        
        String selectedStatus = (String)cboStatus.getSelectedItem();

        try {
            loadViewRepStatus(selectedStatus);
        } catch (IOException ex) {
            Logger.getLogger(LecturerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_butViewRepActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Create an instance of LoginMainJFrame
        LoginJFrame loginFrame = new LoginJFrame();

        // Set the new frame visible
        loginFrame.setVisible(true);

        // Dispose of the current frame
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            loadSecMarkPres();
        } catch (IOException ex) {
            Logger.getLogger(LecturerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String ID = null;
                try {
                    new LecturerJFrame(ID).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(LecturerJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butMark;
    private javax.swing.JButton butViewAss;
    private javax.swing.JButton butViewInd;
    private javax.swing.JButton butViewInt;
    private javax.swing.JButton butViewRep;
    private javax.swing.JComboBox<String> cboAssSup;
    private javax.swing.JComboBox<String> cboIntSup;
    private javax.swing.JComboBox<String> cboRepID;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cboStudSup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblAssessSup;
    private javax.swing.JTable tblIndSup;
    private javax.swing.JTable tblIntSup;
    private javax.swing.JTable tblRepMark;
    private javax.swing.JTable tblSecMark;
    private javax.swing.JTable tblViewRep;
    // End of variables declaration//GEN-END:variables
}
