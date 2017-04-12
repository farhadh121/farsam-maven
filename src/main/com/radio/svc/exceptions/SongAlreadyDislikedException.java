package com.radio.svc.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/10/15
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class SongAlreadyDislikedException extends TaghchehException implements Serializable {

    public SongAlreadyDislikedException(String message) {
        super(message);
    }
}

