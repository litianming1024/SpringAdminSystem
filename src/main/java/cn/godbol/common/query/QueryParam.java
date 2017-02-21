package cn.godbol.common.query;

import lombok.Getter;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
@Getter
public class QueryParam implements Serializable {
    private int pageSize = 25;
    private int currentPage = 1;
    Sort sort = new Sort(Sort.Direction.DESC, "id");
}
