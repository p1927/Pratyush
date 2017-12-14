package com.capgemini.tcc.exception;

@SuppressWarnings("serial")
public class PatientException extends Exception{
	
	public PatientException(){
		super();
	}
	
	public PatientException(String msg){
		super(msg);
	}
	
}
