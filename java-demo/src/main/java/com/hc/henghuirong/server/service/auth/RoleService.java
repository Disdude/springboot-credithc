package com.hc.henghuirong.server.service.auth;


import com.hc.henghuirong.server.common.model.auth.Role;
import com.hc.henghuirong.server.common.model.auth.SelectMenu;
import com.hc.henghuirong.server.common.model.auth.SelectResource;
import com.hc.henghuirong.server.dao.auth.MenuDao;
import com.hc.henghuirong.server.dao.auth.ResourceDao;
import com.hc.henghuirong.server.dao.auth.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;


/**
 * @author wenzhiwei
 */
@Service
public class RoleService {

    @Autowired
    protected RoleDao roleDao;

    @Autowired
    protected ResourceDao resourceDao;

    @Autowired
    protected ResourceSelectService resourceSelectService;

    @Autowired
    protected MenuDao menuDao;


    public Role create(Role role) {
        Assert.hasText(role.getName(), "Role name is empty");
        role.setId(UUID.randomUUID().toString());
        roleDao.add(role);
        return role;
    }


    public Role modify(Role newRole) {
        Assert.hasText(newRole.getId(), "Role id is empty");
        Assert.hasText(newRole.getName(), "Role name is empty");
        roleDao.update(newRole);
        return newRole;
    }


    public Role get(String id) {
        return roleDao.get(id);
    }


    public List<Role> list() {
        return roleDao.list();
    }


    public void delete(String id) {
        roleDao.remove(id);
    }


    public void switchStatus(String id, boolean disable) {
        roleDao.switchStatus(id, disable);
    }

    public void grantResource(String roleId, List<String> resources) {
        roleDao.updateResources(roleId, resources);
    }


    public void grantMenu(String roleId, List<String> menus) {
        roleDao.updateMenus(roleId, menus);
    }


    public List<SelectResource> selectResources(String roleId) {
        return resourceSelectService.mergeResource(resourceDao.list(), resourceDao.listByRole(roleId));
    }

    public List<SelectMenu> selectMenus(String roleId) {
        return resourceSelectService.mergeMenus(menuDao.list(), menuDao.roleMenus(roleId));
    }
}
