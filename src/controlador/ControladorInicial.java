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
import vista.VistaAsignarEstado;
import vista.VistaAsignarMision;

public class ControladorInicial implements ActionListener {
    private VistaInicial vistaInicial;
    private VistaModificar vistaModificar = new VistaModificar(); //se crea la vista modificar
    private VistaRegistro vistaRegistro = new VistaRegistro(); //se crea la vista registro
    private VistaAsignarMision VistaAsignarMision = new VistaAsignarMision(); //se crea la vista asignar mision
    private VistaAsignarEstado VistaAsignarEstado = new VistaAsignarEstado(); //se crea la vista asignar estado
    private ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro);
    private ControladorModificar controladorModificar = new ControladorModificar(vistaModificar);
    private ControladorAsignarMision controladorAsignarMision = new ControladorAsignarMision(VistaAsignarMision);
    private ControladorAsignarEstado controladorAsignarEstado = new ControladorAsignarEstado(VistaAsignarEstado);

    public ControladorInicial(VistaInicial vistaInicial) {
        this.vistaInicial = vistaInicial;
        this.vistaInicial.jButtonRegistro.addActionListener(this);
        this.vistaInicial.jButtonModificar.addActionListener(this);
        this.vistaInicial.jComboBoxRangos.addActionListener(this);
        this.vistaInicial.jComboBoxMas.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaInicial.jButtonRegistro) {
            vistaInicial.jPanelContent.removeAll(); 
            vistaInicial.jPanelContent.add(vistaRegistro, BorderLayout.CENTER);
            vistaInicial.jPanelContent.revalidate();
            vistaInicial.jPanelContent.repaint();
            controladorRegistro.inicializar();

        } else if (e.getSource() == vistaInicial.jButtonModificar) {
            vistaInicial.jPanelContent.removeAll();
            vistaInicial.jPanelContent.add(vistaModificar, BorderLayout.CENTER);
            vistaInicial.revalidate();
            vistaInicial.repaint();
            controladorModificar.inicializar();

        }else if(e.getSource() == vistaInicial.jComboBoxMas){
            String itemSeleccionado = (String) vistaInicial.jComboBoxMas.getSelectedItem();
            vistaMasFuncionalidades(itemSeleccionado);

        } else if(e.getSource() == vistaInicial.jComboBoxRangos){
            String itemSeleccionado = (String) vistaInicial.jComboBoxRangos.getSelectedItem();
            listarSoldados(itemSeleccionado);
    }
}

    public void listarSoldados(String itemSeleccionado){
        //usa la misma instancia de la base de datos, en este metodo debido a que solo se necesita aquí por ahora
        Database db = Database.getInstance();
        vistaInicial.jPanelListar.removeAll();
        switch (itemSeleccionado) {
            case "Soldado Raso":
                for (SoldadoRaso soldadoRaso : db.getSoldadosRasos()) {
                    JLabel labelNombre = new JLabel("  Nombre: "+soldadoRaso.getNombre());
                    JLabel labelId = new JLabel("  ID: "+soldadoRaso.getId());
                    JLabel labelMision = new JLabel("  Misión: "+soldadoRaso.getMision());
                    JLabel labelEstado = new JLabel("  Estado: "+soldadoRaso.getEstado());
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
                for (Teniente tieniente : db.getTenientes()) {
                    JLabel labelNombre = new JLabel("  Nombre: "+tieniente.getNombre());
                    JLabel labelId = new JLabel("  ID: "+tieniente.getId());
                    JLabel labelMision = new JLabel("  Misión: "+tieniente.getMision());
                    JLabel labelEstado = new JLabel("  Estado: "+tieniente.getEstado());
                    JLabel labelUnidad = new JLabel("  Unidad: "+tieniente.getUnidad());
                    JLabel labelLinea = new JLabel("___________________________________");
                    vistaInicial.jPanelListar.add(labelNombre);
                    vistaInicial.jPanelListar.add(labelId);
                    vistaInicial.jPanelListar.add(labelMision);
                    vistaInicial.jPanelListar.add(labelEstado);
                    vistaInicial.jPanelListar.add(labelUnidad);
                    vistaInicial.jPanelListar.add(labelLinea);
                }
                break;
            case "Capitan":
                for (Capitan capitan : db.getCapitanes()){
                    JLabel labelNombre = new JLabel("  Nombre: "+capitan.getNombre());
                    JLabel labelId = new JLabel("  ID: "+capitan.getId());
                    JLabel labelMision = new JLabel("  Misión: "+capitan.getMision());
                    JLabel labelEstado = new JLabel("  Estado: "+capitan.getEstado());
                    JLabel labelSoldadosBajoMando = new JLabel("  Soldados bajo mando: "+capitan.getCantidadSoldadosBajoSuMando());
                    JLabel labelLinea = new JLabel("___________________________________");
                    vistaInicial.jPanelListar.add(labelNombre);
                    vistaInicial.jPanelListar.add(labelId);
                    vistaInicial.jPanelListar.add(labelMision);
                    vistaInicial.jPanelListar.add(labelEstado);
                    vistaInicial.jPanelListar.add(labelSoldadosBajoMando);
                    vistaInicial.jPanelListar.add(labelLinea);
                }
                break;
            case "Coronel":
                for (Coronel coronel : db.getCoroneles()){
                    JLabel labelNombre = new JLabel("  Nombre: "+coronel.getNombre());
                    JLabel labelId = new JLabel("  ID: "+coronel.getId());
                    JLabel labelMision = new JLabel("  Misión: "+coronel.getMision());
                    JLabel labelEstado = new JLabel("  Estado: "+coronel.getEstado());
                    JLabel labelEstrategia = new JLabel("  Estrategia: "+coronel.getEstrategia());
                    JLabel labelLinea = new JLabel("___________________________________");
                    vistaInicial.jPanelListar.add(labelNombre);
                    vistaInicial.jPanelListar.add(labelId);
                    vistaInicial.jPanelListar.add(labelMision);
                    vistaInicial.jPanelListar.add(labelEstado);
                    vistaInicial.jPanelListar.add(labelEstrategia);
                    vistaInicial.jPanelListar.add(labelLinea);
                }
                break;
            default:
                System.out.println("nada");
                break;
            
        }
    // Actualiza el panel para que los nuevos componentes se muestren
    vistaInicial.jPanelListar.revalidate();
    vistaInicial.jPanelListar.repaint();
    }

    public void vistaMasFuncionalidades(String itemSeleccionado){
        switch (itemSeleccionado) {
            case "Asignar Mision":
            vistaInicial.jPanelContent.removeAll(); 
            vistaInicial.jPanelContent.add(VistaAsignarMision, BorderLayout.CENTER);
            vistaInicial.jPanelContent.revalidate();
            vistaInicial.jPanelContent.repaint();
            controladorAsignarMision.inicializar();
                break; 
            case "Asignar Estado":
                vistaInicial.jPanelContent.removeAll(); 
                vistaInicial.jPanelContent.add(VistaAsignarEstado, BorderLayout.CENTER);
                vistaInicial.jPanelContent.revalidate();
                vistaInicial.jPanelContent.repaint();
                controladorAsignarEstado.inicializar();
                System.out.println("Asignar Mision");
                break;/* 

                funcionalidad futuras
            case "Acciones":
                JLabel labelIdPatrullar = new JLabel("ID:");
                vistaInicial.jPanelMas.add(labelIdPatrullar);
                vistaInicial.jPanelMas.add(vistaInicial.jTextFieldIdPatrullar);
                vistaInicial.jPanelMas.add(vistaInicial.jButtonPatrullar);
                break;
                */
            default:
                System.out.println("nada");
                break;
        }
    }

    public void inicializar() {
        vistaInicial.setResizable(false);
        vistaInicial.setVisible(true);
        vistaInicial.setLocationRelativeTo(null);
    }

}
