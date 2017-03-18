package com.radio.svc.songengine;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by farhad on 8/22/14.
 */
public interface ISongSelector extends Serializable {

    /**
     * Returns the next song based on the passed features.
     * @param features  A map of key, values of features.
     * @return  returns the URL of the selected song
     */
    public String getNextSongByFeature( Map<String, String> features ) throws Exception;

}
