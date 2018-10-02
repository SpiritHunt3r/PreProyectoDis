/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

import Modelo.Alfabeto;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ayma-93
 */
public class FraseNoConsecutivoNoDuplicado extends FraseBuilder {

    public FraseNoConsecutivoNoDuplicado() {
        super.frase = "";
    }
    
    
    private boolean consecutivo(char last, char next, String alfabeto){
        
        int i;
         i = alfabeto.indexOf(Character.toString(last));
        if (i == 0){
            return next == alfabeto.charAt(i+1);
        }
        else if (i == (alfabeto.length() - 1)) {
            return next == alfabeto.charAt(i-1);
        }
        else {
            return (next == alfabeto.charAt(i+1) || next == alfabeto.charAt(i-1));
        }        
    }

    @Override
    public String toString() {
        return super.frase; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void generarFrase(Integer largo){
        Random aleatorio = new Random(System.currentTimeMillis());
        String alf = alfabeto.getSimbolos();
        int n,m;
        char c;
        m = largo;
        for (int i = 0; i < m; i++) {
            n = aleatorio.nextInt(alf.length()-1);
            c = alf.charAt(n);
            
            if ("".equals(super.frase)){
               super.frase = super.frase.concat(Character.toString(c));
            }
            else if (!consecutivo(super.frase.charAt(super.frase.length()-1), c ,alfabeto.getSimbolos())){
                if (-1 == super.frase.indexOf(Character.toString(c))){
                    super.frase = super.frase.concat(Character.toString(c));
                    alf = alf.replace(Character.toString(c), "");                    
                }
                else {
                    --i;
                }
            } 
            else {
                --i;
            }
        }
    }
}
