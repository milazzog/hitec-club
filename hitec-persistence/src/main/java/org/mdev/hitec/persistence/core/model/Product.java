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
@Table(name = "PRODUCT", uniqueConstraints = @UniqueConstraint(name = "UNQ_PRODUCT_CODE", columnNames = "CODE"))
public class Product implements Traceable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(name = "CODE", length = 16, nullable = false)
    private String code;

    @Column(name = "NAME", length = 128, nullable = false)
    private String name;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PRICE",
            nullable = false,
            referencedColumnName = ID,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_PRICE"))
    private Price price;

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

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Price> prices = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<ProductRegistry> productRegistries = new HashSet<>();
}
