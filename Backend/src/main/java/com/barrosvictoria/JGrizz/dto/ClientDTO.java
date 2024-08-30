package com.barrosvictoria.JGrizz.dto;

import com.barrosvictoria.JGrizz.entities.Client;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    private String phone;
    private String network;
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.network = entity.getNetwork();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Campo requerido") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Campo requerido") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Campo requerido") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Campo requerido") String phone) {
        this.phone = phone;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
