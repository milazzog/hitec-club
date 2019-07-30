package org.mdev.hitec.persistence.core.repository.exceptions;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public class MultipleEntityFoundException extends GenericPersistenceException {

    public MultipleEntityFoundException(Throwable cause) {
        super(cause);
    }

    public MultipleEntityFoundException(String message) {
        super(message);
    }

    public MultipleEntityFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}