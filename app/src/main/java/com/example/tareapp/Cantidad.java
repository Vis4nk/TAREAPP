package com.example.tareapp;

public class Cantidad {
    private Double Cantidad;

    public Cantidad(Double cantidad) {
        Cantidad = cantidad;
    }

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double cantidad) {
        Cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.valueOf(Cantidad);
    }
}
