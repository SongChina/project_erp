package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.service.FMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FMeasurementServiceImpl implements FMeasurementService {

    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Override
    public List<FinalMeasuretCheck> getFinalMeasuretCheck() {
        return finalMeasuretCheckMapper.selectFinalMeasuretCheck();
    }

    @Override
    public List<FinalMeasuretCheck> searchfMeasureCheckByfMeasureCheckId(String searchValue) {
        return finalMeasuretCheckMapper.searchfMeasureCheckByfMeasureCheckId(searchValue);
    }

    @Override
    public List<FinalMeasuretCheck> searchfMeasureCheckByOrderId(String searchValue) {
        return finalMeasuretCheckMapper.searchfMeasureCheckByOrderId(searchValue);
    }

    @Override
    public QueryStatus delete_batch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            for (int i = 0; i < ids.length; i++) {
                finalMeasuretCheckMapper.deleteByPrimaryKey(ids[i]);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus update_note(String fMeasureCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int i = finalMeasuretCheckMapper.update_note(fMeasureCheckId , note);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("修改失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("修改失败");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus update_all(FinalMeasuretCheck finalMeasuretCheck) {
        QueryStatus queryStatus=new QueryStatus();
        try {
            int i=finalMeasuretCheckMapper.update_all(finalMeasuretCheck);
            if(i==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("修改失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("修改失败");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus insert(FinalMeasuretCheck finalMeasuretCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("插入失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("不合格品申请编号重复，请重新申请");
        }
        return queryStatus;
    }
}
