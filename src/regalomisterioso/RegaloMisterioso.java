/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regalomisterioso;

import javax.swing.SwingUtilities;
import regalomisterioso.control.ControlAplicacion;
import regalomisterioso.modelo.Modelo;
import regalomisterioso.vista.VentanaAplicacion;

/**
 *
 * @author luis
 */
public class RegaloMisterioso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniciarAplicacion();
            }
        });
    }
    
    public static void iniciarAplicacion(){
        Modelo m = new Modelo();
        ControlAplicacion c = new ControlAplicacion(m);
        VentanaAplicacion v = new VentanaAplicacion(c);
        v.init();
    }
}
