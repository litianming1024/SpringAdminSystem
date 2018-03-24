package cn.godbol.web.rest;

import cn.godbol.domain.BasicInfo;

import cn.godbol.domain.dto.BasicInfoDTO;
import cn.godbol.domain.mapper.BasicInfoMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.BasicInfoService;
import cn.godbol.service.api.CrudService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-03-07 下午3:00.
 */
@RestController
@RequestMapping(value = "/api/basicInfo")
public class BasicInfoController implements DefaultCrudController<BasicInfo, Long, QueryParam, BasicInfoDTO> {

    @Autowired
    BasicInfoService basicInfoService;

    @Autowired
    BasicInfoMapper basicInfoMapper;

    @Override
    public CrudService<BasicInfo, Long> getService() {
        return basicInfoService;
    }

    @Override
    public BasicInfo DTOToEntity(BasicInfoDTO basicInfoDTO) {
        return basicInfoMapper.basicInfoDTOToBasicInfo(basicInfoDTO);
    }

    @Override
    public BasicInfoDTO entityToDTO(BasicInfo entity) {
        return basicInfoMapper.basicInfoToBasicInfoDTO(entity);
    }

//    @PostMapping(path = "/resume/{id}")
//    public ResponseMessage createByResumeId(@PathVariable Long id, BasicInfoDTO basicInfoDTO){
//        return ResponseMessage.ok(basicInfoMapper.basicInfoToBasicInfoDTO(basicInfoService.createByResumeId(id, basicInfoMapper.basicInfoDTOToBasicInfo(basicInfoDTO))));
//    }
}
