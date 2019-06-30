package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.ProcessExample;


import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 21:25
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    @Override
    public Vo<Process> findProcess(int page, int rows) {
        List<Process> processes = processMapper.selectByExample(new ProcessExample());

        Vo<Process> processVo = new Vo<>();
        processVo.setRows(processes);
        processVo.setTotal(processes.size());
        return processVo;
    }


    @Override
    public Vo<Process> SerchProcessId(int page, int rows, String searchValue) {
        //创建一个多条件查询实例
       ProcessExample processExample = new ProcessExample();
        //创建条件（准则）
        ProcessExample.Criteria criteria = processExample.createCriteria();
        //在准则中添加条件，模糊查询必须加%
        criteria.andProcessIdLike("%" + searchValue + "%");

        List<Process> processes = processMapper.selectByExample(processExample);

        Vo<Process> processVo = new Vo<>();
        //上面传的是一个list
        processVo.setRows(processes);
        //process.size传的是数量
        processVo.setTotal(processes.size());

        return processVo;
    }




    @Override
    public long countByExample(ProcessExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ProcessExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String processId) {
        return processMapper.deleteByPrimaryKey(processId);
    }

    @Override
    public int insert(Process record) {
        return processMapper.insert(record);
    }

    @Override
    public int insertSelective(Process record) {
        return 0;
    }

    @Override
    public List<Process> selectByExample(ProcessExample example) {
        return processMapper.selectByExample(example);
    }

    @Override
    public Process selectByPrimaryKey(String processId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Process record, ProcessExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Process record, ProcessExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Process record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Process record) {
        return processMapper.updateByPrimaryKey(record);
    }
}
