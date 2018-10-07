/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import Comunicacion.ObjetoComunicador;
import Controlador.Controlador;
import Controlador.DTOAlgoritmos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M-01
 */
public class AdmServidor {
    
    private Controlador controlador;
    
    public AdmServidor(){
        controlador= new Controlador();
    }
    
    public ObjetoComunicador procesarPeticion(ObjetoComunicador obj){
        DTOAlgoritmos data = obj.getDatos();
        controlador.procesarPeticion(data);
        obj.setDatos(data);
        return obj;
    }
    
    public String geSimbolosAlfabeto(ObjetoComunicador obj){
        String  simbolosAlfabeto = controlador.getSimbolosAlfabeto((DTOAlgoritmos) obj.getDatoEntrada());
        return simbolosAlfabeto;
    }
    
    public List<String> cargarAlfabetos(){
        return controlador.cargarAlfabetos();
    }
    
    public ObjetoComunicador getDTO(ObjetoComunicador obj){
        obj.setDatos(new DTOAlgoritmos());
        return obj;
    }
    /*
    public boolean registrar(String login){
        Usuario u=new Usuario(login);
        if (listaUsr.indexOf(u)==-1){
            listaUsr.add(u);
            return true;
        }
        return false;
    }
    
    public boolean desactivar (String login){
        Usuario u=new Usuario(login);
        int donde= listaUsr.indexOf(u);
        if (donde!=-1){
            listaUsr.get(donde).setActivo(false);
            return true;
        }
        return false;
    }
    
    public boolean revisar(String login){
        Usuario u=new Usuario(login);
        int donde = listaUsr.indexOf(u);
        if (donde != -1 && listaUsr.get(donde).isActivo()) {
            return true;
        }
        return false;
            
    }*/
}
