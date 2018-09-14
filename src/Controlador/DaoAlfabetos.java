package Controlador;


import Modelo.Alfabeto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class DaoAlfabetos {

    /**
     * Default constructor
     */
    public DaoAlfabetos() {
    }



    /**
     * @param obj 
     * @return
     */
    public boolean validar(Object obj) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public List<String> getAlfabetosString() {
        String Direccion = System.getProperty("user.dir")+"\\src\\BD\\";
        String line;
        int id = 0;
        List<String> lista_alfabetos = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Direccion+"Alfabetos.txt");
            BufferedReader br = new BufferedReader(fr);
            
            try {
                while((line = br.readLine()) != null){
                    lista_alfabetos.add(line+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_alfabetos;
    }
    
    public List<Alfabeto> getAlfabetos() {
        String Direccion = System.getProperty("user.dir")+"\\src\\BD\\";
        String line;
        int id = 0;
        List<Alfabeto> lista_alfabetos = new ArrayList<>();
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
                    lista_alfabetos.add(tmp);
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

}