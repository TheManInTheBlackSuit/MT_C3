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
public class RepositorioMessage {
    @Autowired
    private InterfaceMessage crud;
    
    public List<Message> getAll(){
        return (List)crud.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return (Optional)crud.findById(id);
    }
    
    public Message guardar(Message obj){
        return crud.save(obj);
    }
    
}
