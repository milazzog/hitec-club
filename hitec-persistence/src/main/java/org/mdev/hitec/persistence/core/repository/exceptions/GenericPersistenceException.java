package org.mdev.hitec.persistence.core.repository.exceptions;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public class GenericPersistenceException extends Exception {

    public GenericPersistenceException(Throwable cause) {
        super(cause);
    }

    public GenericPersistenceException(String message) {
        super(message);
    }

    public GenericPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
