package com.edward.edu.exception;

import com.edward.edu.vo.EduResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//全局异常处理类
@ControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public EduResult error(Exception e){
        logger.error(e.getMessage());
        return EduResult.error(e.getMessage());
    }

    @ExceptionHandler(value = EduException.class)
    @ResponseBody
    public EduResult customError(Exception e){
        logger.error(e.getMessage());
        return EduResult.error(e.getMessage());
    }
}
