package org.campitos;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by rapid on 15/06/2016.
 */
public interface RepositorioCliente extends MongoRepository<Cliente,String> {
    List<Cliente> findByNombre(String nombre);
}
