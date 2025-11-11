// AppointmentService.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Handles appointment-related operations and logic.

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    // Add appointment
    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully for Doctor ID: " + appointment.getDoctorId());
    }

    // View all appointments
    public void viewAllAppointments() {
        System.out.println("\n--- All Appointments ---");
        for (Appointment appt : appointments) {
            appt.displayAppointmentDetails();
            System.out.println("----------------------");
        }
    }

    // Find appointment by ID
    public Appointment findAppointmentById(int id) {
        for (Appointment appt : appointments) {
            if (appt.getAppointmentId() == id) {
                return appt;
            }
        }
        System.out.println("No appointment found with ID: " + id);
        return null;
    }

    // Cancel appointment
    public void cancelAppointment(int id) {
        Appointment appt = findAppointmentById(id);
        if (appt != null) {
            appt.setStatus("Cancelled");
            System.out.println("Appointment cancelled successfully!");
        }
    }
}
