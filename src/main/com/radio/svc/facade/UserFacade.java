package com.radio.svc.facade;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.exceptions.*;
import com.radio.svc.logic.UserLogic;
import com.radio.svc.serviceinterface.IUserServiceProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/19/14
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserFacade implements IUserServiceProvider {

    UserLogic userLogic;




    private String defaultUserRole;

    public String getDefaultUserRole() {
        return defaultUserRole;
    }

    public void setDefaultUserRole(String defaultUserRole) {
        this.defaultUserRole = defaultUserRole;
    }

    public UserLogic getUserLogic() {
        return userLogic;
    }

    public void setUserLogic(UserLogic userLogic) {
        this.userLogic = userLogic;
    }

    @Override
    public List<UserEntity> getAllUsers() {

        return userLogic.getAllUsers();

    }

    @Override
    public List<RoleEntity> getUserRoles(Long userId) throws UserNotExistsException {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserID( userId );

        return userLogic.getUserRoles( userEntity );

    }


    @Override
    public void addUser(String userEmail, String password, String firstName, String lastName, Date bornDate, List<String> userRoles) throws
            UserExistsException,
            EmailNotValidException,
            DateFormatWrongException,
            RoleNotExistsException{

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail( userEmail );
        userEntity.setFirstName( firstName );
        userEntity.setLastName( lastName );
        userEntity.setPassword( password );
        userEntity.setBornDate( bornDate );

        // Reforming roles
        Set<RoleEntity> roleEntitySet = new HashSet<RoleEntity>();

        Iterator itr = userRoles.iterator();
        while( itr.hasNext() ){
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setName( (String)itr.next() );
            roleEntitySet.add(roleEntity);
        }

        userEntity.setRoles(roleEntitySet);

        userLogic.addUser(userEntity);

    }

    @Override
    public void addUser(String userEmail, String password, String firstName, String lastName, Date bornDate) throws
            UserExistsException,
            EmailNotValidException,
            DateFormatWrongException,
            RoleNotExistsException{

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail( userEmail );
        userEntity.setFirstName( firstName );
        userEntity.setLastName( lastName );
        userEntity.setPassword( password );
        userEntity.setBornDate( bornDate );

        // Reforming roles
        Set<RoleEntity> roleEntitySet = new HashSet<RoleEntity>();


        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName( defaultUserRole );
        roleEntitySet.add(roleEntity);


        userEntity.setRoles(roleEntitySet);

        userLogic.addUser(userEntity);

    }


    @Override
    public void editPassword(String username, String oldPassword, String newPassword, String confirmNewPassword) throws
            UserNotExistsException,
            PasswordNotMatchException {

        UserEntity oldUserEntity = new UserEntity();
        oldUserEntity.setEmail(username);
        oldUserEntity.setPassword(oldPassword);

        userLogic.editPassword( oldUserEntity, newPassword, confirmNewPassword );

    }

    @Override
    public UserEntity getUserByUsername(String username) throws
            UserNotExistsException {

        UserEntity temp = new UserEntity();
        temp.setEmail( username );

        return userLogic.getUserByUsername( temp );

    }

    @Override
    public String editUsername(long userId, String newUsername) throws
            UserNotExistsException {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserID( userId );
        userEntity.setEmail( newUsername );

        return userLogic.editUsername( userEntity );

    }

    @Override
    public String editBirthdate(Long userId, String newBirthDate) throws
            UserNotExistsException, ParseException {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserID( userId );

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = formatter.parse(newBirthDate);
        userEntity.setBornDate( date );

        userLogic.editBirthdate( userEntity );

        return newBirthDate;

    }

    @Override
    public String editUserFirstName(Long userId, String newFirstName) throws
            UserNotExistsException {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserID( userId );
        userEntity.setFirstName( newFirstName );

        return userLogic.editUserFirstName( userEntity );

    }

    @Override
    public String editUserLastName(Long userId, String newLastName) throws
            UserNotExistsException {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserID( userId );
        userEntity.setLastName( newLastName );

        return userLogic.editUserLastName( userEntity );

    }

    public Long userLikeSongs(String userName, Long songId) throws
            SongNotExistsException,
            SongAlreadyLikedException,
            UserNotExistsException{

        SongEntity songEntity = new SongEntity();
        songEntity.setSongID( songId );

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userName);

       return userLogic.userLikesSong(userEntity, songEntity);

    }

    public List<SongEntity> getUsersLikedSong(String userName)throws
            UserNotExistsException{
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userName);
        return userLogic.getUsersLikedSong(userEntity);

    }

    public Long userDislikeSongs(String userName, Long songId) throws
            SongNotExistsException,
            SongAlreadyDislikedException,
            UserNotExistsException  {

        SongEntity songEntity = new SongEntity();
        songEntity.setSongID( songId );

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userName);

        return userLogic.userDislikesSong(userEntity, songEntity);

    }

    public List<SongEntity> getUsersDislikedSong(String userName)throws
            UserNotExistsException{
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userName);
        return userLogic.getUsersDislikedSong(userEntity);

    }

    public HashMap<Long,SongEntity> getUsersDislikedSongMap(String userName)throws
            UserNotExistsException{
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userName);
        return userLogic.getUsersDislikedSongMap(userEntity);
    }




}
