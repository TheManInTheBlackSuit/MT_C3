/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RETO3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public class RepositorioReservation {
    @Autowired
    private InterfaceReservation crud;
    
     public List<Reservation> getAll(){
        return (List)crud.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return (Optional)crud.findById(id);
    }
    
    public Reservation guardar(Reservation obj){
        return crud.save(obj);
    }
    
    public void borrar(Integer id){
        crud.deleteById(id);
    }
    
    public Reservation actualizar(Reservation obj){
       return crud.save(obj);
    }
}
