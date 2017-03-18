package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/26/14
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecordLabelExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public RecordLabelExistsException()
    {
        super();
    }

    public RecordLabelExistsException(String message){
        super(message);
    }

    public RecordLabelExistsException(Throwable cause){
        super(cause);
    }

    public RecordLabelExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public RecordLabelExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public RecordLabelExistsException(Object value){
        this.value = value;
    }

}

