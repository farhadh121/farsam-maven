package com.radio.svc.dalc;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.SongEntity;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/18/14
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRoleDA extends IGenericDA<RoleEntity, Long> {

    public RoleEntity getRoleByName( RoleEntity roleEntity );

}
