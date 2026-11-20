
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import service.*;

class HospitalGUI extends JFrame implements ActionListener {

    JButton registerButton, doctorButton, exitButton;
    JLabel messageLabel;

    Hospital hospital;

    HospitalGUI() {

        setTitle("Hospital Token Booking System");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        hospital = new Hospital();

        try {
            hospital.addDoctor(new Doctor(1, "Arun Kumar", 45,
                    "9876543210", "Cardiology"));

            hospital.addDoctor(new Doctor(2, "Meena Devi", 40,
                    "9876543211", "Pediatrics"));

            hospital.addDoctor(new Doctor(3, "Ravi Shankar", 42,
                    "9876543212", "Orthopedics"));

            hospital.addDoctor(new Doctor(4, "Lakshmi Priya", 38,
                    "9876543213", "General Medicine"));

        } catch (HospitalException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        JLabel title = new JLabel("Hospital Management System");

        registerButton = new JButton("Register Patient");
        doctorButton = new JButton("View Doctors");
        exitButton = new JButton("Exit");

        messageLabel = new JLabel("Choose an option");

        registerButton.addActionListener(this);
        doctorButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(title);
        add(registerButton);
        add(doctorButton);
        add(exitButton);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {

            try {
                String idText = JOptionPane.showInputDialog(
                        this, "Enter Patient ID:");

                if (idText == null) return;

                int id = Integer.parseInt(idText);

                String name = JOptionPane.showInputDialog(
                        this, "Enter Patient Name:");

                if (name == null) return;

                String ageText = JOptionPane.showInputDialog(
                        this, "Enter Patient Age:");

                if (ageText == null) return;

                int age = Integer.parseInt(ageText);

                String contact = JOptionPane.showInputDialog(
                        this, "Enter 10-digit Contact Number:");

                if (contact == null) return;

                Patient p = new Patient(id, name, age, contact);

                hospital.registerPatient(p);

                FileManager.savePatient(p);

                HospitalLogger.log(
                        "Patient registered through GUI: " + name);

                JOptionPane.showMessageDialog(
                        this, "Patient registered successfully!");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this, "Enter valid numeric ID and age.");

            } catch (HospitalException ex) {

                JOptionPane.showMessageDialog(
                        this, ex.getMessage());
            }
        }

        else if (e.getSource() == doctorButton) {

            hospital.displayDoctors();

            messageLabel.setText(
                    "Doctor details displayed in console.");
        }

        else if (e.getSource() == exitButton) {

            dispose();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new HospitalGUI());
    }
}
