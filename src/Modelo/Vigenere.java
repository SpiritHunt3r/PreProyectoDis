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
    public String codificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        char[] charArray = DTO.getFraseOrigen().toCharArray();
        String r = "";
        boolean primero=true;
        for (int i=0;i<charArray.length;i++){
            if(charArray[i] == ' '){
                r+= " ";
                primero = !primero;
            }
            else if (primero) {
                r+= followLetter(alfabeto.getSimbolos(),DTO.getCifra()/10,charArray[i],true);
                primero = false;
            }
            else{
                r+= followLetter(alfabeto.getSimbolos(),DTO.getCifra()%10,charArray[i],true);
                primero = true;
            }
        }
        return r;
    }

    /**
     * @param mensaje 
     * @return
     */
    public String decodificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        char[] charArray = DTO.getFraseOrigen().toCharArray();
        String r = "";
        boolean primero=true;
        for (int i=0;i<charArray.length;i++){
            if(charArray[i] == ' '){
                r+= " ";
                primero = !primero;
            }
            else{
                if (primero) {
                    r+= followLetter(alfabeto.getSimbolos(),DTO.getCifra()/10,charArray[i],false);
                    primero = false;
                }
                else{
                    r+= followLetter(alfabeto.getSimbolos(),DTO.getCifra()%10,charArray[i],false);
                    primero = true;
                }
            }
        }
        return r;
    }
    
    private char followLetter(String source,int plus,char start,boolean codificacion){
        int pos = source.indexOf(start);
        if (codificacion){
            pos += plus;
            if (pos <= source.length() || pos >= 0){
                return source.charAt(pos);
            }
            else{
                pos -= source.length();
                return source.charAt(pos);
            }
        }
        else{
            pos -= plus;
            if (pos <= source.length() || pos >= 0){
                return source.charAt(pos);
            }
            else{
                pos += source.length();
                return source.charAt(pos);
            }
        }
        
        
        
    }

}