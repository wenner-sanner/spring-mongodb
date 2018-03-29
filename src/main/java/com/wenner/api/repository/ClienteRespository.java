package com.wenner.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wenner.api.documents.Cliente;

public interface ClienteRespository extends MongoRepository<Cliente, String> {

	Cliente findByNome(String nome);
	
	@Query ("{ 'idade' : {$gt : ?0, $lt : ?1} }")
	List<Cliente> findByIdadeBetweeen(int idadeInicial,  int idadeFinal);
}
