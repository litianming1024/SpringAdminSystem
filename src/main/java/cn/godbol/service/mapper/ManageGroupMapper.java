package cn.godbol.service.mapper;

import cn.godbol.domain.Group;
import cn.godbol.web.rest.vm.ManageGroupVM;
import org.mapstruct.Mapper;

/**
 * Created by li on 17-3-7.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ManageGroupMapper {
    ManageGroupVM groupToManageGroupVM(Group group);
}
