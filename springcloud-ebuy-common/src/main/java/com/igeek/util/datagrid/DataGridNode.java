package com.igeek.util.datagrid;

import java.io.Serializable;
import java.util.List;

/**
 * EasyUI DataGrid数据实体
 * @param <T>
 */
public class DataGridNode<T> implements Serializable {
    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public DataGridNode(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public DataGridNode() {
    }
}
