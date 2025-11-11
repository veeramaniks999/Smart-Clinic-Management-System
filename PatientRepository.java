// PatientRepository.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Handles CRUD operations for patients.

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private List<Patient> patients = new ArrayList<>();

    // Add new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added successfully: " + patient.getName());
    }

    // View all patients
    public void viewAllPatients() {
        System.out.println("\n--- Patient List ---");
        for (Patient p : patients) {
            p.displayPatientInfo();
            System.out.println("----------------------");
        }
    }

    // Find patient by ID
    public Patient findPatientById(int id) {
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                return p;
            }
        }
        System.out.println("No patient found with ID: " + id);
        return null;
    }

    // Remove patient
    public void removePatient(int id) {
        Patient toRemove = findPatientById(id);
        if (toRemove != null) {
            patients.remove(toRemove);
            System.out.println("Patient removed successfully!");
        }
    }
}
