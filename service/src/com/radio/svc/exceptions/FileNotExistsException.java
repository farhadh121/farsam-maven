package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/26/14
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public FileNotExistsException()
    {
        super();
    }

    public FileNotExistsException(String message){
        super(message);
    }

    public FileNotExistsException(Throwable cause){
        super(cause);
    }

    public FileNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public FileNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public FileNotExistsException(Object value){
        this.value = value;
    }

}
