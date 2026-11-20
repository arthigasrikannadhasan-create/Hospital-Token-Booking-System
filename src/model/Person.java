package model;
public abstract class Person {

    // Private variables (Encapsulation)
    private int id;
    private String name;
    private int age;
    private String contact;

    // Parameterized constructor
    public Person(int id, String name, int age, String contact)
            throws HospitalException {

        setId(id);
        setName(name);
        setAge(age);
        setContact(contact);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    // Setters with validation
    public void setId(int id) throws HospitalException {
        if (id <= 0) {
            throw new HospitalException("ID must be positive.");
        }
        this.id = id;
    }

    public void setName(String name) throws HospitalException {
        if (name == null || name.trim().isEmpty()) {
            throw new HospitalException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setAge(int age) throws HospitalException {
        if (age < 1 || age > 120) {
            throw new HospitalException("Invalid age.");
        }
        this.age = age;
    }

    public void setContact(String contact)
            throws HospitalException {

        if (contact == null || !contact.matches("\\d{10}")) {
            throw new HospitalException(
                "Contact must contain exactly 10 digits."
            );
        }
        this.contact = contact;
    }

    // Abstract methods
    public abstract String getRole();

    public abstract void displayDetails();

    // Overriding toString()
    @Override
    public String toString() {
        return getRole() + " [ID=" + id
                + ", Name=" + name + "]";
    }
}
