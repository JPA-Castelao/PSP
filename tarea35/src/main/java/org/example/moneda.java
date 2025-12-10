package org.example;

public class moneda {

    private String nombre;
    private String simbolo;
    private long precio;
    private int ranking;
    private double variacion24h;


    public moneda(String nombre, String simbolo, int ranking, double variacion24h) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        double precio;
        this.ranking = ranking;
        this.variacion24h = variacion24h;
    }
}
