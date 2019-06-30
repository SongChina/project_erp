package com.cskaoyan.bean;

import java.util.List;

public class DepartmentList {
    int total;
    List<Department> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Department> getRows() {
        return rows;
    }

    public void setRows(List<Department> rows) {
        this.rows = rows;
    }
}
