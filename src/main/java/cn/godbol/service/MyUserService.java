package cn.godbol.service;

import cn.godbol.common.service.api.DefaultFindService;
import cn.godbol.domain.Authority;
import cn.godbol.domain.Group;
import cn.godbol.domain.User;
import cn.godbol.repository.UserRepository;
import cn.godbol.service.dto.UserDTO;
import cn.godbol.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Li on 2016/10/15.
 */
@Slf4j
@Service
@Transactional
public class MyUserService implements UserDetailsService{

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;

    public MyUserService() {
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
            return createSpringUser(user);
        }else {
            throw new UsernameNotFoundException(username + "not found!");
        }
    }

    private org.springframework.security.core.userdetails.User createSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
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

    public User currentUser(){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.getByUsername(username);
    }

//    @Override
//    public JpaRepository<User, Long> getRepository() {
//        return this.userRepository;
//    }

    public Page<UserDTO> findAll(Pageable pageable){
        return userRepository.findAll(pageable).map(userMapper::userToUserDTO);
    }
}
