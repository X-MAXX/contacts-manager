import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

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

    public void deleteContact(String contact)  {
        contacts.remove(contact);

        try {
            Files.write(Paths.get("data/", "contacts.txt"), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 1;
        for (Map.Entry<String, String> line : contacts.entrySet()) {
            String c = line + "\n";
            if (contacts.size() == count) {
                c = line.toString();
            }

            try {
                Files.write(Paths.get("data/", "contacts.txt"), c.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public boolean isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Not an integer");
            return false;
        }
        return Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 5;
    }
}