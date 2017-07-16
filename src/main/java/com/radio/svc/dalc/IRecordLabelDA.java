package com.radio.svc.dalc;

import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.entity.hibernate.RoleEntity;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/26/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IRecordLabelDA extends IGenericDA<RecordLabelEntity, Long> {

    public RecordLabelEntity getRecordLabelByName( RecordLabelEntity recordLabelEntity );

}
