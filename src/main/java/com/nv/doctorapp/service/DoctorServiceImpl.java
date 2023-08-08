package com.nv.doctorapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Doctor;
import com.nv.doctorapp.entity.Hospital;
import com.nv.doctorapp.exception.InvalidDoctorNameException;
import com.nv.doctorapp.exception.InvalidEmailException;
import com.nv.doctorapp.repository.IDoctorRepository;
import com.nv.doctorapp.repository.IHospitalRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Autowired
	private IHospitalRepository ihospitalRepository;


	@Override
	public Doctor addDoctor(Doctor doctor) throws Exception {

		if (doctor.getDoctorName().equals("")){
			throw new InvalidDoctorNameException("Invalid Doctor Name");
		}
		
		if (doctor.getEmail().equals("")){
			throw new InvalidEmailException("Invalid Email Id");
		}
		
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {

		return doctorRepository.findAll();
	}
	
	@Override
	public Doctor updateDoctor(int doctorId) {

		Doctor updatedDoctor = doctorRepository.getReferenceById(doctorId);
		doctorRepository.save(updatedDoctor);
		return updatedDoctor;
		
	}

	@Override
	public void removeDoctorById(int doctorId) {

		doctorRepository.deleteById(doctorId);
	}

	@Override
	public Doctor getDoctorById(int doctorId) {

		Doctor savedDoctor = doctorRepository.getReferenceById(doctorId);
		return savedDoctor;
	}

	@Override
	public List<Doctor> getDoctorByAvailability(String searchfromDay, String searchtoDay) {
		
		List<Doctor> allDoctors = doctorRepository.findAll();
		List<Doctor> allDoctorsByAvailability = new ArrayList<>();
		
		for(Doctor doctor: allDoctors) {
			String fromDay = doctor.getAvailabilityDates().getFromDay();
			String toDay = doctor.getAvailabilityDates().getToDay();
			
			if(fromDay.equals(searchfromDay)&& toDay.equals(searchtoDay)) {
				allDoctorsByAvailability.add(doctor);
			}
		}
		return allDoctorsByAvailability;
	}
	
	@Override
	public List<Doctor> getDoctorByLocation(String location) {
		
		return doctorRepository.getDoctoyByLocation(location);
	}

	@Override
	public List<Doctor> getDoctorBySpeciality(String speciality) {

		return doctorRepository.getDoctorBySpeciality(speciality);
	}

	@Override
	public Doctor updateHospitalByDoctorId(int doctorId, int hospitalId) {
		
		Doctor doctorFromDB = getDoctorById(doctorId);
		Hospital hospitalFromDB = ihospitalRepository.getReferenceById(hospitalId);
		
		if(doctorFromDB !=null & hospitalFromDB != null) {
			List<Doctor> allDoctors = hospitalFromDB.getDoctors();
			
			if(allDoctors!= null && allDoctors.isEmpty()==false) {
				allDoctors.add(doctorFromDB);
				hospitalFromDB.setDoctors(allDoctors);
			}
			else {
				List<Doctor> newDoctorList=new ArrayList<>();
				newDoctorList.add(doctorFromDB);
				hospitalFromDB.setDoctors(newDoctorList);
			}
			ihospitalRepository.saveAndFlush(hospitalFromDB);
			doctorRepository.save(doctorFromDB);
			return doctorFromDB;
		}
		else {
			return null;
		}
	}
}
