package org.mdev.hitec.web.services;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public abstract class ApplicationResourceBundle {

    public abstract ResourceBundle getLanguageBundle();

    public abstract String getString(String key);

    public final String getString(String key, Object... params) {
        return MessageFormat.format(getString(key), params);
    }
}