import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Class DOES contain methods. But methods are only superficial and used to display app to user//
public class Menu extends Contacts {

    Scanner scan = new Scanner(System.in);

    public void showMenu() {
        setContacts();
        System.out.println("1. View Contacts");
        System.out.println("2. Add New Contact");
        System.out.println("3. Search Contact By Name");
        System.out.println("4. Delete Existing Contact");
        System.out.println("5. Exit");
        System.out.print("Enter an option (1, 2, 3, 4, 5): ");
    }

    public void viewContacts() {
        HashMap<String, String> all = getContacts();

        for (Map.Entry<String, String> contact : all.entrySet()) {
            System.out.printf("Name: %-15s | Phone Number: %-10s%n", contact.getKey(), contact.getValue());
        }
    }

    public void addNewContact() {
        System.out.print("Enter a new name: ");
        setNewContactName(scan.nextLine());
        System.out.print("Enter a new contact number: ");
        setNewContactNumber(scan.nextLine());
        writeNewContact();
    }

    public void searchContactByName() {
        System.out.print("Enter the name of the contact you want to search: ");
        System.out.println(searchContact(scan.nextLine()));
    }

    public void deleteExistingContact(){
        System.out.print("Enter the name of the contact you would like to delete: ");
        deleteContact(scan.nextLine());
    }
}
