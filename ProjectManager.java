package AGH;

/**
 *
 * @author Taatheer
 */
public class ProjectManager extends User{
    
    private boolean isPM; 
    public ProjectManager(String ID, String Name, String Pass, String Type, boolean isPM) {
        super(ID, Name, Pass, Type);
        isPM = this.isPM;
    }

    public boolean isIsPM() {
        return isPM;
    }

    @Override
    public String toString() {
        return "ProjectManager{" + "isPM=" + isPM + '}';
    }
   
}
