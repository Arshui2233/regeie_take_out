package com.gjl.regeie.common;


import org.apache.commons.lang.StringUtils;

/**
 *自定义业务异常
 */

public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }

}
