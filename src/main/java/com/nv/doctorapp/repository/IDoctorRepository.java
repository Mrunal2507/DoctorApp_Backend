package com.nv.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.doctorapp.entity.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	
	public List<Doctor> getDoctorBySpeciality(String speciality);

	public List<Doctor> getDoctoyByLocation(String location);
}
