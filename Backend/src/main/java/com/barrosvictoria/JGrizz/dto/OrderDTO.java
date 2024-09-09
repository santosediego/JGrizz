package com.barrosvictoria.JGrizz.dto;

import com.barrosvictoria.JGrizz.entities.IllustrationOrder;
import com.barrosvictoria.JGrizz.entities.Order;
import com.barrosvictoria.JGrizz.entities.enums.PaymentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String description;
    private String comments;
    private PaymentStatus payment;
    @NotNull(message = "Campo requerido")
    private ReceiptTypeDTO receipt;
    private Date delivery;
    private Instant creationDate;
    private Instant updateDate;
    private ClientDTO client;
    private Double totalValue;
    private List<IllustrationOrderDTO> items = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Long id, String description, String comments, PaymentStatus payment, ReceiptTypeDTO receipt, Date delivery, Instant creationDate, Instant updateDate, ClientDTO client, Double totalValue) {
        this.id = id;
        this.description = description;
        this.comments = comments;
        this.payment = payment;
        this.receipt = receipt;
        this.delivery = delivery;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.client = client;
        this.totalValue = totalValue;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        description = entity.getDescription();
        comments = entity.getComments();
        payment = entity.getPayment();
        receipt = new ReceiptTypeDTO(entity.getReceipt());
        delivery = entity.getDelivery();
        creationDate = entity.getCreationDate();
        updateDate = entity.getUpdateDate();
        client = new ClientDTO(entity.getClient());
        totalValue = entity.getTotalValue();
        for (IllustrationOrder item : entity.getItems()) {
            IllustrationOrderDTO itemDTO = new IllustrationOrderDTO(item);
            items.add(itemDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Campo requerido") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Campo requerido") String description) {
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

    public @NotNull(message = "Campo requerido") ReceiptTypeDTO getReceipt() {
        return receipt;
    }

    public void setReceipt(@NotNull(message = "Campo requerido") ReceiptTypeDTO receipt) {
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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<IllustrationOrderDTO> getItems() {
        return items;
    }

    public void setItems(List<IllustrationOrderDTO> items) {
        this.items = items;
    }
}
