package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysResult {
    Integer status;
    Object data;
    String msg;
    public static SysResult success(Object data){
        return new SysResult(200,data,null);
    }
    public static SysResult success( ){
        return new SysResult(200,null,null);
    }
    public static SysResult fail(Object data,String msg){
        return new SysResult(201,data,msg);
    }
    public static SysResult fail( String msg){
        return new SysResult(201,msg,null);
    }
    public static SysResult fail(  ){
        return new SysResult(201,null,null);
    }

}
