package cn.godbol.service;

import cn.godbol.domain.model.menu.AuthorityMenu;
import cn.godbol.domain.repository.AuthorityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li on 2016/11/19.
 */
@Service
@Transactional
@Slf4j
public class AuthorityMenuLoaderService {

    private List<AuthorityMenu> authorityMenus;

    @Inject
    private AuthorityRepository authorityRepository;

    public AuthorityMenuLoaderService() {
        authorityMenus = new ArrayList<>();
//        loadAuthorityMenu();
    }

//    private void loadAuthorityMenu(){
//        List<Authority> authorities = authorityRepository.findAll();
//        for (Authority authority: authorities){
//            authority
//        }
//
//    }
//
//    public List<AuthorityMenu> loadAuthorityMenu(User user){
//        Collection<Group> groups = user.getGroups();
//        Collection<Authority> authorities = null;
//        for (Group group : groups){
//            authorities.addAll(group.getAuthorities());
//        }
//        authorities = authorities.stream().distinct().collect(Collectors.toList());
//    }

}
