import java.util.List;

public class Menu extends Contacts {
    public void showMenu() {
        System.out.println("1. View Contacts");
        System.out.println("2. Add New Contact");
        System.out.println("3. Search Contact By Name");
        System.out.println("4. Delete Existing Contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, 5)");
    }

    public void viewContacts() {
        List<String> contacts = getAllContacts();
        System.out.println(contacts.toString());
    }
}
