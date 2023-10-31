
package Excepciones;

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
