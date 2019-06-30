package com.cskaoyan.bean;

import java.util.List;

public class EmployeeList {
    int total;
    List<Employee_p> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Employee_p> getRows() {
        return rows;
    }

    public void setRows(List<Employee_p> rows) {
        this.rows = rows;
    }
}
