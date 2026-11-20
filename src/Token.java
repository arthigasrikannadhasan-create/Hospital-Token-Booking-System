
class Token {

    private int tokenNumber;
    private int doctorSequence;
    private Patient patient;
    private Doctor doctor;
    private boolean active;

    // Constructor
    public Token(int tokenNumber, int doctorSequence,
                 Patient patient, Doctor doctor) {

        this.tokenNumber = tokenNumber;
        this.doctorSequence = doctorSequence;
        this.patient = patient;
        this.doctor = doctor;
        this.active = true;
    }

    // Getters
    public int getTokenNumber() {
        return tokenNumber;
    }

    public int getDoctorSequence() {
        return doctorSequence;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public boolean isActive() {
        return active;
    }

    // Cancel token
    public void cancel() {
        this.active = false;
    }

    // Display token details
    public void display() {

        System.out.println("Token Number : " + tokenNumber
                + " (No. " + doctorSequence
                + " for " + doctor.getName() + ")");

        System.out.println("Patient : " + patient.getName()
                + " (ID " + patient.getId() + ")");

        System.out.println("Doctor : " + doctor.getName());

        System.out.println("Department : "
                + doctor.getDepartment());

        System.out.println("Status : "
                + (active ? "ACTIVE" : "CANCELLED"));
    }
}
