
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

        //Cliente cliente=new Cliente();
        feria=Feria.getInstance();
        
        feria.cargarStands();
        
       
        
        
        //prueba para mostrar los stands y clientes por consola
        List<Stand> listaStandsFeria = feria.getListaStands();
        Set<Cliente> listaClientesFeria=feria.getListaClientes();
        
       
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString());
            
        }
        Set<Cliente> listaClientesFeria= feria.getListaClientes();
        for(Cliente cliente : listaClientesFeria){
            System.out.println(cliente.toString());
        }*/

            System.out.println(stand.toString()); 
        }
        
        for (Cliente cliente : listaClientesFeria) {
            System.out.println(cliente.toString()); 
        }
        //fin prueba
        
        
         feria.agregaStandAcliente();
         
    
    }
    
}



