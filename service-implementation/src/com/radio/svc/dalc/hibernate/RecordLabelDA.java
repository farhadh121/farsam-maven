package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.svc.dalc.IGenreDA;
import com.radio.svc.dalc.IRecordLabelDA;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/26/14
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecordLabelDA extends GenericDA<RecordLabelEntity, Long> implements IRecordLabelDA {

    @Override
    public RecordLabelEntity getRecordLabelByName(RecordLabelEntity recordLabelEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add(Restrictions.eq("name", recordLabelEntity.getName()));

        return (RecordLabelEntity)criteria.uniqueResult();

    }
}
