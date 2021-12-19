package com.revature.exceptions;

public class NullFieldException extends Exception{
	public NullFieldException(String errorMessage) {
		super(errorMessage);
	}
	public NullFieldException(String errorMessage, Throwable err) {
		super(errorMessage,err);
	}
}
