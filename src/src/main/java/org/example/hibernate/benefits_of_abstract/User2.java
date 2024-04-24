package org.example.hibernate.benefits_of_abstract;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Table(name = "_User")
public class User2 {
    @Id
    private String name;

    @Setter
    private int deposit;

    public User2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDeposit() {
        return deposit;
    }

}
