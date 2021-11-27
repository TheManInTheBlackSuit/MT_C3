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
public class RepositorioClient {
    @Autowired
    private InterfaceClient crud;
    
    public List<Client> getAll(){
        return (List)crud.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return (Optional)crud.findById(id);
    }
    
    public Client guardar(Client obj){
        return crud.save(obj);
    }
    public Client actualizar(Client obj){
        return crud.save(obj);
    }
    
    public void borrar(Integer id){
        crud.deleteById(id);
    }
    
}
