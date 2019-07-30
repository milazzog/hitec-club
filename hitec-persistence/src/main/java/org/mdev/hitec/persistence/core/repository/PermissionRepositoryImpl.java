package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.Permission;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.PermissionRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class PermissionRepositoryImpl extends BaseRepository<Permission> implements PermissionRepository {

    @Override
    protected Class<Permission> getManagedClass() {
        return Permission.class;
    }
}
