package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.Account;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.interfaces.AccountRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class AccountRepositoryImpl extends BaseRepository<Account> implements AccountRepository {

    @Override
    protected Class<Account> getManagedClass() {
        return Account.class;
    }
}
