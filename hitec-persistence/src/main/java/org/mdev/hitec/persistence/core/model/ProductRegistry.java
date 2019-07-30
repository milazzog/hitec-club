package org.mdev.hitec.persistence.core.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mdev.hitec.persistence.core.model.base.Traceable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by GiuseppeMilazzo on 29/07/2019.
 */
@Data
@Entity
@Table(name = "PRODUCT_REGISTRY")
public class ProductRegistry implements Traceable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(
            name = "PRODUCT",
            nullable = false,
            referencedColumnName = ID,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_REGISTRY_PRODUCT")
    )
    private Product product;

    @Column(name = "QUANTITY", nullable = false, precision = 8, scale = 2)
    private BigDecimal quantity;

    @Column(name = "SOLD", nullable = false, precision = 8, scale = 2)
    private BigDecimal sold;

    @Column(name = "FINISHED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishedOn;

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
