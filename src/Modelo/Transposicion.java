package Modelo;


import Controlador.DTOAlgoritmos;
import java.util.*;

/**
 * 
 */
public class Transposicion extends Algoritmo {

    /**
     * Default constructor
     */
    public Transposicion() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de Transposicion");
        System.out.println("******************************");
    }

    /**
     * @param mensaje 
     * @return
     */
    public String codificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String[] palabras = DTO.getFraseOrigen().split(" ");
        String r = "Codificacion en Transposicion: ";
        for (String palabra : palabras) {
            r += reverseIt(palabra) + " ";
        }
        return r;
    }

    /**
     * @param mensaje 
     * @return
     */
    public String decodificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String[] palabras = DTO.getFraseOrigen().split(" ");
        String r = "Decodificacion en Transposicion: ";
        for (String palabra : palabras) {
            r += reverseIt(palabra) + " ";
        }
        return r;
    }
    
    private static String reverseIt(String source) {
    int i, len = source.length();
    StringBuilder dest = new StringBuilder(len);

    for (i = (len - 1); i >= 0; i--){
        dest.append(source.charAt(i));
    }

    return dest.toString();
}

}