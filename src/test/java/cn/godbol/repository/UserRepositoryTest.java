package cn.godbol.repository;

import cn.godbol.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Li on 2016/10/15.
 */
@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createNewUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);
    }

}