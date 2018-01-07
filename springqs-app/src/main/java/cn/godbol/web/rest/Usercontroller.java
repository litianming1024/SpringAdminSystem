package cn.godbol.web.rest;

import cn.godbol.domain.User;
import cn.godbol.dto.UserDTO;
import cn.godbol.mapper.UserMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
//import cn.godbol.mapper.UserMapper;
import cn.godbol.service.api.UserService;
import cn.godbol.service.impl.UserServiceImpl;
import cn.godbol.web.rest.impl.DefaultCrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by li on 17-2-20.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class Usercontroller implements DefaultCrudController<User, Long, QueryParam, UserDTO> {

    private static final String currentURI = "/api/user/";

    @Inject
    private UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;




    @Override
    public User DTOToEntity(UserDTO userDTO) {
        return userMapper.userDTOToUser(userDTO);
    }

    @Override
    public UserDTO entityToDTO(User user) {
        return userMapper.userToUserDTO(user);
    }

    @Override
    public String getCurrentURI() {
        return this.currentURI;
    }

    @Override
    public CrudService<User, Long> getService() {
        return userService;
    }
}
