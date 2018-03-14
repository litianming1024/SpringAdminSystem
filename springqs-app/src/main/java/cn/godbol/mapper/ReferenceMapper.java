package cn.godbol.mapper;

import cn.godbol.domain.BaseModel;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by li on 2018-03-11 下午8:27.
 */
//@Component
public class ReferenceMapper {
    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseModel> T resolve(T reference, @TargetType Class<T> entityClass) {
        return reference != null ? entityManager.find( entityClass, reference.getPrimaryKey() ) : null;
    }

//    public Reference toReference(BaseEntity entity) {
//        return entity != null ? new Reference( entity.getPk() ) : null;
//    }
}
