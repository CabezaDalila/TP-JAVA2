package xml;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Modelo.*;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 * La clase `CargaXML` se encarga de cargar datos desde un archivo XML y utilizarlos para construir objetos relacionados con la Feria. En particular, carga información sobre stands, clientes, y accesorios, y construye objetos correspondientes en la instancia de la Feria.
 */
public class CargaXML {
    
    /**
     * Carga información sobre stands desde un archivo XML y la utiliza para crear objetos Stand, Cliente y Accesorio en la instancia de la Feria proporcionada.
     * @param feria La instancia de la Feria en la que se crearán los objetos.
     * @return `true` si la carga se realiza con éxito, `false` si hay errores.
     */
    public boolean cargarStandsXML(Feria feria) {
        try {
            File archivoXML = new File("src/main/java/xml/Stands.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            doc.getDocumentElement().normalize();

            NodeList listaStands = doc.getElementsByTagName("stand");

            for (int i = 0; i < listaStands.getLength(); i++) {
                Node nodoStand = listaStands.item(i);

                if (nodoStand.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoStand = (Element) nodoStand;
                    Element elementoStandInterior = (Element) elementoStand.getElementsByTagName("StandInterior").item(0);
                    String idStand = elementoStand.getElementsByTagName("idStand").item(0).getTextContent();
                    int superficie = Integer.parseInt(elementoStand.getElementsByTagName("superficie").item(0).getTextContent());
                    float precioM2 = Float.parseFloat(elementoStand.getElementsByTagName("precioM2").item(0).getTextContent());
                    String idClienteStand = elementoStand.getElementsByTagName("idCliente").item(0).getTextContent();
                    String descCliente = elementoStand.getElementsByTagName("descCliente").item(0).getTextContent();

                    ArrayList<Accesorio> listaAccesorios = new ArrayList<>();
                    NodeList listaAccesoriosXML = elementoStand.getElementsByTagName("accesorio");
                    for (int j = 0; j < listaAccesoriosXML.getLength(); j++) {
                        Node nodoAccesorio = listaAccesoriosXML.item(j);

                        if (nodoAccesorio.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoAccesorio = (Element) nodoAccesorio;
                            String idAccesorio = elementoAccesorio.getElementsByTagName("idAccesorio").item(0).getTextContent();
                            String descAccesorio = elementoAccesorio.getElementsByTagName("descAccesorio").item(0).getTextContent();
                            double precioAlquiler = Double.parseDouble(elementoAccesorio.getElementsByTagName("precioAlquiler").item(0).getTextContent());

                            Accesorio accesorio = new Accesorio(idAccesorio, descAccesorio, precioAlquiler);
                            listaAccesorios.add(accesorio);
                            feria.agregarAccesorio(accesorio);
                        }
                    }
                    Cliente cliente = new Cliente(idClienteStand, descCliente);
                    feria.agregaCliente(cliente);

                    if (elementoStandInterior != null) {
                        int cantLuminarias = Integer.parseInt(elementoStandInterior.getElementsByTagName("cantLuminarias").item(0).getTextContent());
                        StandInterior standInterior = new StandInterior(cantLuminarias, idStand, superficie, precioM2, cliente, listaAccesorios);
                        feria.agregaStand(standInterior);
                    } else {
                        StandExterior standExterior = new StandExterior(idStand, superficie, precioM2, cliente, listaAccesorios);
                        feria.agregaStand(standExterior);
                    }
                }
            }
            return true;
        } catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) {
            return false;
        }
    }

}
