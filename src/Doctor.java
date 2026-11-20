
class Doctor extends Person {

    private String department;

    public Doctor(int id, String name, int age,
                  String contact, String department)
            throws HospitalException {

        super(id, name, age, contact);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void displayDetails() {
        System.out.printf(
            "%-6d %-22s %-18s%n",
            getId(), getName(), department
        );
    }
}
