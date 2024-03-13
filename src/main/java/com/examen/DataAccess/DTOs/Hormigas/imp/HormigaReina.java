package com.examen.DataAccess.DTOs.Hormigas.imp;

import com.examen.DataAccess.DTOs.Alimento;
import com.examen.DataAccess.DTOs.Hormigas.Hormiga;
import com.examen.DataAccess.DTOs.IHormigaTipoAlimentacion;
import com.examen.DataAccess.DTOs.impl.AlimentoCarnivoro;
import com.examen.DataAccess.DTOs.impl.AlimentoInsectivoro;

public class HormigaReina extends Hormiga implements IHormigaTipoAlimentacion {

    @Override
    public String toString() {
        return super.toString() + "Reina";
    }

    @Override
    public void comer(Alimento tipoAlimento) {
        String mensaje = tipoAlimento instanceof AlimentoInsectivoro ?
                "La hormiga Reina ha comido " + tipoAlimento :
                "La hormiga Reina no puede comer " + tipoAlimento;
        System.out.println(mensaje);
    }
}
