/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.dalc;

import com.radio.entity.hibernate.FeatureSSDEntity;
import com.radio.entity.hibernate.SongEntity;

/**
 *
 * @author farhad
 */
public interface IFeatureSSDDA {
    
    public FeatureSSDEntity getFeatureSSDBySongID(SongEntity songEntity); 
    
}
