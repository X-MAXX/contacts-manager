import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.ArrayList;
import java.util.List;

public class ReadContacts {

    public static void main(String[] args) {

        try {
            List<String> contents = Files.readAllLines(Paths.get("data/", "contacts.txt"));
            System.out.println(contents.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
