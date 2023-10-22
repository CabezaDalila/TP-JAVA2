
package sistema;
import Model.*;
import vista.PantallaPrincipal;
import java.util.*;


public class Sistema {

    private static Feria feria;


    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);

        feria=Feria.getInstance();
        //feria.cargarStands();

        //prueba para mostrar los stands y clientes por consola

  
        feria=Feria.getInstance();

        List<Stand> listaStandsFeria = feria.ordenaStandDescendentePorValor();
        System.out.println("LISTA ORDENADA:");
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString());  
        }
        
        /*Set<Cliente> listaClientesFeria= feria.getListaClientes();
        for(Cliente cliente : listaClientesFeria){
            System.out.println(cliente.toString());
        }
        */
       
        //fin prueba
  
    

    }
    
}



