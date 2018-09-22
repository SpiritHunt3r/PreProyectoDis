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
    public String codificar(DTOAlgoritmos DTO) {
        // TODO implement here
        return "Codifica en Telefonico";
    }

    /**
     * @param mensaje 
     * @return
     */
    public String decodificar(DTOAlgoritmos DTO) {
        // TODO implement here
        return "Decodifica en Telefonico";
    }

    /**
     * @param unAlfabeto 
     * @return
     */
    private void distribuirAlfabeto(Alfabeto unAlfabeto) {
        // TODO implement here
    }

}