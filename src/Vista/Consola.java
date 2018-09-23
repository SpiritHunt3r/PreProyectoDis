/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Controlador.DTOAlgoritmos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author juan_
 */
public class Consola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
        
        
        
    }
    
    private static void menu(){
        List<String> lista_algoritmos = new ArrayList<>();
        List<String> lista_salidas = new ArrayList<>();
        
        Controlador ctrl = new Controlador();
        DTOAlgoritmos data = new DTOAlgoritmos();
        List<String> Alfabetos = ctrl.cargarAlfabetos();

        Scanner keyFrs = new Scanner(System.in);
        
        
        int check=0,optTMP;
        
            while (check==0){
                Scanner keyInt = new Scanner(System.in);
                System.out.println("Alfabetos Guardados:");
                for (int i=0;i<Alfabetos.size();i++){
                    System.out.println(String.valueOf(i+1) + " - " +Alfabetos.get(i));
                }
                System.out.print("Seleccione un alfabeto:");
                try{
                optTMP = keyInt.nextInt()-1;
                if (optTMP >= Alfabetos.size() || optTMP < 0){
                    System.out.println("Seleccione una opcion validad dentro del rango");
                    System.out.println();
                }
                else
                {
                    data.setElAlfabeto(optTMP);
                    check =1;
                }
                
                }
                catch (Exception e){
                    System.out.println("Seleccione una opcion numerica");
                }
            }
            
            System.out.println("Simbolos del Alfabeto seleccionado: "+ctrl.getSimbolosAlfabeto(data));
            System.out.println("* El espacio se puede utilizar en cualquier alfabeto");
            System.out.println();
            System.out.println("Frase para procesar:");
            data.setFraseOrigen(keyFrs.nextLine());
            
            
            check =0;
           while (check == 0){
            Scanner keyStr2 = new Scanner(System.in);
            System.out.println();
            System.out.println("Metodos disponibles:");
            System.out.println("1 - Codificacion");
            System.out.println("2 - Decodificacion");
            System.out.print("Seleccione un metodo:");
            try {
            int metodo = keyStr2.nextInt();
            if (metodo ==1){
                data.setModoCodificacion(true);
                check = 1;
            }
            else if (metodo == 2){
                data.setModoCodificacion(false);
                check = 1;
            }
            else {
                System.out.println("Debe seleccionar una de las dos opciones");
            }
            }
            catch(Exception e){
                System.out.println("Debe ingresar un valor numerico ya sea 1 o 2");
            }
           }
            
           check =0;
           while (check==0){
                Scanner keyStr = new Scanner(System.in);
                System.out.println();
                System.out.println("Algoritmos disponibles:");
                for (int i=0;i<data.getLosAlgoritmos().size();i++){
                    System.out.println(String.valueOf(i+1) + " - " +data.getLosAlgoritmos().get(i));
                }
                System.out.print("Seleccione los algoritmos separados por comas (,):");
                String Algoritmos = keyStr.nextLine();
                String[] opts = Algoritmos.split(",");
                try{
                    for (int j=0;j<opts.length;j++){
                        optTMP = Integer.valueOf(opts[j])-1;
                        if (optTMP >= data.getLosAlgoritmos().size() || optTMP < 0){
                            System.out.println("La opcion "+String.valueOf(optTMP+1)+" se ignora debido a que es un valor invalido");
                        }
                        else{
                            lista_algoritmos.add(data.getLosAlgoritmos().get(optTMP));
                            if (data.getLosAlgoritmos().get(optTMP).equals("Vigenere")){
                                Scanner cifra = new Scanner(System.in);
                                System.out.print("Ingrese una cifra entre 10-99, en caso de no ser valida o superior el default es 50:");
                                try{
                                    data.setCifra(cifra.nextInt());
                                    if (data.getCifra()<10){
                                        data.setCifra(50);
                                    }
                                }
                                catch (Exception e){
                                    data.setCifra(50);
                                }
                            }
                        }

                    }
                    if (lista_algoritmos.size() == 0){
                        System.out.println("Debe seleccionar al menos un algoritmo valido");
                    }
                    else{
                        data.setAlgoritmosSelec(lista_algoritmos);
                        check = 1;
                    }
                    
                }
                catch (Exception e){
                    System.out.println("Ingreso un valor invalido o el formato no es el correcto");
                }
            }
            
           
           check =0;
           while (check == 0){
            Scanner keyStr1 = new Scanner(System.in);
            System.out.println();
            System.out.println("Salidas disponibles:");
            for (int i=0;i<data.getLasSalidas().size();i++){
                System.out.println(String.valueOf(i+1) + " - " +data.getLasSalidas().get(i));
            }
            System.out.print("Seleccione las salidas separadas por comas (,):");
            String Salidas = keyStr1.nextLine();
            String[] opts1 = Salidas.split(",");
            try{
                    for (int j=0;j<opts1.length;j++){
                        optTMP = Integer.valueOf(opts1[j])-1;
                        if (optTMP >= data.getLasSalidas().size() || optTMP < 0){
                            System.out.println("La opcion "+String.valueOf(optTMP+1)+" se ignora debido a que es un valor invalido");
                        }
                        else{
                            lista_salidas.add(data.getLasSalidas().get(optTMP));
                        }

                    }
                    if (lista_salidas.size() == 0){
                        System.out.println("Debe seleccionar al menos una salida valida");
                    }
                    else{
                        data.setSalidasSelec(lista_salidas);
                        check = 1;
                    }
                    
                }
                catch (Exception e){
                    System.out.println("Ingreso un valor invalido o el formato no es el correcto");
                }
           }
           
           
            
            
            ctrl.procesarPeticion(data);

            System.out.println();
            System.out.println();
            System.out.println("Resultados obtenidos:");
            System.out.println();
            
            if (data.getResultados() != null){
                for (int i=0;i<data.getResultados().size();i++){
                    System.out.println(data.getResultados().get(i));
                }
            }
            
            Scanner key = new Scanner(System.in);
            System.out.println();
            System.out.print("Desea realizar otra operacion:(Y/N)");
            String r = key.nextLine();
            if (r.equals("Y")||r.equals("y")){
                menu();
            }
            
        }
    
}
