package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/22/14
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public UserExistsException()
    {
        super();
    }

    public UserExistsException(String message){
        super(message);
    }

    public UserExistsException(Throwable cause){
        super(cause);
    }

    public UserExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public UserExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public UserExistsException(Object value){
        this.value = value;
    }


}
