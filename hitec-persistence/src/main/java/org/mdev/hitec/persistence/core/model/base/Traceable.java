package org.mdev.hitec.persistence.core.model.base;

import java.util.Date;

/**
 * Created by GiuseppeMilazzo on 29/07/2019.
 * <p>
 * default mapping:
 *
 * @Id
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Column(name = ID)
 * @Setter(AccessLevel.PRIVATE) private Long id;
 * @Column(name = "CREATED_BY", length = 64, nullable = false)
 * private String createdBy;
 * @Column(name = "CREATED_AT", nullable = false)
 * @Temporal(TemporalType.TIMESTAMP) private Date createdAt;
 * @Column(name = "MODIFIED_BY", length = 64)
 * private String modifiedBy;
 * @Column(name = "MODIFIED_AT")
 * @Temporal(TemporalType.TIMESTAMP) private Date modifiedAt;
 */
public interface Traceable extends Identifiable {

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getModifiedBy();

    void setModifiedBy(String modifiedBy);

    Date getModifiedAt();

    void setModifiedAt(Date modifiedAt);
}
