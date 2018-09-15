package Modelo;


import Controlador.DTOAlgoritmos;
import java.util.*;

/**
 * 
 */
public class EscritorTxT implements IEscritor {

    /**
     * Default constructor
     */
    public EscritorTxT() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea un escritor de TXT");
        System.out.println("******************************");
    }


    /**
     * @param dto 
     * @return
     */
    public boolean escribir(DTOAlgoritmos dto) {
        // TODO implement here
        return true;
    }

}