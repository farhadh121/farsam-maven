package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created by saman on 8/22/14.
 */
public class StationNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public StationNotExistsException()
    {
        super();
    }

    public StationNotExistsException(String message){
        super(message);
    }

    public StationNotExistsException(Throwable cause){
        super(cause);
    }

    public StationNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public StationNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public StationNotExistsException(Object value){
        this.value = value;
    }


}
