package cn.godbol.service.impl;


import cn.godbol.domain.repository.UserRepository;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by li on 2017-12-15 下午2:19.
 */
@Service
public class UserServiceImpl<User, ID extends Serializable> implements DefaultCrudService<User, ID> {

    @Autowired
    UserRepository userRepository;
    @Override
    public JpaRepository getRepository() {
        return userRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}
