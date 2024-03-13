package com.examen.DataAccess.DTOs.Hormigas;

public abstract class Hormiga {

    protected String estado = "VIVA";

    public Hormiga() {

    }

    public abstract String getEstado();


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
