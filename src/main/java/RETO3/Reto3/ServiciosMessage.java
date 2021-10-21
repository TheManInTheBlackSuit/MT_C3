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
public class ServiciosMessage {
    @Autowired
     private RepositorioMessage metodosCRUD;
    
    public List<Message> getAll(){
        return (List)metodosCRUD.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return (Optional)metodosCRUD.getMessage(id);
    }
    
    public Message guardar(Message obj){
        if(obj.getIdMessage()==null){
            return metodosCRUD.guardar(obj);
        }
        else{
            Optional<Message> resp=metodosCRUD.getMessage(obj.getIdMessage());
            if(resp.isEmpty()){
                return metodosCRUD.guardar(obj);
            }
            else{
                return obj;
            }
        }
    }
    
}
