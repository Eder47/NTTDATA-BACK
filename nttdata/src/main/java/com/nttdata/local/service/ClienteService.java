package com.nttdata.local.service;

import org.springframework.http.ResponseEntity;

import com.nttdata.local.clienteDto.ClienteResult;

public interface ClienteService {

	public ClienteResult buscarCliente(Long numeroDoc, Long tipoDoc);
}
