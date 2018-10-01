/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;

/**
 *
 * @author juan_
 */
public class PalabraClave extends Algoritmo{

    public PalabraClave() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de Palabra Clave");
        System.out.println("******************************");
    }
    

    public String codificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String r = "Codificacion en PalabraClave: \n";
        int palabraSize = DTO.getPalabraclave().length();
        int pos = 0;
        int charAtFrase, charAtPalabra;
        for (int i=0;i<DTO.getFraseOrigen().length();i++){
            if (Character.isWhitespace(DTO.getFraseOrigen().charAt(i))){
                r+= DTO.getFraseOrigen().charAt(i);
                pos = 0;
            }
            else{
                charAtFrase = alfabeto.getSimbolos().indexOf(DTO.getFraseOrigen().charAt(i))+1;
                charAtPalabra = alfabeto.getSimbolos().indexOf(DTO.getPalabraclave().charAt(pos%palabraSize))+1;
                r+= alfabeto.getSimbolos().charAt(getCodedChar(charAtFrase,charAtPalabra,alfabeto.getSimbolos().length(),true));
                pos++;
            }
        }
        return r;
    }

    
    public String decodificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String r = "Decodificacion en PalabraClave: \n";
        int palabraSize = DTO.getPalabraclave().length();
        int pos = 0;
        int charAtFrase, charAtPalabra;
        for (int i=0;i<DTO.getFraseOrigen().length();i++){
            if (Character.isWhitespace(DTO.getFraseOrigen().charAt(i))){
                r+= DTO.getFraseOrigen().charAt(i);
                pos = 0;
            }
            else{
                charAtFrase = alfabeto.getSimbolos().indexOf(DTO.getFraseOrigen().charAt(i))+1;
                charAtPalabra = alfabeto.getSimbolos().indexOf(DTO.getPalabraclave().charAt(pos%palabraSize))+1;
                r+= alfabeto.getSimbolos().charAt(getCodedChar(charAtFrase,charAtPalabra,alfabeto.getSimbolos().length(),false));
                pos++;
            }
        }
        return r;
    }
    
    private int getCodedChar(int charAtFrase, int charAtPalabra,int size, boolean tipo){
        int actual;
        if(tipo){
            actual = charAtFrase + charAtPalabra;
            if (actual > size){
                actual -= size;
            }
        }
        else{
            actual = charAtFrase - charAtPalabra;
            if (actual < 0){
                actual += size;
            }
        }
        return actual-1;
    }
    
}
