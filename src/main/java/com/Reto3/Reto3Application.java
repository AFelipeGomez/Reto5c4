package com.Reto3;


import com.Reto3.repository.crud.IClotheCrudRepository;
import com.Reto3.repository.crud.OrderCrudRepository;

import com.Reto3.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto3Application implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userRepo;

    
    
    @Autowired
    private IClotheCrudRepository clotheRepo;
    
    @Autowired
    private OrderCrudRepository orderRepo;

    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        
        orderRepo.deleteAll();
        clotheRepo.deleteAll();

        //para efectos de formateo de fechas
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");   
    }

}
