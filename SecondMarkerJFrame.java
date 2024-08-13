package AGH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Taatheer
 */
public class SecondMarkerJFrame extends javax.swing.JFrame {
    public String smID; 
    public DefaultTableModel model20;
    public DefaultTableModel model21;
    
    public SecondMarkerJFrame(String ID) {
        initComponents();
        smID = ID;
        model20 = (DefaultTableModel)tblPresSM.getModel();
        model21 = (DefaultTableModel)tblSMSup.getModel();
        loadSMPresentation();
        loadSupL();
    }
    private void loadSupL() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            clearTable21();
       
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    
                    
                    String nationality = data[0];
                    String gender = data[1];
                    String intake = data[6];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String name = data[4];
                    String password = data[5];
                    String type = data[7];
                    String assessType = data[8];
                    String supervisor = data[9];
                    String secMarker = data[10];
                    
                    
                    if(secMarker.trim().equals(smID.trim())){
                        model21.addRow(new Object[]{name,id, age, nationality});
                    }             
         
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void clearTable21() {
        model20.setRowCount(0);
    }

    private void loadSMPresentation() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt"))) {
            String line;
            
            clearTable20();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                          
                    String studID = data[0];
                    String date = data[1];
                    String SM = data[2];
                    String SupID = data[3];
                    String SMID = data[4];
                    
                    System.out.println(smID + SMID);
                    
                    if (SMID.trim().equals(smID.trim())){
                        model20.addRow(new Object[]{studID, date,SM});
                        cboStudIDSM.addItem(studID);                      
                    }           
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable20() {
        model20.setRowCount(0);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSMSup = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPresSM = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboStudIDSM = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboStatusSM = new javax.swing.JComboBox<>();
        butViewPresSM = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SECOND MARKER");

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel2.setLayout(null);

        tblSMSup.setBackground(new java.awt.Color(255, 255, 255));
        tblSMSup.setForeground(new java.awt.Color(0, 0, 0));
        tblSMSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Age", "Nationality"
            }
        ));
        jScrollPane2.setViewportView(tblSMSup);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(132, 38, 634, 263);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 890, 460);

        jTabbedPane1.addTab("View Supervisees", jPanel2);

        jPanel3.setLayout(null);

        tblPresSM.setBackground(new java.awt.Color(255, 255, 255));
        tblPresSM.setForeground(new java.awt.Color(0, 0, 0));
        tblPresSM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Date and Time", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblPresSM);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(118, 19, 653, 270);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Student ID:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(277, 303, 80, 20);

        cboStudIDSM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel3.add(cboStudIDSM);
        cboStudIDSM.setBounds(380, 301, 165, 26);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Status:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(307, 353, 50, 20);

        cboStatusSM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Pending", "Agreed", "Reject" }));
        jPanel3.add(cboStatusSM);
        cboStatusSM.setBounds(380, 351, 165, 26);

        butViewPresSM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butViewPresSM.setForeground(new java.awt.Color(255, 255, 255));
        butViewPresSM.setText("Change");
        butViewPresSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewPresSMActionPerformed(evt);
            }
        });
        jPanel3.add(butViewPresSM);
        butViewPresSM.setBounds(380, 395, 98, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.09.41_6623d6a2.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 890, 460);

        jTabbedPane1.addTab("View Presentation", jPanel3);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butViewPresSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewPresSMActionPerformed
        String selectedID = (String) cboStudIDSM.getSelectedItem();
        String selectedStatus = (String) cboStatusSM.getSelectedItem();
        
        List<String> presList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[4].equals(smID)) {
                    
                    if(data[0].equals(selectedID)){
                         data[2] = selectedStatus;
                    }
                }
                presList.add(String.join(",",data));
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
        
        loadSMPresentation();
    }//GEN-LAST:event_butViewPresSMActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                        // Create an instance of LoginMainJFrame
        LoginJFrame loginFrame = new LoginJFrame();

        // Set the new frame visible
        loginFrame.setVisible(true);

        // Dispose of the current frame
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(SecondMarkerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecondMarkerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecondMarkerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecondMarkerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String id = null;
                new SecondMarkerJFrame(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butViewPresSM;
    private javax.swing.JComboBox<String> cboStatusSM;
    private javax.swing.JComboBox<String> cboStudIDSM;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPresSM;
    private javax.swing.JTable tblSMSup;
    // End of variables declaration//GEN-END:variables
}
