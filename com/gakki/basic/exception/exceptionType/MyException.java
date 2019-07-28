package com.gakki.basic.exception.exceptionType;

/**
 * 自定义异常，继承了RuntimeException
 * @author wangxb (O_o)??)
 * @date 2019-07-25
 */
public class MyException extends RuntimeException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
