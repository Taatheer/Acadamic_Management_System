package AGH;
/**
 *
 * @author Taatheer
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Report {
    
    private String reportID;
    private String studentName;
    private String studentId;
    private String intake;
    private String assessmentType;
    private Date submissionDate;
    private String moodleLink;
    private String status;
    private String Supervisor;
    private String SM;

    
    // Constructor
    public Report(String reportID, String studentName,String studentID,String intake, String assessmentType, Date submissionDate, String moodleLink, String status, String Supervisor, String SM) {
        this.reportID = reportID;
        this.studentName = studentName;
        this.studentId = studentID;
        this.intake = intake;
        this.assessmentType = assessmentType;
        this.submissionDate = submissionDate;
        this.moodleLink = moodleLink;
        this.status = status;
        this.Supervisor = Supervisor;
        this.SM = SM;

    }

    public String getSupervisor() {
        return Supervisor;
    }

    public String getReportID() {
        return reportID;
    }

    public String getIntake() {
        return intake;
    }
    
    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public String getMoodleLink() {
        return moodleLink;
    }

    public String getStatus() {
        return status;
    }


    public String setReportID(){
        this.reportID = generateUniqueReportID();  
        return reportID;
    }
    
    private String generateUniqueReportID() {
        Random random = new Random();
        String newReportID;
        Set<String> existingIDs = getExistingReportIDs();

        do {
            int randomNum = random.nextInt(9000) + 1000; // Generate a random 4-digit number
            newReportID = "R" + randomNum;
        } while (existingIDs.contains(newReportID));

        return newReportID;
    }
    
    private Set<String> getExistingReportIDs() {
        Set<String> existingIDs = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Reports.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    existingIDs.add(parts[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return existingIDs;
    }

    public String getSM() {
        return SM;
    }

    @Override
    public String toString() {
        return "Report{" + "reportID=" + reportID + ", studentName=" + studentName + ", studentId=" + studentId + ", intake=" + intake + ", assessmentType=" + assessmentType + ", submissionDate=" + submissionDate + ", moodleLink=" + moodleLink + ", status=" + status + ", Supervisor=" + Supervisor + ", SM=" + SM + '}';
    }



    
    
    
    
}