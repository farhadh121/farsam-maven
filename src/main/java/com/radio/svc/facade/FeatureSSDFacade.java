/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.facade;

import com.radio.entity.hibernate.FeatureSSDEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.serviceinterface.IFeatureSSDServiceProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author farhad
 */
public class FeatureSSDFacade implements IFeatureSSDServiceProvider{

    @Override
    public void addNewFeatureSSD(String songName, FileItem ssdFeatureFile) throws FileNotFoundException{
       BufferedReader csv = new BufferedReader(new FileReader(ssdFeatureFile.getName()));
        List<FeatureSSDEntity> featureSSDEntities = new LinkedList<FeatureSSDEntity>();
        
        SongEntity songServiceProvider = new SongEntity();
        
       
    String data;
        try {
            while ((data = csv.readLine()) != null){
                String songName_= data.split(",")[0];
                songServiceProvider.setName(songName);
                FeatureSSDEntity featureSSDEntiity = FeatureSSDEntity.create();
                if (featureSSDEntiity != null ) {
                    featureSSDEntiity.setFeatureSSDID(songServiceProvider.getSongID());
                    featureSSDEntities.add(featureSSDEntiity);
                }
            }   } catch (IOException ex) {
            Logger.getLogger(FeatureSSDFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
