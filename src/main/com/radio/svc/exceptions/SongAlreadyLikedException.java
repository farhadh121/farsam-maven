package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 12/13/14
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class SongAlreadyLikedException extends TaghchehException implements Serializable{

    public SongAlreadyLikedException(String message){
        super(message);
    }
}
