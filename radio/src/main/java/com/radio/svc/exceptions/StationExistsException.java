package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created by saman on 10/20/14.
 */
public class StationExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public StationExistsException()
    {
        super();
    }

    public StationExistsException(String message){
        super(message);
    }

    public StationExistsException(Throwable cause){
        super(cause);
    }

    public StationExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public StationExistsException(Throwable cause, Object value){
        super( cause );
        this.value = value;
    }

    public StationExistsException(Object value){
        this.value = value;
    }


}
