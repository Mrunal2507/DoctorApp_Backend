package com.nv.doctorapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Patient;
import com.nv.doctorapp.exception.InvalidPatientException;
import com.nv.doctorapp.repository.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;

	@Override
	public Patient registerPatient(Patient patient) throws Exception {

		if (patient.getPatientName().equals("")) {
			throw new InvalidPatientException("Invalid Patient Name");
		}

		if (patient.getPatientCity().equals("")) {
			throw new InvalidPatientException("Invalid City");
		}

		else
			return patientRepository.save(patient);

	}

	@Override
	public Patient updatepatientDetailsById(int patientId) {

		Patient updatedPatient = patientRepository.getReferenceById(patientId);
		patientRepository.save(updatedPatient);
		return updatedPatient;
	}

	@Override
	public void removePatientDetailsById(int patientId) {

		patientRepository.deleteById(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int patientId) {

		return patientRepository.getReferenceById(patientId);
	}

	@Override
	public List<Patient> getPatientByCity(String patientCity) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientCity().equalsIgnoreCase(patientCity)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;

	}

	@Override
	public List<Patient> getPatientByName(String patientName) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientName().equalsIgnoreCase(patientName)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;

	}

	@Override
	public List<Patient> getPatientByGender(String patientGender) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientGender().equalsIgnoreCase(patientGender)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}

	@Override
	public List<Patient> getPatientByDisease(String patientDisease) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientDisease().equalsIgnoreCase(patientDisease)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}

	@Override
	public List<Patient> getPatientByAge(int patientAge) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientAge() == (patientAge)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}

}
