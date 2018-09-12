package com.pizzashop.pizzashop.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @OneToOne
    @ElementCollection
    private PizzaType type;
    @NotNull
    private Crust crust;
    @NotNull
    private Cheese cheese;
    @NotNull
    private Sauce sauce;

    @ElementCollection
    @CollectionTable(name = "toppings")
    private List<String> toppings = new ArrayList();

    @ElementCollection
    @CollectionTable(name = "toppings")
    private List<String> ingredients = new ArrayList();

    protected Pizza(){}

    public Pizza(PizzaType name, Sauce sauce, Cheese cheese, Crust crust, List<String> toppings, List<String> ingredients){
        this.type = name;
        this.sauce = sauce;
        this.cheese = cheese;
        this.crust = crust;
        this.toppings = toppings;
        this.ingredients = ingredients;
    }

    public void setType(PizzaType type){
        this.type = type;
    }

    public PizzaType getType(){
        return this.type;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
