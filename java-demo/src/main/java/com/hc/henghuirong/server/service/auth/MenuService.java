package com.hc.henghuirong.server.service.auth;


import com.hc.henghuirong.server.common.model.auth.Menu;
import com.hc.henghuirong.server.common.model.auth.TreeModel;
import com.hc.henghuirong.server.common.util.SecurityUtils;
import com.hc.henghuirong.server.dao.auth.MenuDao;
import com.hc.henghuirong.server.dao.auth.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author wenzhiwei
 */
@Service
public class MenuService {

    @Autowired
    protected MenuDao menuDao;

    @Autowired
    protected RoleDao roleDao;


    public Menu create(Menu menu) {
        validate(menu);
        menuDao.add(menu);
        return menu;
    }


    public Menu modify(Menu menu) {
        validate(menu);
        menuDao.update(menu);
        return menu;
    }


    public Menu get(String code) {
        return menuDao.get(code);
    }


    public void delete(String code) {
        roleDao.removeRoleMenuByMenuId(code);
        menuDao.remove(code);
    }


    public List<Menu> list() {
        List<Menu> list = menuDao.list();
        TreeModel.sortByTree(list);
        return list;
    }


    public void switchStatus(String menu, boolean disable) {
        menuDao.switchStatus(menu, disable);
    }


    public List<Menu> getNavMenus(String uid) {
        List<Menu> list = null;
        if (SecurityUtils.isRoot()) {
            list = menuDao.list();
        } else {
            list = menuDao.getNavMenus(uid);
        }
        return (List<Menu>) TreeModel.buildTree(list);
    }

    private void validate(Menu menu) {
        Assert.hasText(menu.getId());
        Assert.hasText(menu.getLabel());
    }

}
