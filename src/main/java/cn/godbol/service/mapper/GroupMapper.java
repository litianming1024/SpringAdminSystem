package cn.godbol.service.mapper;

import cn.godbol.domain.Group;
import cn.godbol.service.dto.GroupDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Created by li on 17-3-1.
 */
@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDTO groupToGroupDTO(Group group);

    Collection<GroupDTO> groupsToGroupDTOs(Collection<Group> groups);
}
