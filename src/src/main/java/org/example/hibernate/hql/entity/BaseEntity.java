package org.example.hibernate.hql.entity;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    int id;
}
