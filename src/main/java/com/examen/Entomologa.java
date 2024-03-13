package com.examen;

import com.examen.DataAccess.DTOs.Alimento;
import com.examen.DataAccess.DTOs.Hormigas.Hormiga;
import com.examen.DataAccess.DTOs.Hormigas.IHormigaLarva;
import com.examen.DataAccess.DTOs.Hormigas.imp.HormigaLarva;
import com.examen.DataAccess.DTOs.Hormigas.imp.HormigaSoldado;
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
            Alimento alimento = new AlimentoInsectivoro(irradiacion);
            alimentos.add(alimento);

        }
        scanner.close();
        System.out.println(alimentos.size());
        return alimentos;
    }
    public static List<Hormiga> crearHormigueroLarvarioAlimentar(List<Alimento> alimentosIrradiados) {

        List<Hormiga> hormiguero = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Hormiga hormigaLarva = new HormigaLarva();

            Hormiga hormiga = ((HormigaLarva) hormigaLarva).comerRealizarMetamorfosis(alimentosIrradiados.get(i));
            hormiguero.add(hormiga);

        }
        hormiguero.forEach(hormiga -> System.out.println(hormiga.getClass().getSimpleName()+" "+hormiga.getEstado()));

        return hormiguero;
    }



    public static void main(String[] args) throws FileNotFoundException {
        crearHormigueroLarvarioAlimentar(obtenerAlimentosEIrradiarlos());

    }
    private static boolean esTipoValido(String tipoAlimento) {
        return tipoAlimento.equals("Carnívoro") || tipoAlimento.equals("Insectívoro");
    }
}
