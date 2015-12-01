package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/14/14
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumNotExistException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public AlbumNotExistException()
    {
        super();
    }

    public AlbumNotExistException(String message){
        super(message);
    }

    public AlbumNotExistException(Throwable cause){
        super(cause);
    }

    public AlbumNotExistException(String message, Throwable cause){
        super( message ,cause );
    }

    public AlbumNotExistException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public AlbumNotExistException(Object value){
        this.value = value;
    }



}
