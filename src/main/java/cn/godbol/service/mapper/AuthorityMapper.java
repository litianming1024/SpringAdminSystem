package cn.godbol.service.mapper;

import cn.godbol.domain.Authority;
import cn.godbol.service.dto.AuthorityDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Created by li on 17-3-1.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorityMapper {
    AuthorityDTO authorityToAuthorityDTO(Authority authority);

    Collection<AuthorityDTO> authorityiesToAuthorityDTOs(Collection<Authority> authorities);
}
