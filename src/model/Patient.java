package model;
public class Patient extends Person {

    public Patient(int id, String name, int age, String contact)
            throws HospitalException {

        super(id, name, age, contact);
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public void displayDetails() {
        System.out.printf(
            "%-6d %-22s %-5d %-12s%n",
            getId(), getName(), getAge(), getContact()
        );
    }
}
