package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Capitan;
import modelo.Coronel;
import modelo.Database;
import modelo.SoldadoRaso;
import modelo.Teniente;
import vista.VistaModificar;

public class ControladorModificar implements ActionListener {
    private VistaModificar vistaModificar;
    private Database database;

    public ControladorModificar(VistaModificar vistaModificar) {
        this.vistaModificar = vistaModificar;
        this.vistaModificar.jButtonModificar.addActionListener(this);
        this.vistaModificar.jComboBoxRango.addActionListener(this);
        this.database = Database.getInstance();
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == vistaModificar.jButtonModificar) {
            ModificarSoldado();
        }
        else if (e.getSource() == vistaModificar.jComboBoxRango){
            actualizarCampos();
        }
    }

    //esta fución se encarga de que actualizar los campos de las otras funciones de soldados como unidad
    //o soldados bajo sumando lo que hace es no dejar escribir en alguno de los campos dependiendo el 
    //rango seleccionado
    public void actualizarCampos(){
        if (vistaModificar.jComboBoxRango.getSelectedItem().toString().equals("Soldado Raso")) {
            vistaModificar.jTextFieldEstrategia.setEnabled(false);
            vistaModificar.jTextFieldUnidad.setEnabled(false);
            vistaModificar.jTextFieldSoldadosBajoMando.setEnabled(false);
        } else if (vistaModificar.jComboBoxRango.getSelectedItem().toString().equals("Teniente")) {
            vistaModificar.jTextFieldEstrategia.setEnabled(false);
            vistaModificar.jTextFieldUnidad.setEnabled(true);
            vistaModificar.jTextFieldSoldadosBajoMando.setEnabled(false);
        } else if (vistaModificar.jComboBoxRango.getSelectedItem().toString().equals("Capitan")) {
            vistaModificar.jTextFieldEstrategia.setEnabled(false);
            vistaModificar.jTextFieldUnidad.setEnabled(false);
            vistaModificar.jTextFieldSoldadosBajoMando.setEnabled(true);
        } else if (vistaModificar.jComboBoxRango.getSelectedItem().toString().equals("Coronel")) {
            vistaModificar.jTextFieldEstrategia.setEnabled(true);
            vistaModificar.jTextFieldUnidad.setEnabled(false);
            vistaModificar.jTextFieldSoldadosBajoMando.setEnabled(false);
        }
    }

    public void ModificarSoldado(){
        String nombre = vistaModificar.jTextFieldNombre.getText();
        String estrategia = vistaModificar.jTextFieldEstrategia.getText();
        String rango = vistaModificar.jComboBoxRango.getSelectedItem().toString();
        String id = vistaModificar.jTextFieldId.getText();
        String unidad = vistaModificar.jTextFieldUnidad.getText();
        String bajoMando = vistaModificar.jTextFieldSoldadosBajoMando.getText();
        switch (rango) {
            case "Soldado Raso":
                    for(SoldadoRaso soldadoRaso : database.getSoldadosRasos()){
                        if(soldadoRaso.getId().equals(id)){
                            soldadoRaso.setNombre(nombre);
                        }
                    }
                break;
            case "Teniente":
                    for(Teniente teniente : database.getTenientes()){
                        if(teniente.getId().equals(id)){
                            teniente.setNombre(nombre);
                            teniente.setUnidad(unidad);
                        }
                    }
                break;
            case "Capitan":
                    for(Capitan capitan : database.getCapitanes()){
                        if(capitan.getId().equals(id)){
                            capitan.setNombre(nombre);
                            capitan.setCantidadSoldadosBajoSuMando(bajoMando);
                        }
                    }
                break;
            case "Coronel":
                    for(Coronel coronel : database.getCoroneles()){
                        if(coronel.getId().equals(id)){
                            coronel.setNombre(nombre);
                            coronel.setEstrategia(estrategia);
                        }
                    }
        
            default:
                break;
        }
    }

    public void inicializar() {
        vistaModificar.setSize(406, 268);
        vistaModificar.setLocation(0,0);
    }
}