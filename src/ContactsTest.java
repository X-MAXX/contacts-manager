import java.util.Scanner;

public class ContactsTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        String option;

        do {
            menu.showMenu();
            option = input.nextLine();

            while (!menu.isInt(option)) {
                System.out.print("Enter a valid choice (1 - 5): ");
                option = input.nextLine();
            }

            switch (option) {
                case "1":
                    menu.viewContacts();
                    break;

                case "2":
                    menu.addNewContact();
                    break;

                case "3":
                    menu.searchContactByName();
                    break;

                case "4":
                    menu.deleteExistingContact();
                    break;

                case "5":
                    break;
            }
        } while (!option.equals("5"));
    }
}
