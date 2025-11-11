package com.smartclinic.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ✅ Primary key

    @ManyToOne
    @JoinColumn(name = "doctor_id")  // ✅ Foreign key reference to Doctor
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id") // ✅ Foreign key reference to Patient
    private Patient patient;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;

    // Constructors
    public Appointment() {}

    public Appointment(Doctor doctor, Patient patient, LocalDate appointmentDate, LocalTime appointmentTime, String status) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = pat
