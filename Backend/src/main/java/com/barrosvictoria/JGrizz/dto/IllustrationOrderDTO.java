package com.barrosvictoria.JGrizz.dto;

import com.barrosvictoria.JGrizz.entities.IllustrationOrder;

import java.io.Serializable;

public class IllustrationOrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long illustrationId;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double subTotal;

    public IllustrationOrderDTO() {
    }

    public IllustrationOrderDTO(Long illustrationId, Integer quantity, Double price, Double discount, Double subTotal) {
        this.illustrationId = illustrationId;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.subTotal = subTotal;
    }

    public IllustrationOrderDTO(IllustrationOrder entity) {
        illustrationId = entity.getIllustration().getId();
        quantity = entity.getQuantity();
        price = entity.getPrice();
        discount = entity.getDiscount();
        subTotal = entity.getSubTotal();
    }

    public Long getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(Long illustrationId) {
        this.illustrationId = illustrationId;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
