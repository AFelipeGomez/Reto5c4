package com.Reto3.repository;

import com.Reto3.model.User;
import com.Reto3.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Gomez
 */
@Repository
public class UserRepository {

    /**
     * Inyeccion del obteto UserCrudRepository
     */
    @Autowired
    private UserCrudRepository crudInterface;

    /**
     * Metodo para obtener usuarios por id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    /**
     * Metodo para obtener todos los usuarios
     * @return 
     */
    public List<User> listAll() {
        return crudInterface.findAll();
    }

    /**
     * Metodo para validad la existenciade un email
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
     * Metodo para validar las credenciales y autenticar al usuario
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> autenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }

    /**
     * Metodo para crear usuarios nuevos
     * @param user
     * @return 
     */
    public User create(User user) {
        return crudInterface.save(user);
    }
    /**
     * Metodo para actualizar usuarios registrados
     * @param user
     * @return 
     */
    
    public User update(User user) {
        return crudInterface.save(user);
    }
    
    
    /**
     * Metodo para eliminar usuarios
     * @param user 
     */
    public void delete(User user) {
        crudInterface.delete(user);
    }
    
    /**
     * Metodo para obtenber usuarios en orden descendente
     * @return 
     */
     public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }
     
    /**
     * Metodo para obtener usuario por fecha de cumpleaños
     * @param monthBirthtDay
     * @return 
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return crudInterface.findByMonthBirthtDay(monthBirthtDay);
    }
}
