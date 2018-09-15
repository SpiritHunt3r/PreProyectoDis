package Controlador;


import java.util.*;
import Modelo.Alfabeto;
import Modelo.Algoritmo;
import Modelo.CodigoTelefonico;
import Modelo.EscritorPDF;
import Modelo.EscritorTxT;
import Modelo.EscritorXML;
import Modelo.IEscritor;
import Modelo.Transposicion;
import Modelo.Vigenere;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Controlador {

    /**
     * Default constructor
     */
    public Controlador() {
    }

    /**
     * 
     */
    private Alfabeto alfabetoActual;
    private List<Alfabeto> dbAlfabetos = new ArrayList<>();
    private List<Algoritmo> elAlgoritmo =  new ArrayList<>();
    private List<IEscritor> elEscritor = new ArrayList<>();
    





    /**
     * @return
     */
    public List<String> cargarAlfabetos() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se realiza coneccion a la Base de datos para los Alfabetos");
        System.out.println("******************************");
        DaoAlfabetos BD = new DaoAlfabetos();
        this.dbAlfabetos = BD.getAlfabetos();
        List<String> Alfabetos = new ArrayList<>();
        for (int i=0;i<this.dbAlfabetos.size();i++){
            Alfabetos.add(this.dbAlfabetos.get(i).getNombre());
        }
        return Alfabetos;

    }
    

    /**
     * @param elDTO 
     * @return
     */
    public void procesarPeticion(DTOAlgoritmos elDTO) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se inicia el proceso de la peticion");
        System.out.println("******************************");
        System.out.println();
        if (validar(elDTO)){
            activarAlgoritmos(elDTO);
            List<String> resultados = new ArrayList<>();
            if (elDTO.isModoCodificacion()){
                for (int j=0;j<elDTO.getAlgoritmosSelec().size();j++){
                    resultados.add(this.elAlgoritmo.get(j).codificar(elDTO.getFraseOrigen()));                
                }
            }
            else{
                for (int j=0;j<elDTO.getAlgoritmosSelec().size();j++){
                    resultados.add(this.elAlgoritmo.get(j).decodificar(elDTO.getFraseOrigen()));                
                }
            }
            elDTO.setResultados(resultados);
            escribir(elDTO);
        }
    }

    /**
     * @param elDTO 
     * @return
     */
    private void predefinirAlfabeto(DTOAlgoritmos elDTO) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se predefine el Alfabeto");
        System.out.println("******************************");
        System.out.println();
        this.alfabetoActual = this.dbAlfabetos.get(elDTO.getElAlfabeto());
    }

    /**
     * @param elDTO 
     * @return
     */
    private boolean validar(DTOAlgoritmos elDTO) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se inicia el proceso de la validacion de la frase");
        System.out.println("******************************");
        System.out.println();
        List<String> resultados = new ArrayList<>();
            predefinirAlfabeto(elDTO);
            for (int i=0;i<elDTO.getFraseOrigen().length();i++){
                if (!(containsChar(this.alfabetoActual.getSimbolos(),elDTO.getFraseOrigen().charAt(i)))){
                    resultados.add("Frase con caracter invalido");
                    elDTO.setResultados(resultados);
                    return false;
                }
            }
        return true;
    }

    
    
    
    private boolean containsChar(String s, char search) {
    if (s.length() == 0)
        return false;
    else
        return s.charAt(0) == search || containsChar(s.substring(1), search);
    }
    
    /**
     * @param elDTO 
     * @return
     */
    private void activarAlgoritmos(DTOAlgoritmos elDTO) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se cargan los algoritmos y salidas que se van a utilizar");
        System.out.println("******************************");
        for (int i=0;i<elDTO.getAlgoritmosSelec().size();i++){
            try {
                String str = elDTO.getAlgoritmosSelec().get(i);
                String name = Algoritmo.class.getPackage().getName();
                this.elAlgoritmo.add((Algoritmo) Class.forName(name+"."+str).newInstance());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (int k=0;k<elDTO.getSalidasSelec().size();k++){
            try {
                String str = elDTO.getSalidasSelec().get(k);
                String name = IEscritor.class.getPackage().getName();
                this.elEscritor.add((IEscritor) Class.forName(name+".Escritor"+str).newInstance());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
             
           
        }
    }

    /**
     * @param DTO 
     * @return
     */
    public void escribir(DTOAlgoritmos DTO) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se inicia el proceso de escribir los resultados en los formatos deseados");
        System.out.println("******************************");
        List<String> resultados = DTO.getResultados();
        for (int k=0;k<DTO.getSalidasSelec().size();k++){
                if(this.elEscritor.get(k).escribir(DTO)){
                    resultados.add("Resultados importados a "+elEscritor.get(k).getClass().getSimpleName().substring(8));
                }
                else{
                   resultados.add("Error al importar datos a "+elEscritor.get(k).getClass().getSimpleName().substring(8));
                }
            }
            DTO.setResultados(resultados);
    }

}