package org.mdev.hitec.persistence.core.repository.exceptions;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public class EntityNotFoundException extends GenericPersistenceException {

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}