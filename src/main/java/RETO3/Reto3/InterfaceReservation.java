/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RETO3.Reto3;

import org.springframework.data.repository.CrudRepository;
import java.util.*;

/**
 *
 * @author Sebastian
 */
public interface InterfaceReservation extends CrudRepository<Reservation,Integer> {
    
    public List<Reservation> findByStartDateBetween(Date first,Date last);
    
    public List<Reservation> findByStatus(String status);
    
    
}
