package com.cskaoyan.service;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

public interface FCountService {
    List<FinalCountCheck> getFinalCountCheck();
    List<FinalCountCheck> searchfCountCheckByfCountCheckId(String searchValue);
    List<FinalCountCheck> searchfCountCheckByOrderId(String searchValue);
    QueryStatus delete_batch(String[] ids);
    QueryStatus update_note(String fCountCheckId, String note);
    QueryStatus update_all(FinalCountCheck finalCountCheck);
    QueryStatus insert(FinalCountCheck finalCountCheck);
}
