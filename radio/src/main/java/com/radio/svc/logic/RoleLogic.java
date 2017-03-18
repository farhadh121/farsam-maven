package com.radio.svc.logic;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.svc.dalc.IRoleDA;
import com.radio.svc.exceptions.RoleExistsException;
import com.radio.svc.exceptions.RoleNotExistsException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 6/21/14
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleLogic {

    private IRoleDA roleDA;

    public IRoleDA getRoleDA() {
        return roleDA;
    }

    public void setRoleDA(IRoleDA roleDA) {
        this.roleDA = roleDA;
    }

    //////////////////////////////////////////////////////////////////

    public void addRole( RoleEntity roleEntity ) throws
            RoleExistsException{

        // first check if role does exists
        if( roleDA.getRoleByName(roleEntity) != null )
            throw new RoleExistsException( "Role with name " + roleEntity.getName() + " does exist in the system!" );

        roleDA.insert( roleEntity );

    }

    public List<RoleEntity> getAllRoles(){

        return roleDA.get();

    }

    public void deleteRole( RoleEntity roleEntity ) throws
        RoleNotExistsException{

        RoleEntity realRoleEntity = roleDA.getRoleByName( roleEntity );
        if( realRoleEntity == null )
            throw new RoleNotExistsException( "Role " + roleEntity.getName() + " does not exist in the system!" );

        roleDA.delete( realRoleEntity );

    }

}