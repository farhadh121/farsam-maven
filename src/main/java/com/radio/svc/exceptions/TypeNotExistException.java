package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created by saman on 8/27/14.
 */
public class TypeNotExistException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public TypeNotExistException()
    {
        super();
    }

    public TypeNotExistException(String message){
        super(message);
    }

    public TypeNotExistException(Throwable cause){
        super(cause);
    }

    public TypeNotExistException(String message, Throwable cause){
        super( message ,cause );
    }

    public TypeNotExistException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public TypeNotExistException(Object value){
        this.value = value;
    }


}