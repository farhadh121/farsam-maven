package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/22/14
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmailNotValidException extends TaghchehException implements Serializable{

    private Object value;

    public Object getValue(){
        return value;
    }

    public EmailNotValidException()
    {
        super();
    }

    public EmailNotValidException(String message){
        super(message);
    }

    public EmailNotValidException(Throwable cause){
        super(cause);
    }

    public EmailNotValidException(String message, Throwable cause){
        super( message ,cause );
    }

    public EmailNotValidException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public EmailNotValidException(Object value){
        this.value = value;
    }


}
