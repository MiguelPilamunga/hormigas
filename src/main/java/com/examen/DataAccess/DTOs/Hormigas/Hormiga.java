package com.examen.DataAccess.DTOs.Hormigas;

public abstract class Hormiga {

    protected String estado = "VIVA";

    public Hormiga() {
        throw new IllegalStateException("No se permite la instanciación directa de la clase Hormiga");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
