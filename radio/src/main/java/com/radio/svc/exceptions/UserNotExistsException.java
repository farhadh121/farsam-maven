package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 7/12/14
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public UserNotExistsException()
    {
        super();
    }

    public UserNotExistsException(String message){
        super(message);
    }

    public UserNotExistsException(Throwable cause){
        super(cause);
    }

    public UserNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public UserNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public UserNotExistsException(Object value){
        this.value = value;
    }


}
