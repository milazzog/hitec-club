package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.Product;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.ProductRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class ProductRepositoryImpl extends BaseRepository<Product> implements ProductRepository {

    @Override
    protected Class<Product> getManagedClass() {
        return Product.class;
    }
}
