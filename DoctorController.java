// DoctorController.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Controls doctor-related operations like add, view, and remove.

import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    private List<Doctor> doctors = new ArrayList<>();

    // Add a new doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added successfully: " + doctor.getName());
    }

    // View all doctors
    public void viewDoctors() {
        System.out.println("\n--- List of Doctors ---");
        for (Doctor doctor : doctors) {
            doctor.displayDoctorInfo();
            System.out.println("----------------------");
        }
    }

    // Find a doctor by ID
    public Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == id) {
                return doctor;
            }
        }
        System.out.println("Doctor not found with ID: " + id);
        return null;
    }

    // Remove doctor by ID
    public void removeDoctor(int id) {
        Doctor toRemove = findDoctorById(id);
        if (toRemove != null) {
            doctors.remove(toRemove);
            System.out.println("Doctor removed successfully.");
        }
    }
}
