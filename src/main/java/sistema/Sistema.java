
package sistema;
import Model.*;
import vista.PantallaPrincipal;
import java.util.*;

public class Sistema {
    

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        
        //feria=Feria.getInstance();
        
        /*feria.cargarStands();
        List<Stand> listaStandsFeria = feria.getListaStands();
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString());
            
        }
        Set<Cliente> listaClientesFeria= feria.getListaClientes();
        for(Cliente cliente : listaClientesFeria){
            System.out.println(cliente.toString());
        }*/
    }
    
}



