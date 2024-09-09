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
    private Set<IllustrationOrder> items = new HashSet<>();
    //O Set acima é para que o próprio Java garanta que não haja pedidos repetidos;

    public Order() {
    }

    public Order(Long id, String description, String comments, PaymentStatus payment, ReceiptType receipt, Date delivery, Instant creationDate, Instant updateDate, Client client) {
        this.id = id;
        this.description = description;
        this.comments = comments;
        this.payment = payment;
        this.receipt = receipt;
        this.delivery = delivery;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Set<IllustrationOrder> getItems() {
        return items;
    }

    public void setItems(Set<IllustrationOrder> items) {
        this.items = items;
    }

    @PrePersist
    public void prePersist() {
        creationDate = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = Instant.now();
    }

    public double getTotalValue() {
        double sum = 0.0;

        for (IllustrationOrder io : items) {
            sum = sum + io.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
