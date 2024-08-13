
package AGH;

/**
 *
 * @author Taatheer
 */
public class Student extends User {
    private String StudNat;
    private String StudGen;
    private String StudIntake;
    private Integer StudAge;
    private String AssessType;
    private String Supervisor;
    private String SecMarker;
    

    public Student(String StudNat, String StudGen, String StudIntake, Integer StudAge, String ID, String Name, String Pass, String Type, String AssessType, String Supervisor, String SecMarker) {
        super(ID, Name, Pass, Type);
        this.StudNat = StudNat;
        this.StudGen = StudGen;
        this.StudIntake = StudIntake;
        this.StudAge = StudAge;
        this.AssessType = AssessType;
        this.Supervisor = Supervisor;
        this.SecMarker = SecMarker;
    }

    public String getStudNat() {
        return StudNat;
    }

    public String getStudGen() {
        return StudGen;
    }

    public String getStudIntake() {
        return StudIntake;
    }

    public Integer getStudAge() {
        return StudAge;
    }

    public String getAssessType() {
        return AssessType;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public String getSecMarker() {
        return SecMarker;
    }

    @Override
    public String toString() {
        return "Student{" + "StudNat=" + StudNat + ", StudGen=" + StudGen + ", StudIntake=" + StudIntake + ", StudAge=" + StudAge + ", AssessType=" + AssessType + ", Supervisor=" + Supervisor + ", SecMarker=" + SecMarker + '}';
    }
    
    
    
    
}
