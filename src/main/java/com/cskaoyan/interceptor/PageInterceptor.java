package com.cskaoyan.interceptor;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.vo.COrderResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*@Aspect
@Component*/
public class PageInterceptor {
/*    @ResponseBody
    @Around("execution(* com.cskaoyan.controller..*.*Paging(..))")*/
    public Object process(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if (args.length < 2) {
            //规定原方法的参数最后两个是当前页和每页条数
            throw new Exception("参数不够分页");
        }
        PageHelper.startPage((Integer) args[args.length - 2], (Integer) args[args.length - 1]);
        List list = (List) point.proceed();
        COrderResponseVo<COrder> pageInfo = new COrderResponseVo<>();
        pageInfo.setTotal(50);
        pageInfo.setRows(list);
        return pageInfo;
    }
}

