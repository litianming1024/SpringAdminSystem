package cn.godbol.web.rest;

import cn.godbol.domain.User;

import cn.godbol.domain.dto.UserDTO;
import cn.godbol.domain.mapper.UserMapper;
import cn.godbol.domain.repository.UserRepository;
import cn.godbol.jwt.util.JwtTokenUtil;
import cn.godbol.message.ResponseMessage;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
//import cn.godbol.mapper.UserMapper;
import cn.godbol.service.impl.UserServiceImpl;
import cn.godbol.web.rest.impl.DefaultCrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by li on 17-2-20.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class Usercontroller implements DefaultCrudController<User, Long, QueryParam, UserDTO> {

    private static final String currentURI = "/api/user/";

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Inject
    private UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public User DTOToEntity(UserDTO userDTO) {
        return userMapper.userDTOToUser(userDTO);
    }

    @Override
    public UserDTO entityToDTO(User user) {
        return userMapper.userToUserDTO(user);
    }

    @Override
    public CrudService<User, Long> getService() {
        return userService;
    }

    @RequestMapping("/info")
    public ResponseMessage getUserInfo(HttpServletRequest request) {

        final String requestHeader = request.getHeader(this.tokenHeader);
        String username = null;
        String authToken;
        if (requestHeader != null) {
//
            authToken = requestHeader;
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
                User user = userRepository.getByUsername(username);
                return ResponseMessage.ok(userMapper.userToUserDTO(user));
            } catch (IllegalArgumentException e) {
                log.error("an error occured during getting username from token", e);
            }
        } else {
            log.warn("couldn't find bearer string, will ignore the header");
        }
        log.info("checking authentication for user " + username);
        return ResponseMessage.error("wrong");
    }
}
