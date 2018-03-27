package cn.godbol.controller;

import cn.godbol.domain.User;
import cn.godbol.domain.repository.UserRepository;
import cn.godbol.dto.CodeDTO;
import cn.godbol.jwt.controller.rest.common.JwtAuthenticationRequest;
import cn.godbol.jwt.controller.rest.common.JwtAuthenticationResponse;
import cn.godbol.jwt.util.JwtTokenUtil;
import cn.godbol.message.ResponseMessage;
import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * Created by li on 2018-03-26 下午2:55.
 */
@RestController
@RequestMapping("/api/wechat/auth")
public class WechatAuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    WxMpService wxMpService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/login")
    public ResponseMessage createAuthenticationToken(@RequestBody CodeDTO codeDTO) throws AuthenticationException, WxErrorException {
        String code = codeDTO.getCode();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken= wxMpService.oauth2getAccessToken(code);
        String openId = wxMpOAuth2AccessToken.getOpenId();
        User user = userRepository.findByOpenId(openId);
        if (user == null) {
            user = new User();
            user.setUsername(openId);
            user.setPassword(openId);
            user.setOpenId(openId);
            user = userRepository.save(user);
        }
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseMessage.ok(new JwtAuthenticationResponse(token));
    }
}
