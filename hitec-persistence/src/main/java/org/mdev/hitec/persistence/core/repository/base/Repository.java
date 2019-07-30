package org.mdev.hitec.persistence.core.repository.base;

import org.mdev.hitec.persistence.core.model.base.Identifiable;
import org.mdev.hitec.persistence.core.repository.exceptions.EntityNotFoundException;

import java.util.List;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public interface Repository<T extends Identifiable> {

    void save(T item);

    void delete(T item);

    T merge(T item);

    T find(Long id) throws EntityNotFoundException;

    List<T> find();
}