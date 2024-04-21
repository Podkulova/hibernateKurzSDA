package org.example.hibernate.hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "_order")
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {

    private DeliveryType dType;

    @OneToOne
    private Customer customer;

    @OneToMany
    private List<OrderItem> items;

}
