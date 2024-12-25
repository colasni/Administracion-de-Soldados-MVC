package modelo;
import java.util.ArrayList;

public class Database {
    private static Database instance = null;
    private ArrayList<SoldadoRaso> soldadosRasos;
    private ArrayList<Capitan> capitan;
    private ArrayList<Coronel> coronel;
    private ArrayList<Teniente> teniente;

    private Database() {
        soldadosRasos = new ArrayList<>();
        capitan = new ArrayList<>();
        coronel = new ArrayList<>();
        teniente = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static void setInstance(Database instance) {
        Database.instance = instance;
    }
    
    public ArrayList<SoldadoRaso> getSoldadosRasos() {
        return soldadosRasos;
    }

    public void setSoldadosRasos(ArrayList<SoldadoRaso> soldadosRasos) {
        this.soldadosRasos = soldadosRasos;
    }

    public void addSoldadoRaso(SoldadoRaso soldadoRaso) {
        this.soldadosRasos.add(soldadoRaso); 
    }

    public ArrayList<Capitan> getCapitan() {
        return capitan;
    }

    public void setCapitan(ArrayList<Capitan> capitan) {
        this.capitan = capitan;
    }

    public ArrayList<Coronel> getCoronel() {
        return coronel;
    }

    public void setCoronel(ArrayList<Coronel> coronel) {
        this.coronel = coronel;
    }

    public ArrayList<Teniente> getTeniente() {
        return teniente;
    }

    public void setTeniente(ArrayList<Teniente> teniente) {
        this.teniente = teniente;
    }

}
