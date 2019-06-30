package com.cskaoyan.vo;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 16:07
 */
public class Vo<T> {
    long total ;
    List<T> rows;

    public Vo() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
