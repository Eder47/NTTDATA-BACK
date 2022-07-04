package com.nttdata.local.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nttdata.local.clienteDto.ClienteResult;
import com.nttdata.local.excepciones.ExcepClienteNoExiste;
import com.nttdata.local.model.Catalogo;
import com.nttdata.local.model.Cliente;
import com.nttdata.local.repository.CatalogoRepositorio;
import com.nttdata.local.repository.ClienteRepositorio;
import com.nttdata.local.service.ClienteService;
import com.nttdata.local.service.ListarCatService;

@Service
public class ClienteServiceImpl implements ClienteService, ListarCatService{
	
	@Autowired
	ClienteRepositorio clienteRepo;
	
	@Autowired
	CatalogoRepositorio catalogoRepo;
	
	@Transactional
	public ClienteResult buscarCliente(Long numeroDoc, Long tipoDoc) {
		Cliente cliente = clienteRepo.getCliente(numeroDoc, tipoDoc);
		Catalogo catalogo = catalogoRepo.buscarCatalogo(tipoDoc);
		if (cliente == null) {
			throw new ExcepClienteNoExiste("500", HttpStatus.BAD_REQUEST, "El cliente no existe en base de datos");
		}
		ClienteResult response = new ClienteResult();
		response.setNumeroDocumento(cliente.getNumeroDocumento());
		response.setTipoDoc(catalogo.getNombre());
		response.setPrimerNombre(cliente.getPrimerNombre());
		response.setSegundoNombre(cliente.getSegundoNombre());
		response.setPrimerApellido(cliente.getPrimerApellido());
		response.setSegundoApellido(cliente.getSegundoApellido());
		response.setTelefono(cliente.getTelefono());
		response.setDireccion(cliente.getDireccion());
		response.setCiudadResidencia(cliente.getCiudadResidencia());
		return response;
				
	}

	@Override
	public List<Catalogo> listarCatalogo() {
		return catalogoRepo.findAll();
	}

}
