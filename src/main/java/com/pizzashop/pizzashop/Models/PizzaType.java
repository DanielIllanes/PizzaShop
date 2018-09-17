package com.pizzashop.pizzashop.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pizzas_types")
public class PizzaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    protected PizzaType(){}

    public PizzaType(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
