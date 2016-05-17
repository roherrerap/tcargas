/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class ROB {
 
    private boolean success;
    private String err_message;
    private String data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErr_message() {
        return err_message;
    }

    public void setErr_message(String err_message) {
        this.err_message = err_message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
