package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.CashRegister;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.CashRegisterRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class CashRegisterRepositoryImpl extends BaseRepository<CashRegister> implements CashRegisterRepository {

    @Override
    protected Class<CashRegister> getManagedClass() {
        return CashRegister.class;
    }
}
