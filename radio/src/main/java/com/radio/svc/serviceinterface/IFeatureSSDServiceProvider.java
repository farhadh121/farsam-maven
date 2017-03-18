/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.serviceinterface;

import java.io.FileNotFoundException;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author farhad
 */
public interface IFeatureSSDServiceProvider {

    public void addNewFeatureSSD(String songName, FileItem ssdFeatureFile)throws FileNotFoundException;
    
}
