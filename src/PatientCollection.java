
import java.util.ArrayList;
import model.Patient;
import java.util.ArrayList;
public class PatientCollection {

    private ArrayList<Patient> patientList =
            new ArrayList<>();

    // Add patient
    public void addPatient(Patient p) {
        patientList.add(p);
        System.out.println("Patient added to collection.");
    }

    // Display patients
    public void displayPatients() {

        if (patientList.isEmpty()) {
            System.out.println("No patients in collection.");
            return;
        }

        System.out.println("\n--- Patient Collection ---");

        for (Patient p : patientList) {
            p.displayDetails();
        }
    }

    // Search patient
    public Patient searchPatient(int id) {

        for (Patient p : patientList) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    // Get collection size
    public int getCount() {
        return patientList.size();
    }
}
