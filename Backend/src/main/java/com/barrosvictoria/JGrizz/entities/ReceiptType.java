package com.barrosvictoria.JGrizz.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_receipt_type")
public class ReceiptType {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean active;

    public ReceiptType() {
    }

    public ReceiptType(Long id, String description, Boolean active) {
        this.id = id;
        this.description = description;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptType that = (ReceiptType) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, active);
    }
}
