
class Hospital implements Bookable {

    // Maximum limits
    public static final int MAX_PATIENTS = 20;
    public static final int MAX_DOCTORS = 5;
    public static final int MAX_TOKENS = 30;
    public static final int MAX_ACTIVE_PER_DOCTOR = 5;

    // Arrays to store objects
    private Patient[] patients = new Patient[MAX_PATIENTS];
    private Doctor[] doctors = new Doctor[MAX_DOCTORS];
    private Token[] tokens = new Token[MAX_TOKENS];

    // Counters
    private int patientCount = 0;
    private int doctorCount = 0;
    private int tokenCount = 0;

    // Token numbering
    private int nextTokenNumber = 1001;

    // Separate token sequence for each doctor
    private int[] doctorSequence = new int[MAX_DOCTORS];


    // ---------------- DOCTOR METHODS ----------------

    public void addDoctor(Doctor d) throws HospitalException {

        if (doctorCount >= MAX_DOCTORS) {
            throw new HospitalException("Doctor list is full.");
        }

        doctors[doctorCount++] = d;
    }


    public void displayDoctors() {

        System.out.println("\n--- Available Doctors ---");

        System.out.printf("%-6s %-22s %-18s%n",
                "ID", "Name", "Department");

        for (int i = 0; i < doctorCount; i++) {

            Person p = doctors[i];
            p.displayDetails();
        }
    }


    public Doctor findDoctor(int id) throws HospitalException {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].getId() == id) {
                return doctors[i];
            }
        }

        throw new HospitalException("Invalid doctor ID: " + id);
    }


    // ---------------- PATIENT METHODS ----------------

    public void registerPatient(Patient p) throws HospitalException {

        if (patientCount >= MAX_PATIENTS) {
            throw new HospitalException(
                    "Patient capacity reached. Cannot register more.");
        }

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId() == p.getId()) {
                throw new HospitalException(
                        "Duplicate patient ID: " + p.getId());
            }
        }

        patients[patientCount++] = p;
    }


    public boolean patientExists(int id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId() == id) {
                return true;
            }
        }

        return false;
    }


    public Patient findPatient(int id) throws HospitalException {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId() == id) {
                return patients[i];
            }
        }

        throw new HospitalException(
                "Patient not registered: ID " + id);
    }


    public void displayPatients() {

        if (patientCount == 0) {
            System.out.println("\nNo patients registered yet.");
            return;
        }

        System.out.println("\n--- Registered Patients ---");

        System.out.printf("%-6s %-22s %-5s %-12s%n",
                "ID", "Name", "Age", "Contact");

        for (int i = 0; i < patientCount; i++) {

            Person p = patients[i];
            p.displayDetails();
        }
    }


    // ---------------- TOKEN BOOKING ----------------

    @Override
    public Token bookToken(int patientId, int doctorId)
            throws HospitalException {

        // Find patient and doctor
        Patient patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        // Check total token capacity
        if (tokenCount >= MAX_TOKENS) {
            throw new HospitalException(
                    "Hospital token capacity reached.");
        }

        // Check doctor's active booking limit
        if (activeTokensForDoctor(doctor) >= MAX_ACTIVE_PER_DOCTOR) {

            throw new HospitalException(
                    "Dr. " + doctor.getName()
                    + " is fully booked.");
        }

        // Find doctor's array position
        int doctorIndex = 0;

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] == doctor) {
                doctorIndex = i;
                break;
            }
        }

        // Increase that doctor's token sequence
        doctorSequence[doctorIndex]++;

        // Create a new token
        Token t = new Token(
                nextTokenNumber++,
                doctorSequence[doctorIndex],
                patient,
                doctor);

        // Store token
        tokens[tokenCount++] = t;

        return t;
    }


    // ---------------- CANCEL TOKEN ----------------

    @Override
    public void cancelToken(int tokenNumber)
            throws HospitalException {

        Token t = findToken(tokenNumber);

        if (!t.isActive()) {
            throw new HospitalException(
                    "Token " + tokenNumber + " is already cancelled.");
        }

        t.cancel();
    }


    // Count active tokens for a particular doctor
    private int activeTokensForDoctor(Doctor doctor) {

        int count = 0;

        for (int i = 0; i < tokenCount; i++) {

            if (tokens[i].isActive()
                    && tokens[i].getDoctor() == doctor) {

                count++;
            }
        }

        return count;
    }


    // ---------------- SEARCH TOKEN ----------------

    public Token findToken(int tokenNumber)
            throws HospitalException {

        for (int i = 0; i < tokenCount; i++) {

            if (tokens[i].getTokenNumber() == tokenNumber) {
                return tokens[i];
            }
        }

        throw new HospitalException(
                "Token not found: " + tokenNumber);
    }


    // ---------------- DISPLAY ACTIVE TOKENS ----------------

    public void displayActiveTokens() {

        int shown = 0;

        System.out.println("\n--- Active Tokens ---");

        for (int i = 0; i < tokenCount; i++) {

            if (tokens[i].isActive()) {

                tokens[i].display();

                System.out.println();

                shown++;
            }
        }

        if (shown == 0) {
            System.out.println("No active tokens.");
        }
    }
}
