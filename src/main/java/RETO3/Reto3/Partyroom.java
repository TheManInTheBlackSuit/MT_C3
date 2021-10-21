/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RETO3.Reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 *
 * @author Sebastian
 */
/** 
 Clase que representa los salones de fiestas.
 */
@Entity
@Table(name="partyroom")
public class Partyroom {
    /**
     Atributo que representa el id del salón de fiestas en la base de datos.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    
   /**
     * Atributo que representa el nombre del salón de fiestas.
     */
    private String name; 
    
   /**
    * Atributo que representa al dueño del salón de fiestas.
    */
    private String owner;
    /**
     * Atributo que representa la capacidad del salón de fiestas.
     */
    private Integer capacity;
    
     /**
     * Descripción del salón de fiestas.
     */
    private String description;
    
    /**
     * Atributo que representa la categoría a la que pertenece el salón de fiestas.
     */
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("partyrooms")
    private Category category;
    
   
    
    /**
     * Atributo que representa los mensajes dejados por los usuarios al salon de fiestas.
     */
   @OneToMany
   @JsonIgnoreProperties("partyroom")
   private List<Message> messages;
   
   /**
    * Atributo que representa las reservaciones hechas por los clientes para el salon de fiestas.
    */
   @OneToMany
   @JsonIgnoreProperties("partyroom")
   private List<Reservation> reservations;

   /**
    * Método que devuelve la lista de reservaciones del salón de fiestas.
    * @return lista de reservaciones.
    */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Método que establece la lista de reservaciones de un salón de fiestas.
     * @param reservations Es la lista de reservas hechas sobre el salón.
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

   
   /**
    * Método que retorna los mensajes de los clientes sobre un salón de fiestas.
    * @return lista de mensajes.
    */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Método que establece la lista de mensajes sobre un salón de fiestas.
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    

   /**
    * Método que devuelve el id del salón de fiestas.
    * @return id del salón de fiestas.
    */
    public Integer getId() {
        return id;
    }
    /**
     * Método que establece el id del salón de fiestas.
     * @param id Es el nuevo id de salón de fiestas.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que devuelve el nombre del dueño del salón de fiestas.
     * @return Cadena de caracteres que identifica al dueño del salón de fiestas.
     */
    public String getOwner() {
        return owner;
    }

    
    /**
     * Método que establece la cadena de caracteres que identifica al dueño del salón de fiestas.
     * @param owner Es el nombre o identificador del dueño del salón de fiestas.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Método que devuelve la capacidad de personas del salón de fiestas.
     * @return la capacidad del salón de fiestas.
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Método que establece la capacidad de personas del salón de fiestas.
     * @param capacity Es la capacidad del salón de fiestas.
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Método que devuelve la categoría del salón de fiestas.
     * @return La categoría del salón de fiestas.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Método que establece la categoría del salón de fiestas.
     * @param category Categoría a la que pertenece el salón de fiestas.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Método que devuelve el nombre del salón de fiestas.
     * @return Nombre del salón de fiestas.
     */
    public String getName() {
        return name;
    }

    /**
     * Método que establece el nombre del salón de fiestas.
     * @param name Es el nombre del salón de fiestas.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que devuelve la descripción del salón de fiestas.
     * @return Descripción del salón de fiestas.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que establece una descripción para el salón de fiestas.
     * @param description Es la descripción que tendrá el salón de fiestas.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
