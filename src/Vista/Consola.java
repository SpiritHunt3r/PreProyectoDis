/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Controlador.DTOAlgoritmos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author juan_
 */
public class Consola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables del DTO
        String Frase;
        List<String> lista_algoritmos = new ArrayList<>();
        List<String> lista_salidas = new ArrayList<>();
        
        Controlador ctrl = new Controlador();
        DTOAlgoritmos data = new DTOAlgoritmos();
        List<String> Alfabetos = ctrl.cargarAlfabetos();
        
        //Herramientas para el manejo de datos
        Scanner keyInt = new Scanner(System.in);
        Scanner keyFrs = new Scanner(System.in);
        Scanner keyStr = new Scanner(System.in);
        Scanner keyStr1 = new Scanner(System.in);
        Scanner keyStr2 = new Scanner(System.in);
        
        
        System.out.println("Alfabetos Guardados:");
        for (int i=0;i<Alfabetos.size();i++){
            System.out.println(String.valueOf(i+1) + " - " +Alfabetos.get(i));
        }
        System.out.print("Seleccione un alfabeto:");
        data.setElAlfabeto(keyInt.nextInt()-1);
        System.out.println();
        System.out.println("Algoritmos disponibles:");
        for (int i=0;i<data.getLosAlgoritmos().size();i++){
            System.out.println(String.valueOf(i+1) + " - " +data.getLosAlgoritmos().get(i));
        }
        System.out.print("Seleccione los algoritmos separados por comas (,):");
        String Algoritmos = keyStr.nextLine();
        String[] opts = Algoritmos.split(",");
        for (int j=0;j<opts.length;j++){
            lista_algoritmos.add(data.getLosAlgoritmos().get(Integer.valueOf(opts[j])-1));
        }
        data.setAlgoritmosSelec(lista_algoritmos);
        System.out.println();
        System.out.println("Salidas disponibles:");
        for (int i=0;i<data.getLasSalidas().size();i++){
            System.out.println(String.valueOf(i+1) + " - " +data.getLasSalidas().get(i));
        }
        System.out.print("Seleccione las salidas separadas por comas (,):");
        String Salidas = keyStr1.nextLine();
        String[] opts1 = Salidas.split(",");
        for (int k=0;k<opts.length;k++){
            lista_salidas.add(data.getLasSalidas().get(Integer.valueOf(opts[k])-1));
        }
        data.setSalidasSelec(lista_salidas);
        System.out.println();
        System.out.println("Metodos disponibles:");
        System.out.println("1 - Codificacion");
        System.out.println("2 - Decodificacion");
        System.out.print("Seleccione un metodo:");
        int metodo = keyStr2.nextInt();
        if (metodo ==1){
            data.setModoCodificacion(true);
        }
        else{
            data.setModoCodificacion(false);
        }
        ctrl.procesarPeticion(data);
        
        if (data.getResultados() != null){
            for (int i=0;i<data.getResultados().size();i++){
                System.out.println(data.getResultados().get(i));
            }
        }
    }
    
}
