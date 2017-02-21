package cn.godbol.web;

import cn.godbol.common.controller.api.QueryController;
import cn.godbol.domain.model.User;
import cn.godbol.service.MyUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by li on 17-2-20.
 */
@RestController
@RequestMapping(value = "/user")
public class Usercontroller implements QueryController<User>{

    @Inject
    private MyUserService myUserService;

    @Override
    public MyUserService getService() {
        return this.myUserService;
    }
}
