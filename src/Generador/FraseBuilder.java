/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

import Modelo.Alfabeto;

/**
 *
 * @author ayma-93
 */
public abstract class FraseBuilder{
    protected Alfabeto alfabeto;
    protected String frase; 
    
    public abstract void generarFrase(Integer largo);

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public String getFrase() {
        return frase;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    
    
}
