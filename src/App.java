import controlador.ControladorInicial;
import vista.VistaInicial;


public class App {
    public static void main(String[] args) {
        VistaInicial ventana = new VistaInicial();  //se crea la vista principal
        ControladorInicial controladorInicial = new ControladorInicial(ventana); //se crea el controlador principal
        controladorInicial.inicializar(); //se inicializa el controlador principal
    }
}
