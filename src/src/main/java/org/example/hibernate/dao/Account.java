package org.example.hibernate.dao;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Account {

    public Account(int deposite, User owner) {
        this.deposite = deposite;
        this.owner = owner;
    }

    private int deposite;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
