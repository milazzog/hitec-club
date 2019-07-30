package org.mdev.hitec.persistence.core.model.base;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by GiuseppeMilazzo on 29/07/2019.
 * <p>
 * default mapping:
 *
 * @Id
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * @Column(name = ID)
 * @Setter(AccessLevel.PRIVATE) private Long id;
 */
public interface Identifiable {

    String ID = "ID";

    Long getId();

    default String getIdString() {
        return StringUtils.leftPad(String.valueOf(getId()), 9, '0');
    }
}
