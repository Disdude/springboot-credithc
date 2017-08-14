package com.hc.henghuirong.server.common.util;

import com.hc.henghuirong.server.common.model.auth.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @author Jonsy
 */
public class SecurityUtils {

    public static String getUid() {
        return getUser() == null ? "" : getUser().getUid();
    }

    public static SecurityUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return (SecurityUser) authentication.getPrincipal();
    }

    public static boolean isRoot() {
        return "root".equals(getUser().getUsername());
    }


}
