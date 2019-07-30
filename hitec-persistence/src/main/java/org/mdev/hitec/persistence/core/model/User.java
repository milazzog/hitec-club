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
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(name = "UNQ_USER_USERNAME", columnNames = "USERNAME"))
@NamedQueries({
        @NamedQuery(name = "user.find.by.username", query = "select u from User u where u.username = :username")
})
public class User implements Traceable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(name = "USERNAME", length = 32, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 32, nullable = false)
    private String password;

    @Column(name = "ACTIVE")
    private boolean active;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_PERMISSION",
            joinColumns = @JoinColumn(name = "USER", foreignKey = @ForeignKey(name = "FK_USER_PERMISSION_USER_ID")),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION", foreignKey = @ForeignKey(name = "FK_USER_PERMISSION_PERMISSION_ID"))
    )
    private Set<Permission> permissions = new HashSet<>();


}
