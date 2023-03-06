package com.barrosvictoria.JGrizz.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable /*Informa que essa classe é um subtipo*/
public class IllustrationOrderPK implements Serializable {
    private static final long serialVersionUID = 1L;

    /*Essa classe fará referencia entre o pedido e o produto juntando os dois ids para criar o id
     * da classe ItemPedido.
     * */

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "illustration_id")
    private Illustration illustration;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Illustration getIllustration() {
        return illustration;
    }

    public void setIllustration(Illustration illustration) {
        this.illustration = illustration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IllustrationOrderPK that)) return false;
        return Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getIllustration(),
                that.getIllustration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getIllustration());
    }
}
