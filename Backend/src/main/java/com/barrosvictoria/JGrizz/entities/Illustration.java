package com.barrosvictoria.JGrizz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_illustration")
public class Illustration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column(columnDefinition = "TEXT", length = 300)
    private String comments;
    @Column
    private Double price;


    @JsonIgnore
    @OneToMany(mappedBy = "id.illustration")
    private Set<IllustrationOrder> itens = new HashSet<>();
    //O Set acima é para que o próprio Java garante que não haja pedidos repetidos;


    public Illustration (){
    }
    public Illustration(Long id, String description, String comments, Double price) {
        this.id = id;
        this.description = description;
        this.comments = comments;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Illustration that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(),
                that.getDescription()) && Objects.equals(getComments(),
                that.getComments()) && Objects.equals(getPrice(), that.getPrice());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getComments(), getPrice());
    }

}
