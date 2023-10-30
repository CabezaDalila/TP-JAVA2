
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

        //feria=Feria.getInstance();
        //feria.cargarStands();

        //prueba para mostrar los stands y clientes por consola

  
        feria=Feria.getInstance();

        List<Stand> listaStandsFeria = feria.getListaStands();
        System.out.println("LISTA ORDENADA:");
        for (Stand stand : listaStandsFeria) {
            System.out.println(stand.toString());  
        }
        
        /*Set<Cliente> listaClientesFeria= feria.getListaClientes();
        for(Cliente cliente : listaClientesFeria){
            System.out.println(cliente.toString());
        }*/
        Map<String, Integer> listaAcc = feria.reporteAccesorios();
        for (Map.Entry<String, Integer> entry : listaAcc.entrySet()) {
            String clave = entry.getKey();
            Integer valor = entry.getValue();
            System.out.println("Clave: " + clave + ", Valor: " + valor);
        }
       
        //fin prueba
        
        /*Set<Accesorio> listaAcc1 = feria.getListaAccesorios();
        for(Accesorio accesorio : listaAcc1){
            System.out.println(accesorio.toString());
        }*/
        

    }
    
}



