package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.dalc.ISongDA;
import com.radio.svc.dalc.IUserDA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/18/14
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDA extends GenericDA<UserEntity, Long> implements IUserDA {

    public Log logger = new Log4JLogger(this.getClass().getName());

    /////////////////////////////////////////////////////////////////

    @Override
    public UserEntity getUserByUserName(UserEntity userEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add(Restrictions.eq("email", userEntity.getEmail()));
        return (UserEntity)criteria.uniqueResult();

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {

        // Getting User Entity
        UserEntity temp = new UserEntity();
        temp.setEmail(s);
        temp = getUserByUserName(temp);

        if( temp == null )
            throw new UsernameNotFoundException( "There is not user with user name " + s );

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
            temp.getEmail(),
            temp.getPassword(),
            enabled,
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            getAuthorities(temp)
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities( UserEntity userEntity ){

        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        Iterator itr = userEntity.getRoles().iterator();
        while( itr.hasNext() ){
            RoleEntity roleEntity = (RoleEntity)itr.next();
            list.add(new GrantedAuthorityImpl(roleEntity.getName()));
        }

        return list;

    }
}
