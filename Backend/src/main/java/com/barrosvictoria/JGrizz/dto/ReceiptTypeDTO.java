package com.barrosvictoria.JGrizz.dto;

import com.barrosvictoria.JGrizz.entities.ReceiptType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ReceiptTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String description;
    @NotNull(message = "Campo requerido")
    private Boolean active;

    public ReceiptTypeDTO() {
    }

    public ReceiptTypeDTO(ReceiptType entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.active = entity.getActive();
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
}
