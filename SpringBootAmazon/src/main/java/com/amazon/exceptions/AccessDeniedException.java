package com.amazon.exceptions;

@SuppressWarnings("serial")
public class AccessDeniedException extends Exception{
	public AccessDeniedException(String message)
	{
		super(message);
	}
}
