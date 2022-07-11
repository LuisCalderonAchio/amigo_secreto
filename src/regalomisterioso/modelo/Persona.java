package regalomisterioso.modelo;

public class Persona {

    public Persona(String nombre) {
        this.nombre = nombre;
        this.vecesConsultadas = 0;
        this.receptor = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreReceptor() {
        return receptor != null ? receptor.nombre : "nadie";
    }

    public int getVecesConsultadas() {
        return vecesConsultadas;
    }

    public void setReceptor(Persona receptor) {
        this.receptor = receptor;
    }
    
    public boolean regalaASiMismo() {
        return equals(receptor);
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Persona){
            return this.nombre.equals(((Persona) o).getNombre());
        }
        return false;
    }
    
    public boolean leRegalaAAlguien(){
        return receptor != null;
    }
    
    public static String[] obtenerEncabezado(){
        return encabezado;
    }
    
    public void incrementarVecesConsultadas(){
        vecesConsultadas++;
    }
    
    public void resetearVecesConsultadas(){
        vecesConsultadas = 0;
    }
    
    private static String[] encabezado = {"Nombre", "Tiene receptor asignado", "Veces que se ha consultado"};
    
    private String nombre;
    private Persona receptor;
    private int vecesConsultadas;
}
