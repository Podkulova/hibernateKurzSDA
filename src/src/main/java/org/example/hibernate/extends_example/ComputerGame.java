package org.example.hibernate.extends_example;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hibernate.hql.entity.BaseEntity;

@Entity
@NoArgsConstructor
@Setter
public class ComputerGame extends BaseEntity {
    private String name;
    private String description;
    private String type;
}
