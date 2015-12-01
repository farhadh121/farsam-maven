package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/26/14
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecordLabelNotExistsException extends TaghchehException implements Serializable {

    private Object value;

    public Object getValue(){
        return value;
    }

    public RecordLabelNotExistsException()
    {
        super();
    }

    public RecordLabelNotExistsException(String message){
        super(message);
    }

    public RecordLabelNotExistsException(Throwable cause){
        super(cause);
    }

    public RecordLabelNotExistsException(String message, Throwable cause){
        super( message ,cause );
    }

    public RecordLabelNotExistsException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public RecordLabelNotExistsException(Object value){
        this.value = value;
    }


}
