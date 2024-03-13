package com.examen.DataAccess.DTOs;

import com.examen.DataAccess.DTOs.impl.AlimentoCarnivoro;
import com.examen.DataAccess.DTOs.impl.AlimentoInsectivoro;

public class pruebas {

    public static void main(String[] args) {
        AlimentoCarnivoro alimentoCarnivoro = new AlimentoCarnivoro(50);
        System.out.println(alimentoCarnivoro);
        System.out.println(alimentoCarnivoro.escalaRadiacion);

        AlimentoInsectivoro alimentoInsectivoro = new AlimentoInsectivoro(10);
        System.out.println(alimentoInsectivoro);
        System.out.println(alimentoInsectivoro.escalaRadiacion);

    }
}
