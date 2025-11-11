# Smart Clinic Management System - Database Schema

## Overview
This schema defines the structure of the Smart Clinic Management System database, used to manage doctors, patients, appointments, and billing.

---

## 🧑‍⚕️ Doctor Table
| Field Name | Data Type | Description |
|-------------|------------|--------------|
| doctor_id | INT (Primary Key, Auto Increment) | Unique ID for each doctor |
| name | VARCHAR(100) | Doctor’s full name |
| specialization | VARCHAR(100) | Field of specialization |
| email | VARCHAR(100) | Contact email |
| phone | VARCHAR(15) | Contact number |

---

## 👨‍💼 Patient Table
| Field Name | Data Type | Description |
|-------------|------------|--------------|
| patient_id | INT (Primary Key, Auto Increment) | Unique ID for each patient |
| name | VARCHAR(100) | Patient’s full name |
| age | INT | Age of the patient |
| gender | VARCHAR(10) | Gender of the patient |
| contact | VARCHAR(15) | Contact number |
| address | VARCHAR(200) | Residential address |

---

## 📅 Appointment Table
| Field Name | Data Type | Description |
|-------------|------------|--------------|
| appointment_id | INT (Primary Key, Auto Increment) | Unique appointment ID |
| patient_id | INT (Foreign Key → Patient.patient_id) | Patient reference |
| doctor_id | INT (Foreign Key → Doctor.doctor_id) | Doctor reference |
| date | DATE | Appointment date |
| time | TIME | Appointment time |
| status | VARCHAR(20) | Appointment status (Scheduled, Completed, Cancelled) |

---

## 💊 Prescription Table
| Field Name | Data Type | Description |
|-------------|------------|--------------|
| prescription_id | INT (Primary Key, Auto Increment) | Unique prescription ID |
| appointment_id | INT (Foreign Key → Appointment.appointment_id) | Appointment reference |
| medicine_name | VARCHAR(100) | Name of the prescribed medicine |
| dosage | VARCHAR(50) | Dosage instructions |
| duration | VARCHAR(50) | Duration for medication |

---

## 💰 Billing Table
| Field Name | Data Type | Description |
|-------------|------------|--------------|
| bill_id | INT (Primary Key, Auto Increment) | Unique billing ID |
| appointment_id | INT (Foreign Key → Appointment.appointment_id) | Appointment reference |
| total_amount | DECIMAL(10,2) | Total bill amount |
| payment_status | VARCHAR(20) | Payment status (Paid, Pending) |

---

## 🔗 Relationships
- One doctor can have many appointments.  
- One patient can have many appointments.  
- One appointment can have one prescription and one bill.

---

**Author:** *Your Name*  
**Course:** Project: Building a Smart Clinic Management System  
