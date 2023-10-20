/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import Excepciones.ClienteNoEncontrado;

/**
 *
 * @author dalilacabeza
 */
public class Feria {
    private Set<Cliente> listaClientes;
    private Set<Stand> listaStands;

    public Cliente buscaClientePorId(String idCliente) throws ClienteNoEncontrado{
         for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente; 
            }
        }
               
        throw new ClienteNoEncontrado("Error: ID no encontrado");
    }
  
}
