package com.bank.transaction.service.processor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="branch")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "branchNumber", updatable = false, nullable = false, unique = true)
    private UUID branchNumber = UUID.randomUUID();

    @Column(name = "branchName", nullable = false)
    private String branchName;

    @ManyToOne
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;

//    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
//    private Set<Account> accounts;

}
