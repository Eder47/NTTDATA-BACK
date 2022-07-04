package com.nttdata.local.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.local.clienteDto.ClienteResult;
import com.nttdata.local.excepciones.ExcepClienteNoExiste;
import com.nttdata.local.model.Catalogo;
import com.nttdata.local.service.ClienteService;
import com.nttdata.local.service.ListarCatService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clientes")
public class ControllerCliente {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ListarCatService listarCatService;
	
	@GetMapping("/getInfo/{numeroDoc}/{tipoDoc}")
	public ResponseEntity<ClienteResult> obtegerCliente(@PathVariable Long numeroDoc, @PathVariable Long tipoDoc) throws ExcepClienteNoExiste{
		HttpHeaders httpHeaders = new HttpHeaders();
		ClienteResult infoCliete = clienteService.buscarCliente(numeroDoc, tipoDoc);
        return new ResponseEntity<ClienteResult>(infoCliete, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/getInfo/catalogo")
	public List<Catalogo> listarCat(){
		return listarCatService.listarCatalogo();
		
	}

}
