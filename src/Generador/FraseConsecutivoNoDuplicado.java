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
public class FraseConsecutivoNoDuplicado extends FraseBuilder{

    public FraseConsecutivoNoDuplicado() {
        super.frase = "";
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
            else if (-1 == super.frase.indexOf(Character.toString(c))){
                    super.frase = super.frase.concat(Character.toString(c));
                    alf = alf.replace(Character.toString(c), "");                    
                }            
            else {
                --i;
            }
            
            
        }
    }

   

    @Override
    public String toString() {
        return super.frase;
    }
    
}
