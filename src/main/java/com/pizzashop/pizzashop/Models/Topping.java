package com.pizzashop.pizzashop.Models;

import javax.persistence.*;

@Entity
@Table(name = "toppings")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    protected Topping(){}

    public Topping(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }
}
