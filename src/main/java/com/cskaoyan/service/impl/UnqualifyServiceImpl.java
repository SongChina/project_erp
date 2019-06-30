package com.cskaoyan.service.impl;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.cskaoyan.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public List<UnqualifyApply> getUnqualifyApply() {
        return unqualifyApplyMapper.selectUnqualifyApply();
    }

    @Override
    public List<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue) {
        return unqualifyApplyMapper.searchUnqualifyByUnqualifyId(searchValue);
    }

    @Override
    public List<UnqualifyApply> searchUnqualifyByPAgeByProductName(String searchValue) {
        return unqualifyApplyMapper.searchUnqualifyByPAgeByProductName(searchValue);
    }

    @Override
    public QueryStatus delete_batch(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            for (int i = 0; i < ids.length; i++) {
                unqualifyApplyMapper.deleteByPrimaryKey(ids[i]);
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
    public QueryStatus update_note(String unqualifyApplyId, String note) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyApplyMapper.update_note(unqualifyApplyId , note);
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
    public QueryStatus update_all(UnqualifyApply unqualifyApply) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyApplyMapper.update_all(unqualifyApply);
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
    public QueryStatus insert(UnqualifyApply unqualifyApply) {
        QueryStatus queryStatus = new QueryStatus();

        try {
            int i = unqualifyApplyMapper.insert(unqualifyApply);
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
