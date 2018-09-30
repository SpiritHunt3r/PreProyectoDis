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
        
        if (validar(elDTO)){
            activarAlgoritmos(elDTO);
            List<String> resultados = new ArrayList<>();
            if (elDTO.isModoCodificacion()){
                for (int j=0;j<elDTO.getAlgoritmosSelec().size();j++){
                    resultados.add(this.elAlgoritmo.get(j).codificar(elDTO,this.alfabetoActual));                
                }
            }
            else{
                for (int j=0;j<elDTO.getAlgoritmosSelec().size();j++){
                    resultados.add(this.elAlgoritmo.get(j).decodificar(elDTO,this.alfabetoActual));                
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
    
    public String getSimbolosAlfabeto(DTOAlgoritmos elDTO){
        return this.dbAlfabetos.get(elDTO.getElAlfabeto()).getSimbolos();
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
        boolean isBinario = false,isCodigoTelefonico = false;
        for (int k=0;k<elDTO.getAlgoritmosSelec().size();k++){
            if (elDTO.getAlgoritmosSelec().get(k).equals("CodigoTelefonico")){
                isCodigoTelefonico = true;
            }
            if (elDTO.getAlgoritmosSelec().get(k).equals("Binario")){
                isBinario = true;
            }
        }
        if (isCodigoTelefonico && !(elDTO.isModoCodificacion())){
            String[] data = elDTO.getFraseOrigen().split(" ");
            int[] valores = getMaxIndexAlfabeto();
            for (int i=0;i<data.length;i++){
                try{
                    if (Integer.valueOf(data[i]) >= (valores[1]*10+valores[2]) || Integer.valueOf(data[i]) % 10 > valores[0]){
                        resultados.add("Frase con valor no codificable");
                        elDTO.setResultados(resultados);
                        return false;
                    }   
                }
                catch (Exception e){
                if (data[i] == "*"){
                    resultados.add("Frase con caracter invalido");
                    elDTO.setResultados(resultados);
                    return false;
                    }
                }
                }
            }
        else if (isBinario && !(elDTO.isModoCodificacion())){
            String[] data = elDTO.getFraseOrigen().split(" ");
            for (int i=0;i<data.length;i++){
                if(data[i].matches("[01]+")){
                    int a = Integer.parseInt(data[i],2);
                    if (a > this.alfabetoActual.getSimbolos().length()){
                        resultados.add("Frase con caracteraa invalido");
                        elDTO.setResultados(resultados);
                        return false;
                    }
                    
                }
                else if (!(data[i] == "*")){
                    
                }
                else{
                    resultados.add("Frase con caracter invalido");
                    elDTO.setResultados(resultados);
                    return false;
                }
            }
        }
        else {
            for (int i=0;i<elDTO.getFraseOrigen().length();i++){
                if (!(containsChar(this.alfabetoActual.getSimbolos(),elDTO.getFraseOrigen().charAt(i)))){
                        if (!(elDTO.getFraseOrigen().charAt(i) == ' ')){
                            resultados.add("Frase con caracter invalido");
                            elDTO.setResultados(resultados);
                            return false;
                        }
                }
            }
        }
        return true;
    }

    
    
    
    
    
    /**
     * @param elDTO 
     * @return
     */
    private void activarAlgoritmos(DTOAlgoritmos elDTO) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se cargan los algoritmos");
        System.out.println("******************************");
        this.elAlgoritmo.clear();
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
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se cargan las Salidas");
        System.out.println("******************************");
        this.elEscritor.clear();
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
    
    
    
    
    private int[] getMaxIndexAlfabeto() {
        int[] data = new int[3];
        String sim = this.alfabetoActual.getSimbolos();
        int entero = sim.length() / 10;
        double flotante = sim.length() / 10.0;
        int size;
        if (flotante > (float) entero){
            size = entero+1;
            data[2] = size-1;
        }
        else{
            size = entero;
            data[2] = size;
        }
        data[0]=size;
        int pos = 0;
        for (int i=0;i<10;i++){
            if (pos > sim.length()){
                break;
            }
            else{
                data[1]=i;
            }
            pos+=size;
        }
        return data;
    }
    
    private boolean containsChar(String s, char search) {
    if (s.length() == 0)
        return false;
    else
        return s.charAt(0) == search || containsChar(s.substring(1), search);
    }

}