/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import Excepciones.ClienteNoEncontrado;
import xml.*;
/**
 *
 * @author dalilacabeza
 */
public class Feria {
    private static Feria feria;
    private Set<Cliente> listaClientes;
    private List<Stand> listaStands;

    public Feria(Set<Cliente> listaClientes, Set<Stand> listaStands) {
        this.listaClientes = new TreeSet<>(listaClientes);
        this.listaStands = new ArrayList<>();
    }

   //Singleton
   public static Feria getInstance(){
       if(feria==null){
            feria = new Feria(new HashSet<>(), new HashSet<>());
       }
       return feria;
   }
    public Cliente buscaClientePorId(String idCliente) throws ClienteNoEncontrado{
         for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente; 
            }
        }
        throw new ClienteNoEncontrado("Error: ID no encontrado");
    }
    public void agregaCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public List<Stand> getListaStands() {
        return listaStands;
    }
    public Set<Cliente> getListaClientes(){
        return listaClientes;
    }
   
    public void agregaStand(Stand stand){
        listaStands.add(stand);
    }
   
    public void agregaStandAcliente(){
        ArrayList<Stand> nuevaLista=new ArrayList();
        for(Cliente cliente:listaClientes){
            for(Stand stand:listaStands){
                if(stand.getUnCliente().getIdCliente().compareTo(cliente.getIdCliente())==0){
                    nuevaLista.add(stand);
                }
            }
            System.out.println("tamanio de la lista nueva:  "+nuevaLista.size()); 
            cliente.agregaStand(nuevaLista);
            nuevaLista.clear();
        }
        
        
        System.out.println("Termino la funcion agregaStand a cliente"); 
        System.out.println("Cant stands en cte:"); 
        /*for(Cliente cliente:listaClientes){
            System.out.println("DATOS "+cliente.toString()); 
        }*/
    }
    
    public List<Stand> ordenaStandDescendentePorValor() {
        List<Stand> listaOrdenada = listaStands.stream()
                                               .sorted((stand1, stand2) -> Float.compare(stand2.valorTotalStand(), stand1.valorTotalStand()))
                                               .toList();
        return listaOrdenada;
    }
    public float valorPromedioStands(){
        float suma=0;
        int cont=0;
        for(Stand stand : listaStands){
            suma+=stand.valorTotalStand();
            cont++;
        }
        return cont>0? suma/cont :0;
    }
    // SOLO PARA PROBAR
       public void cargarStands() {	
        CargaXML cargador = new CargaXML();	
        cargador.cargarStandsXML(this);	

    }
}
