package com.Reto3.repository.crud;

import com.Reto3.model.Clothe;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;





public interface IClotheCrudRepository extends CrudRepository<Clothe, String> {

    public List<Clothe> findByPriceLessThanEqual(double precio);
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Clothe> findByDescriptionLike(String description);
}
