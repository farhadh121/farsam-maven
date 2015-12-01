package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/20/14
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenreNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public GenreNotExistsException()
    {
        super();
    }

    public GenreNotExistsException(String message){
        super(message);
    }

    public GenreNotExistsException(Throwable cause){
        super(cause);
    }

    public GenreNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public GenreNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public GenreNotExistsException(Object value){
        this.value = value;
    }

}
