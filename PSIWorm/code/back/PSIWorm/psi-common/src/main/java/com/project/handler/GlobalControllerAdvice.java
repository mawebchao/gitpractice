package com.project.handler;

import com.project.vo.SysResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler({RuntimeException.class})
    public SysResult fail(Exception e){
        return SysResult.fail(null,e.getMessage());
    }
}
