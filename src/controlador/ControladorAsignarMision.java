package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Capitan;
import modelo.Coronel;
import modelo.Database;
import modelo.SoldadoRaso;
import modelo.Teniente;
import vista.VistaAsignarMision;

public class ControladorAsignarMision implements ActionListener {
    private VistaAsignarMision vistaAsignarMision;
    private Database database;

    public ControladorAsignarMision(VistaAsignarMision vistaAsignarMision) {
        this.vistaAsignarMision = vistaAsignarMision;
        this.vistaAsignarMision.jButtonAsignar.addActionListener(this);
        this.database = Database.getInstance();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAsignarMision.jButtonAsignar) {
            String rango = vistaAsignarMision.jComboBoxRango.getSelectedItem().toString();
            String id = vistaAsignarMision.jTextFieldId.getText();
            String mision = vistaAsignarMision.jTextAreaMision.getText();
            asignarMision(id,mision,rango);
        }
    }

    public void asignarMision(String id, String mision, String rango) {
        if(rango.equals("Soldado Raso")){
            for (SoldadoRaso soldadoRaso : database.getSoldadosRasos()) {
                if(soldadoRaso.getId().equals(id)){
                    soldadoRaso.asignarMision(mision);
                }
            }
        }else if(rango.equals("Teniente")){
            for (Teniente teniente : database.getTenientes()) {
                if(teniente.getId().equals(id)){
                    teniente.asignarMision(mision);
                }
            }
        }else if(rango.equals("Capitan")){
            for (Capitan capitan : database.getCapitanes()) {
                if(capitan.getId().equals(id)){
                    capitan.asignarMision(mision);
                }
            }
        }else if(rango.equals("Coronel")){
            for (Coronel coronel : database.getCoroneles()) {
                if(coronel.getId().equals(id)){
                    coronel.asignarMision(mision);
                }
            }
        }
    }
    public void inicializar(){
        vistaAsignarMision.setSize(406, 300);
        vistaAsignarMision.setLocation(0,0);
    }
}