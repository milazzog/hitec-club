package org.mdev.hitec.persistence.core.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mdev.hitec.persistence.core.model.base.Traceable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Data
@Entity
@Table(name = "SALE_DEED")
public class SaleDeed implements Traceable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(
            name = "PRICE",
            nullable = false,
            referencedColumnName = ID,
            foreignKey = @ForeignKey(name = "FK_SALE_DEED_PRICE")
    )
    private Price price;

    @Column(name = "QUANTITY", nullable = false, precision = 8, scale = 2)
    private BigDecimal quantity;

    @Column(name = "BASE_PRICE", nullable = false, precision = 8, scale = 2)
    private BigDecimal basePrice;

    @Column(name = "REAL_PRICE", nullable = false, precision = 8, scale = 2)
    private BigDecimal realPrice;

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
}
