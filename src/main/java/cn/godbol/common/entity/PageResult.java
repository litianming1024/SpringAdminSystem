package cn.godbol.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by li on 17-2-20.
 */
@Getter
@Setter
public class PageResult<E> implements Serializable {

    private long total;

    private List<E> data;
}
