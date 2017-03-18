package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.svc.exceptions.RoleExistsException;
import com.radio.svc.exceptions.RoleNotExistsException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 6/21/14
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRoleServiceProvider {


    /**
     * Add new role to our system
     * @param roleName              Name of the target role
     * @throws RoleExistsException  Throws if the role does exists in the system
     */
    public void addRole( String roleName ) throws
            RoleExistsException;

    /**
     * return a list of all roles
     * @return      list of all roles
     */
    public List<RoleEntity> getAllRoles();

    /**
     * delete one role from the system
     * @param rolename      name of the target role
     * @throws RoleNotExistsException   throws when there is no such a role in the system with
     *                                  the specified name
     */
    public void deleteRole( String rolename ) throws
            RoleNotExistsException;



}
