/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

//import administrador.AdmServidor;
//import administrador.Estadistica;
//import administrador.Usuario;
import Comunicacion.ObjetoComunicador;
import Controlador.DTOAlgoritmos;
import Comunicacion.TipoAccion;
import administrador.AdmServidor;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
**/
public class Servidor {
    private ServerSocket servidor;   // objeto que se encarga de atender peticiones externas
    private  int PUERTO = 5000; // numero de puerto por donde va a atender peticiones

   // la conexion de escritura del servidor
    private OutputStream conexionSalida;
    private ObjectOutputStream flujoSalida;

    // la conexion de lectura del servidor
    private InputStream conexionEntrada;
    private ObjectInputStream flujoEntrada;


    // socket que contiene la conexion con el cliente
    private Socket cliente;         // el proceso cliente que esta atendiendo...

    private AdmServidor adm = new AdmServidor();

    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }

//    public AdmServidor getAdm() {
//        return adm;
//    }
//
//    public void setAdm(AdmServidor adm) {
//        this.adm = adm;
//    }



    

    public void inicialiceServidor(JTextArea log){
        try {
            servidor = new ServerSocket(PUERTO);
            while (true){
                //System.out.println("Esperando una solicitud de un cliente...");
                log.setText(log.getText()+ "\nEsperando una solicitud de un cliente...");
                cliente = servidor.accept();  // acepta la solicitud de un cliente

                log.setText(log.getText()+ "\nEstableciendo canal de escritura...");
                //System.out.println("Estableciendo canal de escritura...");
                // se establece DE PRIMERO  el canal de comunicacion-Escritura
                conexionSalida =  cliente.getOutputStream();
                flujoSalida = new ObjectOutputStream(conexionSalida);

                //System.out.println("Estableciendo canal de lectura ...");
                log.setText(log.getText()+ "\nEstableciendo canal de lectura...");
                // se establece DE SEGUNDO el canal de comunicacion-Lectura
                conexionEntrada = cliente.getInputStream();
                flujoEntrada = new ObjectInputStream(conexionEntrada);

                // atender la peticion...
                log.setText(log.getText()+ "\nAtendiendo peticion...");
                procesePeticion(log);

                log.setText(log.getText()+ "\nDesconectando...");
                log.setCaretPosition(log.getText().length());  // manda el log al final
                flujoEntrada.close();
                flujoSalida.close();
                cliente.close();
            }
        } catch (IOException ex) {
            System.out.println("Problemas creando el servidor en el puerto "+ PUERTO);
        }
    }

private void procesePeticion(JTextArea log) {
        try {
            ObjetoComunicador obj = (ObjetoComunicador) flujoEntrada.readObject();
            // detectar lo que le enviaron...
            if (obj.getAccion() == TipoAccion.GET_DTO){
                log.setText(log.getText()+ "\nAtendiendo peticion OBTIENE EL DTO..");
                obj.setDatoSalida(adm.getDTO(obj));
            }
            if (obj.getAccion() == TipoAccion.PROCESAR_PETICION){
                log.setText(log.getText()+ "\nAtendiendo peticion PROCESAR PETICION..");
                obj.setDatoSalida(adm.procesarPeticion(obj));
            }
            if (obj.getAccion() == TipoAccion.GET_SIMBOLOS_ALFABETO){
                log.setText(log.getText()+ "\nAtendiendo peticion OBTENER SIMBOLOS..");
                obj.setDatoSalida(adm.geSimbolosAlfabeto(obj));
            }
            if (obj.getAccion() == TipoAccion.CARGAR_ALFABETO){
                log.setText(log.getText()+ "\nAtendiendo peticion CARGAR ALFABETOS..");
                obj.setDatoSalida(adm.cargarAlfabetos());
            }
            
            /*
            if (objeto.getAccion() == TipoAccion.REGISTRAR_USUARIO){
                String elLogin=(String) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion REGISTRAR USUARIO.."+ elLogin);
                objeto.setDatoSalida(adm.registrar(elLogin));
            }
            if (objeto.getAccion() == TipoAccion.DESACTIVAR_USUARIO){
                String elLogin=(String) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion DESACTIVAR USUARIO.."+ elLogin);
                objeto.setDatoSalida(adm.desactivar(elLogin));
            }
            
             if (objeto.getAccion() == TipoAccion.REVISAR_USUARIO){
                String elLogin=(String) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion REVISAR USUARIO.."+ elLogin);
                objeto.setDatoSalida(adm.revisar(elLogin));
            }

             
             if (objeto.getAccion() == TipoAccion.ENVIAR_ARCHIVO){
                ArrayList losDatos =(ArrayList) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion ENVIAR ARCHIVO ..");
                String [] nArchivo = ((String)losDatos.get(0)).split("\\");
                log.setText(log.getText()+ "\nrecibio archivo "+ nArchivo[nArchivo.length-1]);
                objeto.setDatoSalida(Boolean.TRUE);
            }
             */
             

           flujoSalida.writeObject(obj);
        } catch (IOException ex) {
            System.out.println("Problemas leyendo o escribiendo en el flujo entrada/salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problemas en la conversion del objeto recibido...");
        }
    }
}
