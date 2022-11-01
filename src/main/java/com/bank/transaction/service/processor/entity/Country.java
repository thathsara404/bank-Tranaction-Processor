package com.bank.transaction.service.processor.entity;

import com.bank.transaction.service.processor.enums.CountryName;
import com.bank.transaction.service.processor.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="country")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "countryName", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CountryName countryName;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

//    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Branch> branches;

}
