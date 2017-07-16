package com.radio.svc.exceptions;

import java.io.Serializable;

public class TaghchehException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object value;
	
	   public Object getValue(){
	        return value;
	    }

	    public TaghchehException()
	    {
	        super();
	    }

	    public TaghchehException(String message){
	        super(message);
	    }

	    public TaghchehException(Throwable cause){
	        super(cause);
	    }

	    public TaghchehException(String message, Throwable cause){
	        super( message ,cause );
	    }

	    public TaghchehException(Throwable cause, Object value)
	    {
	        super( cause );
	        this.value = value;
	    }

	    public TaghchehException(Object value){
	        this.value = value;
	    }

	

}
