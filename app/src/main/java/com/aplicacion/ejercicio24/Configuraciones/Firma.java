package com.aplicacion.ejercicio24.Configuraciones;

import java.io.Serializable;

public class Firma implements Serializable {
    private Integer id;
    private String descripcion;

    public Firma()
    {
        // Constructor Vacio
    }


    public Firma(Integer id, String descripcion, byte[] firmaDigital) {
        this.id = id;
        this.descripcion = descripcion;
        this.firmaDigital = firmaDigital;
    }

    private byte[] firmaDigital;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(byte[] firmaDigital) {
        this.firmaDigital = firmaDigital;
    }
}
