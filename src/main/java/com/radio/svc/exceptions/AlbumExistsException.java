package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/27/14
 * Time: 1:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public AlbumExistsException()
    {
        super();
    }

    public AlbumExistsException(String message){
        super(message);
    }

    public AlbumExistsException(Throwable cause){
        super(cause);
    }

    public AlbumExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public AlbumExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public AlbumExistsException(Object value){
        this.value = value;
    }


}
