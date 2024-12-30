package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Capitan;
import modelo.Coronel;
import modelo.Database;
import modelo.SoldadoRaso;
import modelo.Teniente;
import vista.VistaRegistro;

public class ControladorRegistro implements ActionListener{
    private VistaRegistro vistaRegistro;
    private Database database;
    
    public ControladorRegistro(VistaRegistro vistaRegistro){
        this.vistaRegistro = vistaRegistro;
        this.vistaRegistro.jButtonRegistrar.addActionListener(this);
        this.vistaRegistro.jComboBoxRango.addActionListener(this);
        this.database = Database.getInstance();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaRegistro.jButtonRegistrar) {
            registrarSoldado();
        }
        if (e.getSource() == vistaRegistro.jComboBoxRango) {
            actualizarCampos();
        }
    }


    //esta fución se encarga de que actualizar los campos de las otras funciones de soldados como unidad
    //o soldados bajo sumando lo que hace es no dejar escribir en alguno de los campos dependiendo el 
    //rango seleccionado
    public void actualizarCampos(){
    if (vistaRegistro.jComboBoxRango.getSelectedItem().toString().equals("Soldado Raso")) {
        vistaRegistro.jTextFieldEstrategia.setEnabled(false);
        vistaRegistro.jTextFieldUnidad.setEnabled(false);
        vistaRegistro.jTextFieldSoldadosBajoMando.setEnabled(false);
    } else if (vistaRegistro.jComboBoxRango.getSelectedItem().toString().equals("Teniente")) {
        vistaRegistro.jTextFieldEstrategia.setEnabled(false);
        vistaRegistro.jTextFieldUnidad.setEnabled(true);
        vistaRegistro.jTextFieldSoldadosBajoMando.setEnabled(false);
    } else if (vistaRegistro.jComboBoxRango.getSelectedItem().toString().equals("Capitan")) {
        vistaRegistro.jTextFieldEstrategia.setEnabled(false);
        vistaRegistro.jTextFieldUnidad.setEnabled(false);
        vistaRegistro.jTextFieldSoldadosBajoMando.setEnabled(true);
    } else if (vistaRegistro.jComboBoxRango.getSelectedItem().toString().equals("Coronel")) {
        vistaRegistro.jTextFieldEstrategia.setEnabled(true);
        vistaRegistro.jTextFieldUnidad.setEnabled(false);
        vistaRegistro.jTextFieldSoldadosBajoMando.setEnabled(false);
    }
}

    public void registrarSoldado(){
        String nombre = vistaRegistro.jTextFieldNombre.getText();
        String estrategia = vistaRegistro.jTextFieldEstrategia.getText();
        String rango = vistaRegistro.jComboBoxRango.getSelectedItem().toString();
        String id = vistaRegistro.jTextFieldId.getText();
        String unidad = vistaRegistro.jTextFieldUnidad.getText();
        String bajoMando = vistaRegistro.jTextFieldSoldadosBajoMando.getText();

        if (rango.equals("Soldado Raso")){

            for(SoldadoRaso soldadoRasos : database.getSoldadosRasos()){
                if(soldadoRasos.getId().equals(id)){
                    javax.swing.JOptionPane.showMessageDialog(null, "El ID del soldado ya existe");
                    return;
                }
            }
            SoldadoRaso soldadoRaso = new SoldadoRaso(nombre, id, "Soldado raso", 1);
            database.addSoldadoRaso(soldadoRaso);
        }
        else if (rango.equals("Teniente")){
            for(Teniente teniente : database.getTenientes()){
                if(teniente.getId().equals(id)){
                    javax.swing.JOptionPane.showMessageDialog(null, "El ID del soldado ya existe");
                    return;
                }
            }
            Teniente teniente = new Teniente(nombre, id, "Teniente", 2,unidad);
            database.addTeniente(teniente);
        }
        else if (rango.equals("Capitan")){
            Capitan capitan = new Capitan(nombre, id, "Capitan", 3, bajoMando);
            database.addCapitan(capitan);
            System.err.println(database.getCapitanes());
        }
        else if (rango.equals("Coronel")){
            Coronel coronel = new Coronel(nombre, id, "Coronel", 4, estrategia);
            database.addCoronel(coronel);
            System.err.println(database.getCoroneles());
        }
        
    }

    public void inicializar() {
        vistaRegistro.setSize(406, 268);
        vistaRegistro.setLocation(0,0);
    }

}
