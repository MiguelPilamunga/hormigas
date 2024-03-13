package com.examen.DataAccess.DTOs.Hormigas.imp;

import com.examen.DataAccess.DTOs.Alimento;
import com.examen.DataAccess.DTOs.Hormigas.Hormiga;
import com.examen.DataAccess.DTOs.Hormigas.IHormigaLarva;
import com.examen.DataAccess.DTOs.impl.AlimentoCarnivoro;
import com.examen.DataAccess.DTOs.impl.AlimentoInsectivoro;

public class HormigaLarva extends Hormiga implements IHormigaLarva {

    @Override
    public String toString() {
        return super.toString() + "Larva";
    }

    @Override
    public Hormiga comerRealizarMetamorfosis(Alimento alimento) {
        if (alimento instanceof AlimentoCarnivoro) {
            return new HormigaSoldado();
        } else if (alimento instanceof AlimentoInsectivoro) {
            return new HormigaReina();
        } else {
            System.out.println(" no pertenece ni a AlimentoCarnivoro ,ni AlimentoInsectivoro");
            return null;
        }
    }
}

