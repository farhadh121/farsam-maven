package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.dalc.IRoleDA;
import com.radio.svc.dalc.ISongDA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/18/14
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleDA extends GenericDA<RoleEntity, Long> implements IRoleDA {

    public Log logger = new Log4JLogger(this.getClass().getName());

    /////////////////////////////////////////////////////////////////


    @Override
    public RoleEntity getRoleByName(RoleEntity roleEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add(Restrictions.eq( "name", roleEntity.getName() ));

        return (RoleEntity)criteria.uniqueResult();

    }
}
