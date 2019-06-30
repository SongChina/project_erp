package com.cskaoyan.service;


import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.UnqualifyApply;

import java.util.List;

public interface UnqualifyService {

    List<UnqualifyApply> getUnqualifyApply();

    List<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue);
    List<UnqualifyApply> searchUnqualifyByPAgeByProductName(String searchValue);

    QueryStatus delete_batch(String[] ids);

    QueryStatus update_note(String unqualifyApplyId, String note);

    QueryStatus update_all(UnqualifyApply unqualifyApply);

    QueryStatus insert(UnqualifyApply unqualifyApply);
}
