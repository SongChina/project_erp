package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.ProcessMeasureCheckMapper;
import com.cskaoyan.service.PMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PMeasurementServiceImpl implements PMeasurementService {

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;
    @Override
    public List<ProcessMeasureCheck> getProcessMeasureCheck() {
        return processMeasureCheckMapper.selectProcessMeasureCheck();
    }

    @Override
    public List<ProcessMeasureCheck> searchById(String searchValue) {
        return processMeasureCheckMapper.searchById(searchValue);
    }

    @Override
    public QueryStatus delete_batch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            for (int i = 0; i < ids.length; i++) {
                processMeasureCheckMapper.deleteByPrimaryKey(ids[i]);
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
    public QueryStatus updateNote(String pMeasureCheckId, String note) {
        QueryStatus queryStatus=new QueryStatus();
        try {
            int i = processMeasureCheckMapper.updateNote(pMeasureCheckId,note);
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
    public QueryStatus updateAll(ProcessMeasureCheck processMeasureCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = processMeasureCheckMapper.updateAll(processMeasureCheck);
            if (i == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            } else {
                queryStatus.setStatus(404);
                queryStatus.setMsg("修改失败");
            }
        }catch (Exception e){
            queryStatus.setStatus(404);
            queryStatus.setMsg("不合格品申请编号重复，请重新申请");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus insert(ProcessMeasureCheck processMeasureCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = processMeasureCheckMapper.insert(processMeasureCheck);
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
