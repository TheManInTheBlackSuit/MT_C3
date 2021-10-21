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
public class ServiciosClient {
    @Autowired
     private RepositorioClient metodosCRUD;
    
     public List<Client> getAll(){
        return (List)metodosCRUD.getAll();
    }
    
    public Optional<Client> getCategory(int id){
        return (Optional)metodosCRUD.getClient(id);
    }
    
    public Client guardar(Client obj){
        if(obj.getIdClient()==null){
            return metodosCRUD.guardar(obj);
        }
        else{
            Optional<Client> resp=metodosCRUD.getClient(obj.getIdClient());
            if(resp.isEmpty()){
                return metodosCRUD.guardar(obj);
            }
            else{
                return obj;
            }
        }
    }
    
}
