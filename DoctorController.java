package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ✅ Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // ✅ Get doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // ✅ Add a new doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // ✅ Retrieve doctor availability by ID and date
    @GetMapping("/{id}/availability")
    public List<String> getDoctorAvailability(
            @PathVariable Long id,
            @RequestParam("date") String date,
            @RequestHeader(value = "Authorization", required = false) String token
    ) {
        // 🩺 (Simulated token check - optional)
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Unauthorized access: missing token");
        }

        LocalDate localDate = LocalDate.parse(date);
        return doctorService.getAvailableTimesByDate(id, localDate);
    }
}
