package controlador;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import modelo.Capitan;
import modelo.Coronel;
import modelo.Database;
import modelo.SoldadoRaso;
import modelo.Teniente;
import vista.VistaInicial;
import vista.VistaModificar;
import vista.VistaRegistro;

public class ControladorInicial implements ActionListener {
    private VistaInicial vistaInicial;
    private VistaModificar vistaModificar = new VistaModificar(); //se crea la vista modificar
    private VistaRegistro vistaRegistro = new VistaRegistro(); //se crea la vista registro
    private ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro);

    public ControladorInicial(VistaInicial vistaInicial) {
        this.vistaInicial = vistaInicial;
        this.vistaInicial.jButtonRegistro.addActionListener(this);
        this.vistaInicial.jButtonModificar.addActionListener(this);
        this.vistaInicial.jComboBoxRangos.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaInicial.jButtonRegistro) {
            vistaInicial.jPanelContent.removeAll(); 
            vistaInicial.jPanelContent.add(vistaRegistro, BorderLayout.CENTER);
            vistaInicial.jPanelContent.revalidate();
            vistaInicial.jPanelContent.repaint();
            controladorRegistro.Inicializar();

        } else if (e.getSource() == vistaInicial.jButtonModificar) {
            vistaModificar.setSize(406, 268);
            vistaModificar.setLocation(0,0);
            
            vistaInicial.jPanelContent.removeAll();
            vistaInicial.jPanelContent.add(vistaModificar, BorderLayout.CENTER);
            vistaInicial.revalidate();
            vistaInicial.repaint();
        } else if(e.getSource() == vistaInicial.jComboBoxRangos){
            String itemSeleccionado = (String) vistaInicial.jComboBoxRangos.getSelectedItem();
            listarSoldados(itemSeleccionado);
    }
}

    public void listarSoldados(String itemSeleccionado){
        //usa la misma instancia de la base de datos
        Database db = Database.getInstance();
        vistaInicial.jPanelListar.removeAll();
        switch (itemSeleccionado) {
            case "Soldado Raso":
                for (SoldadoRaso soldadoRaso : db.getSoldadosRasos()) {
                    if (soldadoRaso.getMision() == null) {
                        soldadoRaso.asignarMision("Sin misión");
                    }
                    if (soldadoRaso.getEstado() == null) {
                        soldadoRaso.setEstado("Sin estado");
                    }
                    JLabel labelNombre = new JLabel(" Nombre: "+soldadoRaso.getNombre());
                    JLabel labelId = new JLabel(" ID: "+soldadoRaso.getId());
                    JLabel labelMision = new JLabel("Misión: "+soldadoRaso.getMision());
                    JLabel labelEstado = new JLabel("Estado: "+soldadoRaso.getEstado());
                    JLabel labelLinea = new JLabel("___________________________________");
                    //label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    //lab.setAlignmentX(Component.CENTER_ALIGNMENT);
                    //sep.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vistaInicial.jPanelListar.add(labelNombre);
                    vistaInicial.jPanelListar.add(labelId);
                    vistaInicial.jPanelListar.add(labelMision);
                    vistaInicial.jPanelListar.add(labelEstado);
                    vistaInicial.jPanelListar.add(labelLinea);
                }
                break;
            case "Teniente":
                System.out.println("Teniente");
                break;
            case "Capitan":
                System.out.println("Capitan");
                break;
            case "Coronel":
                System.out.println("Coronel");
                break;
            default:
                System.out.println("nada");
                break;
            
        }
    // Actualiza el panel para que los nuevos componentes se muestren
    vistaInicial.jPanelListar.revalidate();
    vistaInicial.jPanelListar.repaint();
    }

    public void Inicializar() {
        vistaInicial.setResizable(false);
        vistaInicial.setVisible(true);
        vistaInicial.setLocationRelativeTo(null);
    }

}
