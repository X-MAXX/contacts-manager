import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


//This class is currently running our functionality. i.e. Methods, Logic, I/O, etc//
public class Contacts {
    private List<String> allContacts;
    private String newContactName;
    private String newContactNumber;

    public void setNewContactName(String newContactName) {
        this.newContactName = newContactName;
    }

    public void setNewContactNumber(String newContactNumber) {
        this.newContactNumber = newContactNumber;
    }

    public String getNewContactName() {
        return newContactName;
    }

    public String getNewContactNumber(){
        return newContactNumber;
    }

    public List<String> getAllContacts() {
        try {
            allContacts = Files.readAllLines(Paths.get("data/", "contacts.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allContacts;
    }

    public void writeNewContact(){
        String newContact = newContactName + ", " + newContactNumber;
        try {
            Files.write(Paths.get("data/", "contacts.txt"), newContact.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
