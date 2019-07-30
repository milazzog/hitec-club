package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.Price;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.PriceRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class PriceRepositoryImpl extends BaseRepository<Price> implements PriceRepository {

    @Override
    protected Class<Price> getManagedClass() {
        return Price.class;
    }
}
