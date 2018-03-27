package cn.godbol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by li on 2018-03-26 下午7:31.
 */
@Controller
public class WechatFrontController {
    @GetMapping("/wechat/front")
    public String wechatFront() {
        return "/wechatfront/index.html";
    }
}
