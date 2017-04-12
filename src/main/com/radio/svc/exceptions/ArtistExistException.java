package com.radio.svc.exceptions;

import java.io.Serializable;

public class ArtistExistException extends TaghchehException implements Serializable {
	
	private Object value;
	
	public Object getValue(){
        return value;
    }

    public ArtistExistException()
    {
        super();
    }

    public ArtistExistException(String message){
        super(message);
    }

    public ArtistExistException(Throwable cause){
        super(cause);
    }

    public ArtistExistException(String message, Throwable cause){
        super( message ,cause );
    }

    public ArtistExistException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public ArtistExistException(Object value){
        this.value = value;
    }


}
