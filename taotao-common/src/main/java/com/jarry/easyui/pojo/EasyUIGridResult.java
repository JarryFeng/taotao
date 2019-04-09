package com.jarry.easyui.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/9
 * @describe easyUI分页需要的数据格式
 */
public class EasyUIGridResult implements Serializable {

    private Long total;

    private List rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
