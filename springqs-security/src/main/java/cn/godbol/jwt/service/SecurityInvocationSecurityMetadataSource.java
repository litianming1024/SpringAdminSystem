package cn.godbol.jwt.service;

import cn.godbol.domain.Authority;
import cn.godbol.domain.repository.AuthorityRepository;
import cn.godbol.domain.repository.api.AuthorityRepositoryApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by li on 17-6-14.
 */
@Slf4j
@Service
public class SecurityInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private AuthorityRepository authorityRepository;

    private Map<String, Collection<ConfigAttribute>> resourceMap = null;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (resourceMap == null) {
            log.debug("初始化权限");
            loadResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
        AntPathRequestMatcher matcher;
        for (String resUrl : resourceMap.keySet()) {
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return resourceMap.get(resUrl);
            }
        }
        return null;
    }

    //加载权限列表
    private void loadResourceDefine() {
        resourceMap = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<Authority> authorities = authorityRepository.findAll();
        for (Authority authority: authorities) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(authority.getE_name());
            array.add(cfg);
            resourceMap.put(authority.getUrl(), array);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
