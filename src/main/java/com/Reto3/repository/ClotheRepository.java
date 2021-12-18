package com.Reto3.repository;

import com.Reto3.model.Clothe;
import com.Reto3.repository.crud.IClotheCrudRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class ClotheRepository {

	   @Autowired
	    private IClotheCrudRepository clotheCrudRepository;

	  

	    public List<Clothe> listAll() {
	        return (List<Clothe>) clotheCrudRepository.findAll();
	    }

	    public Optional<Clothe> getClothe(String reference) {
	        return clotheCrudRepository.findById(reference);
	    }

	    public Clothe create(Clothe clothe) {
	        return clotheCrudRepository.save(clothe);
	    }

	    public void update(Clothe clothe) {
	    	clotheCrudRepository.save(clothe);
	    }

	    public void delete(Clothe clothe) {
	    	clotheCrudRepository.delete(clothe);
	    }
            //Reto 5
    public List<Clothe> gadgetsByPrice(double precio) {
        return clotheCrudRepository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Clothe> findByDescriptionLike(String description) {
        return clotheCrudRepository.findByDescriptionLike(description);
    }
}
