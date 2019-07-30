package org.mdev.hitec.persistence.core.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mdev.hitec.persistence.core.model.base.Traceable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Data
@Entity
@Table(name = "CASH_REGISTER")
public class CashRegister implements Traceable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(name = "OPENING_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;

    @Column(name = "CLOSING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closingDate;

    @Column(name = "CREATED_BY", length = 64, nullable = false)
    private String createdBy;

    @Column(name = "CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "MODIFIED_BY", length = 64)
    private String modifiedBy;

    @Column(name = "MODIFIED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @OneToMany(mappedBy = "cashRegister", fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "CASH_REGISTER_SALE_DEED",
            joinColumns = @JoinColumn(
                    name = "CASH_REGISTER",
                    foreignKey = @ForeignKey(name = "FK_CASH_REGISTER_SALE_DEED_CASH_REGISTER")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "SALE_DEED",
                    foreignKey = @ForeignKey(name = "FK_CASH_REGISTER_SALE_DEED_SALE_DEED")
            )
    )
    private Set<SaleDeed> saleDeeds = new HashSet<>();


}
