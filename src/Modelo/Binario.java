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
public class Binario extends Algoritmo{
    public Binario() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de Codificacion Binaria");
        System.out.println("******************************");
    }
    
    public String codificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String r= "Codificacion en Binario: ";
        char c;
        for (int i=0; i<DTO.getFraseOrigen().length();i++){
            c = DTO.getFraseOrigen().charAt(i);
            if (Character.isWhitespace(c)){
                r += "* ";
            }
            else{
                r += binary2Representation(alfabeto.getSimbolos().indexOf(c),alfabeto) + " ";
            }
        }
        return r;
    }
    
    public String decodificar(DTOAlgoritmos DTO,Alfabeto alfabeto) {
        String r="Decodificacion en Binario: ";
        String[] data = DTO.getFraseOrigen().split(" ");
        int index;
        for (int i=0;i<data.length;i++){
            if (data[i].matches("[01]+")){
                index = Integer.parseInt(data[i],2);
                r += alfabeto.getSimbolos().charAt(index);
            }
            else{
                r += " ";
            }
            
        }
        return r;
    }
    
    private String binary2Representation(int no,Alfabeto alfabeto){
    StringBuilder result = new StringBuilder();
    int i=0;
    while (no > 0){
        result.append(no%2);
        i++;
        no = no/2;
    }
    int size = alfabeto.getSimbolos().length();
    while (result.length()< Integer.toBinaryString(size).length()){
        result.append(0);
    }
    return result.reverse().toString();
}
    
}
