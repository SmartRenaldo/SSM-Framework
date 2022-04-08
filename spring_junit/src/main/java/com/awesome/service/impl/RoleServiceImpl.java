package com.awesome.service.impl;

import com.awesome.dao.RoleDao;
import com.awesome.domain.Role;
import com.awesome.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleDao")
    private RoleDao roleDao;

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
