package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created by saman on 8/27/14.
 */
public class EntityNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public EntityNotExistsException()
    {
        super();
    }

    public EntityNotExistsException(String message){
        super(message);
    }

    public EntityNotExistsException(Throwable cause){
        super(cause);
    }

    public EntityNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public EntityNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public EntityNotExistsException(Object value){
        this.value = value;
    }


}
