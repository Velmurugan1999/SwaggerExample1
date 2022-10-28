package com.amazon.handler;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amazon.exceptions.AccessDeniedException;
import com.amazon.exceptions.OrderNotFoundException;
import com.amazon.exceptions.ProductNotFoundException;
import com.amazon.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ControllerAdviceCls {
	public static Logger logger=Logger.getLogger("amazon");
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundException(UserNotFoundException ex)
	{
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String productNotFoundException(ProductNotFoundException ex)
	{
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public String orderNotFoundException(OrderNotFoundException ex)
	{
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String accessDeniedException(AccessDeniedException ex)
	{
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public String entityNotFoundException(EntityNotFoundException ex)
	{
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
}
