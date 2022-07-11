/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regalomisterioso.modelo;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import regalomisterioso.modelo.util.PersonaWriter;

/**
 *
 * @author luis
 */
public class Modelo extends AbstractTableModel {

    public Modelo() {
        this.personas = new LinkedList<>();
        this.tabla = null;
    }
    
    
    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return Persona.obtenerEncabezado().length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return tabla[i][i1];
    }
    
    @Override
    public String getColumnName(int i){
        return Persona.obtenerEncabezado()[i];
    }
    
    public void intentaAsignarPersonas(){
        List<Persona> lista2 = new LinkedList<>();
        for(Persona p: personas){
            lista2.add(p);
        }
        Collections.shuffle(lista2);
        
        Iterator<Persona> ite1 = personas.iterator();
        Iterator<Persona> ite2 = lista2.iterator();
        
        while(ite1.hasNext() && ite2.hasNext()){
            ite1.next().setReceptor(ite2.next());
        }
    }
    
    public boolean alguienSeRegalaASiMismo(){
        for(Persona p : personas){
            if(p.regalaASiMismo()){
                return true;
            }
        }
        return false;
    }
    
    public void asignaRegalos() throws IllegalStateException{
        resetearContadoresDeConsultas();
        boolean seAsignaronBien = false;
        if (personas.size() <= 1){
            throw new IllegalStateException("No se pueden asignar aún los regalos ya que no hay suficientes personas");
        }
        do{
            intentaAsignarPersonas();
            seAsignaronBien = !alguienSeRegalaASiMismo();
        } while (!seAsignaronBien);
        actualizarTabla();
    }
    
    public void actualizarTabla(){
        Object[][] nuevaTabla = new Object[personas.size()][3];
        int i = 0;
        for (Persona p : personas){
            nuevaTabla[i][0] = p.getNombre();
            nuevaTabla[i][1] = p.leRegalaAAlguien();
            nuevaTabla[i][2] = p.getVecesConsultadas();
            i++;
        }
        tabla = nuevaTabla;
        fireTableDataChanged();
    }
    
    public boolean hayPersona(Persona p){
        for(Persona per: personas){
            if(per.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    public void agregar(String nombre) throws IllegalArgumentException{
        Persona p = new Persona(nombre);
        if(hayPersona(p)){
            throw new IllegalArgumentException("Ya existe la persona en la lista");
        }
        personas.add(p);
        actualizarTabla();
    }
    
    public void eliminar(Persona p){
        personas.remove(p);
        actualizarTabla();
        fireTableDataChanged();
    }
    
    public String consultarRegaloDe(String nombre) throws IllegalArgumentException {
        for(Persona p: personas){
            if(p.getNombre().equals(nombre)){
                p.incrementarVecesConsultadas();
                actualizarTabla();
                return p.getNombreReceptor();
            }
        }
        throw new IllegalArgumentException("No se ha encontrado a nadie con el nombre de " + nombre);
    }
    
    public void resetearContadoresDeConsultas(){
        for(Persona p : personas){
            p.resetearVecesConsultadas();
        }
    }
    
    public void guardar() throws IllegalStateException{
        if(personas.size() == 0){
            throw new IllegalStateException("No hay personas por guardar");
        }
        for(Persona p: personas){
            PersonaWriter.guardar(p);
        }
    }
    
    private List<Persona> personas;
    private Object[][] tabla;
}
