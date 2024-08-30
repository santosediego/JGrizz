package com.barrosvictoria.JGrizz.entities;

import com.barrosvictoria.JGrizz.entities.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120)
    private String description;
    @Column(length = 300)
    private String comments;
    private PaymentStatus payment;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_type_id")
    private ReceiptType receipt;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date delivery;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant creationDate;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "id.order")
    private Set<IllustrationOrder> itens = new HashSet<>();
    //O Set acima é para que o próprio Java garante que não haja pedidos repetidos;

    public Order(){
    }
    public Order(Long id, String description, String comments,
                 PaymentStatus payment, Double price,
                 ReceiptType receipt, Date delivery,
                 Instant creationDate, Instant updateDate) {
        this.id = id;
        this.description = description;
        this.comments = comments;
        this.payment = payment;
        this.price = price;
        this.receipt = receipt;
        this.delivery = delivery;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public PaymentStatus getPayment() {
        return payment;
    }

    public void setPayment(PaymentStatus payment) {
        this.payment = payment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ReceiptType getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptType receipt) {
        this.receipt = receipt;
    }

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }
    @PrePersist
    public void prePersist() {
        creationDate = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = Instant.now();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getDescription(),
                order.getDescription()) && Objects.equals(getComments(),
                order.getComments()) && Objects.equals(getPayment(),
                order.getPayment()) && Objects.equals(getPrice(),
                order.getPrice()) && Objects.equals(getReceipt(),
                order.getReceipt()) && Objects.equals(getDelivery(),
                order.getDelivery()) && Objects.equals(getCreationDate(),
                order.getCreationDate()) && Objects.equals(getUpdateDate(),
                order.getUpdateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getComments(),
                getPayment(), getPrice(), getReceipt(), getDelivery(),
                getCreationDate(), getUpdateDate());
    }
}
