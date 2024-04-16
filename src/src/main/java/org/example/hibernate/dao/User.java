package org.example.hibernate.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString(exclude = "account")
public class User {

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String lastName;

    @OneToOne(mappedBy = "owner", fetch = FetchType.EAGER)
    private Account account;
}
