package com.bank.transaction.service.processor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="userProfile")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId", updatable = false, nullable = false, unique = true)
    private UUID userId = UUID.randomUUID();

    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "firstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Column(name = "tele", nullable = false, length = 10)
    private String tele;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private Set<Account> accounts;

}
