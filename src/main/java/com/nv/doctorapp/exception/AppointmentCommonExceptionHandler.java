package com.nv.doctorapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.AppointmentExceptionDTOResponse;

@ControllerAdvice
public class AppointmentCommonExceptionHandler {

	@ExceptionHandler

	public ResponseEntity<AppointmentExceptionDTOResponse> invalidName(InvalidAppointmentException e) {
		AppointmentExceptionDTOResponse dto = new AppointmentExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<AppointmentExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<AppointmentExceptionDTOResponse> invalidEmail(InvalidAppointmentException e) {
		AppointmentExceptionDTOResponse dto = new AppointmentExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<AppointmentExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

}
