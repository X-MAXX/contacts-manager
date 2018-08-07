import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Contacts {
    private List<String> allContacts;

    public List<String> getAllContacts() {
        try {
            allContacts = Files.readAllLines(Paths.get("data/", "contacts.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allContacts;
    }
}
