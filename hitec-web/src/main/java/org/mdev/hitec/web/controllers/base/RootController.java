package org.mdev.hitec.web.controllers.base;

import org.apache.commons.lang3.StringUtils;
import org.mdev.hitec.persistence.core.model.User;
import org.mdev.hitec.persistence.core.model.base.Identifiable;
import org.mdev.hitec.web.auth.model.UserDetailsImpl;
import org.mdev.hitec.web.services.FacesMessageManager;
import org.mdev.hitec.web.services.WebResourceBundle;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public class RootController extends SpringBeanAutowiringSupport {

    private static final String ERROR_PARAM_NAME = "isError";
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    @Autowired
    protected FacesMessageManager messageManager;

    @Autowired
    protected WebResourceBundle resourceBundle;

    public String id(Identifiable obj) {
        return Objects.nonNull(obj) ? obj.getIdString() : "-";
    }

    public String getDate(Date date) {

        if (Objects.nonNull(date))
            return (new SimpleDateFormat(DATE_PATTERN)).format(date);
        return "-";

    }

    public String getTime(Date date) {

        if (Objects.nonNull(date))
            return (new SimpleDateFormat(TIME_PATTERN)).format(date);
        return "-";
    }

    public String getDateTime(Date date) {
        if (Objects.nonNull(date))
            return (new SimpleDateFormat(DATETIME_PATTERN)).format(date);
        return "-";
    }

    public String reduce(String val) {

        if (StringUtils.isBlank(val)) {
            return "-";
        }

        if (val.length() > 20) {
            return val.substring(0, 20) + " ...";
        }

        return val;
    }

    public User getLoggedInUser() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetailsImpl) {
            return ((UserDetailsImpl) principal).getUser();
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    protected void markError() {
        RequestContext.getCurrentInstance().addCallbackParam(ERROR_PARAM_NAME, true);
    }

    protected void redirect(String outcome) {

        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        String url = contextPath + outcome;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException e) {
            throw new RuntimeException(String.format("error while loading page: %s", url), e);
        }
    }
}
