import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Class DOES contain methods. But methods are only superficial and used to display app to user//
public class Menu extends Contacts {

    Scanner scan = new Scanner(System.in);

    public void showMenu() {
        System.out.println("1. View Contacts");
        System.out.println("2. Add New Contact");
        System.out.println("3. Search Contact By Name");
        System.out.println("4. Delete Existing Contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, 5)");
    }

    public void viewContacts() {
        HashMap<String, String> all = getContacts();

        for (Map.Entry<String, String> contact : all.entrySet()) {
            System.out.printf("Name: %s | Phone Number: %s\n", contact.getKey(), contact.getValue());
        }
    }

    public void addNewContact() {
        System.out.println("Enter a new name");
        setNewContactName(scan.nextLine());
        System.out.println("Enter a new contact number");
        setNewContactNumber(scan.nextLine());

        writeNewContact();
    }

    public void searchContactByName() {
        //setContacts();
        System.out.println("Enter the name of the contact you want to search");
        System.out.println(searchContact(scan.nextLine()));
    }

    public void deleteExistingContact(){
        setContacts();
        System.out.println("Enter the name of the contact you would like to |DELETE|");
        deleteContact(scan.nextLine());

    }
}
