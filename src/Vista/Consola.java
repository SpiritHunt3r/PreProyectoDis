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
        /*for (int i=0;i<Alfabetos.size();i++){
            System.out.print(Alfabetos.get(i));
        }*/
        System.out.print("Hola");
    }
    
}
