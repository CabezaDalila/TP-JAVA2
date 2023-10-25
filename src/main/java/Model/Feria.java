/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import Excepciones.ClienteNoEncontrado;
import xml.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author dalilacabeza
 */
public class Feria {
    private static Feria feria;
    private Set<Cliente> listaClientes;
    private static List<Stand> listaStands;
    // crear un listado donde esten todos los acc, apartte para poder generar el reporte, fijarme para q no se carguen repetidos
    private Set<Accesorio> listaAccesorios;

    public Feria(Set<Cliente> listaClientes, Set<Stand> listaStands,Set<Accesorio> listaAccesorios) {
        this.listaClientes = new TreeSet<>(listaClientes);
        this.listaStands = new ArrayList<>();
        this.listaAccesorios = new TreeSet<>(listaAccesorios); 
    }

   //Singleton
   public static Feria getInstance(){
       if(feria==null){
            feria = new Feria(new HashSet<>(), new HashSet<>(), new TreeSet<>());
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
    public void agregarAccesorio(Accesorio accesorio){
        listaAccesorios.add(accesorio);
    }
    public Set<Accesorio> getListaAccesorios() {
        return listaAccesorios;
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
            //System.out.println("tamanio de la lista nueva:  "+nuevaLista.size()); 
            cliente.agregaStands(nuevaLista);
            nuevaLista.clear();
        }
        
        // 
        //System.out.println("Termino la funcion agregaStand a cliente"); 
        //System.out.println("Cant stands en cte:"); 
        /*for(Cliente cliente:listaClientes){
            System.out.println("DATOS "+cliente.toString()); 
        }*/
    }
    
    public static List<Stand> ordenaStandDescendentePorValor() {
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
    
   public void generaTxtReporteStands() throws IOException {
        String nombreArchivo = "Reporte de Stands.txt";
        FileWriter fileWriter = new FileWriter(nombreArchivo);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Listado completo de stands ordenados descendentemente por su valor total:\n");
        List<Stand> listaStandsOrdenados = ordenaStandDescendentePorValor();

        for (Stand stand : listaStandsOrdenados) {
            bufferedWriter.write("Id Stand: "+stand.getIdStand());
            float valor = stand.valorTotalStand();
            bufferedWriter.write(" Valor del Stand: "+ valor );
            bufferedWriter.write(" Superficie: "+stand.getSuperficie());
            bufferedWriter.write(" Precio metro2: "+stand.getPrecio()+ "\n");
            bufferedWriter.write("Listado de acceosrios:\n");
            for(Accesorio acc : stand.getListaAccesorios())
                bufferedWriter.write(acc.getIdAccesorio()+ "\n");
        }

        String valorPromedio = String.valueOf(valorPromedioStands());
        bufferedWriter.write("Valor promedio de los stands: " + valorPromedio + "\n");

        bufferedWriter.close();
        System.out.println("Reporte generado correctamente.");
    }
}
