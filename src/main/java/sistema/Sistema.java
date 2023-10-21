
package sistema;
import Model.*;
import vista.PantallaPrincipal;
import java.util.*;


public class Sistema {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    private static Feria feria;
=======
    public static Feria feria;
>>>>>>> Stashed changes
=======
    public static Feria feria;
>>>>>>> Stashed changes

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);

        feria=Feria.getInstance();
        
<<<<<<< Updated upstream
        
<<<<<<< Updated upstream
        
        /*feria.cargarStands();

        //Cliente cliente=new Cliente();
        feria=Feria.getInstance();
        
        feria.cargarStands();
        
       
        
        
        //prueba para mostrar los stands y clientes por consola
=======
        feria=Feria.getInstance();
        
        feria.cargarStands();
>>>>>>> Stashed changes
=======
        feria=Feria.getInstance();
        
        feria.cargarStands();
>>>>>>> Stashed changes
        List<Stand> listaStandsFeria = feria.getListaStands();
        Set<Cliente> listaClientesFeria=feria.getListaClientes();
        
       
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString());
            
        }
        Set<Cliente> listaClientesFeria= feria.getListaClientes();
        for(Cliente cliente : listaClientesFeria){
            System.out.println(cliente.toString());
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        }*/

        
       /* for (Cliente cliente : listaClientesFeria) {
            System.out.println(cliente.toString()); 
        }
        //fin prueba
        
         */
    
=======
        }
>>>>>>> Stashed changes
=======
        }
>>>>>>> Stashed changes
    }
    
}



