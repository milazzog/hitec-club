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
 * Created by GiuseppeMilazzo on 29/07/2019.
 */
@Data
@Entity
@Table(name = "ACCOUNT")
public class Account implements Traceable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(
            name = "CASH_REGISTER",
            nullable = false,
            referencedColumnName = ID,
            foreignKey = @ForeignKey(name = "FK_ACCOUNT_CASH_REGISTER")
    )
    private CashRegister cashRegister;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ACCOUNT_SALE_DEED",
            joinColumns = @JoinColumn(
                    name = "ACCOUNT",
                    foreignKey = @ForeignKey(name = "FK_ACCOUNT_SALE_DEED_ACCOUNT")),
            inverseJoinColumns = @JoinColumn(
                    name = "SALE_DEED",
                    foreignKey = @ForeignKey(name = "FK_ACCOUNT_SALE_DEED_SALE_DEED"))
    )
    private Set<SaleDeed> saleDeeds = new HashSet<>();
}
