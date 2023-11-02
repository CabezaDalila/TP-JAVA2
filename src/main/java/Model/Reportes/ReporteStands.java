package Model.Reportes;

import Excepciones.ListaVacia;
import Model.Accesorio;
import Model.Feria;
import Model.Stand;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * La clase `ReporteStands` se encarga de generar informes relacionados con los stands en la feria.
 * Estos informes incluyen la lista de stands ordenada por su valor total y el valor promedio de los stands en la feria.
 */
public class ReporteStands {

    private static Feria feria;

    /**
     * Constructor de la clase `ReporteStands`. Inicializa la instancia de la feria.
     */
    public ReporteStands() {
        this.feria = Feria.getInstance();
    }

    /**
     * Ordena la lista de stands en orden descendente según su valor total.
     *
     * @return Una lista de stands ordenada por valor total en orden descendente.
     */
    public List<Stand> ordenaStandDescendentePorValor() {
        List<Stand> listaOrdenada = feria.getListaStands().stream()
                .sorted((stand1, stand2) -> Float.compare(stand2.valorTotalStand(), stand1.valorTotalStand()))
                .toList();
        return listaOrdenada;
    }


    /**
     * Calcula el valor promedio de los stands en la feria.
     *
     * @return El valor promedio de los stands o 0 si no hay stands en la feria.
     */
    public float valorPromedioStands() {
        float suma = 0;
        int cont = 0;
        Iterator<Stand> it = feria.getListaStands().iterator();
        while (it.hasNext()) {
            Stand stand = it.next();
            suma += stand.valorTotalStand();
            cont++;
        }
        return cont > 0 ? suma / cont : 0;
    }

    /**
     * Genera un archivo de texto que contiene un informe de los stands en la feria, incluyendo su valor total, superficie,
     * precio por metro cuadrado y lista de accesorios. Además, se incluye el valor promedio de los stands.
     *
     * @throws IOException  Si ocurre un error de E/S al escribir el archivo.
     * @throws ListaVacia   Si la lista de stands en la feria está vacía.
     */
    public void generaTxtReporteStands() throws IOException, ListaVacia {
        String Archivo = "Reporte de Stands.txt";
        FileWriter fileWriter = new FileWriter(Archivo);
        if (ordenaStandDescendentePorValor().size()!=0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Listado completo de stands ordenados descendentemente por su valor total:\n");
                List<Stand> listaStandsOrdenados = ordenaStandDescendentePorValor();
                for (Stand stand : listaStandsOrdenados) {
                    bufferedWriter.write("Id Stand: " + stand.getIdStand());
                    bufferedWriter.write(" Valor del Stand: " + stand.valorTotalStand());
                    bufferedWriter.write(" Superficie: " + stand.getSuperficie());
                    bufferedWriter.write(" Precio metro2: " + stand.getPrecio() + "\n");
                    bufferedWriter.write("Listado de accesorios:\n");
                    for (Accesorio acc : stand.getListaAccesorios()) {
                        bufferedWriter.write(acc.getIdAccesorio() + "\n");
                    }
                    bufferedWriter.write("\n");
                }
                String valorPromedio = String.valueOf(valorPromedioStands());
                bufferedWriter.write("Valor promedio de los stands: " + valorPromedio + "\n");
            }
        } else {
            throw new ListaVacia("Error: Lista de stands vacía");
        }
    }
}
