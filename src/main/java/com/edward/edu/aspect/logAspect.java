package com.edward.edu.aspect;


import com.edward.edu.bean.EduLog;
import com.edward.edu.exception.EduException;
import com.edward.edu.mapper.EduLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class logAspect {
    @Autowired
    private EduLogMapper eduLogMapper;
//    @After("execution(* *..*.*ServiceImpl.add*(..))") //任意返回类型 任意包下面的以ServiceImpl结尾的类中 任意add开头方法 任意参数
//    public void addLog(ProceedingJoinPoint joinPoint){
//        String name = joinPoint.getSignature().getName();
//        EduLog eduLog = new EduLog();
//        eduLog.setUsername("张三");
//        eduLog.setOption(name);
//        eduLog.setRecordTime(new Date());
//        eduLogMapper.addLog(eduLog);
//    }


    @Around("execution(* *..*.*ServiceImpl.*(..))")
    public Object addlog(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();//原始方法运行前
        try {
            Object proceed = joinPoint.proceed();//调用原始代码中的方法
            EduLog eduLog = new EduLog();          //原始方法运行后
            eduLog.setUsername("edward");
            eduLog.setOption(name);
            eduLog.setRecordTime(new Date());
            eduLogMapper.addLog(eduLog);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new EduException("代码运行异常，请重试");
        }

    }

}
