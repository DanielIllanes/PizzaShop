package com.pizzashop.pizzashop.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizzas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Enumerated(EnumType.STRING)
    private PizzaTypes pizzatype;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Crust crust;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Cheese cheese;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sauce sauce;

    @ElementCollection
    @CollectionTable(name = "toppings")
    private List<String> toppings = new ArrayList();

    @ElementCollection
    @CollectionTable(name = "ingredients")
    private List<String> ingredients = new ArrayList();

    protected Pizzas(){}

    public Pizzas(PizzaTypes name, Sauce sauce, Cheese cheese, Crust crust, List<String> toppings, List<String> ingredients){
        this.pizzatype = name;
        this.sauce = sauce;
        this.cheese = cheese;
        this.crust = crust;
        this.toppings = toppings;
        this.ingredients = ingredients;
        System.out.println(crust);
        System.out.println(crust.toString());
        System.out.println(crust.name());
    }

    public void setPizzatype(PizzaTypes pizzatype){
        this.pizzatype = pizzatype;
    }

    public PizzaTypes getPizzatype(){
        return this.pizzatype;
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
}
