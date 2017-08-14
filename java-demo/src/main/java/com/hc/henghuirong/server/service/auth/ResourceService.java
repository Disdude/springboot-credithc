package com.hc.henghuirong.server.service.auth;


import com.hc.henghuirong.server.common.model.auth.Resource;
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
public class ResourceService {

    @Autowired
    protected ResourceDao resourceDao;

    @Autowired
    protected RoleDao roleDao;


    public Resource create(Resource resource) {
        validate(resource);
        resource.setId(UUID.randomUUID().toString());
        resourceDao.add(resource);
        return resource;
    }


    public Resource modify(Resource resource) {
        validate(resource);
        resourceDao.update(resource);
        return resource;
    }


    public Resource get(String code) {
        return resourceDao.get(code);
    }


    public List<Resource> list() {
        return resourceDao.list();
    }


    public void delete(String code) {
        roleDao.removeRoleResourceByResourceId(code);
        resourceDao.remove(code);
    }


    public void switchStatus(String code, boolean disable) {
        resourceDao.switchStatus(code, disable);
    }

    private void validate(Resource resource) {
        Assert.hasText(resource.getTitle());
        Assert.hasText(resource.getUrl());

    }
}
