package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/21/14
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public RoleExistsException()
    {
        super();
    }

    public RoleExistsException(String message){
        super(message);
    }

    public RoleExistsException(Throwable cause){
        super(cause);
    }

    public RoleExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public RoleExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public RoleExistsException(Object value){
        this.value = value;
    }


}
