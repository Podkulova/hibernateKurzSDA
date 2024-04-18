package org.example.hibernate.hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity{

    private int countStock;

    private String name;

    private int price;

    @ManyToOne
    private Order order;
}
