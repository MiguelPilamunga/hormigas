package com.examen.DataAccess.DTOs.Hormigas.imp;

import com.examen.DataAccess.DTOs.Alimento;
import com.examen.DataAccess.DTOs.Hormigas.Hormiga;
import com.examen.DataAccess.DTOs.IHormigaTipoAlimentacion;
import com.examen.DataAccess.DTOs.impl.AlimentoCarnivoro;

public class HormigaSoldado extends Hormiga implements IHormigaTipoAlimentacion {

    @Override
    public String toString() {
        return super.toString() + "Soldado";
    }

    @Override
    public void comer(Alimento tipoAlimento) {
        String mensaje = tipoAlimento instanceof AlimentoCarnivoro ?
                "La hormiga soldado ha comido " + tipoAlimento :
                "La hormiga soldado no puede comer " + tipoAlimento;
        System.out.println(mensaje);
    }
}
