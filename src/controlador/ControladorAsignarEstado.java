package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Capitan;
import modelo.Coronel;
import modelo.Database;
import modelo.SoldadoRaso;
import modelo.Teniente;
import vista.VistaAsignarEstado;

public class ControladorAsignarEstado implements ActionListener {
    private VistaAsignarEstado vistaAsignarEstado;
    private Database database;

    public ControladorAsignarEstado(VistaAsignarEstado vistaAsignarEstado) {
        this.vistaAsignarEstado = vistaAsignarEstado;
        this.vistaAsignarEstado.jButtonAsignar.addActionListener(this);
        this.database = Database.getInstance();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaAsignarEstado.jButtonAsignar){
            String rango = vistaAsignarEstado.jComboBoxRango.getSelectedItem().toString();
            String id = vistaAsignarEstado.jTextFieldId.getText();
            String estado = vistaAsignarEstado.jTextFieldEstado.getText();
            asignarEstado(id,estado,rango);
        }
    }

    public void asignarEstado(String id, String estado, String rango) {
        switch (rango) {
            case "Soldado Raso":
                for (SoldadoRaso soldadoRaso : database.getSoldadosRasos()) {
                    if(soldadoRaso.getId().equals(id)){
                        soldadoRaso.reportarEstado(estado);
                    }
                }
                break;
            case "Teniente":
                for (Teniente teniente : database.getTenientes()) {
                    if(teniente.getId().equals(id)){
                        teniente.reportarEstado(estado);
                    }
                }
                break;
            case "Capitan":
                for (Capitan capitan : database.getCapitanes()) {
                    if(capitan.getId().equals(id)){
                        capitan.reportarEstado(estado);
                    }
                }
            case "Coronel":
                for (Coronel coronel : database.getCoroneles()) {
                    if(coronel.getId().equals(id)){
                        coronel.reportarEstado(estado);
                    }
                }
            default:
                break;
        }
    }

    public void inicializar(){
        vistaAsignarEstado.setSize(406, 300);
        vistaAsignarEstado.setLocation(0,0);
    }
}
