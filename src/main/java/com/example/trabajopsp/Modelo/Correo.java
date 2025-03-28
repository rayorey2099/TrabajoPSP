package com.example.trabajopsp.Modelo;

import com.example.trabajopsp.Enumerados.Estado;

public class Correo {
    private String enunciado;
    private String contenido;
    private String estado;

    public Correo(Estado estado, String contenido, String enunciado) {
        this.estado = estado.toString();
        this.contenido = contenido;
        this.enunciado = enunciado;
    }
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado.toString();
    }
}
