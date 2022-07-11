/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regalomisterioso.modelo.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import regalomisterioso.modelo.Persona;

/**
 *
 * @author luis
 */
public class PersonaWriter {
    public static void guardar(Persona p){
        try {
            FileWriter fstream = new FileWriter(p.getNombre() + ".txt");
            try (BufferedWriter salida = new BufferedWriter(fstream)) {
                salida.write(p.getNombreReceptor());
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
