package org.example.hibernate.hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrderItem extends BaseEntity {

    private int count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
