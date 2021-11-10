package com.project.advice;

import com.project.vo.SysResult;
import com.project.vo.exception.HasNoAuthoritiesException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler({RuntimeException.class})
    public SysResult fail(Exception e){
        return SysResult.fail(null,e.getMessage());
    }

    @ExceptionHandler({HasNoAuthoritiesException.class})
    public SysResult noAuthoritiesFail(Exception e){
        return SysResult.fail(null,"该用户没有任何权限");
    }

}
