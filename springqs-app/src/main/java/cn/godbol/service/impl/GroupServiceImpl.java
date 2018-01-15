package cn.godbol.service.impl;

import cn.godbol.domain.Group;
import cn.godbol.repository.GroupRepository;
import cn.godbol.service.api.GroupService;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-14 下午6:04.
 */
@Service
public class GroupServiceImpl implements GroupService, DefaultCrudService<Group, Long> {
    @Autowired
    GroupRepository groupRepository;
    @Override
    public JpaRepository<Group, Long> getRepository() {
        return groupRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}
