package cn.godbol.service.mapper;

import cn.godbol.domain.Authority;
import cn.godbol.domain.Group;
import cn.godbol.service.dto.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

/**
 * Created by li on 17-3-1.
 */
@Mapper(componentModel = "spring", uses = {AuthorityMapper.class})
public interface GroupMapper {
    GroupDTO groupToGroupDTO(Group group);

    Collection<GroupDTO> groupsToGroupDTOs(Collection<Group> groups);

    @Mapping(target = "users", ignore = true)
    Group groupDTOToGroup(GroupDTO groupDTO);

    Collection<Group> groupDTOsToGroups(Collection<GroupDTO> groupDTOs);

    default Authority authorityFromId(Long id) {
        if (id == null) {
            return null;
        }
        Authority authority = new Authority();
        authority.setId(id);
        return authority;
    }
}
