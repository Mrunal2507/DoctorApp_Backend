package com.nv.doctorapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.HospitalExceptionDTOResponse;

@ControllerAdvice
public class HospitalCommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<HospitalExceptionDTOResponse> invalidInput(InvalidInputException e) {
		HospitalExceptionDTOResponse dto = new HospitalExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<HospitalExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<HospitalExceptionDTOResponse> invalidId(NullPointerException e) {
		HospitalExceptionDTOResponse dto = new HospitalExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<HospitalExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}
}
