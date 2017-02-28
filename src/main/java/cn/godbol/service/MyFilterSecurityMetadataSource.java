package cn.godbol.service;

import cn.godbol.domain.model.Authority;
import cn.godbol.repository.AuthorityRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by Li on 2016/11/18.
 */

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Inject
    private AuthorityRepository authorityRepository;

    private HashMap<String, Collection<ConfigAttribute>> requestMap;

    public MyFilterSecurityMetadataSource() {
        loadUrlDefine();
    }

    private void loadUrlDefine() {
        requestMap = new HashMap<>();
        List<Authority> authorities = authorityRepository.findAll();
        if (authorities != null){
            for (Authority authority : authorities) {
                Collection<ConfigAttribute> value = new ArrayList<>();
                value.add(new SecurityConfig(authority.getE_name()));
                requestMap.put(authority.getUrl(), value);
            }
        }

    }

    /**
     * Accesses the {@code ConfigAttribute}s that apply to a given secure object.
     *
     * @param object the object being secured
     * @return the attributes that apply to the passed in secured object. Should return an
     * empty collection if there are no applicable attributes.
     * @throws IllegalArgumentException if the passed object is not of a type supported by
     *                                  the <code>SecurityMetadataSource</code> implementation
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        loadUrlDefine();
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        String httpMethod = fi.getRequest().getMethod();

        int firstQuestionMarkIndex = url.indexOf(".");
        //判断请求是否带有参数 如果有参数就去掉后面的后缀和参数(/index.do  --> /index)
        if(firstQuestionMarkIndex != -1){
            url = url.substring(0,firstQuestionMarkIndex);
        }
        firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        for (String resUrl : requestMap.keySet()){
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resUrl);
            if(requestMatcher.matches(fi.getHttpRequest()))
            {
                return requestMap.get(resUrl);
            }
        }
        return null;
    }

    /**
     * If available, returns all of the {@code ConfigAttribute}s defined by the
     * implementing class.
     * <p>
     * This is used by the {@link AbstractSecurityInterceptor} to perform startup time
     * validation of each {@code ConfigAttribute} configured against it.
     *
     * @return the {@code ConfigAttribute}s or {@code null} if unsupported
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * Indicates whether the {@code SecurityMetadataSource} implementation is able to
     * provide {@code ConfigAttribute}s for the indicated secure object type.
     *
     * @param clazz the class that is being queried
     * @return true if the implementation can process the indicated class
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
