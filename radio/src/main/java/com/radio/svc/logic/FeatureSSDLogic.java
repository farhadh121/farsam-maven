/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.logic;

import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.ArtistFeatureEntity;
import com.radio.entity.hibernate.FeatureSSDEntity;
import com.radio.svc.common.ImageFormat;
import com.radio.svc.dalc.IFeatureSSDDA;
import com.radio.svc.dalc.ISongDA;
import com.radio.svc.exceptions.ArtistExistException;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.exceptions.FileNotExistsException;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author farhad
 */
public class FeatureSSDLogic {
    
    private ISongDA songDA;
    private IFeatureSSDDA featureSSDDA;

    public ISongDA getSongDA() {
        return songDA;
    }

    public void setSongDA(ISongDA songDA) {
        this.songDA = songDA;
    }

    public IFeatureSSDDA getFeatureSSDDA() {
        return featureSSDDA;
    }

    public void setFeatureSSDDA(IFeatureSSDDA featureSSDDA) {
        this.featureSSDDA = featureSSDDA;
    }
      /////////////////////////////////////////////////

    public void addNewFeatureSSD( FeatureSSDEntity featureSSDEntity, FileItem featureSSDFile) throws
            
            FileNotExistsException{
/***
 * TODO: FIX this shit
 */



    }
}
