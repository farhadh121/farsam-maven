package com.radio.svc.exceptions;

import java.io.Serializable;

public class SongExistException extends TaghchehException implements Serializable {
	
	private Object value;
	
	   public Object getValue(){
	        return value;
	    }

	    public SongExistException()
	    {
	        super();
	    }

	    public SongExistException(String message){
	        super(message);
	    }

	    public SongExistException(Throwable cause){
	        super(cause);
	    }

	    public SongExistException(String message, Throwable cause){
	        super( message ,cause );
	    }

	    public SongExistException(Throwable cause, Object value)
	    {
	        super( cause );
	        this.value = value;
	    }

	    public SongExistException(Object value){
	        this.value = value;
	    }

	

}
