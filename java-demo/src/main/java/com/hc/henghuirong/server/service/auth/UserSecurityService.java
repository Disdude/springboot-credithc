package com.hc.henghuirong.server.service.auth;


import com.hc.henghuirong.server.common.model.auth.Role;
import com.hc.henghuirong.server.common.model.auth.SecurityUser;
import com.hc.henghuirong.server.common.model.auth.User;
import com.hc.henghuirong.server.dao.auth.RoleDao;
import com.hc.henghuirong.server.dao.auth.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * wenzhiwei
 */
@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("no user");
        }
        SecurityUser userDetails = new SecurityUser(user.getId(), username, user.getPassword(), !user.isDisabled(), true, true, true, grantedAuthorities(user.getId()), user.getSalt(), user.getEmail());
        return userDetails;
    }

    protected Collection<GrantedAuthority> grantedAuthorities(String userId) {
        List<Role> resources = roleDao.getRoles(userId);
        if (CollectionUtils.isEmpty(resources)) {
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> authorities = new HashSet<>();
        //忽略已经禁用的角色
        resources.stream().filter(role -> {
            return !role.isDisabled();
        }).forEach((resource -> {
            authorities.add(new SimpleGrantedAuthority(resource.getName()));
        }));
        return authorities;
    }

}

