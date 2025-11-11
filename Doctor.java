// Doctor.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Represents a Doctor entity with attributes and methods.

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String email;
    private String phone;

    // Default constructor
    public Doctor() {
    }

    // Parameterized constructor
    public Doctor(int doctorId, String name, String specialization, String email, String phone) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Display doctor details
    public void displayDoctorInfo() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}
