package com.nttdata.local.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nttdata.local.model.Catalogo;

public interface CatalogoRepositorio extends JpaRepository<Catalogo, Long>{
	
	@Query("select p from Catalogo p where p.id = ?1")
	public Catalogo buscarCatalogo(Long id);

}
