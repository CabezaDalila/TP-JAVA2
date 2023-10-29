
package Model;
import java.util.*;
import Excepciones.ClienteNoEncontrado;
import xml.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Feria {
    private static Feria feria;
    private Set<Cliente> listaClientes;
    private static List<Stand> listaStands;
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
        if (!listaStands.contains(stand)) {
            listaStands.add(stand);
        }
    }

    public void ordenadListaStands(){
        Collections.sort(listaStands);
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
    //Recorrido con stream
    public static List<Stand> ordenaStandDescendentePorValor() {
        List<Stand> listaOrdenada = listaStands.stream()
                                               .sorted((stand1, stand2) -> Float.compare(stand2.valorTotalStand(), stand1.valorTotalStand()))
                                               .toList();
        return listaOrdenada;
    }
    
    //Recorrido con iterator
    public float valorPromedioStands(){
        float suma=0;
        int cont=0;
        Iterator<Stand> it = listaStands.iterator();
        while(it.hasNext()){
            Stand stand= it.next();
            suma=+stand.valorTotalStand();
            cont++;
        }
        return cont>0? suma/cont :0;
    }
    // SOLO PARA PROBAR
       public void cargarStands() {	
        CargaXML cargador = new CargaXML();	
        cargador.cargarStandsXML(this);	

    }
    
    //Recorrido con for each
    //Se podria haber usado NIO.2 que es mas nuevo, y mejora el uso
    public void generaTxtReporteStands() throws IOException {
        String nombreArchivo = "Reporte de Stands.txt";
        FileWriter fileWriter = new FileWriter(nombreArchivo);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("Listado completo de stands ordenados descendentemente por su valor total:\n");
            List<Stand> listaStandsOrdenados = ordenaStandDescendentePorValor();
            for (Stand stand : listaStandsOrdenados) {
                bufferedWriter.write("Id Stand: "+stand.getIdStand());
                bufferedWriter.write(" Valor del Stand: "+ stand.valorTotalStand());
                bufferedWriter.write(" Superficie: "+stand.getSuperficie());
                bufferedWriter.write(" Precio metro2: "+stand.getPrecio()+ "\n");
                bufferedWriter.write("Listado de acceosrios:\n");
                for(Accesorio acc : stand.getListaAccesorios())
                    bufferedWriter.write(acc.getIdAccesorio()+ "\n");
            }   String valorPromedio = String.valueOf(valorPromedioStands());
            bufferedWriter.write("Valor promedio de los stands: " + valorPromedio + "\n");
        }
    }
   
    public Map<String, Integer> reporteAccesorios() {
        Map<String, Integer> AccOrdenada = new TreeMap<>();
        for (Stand stand : listaStands) {
            ArrayList<Accesorio> listaAccStand = stand.getListaAccesorios();
            for(Accesorio acc : listaAccStand){
                String descAccesorio = acc.getDescAccesorio().toUpperCase();
                AccOrdenada.putIfAbsent(descAccesorio, 0); 
                int valorActual = AccOrdenada.get(descAccesorio);
                valorActual++;
                AccOrdenada.put(descAccesorio, valorActual); 
            }
             
        }
        return AccOrdenada;
    }
    public Accesorio buscarAccesorioPorDescripcion(String descripcion) {
        for (Accesorio acc : listaAccesorios) {
            if (acc.getDescAccesorio().equalsIgnoreCase(descripcion)) {
                return acc;
            }
        }
        return null; 
    }
}
