package AGH;

/**
 *
 * @author Taatheer
 */

public class Lecturer extends User{

    private String LecNat;
    private String LecGen;
    private int LecAge;
    private boolean isPM;
    private boolean isSupervisor;
    private boolean isSM;
 
    public Lecturer(String LecNat, String LecGen, int LecAge, String ID, String Name,String Pass, String Type, boolean isPM, boolean isSupervisor, boolean isSM) {
        super(ID, Name, Pass, Type);
        
        this.LecNat = LecNat;
        this.LecGen = LecGen;
        this.LecAge = LecAge;
        this.isPM = isPM;
        this.isSupervisor = isSupervisor;
        this.isSM = isSM;
        
    }

    public String getLecNat() {
        return LecNat;
    }

    public String getLecGen() {
        return LecGen;
    }

    public int getLecAge() {
        return LecAge;
    }

    public boolean getIsPM() {
        return isPM;
    }

    public boolean getisSupervisor() {
        return isSupervisor;
    }

    public boolean getisSM() {
        return isSM;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "LecNat=" + LecNat + ", LecGen=" + LecGen + ", LecAge=" + LecAge + ", isPM=" + isPM + ", isSupervisor=" + isSupervisor + ", isSM=" + isSM + '}';
    }

    
 
 
}
