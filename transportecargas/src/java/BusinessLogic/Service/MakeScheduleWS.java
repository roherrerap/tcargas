/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import BusinessLogic.Controller.ROB;
import BusinessLogic.Controller.MakeSchedule;
import java.text.ParseException;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */
@WebService(serviceName = "MakeScheduleWS")
public class MakeScheduleWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "makeSchedule")
    public ROB makeSchedule(String username, String password, String datefinal, String description) throws ParseException {
        //Instancia un objeto de la clase encargada de realizar las transacciones 
        MakeSchedule makeSchedule = new MakeSchedule();
    	//Se llama a la función que realiza la transacción y se le enían los parámetros que necesita 
        //para realizarla, los cuales vienen de la aplicacion que consume el servicio 
        return makeSchedule.make(username, password, datefinal, description);
    }
}
