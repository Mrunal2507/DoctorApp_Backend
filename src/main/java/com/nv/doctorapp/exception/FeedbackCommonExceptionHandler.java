package com.nv.doctorapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.FeedbackExceptionDTOResponse;


@ControllerAdvice
public class FeedbackCommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<FeedbackExceptionDTOResponse> invalidName(InvalidDataException e) {
		FeedbackExceptionDTOResponse dto = new FeedbackExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<FeedbackExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<FeedbackExceptionDTOResponse> invalidId(NullPointerException e) {
		FeedbackExceptionDTOResponse dto = new FeedbackExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<FeedbackExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

}
