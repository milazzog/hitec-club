package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.ProductRegistry;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.ProductRegistryRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class ProductRegistryRepositoryImpl extends BaseRepository<ProductRegistry> implements ProductRegistryRepository {

    @Override
    protected Class<ProductRegistry> getManagedClass() {
        return ProductRegistry.class;
    }
}
