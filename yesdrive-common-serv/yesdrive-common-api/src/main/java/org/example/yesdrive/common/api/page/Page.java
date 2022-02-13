package org.example.yesdrive.common.api.page;

import lombok.ToString;

import java.util.List;

@ToString
public abstract class Page<Q extends Page<Q, R>, R> {

    private int page;
    private int size;
    private List<R> rows;
    private int total;
    private int ltLimit;
    private int rtLimit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Q getQueryCondition() {
        return (Q) this;
    }

    public List<R> getRows() {
        return rows;
    }

    public void setRows(List<R> rows) {
        this.rows = rows;
    }

    public void afterSet() {
        ltLimit = (page - 1) * size;
        rtLimit = page * size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
