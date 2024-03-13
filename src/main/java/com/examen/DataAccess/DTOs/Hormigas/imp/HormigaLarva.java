package com.examen.DataAccess.DTOs.Hormigas.imp;

import com.examen.DataAccess.DTOs.Alimento;
import com.examen.DataAccess.DTOs.Hormigas.Hormiga;
import com.examen.DataAccess.DTOs.Hormigas.IHormigaLarva;
import com.examen.DataAccess.DTOs.impl.AlimentoCarnivoro;
import com.examen.DataAccess.DTOs.impl.AlimentoInsectivoro;

public class HormigaLarva extends Hormiga implements IHormigaLarva {

    @Override
    public String getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return super.toString() + "Larva";
    }

    @Override
    public Hormiga comerRealizarMetamorfosis(Alimento alimento) {

        if (alimento instanceof  AlimentoCarnivoro  || alimento instanceof AlimentoInsectivoro){
            if ((alimento.getEscalaRadiacion().equals("baja"))){
                if(alimento instanceof  AlimentoCarnivoro)
                    return new HormigaReina();
                if (alimento instanceof  AlimentoInsectivoro)
                    return new HormigaSoldado();
            }
            if (alimento.getEscalaRadiacion().equals("media")) {
                return new HormigaSantacruz();
            }
            if (alimento.getEscalaRadiacion().equals("alta")){
                return new HormigaLarva().setEstado("MUERTA");
            }
        }
        else {
            return  new HormigaLarva().setEstado("Muerta");
        }
        return null;
    }

    public HormigaLarva setEstado(String estado) {
        this.estado = estado;
        return this;
    }
}

