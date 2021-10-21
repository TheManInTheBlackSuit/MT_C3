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
public class ServiciosCategory{
    @Autowired
    
    private RepositorioCategory metodosCRUD;
    
    public List<Category> getAll(){
        return (List)metodosCRUD.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return (Optional)metodosCRUD.getCategory(id);
    }
    
    public Category guardar(Category obj){
        if(obj.getId()==null){
            return metodosCRUD.guardar(obj);
        }
        else{
            Optional<Category> resp=metodosCRUD.getCategory(obj.getId());
            if(resp.isEmpty()){
                return metodosCRUD.guardar(obj);
            }
            else{
                return obj;
            }
        }
    }
    
}
