package com.nv.doctorapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.PatientExceptionDTOResponse;

@ControllerAdvice
public class PatientCommonExceptionHandler {

	@ExceptionHandler

	public ResponseEntity<PatientExceptionDTOResponse> invalidName(InvalidPatientException e) {
		
		PatientExceptionDTOResponse dto = new PatientExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<PatientExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<PatientExceptionDTOResponse> invalidCity(InvalidPatientException e) {
		
		PatientExceptionDTOResponse dto = new PatientExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<PatientExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

}
