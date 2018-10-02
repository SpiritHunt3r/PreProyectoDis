/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

import Modelo.Alfabeto;
import java.util.Random;

/**
 *
 * @author ayma-93
 */
public class FraseConsecutivoDuplicado extends FraseBuilder{

    
    public FraseConsecutivoDuplicado() {
        super.frase = "";
    }


    @Override
    public String toString() {
        return super.frase;
    }
    
    
    
    @Override
    public void generarFrase(Integer largo){
        Random aleatorio = new Random(System.currentTimeMillis());
        int n;
        char c;
        for (int i = 0; i < largo; i++) {
            n = aleatorio.nextInt(super.alfabeto.getSimbolos().length());
            c = super.alfabeto.getSimbolos().charAt(n);
            super.frase = super.frase.concat(Character.toString(c));
            
        }
    }
}
