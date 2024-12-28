package modelo;
public class Coronel extends Rango{
    private String nombre;
    private String id;
    private String rango;
    private int nivel;
    private String estrategia;
    private String patru;
    private String salu;


    public Coronel(String nombre,String id,String rango,int nivel,String estrategia) {
        super(nombre,id,rango,nivel);
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
        this.nivel = nivel;
        this.estrategia = estrategia;
    }

    @Override
    void realizarAccion() {
        String accion = "Garantizar la seguridad general y ajustar las políticas de patrullaje según las amenazas o necesidades.";
    }


    @Override
    public void asignarMision(String mision) {
        this.mision = mision;
        System.out.println("Mision asignada: " + mision);
    }

    @Override
    public String getMision() {
        return mision;
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

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
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

    public String getPatru() {
        return patru;
    }

    public void setPatru(String patru) {
        this.patru = patru;
    }

    public String getSalu() {
        return salu;
    }

    public void setSalu(String salu) {
        this.salu = salu;
    }
}
