package com.barrosvictoria.JGrizz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class IllustrationOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private IllustrationOrderPK id = new IllustrationOrderPK();// Chave composta para o JPA;

    private Integer quantity;
    private Double price;

    public IllustrationOrder(){
    }

    public IllustrationOrder(Order order, Illustration illustration,
                             Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setIllustration(illustration);
        this.quantity = quantity;
        this.price = price;
    }

    public double getSubTotal() {
        return price * quantity;
    }

    public IllustrationOrderPK getId() {
        return id;
    }

    public void setId(IllustrationOrderPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
