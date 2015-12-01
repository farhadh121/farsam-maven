package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/4/14
 * Time: 12:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class SongsListNotEmptyException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public SongsListNotEmptyException()
    {
        super();
    }

    public SongsListNotEmptyException(String message){
        super(message);
    }

    public SongsListNotEmptyException(Throwable cause){
        super(cause);
    }

    public SongsListNotEmptyException(String message, Throwable cause){
        super( message ,cause );
    }

    public SongsListNotEmptyException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public SongsListNotEmptyException(Object value){
        this.value = value;
    }


}
