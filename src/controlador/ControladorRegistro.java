package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Database;
import modelo.SoldadoRaso;
import vista.VistaRegistro;

public class ControladorRegistro implements ActionListener{
    private VistaRegistro vistaRegistro;
    private Database database;
    
    public ControladorRegistro(VistaRegistro vistaRegistro){
        this.vistaRegistro = vistaRegistro;
        this.vistaRegistro.jButtonRegistrar.addActionListener(this);
        this.database = Database.getInstance();
    }

    public void actionPerformed(ActionEvent e) {
        String nombre = vistaRegistro.jTextFieldNombre.getText();
        String estrategia = vistaRegistro.jTextFieldEstrategia.getText();
        String rango = vistaRegistro.jComboBoxRango.getSelectedItem().toString();
        String id = vistaRegistro.jTextFieldId.getText();
        String unidad = vistaRegistro.jTextFieldUnidad.getText();
        String bajoMando = vistaRegistro.jTextFieldSoldadosBajoMando.getText();

        SoldadoRaso soldadoRaso = new SoldadoRaso(nombre, id, "Soldado raso", 1);
        database.addSoldadoRaso(soldadoRaso);
        System.err.println(database.getSoldadosRasos());
        System.out.println("hola desde controlador");
    }

    public void Inicializar() {
        vistaRegistro.setSize(406, 268);
        vistaRegistro.setLocation(0,0);
    }

}
