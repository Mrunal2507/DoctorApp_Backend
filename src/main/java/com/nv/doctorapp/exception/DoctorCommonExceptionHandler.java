package com.nv.doctorapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.DoctorExceptionDTOResponse;


@ControllerAdvice
public class DoctorCommonExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<DoctorExceptionDTOResponse> invalidDoctor(InvalidDoctorNameException e)
	{
		DoctorExceptionDTOResponse dto = new DoctorExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<DoctorExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<DoctorExceptionDTOResponse> invalidEmail(InvalidEmailException e1)
	{
		DoctorExceptionDTOResponse dto = new DoctorExceptionDTOResponse();
		dto.setErrorMsg(e1.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<DoctorExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}

}
