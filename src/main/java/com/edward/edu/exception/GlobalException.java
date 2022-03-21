package com.edward.edu.exception;

import com.edward.edu.vo.EduResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//全局异常处理类
@ControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public EduResult error(Exception e){
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            FieldError error = fieldErrors.get(0);
            String msg = error.getDefaultMessage();
            return EduResult.error(msg);
        }
        //logger.error(e.getMessage());
        return EduResult.error(e.getMessage());
    }

    @ExceptionHandler(value = EduException.class)
    @ResponseBody
    public EduResult customError(Exception e){ //自定义异常
        //logger.error(e.getMessage());
        return EduResult.error(e.getMessage());
    }
}
