package com.nttdata.local.excepciones;

import org.springframework.http.HttpStatus;


import lombok.Data;

@Data
public class ExcepClienteNoExiste extends RuntimeException{
	
	private String code;
	private HttpStatus status;
	public ExcepClienteNoExiste(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}

}
