
package sistema;
import Model.*;
import vista.PantallaPrincipal;
import java.util.List;
import java.util.Set;

public class Sistema {

    private static Feria feria;
    
    private List<Stand> listaStands;

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        //Cliente cliente=new Cliente();
        feria=Feria.getInstance();
        
        feria.cargarStands();
        
       
        
        
        //prueba para mostrar los stands y clientes por consola
        List<Stand> listaStandsFeria = feria.getListaStands();
        Set<Cliente> listaClientesFeria=feria.getListaClientes();
        
       
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString()); 
        }
        
        for (Cliente cliente : listaClientesFeria) {
            System.out.println(cliente.toString()); 
        }
        //fin prueba
        
        
         feria.agregaStandAcliente();
         
    
    }
}



