package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Patient;

@Service
public interface IPatientService {

	public Patient registerPatient(Patient patient) throws Exception;

	public Patient updatepatientDetailsById(int patientId);

	public void removePatientDetailsById(int patientId);

	public Patient getPatientById(int patientId);

	public List<Patient> getAllPatients();

	public List<Patient> getPatientByCity(String patientCity);

	public List<Patient> getPatientByName(String patientName);

	public List<Patient> getPatientByAge(int patientAge);

	public List<Patient> getPatientByGender(String patientGender);

	public List<Patient> getPatientByDisease(String patientDisease);
	
}
