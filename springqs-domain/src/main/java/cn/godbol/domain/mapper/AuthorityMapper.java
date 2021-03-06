package cn.godbol.domain.mapper;

import cn.godbol.domain.Authority;
import cn.godbol.domain.dto.AuthorityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

/**
 * Created by li on 17-3-1.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorityMapper {
    AuthorityDTO authorityToAuthorityDTO(Authority authority);

    Collection<AuthorityDTO> authorityiesToAuthorityDTOs(Collection<Authority> authorities);

    @Mapping(target = "groups", ignore = true)
    Authority authorityDTOToAuthority(AuthorityDTO authorityDTO);

    Collection<Authority> authorityDTOsToAuthorities(Collection<AuthorityDTO> authorityDTOs);
}
