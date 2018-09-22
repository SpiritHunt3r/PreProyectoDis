package Modelo;


import Controlador.DTOAlgoritmos;
import java.util.*;

/**
 * 
 */
public class Vigenere extends Algoritmo {

    /**
     * Default constructor
     */
    public Vigenere() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de Vigenere");
        System.out.println("******************************");
    }

    /**
     * @param mensaje 
     * @return
     */
    public String codificar(DTOAlgoritmos DTO) {
        // TODO implement here
        return "Codifica en Vigenere";
    }

    /**
     * @param mensaje 
     * @return
     */
    public String decodificar(DTOAlgoritmos DTO) {
        // TODO implement here
        return "Decodifica en Vigenere";
    }

}