package com.chan.hen.core.exhandler;

import com.baomidou.mybatisplus.extension.api.R;
import com.chan.hen.base.HenResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description 全局异常处理
 * @Author chanyu
 * @Date 2020/6/16 21:04
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionAdvice {
    public static Logger logger= LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler
    public R exceptionHandler(Exception e){
        logger.error("",e);
        // 发生异常，根据异常处理响应
        return HenResult.failed("失败"+e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler
    public R exceptionHandler(ArithmeticException e){
        logger.error("",e);
        // 发生异常，根据异常处理响应
        return HenResult.failed("失败"+e.getMessage());
    }
    /**
     * 参数校验失败异常处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler
    public R exceptionHandler( ConstraintViolationException e ){
        String message="";
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        if (iterator.hasNext()) {
            ConstraintViolation<?> next = iterator.next();
            message = next.getMessage();
        }
        return HenResult.failed(message);
    }

}
