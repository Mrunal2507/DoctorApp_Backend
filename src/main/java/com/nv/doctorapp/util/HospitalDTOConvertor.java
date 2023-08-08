package com.nv.doctorapp.util;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.HospitalResponseDTO;
import com.nv.doctorapp.entity.Hospital;

@Component

public class HospitalDTOConvertor {

	public HospitalResponseDTO convertTo(Hospital hospital) {
		
		return new HospitalResponseDTO(hospital.getHospitalId(), hospital.getHospitalName(), hospital.getCity(), hospital.getState(), hospital.getAddress(), hospital.getHospitalRating());
		
	}

}
