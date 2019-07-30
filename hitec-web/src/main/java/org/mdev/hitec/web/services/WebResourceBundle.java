package org.mdev.hitec.web.services;

import org.springframework.stereotype.Service;

import javax.faces.context.FacesContext;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
@Service
public class WebResourceBundle extends ApplicationResourceBundle {

    private static final String BUNDLE_NAME = "internationalization.language";

    @Override
    public ResourceBundle getLanguageBundle() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext != null && facesContext.getViewRoot() != null ?
                facesContext.getViewRoot().getLocale() : Locale.getDefault();
        return ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    @Override
    public String getString(String key) {
        return getLanguageBundle().getString(key);
    }
}