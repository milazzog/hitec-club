package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.SaleDeed;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.SaleDeedRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class SaleDeedRepositoryImpl extends BaseRepository<SaleDeed> implements SaleDeedRepository {

    @Override
    protected Class<SaleDeed> getManagedClass() {
        return SaleDeed.class;
    }
}
