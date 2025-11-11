// DoctorService.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Provides business logic for managing doctors.

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<Doctor> doctorList = new ArrayList<>();

    // Add doctor
    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        System.out.println("Doctor added successfully: " + doctor.getName());
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    // Find doctor by ID
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId() == id) {
                return doctor;
            }
        }
        System.out.println("Doctor not found with ID: " + id);
        return null;
    }

    // Update doctor details
    public void updateDoctorEmail(int id, String newEmail) {
        Doctor doctor = getDoctorById(id);
        if (doctor != null) {
            doctor.setEmail(newEmail);
            System.out.println("Doctor email updated successfully!");
        }
    }

    // Delete doctor
    public void deleteDoctor(int id) {
        Doctor doctor = getDoctorById(id);
        if (doctor != null) {
            doctorList.remove(doctor);
            System.out.println("Doctor deleted successfully!");
        }
    }
}
