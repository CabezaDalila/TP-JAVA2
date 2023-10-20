/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Model.*;

public class CargaXML {
    public void cargarStandsXML(Feria feria){
        try{
            File archivoXML = new File("src/xml/Stands.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            doc.getDocumentElement().normalize();

            NodeList listaStands = doc.getElementsByTagName("stands");

            for (int i = 0; i < listaStands.getLength(); i++) {
                Node nodoStand = listaStands.item(i);

                if (nodoStand.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoStand = (Element) nodoStand;
                    Element elementoStandInterior = (Element) elementoStand.getElementsByTagName("StandInterior").item(0);
                    Element elementoStandExterior = (Element) elementoStand.getElementsByTagName("StandExterior").item(0);
                    String idStand = elementoStand.getElementsByTagName("idStand").item(0).getTextContent();
                    int superficie = Integer.parseInt(elementoStand.getElementsByTagName("superficieStand").item(0).getTextContent());
                    float precioM2 = Float.parseFloat(elementoStand.getElementsByTagName("preciom2Stand").item(0).getTextContent());
                    String idClienteStand = elementoStand.getElementsByTagName("idClienteStand").item(0).getTextContent();
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
                            feria.agregarAccesorios(accesorio);
                        }
                    }
                    Cliente cliente = new Cliente(idClienteStand,descCliente);
                    if(elementoStandInterior != null){
                        int cantLuminarias = Integer.parseInt(elementoStandInterior.getElementsByTagName("cantLuminarias").item(0).getTextContent());
                        StandInterior standInterior = new StandInterior(idStand, superficie, precioM2, cliente, listaAccesorios);
                        feria.agregaStand(standInterior);
                    } else {
                        StandExterior standExterior = new StandExterior(idStand, superficie, precioM2, cliente, listaAccesorios);
                        feria.agregarStand(standExterior);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
