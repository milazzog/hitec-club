package org.mdev.hitec.persistence.core.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mdev.hitec.persistence.core.model.base.Identifiable;
import org.mdev.hitec.persistence.core.model.enums.PermissionType;

import javax.persistence.*;

/**
 * Created by GiuseppeMilazzo on 29/07/2019.
 */
@Data
@Entity
@Table(name = "PERMISSION", uniqueConstraints = @UniqueConstraint(name = "UNQ_PERMISSION_PERMISSION_TYPE", columnNames = "PERMISSION_TYPE"))
public class Permission implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "PERMISSION_TYPE", length = 32, nullable = false)
    private PermissionType permissionType;
}
