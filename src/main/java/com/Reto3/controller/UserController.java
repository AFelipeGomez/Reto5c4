package com.Reto3.controller;

import com.Reto3.model.User;
import com.Reto3.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Gomez
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    /**
     * Inyeccion del service
     */
    @Autowired
    private UserService servicio;

    /**
     * Peticion para obtener todos los usuarios
     * @return 
     */
    @GetMapping("/all")
    public List<User> listAll() {
        return servicio.listAll();
    }
    
    /**
     * Peticion para obtener usuario por id
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return servicio.getUser(id);
    }

    /**
     * Peticion para validar la existencia del email
     * @param email
     * @return 
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return servicio.emailExists(email);
    }

    /**
     * Peticion para validar y autenticar al usuario que inicia sesion
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticateUser(email, password);
    }

    /**
     * Peticion para la creacion de nuevos usuarios
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return servicio.create(user);
    }

    /**
     * Peticion para la actualizacion de usuarios registrados
     * @param user
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicio.update(user);
    }
    
    /**
     * Peticion para eliminacion de usuairos por id
     * @param id
     * @return 
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
    /**
     * Peticion para listar usuarios por fecha
     * @param monthBirthtDay
     * @return 
     */
    
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return servicio.birthtDayList(monthBirthtDay);
    }
}
