package cn.godbol.web.rest;

import cn.godbol.common.controller.api.DefaultFindController;
import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.DefaultFindService;
import cn.godbol.domain.User;
import cn.godbol.repository.UserRepository;
import cn.godbol.service.MyUserService;
import cn.godbol.service.dto.UserDTO;
import cn.godbol.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by li on 17-2-20.
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class Usercontroller{

    private UserMapper userMapper;

    private UserRepository userRepository;

    @Inject
    private MyUserService myUserService;

//    @Override
//    public MyUserService getService() {
//        return this.myUserService;
//    }

    @GetMapping
    public Page<UserDTO> findAll(QueryParam param) {
        return myUserService.findAll(param.toPageRequest());
    }

}