package com.chan.hen.core.exhandler;

import com.baomidou.mybatisplus.extension.api.R;
import com.chan.hen.base.HenResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
