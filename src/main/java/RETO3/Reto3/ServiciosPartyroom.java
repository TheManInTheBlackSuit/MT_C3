package RETO3.Reto3;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sebastian
 */
@Service
public class ServiciosPartyroom {
    @Autowired
    
     private RepositorioPartyroom metodosCRUD;
    
    public List<Partyroom> getAll(){
        return (List)metodosCRUD.getAll();
    }
    
    public Optional<Partyroom> getCategory(int id){
        return (Optional)metodosCRUD.getPartyroom(id);
    }
    
    public Partyroom guardar(Partyroom obj){
        if(obj.getId()==null){
            return metodosCRUD.guardar(obj);
        }
        else{
            Optional<Partyroom> resp=metodosCRUD.getPartyroom(obj.getId());
            if(resp.isEmpty()){
                return metodosCRUD.guardar(obj);
            }
            else{
                return obj;
            }
        }
    }
    
    
     public void borrar(Integer id){
        metodosCRUD.borrar(id);
    }
     
    
     public Partyroom actualizar(Partyroom obj){
          if(obj.getId()==null){
            return obj;
        }
        else{
            Optional<Partyroom> resp=metodosCRUD.getPartyroom(obj.getId());
            if(!resp.isEmpty()){
                Partyroom nuevo=resp.get();
                nuevo.setCapacity(obj.getCapacity());
                nuevo.setDescription(obj.getDescription());
                nuevo.setName(obj.getName());
                nuevo.setOwner(obj.getOwner());
                return metodosCRUD.actualizar(nuevo);
            }
            else{
                return obj;
            }
        }
    }
    
}
