package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // ✅ Retrieve a patient by email address
    Patient findByEmail(String email);

    // ✅ Retrieve a patient by phone number
    Patient findByPhoneNumber(String phoneNumber);
}
