/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Juan Diego
 */
public class ExcepcionNegocio extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionNegocio</code> without detail
     * message.
     */
    public ExcepcionNegocio() {
    }

    /**
     * Constructs an instance of <code>ExcepcionNegocio</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionNegocio(String msg) {
        super(msg);
    }
}
