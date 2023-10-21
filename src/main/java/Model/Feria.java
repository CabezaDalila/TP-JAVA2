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
    public void cargarStands() {
	CargaXML cargador = new CargaXML();
	cargador.cargarStandsXML(this);
    }
    
    public List<Stand> getListaStands() {
        return listaStands;
    }

    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    
   
    public void agregaStand(Stand stand){
        listaStands.add(stand);
    }
    
    
    
    public void agregaStandAcliente(){
        ArrayList<Stand> nuevaLista=new ArrayList();
        for(Cliente cliente:listaClientes){
            for(Stand stand:listaStands){
                if(stand.getUnCliente().getIdCliente().equals(cliente.getIdCliente())){
                    nuevaLista.add(stand);
                }
            }
            System.out.println("tamanio de la lista nueva:  "+nuevaLista.size()); 
            cliente.setListaStands(nuevaLista);
        }
    }
    

    
}
