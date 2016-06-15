package org.campitos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongutioApplication implements CommandLineRunner {

	@Autowired
	private  RepositorioCliente repo;

	public static void main(String[] args) {
		SpringApplication.run(MongutioApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();
		repo.save(new Cliente("juan",43));
		repo.save((new Cliente("floky",4)));
		System.out.println("Todo guardados");

		for(Cliente cli:repo.findAll()){
			System.out.println("Cliente con nombre:"+cli.getNombre());
		}

	}
}
