package com.wenner.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wenner.api.documents.Cliente;
import com.wenner.api.repository.ClienteRespository;

@SpringBootApplication
public class SpringMongoApplication {
	
	@Autowired
	private ClienteRespository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}
	
 	public CommandLineRunner commandLineRunner() {
		
 		return args -> {
// 			repository.deleteAll();	
 			
 			repository.save( new Cliente("Wenner", 36) );
 			repository.save( new Cliente("Gabriel", 34) );
 			repository.save( new Cliente("Sander", 37) );
 			
 			System.out.println("Listando todos os clientes -> findAll()");
 			System.out.println("--------------------------------------------");
 			
 			repository.findAll().forEach(System.out::println);
 			System.out.println();
 			
 			System.out.println("Buscando o cliente Wenner: findByNome('Wenner')");
 			System.out.println("--------------------------------------------");
 			
 			System.out.println(repository.findByNome("Wenner") ); 
 			
 			
 			System.out.println();
 			
 			System.out.println("Clientes com idade entre 36 and 38 anos");
 			System.out.println("--------------------------------------------");
 			
 			repository.findByIdadeBetweeen(36, 38).forEach(System.out::println);
 		};
 		
	}
}
