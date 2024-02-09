import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<ContactKey, String> contacts = new HashMap<>();
        ContactKey obj;

        String filePath = "C:/Users/Mohamed Rilwan/Desktop/Java-Assignments/assignment3/contacts.csv";

        try (Scanner scanner = new Scanner(new File(filePath))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                obj = new ContactKey(fields[0], fields[1]);
                contacts.put(obj, fields[2]);
            }

            System.out.println("\nWelcome to My Phone Book");
            System.out.println("-------------------------");
            System.out.println("\nInstructions:");
            System.out.println("F:(First Name prefix) L:(Last Name prefix) Q:(Exit)\n");

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Command : ");
                String userInput = input.nextLine().trim();

                // Check for exit command
                if (userInput.equalsIgnoreCase("Q")) {
                    System.out.println("Exiting...");
                    break;
                }

                // Process the input based on the specified prefixes
                if (userInput.startsWith("F:")) {
                    String firstName = userInput.substring(2); // Extract the first name
                    // System.out.println("First Name: " + firstName);
                    // Search and display phone number for the first name
                    searchAndDisplay(firstName,contacts);
                    
                } else if (userInput.startsWith("L:")) {
                    String lastName = userInput.substring(2); // Extract the last name
                    System.out.println("Last Name: " + lastName);
                    // Search and display phone number for the last name
                    searchAndDisplay(lastName,contacts);
                } else {
                    System.out.println("Invalid command. Please use F: or L: prefixes.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


    public static void searchAndDisplay(String userInput, Map<ContactKey,String> contacts){


        for(Map.Entry<ContactKey,String> entry : contacts.entrySet()){

            if(userInput.equals(entry.getKey().fName))
                System.out.println("First Name: "+ userInput + "\tPhone Number: "+ entry.getValue());
            else if (userInput.equals(entry.getKey().lName))
                System.out.println("Last Name: "+ userInput + "\tPhone Number: "+ entry.getValue());

        }

    }
}
