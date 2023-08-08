package com.nv.doctorapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.doctorapp.dto.DoctorResponseDTO;
import com.nv.doctorapp.entity.Doctor;
import com.nv.doctorapp.service.IDoctorService;
import com.nv.doctorapp.util.DoctorDTOConvertor;

@RestController
@RequestMapping("/doctor")
public class DoctorRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IDoctorService doctorService;

	@Autowired
	DoctorDTOConvertor dtoConvertor;

	public DoctorRestController() {
		logger.info(" Doctor Rest Controller Called");
		System.err.println("-------Doctor Rest Controller Called-------");
	}

	@PostMapping("/register")
	public ResponseEntity<DoctorResponseDTO> saveDoctor(@RequestBody Doctor doctor) throws Exception {

		System.err.println( "post mapping "+doctor);
		Doctor savedDoctor = doctorService.addDoctor(doctor);
		logger.info("Doctor Saved" + savedDoctor);

		DoctorResponseDTO dto = dtoConvertor.convertTo(savedDoctor);
		
		return new ResponseEntity<DoctorResponseDTO>(dto, HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {

		List<Doctor> allDoctors = doctorService.getAllDoctors();
		List<DoctorResponseDTO> dtoList = new ArrayList<>();

		for (Doctor doctor : allDoctors) {

			DoctorResponseDTO dtoObj = dtoConvertor.convertTo(doctor);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<DoctorResponseDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/id/{doctorId}")
	public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable int doctorId) {
		
		Doctor savedDoctor = doctorService.getDoctorById(doctorId);
		DoctorResponseDTO dto = dtoConvertor.convertTo(savedDoctor);
		return new ResponseEntity<DoctorResponseDTO>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/{doctorId}")
	public String updateDoctor(@PathVariable int doctorId){
		Doctor updatedDoctor = doctorService.getDoctorById(doctorId);
		return updatedDoctor.toString();
		
	}
	
	@DeleteMapping("/{doctorId}")
	public void removeDoctor(@PathVariable int doctorId) {
		doctorService.removeDoctorById(doctorId);
	}
	
	@GetMapping("/availability/{fromDay}/{toDay}")
	public ResponseEntity<List<DoctorResponseDTO>> getDoctorByAvailability(@PathVariable String fromDay, @PathVariable String toDay){
		List<Doctor> allDoctors = doctorService.getDoctorByAvailability(fromDay, toDay);
		List<DoctorResponseDTO> dto = new ArrayList<>();
		for(Doctor doctor: allDoctors) {
			DoctorResponseDTO dtoObj = dtoConvertor.convertTo(doctor);
			dto.add(dtoObj);
		}
		return new ResponseEntity<List<DoctorResponseDTO>>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/location/{location}")
	public ResponseEntity<List<DoctorResponseDTO>> getDoctorByLocation(@PathVariable String location){
		
		List<Doctor> allDoctors = doctorService.getDoctorByLocation(location);
		List<DoctorResponseDTO> dtoObj = new ArrayList<>();
		
		for(Doctor doctor: allDoctors) {
			dtoObj.add(dtoConvertor.convertTo(doctor));
		}
		
		return new ResponseEntity<List<DoctorResponseDTO>>(dtoObj, HttpStatus.OK);
		
	}
	
	@GetMapping("/speciality/{speciality}")
	public ResponseEntity<List<DoctorResponseDTO>>getDoctorBySpeciality(@PathVariable String speciality){
		
		List<Doctor> allDoctors = doctorService.getDoctorBySpeciality(speciality);
		List<DoctorResponseDTO> dto = new ArrayList<>();
		
		for(Doctor doctor: allDoctors) {
			
			dto.add(dtoConvertor.convertTo(doctor));
		}
		
		return new ResponseEntity<List<DoctorResponseDTO>>(dto, HttpStatus.OK);
		
	}
	
	@PutMapping("/{doctorId}/hospital/{hospitalId}")
	public ResponseEntity<DoctorResponseDTO>updateHospitalByDoctorId(@PathVariable int doctorId, @PathVariable int hospitalId)
	{
		Doctor updatedDoctor = doctorService.updateHospitalByDoctorId(doctorId,hospitalId);
		if(updatedDoctor!=null) {
			DoctorResponseDTO dto = dtoConvertor.convertTo(updatedDoctor);
			return new ResponseEntity<DoctorResponseDTO>(dto, HttpStatus.OK);
		}
		return null;
	}
	
}
