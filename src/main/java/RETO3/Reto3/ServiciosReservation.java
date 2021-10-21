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
 *
 * @author Sebastian
 */
@Service
public class ServiciosReservation {
    @Autowired
     private RepositorioReservation metodosCRUD;
    
    public List<Reservation> getAll(){
        return (List)metodosCRUD.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return (Optional)metodosCRUD.getReservation(id);
    }
    
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
    
}
