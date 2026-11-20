package service;
import model.Patient;
import java.io.*;

public class FileManager {

    private static final String FILE_NAME = "patients.txt";

    // Save patient details
    public static void savePatient(Patient p) {

        try (FileWriter writer =
                new FileWriter(FILE_NAME, true)) {

            writer.write(
                p.getId() + "," +
                p.getName() + "," +
                p.getAge() + "," +
                p.getContact() +
                System.lineSeparator()
            );

            System.out.println("Patient record saved to file.");

        } catch (IOException e) {
            System.out.println("File writing error: "
                    + e.getMessage());
        }
    }

    // Display saved patient records
   
public static void displaySavedPatients() {
    try (BufferedReader reader =
            new BufferedReader(new FileReader(FILE_NAME))) {

        String line;

        System.out.println("\n--- Saved Patient Records ---");

        while ((line = reader.readLine()) != null) {

            String[] details = line.split(",");

            if (details.length == 4) {
                System.out.println("Patient ID: " + details[0]);
                System.out.println("Name: " + details[1]);
                System.out.println("Age: " + details[2]);
                System.out.println("Contact: " + details[3]);
                System.out.println("----------------------");
            }
        }

    } catch (FileNotFoundException e) {
        System.out.println("No saved patient records found.");
    } catch (IOException e) {
        System.out.println("File reading error: " + e.getMessage());
    }
}

}
