package cn.godbol.web.rest;

import cn.godbol.domain.Apply;
import cn.godbol.domain.dto.ApplyDTO;
import cn.godbol.domain.mapper.ApplyMapper;
import cn.godbol.message.ResponseMessage;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.ApplyService;
import cn.godbol.service.api.CrudService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:32.
 */
@RestController
@RequestMapping(value = "/api/apply")
public class ApplyController implements DefaultCrudController<Apply, Long, QueryParam, ApplyDTO> {

    @Autowired
    ApplyService applyService;

    @Autowired
    ApplyMapper applyMapper;

    @Override
    public CrudService<Apply, Long> getService() {
        return applyService;
    }

    @Override
    public Apply DTOToEntity(ApplyDTO applyDTO) {
        return applyMapper.applyDTOToApply(applyDTO);
    }

    @Override
    public ApplyDTO entityToDTO(Apply apply) {
        return applyMapper.applyToApplyDTO(apply);
    }

    @GetMapping("/applyStatus")
    public ResponseMessage findByStatus(QueryParam queryParam, @RequestParam(name = "applyStatus[]") Collection<Integer> applyStatus) {
        return ResponseMessage.ok(applyService.findByApplyStatusIn(applyStatus, queryParam.toPageRequest()).map(this::entityToDTO));
    }
}
