package com.barrosvictoria.JGrizz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120)
    private String name;
    @Column(length = 20)
    private String phone;
    @Column(length = 20)
    private String network;
    @Column(length = 50)
    private String email;


    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client (){
    }
    public Client(Long id, String name, String phone, String network, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.network = network;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getName(),
                client.getName()) && Objects.equals(getPhone(),
                client.getPhone()) && Objects.equals(getNetwork(),
                client.getNetwork()) && Objects.equals(getEmail(), client.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhone(), getNetwork(), getEmail());
    }
}
