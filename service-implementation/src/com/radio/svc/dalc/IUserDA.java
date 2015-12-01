package com.radio.svc.dalc;

import com.radio.entity.hibernate.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/18/14
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDA extends IGenericDA<UserEntity, Long>, UserDetailsService {

    /**
     * Get User Entity by username
     *
     * @param userEntity    The user entity to look for its username ( email )
     * @return  the result user entity
     */
    public UserEntity getUserByUserName( UserEntity userEntity );


}
