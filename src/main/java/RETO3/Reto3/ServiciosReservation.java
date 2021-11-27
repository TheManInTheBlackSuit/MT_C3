/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RETO3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Clase que representa los servicios de la entidad Reservation
 * @author Sebastian
 */
@Service
public class ServiciosReservation {
    /**
     * Relación con el respositorio que implementa los métodos CRUD de la entidad Reservation
     */
    @Autowired
     private RepositorioReservation metodosCRUD;
    
    /**
     * Método que devuelve la lista de todas las reservaciones hechas
     * @return Todas las reservaciones
     */
    public List<Reservation> getAll(){
        return (List)metodosCRUD.getAll();
    }
    
    /**
     * Método que devuelve una reservación específica de acuerdo al id entregado
     * como parámetro
     * @param id es el id de la reservación que se quiere buscar.
     * @return Un Optional que puede o no tener el objeto buscado de la entidad Reservation. 
     */
    public Optional<Reservation> getReservation(int idReservacion){
        return (Optional)metodosCRUD.getReservation(idReservacion);
    }
    
    /**
     * Método que guarda un objeto de la clase reservation en la bd
     * @param obj Es el objeto de la clase reservation que se quiere guardar.
     * @return Un objeto de la clase reservation de acuerdo a si se pudo guardar o no.
     */
    public Reservation guardar(Reservation obj){
        if(obj.getIdReservation()==null){
            return metodosCRUD.guardar(obj);
        }
        else{
            Optional<Reservation> resp=metodosCRUD.getReservation(obj.getIdReservation());
            if(resp.isEmpty()){
                return metodosCRUD.guardar(obj);
            }
            else{
                return obj;
            }
        }
    }
    
    /**
     * Método que borra un registro de la bd de acuerdo al id de la reservacion 
     * correspondiente.
     * @param id Es el id de la reservación que se quiere borrar.
     */
    public void borrar(Integer idReservacion){
        metodosCRUD.borrar(idReservacion);
    }
    
    /**
     * Método que actualiza la información de una reservación en la bd.
     * @param obj Es el objeto de la clase Reservation que tiene los datos actualizados.
     * @return Un objeto de la clase reservation de acuerdo a si se pudo o no realizar 
     * la operación.
     */
     public Reservation actualizar(Reservation obj){
          if(obj.getIdReservation()==null){
            return obj;
        }
        else{
            Optional<Reservation> resp=metodosCRUD.getReservation(obj.getIdReservation());
            if(!resp.isEmpty()){
                Reservation nuevo=resp.get();
                nuevo.setStartDate(obj.getStartDate());
                nuevo.setDevolutionDate(obj.getDevolutionDate());
                nuevo.setStatus(obj.getStatus());
                return metodosCRUD.actualizar(nuevo);
            }
            else{
                return obj;
            }
        }
    }
}
