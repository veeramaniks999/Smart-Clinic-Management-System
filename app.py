# Smart Clinic Management System - Flask Application
# Author: <Your Name>
# Description: Basic Flask app setup for managing doctors, patients, and appointments

from flask import Flask, jsonify, request

app = Flask(__name__)

# Sample in-memory data (temporary storage)
doctors = [
    {"doctor_id": 1, "name": "Dr. John Smith", "specialization": "Cardiology"},
    {"doctor_id": 2, "name": "Dr. Priya Mehta", "specialization": "Dermatology"}
]

patients = [
    {"patient_id": 1, "name": "Alice Brown", "age": 32, "gender": "Female"},
    {"patient_id": 2, "name": "Raj Kumar", "age": 45, "gender": "Male"}
]

appointments = []


# Home route
@app.route('/')
def home():
    return "Welcome to Smart Clinic Management System!"


# Get all doctors
@app.route('/doctors', methods=['GET'])
def get_doctors():
    return jsonify(doctors)


# Get all patients
@app.route('/patients', methods=['GET'])
def get_patients():
    return jsonify(patients)


# Schedule a new appointment
@app.route('/appointments', methods=['POST'])
def create_appointment():
    data = request.get_json()
    appointment_id = len(appointments) + 1
    data['appointment_id'] = appointment_id
    appointments.append(data)
    return jsonify({"message": "Appointment created successfully!", "appointment": data})


# Get all appointments
@app.route('/appointments', methods=['GET'])
def get_appointments():
    return jsonify(appointments)


if __name__ == '__main__':
    app.run(debug=True)
