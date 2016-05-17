/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import BusinessLogic.Controller.ROB;
import BusinessLogic.Controller.ServiceSchedule;

/**
 *
 * @author Grupo 6 - Transportes de Carga
 */

@WebService(serviceName = "CheckScheduleWS")
public class CheckScheduleWS {

    @WebMethod(operationName = "checkSchedule")
    public ROB checkSchedule(String idscheduleusername, String password, String idschedule) {
        //Instancia un objeto de la clase encargada de realizar las transacciones 
        ServiceSchedule checkSchedule = new ServiceSchedule();
    	//Se llama a la función que realiza la transacción y se le enían los parámetros que necesita 
        //para realizarla, los cuales vienen de la aplicacion que consume el servicio 
        return checkSchedule.check(idscheduleusername, password, idschedule);
    }
}
