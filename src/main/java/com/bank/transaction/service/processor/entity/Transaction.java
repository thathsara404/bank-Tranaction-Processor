package com.bank.transaction.service.processor.entity;

import com.bank.transaction.service.processor.enums.TransactionDirection;
import com.bank.transaction.service.processor.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="transaction")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "transactionNumber", updatable = false, nullable = false, unique = true)
    private UUID transactionNumber = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    @Column(name = "beneficiaryAccountNumber", nullable = false)
    private UUID beneficiaryAccountNumber;

    @Column(name = "transactionDateTime", nullable = false)
    private LocalDateTime transactionDateTime = LocalDateTime.now();

    @Column(name = "transactionAmount", nullable = false)
    private BigDecimal transactionAmount;

    @Column(name = "transactionDescription", nullable = false)
    private String transactionDescription;

    @Column(name = "transactionDirection", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionDirection direction = TransactionDirection.OUT;

    @Column(name = "transactionStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus = TransactionStatus.PROCESSING;

}
