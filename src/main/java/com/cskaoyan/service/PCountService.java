package com.cskaoyan.service;

import com.cskaoyan.bean.ProcessCountCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

public interface PCountService {
    List<ProcessCountCheck> getProcessCountCheck();
    List<ProcessCountCheck> searchById(String searchValue);
    QueryStatus delete_batch(String[] ids);
    QueryStatus updateNote(String pCountCheckId, String note);
    QueryStatus updateAll(ProcessCountCheck processCountCheck);
    QueryStatus insert(ProcessCountCheck processCountCheck);
}
