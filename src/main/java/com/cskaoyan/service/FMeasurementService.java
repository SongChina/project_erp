package com.cskaoyan.service;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

public interface FMeasurementService {

    List<FinalMeasuretCheck> getFinalMeasuretCheck();
    List<FinalMeasuretCheck> searchfMeasureCheckByfMeasureCheckId(String searchValue);
    List<FinalMeasuretCheck> searchfMeasureCheckByOrderId(String searchValue);
    QueryStatus delete_batch(String[] ids);
    QueryStatus update_note(String fMeasureCheckId, String note);
    QueryStatus update_all(FinalMeasuretCheck finalMeasuretCheck);
    QueryStatus insert(FinalMeasuretCheck finalMeasuretCheck);
}
