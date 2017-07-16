package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 7/12/14
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasswordNotMatchException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public PasswordNotMatchException()
    {
        super();
    }

    public PasswordNotMatchException(String message){
        super(message);
    }

    public PasswordNotMatchException(Throwable cause){
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause){
        super( message ,cause );
    }

    public PasswordNotMatchException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public PasswordNotMatchException(Object value){
        this.value = value;
    }


}
