package com.example.logica;

public class Juego {

    private String[] peliculas;

    public Juego() {
        this.peliculas = new String[]{"LA RAZON DE VIVIR"};
    }

    public String inicio(){
        return this.peliculas[(int) (Math.random() * this.peliculas.length) ];
    }

    public boolean validarLetra(String letra, String pelicula){

        return pelicula.contains(letra);

    }
}
