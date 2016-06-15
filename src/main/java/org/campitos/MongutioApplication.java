package org.campitos;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class MongutioApplication implements CommandLineRunner {

	@Autowired
	private  RepositorioCliente repo;

	/*
	Con la configuracion ehcha antes sí funcona este que es el mongotemplate
	 */
	@Autowired
	MongoTemplate template;

	@Autowired
	GridFsTemplate grid;

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

			System.out.println("Ya todo");
		}
   //Para el mongo template
		template.save(new Cliente("Cacurrio", 45));

		//Para grifs	C:\Users\rapid\Pictures
		InputStream inputStream = null;
		DBObject metaData = new BasicDBObject();
		metaData.put("extra1", "anything 1");
		metaData.put("extra2", "anything 2");

		try {
			inputStream = new FileInputStream("C:\\Users\\rapid\\Pictures\\alnmacig.jpg");
			//grid.store(inputStream, "alnmacig.jpg", "image/jpg", metaData); si funciono

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
