package com.barrosvictoria.JGrizz.dto;

import com.barrosvictoria.JGrizz.entities.Illustration;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class IllustrationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String description;
    @NotBlank(message = "Campo requerido")
    private String comments;
    @NotNull(message = "Campo requerido")
    private Double price;

    public IllustrationDTO() {
    }

    public IllustrationDTO(Illustration entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.comments = entity.getComments();
        this.price = entity.getPrice();
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

    public @NotBlank(message = "Campo requerido") String getComments() {
        return comments;
    }

    public void setComments(@NotBlank(message = "Campo requerido") String comments) {
        this.comments = comments;
    }

    public @NotNull(message = "Campo requerido") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Campo requerido") Double price) {
        this.price = price;
    }
}
