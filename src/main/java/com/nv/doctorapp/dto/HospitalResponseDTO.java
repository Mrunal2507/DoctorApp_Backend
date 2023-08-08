package com.nv.doctorapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponseDTO {

	private int hospitalId;
	private String hospitalName;
	private String city;
	private String state;
	private String address;
	private int hospitalRating;

}
