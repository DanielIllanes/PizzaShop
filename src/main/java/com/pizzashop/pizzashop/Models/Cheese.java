package com.pizzashop.pizzashop.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cheese {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @Size(min=2, max=30)
    private String provider;

    protected Cheese(){}

    public Cheese(String name, String provider){
        this.name = name;
        this.provider = provider;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setProvider(String location) { this.provider = provider; }

    public String getProvider() { return provider; }

}
