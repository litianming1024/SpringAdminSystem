package cn.godbol.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by li on 17-2-20.
 */
@Getter
@Setter
public class PageResult<T> implements Serializable {

    private long total;

    private List<T> data;

    public PageResult(Page<T> page) {
        this.total = page.getTotalElements();
        this.data = page.getContent();
    }
}
