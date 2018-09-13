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
            predefinirAlfabeto(elDTO);
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
        if (elDTO.getElAlfabeto() < 0 || elDTO.getElAlfabeto() > this.dbAlfabetos.size()){
            resultados.add("Alfabeto invalido");
        }
        for (int i=0;i<elDTO.getAlgoritmosSelec().size();i++){
            if (!(elDTO.getLosAlgoritmos().contains(elDTO.getAlgoritmosSelec().get(i)))){
                resultados.add("Algoritmo invalido");
            }
        }
        for (int k=0;k<elDTO.getSalidasSelec().size();k++){
            if (!(elDTO.getLasSalidas().contains(elDTO.getSalidasSelec().get(k)))){
                resultados.add("Salida invalida");
            }
        }
        if (resultados.size()==0){
            return true;
        }
        return false;
    }

    /**
     * @param elDTO 
     * @return
     */
    private void activarAlgoritmos(DTOAlgoritmos elDTO) {
        for (int i=0;i<elDTO.getAlgoritmosSelec().size();i++){
           String str = elDTO.getAlgoritmosSelec().get(i);
           switch (str){
               case "Vigenere": this.elAlgoritmo.add(new Vigenere());
                                break;
               case "Transposicion": this.elAlgoritmo.add(new Transposicion());
                                break;
               case "CodigoTelefonico": this.elAlgoritmo.add(new CodigoTelefonico());
                                break;        
           }
        }
        for (int k=0;k<elDTO.getSalidasSelec().size();k++){
            String str = elDTO.getSalidasSelec().get(k);
            switch (str){
               case "TXT": this.elEscritor.add(new EscritorTxT());
                                break;
               case "PDF": this.elEscritor.add(new EscritorPDF());
                                break;                 
               case "XML": this.elEscritor.add(new EscritorXML());
                                break;       
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