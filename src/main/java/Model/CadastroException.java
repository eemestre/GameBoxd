/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Model;

/**
 *
 * @author Eduardo
 */
public class CadastroException extends Exception {

    /**
     * Creates a new instance of <code>CadastroException</code> without detail
     * message.
     */
    public CadastroException() {
    }

    /**
     * Constructs an instance of <code>CadastroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CadastroException(String msg) {
        super(msg);
    }
}
