package com.project.advice;

import com.project.vo.SysResult;
import com.project.vo.exception.HasNoAuthoritiesException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {
    @ExceptionHandler({RuntimeException.class})
    public SysResult fail(Exception e) {
        log.debug(e.toString());
        log.debug(e.getMessage());
        log.debug(String.valueOf(e.getCause()));
        log.debug(String.valueOf(e.getStackTrace()));
        e.printStackTrace();
        return SysResult.fail(null, e.getMessage());
    }

    @ExceptionHandler({HasNoAuthoritiesException.class})
    public SysResult noAuthoritiesFail(Exception e) {
        return SysResult.fail(null, "该用户没有任何权限");
    }

}
