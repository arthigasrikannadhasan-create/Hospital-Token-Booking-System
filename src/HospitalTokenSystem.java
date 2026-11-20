
import java.util.Scanner;
import model.*;
import service.*;
public class HospitalTokenSystem {

    static Scanner sc = new Scanner(System.in);

    // Read integer safely
    static int readInt(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Read text
    static String readText(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }


    // Register patient
    static void registerPatient(Hospital hospital) {

        try {
            int id = readInt("Enter Patient ID: ");
            String name = readText("Enter Name: ");
            int age = readInt("Enter Age: ");
            String contact = readText("Enter Contact: ");

            Patient p = new Patient(id, name, age, contact);

            hospital.registerPatient(p);
            
            FileManager.savePatient(p);
            HospitalLogger.log("Patient registered: " + p.getName());

            System.out.println("Patient registered successfully!");

        } catch (HospitalException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Search patient
    static void searchPatient(Hospital hospital) {

        try {
            int id = readInt("Enter Patient ID: ");

            Patient p = hospital.findPatient(id);

            System.out.println("\nPatient Found:");
            p.displayDetails();

        } catch (HospitalException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Book token
    static void bookToken(Hospital hospital) {

        try {
            int patientId = readInt("Enter Patient ID: ");
            int doctorId = readInt("Enter Doctor ID: ");

            Token t = hospital.bookToken(patientId, doctorId);

            System.out.println("\nToken booked successfully!");
            t.display();

        } catch (HospitalException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Search token
    static void searchToken(Hospital hospital) {

        try {
            int tokenNumber = readInt("Enter Token Number: ");

            Token t = hospital.findToken(tokenNumber);

            System.out.println("\nToken Details:");
            t.display();

        } catch (HospitalException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Cancel token
    static void cancelToken(Hospital hospital) {

        try {
            int tokenNumber = readInt("Enter Token Number: ");

            hospital.cancelToken(tokenNumber);

            System.out.println("Token cancelled successfully!");

        } catch (HospitalException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

static void viewSavedPatients() {
    FileManager.displaySavedPatients();
}
    // Main method
    public static void main(String[] args) {

        Hospital hospital = new Hospital();
TokenMonitor monitor = new TokenMonitor(hospital);
monitor.start();
        // Add sample doctors
        try {
            hospital.addDoctor(new Doctor(
                    1, "Arun Kumar", 45, "9000000001", "Cardiology"));

            hospital.addDoctor(new Doctor(
                    2, "Meena Devi", 38, "9000000002", "Pediatrics"));

            hospital.addDoctor(new Doctor(
                    3, "Ravi Shankar", 50, "9000000003", "Orthopedics"));

            hospital.addDoctor(new Doctor(
                    4, "Lakshmi Priya", 42, "9000000004", "General Medicine"));

        } catch (HospitalException e) {
            System.out.println(e.getMessage());
        }


        // Menu
        while (true) {

            System.out.println("\n================================");
            System.out.println(" HOSPITAL TOKEN BOOKING SYSTEM");
            System.out.println("================================");

            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Hospital Token");
            System.out.println("6. View All Active Tokens");
            System.out.println("7. Search Token");
            System.out.println("8. Cancel Token");
            System.out.println("9. Exit");
System.out.println("10. View Saved Patient Records");
            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient(hospital);
                    break;

                case 2:
                    hospital.displayPatients();
                    break;

                case 3:
                    searchPatient(hospital);
                    break;

                case 4:
                    hospital.displayDoctors();
                    break;

                case 5:
                    bookToken(hospital);
                    break;

                case 6:
                    hospital.displayActiveTokens();
                    break;

                case 7:
                    searchToken(hospital);
                    break;

                case 8:
                    cancelToken(hospital);
                    break;

                case 9:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;
                    case 10:
    viewSavedPatients();
    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
