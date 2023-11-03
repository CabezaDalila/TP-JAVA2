package sistema;

import Modelo.*;
import vista.PantallaPrincipal;

/**
 * La clase `Sistema` representa el punto de entrada de la aplicación. Esta clase
 * se encarga de iniciar la interfaz de usuario principal de la feria.
 */
public class Sistema {

    private static Feria feria;

    /**
     * Método principal de la aplicación. Crea una instancia de la interfaz de usuario
     * principal (`PantallaPrincipal`), la hace visible y la coloca en el centro de la pantalla.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }

}
