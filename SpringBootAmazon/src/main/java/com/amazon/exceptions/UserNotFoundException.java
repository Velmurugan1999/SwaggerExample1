package com.amazon.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	public UserNotFoundException(String message)
	{
		super(message);
	}
}
