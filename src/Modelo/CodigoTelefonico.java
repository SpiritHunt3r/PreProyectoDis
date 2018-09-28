package Modelo;


import Controlador.DTOAlgoritmos;
import java.util.*;

/**
 * 
 */
public class CodigoTelefonico extends Algoritmo {

    /**
     * Default constructor
     */
    public CodigoTelefonico() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de Codigo Telefonico");
        System.out.println("******************************");
    }

    /**
     * 
     */
    private Collection distSimbolos;

    /**
     * @param mensaje 
     * @return
     */
    public String codificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String[] data = distribuirAlfabeto(alfabeto);
        return "Codifica en Telefonico";
    }

    /**
     * @param mensaje 
     * @return
     */
    public String decodificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String[] data = distribuirAlfabeto(alfabeto);
        return "Decodifica en Telefonico";
    }

    /**
     * @param unAlfabeto 
     * @return
     */
    private String[] distribuirAlfabeto(Alfabeto unAlfabeto) {
        String sim = unAlfabeto.getSimbolos();
        int size = (int) Math.round(sim.length()/10.0);
        int pos = 0;
        String[] matriz = new String[10];
        for (int i=0;i<10;i++){
            if (pos > sim.length()){
                break;
            }
            else if (pos+size < sim.length()){
                matriz[i] = sim.substring(pos, pos+size);
            } 
            else{
                matriz[i] = sim.substring(pos,sim.length());
            }
            pos+=size;
        }
        return matriz;
    }

}