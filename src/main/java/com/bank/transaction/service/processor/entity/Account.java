package com.bank.transaction.service.processor.entity;

import com.bank.transaction.service.processor.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="bankAccount")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "accountNumber", updatable = false, nullable = false, unique = true)
    private UUID accountNumber = UUID.randomUUID();

    @Column(name = "accountType", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "accountBalance", nullable = false)
    private BigDecimal accountBalance;


}
