package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 6/14/14
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class SongNotExistsException extends TaghchehException implements Serializable{

    private Object value;

    public Object getValue(){
        return value;
    }

    public SongNotExistsException()
    {
        super();
    }

    public SongNotExistsException(String message){
        super(message);
    }

    public SongNotExistsException(Throwable cause){
        super(cause);
    }

    public SongNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public SongNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public SongNotExistsException(Object value){
        this.value = value;
    }



}
