/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import java.util.List;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
public class ROB {
 
    private boolean success;
    private String err_message;
    private Long data;
    private Integer dataint;
    private List information;

    public List getInformation() {
        return information;
    }

    public void setInformation(List information) {
        this.information = information;
    }

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

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Integer getDataint() {
        return dataint;
    }

    public void setDataint(Integer dataint) {
        this.dataint = dataint;
    }
    
}
