package cn.godbol.service.impl;

import cn.godbol.jwt.domain.User;
import cn.godbol.jwt.repository.UserRepository;
import cn.godbol.service.api.UserService;

import javax.inject.Inject;

/**
 * Created by li on 2017-12-15 下午2:19.
 */
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
