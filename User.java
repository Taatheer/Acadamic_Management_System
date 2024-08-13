package AGH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Taatheer
 */
public class User {
    private String ID;
    private String Name;
    private String Pass;
    private String Type;


    public User(String ID, String Name, String Pass, String Type) {
        this.ID = ID;
        this.Name = Name;
        this.Pass = Pass;
        this.Type = Type;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getPass() {
        return Pass;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", Name=" + Name + ", Pass=" + Pass + "Type=" + Type + '}';
    }
    
    public String setID(){
        this.ID = generateUniqueID();  
        return ID;
    }
    
    private String generateUniqueID() {
        Random random = new Random();
        String newID = null;
        Set<String> existingIDs = getExistingIDs();

        do {
            int randomNum = random.nextInt(9000) + 1000; // Generate a random 4-digit number
            if(Type == "Student"){
                newID = "S" + randomNum;
            }else{ 
                if(Type == "Lecturer"){
                    newID = "L" + randomNum;
                }
            }    
        } while (existingIDs.contains(newID));

        return newID;
    }
    
    private Set<String> getExistingIDs() {
        Set<String> existingIDs = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Taatheer\\Documents\\NetBeansProjects\\Assignment\\src\\AGH\\Users.txt"))) {
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
}
