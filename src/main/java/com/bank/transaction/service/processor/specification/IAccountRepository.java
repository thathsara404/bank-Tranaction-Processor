package com.bank.transaction.service.processor.specification;

import com.bank.transaction.service.processor.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Represent the specification which includes account related operations.
 * */
@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    public abstract Account getByAccountNumber(final UUID accountNumber);

}
