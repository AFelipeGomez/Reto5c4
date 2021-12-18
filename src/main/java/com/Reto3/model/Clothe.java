package com.Reto3.model;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Document(collection = "clothes")

@Data

@NoArgsConstructor

@AllArgsConstructor

public class Clothe {

@Id

private String reference;

private String category;

private String size;

private String description;

private boolean availability;

private double price;

private int quantity;

private String photography;

}
