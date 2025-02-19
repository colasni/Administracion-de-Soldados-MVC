package modelo;
public class Soldado {

    String nombre;
    String id;
    String rango;
    String mision = "Sin misión";
    String estado = "Sin estado";

    public Soldado(String nombre, String id, String rango) {
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;  
    }

    public void TodosLosSoldados(String id, String rango){
        this.id=id;
        this.rango=rango;


    }

    public void asignarMision(String mision) {
        this.mision = mision;
        System.out.println("Mision asignada: " + mision);
    }

    public void reportarEstado(String estado) {
        this.estado = estado;
        System.out.println("Estado asignado: " + estado);

    }

    public String patrullar() {
        return "El soldado " + this.nombre + " esta patrullando.";
    }

    public String saludar(){
        return "Hola " + this.nombre + ", soy " + this.nombre + ".";
    }

    public void regañado(){


    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMision() {
        return mision;
    }


    public void mostrarInformacion() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

}