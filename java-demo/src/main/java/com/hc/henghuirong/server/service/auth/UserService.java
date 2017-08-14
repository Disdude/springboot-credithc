
package com.hc.henghuirong.server.service.auth;


import com.hc.henghuirong.server.common.model.auth.SelectRole;
import com.hc.henghuirong.server.common.model.auth.User;
import com.hc.henghuirong.server.dao.auth.RoleDao;
import com.hc.henghuirong.server.dao.auth.UserDao;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


/**
 * @author wenzhiwei
 *
 *
 */
@Service
public class UserService {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected Md5PasswordEncoder md5PasswordEncoder;

    @Autowired
    protected RoleSelectService roleSelectService;

    @Autowired
    protected RoleDao roleDao;


    public User create(User user) {
        validate(user);
        Assert.hasText(user.getPassword());
        user.setDisabled(false);
        user.setCreateTime(new Date());
        user.setSalt(RandomStringUtils.randomAscii(10));
        user.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), user.getSalt()));
        userDao.add(user);
        return user;
    }


    public User modify(User user) {
        Assert.hasText(user.getId());
        User old = get(user.getId());
        if (StringUtils.isNotBlank(user.getUsername())) {
            old.setUsername(user.getUsername());
        }
        if (StringUtils.isNotBlank(user.getPassword())) {
            old.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), old.getSalt()));
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            old.setEmail(user.getEmail());
        }
        userDao.update(old);
        return user;
    }


    public void delete(String id) {
        userDao.remove(id);
    }


    public User get(String id) {
        return userDao.get(id);
    }


    public List<User> list() {
        return userDao.list();
    }


    public void switchStatus(String id, boolean disable) {
        userDao.switchStatus(id, disable);
    }


    public void grantRole(String uid, List<String> roleIds) {
        userDao.updateRoles(uid, roleIds);
    }


    private void validate(User user) {
        Assert.hasText(user.getUsername());
        if (user.isRoot()) {
            throw new IllegalArgumentException("user loginName cannot is root");
        }
    }

    public List<SelectRole> selectRoles(String uid) {
        return roleSelectService.mergeRole(roleDao.list(), roleDao.getRoles(uid));
    }

    public List<User> getUserByUname(String username) {
        return userDao.getUserByUname(username);
    }

    public List<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

}

