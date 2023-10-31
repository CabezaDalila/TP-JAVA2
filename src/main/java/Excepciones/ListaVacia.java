
package Excepciones;

public class ListaVacia extends Exception {

    /**
     * Creates a new instance of <code>ListaVacia</code> without detail message.
     */
    public ListaVacia() {
    }

    /**
     * Constructs an instance of <code>ListaVacia</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ListaVacia(String msg) {
        super(msg);
    }
}
