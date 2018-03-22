package cn.godbol.web.query;

import cn.godbol.query.QueryParam;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

/**
 * Created by li on 2018-03-22 下午3:17.
 */
@Getter@Setter
public class ApplyQueryParam extends QueryParam {
    private int[] applyStatus;
}
