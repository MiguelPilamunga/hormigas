package com.examen.DataAccess.DTOs.Hormigas.imp;

import com.examen.DataAccess.DTOs.Hormigas.Hormiga;

public class HormigaSantacruz extends Hormiga {

    @Override
    public String getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return super.toString() + "Santacruz";
    }
}
