package com.cskaoyan.service;


import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

public interface PMeasurementService {

    List<ProcessMeasureCheck> getProcessMeasureCheck();
    List<ProcessMeasureCheck> searchById(String searchValue);
    QueryStatus delete_batch(String[] ids);
    QueryStatus updateNote(String pMeasureCheckId, String note);
    QueryStatus updateAll(ProcessMeasureCheck processMeasureCheck);
    QueryStatus insert(ProcessMeasureCheck processMeasureCheck);
}
