/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regalomisterioso.control;

import javax.swing.table.AbstractTableModel;
import regalomisterioso.modelo.Modelo;

/**
 *
 * @author luis
 */
public class ControlAplicacion {

    public ControlAplicacion(Modelo datos) {
        this.datos = datos;
    }
    
    public AbstractTableModel getDatos(){
        return datos;
    }

    public void agregar(String nombre) throws IllegalArgumentException {
        datos.agregar(nombre);
    }
    
    public void asignarRegalos() throws IllegalStateException {
        datos.asignaRegalos();
    }

    public String consultar(String nombre) throws IllegalArgumentException{
        return datos.consultarRegaloDe(nombre);
    }

    public void guardar() throws IllegalStateException {
        datos.guardar();
    }
    
    private Modelo datos;
}
