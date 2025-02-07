/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Model;

/**
 *
 * @author Eduardo
 */
public class BuscaException extends Exception {

    /**
     * Creates a new instance of <code>BuscaException</code> without detail
     * message.
     */
    public BuscaException() {
    }

    /**
     * Constructs an instance of <code>BuscaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BuscaException(String msg) {
        super(msg);
    }
}
