package com.nv.doctorapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidPatientException extends Exception {

	String msg;

	@Override
	public String toString() {
		return "InvalidPatientException [msg=" + msg + "]";
	}
}
