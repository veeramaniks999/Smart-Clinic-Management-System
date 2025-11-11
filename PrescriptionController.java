// PrescriptionController.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Manages prescription-related operations.

import java.util.ArrayList;
import java.util.List;

public class PrescriptionController {

    private List<Prescription> prescriptions = new ArrayList<>();

    // Add prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        System.out.println("Prescription added for Appointment ID: " + prescription.getAppointmentId());
    }

    // View all prescriptions
    public void viewAllPrescriptions() {
        System.out.println("\n--- All Prescriptions ---");
        for (Prescription p : prescriptions) {
            p.displayPrescription();
            System.out.println("----------------------");
        }
    }

    // Find prescription by appointment ID
    public Prescription findByAppointmentId(int appointmentId) {
        for (Prescription p : prescriptions) {
            if (p.getAppointmentId() == appointmentId) {
                return p;
            }
        }
        System.out.println("No prescription found for Appointment ID: " + appointmentId);
        return null;
    }
}
