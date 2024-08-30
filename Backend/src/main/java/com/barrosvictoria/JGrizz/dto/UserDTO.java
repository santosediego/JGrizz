package com.barrosvictoria.JGrizz.dto;

import com.barrosvictoria.JGrizz.entities.User;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String username;
    @NotBlank(message = "Campo requerido")
    private String password;

    public UserDTO() {
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Campo requerido") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Campo requerido") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Campo requerido") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Campo requerido") String password) {
        this.password = password;
    }
}
