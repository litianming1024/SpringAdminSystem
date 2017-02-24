package cn.godbol.web;

import cn.godbol.common.query.QueryParam;
import cn.godbol.service.MyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by li on 17-2-20.
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class Usercontroller {

    @Inject
    private MyUserService myUserService;

//    @Override
//    public MyUserService getService() {
//        return this.myUserService;
//    }

    @GetMapping
    public ResponseEntity findAll(QueryParam param){
        return ResponseEntity.ok(myUserService.findAll(param.toPageRequest()));
    }

}
