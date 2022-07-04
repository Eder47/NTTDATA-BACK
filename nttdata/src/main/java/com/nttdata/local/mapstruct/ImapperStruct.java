package com.nttdata.local.mapstruct;

import org.mapstruct.Mapper;

import com.nttdata.local.clienteDto.ClienteDto;
import com.nttdata.local.model.Cliente;



@Mapper(componentModel = "spring")
public interface ImapperStruct {
	
	Cliente clienteDtoToCliente(ClienteDto clienteDto);
	ClienteDto clienteToClienteDto(Cliente cliente);

}
