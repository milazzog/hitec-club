package org.mdev.hitec.persistence.core.repository;

import org.mdev.hitec.persistence.core.model.User;
import org.mdev.hitec.persistence.core.repository.base.BaseRepository;
import org.mdev.hitec.persistence.core.repository.exceptions.EntityNotFoundException;
import org.mdev.hitec.persistence.core.repository.interfaces.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

    @Override
    protected Class<User> getManagedClass() {
        return User.class;
    }

    @Override
    @Transactional
    public User findByUsername(String username) throws EntityNotFoundException {
        return named("user.find.by.username")
                .setParameter("username", username)
                .getSingleResult();
    }
}
