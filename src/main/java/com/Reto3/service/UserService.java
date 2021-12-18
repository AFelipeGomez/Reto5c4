package com.Reto3.service;

import com.Reto3.model.User;
import com.Reto3.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Gomez
 */
@Service
public class UserService {
    
    /**
     * Inyeccion del objeto para acceder a crud repository
     */
    @Autowired
    private UserRepository repositorio;
    
    /**
     * Metodo para obtener usuarios por id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }

    /**
     * Metodo para obtener todos los Usuarios
     * @return 
     */
    public List<User> listAll() {
        return repositorio.listAll();
    }
    /**
     * Metodo para validar la existencia de un email
     * @param email
     * @return 
     */

    public boolean emailExists(String email) {
        return repositorio.emailExists(email);
    }

    /**
     * Metodo para validar y autenticar al usuario
     * @param email
     * @param password
     * @return 
     */
    public User autenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
/**
 * Metodo para crear usuarios nuevos
 * @param user
 * @return 
 */
    public User create(User user) {
        
        Optional<User> userIdMaximo;
        
        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            
            //obtiene el maximo id existente en la coleccion
            userIdMaximo = repositorio.lastUserId();
            
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        
        //busca si en base de datos existe un documento cuyo id coincida con el que no enviarón en la peticiòn
        Optional<User> e = repositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return repositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
/**
 * Metodo para actualizar usuarios registrados
 * @param user
 * @return 
 */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                repositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
/**
 * Metodo para eliminar usuarios por id
 * @param userId
 * @return 
 */
    public boolean delete(int userId) {
        Optional<User> usuario = getUser(userId);
        
        if (usuario.isEmpty()){
            return false;
        }else{
            repositorio.delete(usuario.get());
            return true;
        }
        /*
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;

        */
    }
    /**
     * Metodo para listar usuarios por fecha de cumpleaños
     * @param monthBirthtDay
     * @return 
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return repositorio.birthtDayList(monthBirthtDay);
    }
}
