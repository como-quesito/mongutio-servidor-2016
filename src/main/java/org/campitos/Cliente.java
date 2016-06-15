package org.campitos;

import org.springframework.data.annotation.Id;

/**
 * Created by rapid on 15/06/2016.
 */
public class Cliente {

    @Id
    private String id;

    private String nombre;
    private Integer edad;

    public Cliente() {
    }

    public Cliente(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
