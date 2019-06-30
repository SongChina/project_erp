package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.FinalCountCheckMapper;
import com.cskaoyan.service.FCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FCountServiceImpl implements FCountService {

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Override
    public List<FinalCountCheck> getFinalCountCheck() {
        return finalCountCheckMapper.selectFinalCountCheck();
    }

    @Override
    public List<FinalCountCheck> searchfCountCheckByfCountCheckId(String searchValue) {
        return finalCountCheckMapper.searchfCountCheckByfCountCheckId(searchValue);
    }

    @Override
    public List<FinalCountCheck> searchfCountCheckByOrderId(String searchValue) {
        return finalCountCheckMapper.searchfCountCheckByOrderId(searchValue);
    }

    @Override
    public QueryStatus delete_batch(String[] ids) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            for(int i=0;i<ids.length;i++) {
                finalCountCheckMapper.deleteByPrimaryKey(ids[i]);
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
    public QueryStatus update_note(String fCountCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = finalCountCheckMapper.update_note(fCountCheckId , note);
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
    public QueryStatus update_all(FinalCountCheck finalCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = finalCountCheckMapper.update_all(finalCountCheck);
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
    public QueryStatus insert(FinalCountCheck finalCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = finalCountCheckMapper.insert(finalCountCheck);
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
