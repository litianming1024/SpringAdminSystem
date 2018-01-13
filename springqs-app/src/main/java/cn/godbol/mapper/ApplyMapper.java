package cn.godbol.mapper;

import cn.godbol.domain.Apply;
import cn.godbol.dto.ApplyDTO;
import org.mapstruct.Mapper;
import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午9:53.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ApplyMapper {
    ApplyDTO applyToApplyDTO(Apply apply);
    Collection<ApplyDTO> appliesToapplyDTOs(Collection<Apply> applies);

    Apply applyDTOToApply(ApplyDTO applyDTO);

}
