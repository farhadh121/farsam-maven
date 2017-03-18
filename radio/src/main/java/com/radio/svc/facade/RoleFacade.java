package com.radio.svc.facade;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.svc.exceptions.RoleExistsException;
import com.radio.svc.exceptions.RoleNotExistsException;
import com.radio.svc.logic.RoleLogic;
import com.radio.svc.serviceinterface.IRoleServiceProvider;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/21/14
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleFacade implements IRoleServiceProvider {

    private RoleLogic roleLogic;

    public RoleLogic getRoleLogic() {
        return roleLogic;
    }

    public void setRoleLogic(RoleLogic roleLogic) {
        this.roleLogic = roleLogic;
    }

    ////////////////////////////////////////////////////////////

    @Override
    public void addRole(String roleName) throws RoleExistsException {

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName( roleName );

        roleLogic.addRole(roleEntity);

    }

    @Override
    public List<RoleEntity> getAllRoles() {

        return roleLogic.getAllRoles();

    }

    @Override
    public void deleteRole(String rolename) throws RoleNotExistsException {

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName( rolename );

        roleLogic.deleteRole( roleEntity );

    }
}
