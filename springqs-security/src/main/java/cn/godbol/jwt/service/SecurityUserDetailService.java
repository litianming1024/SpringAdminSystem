package cn.godbol.jwt.service;

import cn.godbol.domain.User;
import cn.godbol.domain.Authority;
import cn.godbol.domain.Group;
import cn.godbol.domain.JwtUser;
import cn.godbol.jwt.repository.api.UserRepositoryApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Li on 2016/10/15.
 */
@Slf4j
@Service
@Transactional
public class SecurityUserDetailService implements UserDetailsService{


    @Autowired
    private UserRepositoryApi userRepository;


    public SecurityUserDetailService() {
    }

    /**
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user != null) {
            return createJwtUser(user);
        }else {
            log.debug("用户未找到");
            throw new UsernameNotFoundException(username + "not found!");
        }
    }

    private JwtUser createJwtUser(User user) {
        return new JwtUser(user.getUsername(), user.getPassword(),
                user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), getAuthorities(user.getGroups()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Group> groups) {
        return getGrantedAuthorities(getPrivileges(groups));
    }

    private List<String> getPrivileges(Collection<Group> groups) {
        List<String> privileges = new ArrayList<>();
        List<Authority> collection = new ArrayList<>();
        for (Group group : groups) {
            collection.addAll(group.getAuthorities());
        }
        for (Authority item : collection) {
            privileges.add(item.getE_name());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

//    public SecurityUser currentUser(){
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return SecurityUserRepository.getByUsername(username);
//    }


//    @Override
//    public JpaRepository<User, Long> getRepository() {
//        return userRepository;
//    }
//
//    @Override
//    public String getEntityName() {
//        return ENTITY_NAME;
//    }

}
