package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created by mbani002 on 5/16/14.
 */
public class GenreExistException extends TaghchehException implements Serializable {
    private Object value;

    public Object getValue(){
        return value;
    }

    public GenreExistException()
    {
        super();
    }

    public GenreExistException(String message){
        super(message);
    }

    public GenreExistException(Throwable cause){
        super(cause);
    }

    public GenreExistException(String message, Throwable cause){
        super( message ,cause );
    }

    public GenreExistException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public GenreExistException(Object value){
        this.value = value;
    }


}
