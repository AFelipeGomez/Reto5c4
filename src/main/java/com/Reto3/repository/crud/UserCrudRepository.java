package com.Reto3.repository.crud;

import com.Reto3.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Andres Gomez
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    //Reto 5
    List<User> findByMonthBirthtDay(String monthBirthtDay);
    
    //Para seleccionar el usuario con el id maximo
    //Corresponde a esta consulta de mongodb: db.usuarios.find().limit(1).sort({$natural:-1})
    Optional<User> findTopByOrderByIdDesc();
}
