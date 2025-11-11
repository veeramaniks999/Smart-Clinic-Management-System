package com.smartclinic.controller;

import com.smartclinic.model.Prescription;
import com.smartclinic.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // ✅ POST method to save a prescription
    @PostMapping("/{token}")
    public ResponseEntity<String> savePrescription(
            @PathVariable("token") String token,
            @RequestBody Prescription prescription) {

        // Example token validation (optional)
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid or missing token.");
        }

        // Save prescription using service
        prescriptionService.savePrescription(prescription);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Prescription saved successfully for token: " + token);
    }

    // ✅ GET method to retrieve all prescriptions
    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return ResponseEntity.ok(prescriptions);
    }
}
