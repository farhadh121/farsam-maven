package com.radio.svc.exceptions;

import java.io.Serializable;

public class ArtistNotExistException extends TaghchehException implements Serializable {
	
    private Object value;
	
	public Object getValue(){
        return value;
    }

    public ArtistNotExistException()
    {
        super();
    }

    public ArtistNotExistException(String message){
        super(message);
    }

    public ArtistNotExistException(Throwable cause){
        super(cause);
    }

    public ArtistNotExistException(String message, Throwable cause){
        super( message ,cause );
    }

    public ArtistNotExistException(Throwable cause, Object value)
    {
        super( cause );
        this.value = value;
    }

    public ArtistNotExistException(Object value){
        this.value = value;
    }


}


