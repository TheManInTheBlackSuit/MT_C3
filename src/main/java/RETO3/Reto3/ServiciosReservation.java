/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RETO3.Reto3;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


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
     * @param idReservacion es el id de la reservación que se quiere buscar.
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
     * @param idReservacion Es el id de la reservación que se quiere borrar.
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
    /**
     * Método que genera el reporte de reservaciones hechas en un intervalo de tiempo.
     * @param inicio Es la cadena de caracteres que tiene la fecha de inicio del intervalo.
     * @param terminacion Es la cadena de caracteres que tiene la fecha final del intervalo.
     * @return La lista con las reservas que cumplen la condición.
     */
    public List<Reservation> darReporte(String inicio, String terminacion){
       SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
       try{
       Date first=formato.parse(inicio);
       Date last=formato.parse(terminacion);
       return metodosCRUD.darReporte(first, last);
       }
       catch(Exception excepcion){
           
       }
       return null;
    }
    
    /**
     * Método que devuelve un Map con la cantidad de las reservas completadas y las 
     * reservas canceladas.
     * @return Mapa con la cantidad de reservas completadas y reservas canceladas.
     */
    public Map<String,Integer> darCompletadosVsCancelados(){
        Map<String,Integer> respuesta=new HashMap<>();
        int completados=metodosCRUD.darPorEstado("completed").size();
        int cancelados=metodosCRUD.darPorEstado("cancelled").size();
        respuesta.put("completed",completados);
        respuesta.put("cancelled", cancelados);
        return respuesta;
    }
    
    /**
     * Método que devuelve la lista con la información sobre los clientes y la cantidad
     * de reservas que han hecho.
     * @return Lista con los objetos que tienen la información de las reservas de los
     * clientes.
     */
    public List<Object> darTopClientes(){
       List<Reservation> reservas= metodosCRUD.darPorEstado("completed");
       reservas.addAll(metodosCRUD.darPorEstado("cancelled"));
       reservas.addAll(metodosCRUD.darPorEstado("created"));
       Map<Client,Integer> contadores=new HashMap();
       for(Reservation r:reservas){
           Client actual=r.getClient();
           if(contadores.get(actual)==null){
               contadores.put(actual,1);
           }
           else{
               contadores.put(actual,contadores.get(actual)+1);
           }
       }
       
       Set<Client> llaves=contadores.keySet();
       Map<Client,Integer> contadorOrdenado=new HashMap();
       Client mayor=null;
       int numMayor=0;
       while(contadores.size()>0){
           for(Client llave:llaves){
               if(contadores.get(llave)>numMayor){
                   numMayor=contadores.get(llave);
                   mayor=llave;
               }
           }
           contadorOrdenado.put(mayor, numMayor);
           contadores.remove(mayor);
           numMayor=0;
       }
       List<Object> respuesta=new ArrayList();
       for(Client cliente:contadorOrdenado.keySet()){
           Map<String,Object> mapResp=new HashMap();
           mapResp.put("total", contadorOrdenado.get(cliente));
           mapResp.put("client",cliente);
           respuesta.add(mapResp);
       }
       
       return respuesta;
    }
}
