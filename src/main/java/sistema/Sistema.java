package sistema;

import Model.*;
import vista.PantallaPrincipal;

public class Sistema {

    private static Feria feria;

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }

}
