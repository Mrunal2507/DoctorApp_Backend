package com.nv.doctorapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidDataException extends Exception {

	private String msg;

	@Override
	public String toString() {
		return "InvalidDataException [msg=" + msg + "]";
	}

}
