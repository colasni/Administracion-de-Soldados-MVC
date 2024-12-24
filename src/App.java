import vista.VistaInicial;

public class App {
    public static void main(String[] args) {
        VistaInicial ventana = new VistaInicial();
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}
