
package AGH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
public class StudentMainJFRame extends javax.swing.JFrame {
    public String studentID;
    public String supID;
    public String smID;
    
    public static final String filePathRep = "C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt";
    public DefaultTableModel model18;
    
    public StudentMainJFRame(String ID) {
        studentID = ID;
        
        
        initComponents();
        model18 = (DefaultTableModel)tblViewRep1.getModel();
        loadDateTime();
        presLocalTime();
        loadViewRepStatus();
        
        cboStudIDPres.addItem(studentID);
        
    }
    
    
    
    private void loadViewRepStatus() {
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            
            clearTable18();
                  
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    String RepID = data[0];
                    String studID = data[2];
                    String name = data[1];
                    String status;
                    status = data[7];
                    supID = data[8];
                    smID = data[9];
                    
                    if (studID.equals(studentID)){
                        model18.addRow(new Object[]{studID, name, RepID, status});
                    }                                                         
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void clearTable18() {
        model18.setRowCount(0);
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cboDatePres = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboStudIDPres = new javax.swing.JComboBox<>();
        butRequest = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewRep1 = new javax.swing.JTable();
        butViewRep1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboDateNow = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtMoodleL = new javax.swing.JTextField();
        butSubmitRep = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        studIDRep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("STUDENT");

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
                .addGap(388, 388, 388)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Student ID:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(290, 120, 80, 20);

        cboDatePres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel3.add(cboDatePres);
        cboDatePres.setBounds(388, 173, 177, 26);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Presentation Date:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(247, 176, 122, 20);

        cboStudIDPres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel3.add(cboStudIDPres);
        cboStudIDPres.setBounds(388, 118, 177, 26);

        butRequest.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butRequest.setForeground(new java.awt.Color(255, 255, 255));
        butRequest.setText("Request");
        butRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRequestActionPerformed(evt);
            }
        });
        jPanel3.add(butRequest);
        butRequest.setBounds(388, 322, 102, 38);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(0, 0, 890, 490);

        jTabbedPane1.addTab("Request Presentation", jPanel3);

        jPanel4.setLayout(null);

        tblViewRep1.setBackground(new java.awt.Color(255, 255, 255));
        tblViewRep1.setForeground(new java.awt.Color(0, 0, 0));
        tblViewRep1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Report ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblViewRep1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(156, 58, 564, 277);

        butViewRep1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butViewRep1.setForeground(new java.awt.Color(0, 0, 0));
        butViewRep1.setText("View");
        butViewRep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewRep1ActionPerformed(evt);
            }
        });
        jPanel4.add(butViewRep1);
        butViewRep1.setBounds(388, 387, 91, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(0, 0, 890, 490);

        jTabbedPane1.addTab("Check Results", jPanel4);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Moodle Link:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(238, 204, 86, 20);

        cboDateNow.setBackground(new java.awt.Color(255, 255, 255));
        cboDateNow.setForeground(new java.awt.Color(0, 0, 0));
        cboDateNow.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cboDateNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDateNowActionPerformed(evt);
            }
        });
        jPanel2.add(cboDateNow);
        cboDateNow.setBounds(350, 130, 190, 26);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Date:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(287, 136, 37, 20);

        txtMoodleL.setBackground(new java.awt.Color(255, 255, 255));
        txtMoodleL.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtMoodleL);
        txtMoodleL.setBounds(350, 200, 188, 26);

        butSubmitRep.setBackground(new java.awt.Color(153, 153, 153));
        butSubmitRep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butSubmitRep.setForeground(new java.awt.Color(0, 0, 0));
        butSubmitRep.setText("Submit");
        butSubmitRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSubmitRepActionPerformed(evt);
            }
        });
        jPanel2.add(butSubmitRep);
        butSubmitRep.setBounds(394, 366, 108, 39);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Student ID:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(250, 80, 80, 20);

        studIDRep.setBackground(new java.awt.Color(255, 255, 255));
        studIDRep.setForeground(new java.awt.Color(0, 0, 0));
        studIDRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studIDRepActionPerformed(evt);
            }
        });
        jPanel2.add(studIDRep);
        studIDRep.setBounds(350, 80, 190, 26);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 0, 890, 510);

        jTabbedPane1.addTab("Submit Report", jPanel2);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butSubmitRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSubmitRepActionPerformed
        String studentID = studIDRep.getText().trim();
        List<String> theRepList = new ArrayList<>();
        

        try (BufferedReader br = new BufferedReader(new FileReader(filePathRep))) {
            String line;
            
            // Parse the date string into a Date object using SimpleDateFormat
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); // Modify the pattern as per your date format
            

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    
                     
                    String studID = data[2];
                    String studName = data[1];
                    String intake = data[3];
                    String assessType = data[4];
                    String subDate = data[5];
                    String moodleLink = data[6];
                    String status = data[7];
                    String sup = data[8];
                    String sm = data[9];
                    
                    Date subDateStr = null;
                    
                    System.out.println(studID + studentID);
                    
                    if(studID.trim().equals(studentID.trim())){
                        //System.out.println("Y");
                        subDate = (String) cboDateNow.getSelectedItem();
                        moodleLink = txtMoodleL.getText();

                        status = "Pending";
                       
                        data[5] = subDate;
                        data[6] = moodleLink;
                        data[7] = status;
                        
                    }
                    subDateStr = dateFormat.parse(subDate);
                    
                    Report R2 = new Report(null, studID, studName, intake, assessType,subDateStr, moodleLink,status, sup, sm);
                    data[0] = R2.setReportID();                    
                    
                    theRepList.add(String.join(",",data));
                
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(StudentMainJFRame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathRep))) {
                for (String line : theRepList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        JOptionPane.showMessageDialog(this, "Report has been successfully submitted");
        
    }//GEN-LAST:event_butSubmitRepActionPerformed

    private void cboDateNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDateNowActionPerformed

    }//GEN-LAST:event_cboDateNowActionPerformed

    private void studIDRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studIDRepActionPerformed

    }//GEN-LAST:event_studIDRepActionPerformed

    private void butRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRequestActionPerformed
        String selectedDate = (String) cboDatePres.getSelectedItem();
        String selectedStudID = (String) cboStudIDPres.getSelectedItem();
        
        System.out.println(smID);
        String reportLine = selectedStudID + "," + selectedDate + ",None," + supID + "," + smID;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Appending the new report line to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Presentations.txt", true))) {
            writer.write(reportLine);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_butRequestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
                                // Create an instance of LoginMainJFrame
        LoginJFrame loginFrame = new LoginJFrame();

        // Set the new frame visible
        loginFrame.setVisible(true);

        // Dispose of the current frame
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butViewRep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewRep1ActionPerformed
        loadViewRepStatus();

    }//GEN-LAST:event_butViewRep1ActionPerformed
    
      
    
    public String searchAndAddAssessmentType(String studentID) {
        
        String assessmentType = getAssessmentTypeForStudentID(studentID);

        if (assessmentType != null) {
            return assessmentType;
        } else {
            System.out.println("No assessment type found for student ID: " + studentID);
            return null;
        }
    }

    public String getAssessmentTypeForStudentID(String studentID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Reports.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 4 && parts[2].trim().equals(studentID)) {
                    return parts[4]; // Assuming the assessment type is the 5th element
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private void loadDateTime(){
        // Get the current date and time
        Date now = new Date();

        // Define a formatter to customize the date-time format
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        // Convert the current date and time to a string using the formatter
        String nowString = formatter.format(now);

        // Add the formatted date-time string to the combo box
        cboDateNow.addItem(nowString);
    }
    
    public void presLocalTime() {
        // Get the current date and time

        LocalDateTime now = LocalDateTime.now();

        // Add 10 hours to the current date and time
        LocalDateTime futureDateTime = now.plusHours(10);

        // Define the formatter to display the date, time, and day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

        // Add date-time values to the combo box at one-hour intervals within the daytime range
        for (int i = 0; i < 24; i++) {
            futureDateTime = ensureDaytimeHours(futureDateTime);
            ZonedDateTime futureZonedDateTime = futureDateTime.atZone(ZoneId.systemDefault());
            String formattedDateTime = futureZonedDateTime.format(formatter);
            cboDatePres.addItem(formattedDateTime);

            // Print the formatted date-time for demonstration purposes
            System.out.println(formattedDateTime);

            // Increment the time by one hour
            futureDateTime = futureDateTime.plusHours(1);
        }
    }

    private static LocalDateTime ensureDaytimeHours(LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        LocalDateTime adjustedDateTime = dateTime;

        // Define the start and end of daytime hours
        int startOfDaytime = 8; // 8 AM
        int endOfDaytime = 20; // 8 PM

        // Check if the time is before 8 AM
        if (hour < startOfDaytime) {
            // Adjust to 8 AM
            adjustedDateTime = dateTime.truncatedTo(ChronoUnit.DAYS).plusHours(startOfDaytime);
        }
        // Check if the time is after 8 PM
        else if (hour >= endOfDaytime) {
            // Adjust to 8 AM the next day
            adjustedDateTime = dateTime.truncatedTo(ChronoUnit.DAYS).plusDays(1).plusHours(startOfDaytime);
        }

        return adjustedDateTime;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentMainJFRame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentMainJFRame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentMainJFRame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentMainJFRame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String ID = null;
                new StudentMainJFRame(ID).setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butRequest;
    private javax.swing.JButton butSubmitRep;
    private javax.swing.JButton butViewRep1;
    private javax.swing.JComboBox<String> cboDateNow;
    private javax.swing.JComboBox<String> cboDatePres;
    private javax.swing.JComboBox<String> cboStudIDPres;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField studIDRep;
    private javax.swing.JTable tblViewRep1;
    private javax.swing.JTextField txtMoodleL;
    // End of variables declaration//GEN-END:variables
}
