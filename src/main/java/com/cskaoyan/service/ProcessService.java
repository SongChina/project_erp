package com.cskaoyan.service;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.ProcessExample;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 21:25
 */
public interface ProcessService {


    //工序管理
    Vo<Process> findProcess(int page, int rows);

    //工艺编号模糊查询
    Vo<Process> SerchProcessId(int page, int rows, String searchValue);



    long countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);
}
