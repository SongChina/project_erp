package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ProcessCountCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.ProcessCountCheckMapper;
import com.cskaoyan.service.PCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCountServiceImpl implements PCountService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public List<ProcessCountCheck> getProcessCountCheck() {
        return processCountCheckMapper.selectProcessCountCheck();
    }

    @Override
    public List<ProcessCountCheck> searchById(String searchValue) {
        return processCountCheckMapper.searchById(searchValue);
    }

    @Override
    public QueryStatus delete_batch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            for (int i = 0; i < ids.length; i++) {
                processCountCheckMapper.deleteByPrimaryKey(ids[i]);
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
    public QueryStatus updateNote(String pCountCheckId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = processCountCheckMapper.updateNote(pCountCheckId,note);
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
    public QueryStatus updateAll(ProcessCountCheck processCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = processCountCheckMapper.updateAll(processCountCheck);
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
    public QueryStatus insert(ProcessCountCheck processCountCheck) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = processCountCheckMapper.insert(processCountCheck);
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
