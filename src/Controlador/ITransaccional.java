package Controlador;


import java.util.*;

/**
 * 
 */
public interface ITransaccional {



    /**
     * @param obj 
     * @return
     */
    public boolean agregar(Object obj);

    /**
     * @param obj 
     * @return
     */
    public boolean modificar(Object obj);

    /**
     * @param llave 
     * @return
     */
    public Object consultar(Object llave);

    /**
     * @param obj 
     * @return
     */
    public boolean eliminar(Object obj);

}