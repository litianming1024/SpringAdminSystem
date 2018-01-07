package cn.godbol.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
@Getter
@Setter
public class QueryParam implements Serializable {
    private int pageSize = 20;
    private int page = 1;

    public PageRequest toPageRequest(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pageRequest = new PageRequest(page - 1, pageSize, sort);
        return pageRequest;
    }
}
