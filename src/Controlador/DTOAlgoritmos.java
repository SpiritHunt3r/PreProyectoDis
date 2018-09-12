package Controlador;


import java.util.*;

/**
 * 
 */
public class DTOAlgoritmos {

    /**
     * Default constructor
     */
    public DTOAlgoritmos() {
    }

    /**
     * 
     */
    private String elAlfabeto;

    /**
     * 
     */
    private String fraseOrigen;

    /**
     * 
     */
    private List<String> algoritmosSelec;

    /**
     * 
     */
    private List<String> salidasSelec;

    /**
     * 
     */
    private List<String> resultados;

    /**
     * 
     */
    private boolean modoCodificacion;

    public String getElAlfabeto() {
        return elAlfabeto;
    }

    public void setElAlfabeto(String elAlfabeto) {
        this.elAlfabeto = elAlfabeto;
    }

    public String getFraseOrigen() {
        return fraseOrigen;
    }

    public void setFraseOrigen(String fraseOrigen) {
        this.fraseOrigen = fraseOrigen;
    }

    public List<String> getAlgoritmosSelec() {
        return algoritmosSelec;
    }

    public void setAlgoritmosSelec(List<String> algoritmosSelec) {
        this.algoritmosSelec = algoritmosSelec;
    }

    public List<String> getSalidasSelec() {
        return salidasSelec;
    }

    public void setSalidasSelec(List<String> salidasSelec) {
        this.salidasSelec = salidasSelec;
    }

    public List<String> getResultados() {
        return resultados;
    }

    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }


    public boolean isModoCodificacion() {
        return modoCodificacion;
    }

    public void setModoCodificacion(boolean modoCodificacion) {
        this.modoCodificacion = modoCodificacion;
    }

}