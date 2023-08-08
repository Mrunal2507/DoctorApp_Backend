package com.nv.doctorapp.exception;

public class InvalidAppointmentException extends Exception {

	String input;
	String msg;

	public InvalidAppointmentException(String input, String msg) {
		super();
		this.input = input;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidInputException [" + input + msg + "]";
	}
}
