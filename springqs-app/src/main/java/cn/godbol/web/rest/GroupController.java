package cn.godbol.web.rest;

import cn.godbol.domain.Group;
import cn.godbol.dto.GroupDTO;
import cn.godbol.mapper.GroupMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.impl.GroupServiceImpl;
import cn.godbol.web.rest.impl.DefaultCrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-01-14 下午5:57.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/group")
public class GroupController implements DefaultCrudController<Group, Long, QueryParam, GroupDTO>{

    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    GroupMapper groupMapper;
    @Override
    public CrudService<Group, Long> getService() {
        return groupService;
    }

    @Override
    public Group DTOToEntity(GroupDTO groupDTO) {
        return groupMapper.groupDTOToGroup(groupDTO);
    }

    @Override
    public GroupDTO entityToDTO(Group group) {
        return groupMapper.groupToGroupDTO(group);
    }
}
