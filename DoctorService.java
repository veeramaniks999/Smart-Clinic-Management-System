package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final List<Doctor> doctors = new ArrayList<>();

    // ✅ Add a new doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // ✅ View all doctors
    public List<Doctor> viewAllDoctors() {
        return doctors;
    }

    // ✅ Find a doctor by ID
    public Doctor findDoctorById(Long id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    // ✅ Delete a doctor by ID
    public boolean deleteDoctor(Long id) {
        return doctors.removeIf(doctor -> doctor.getId().equals(id));
    }

    // ✅ Retrieve doctor's availability by ID and date
    public List<String> getDoctorAvailability(Long doctorId, LocalDate date) {
        Doctor doctor = findDoctorById(doctorId);
        if (doctor != null && doctor.getAvailableTimes() != null) {
            // For simplicity, assume the same availability applies to any date
            return doctor.getAvailableTimes();
        }
        return new ArrayList<>();
    }

    // ✅ Validate login credentials
    public Doctor validateDoctorLogin(String email, String password) {
        for (Doctor doctor : doctors) {
            if (doctor.getEmail().equalsIgnoreCase(email)
                    && doctor.getPassword().equals(password)) {
                return doctor;
            }
        }
        return null; // Invalid credentials
    }
}
