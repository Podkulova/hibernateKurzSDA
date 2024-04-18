package org.example.hibernate.hql.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity{

    private String name;

    @Embedded
    private  Adress adress;
}
