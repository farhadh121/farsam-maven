package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/27/14
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateFormatWrongException extends TaghchehException implements Serializable {

    private Object value;

	public Object getValue(){
        return value;
    }

    public DateFormatWrongException()
    {
        super();
    }

    public DateFormatWrongException(String message){
        super(message);
    }

    public DateFormatWrongException(Throwable cause){
        super(cause);
    }

    public DateFormatWrongException(String message, Throwable cause){
        super( message ,cause );
    }

    public DateFormatWrongException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public DateFormatWrongException(Object value){
        this.value = value;
    }


}
