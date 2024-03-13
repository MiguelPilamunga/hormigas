package com.examen;

import com.examen.DataAccess.DTOs.Alimento;
import com.examen.DataAccess.DTOs.impl.AlimentoCarnivoro;
import com.examen.DataAccess.DTOs.impl.AlimentoInsectivoro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entomologa {


    public static List<Alimento> obtenerAlimentosEIrradiarlos() throws FileNotFoundException {
        ArrayList<Alimento> alimentos = new ArrayList<>();

        File file = new File("C:\\Users\\LPILAMUNGA\\OneDrive - COBIS\\Documents\\NetBeansProjects\\Examen\\src\\main\\java\\com\\examen\\AlimentosDeHormigas.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            if (linea.startsWith("%")) {
                continue;
            }
            String[] partes = linea.split(",");

            int irradiacion = Integer.parseInt(partes[0]);
            String tipoAlimento = partes[1];

            Alimento alimento;
            if (tipoAlimento.equals("Carnívoro")) {
                alimento = new AlimentoCarnivoro(irradiacion);
            } else if (tipoAlimento.equals("Insectívoros")) {
                alimento = new AlimentoInsectivoro(irradiacion);
            } else {
                continue;
            }
            alimentos.add(alimento);

        }
        scanner.close();
        return alimentos;
    }
    public static void main(String[] args) throws FileNotFoundException {
        obtenerAlimentosEIrradiarlos().forEach(System.out::println);
    }
    private static boolean esTipoValido(String tipoAlimento) {
        return tipoAlimento.equals("Carnívoro") || tipoAlimento.equals("Insectívoro");
    }
}
