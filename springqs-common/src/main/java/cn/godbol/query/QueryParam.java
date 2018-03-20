package cn.godbol.query;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by li on 17-2-21.
 */
@Getter
@Setter
@Slf4j
public class QueryParam implements Serializable {
    private int pageSize = 20;
    private int page = 1;
//    private List<Filter> filters;

    public PageRequest toPageRequest(){
//        log.debug(filters.toString());
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pageRequest = new PageRequest(page - 1, pageSize, sort);
        return pageRequest;
    }
}
