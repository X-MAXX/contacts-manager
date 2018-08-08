import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

//This class is currently running our functionality. i.e. Methods, Logic, I/O, etc//
public class Contacts {
    private HashMap<String, String> contacts = new HashMap<>();
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

    public void setContacts() {
        try {
            for (String line : Files.readAllLines(Paths.get("data/", "contacts.txt"))) {
                String[] contact = line.split("=");
                contacts.put(contact[0], contact[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getContacts() {
        return contacts;
    }

    public void writeNewContact(){
        String newContact = "\n" + newContactName + "=" + newContactNumber;
        try {
            Files.write(Paths.get("data/", "contacts.txt"), newContact.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String searchContact(String contact) {
        if (contacts.containsKey(contact)) {
            return "Name " + contact + " | Phone Number: " + contacts.get(contact);
        }
        return "Not found";
    }
}
