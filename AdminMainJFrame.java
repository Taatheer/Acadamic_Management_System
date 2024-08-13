package AGH;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Taatheer
 */
public class AdminMainJFrame extends javax.swing.JFrame {

    public DefaultTableModel model1;
    public DefaultTableModel model2;
    public DefaultTableModel model3;
    public DefaultTableModel model4;
    public ArrayList<Lecturer> theLecList = new ArrayList<Lecturer>();
    public ArrayList<Student> theStudList = new ArrayList<Student>();
    public ArrayList<ProjectManager> thePMList = new ArrayList<ProjectManager>();   
    
    public AdminMainJFrame() {
        initComponents();
        model1 = (DefaultTableModel)tblLecturer.getModel();
        model2 = (DefaultTableModel)tblStudents.getModel();
        model3 = (DefaultTableModel)tblManagePM.getModel();
        model4 = (DefaultTableModel)tbleditPM.getModel();
        loadLecturersFromFile();
        loadStudentsFromFile();
        loadPMFromFile();
        loadEditPMFromFile();
        
       
    }
    private void loadLecturersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            clearTable1();
            cboLecID.removeAllItems();
            cboLecID.addItem("None");
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
                    theLecList.add(L2);
                    model1.addRow(new Object[]{id, name, nationality, gender, age});
                    
                    cboLecID.addItem(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable1() {
        model1.setRowCount(0);
    }
        
    private void loadStudentsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            clearTable2();
            cboStudID.removeAllItems();
            cboStudID.addItem("None");
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
                    String assessType = "None";
                    String supervisor = "None";
                    String secMarker = "None";
                    
                    Student S2 = new Student(nationality, gender,intake, age, id, name, password,type,assessType,supervisor,secMarker);
                    theStudList.add(S2);
                    model2.addRow(new Object[]{id, name, nationality, age, gender, intake});
                    
                    cboStudID.addItem(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable2() {
        model2.setRowCount(0);
    }
    private void loadPMFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            clearTable3();
            cboLecPMID.removeAllItems();
            cboLecPMID.addItem("None");
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
                    
                    Lecturer L3 = new Lecturer(nationality, gender, age, id, name, password,type,PM, Sup, SM);
                    theLecList.add(L3);
                    model3.addRow(new Object[]{id, name, PM});
                    
                    cboLecPMID.addItem(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable3() {
        model3.setRowCount(0);
    }
    
    private void loadEditPMFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\ProjectManagers.txt"))) {
            String line;
            clearTable4();
            cboeditPMID.removeAllItems();
            cboeditPMID.addItem("None");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String id = data[0];
                    String name = data[1];
                    String password = data[2];
                    String type = data[3];
                    boolean PM = Boolean.parseBoolean(data[4]);
                    
                    ProjectManager PM1 = new ProjectManager(id, name, password,type,PM);
                    thePMList.add(PM1);
                    model4.addRow(new Object[]{id, name, type});
                    
                    cboeditPMID.addItem(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearTable4() {
        model4.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rdbEditLec = new javax.swing.ButtonGroup();
        rbnregStud = new javax.swing.ButtonGroup();
        rbnEditStud = new javax.swing.ButtonGroup();
        rbnManagePM = new javax.swing.ButtonGroup();
        rbnregLec = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        RegStudPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtStudName = new javax.swing.JTextField();
        txtStudNat = new javax.swing.JTextField();
        txtStudPass = new javax.swing.JPasswordField();
        txtStudAge = new javax.swing.JTextField();
        txtStudIntake = new javax.swing.JTextField();
        rbNMale = new javax.swing.JRadioButton();
        rbnFemale = new javax.swing.JRadioButton();
        butRegStud = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        EditLecPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLecturer = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rbnEditLecName = new javax.swing.JRadioButton();
        rbnEditLecNat = new javax.swing.JRadioButton();
        butEditLec = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        editLecNew = new javax.swing.JTextField();
        cboLecID = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        cboStudID = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        rbnEditStudNat = new javax.swing.JRadioButton();
        rbnEditStudName = new javax.swing.JRadioButton();
        rbnEditStudIntake = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        editStudNew = new javax.swing.JTextField();
        butEditStud = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblManagePM = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        cboLecPMID = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        rbnPMYes = new javax.swing.JRadioButton();
        rbnPMNo = new javax.swing.JRadioButton();
        butAllotPM = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbleditPM = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cboeditPMID = new javax.swing.JComboBox<>();
        rbnPMName = new javax.swing.JRadioButton();
        butPMChange = new javax.swing.JButton();
        butPMDelete = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        editPMName = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        RegLecPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLecName = new javax.swing.JTextField();
        txtLecAge = new javax.swing.JTextField();
        txtLecNat = new javax.swing.JTextField();
        rbnMale1 = new javax.swing.JRadioButton();
        rbnFemale1 = new javax.swing.JRadioButton();
        txtLecPass = new javax.swing.JPasswordField();
        butRegLec = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/realistic-neon-lights-background_23-2148907367 (3).jpg"))); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/realistic-neon-lights-background_23-2148907367 (3).jpg"))); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/realistic-neon-lights-background_23-2148907367 (3).jpg"))); // NOI18N
        jLabel18.setText("jLabel18");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ADMIN");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Log out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        RegStudPanel.setBackground(new java.awt.Color(255, 255, 255));
        RegStudPanel.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Student Age:");
        RegStudPanel.add(jLabel10);
        jLabel10.setBounds(268, 226, 86, 20);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Student Name:");
        RegStudPanel.add(jLabel12);
        jLabel12.setBounds(255, 112, 99, 20);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Student Password:");
        RegStudPanel.add(jLabel13);
        jLabel13.setBounds(232, 150, 122, 20);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Intake:");
        RegStudPanel.add(jLabel14);
        jLabel14.setBounds(308, 264, 50, 20);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Student Nationality:");
        RegStudPanel.add(jLabel15);
        jLabel15.setBounds(220, 188, 140, 20);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Gender:");
        RegStudPanel.add(jLabel16);
        jLabel16.setBounds(302, 302, 52, 20);

        txtStudName.setBackground(new java.awt.Color(255, 255, 255));
        txtStudName.setForeground(new java.awt.Color(0, 0, 0));
        RegStudPanel.add(txtStudName);
        txtStudName.setBounds(372, 110, 143, 26);

        txtStudNat.setBackground(new java.awt.Color(255, 255, 255));
        txtStudNat.setForeground(new java.awt.Color(0, 0, 0));
        RegStudPanel.add(txtStudNat);
        txtStudNat.setBounds(372, 186, 143, 26);

        txtStudPass.setBackground(new java.awt.Color(255, 255, 255));
        txtStudPass.setForeground(new java.awt.Color(0, 0, 0));
        RegStudPanel.add(txtStudPass);
        txtStudPass.setBounds(372, 148, 143, 26);

        txtStudAge.setBackground(new java.awt.Color(255, 255, 255));
        txtStudAge.setForeground(new java.awt.Color(0, 0, 0));
        RegStudPanel.add(txtStudAge);
        txtStudAge.setBounds(372, 224, 143, 26);

        txtStudIntake.setBackground(new java.awt.Color(255, 255, 255));
        txtStudIntake.setForeground(new java.awt.Color(0, 0, 0));
        txtStudIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudIntakeActionPerformed(evt);
            }
        });
        RegStudPanel.add(txtStudIntake);
        txtStudIntake.setBounds(372, 262, 143, 26);

        rbnregStud.add(rbNMale);
        rbNMale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbNMale.setForeground(new java.awt.Color(0, 0, 0));
        rbNMale.setText("Male");
        rbNMale.setContentAreaFilled(false);
        RegStudPanel.add(rbNMale);
        rbNMale.setBounds(372, 300, 100, 25);

        rbnregStud.add(rbnFemale);
        rbnFemale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnFemale.setForeground(new java.awt.Color(0, 0, 0));
        rbnFemale.setText("Female");
        rbnFemale.setContentAreaFilled(false);
        RegStudPanel.add(rbnFemale);
        rbnFemale.setBounds(372, 331, 100, 25);

        butRegStud.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butRegStud.setForeground(new java.awt.Color(255, 255, 255));
        butRegStud.setText("Register");
        butRegStud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRegStudActionPerformed(evt);
            }
        });
        RegStudPanel.add(butRegStud);
        butRegStud.setBounds(364, 386, 126, 39);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-08 at 02.36.00_4f943dbd.jpg"))); // NOI18N
        jLabel29.setText("jLabel29");
        RegStudPanel.add(jLabel29);
        jLabel29.setBounds(0, 0, 860, 520);

        jTabbedPane1.addTab("Register Student", RegStudPanel);

        EditLecPanel.setBackground(new java.awt.Color(0, 0, 0));
        EditLecPanel.setForeground(new java.awt.Color(0, 0, 0));
        EditLecPanel.setLayout(null);

        tblLecturer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblLecturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Nationality", "Gender", "Age"
            }
        ));
        jScrollPane1.setViewportView(tblLecturer);

        EditLecPanel.add(jScrollPane1);
        jScrollPane1.setBounds(92, 43, 686, 197);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Choose:");
        EditLecPanel.add(jLabel17);
        jLabel17.setBounds(300, 340, 53, 27);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Lecturer ID:");
        EditLecPanel.add(jLabel19);
        jLabel19.setBounds(280, 290, 77, 27);

        rdbEditLec.add(rbnEditLecName);
        rbnEditLecName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnEditLecName.setForeground(new java.awt.Color(255, 255, 255));
        rbnEditLecName.setText("Name");
        rbnEditLecName.setContentAreaFilled(false);
        EditLecPanel.add(rbnEditLecName);
        rbnEditLecName.setBounds(370, 340, 100, 25);

        rdbEditLec.add(rbnEditLecNat);
        rbnEditLecNat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnEditLecNat.setForeground(new java.awt.Color(255, 255, 255));
        rbnEditLecNat.setText("Nationality");
        rbnEditLecNat.setContentAreaFilled(false);
        EditLecPanel.add(rbnEditLecNat);
        rbnEditLecNat.setBounds(470, 340, 100, 25);

        butEditLec.setBackground(new java.awt.Color(153, 153, 153));
        butEditLec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butEditLec.setForeground(new java.awt.Color(255, 255, 255));
        butEditLec.setText("Edit");
        butEditLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditLecActionPerformed(evt);
            }
        });
        EditLecPanel.add(butEditLec);
        butEditLec.setBounds(378, 440, 121, 39);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("New Details:");
        EditLecPanel.add(jLabel20);
        jLabel20.setBounds(264, 391, 83, 20);

        editLecNew.setBackground(new java.awt.Color(255, 255, 255));
        EditLecPanel.add(editLecNew);
        editLecNew.setBounds(365, 389, 198, 26);

        cboLecID.setBackground(new java.awt.Color(255, 255, 255));
        EditLecPanel.add(cboLecID);
        cboLecID.setBounds(365, 288, 200, 26);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-08 at 02.36.00_4f943dbd.jpg"))); // NOI18N
        jLabel30.setText("jLabel30");
        EditLecPanel.add(jLabel30);
        jLabel30.setBounds(0, 0, 860, 520);

        jTabbedPane1.addTab("Edit Lecturer", EditLecPanel);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(null);

        tblStudents.setBackground(new java.awt.Color(255, 255, 255));
        tblStudents.setForeground(new java.awt.Color(0, 0, 0));
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Nationality", "Age", "Gender", "Intake"
            }
        ));
        jScrollPane2.setViewportView(tblStudents);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(83, 45, 690, 195);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Student ID:");
        jPanel6.add(jLabel21);
        jLabel21.setBounds(266, 291, 80, 20);

        cboStudID.setBackground(new java.awt.Color(255, 255, 255));
        cboStudID.setForeground(new java.awt.Color(0, 0, 0));
        cboStudID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel6.add(cboStudID);
        cboStudID.setBounds(369, 289, 206, 26);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Choose:");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(280, 350, 53, 20);

        rbnEditStud.add(rbnEditStudNat);
        rbnEditStudNat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnEditStudNat.setForeground(new java.awt.Color(0, 0, 0));
        rbnEditStudNat.setText("Nationality");
        rbnEditStudNat.setContentAreaFilled(false);
        jPanel6.add(rbnEditStudNat);
        rbnEditStudNat.setBounds(370, 350, 100, 25);

        rbnEditStud.add(rbnEditStudName);
        rbnEditStudName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnEditStudName.setForeground(new java.awt.Color(0, 0, 0));
        rbnEditStudName.setText("Name");
        rbnEditStudName.setContentAreaFilled(false);
        jPanel6.add(rbnEditStudName);
        rbnEditStudName.setBounds(498, 327, 100, 25);

        rbnEditStud.add(rbnEditStudIntake);
        rbnEditStudIntake.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnEditStudIntake.setForeground(new java.awt.Color(0, 0, 0));
        rbnEditStudIntake.setText("Intake");
        rbnEditStudIntake.setContentAreaFilled(false);
        jPanel6.add(rbnEditStudIntake);
        rbnEditStudIntake.setBounds(500, 380, 100, 25);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("New Details:");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(258, 425, 83, 20);

        editStudNew.setBackground(new java.awt.Color(255, 255, 255));
        editStudNew.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(editStudNew);
        editStudNew.setBounds(369, 419, 201, 26);

        butEditStud.setBackground(new java.awt.Color(153, 153, 153));
        butEditStud.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butEditStud.setForeground(new java.awt.Color(255, 255, 255));
        butEditStud.setText("Edit");
        butEditStud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditStudActionPerformed(evt);
            }
        });
        jPanel6.add(butEditStud);
        butEditStud.setBounds(379, 463, 123, 37);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-08 at 02.36.00_4f943dbd.jpg"))); // NOI18N
        jLabel31.setText("jLabel31");
        jPanel6.add(jLabel31);
        jLabel31.setBounds(0, 0, 860, 520);

        jTabbedPane1.addTab("Edit Student", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(null);

        tblManagePM.setBackground(new java.awt.Color(255, 255, 255));
        tblManagePM.setForeground(new java.awt.Color(0, 0, 0));
        tblManagePM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lecturer ID", "Name", "Is Project Manager"
            }
        ));
        jScrollPane4.setViewportView(tblManagePM);

        jPanel7.add(jScrollPane4);
        jScrollPane4.setBounds(71, 41, 710, 201);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Assign Project Manager:");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(208, 340, 160, 20);

        cboLecPMID.setBackground(new java.awt.Color(255, 255, 255));
        cboLecPMID.setForeground(new java.awt.Color(0, 0, 0));
        cboLecPMID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel7.add(cboLecPMID);
        cboLecPMID.setBounds(388, 294, 190, 26);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Lecturer ID:");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(293, 296, 77, 20);

        rbnManagePM.add(rbnPMYes);
        rbnPMYes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnPMYes.setForeground(new java.awt.Color(0, 0, 0));
        rbnPMYes.setText("Yes");
        rbnPMYes.setContentAreaFilled(false);
        rbnPMYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnPMYesActionPerformed(evt);
            }
        });
        jPanel7.add(rbnPMYes);
        rbnPMYes.setBounds(388, 338, 100, 25);

        rbnManagePM.add(rbnPMNo);
        rbnPMNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnPMNo.setForeground(new java.awt.Color(0, 0, 0));
        rbnPMNo.setText("No");
        rbnPMNo.setContentAreaFilled(false);
        jPanel7.add(rbnPMNo);
        rbnPMNo.setBounds(522, 338, 100, 25);

        butAllotPM.setBackground(new java.awt.Color(153, 153, 153));
        butAllotPM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAllotPM.setForeground(new java.awt.Color(255, 255, 255));
        butAllotPM.setText("Allot");
        butAllotPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAllotPMActionPerformed(evt);
            }
        });
        jPanel7.add(butAllotPM);
        butAllotPM.setBounds(372, 417, 116, 41);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-08 at 02.36.00_4f943dbd.jpg"))); // NOI18N
        jLabel32.setText("jLabel32");
        jPanel7.add(jLabel32);
        jLabel32.setBounds(0, 0, 860, 520);

        jTabbedPane1.addTab("Allot Project Manager", jPanel7);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(null);

        tbleditPM.setBackground(new java.awt.Color(255, 255, 255));
        tbleditPM.setForeground(new java.awt.Color(0, 0, 0));
        tbleditPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type"
            }
        ));
        jScrollPane3.setViewportView(tbleditPM);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(46, 29, 757, 206);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Change:");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(348, 336, 53, 20);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Project Manager ID:");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(277, 292, 132, 20);

        cboeditPMID.setBackground(new java.awt.Color(255, 255, 255));
        cboeditPMID.setForeground(new java.awt.Color(0, 0, 0));
        cboeditPMID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        jPanel3.add(cboeditPMID);
        cboeditPMID.setBounds(427, 290, 188, 26);

        rbnPMName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnPMName.setForeground(new java.awt.Color(255, 255, 255));
        rbnPMName.setText("Name");
        rbnPMName.setContentAreaFilled(false);
        rbnPMName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.add(rbnPMName);
        rbnPMName.setBounds(427, 334, 100, 25);

        butPMChange.setBackground(new java.awt.Color(153, 153, 153));
        butPMChange.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butPMChange.setForeground(new java.awt.Color(255, 255, 255));
        butPMChange.setText("Change");
        butPMChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPMChangeActionPerformed(evt);
            }
        });
        jPanel3.add(butPMChange);
        butPMChange.setBounds(290, 451, 111, 35);

        butPMDelete.setBackground(new java.awt.Color(153, 153, 153));
        butPMDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butPMDelete.setForeground(new java.awt.Color(255, 255, 255));
        butPMDelete.setText("Delete");
        butPMDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPMDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(butPMDelete);
        butPMDelete.setBounds(455, 451, 108, 35);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("New details:");
        jPanel3.add(jLabel28);
        jLabel28.setBounds(320, 373, 81, 20);

        editPMName.setBackground(new java.awt.Color(255, 255, 255));
        editPMName.setForeground(new java.awt.Color(0, 0, 0));
        editPMName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPMNameActionPerformed(evt);
            }
        });
        jPanel3.add(editPMName);
        editPMName.setBounds(427, 371, 177, 26);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-08 at 02.36.00_4f943dbd.jpg"))); // NOI18N
        jLabel33.setText("jLabel33");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(0, 0, 860, 520);

        jTabbedPane1.addTab("Edit Project Manager", jPanel3);

        RegLecPanel.setBackground(new java.awt.Color(0, 0, 0));
        RegLecPanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Lecturer Nationality:");
        RegLecPanel.add(jLabel2);
        jLabel2.setBounds(215, 226, 135, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Lecturer Name:");
        RegLecPanel.add(jLabel3);
        jLabel3.setBounds(250, 110, 103, 28);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Lecturer Age:");
        RegLecPanel.add(jLabel5);
        jLabel5.setBounds(262, 188, 88, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Lecturer Password:");
        RegLecPanel.add(jLabel6);
        jLabel6.setBounds(227, 150, 123, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Lecturer Gender:");
        RegLecPanel.add(jLabel7);
        jLabel7.setBounds(241, 262, 109, 20);

        txtLecName.setBackground(new java.awt.Color(255, 255, 255));
        txtLecName.setForeground(new java.awt.Color(0, 0, 0));
        txtLecName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLecNameActionPerformed(evt);
            }
        });
        RegLecPanel.add(txtLecName);
        txtLecName.setBounds(370, 110, 150, 26);

        txtLecAge.setBackground(new java.awt.Color(255, 255, 255));
        txtLecAge.setForeground(new java.awt.Color(0, 0, 0));
        RegLecPanel.add(txtLecAge);
        txtLecAge.setBounds(368, 186, 152, 26);

        txtLecNat.setBackground(new java.awt.Color(255, 255, 255));
        txtLecNat.setForeground(new java.awt.Color(0, 0, 0));
        RegLecPanel.add(txtLecNat);
        txtLecNat.setBounds(368, 224, 152, 26);

        rbnregLec.add(rbnMale1);
        rbnMale1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnMale1.setForeground(new java.awt.Color(0, 0, 0));
        rbnMale1.setText("Male");
        rbnMale1.setContentAreaFilled(false);
        RegLecPanel.add(rbnMale1);
        rbnMale1.setBounds(368, 263, 100, 25);

        rbnregLec.add(rbnFemale1);
        rbnFemale1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnFemale1.setForeground(new java.awt.Color(0, 0, 0));
        rbnFemale1.setText("Female");
        rbnFemale1.setContentAreaFilled(false);
        RegLecPanel.add(rbnFemale1);
        rbnFemale1.setBounds(368, 290, 100, 25);

        txtLecPass.setBackground(new java.awt.Color(255, 255, 255));
        txtLecPass.setForeground(new java.awt.Color(0, 0, 0));
        RegLecPanel.add(txtLecPass);
        txtLecPass.setBounds(370, 150, 150, 26);

        butRegLec.setBackground(new java.awt.Color(153, 153, 153));
        butRegLec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butRegLec.setForeground(new java.awt.Color(255, 255, 255));
        butRegLec.setText("Register");
        butRegLec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRegLecActionPerformed(evt);
            }
        });
        RegLecPanel.add(butRegLec);
        butRegLec.setBounds(360, 360, 120, 40);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AGH/WhatsApp Image 2024-06-08 at 02.36.00_4f943dbd.jpg"))); // NOI18N
        jLabel34.setText("jLabel34");
        RegLecPanel.add(jLabel34);
        jLabel34.setBounds(0, 0, 860, 520);

        jTabbedPane1.addTab("Register Lecturer", RegLecPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butEditStudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditStudActionPerformed
        
        String selectedID = (String) cboStudID.getSelectedItem();
        String newValue = editStudNew.getText();

        if (selectedID == null || selectedID.isEmpty() || newValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a student and enter the new value.");
            return;
        }
        
        List<String> studentsList = new ArrayList<>();
        List<String> usersList = new ArrayList<>();


        boolean studentUpdated = false;
        boolean userUpdated = false;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11 && data[3].equals(selectedID)) {
                    
                    if (rbnEditStudName.isSelected()) {
                        data[4] = newValue;  // Update Name
                    } else if (rbnEditStudNat.isSelected()) {
                        data[0] = newValue;  // Update Nationality
                    } else if (rbnEditStudIntake.isSelected()) {
                        data[6] = newValue;  // Update Intake
                    }
                    studentUpdated = true;
                }
                studentsList.add(String.join(",",data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(selectedID)) {
                    
                    if (rbnEditStudName.isSelected()) {
                        data[0] = newValue;  // Update Name
                    }
                    userUpdated = true;
                }
                usersList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        if (studentUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt"))) {
                for (String line : studentsList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        }

        if (userUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
                for (String line : usersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (studentUpdated || userUpdated) {
            JOptionPane.showMessageDialog(this, "Student details updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Student not found or no changes made.");
        }
        loadStudentsFromFile();
    }//GEN-LAST:event_butEditStudActionPerformed

    private void butEditLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditLecActionPerformed
        String selectedID = (String) cboLecID.getSelectedItem();
        String newValue = editLecNew.getText();

        if (selectedID == null || selectedID.isEmpty() || newValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a lecturer and enter the new value.");
            return;
        }
        
        List<String> lecturersList = new ArrayList<>();
        List<String> usersList = new ArrayList<>();

        boolean lecturerUpdated = false;
        boolean userUpdated = false;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[3].equals(selectedID)) {
                    
                    if (rbnEditLecName.isSelected()) {
                        data[4] = newValue;  // Update Name
                    } else if (rbnEditLecNat.isSelected()) {
                        data[0] = newValue;  // Update Nationality
                    }
                    lecturerUpdated = true;
                }
                lecturersList.add(String.join(",",data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(selectedID)) {
                    
                    if (rbnEditLecName.isSelected()) {
                        data[0] = newValue;  // Update Name
                    }
                    userUpdated = true;
                }
                usersList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lecturerUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                for (String line : lecturersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (userUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
                for (String line : usersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (lecturerUpdated || userUpdated) {
            JOptionPane.showMessageDialog(this, "Lecturer details updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Lecturer not found or no changes made.");
        }
        loadLecturersFromFile();
    }//GEN-LAST:event_butEditLecActionPerformed

    private void butRegStudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRegStudActionPerformed
        String Gen="";
        if(rbNMale.isSelected()){Gen="Male";}else
        if(rbnFemale.isSelected()){Gen="Female";}

        String studPass = new String(txtStudPass.getPassword());
        Student S1 = new Student(txtStudNat.getText(),Gen,txtStudIntake.getText(),Integer.parseInt(txtStudAge.getText()),null,txtStudName.getText(),studPass, "Student","","","");
        
        String encryptedPassword = null;
        try {
            encryptedPassword = EncryptionUtil.encrypt(studPass);
        } catch (Exception ex) {
            Logger.getLogger(AdminMainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        // Append data to Students.txt
        try (BufferedWriter studWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Students.txt", true))) {
            studWriter.write(S1.getStudNat()+ "," + Gen + "," + S1.getStudAge()+ "," + S1.setID() + "," + S1.getName() + "," + encryptedPassword + "," + S1.getStudIntake() + ",Student,None,None,None");
            studWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter studWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Intake.txt", true))) {
            studWriter.write(S1.getID() +  "," +  S1.getStudIntake() +",None,None,None");
            studWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Append data to User.txt
        try (BufferedWriter userWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt", true))) {
            userWriter.write(S1.getName() + "," + S1.getID() + "," + encryptedPassword + ",Student");
            userWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(this, "Student has been successfully registered.");
        loadStudentsFromFile();
    }//GEN-LAST:event_butRegStudActionPerformed

    private void txtStudIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudIntakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudIntakeActionPerformed

    private void butRegLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRegLecActionPerformed
        String Gen="";
        if(rbnMale1.isSelected()){Gen="Male";}else
        if(rbnFemale1.isSelected()){Gen="Female";}
        

        int lecAgeNu = Integer.parseInt(txtLecAge.getText());
        
        String lecPass = new String(txtLecPass.getPassword());
        Lecturer L1 = new Lecturer(txtLecNat.getText(),Gen,lecAgeNu,null,txtLecName.getText(),lecPass, "Lecturer", false, false, false);
        
        String encryptedPassword = null;
        try {
            encryptedPassword = EncryptionUtil.encrypt(lecPass);
        } catch (Exception ex) {
            Logger.getLogger(AdminMainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Append data to Lecturer.txt
        try (BufferedWriter lecWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt", true))) {
            lecWriter.write(L1.getLecNat() + "," + Gen + "," + L1.getLecAge() + "," + L1.setID() + "," + L1.getName() + "," + encryptedPassword + ",Lecturer," + L1.getIsPM() + "," + L1.getisSupervisor()+ "," + L1.getisSM());
            lecWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Append data to User.txt
        try (BufferedWriter userWriter = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt", true))) {
            userWriter.write(L1.getName() + "," + L1.getID() + "," + encryptedPassword + ",Lecturer");
            userWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Lecturer has been successfully registered.");
            
        loadLecturersFromFile();
        loadPMFromFile();
    }//GEN-LAST:event_butRegLecActionPerformed

    private void rbnPMYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnPMYesActionPerformed
        //
    }//GEN-LAST:event_rbnPMYesActionPerformed

    private void butAllotPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAllotPMActionPerformed
        String selectedID = (String) cboLecPMID.getSelectedItem();

        List<String> LecturersList = new ArrayList<>();
        List<String> usersList = new ArrayList<>();
        List<String> PMList = new ArrayList<>();

        boolean PMUpdated = false;
        boolean userUpdated = false;
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[3].equals(selectedID)) {
                    if (rbnPMYes.isSelected()) {
                        data[7] = "true";  // Update isPM
                        data[6] = "Project Manager";
                        PMUpdated = true;
                        String[] myData = {data[3],data[4],data[5],data[6],data[7]};
                        PMList.add(String.join(",",myData));
                    } else if (rbnPMNo.isSelected()) {
                        data[7] = "false";  
                    }                    
                }
                LecturersList.add(String.join(",",data));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(selectedID)) {
                    if (rbnPMYes.isSelected()) {
                        data[3] = "Project Manager";  // Update type
                    }
                    userUpdated = true;
                }
                usersList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (PMUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                for (String line : LecturersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\ProjectManagers.txt"))) {
                for (String line : PMList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (userUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
                for (String line : usersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (PMUpdated || userUpdated) {
            JOptionPane.showMessageDialog(this, "Project Manager details updated successfully.");
            loadEditPMFromFile();
            loadLecturersFromFile();
        } else {
            JOptionPane.showMessageDialog(this, "Project Manager not found or no changes made.");
        }
        loadPMFromFile();          
    }//GEN-LAST:event_butAllotPMActionPerformed

    private void butPMChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPMChangeActionPerformed
        String selectedID = (String) cboeditPMID.getSelectedItem();
        String newValue = editPMName.getText();

        if (selectedID == null || selectedID.isEmpty() || newValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a project manager and enter the new value.");
            return;
        }

        List<String> lecturersList = new ArrayList<>();
        List<String> PMList = new ArrayList<>();
        List<String> usersList = new ArrayList<>();

        boolean PMUpdated = false;
        boolean userUpdated = false;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\ProjectManagers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[0].equals(selectedID)) {
                    if (rbnPMName.isSelected()) {
                        data[1] = newValue;  // Update Name
                    }
                    PMUpdated = true;
                }
                PMList.add(String.join(",",data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(selectedID)) {
                    if (rbnPMName.isSelected()) {
                        data[0] = newValue;  // Update Name
                    } 
                    userUpdated = true;
                }
                usersList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[3].equals(selectedID)) {
                    if (rbnPMName.isSelected()) {
                        data[4] = newValue;  // Update Name
                    } 
                    PMUpdated = true;
                }
                lecturersList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (PMUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                for (String line : lecturersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\ProjectManagers.txt"))) {
                for (String line : PMList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (userUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
                for (String line : usersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (PMUpdated || userUpdated) {
            JOptionPane.showMessageDialog(this, "Project Manager details updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Project Manager not found or no changes made.");
        }
        loadEditPMFromFile();
        loadPMFromFile();
    }//GEN-LAST:event_butPMChangeActionPerformed

    private void editPMNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPMNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPMNameActionPerformed

    private void txtLecNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLecNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLecNameActionPerformed

    private void butPMDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPMDeleteActionPerformed
        String selectedID = (String) cboeditPMID.getSelectedItem();

        List<String> LecturersList = new ArrayList<>();
        List<String> usersList = new ArrayList<>();
        List<String> PMList = new ArrayList<>();

        boolean PMUpdated = false;
        boolean userUpdated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\ProjectManagers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5 && data[0].equals(selectedID)) {
                    PMUpdated = true;              
                }else{PMList.add(String.join(",",data));}
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10 && data[3].equals(selectedID)) {
                    data[7] = "false";  // Update isPM
                    data[6] = "Lecturer";
                    PMUpdated = true;            
                }
                LecturersList.add(String.join(",",data));
                          
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(selectedID)) {
                    
                    data[3] = "Lecturer";  // Update type
               
                    userUpdated = true;
                }
                usersList.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (PMUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Lecturers.txt"))) {
                for (String line : LecturersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\ProjectManagers.txt"))) {
                for (String line : PMList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (userUpdated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
                for (String line : usersList) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (PMUpdated || userUpdated) {
            JOptionPane.showMessageDialog(this, "Project Manager deleted successfully.");
            loadEditPMFromFile();
            loadLecturersFromFile();
        } else {
            JOptionPane.showMessageDialog(this, "Project Manager not found or no changes made.");
        }
        loadPMFromFile();
        loadEditPMFromFile();
        loadLecturersFromFile();
    }//GEN-LAST:event_butPMDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // Create an instance of LoginMainJFrame
        LoginJFrame loginFrame = new LoginJFrame();

        // Set the new frame visible
        loginFrame.setVisible(true);

        // Dispose of the current frame
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainJFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EditLecPanel;
    private javax.swing.JPanel RegLecPanel;
    private javax.swing.JPanel RegStudPanel;
    private javax.swing.JButton butAllotPM;
    private javax.swing.JButton butEditLec;
    private javax.swing.JButton butEditStud;
    private javax.swing.JButton butPMChange;
    private javax.swing.JButton butPMDelete;
    private javax.swing.JButton butRegLec;
    private javax.swing.JButton butRegStud;
    private javax.swing.JComboBox<String> cboLecID;
    private javax.swing.JComboBox<String> cboLecPMID;
    private javax.swing.JComboBox<String> cboStudID;
    private javax.swing.JComboBox<String> cboeditPMID;
    private javax.swing.JTextField editLecNew;
    private javax.swing.JTextField editPMName;
    private javax.swing.JTextField editStudNew;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbNMale;
    private javax.swing.JRadioButton rbnEditLecName;
    private javax.swing.JRadioButton rbnEditLecNat;
    private javax.swing.ButtonGroup rbnEditStud;
    private javax.swing.JRadioButton rbnEditStudIntake;
    private javax.swing.JRadioButton rbnEditStudName;
    private javax.swing.JRadioButton rbnEditStudNat;
    private javax.swing.JRadioButton rbnFemale;
    private javax.swing.JRadioButton rbnFemale1;
    private javax.swing.JRadioButton rbnMale1;
    private javax.swing.ButtonGroup rbnManagePM;
    private javax.swing.JRadioButton rbnPMName;
    private javax.swing.JRadioButton rbnPMNo;
    private javax.swing.JRadioButton rbnPMYes;
    private javax.swing.ButtonGroup rbnregLec;
    private javax.swing.ButtonGroup rbnregStud;
    private javax.swing.ButtonGroup rdbEditLec;
    private javax.swing.JTable tblLecturer;
    private javax.swing.JTable tblManagePM;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTable tbleditPM;
    private javax.swing.JTextField txtLecAge;
    private javax.swing.JTextField txtLecName;
    private javax.swing.JTextField txtLecNat;
    private javax.swing.JPasswordField txtLecPass;
    private javax.swing.JTextField txtStudAge;
    private javax.swing.JTextField txtStudIntake;
    private javax.swing.JTextField txtStudName;
    private javax.swing.JTextField txtStudNat;
    private javax.swing.JPasswordField txtStudPass;
    // End of variables declaration//GEN-END:variables
}
