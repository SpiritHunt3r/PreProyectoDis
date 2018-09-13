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
        String Direccion = System.getProperty("user.dir")+"\\src\\BD\\";
        String line;
        int id = 0;
        List<String> lista_alfabetos = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Direccion+"Alfabetos.txt");
            BufferedReader br = new BufferedReader(fr);
            
            try {
                while((line = br.readLine()) != null){
                    //Pensar en algun metodo para organizar los Alfabetos por id/nombre/items
                    Alfabeto tmp = new Alfabeto();
                    if (id == 0){
                        tmp.setId(id);
                        tmp.setNombre("Default");
                        tmp.setSimbolos(line);
                    }
                    else{
                        tmp.setId(id);
                        tmp.setNombre("Alfabeto " + String.valueOf(id));
                        tmp.setSimbolos(line);
                    }
                    lista_alfabetos.add(line+"\n");
                    this.dbAlfabetos.add(tmp);
                    id++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_alfabetos;
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
        this.alfabetoActual = this.dbAlfabetos.get(elDTO.getElAlfabeto());
    }

    /**
     * @param elDTO 
     * @return
     */
    private boolean validar(DTOAlgoritmos elDTO) {
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

    
    
    
    public boolean containsChar(String s, char search) {
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