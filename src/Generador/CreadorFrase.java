/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

/**
 *
 * @author ayma-93
 */
public class CreadorFrase {
    private FraseBuilder creadorFrase;

    public void setCreadorFrase(FraseBuilder creadorFrase) {
        this.creadorFrase = creadorFrase;
    }
    
    public void generarFrase(int largo){
        creadorFrase.generarFrase(largo);
    }
}
