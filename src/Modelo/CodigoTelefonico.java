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
    private String[] matriz = new String[10]; 

    /**
     * @param mensaje 
     * @return
     */
    public String codificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        distribuirAlfabeto(alfabeto);
        String frase = DTO.getFraseOrigen();
        char c;
        String r = "Codificacion en CodigoTelefonico: \n";
        for (int i=0;i<frase.length();i++){
            c = frase.charAt(i);
            if (Character.isWhitespace(c)){
                r+= "* ";
            }
            else{
                r += indexPos(c)+" ";
            }
            
        }
        return r;
    }

    /**
     * @param mensaje 
     * @return
     */
    public String decodificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        distribuirAlfabeto(alfabeto);
        String[] data = DTO.getFraseOrigen().split(" ");
        String r = "Decodificacion en CodigoTelefonico: \n";
        for (int i=0; i<data.length;i++){
            if (data[i].charAt(i) == '*'){
                r+= " ";
            }
            else{
                int p = Character.getNumericValue(data[i].charAt(0));
                int q = Character.getNumericValue(data[i].charAt(1));
                r+= matriz[p].charAt(q);
                
            }
            
        }
        return r.toString();
    }

    /**
     * @param unAlfabeto 
     * @return
     */
    private void distribuirAlfabeto(Alfabeto unAlfabeto) {
        String sim = unAlfabeto.getSimbolos();
        int entero = sim.length() / 10;
        double flotante = sim.length() / 10.0;
        int size;
        if (flotante > (float) entero){
            size = entero+1;
        }
        else{
            size = entero;
        }
        int pos = 0;
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
    }
    
    private String indexPos(char c){
        String data="";
       for (int i=0;i<10;i++){
           for (int j=0;j<matriz[i].length();j++){
               if (matriz[i].charAt(j) == c){
                   data= String.valueOf(i)+String.valueOf(j);
                   return data;
               }
           }
       }
       return data; 
    }

}