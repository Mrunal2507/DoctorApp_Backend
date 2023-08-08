package com.nv.doctorapp.util;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.DoctorResponseDTO;
import com.nv.doctorapp.entity.Doctor;

@Component
public class DoctorDTOConvertor {

	public DoctorResponseDTO convertTo(Doctor doctor) {

		return new DoctorResponseDTO(doctor.getDoctorId(), doctor.getDoctorName(), doctor.getSpeciality(),
				doctor.getChargePerVisit());

	}
}
