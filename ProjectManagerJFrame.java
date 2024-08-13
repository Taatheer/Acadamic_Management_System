package AGH;

/**
 *
 * @author Taatheer
 */

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProjectManagerJFrame extends javax.swing.JFrame {

    public DefaultTableModel model5;
    public DefaultTableModel model6;
    public DefaultTableModel model7;
    public DefaultTableModel model8;
    public DefaultTableModel model9;
    public DefaultTableModel model10;
    public DefaultTableModel model11;
    public DefaultTableModel model12;
    public ArrayList<Lecturer> theSupLecList = new ArrayList<Lecturer>();
    
    public ProjectManagerJFrame() {
        initComponents();
        model5 = (DefaultTableModel)tblPMIntake.getModel();
        model6 = (DefaultTableModel)tblIndividualStud.getModel();
        model7 = (DefaultTableModel)tblAssSup.getModel();
        model8 = (DefaultTableModel)tblSupLecturers.getModel();
        model9 = (DefaultTableModel)tblSupIntake.getModel();
        model10 = (DefaultTableModel)tblStudSup.getModel();
        model11 = (DefaultTableModel)tblIntakeRep.getModel();
        model12 = (DefaultTableModel)tblStudRep.getModel();
        
        
        loadIndStudFromFile();
        loadIntakeFromFile();
        loadSupLecturersFromFile();
        loadAssSupFromFile();
        loadIntakeSupFromFile();
        loadStudSupFromFile();
        loadIntakeRepFromFile();
        loadStudRepFromFile();
        
    }
    private void loadIntakeFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            clearTable5();
            cboIntakeChoice.removeAllItems();
            cboAsType.removeAllItems();
            cboIntakeChoice.addItem("None");
            cboAsType.addItem("None");
            cboAsType.addItem("Internship");
            cboAsType.addItem("Investigation Reports");
            cboAsType.addItem("CP1"); 
            cboAsType.addItem("CP2");
            cboAsType.addItem("RMCP");
            cboAsType.addItem("FYP");
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String intake = data[1];
                    String id = data[0];
                    String assessType = data[2];
                    
                    model5.addRow(new Object[]{intake, id, assessType});
                    
                    boolean itemExists = false;
                    for (int i = 0; i < cboIntakeChoice.getItemCount(); i++) {
                        if (cboIntakeChoice.getItemAt(i).equals(intake)) {
                            itemExists = true;
                            break;
                        }
                    }
                    if (itemExists == false){cboIntakeChoice.addItem(intake);}
                 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable5() {
        model5.setRowCount(0);
    }
    private void loadIndStudFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            clearTable6();
            cboIndStud.removeAllItems();
            cboAssType.removeAllItems();
            cboIndStud.addItem("None");
            cboAssType.addItem("None");
            cboAssType.addItem("Internship");
            cboAssType.addItem("Investigation Reports");
            cboAssType.addItem("CP1"); 
            cboAssType.addItem("CP2");
            cboAssType.addItem("RMCP");
            cboAssType.addItem("FYP");
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    String intake = data[6];
                    String id = data[3];
                    String name = data[4];
                    String assessType = data[8];
                    
                    model6.addRow(new Object[]{id, name ,intake,assessType});
                    
                    
                    cboIndStud.addItem(id);
                 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable6() {
        model6.setRowCount(0);
    }
    
    
    private void loadSupLecturersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            clearTable8();
            cboLecIDChoice1.removeAllItems();
            cboLecIDChoice1.addItem("None");
            cboLecIDChoice2.removeAllItems();
            cboLecIDChoice2.addItem("None");
            cboLecIDChoice3.removeAllItems();
            cboLecIDChoice3.addItem("None");
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    String nationality = data[0];
                    String gender = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String name = data[4];
                    String password = data[5];
                    String type = data[6];
                    boolean PM = Boolean.parseBoolean(data[7]);
                    boolean Sup = Boolean.parseBoolean(data[8]);
                    boolean SM = Boolean.parseBoolean(data[9]);
                    
                    Lecturer L2 = new Lecturer(nationality, gender, age, id, name, password,type,PM, Sup, SM);
                    theSupLecList.add(L2);
                    model8.addRow(new Object[]{name, id, Sup, SM});
                    
                    cboLecIDChoice1.addItem(id);
                    cboLecIDChoice2.addItem(id);
                    cboLecIDChoice3.addItem(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable8() {
        model8.setRowCount(0);
    }
    
    private void loadAssSupFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            clearTable7();
            cboAssign1.removeAllItems();
            cboAsType1.removeAllItems();
            cboAssign1.addItem("None");

            cboAsType1.addItem("None");
            
            
            cboAssign1.addItem("Supervisor");
            
            
            cboAssign1.addItem("Second Marker");
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String intake = data[1];
                    String id = data[0];
                    String assessType = data[2];
                    String sup = data[3];
                    String SM = data[4];
                    
                    model7.addRow(new Object[]{assessType, id, sup, SM});
                    
                    boolean itemExists = false;
                    for (int i = 0; i < cboAsType1.getItemCount(); i++) {
                        if (cboAsType1.getItemAt(i).equals(assessType)) {
                            itemExists = true;
                            break;
                        }
                    }
                    if (itemExists == false){cboAsType1.addItem(assessType);}
                    
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable7() {
        model7.setRowCount(0);
    }
    
    private void loadIntakeSupFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            clearTable9();
            cboIntakeChoice1.removeAllItems();
            cboAsType.removeAllItems();
            cboAssign2.removeAllItems();
            cboIntakeChoice1.addItem("None");
            cboAssign2.addItem("None");
            cboAssign2.addItem("Supervisor");
            cboAssign2.addItem("Second Marker");
            cboAsType.addItem("None");
            cboAsType.addItem("Internship");
            cboAsType.addItem("Investigation Reports");
            cboAsType.addItem("CP1"); 
            cboAsType.addItem("CP2");
            cboAsType.addItem("RMCP");
            cboAsType.addItem("FYP");
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String intake = data[1];
                    String id = data[0];
                    String sup = data[3];
                    String SM = data[4];
                    
                    model9.addRow(new Object[]{intake, id, sup, SM});
                    
                    boolean itemExists = false;
                    for (int i = 0; i < cboIntakeChoice1.getItemCount(); i++) {
                        if (cboIntakeChoice1.getItemAt(i).equals(intake)) {
                            itemExists = true;
                            break;
                        }
                    }
                    if (itemExists == false){cboIntakeChoice1.addItem(intake);}
                 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable9() {
        model9.setRowCount(0);
    }
    
    private void loadStudSupFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            clearTable10();
            cboStudIDChoice.removeAllItems();
            cboAssign3.removeAllItems();
            cboStudIDChoice.addItem("None");
            cboAssign3.addItem("None");
            cboAssign3.addItem("Supervisor");
            cboAssign3.addItem("Second Marker");
            
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    String sup = data[9];
                    String id = data[3];
                    String name = data[4];
                    String SM = data[10];
                    model10.addRow(new Object[]{id,name,sup,SM});
                    
                    cboStudIDChoice.addItem(id);
                    
                 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable10() {
        model10.setRowCount(0);
    }
    
    private void loadIntakeRepFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            clearTable11();
            
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    String repID = data[0];
                    String intake = data[3];
                    String assessType = data[4];
                    String moodleLink = data[6];
                    String status = data[7];
                    
                    model11.addRow(new Object[]{repID,intake,assessType,moodleLink,status});
                             
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable11() {
        model11.setRowCount(0);
    }
    
    private void loadStudRepFromFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            clearTable12();
                    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) {
                    String repID = data[0];
                    String studID = data[1];
                    String studName = data[2];
                    String moodleLink = data[6];
                    String status = data[7];
                    
                    model12.addRow(new Object[]{repID,studID,studName,moodleLink,status});
                             
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable12() {
        model12.setRowCount(0);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPMIntake = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboIntakeChoice = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboAsType = new javax.swing.JComboBox<>();
        butAllotIntake = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIndividualStud = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cboIndStud = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboAssType = new javax.swing.JComboBox<>();
        butAllotAssess = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAssSup = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboAsType1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboAssign1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboLecIDChoice1 = new javax.swing.JComboBox<>();
        butAssign1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSupIntake = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cboIntakeChoice1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboAssign2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboLecIDChoice2 = new javax.swing.JComboBox<>();
        butAssign2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblStudSup = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cboStudIDChoice = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cboAssign3 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cboLecIDChoice3 = new javax.swing.JComboBox<>();
        butAssign3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSupLecturers = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblIntakeRep = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblStudRep = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel23.setText("jLabel23");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PROJECT MANAGER");

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
                .addGap(335, 335, 335)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel5.setLayout(null);

        tblPMIntake.setBackground(new java.awt.Color(255, 255, 255));
        tblPMIntake.setForeground(new java.awt.Color(0, 0, 0));
        tblPMIntake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intake", "Student ID", "Assessment Type"
            }
        ));
        jScrollPane1.setViewportView(tblPMIntake);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(73, 24, 705, 218);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Assessment Type:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(209, 330, 116, 20);

        cboIntakeChoice.setBackground(new java.awt.Color(255, 255, 255));
        cboIntakeChoice.setForeground(new java.awt.Color(0, 0, 0));
        cboIntakeChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel5.add(cboIntakeChoice);
        cboIntakeChoice.setBounds(350, 280, 186, 26);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Intake:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(278, 286, 50, 20);

        cboAsType.setBackground(new java.awt.Color(255, 255, 255));
        cboAsType.setForeground(new java.awt.Color(0, 0, 0));
        cboAsType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel5.add(cboAsType);
        cboAsType.setBounds(350, 330, 185, 26);

        butAllotIntake.setBackground(new java.awt.Color(153, 153, 153));
        butAllotIntake.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAllotIntake.setForeground(new java.awt.Color(255, 255, 255));
        butAllotIntake.setText("Allot Intake");
        butAllotIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAllotIntakeActionPerformed(evt);
            }
        });
        jPanel5.add(butAllotIntake);
        butAllotIntake.setBounds(357, 407, 123, 40);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel17.setText("jLabel17");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(-10, 0, 870, 490);

        jTabbedPane2.addTab("Intake", jPanel5);

        jPanel6.setLayout(null);

        tblIndividualStud.setBackground(new java.awt.Color(255, 255, 255));
        tblIndividualStud.setForeground(new java.awt.Color(0, 0, 0));
        tblIndividualStud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Intake", "Assessment Type"
            }
        ));
        jScrollPane2.setViewportView(tblIndividualStud);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(67, 29, 722, 224);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Student ID:");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(299, 297, 80, 20);

        cboIndStud.setBackground(new java.awt.Color(255, 255, 255));
        cboIndStud.setForeground(new java.awt.Color(0, 0, 0));
        cboIndStud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel6.add(cboIndStud);
        cboIndStud.setBounds(404, 295, 155, 26);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Assessment Type:");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(258, 335, 116, 20);

        cboAssType.setBackground(new java.awt.Color(255, 255, 255));
        cboAssType.setForeground(new java.awt.Color(0, 0, 0));
        cboAssType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel6.add(cboAssType);
        cboAssType.setBounds(404, 333, 155, 26);

        butAllotAssess.setBackground(new java.awt.Color(153, 153, 153));
        butAllotAssess.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAllotAssess.setForeground(new java.awt.Color(255, 255, 255));
        butAllotAssess.setText("Allot Assessment");
        butAllotAssess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAllotAssessActionPerformed(evt);
            }
        });
        jPanel6.add(butAllotAssess);
        butAllotAssess.setBounds(347, 411, 146, 38);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel21.setText("jLabel21");
        jPanel6.add(jLabel21);
        jLabel21.setBounds(0, 0, 870, 490);

        jTabbedPane2.addTab("Individual", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Allot Assessments", jPanel2);

        jPanel3.setLayout(null);

        jPanel8.setLayout(null);

        tblAssSup.setBackground(new java.awt.Color(255, 255, 255));
        tblAssSup.setForeground(new java.awt.Color(0, 0, 0));
        tblAssSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assessment", "Student ID", "Supervisor", "Second Marker"
            }
        ));
        jScrollPane4.setViewportView(tblAssSup);

        jPanel8.add(jScrollPane4);
        jScrollPane4.setBounds(30, 21, 372, 261);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Lecturer ID:");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(92, 378, 77, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(jLabel7);
        jLabel7.setBounds(174, 332, 0, 0);

        cboAsType1.setBackground(new java.awt.Color(255, 255, 255));
        cboAsType1.setForeground(new java.awt.Color(0, 0, 0));
        cboAsType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel8.add(cboAsType1);
        cboAsType1.setBounds(197, 300, 193, 26);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Assessment Type:");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(75, 302, 116, 20);

        cboAssign1.setBackground(new java.awt.Color(255, 255, 255));
        cboAssign1.setForeground(new java.awt.Color(0, 0, 0));
        cboAssign1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel8.add(cboAssign1);
        cboAssign1.setBounds(197, 338, 193, 26);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Assign:");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(109, 340, 47, 20);

        cboLecIDChoice1.setBackground(new java.awt.Color(255, 255, 255));
        cboLecIDChoice1.setForeground(new java.awt.Color(0, 0, 0));
        cboLecIDChoice1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel8.add(cboLecIDChoice1);
        cboLecIDChoice1.setBounds(197, 376, 193, 26);

        butAssign1.setBackground(new java.awt.Color(153, 153, 153));
        butAssign1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAssign1.setForeground(new java.awt.Color(255, 255, 255));
        butAssign1.setText("Assign");
        butAssign1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAssign1ActionPerformed(evt);
            }
        });
        jPanel8.add(butAssign1);
        butAssign1.setBounds(168, 435, 88, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel16.setText("jLabel16");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(0, 0, 860, 510);

        jTabbedPane3.addTab("Assessment", jPanel8);

        jPanel9.setLayout(null);

        tblSupIntake.setBackground(new java.awt.Color(255, 255, 255));
        tblSupIntake.setForeground(new java.awt.Color(0, 0, 0));
        tblSupIntake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intake", "Student ID", "Supervisor", "Second Marker"
            }
        ));
        jScrollPane5.setViewportView(tblSupIntake);

        jPanel9.add(jScrollPane5);
        jScrollPane5.setBounds(28, 20, 379, 262);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Intake:");
        jPanel9.add(jLabel10);
        jLabel10.setBounds(113, 302, 50, 20);

        cboIntakeChoice1.setBackground(new java.awt.Color(255, 255, 255));
        cboIntakeChoice1.setForeground(new java.awt.Color(0, 0, 0));
        cboIntakeChoice1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel9.add(cboIntakeChoice1);
        cboIntakeChoice1.setBounds(182, 300, 200, 26);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Lecturer ID:");
        jPanel9.add(jLabel11);
        jLabel11.setBounds(87, 390, 77, 20);

        cboAssign2.setBackground(new java.awt.Color(255, 255, 255));
        cboAssign2.setForeground(new java.awt.Color(0, 0, 0));
        cboAssign2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel9.add(cboAssign2);
        cboAssign2.setBounds(182, 344, 200, 26);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Assign:");
        jPanel9.add(jLabel12);
        jLabel12.setBounds(110, 340, 47, 20);

        cboLecIDChoice2.setBackground(new java.awt.Color(255, 255, 255));
        cboLecIDChoice2.setForeground(new java.awt.Color(0, 0, 0));
        cboLecIDChoice2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel9.add(cboLecIDChoice2);
        cboLecIDChoice2.setBounds(182, 388, 200, 26);

        butAssign2.setBackground(new java.awt.Color(153, 153, 153));
        butAssign2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAssign2.setForeground(new java.awt.Color(255, 255, 255));
        butAssign2.setText("Assign");
        butAssign2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAssign2ActionPerformed(evt);
            }
        });
        jPanel9.add(butAssign2);
        butAssign2.setBounds(172, 432, 91, 42);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel19.setText("jLabel19");
        jPanel9.add(jLabel19);
        jLabel19.setBounds(0, 0, 450, 490);

        jTabbedPane3.addTab("Intake", jPanel9);

        jPanel7.setLayout(null);

        tblStudSup.setBackground(new java.awt.Color(255, 255, 255));
        tblStudSup.setForeground(new java.awt.Color(0, 0, 0));
        tblStudSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Supervisor", "Second Marker"
            }
        ));
        jScrollPane6.setViewportView(tblStudSup);

        jPanel7.add(jScrollPane6);
        jScrollPane6.setBounds(30, 20, 383, 255);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Student ID:");
        jPanel7.add(jLabel13);
        jLabel13.setBounds(104, 301, 80, 20);

        cboStudIDChoice.setBackground(new java.awt.Color(255, 255, 255));
        cboStudIDChoice.setForeground(new java.awt.Color(0, 0, 0));
        cboStudIDChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel7.add(cboStudIDChoice);
        cboStudIDChoice.setBounds(197, 299, 192, 26);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Assign:");
        jPanel7.add(jLabel14);
        jLabel14.setBounds(132, 339, 47, 20);

        cboAssign3.setBackground(new java.awt.Color(255, 255, 255));
        cboAssign3.setForeground(new java.awt.Color(0, 0, 0));
        cboAssign3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel7.add(cboAssign3);
        cboAssign3.setBounds(197, 337, 192, 26);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Lecturer ID:");
        jPanel7.add(jLabel15);
        jLabel15.setBounds(102, 383, 77, 20);

        cboLecIDChoice3.setBackground(new java.awt.Color(255, 255, 255));
        cboLecIDChoice3.setForeground(new java.awt.Color(0, 0, 0));
        cboLecIDChoice3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel7.add(cboLecIDChoice3);
        cboLecIDChoice3.setBounds(197, 381, 192, 26);

        butAssign3.setBackground(new java.awt.Color(153, 153, 153));
        butAssign3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAssign3.setForeground(new java.awt.Color(255, 255, 255));
        butAssign3.setText("Assign");
        butAssign3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAssign3ActionPerformed(evt);
            }
        });
        jPanel7.add(butAssign3);
        butAssign3.setBounds(183, 437, 94, 35);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel20.setText("jLabel20");
        jPanel7.add(jLabel20);
        jLabel20.setBounds(0, 0, 450, 490);

        jTabbedPane3.addTab("Individual", jPanel7);

        jPanel3.add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 0, 450, 520);

        tblSupLecturers.setBackground(new java.awt.Color(255, 255, 255));
        tblSupLecturers.setForeground(new java.awt.Color(0, 0, 0));
        tblSupLecturers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lecturer Name", "Lecturer ID", "Supervisor", "Second Marker"
            }
        ));
        jScrollPane3.setViewportView(tblSupLecturers);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(464, 56, 383, 259);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel18.setText("jLabel18");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(450, 36, 420, 490);

        jTabbedPane1.addTab("Manage Supervisors and Second Markers", jPanel3);

        jPanel10.setLayout(null);

        tblIntakeRep.setBackground(new java.awt.Color(255, 255, 255));
        tblIntakeRep.setForeground(new java.awt.Color(0, 0, 0));
        tblIntakeRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Report ID", "Intake", "Status", "Moodle Link"
            }
        ));
        jScrollPane8.setViewportView(tblIntakeRep);

        jPanel10.add(jScrollPane8);
        jScrollPane8.setBounds(90, 28, 668, 280);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel22.setText("jLabel22");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(-10, 0, 880, 490);

        jTabbedPane4.addTab("Intake", jPanel10);

        jPanel11.setLayout(null);

        tblStudRep.setBackground(new java.awt.Color(255, 255, 255));
        tblStudRep.setForeground(new java.awt.Color(0, 0, 0));
        tblStudRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Report ID", "Student ID", "Student Name", "Status", "Moodle Link"
            }
        ));
        jScrollPane7.setViewportView(tblStudRep);

        jPanel11.add(jScrollPane7);
        jScrollPane7.setBounds(100, 33, 664, 240);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-07 at 15.32.40_a30467a5.jpg"))); // NOI18N
        jLabel26.setText("jLabel26");
        jPanel11.add(jLabel26);
        jLabel26.setBounds(-10, 10, 890, 480);

        jTabbedPane4.addTab("Student", jPanel11);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("View Report", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAllotIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAllotIntakeActionPerformed
        String selectedIntake = (String) cboIntakeChoice.getSelectedItem();
        String selectedAsType = (String) cboAsType.getSelectedItem();

        List<String> studentsList = new ArrayList<>();
        List<String> intakeList = new ArrayList<>();

        boolean studUpdated = false;
        boolean intakeUpdated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11 && data[6].equals(selectedIntake)) {
                    
                    data[8] = selectedAsType; 
                    
                    Date currentDate = new Date();

                    Date parsedDate = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String formattedDate = dateFormat.format(currentDate);
                    
                    try {
                        parsedDate = dateFormat.parse(formattedDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProjectManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Report R1 = new Report("None",data[4],data[3],data[6],selectedAsType,parsedDate,"None","None", data[9], data[10]);
                    
                    
                    try (BufferedWriter repWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt", true))) {
                        repWriter.write(R1.getReportID()+ "," + R1.getStudentName() + "," + R1.getStudentId()+ "," + R1.getIntake()+ "," + R1.getAssessmentType()+ "," + R1.getSubmissionDate() + "," + R1.getMoodleLink()+ "," + R1.getStatus() + "," + R1.getSupervisor() + "," + R1.getSM());
                        repWriter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    studUpdated = true;
                    
                }
                studentsList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[1].equals(selectedIntake)) {
                    data[2] = selectedAsType;  // Update type
                    
                    intakeUpdated = true;
                }
                intakeList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (studUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                for (String line : studentsList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

        if (intakeUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
                for (String line : intakeList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (studUpdated || intakeUpdated) {
            JOptionPane.showMessageDialog(this, "Assessment details updated successfully.");

        } else {
            JOptionPane.showMessageDialog(this, "Intake details not found or no changes made.");
        }
        
        loadIndStudFromFile();
        loadIntakeFromFile(); 
        loadIntakeSupFromFile();
        loadAssSupFromFile();
    }//GEN-LAST:event_butAllotIntakeActionPerformed

    private void butAllotAssessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAllotAssessActionPerformed
        String selectedID = (String) cboIndStud.getSelectedItem();
        String selectedAsType = (String) cboAssType.getSelectedItem();

        List<String> studentsList = new ArrayList<>();
        List<String> intakeList = new ArrayList<>();

        boolean studUpdated = false;
        boolean intakeUpdated = false;
        
      
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11 && data[3].equals(selectedID)) {
                    data[8] = selectedAsType; 

                    Date currentDate = new Date();

                    Date parsedDate = null;

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String formattedDate = dateFormat.format(currentDate);
                    parsedDate = dateFormat.parse(formattedDate);

                    Report R1 = new Report("None",data[4],data[3],data[6],selectedAsType,parsedDate,"None","None", data[9], data[10]);

                    try (BufferedWriter repWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt", true))) {
                        repWriter.write(R1.getReportID()+ "," + R1.getStudentName() + "," + R1.getStudentId()+ "," + R1.getIntake()+ "," + R1.getAssessmentType()+ "," + R1.getSubmissionDate() + "," + R1.getMoodleLink()+ "," + R1.getStatus() + "," + R1.getSupervisor() + "," + R1.getSM());
                        repWriter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    studUpdated = true;

                }
                studentsList.add(String.join(",",data));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ProjectManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[0].equals(selectedID)) {
                    data[2] = selectedAsType;  // Update type

                    intakeUpdated = true;
                }
                intakeList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (studUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                for (String line : studentsList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (intakeUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
                for (String line : intakeList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (studUpdated || intakeUpdated) {
            JOptionPane.showMessageDialog(this, "Assessment details updated successfully.");

        } else {
            JOptionPane.showMessageDialog(this, "Intake details not found or no changes made.");
        }
        loadIndStudFromFile();
        loadIntakeFromFile();
        loadIntakeSupFromFile();
        loadAssSupFromFile();
           
    }//GEN-LAST:event_butAllotAssessActionPerformed

    private void butAssign1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAssign1ActionPerformed
        String selectedLecID = (String) cboLecIDChoice1.getSelectedItem();
        String selectedAsType = (String) cboAsType1.getSelectedItem();
        String selectedAssign = (String) cboAssign1.getSelectedItem();

        List<String> lecturersList = new ArrayList<>();
        List<String> intakeList = new ArrayList<>();
        List<String> studentsList = new ArrayList<>();
        
        boolean lecturersUpdated = false;
        boolean intakeUpdated = false;
        boolean studentsUpdated = false;
        
        System.out.println(selectedAsType + selectedAssign);
        if(selectedAssign.equals("Second Marker") && selectedAsType.equals("Internship")){
            JOptionPane.showMessageDialog(this, "There is no second marker for Internship.");
            
        }else{
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 10 && data[3].equals(selectedLecID)) {
                        if(selectedAssign == "Supervisor"){data[8] = "true";}
                        else{if(selectedAssign == "Second Marker"){data[9] = "true";}

                        }
                        lecturersUpdated = true;                    
                    }
                    lecturersList.add(String.join(",",data));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 5 && data[2].equals(selectedAsType)) {
                        if(selectedAssign == "Supervisor"){data[3] = selectedLecID;}
                        else{if(selectedAssign == "Second Marker"){data[4] = selectedLecID;}  // Update ID
                        }
                        intakeUpdated = true;
                    }
                    intakeList.add(String.join(",", data));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 11 && data[8].equals(selectedAsType)) {
                        if(selectedAssign == "Supervisor"){data[9] = selectedLecID;}
                        else{if(selectedAssign == "Second Marker"){data[10] = selectedLecID;}

                        }
                        studentsUpdated = true;                    
                    }
                    studentsList.add(String.join(",",data));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (lecturersUpdated) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                    for (String line : lecturersList) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (intakeUpdated) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
                    for (String line : intakeList) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (studentsUpdated) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                    for (String line : studentsList) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (lecturersUpdated || intakeUpdated) {
                JOptionPane.showMessageDialog(this, "Successfully assigned.");

            } else {
                JOptionPane.showMessageDialog(this, "Assessment details not found or no changes made.");
            }

            loadAssSupFromFile();
            loadSupLecturersFromFile();
            loadIntakeSupFromFile();
        }    
    }//GEN-LAST:event_butAssign1ActionPerformed

    private void butAssign2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAssign2ActionPerformed
        String selectedLecID = (String) cboLecIDChoice2.getSelectedItem();
        String selectedIntake = (String) cboIntakeChoice1.getSelectedItem();
        String selectedAssign = (String) cboAssign2.getSelectedItem();

        List<String> lecturersList = new ArrayList<>();
        List<String> intakeList = new ArrayList<>();
        List<String> studentsList = new ArrayList<>();
        
        boolean lecturersUpdated = false;
        boolean intakeUpdated = false;  
        boolean studentsUpdated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[3].equals(selectedLecID)) {
                    if(selectedAssign == "Supervisor"){data[8] = "true";}
                    else{if(selectedAssign == "Second Marker"){data[9] = "true";}
                    
                    }
                    lecturersUpdated = true;                    
                }
                lecturersList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[1].equals(selectedIntake)) {
                    if(selectedAssign == "Supervisor"){data[3] = selectedLecID;}
                    else{if(selectedAssign == "Second Marker"){data[4] = selectedLecID;}  // Update ID
                    }
                    intakeUpdated = true;
                }
                intakeList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11 && data[6].equals(selectedIntake)) {
                    if(selectedAssign == "Supervisor"){data[9] = selectedLecID;}
                    else{if(selectedAssign == "Second Marker"){data[10] = selectedLecID;}
                    
                    }
                    studentsUpdated = true;                    
                }
                studentsList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lecturersUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                for (String line : lecturersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

        if (intakeUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
                for (String line : intakeList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (studentsUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                for (String line : studentsList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        if (lecturersUpdated || intakeUpdated) {
            JOptionPane.showMessageDialog(this, "Successfully assigned.");

        } else {
            JOptionPane.showMessageDialog(this, "Intake details not found or no changes made.");
        }
        
        loadIntakeSupFromFile();
        loadSupLecturersFromFile();
        loadAssSupFromFile();
        loadStudSupFromFile();
    }//GEN-LAST:event_butAssign2ActionPerformed

    private void butAssign3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAssign3ActionPerformed
        String selectedLecID = (String) cboLecIDChoice3.getSelectedItem();
        String selectedStudID = (String) cboStudIDChoice.getSelectedItem();
        String selectedAssign = (String) cboAssign3.getSelectedItem();

        List<String> lecturersList = new ArrayList<>();
        List<String> studentsList = new ArrayList<>();
        List<String> intakeList = new ArrayList<>();

        boolean lecturersUpdated = false;
        boolean intakeUpdated = false;
        boolean studentsUpdated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[3].equals(selectedLecID)) {
                    if(selectedAssign == "Supervisor"){data[8] = "true";}
                    else{if(selectedAssign == "Second Marker"){data[9] = "true";}
                    
                    }
                    lecturersUpdated = true;                    
                }
                lecturersList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[0].equals(selectedStudID)) {
                    if(selectedAssign == "Supervisor"){data[3] = selectedLecID;}
                    else{if(selectedAssign == "Second Marker"){data[4] = selectedLecID;}  // Update ID
                    }
                    intakeUpdated = true;
                }
                intakeList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11 && data[3].equals(selectedStudID)) {
                    if(selectedAssign == "Supervisor"){data[9] = selectedLecID;}
                    else{if(selectedAssign == "Second Marker"){data[10] = selectedLecID;}
                    
                    }
                    studentsUpdated = true;                    
                }
                studentsList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lecturersUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                for (String line : lecturersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

        if (intakeUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt"))) {
                for (String line : intakeList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (studentsUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                for (String line : studentsList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (lecturersUpdated || intakeUpdated) {
            JOptionPane.showMessageDialog(this, "Successfully assigned.");

        } else {
            JOptionPane.showMessageDialog(this, "Intake details not found or no changes made.");
        }
        
        loadStudSupFromFile();
        loadSupLecturersFromFile();
        loadIntakeSupFromFile();
        loadAssSupFromFile();
    }//GEN-LAST:event_butAssign3ActionPerformed

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
            java.util.logging.Logger.getLogger(ProjectManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectManagerJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAllotAssess;
    private javax.swing.JButton butAllotIntake;
    private javax.swing.JButton butAssign1;
    private javax.swing.JButton butAssign2;
    private javax.swing.JButton butAssign3;
    private javax.swing.JComboBox<String> cboAsType;
    private javax.swing.JComboBox<String> cboAsType1;
    private javax.swing.JComboBox<String> cboAssType;
    private javax.swing.JComboBox<String> cboAssign1;
    private javax.swing.JComboBox<String> cboAssign2;
    private javax.swing.JComboBox<String> cboAssign3;
    private javax.swing.JComboBox<String> cboIndStud;
    private javax.swing.JComboBox<String> cboIntakeChoice;
    private javax.swing.JComboBox<String> cboIntakeChoice1;
    private javax.swing.JComboBox<String> cboLecIDChoice1;
    private javax.swing.JComboBox<String> cboLecIDChoice2;
    private javax.swing.JComboBox<String> cboLecIDChoice3;
    private javax.swing.JComboBox<String> cboStudIDChoice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable tblAssSup;
    private javax.swing.JTable tblIndividualStud;
    private javax.swing.JTable tblIntakeRep;
    private javax.swing.JTable tblPMIntake;
    private javax.swing.JTable tblStudRep;
    private javax.swing.JTable tblStudSup;
    private javax.swing.JTable tblSupIntake;
    private javax.swing.JTable tblSupLecturers;
    // End of variables declaration//GEN-END:variables
}
