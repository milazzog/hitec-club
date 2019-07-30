package org.mdev.hitec.persistence.core.repository.interfaces;

import org.mdev.hitec.persistence.core.model.User;
import org.mdev.hitec.persistence.core.repository.base.Repository;
import org.mdev.hitec.persistence.core.repository.exceptions.EntityNotFoundException;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public interface UserRepository extends Repository<User> {

    User findByUsername(String username) throws EntityNotFoundException;
}
