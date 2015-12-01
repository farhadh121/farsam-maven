package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/22/14
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class RoleNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public RoleNotExistsException()
    {
        super();
    }

    public RoleNotExistsException(String message){
        super(message);
    }

    public RoleNotExistsException(Throwable cause){
        super(cause);
    }

    public RoleNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public RoleNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public RoleNotExistsException(Object value){
        this.value = value;
    }



}
