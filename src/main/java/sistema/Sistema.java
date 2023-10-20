
package sistema;
import Model.*;
import vista.PantallaPrincipal;
import java.util.List;

public class Sistema {

    private static Feria feria;
    
    private List<Stand> listaStands;

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        feria=Feria.getInstance();
        
        feria.cargarStands();
        List<Stand> listaStandsFeria = feria.getListaStands();
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString());
            
            
        }
    }
}



