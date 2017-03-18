package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/14/14
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileExistException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public FileExistException()
    {
        super();
    }

    public FileExistException(String message){
        super(message);
    }

    public FileExistException(Throwable cause){
        super(cause);
    }

    public FileExistException(String message, Throwable cause){
        super( message ,cause );
    }

    public FileExistException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public FileExistException(Object value){
        this.value = value;
    }

}
