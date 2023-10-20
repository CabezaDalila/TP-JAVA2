/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Excepciones;

/**
 *
 * @author dalilacabeza
 */
public class ClienteNoEncontrado extends Exception {
    /**
     * Creates a new instance of <code>ClienteNoEncontrado</code> without detail
     * message.
     */
    public ClienteNoEncontrado() {
    }

    /**
     * Constructs an instance of <code>ClienteNoEncontrado</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ClienteNoEncontrado(String msg) {
        super(msg);
    }
}
