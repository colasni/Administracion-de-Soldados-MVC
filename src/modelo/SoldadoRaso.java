package modelo;
public class SoldadoRaso extends Rango{

    private String nombre;
    private String id;
    private String rango;
    private int nivel;
    
    
    public SoldadoRaso(String nombre, String id, String rango, int nivel) {
        super(nombre, id, rango, nivel);
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
        this.nivel = nivel;
        //TODO Auto-generated constructor stub
    }

    @Override
    void realizarAccion() {
        String accion = "Ejecutar las operaciones básicas de vigilancia y seguridad.";
    }

    @Override
    public void asignarMision(String mision) {
        this.mision = mision;
    }

    @Override
    public void reportarEstado(String estado) {
        this.estado = estado;
        System.out.println("Estado asignado: " + estado);

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String getRango() {
        return rango;
    }

    @Override
    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getMision() {
        return mision;
    }
    
}
