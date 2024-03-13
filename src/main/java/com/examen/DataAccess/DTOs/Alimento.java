package com.examen.DataAccess.DTOs;

public abstract class Alimento implements AlimentoRadioactivo {

    protected String escalaRadiacion;

    public Alimento(int porcentajeIrradiacion) {
        setIrradiar(porcentajeIrradiacion);
    }

    @Override
    public void setIrradiar(int porcentajeIrradiacion) {
        if (porcentajeIrradiacion <= 30) {
            escalaRadiacion = "baja";
        } else if (porcentajeIrradiacion > 30 && porcentajeIrradiacion < 70) {
            escalaRadiacion = "media";
        } else {
            escalaRadiacion = "alta";
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public String getEscalaRadiacion() {
        return escalaRadiacion;
    }
}
