package cn.godbol.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Li on 2016/10/23.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index(HttpServletRequest request){
        return;
    }
}
