package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.exceptions.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/19/14
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IUserServiceProvider extends Serializable {

    /**
     * Retrieve a list of all users inside the system
     * @return  a list of all users
     */
    public List<UserEntity> getAllUsers();

    /**
     * returns a list of roles
     * @param userId        user id of the target user
     * @return              a list of all users
     */
    public List<RoleEntity> getUserRoles( Long userId ) throws
            UserNotExistsException;

    /**
     *
     * @param userEmail                     email of the user
     * @param password                      password of the user
     * @param firstName                     first name of the user
     * @param lastName                      last name of the user
     * @param bornDate                      born date of the user
     * @param userRoles                     role of the added user
     * @throws UserExistsException          throws when the same user exists in the system
     * @throws EmailNotValidException       throws when the email provided is not valid
     * @throws DateFormatWrongException     throws when the date format is not valid
     */
    public void addUser( String userEmail, String password, String firstName, String lastName, Date bornDate, List<String> userRoles ) throws
            UserExistsException,
            EmailNotValidException,
            DateFormatWrongException,
            RoleNotExistsException;

    /**
     *
     * @param userEmail                     email of the user
     * @param password                      password of the user
     * @param firstName                     first name of the user
     * @param lastName                      last name of the user
     * @param bornDate                      born date of the user
     * @throws UserExistsException          throws when the same user exists in the system
     * @throws EmailNotValidException       throws when the email provided is not valid
     * @throws DateFormatWrongException     throws when the date format is not valid
     */
    public void addUser( String userEmail, String password, String firstName, String lastName, Date bornDate) throws
            UserExistsException,
            EmailNotValidException,
            DateFormatWrongException,
            RoleNotExistsException;


    /**
     *
     * @param username                      user name of the target user for changing password
     * @param oldPassword                   old password of the user
     * @param newPassword                   new password for the user
     * @param confirmNewPassword            confirmed new password for the user
     * @throws UserNotExistsException       Throws when the user does not exist in the system
     * @throws PasswordNotMatchException    Throws when something wrong with the password
     */
    public void editPassword( String username, String oldPassword, String newPassword, String confirmNewPassword ) throws
            UserNotExistsException,
            PasswordNotMatchException;

    /**
     * This function returns the user entity for that specific username, if that user name exists
     * @param username      name of the user as input
     * @return              The selected user entity
     * @throws UserNotExistsException   Throws when there is no user with the specified username
     */
    public UserEntity getUserByUsername( String username ) throws
            UserNotExistsException;


    /**
     * Change the username to the new one
     * @param userId        user id of the target user that it's name should be changed
     * @param newUsername   new user name for the user
     * @return              The new user name
     * @throws UserNotExistsException   Throws when there is no user with such user id
     */
    public String editUsername( long userId, String newUsername ) throws
            UserNotExistsException;


    /**
     * Change the user birthday to the new one
     * @param userId        User id of the target user that it's birthday should be changed
     * @param newBirthDate  new birthday date for the user
     * @return              The new birthday date
     * @throws UserNotExistsException   Throws when there is no user with such user id
     */
    public String editBirthdate( Long userId, String newBirthDate ) throws
            UserNotExistsException, ParseException;

    /**
     * Change the user First name to the new one
     * @param userId        User id of the target user that it's first name should be changed
     * @param newFirstName  new first name for the user
     * @return              The new first name
     * @throws UserNotExistsException   Throws when there is no user with such user first name
     */
    public String editUserFirstName( Long userId, String newFirstName ) throws
            UserNotExistsException;

    /**
     * Change the user last name to the new one
     * @param userId        User id of the target user that it's last name should be changed
     * @param newLastName   new last name for the user
     * @return              The new last name
     * @throws UserNotExistsException   Throws when there is no user with such user last name
     */
    public String editUserLastName( Long userId, String newLastName ) throws
            UserNotExistsException;

    /**
     *
     * @param userName
     * @param songId
     * @return
     * @throws com.radio.svc.exceptions.SongNotExistsException       throws where there is not song with specified ID
     * @throws com.radio.svc.exceptions.SongAlreadyLikedException    throws where the songID provided is already liked.
     */
    //Farhad Testing Like
    public Long userLikeSongs(String userName, Long songId) throws
            SongNotExistsException,
            SongAlreadyLikedException,
            UserNotExistsException;

    /**
     *
     * @param userName
     * @return
     * @throws UserNotExistsException
     */
    public  List<SongEntity> getUsersLikedSong(String userName)throws
            UserNotExistsException;

    /**
     *
     * @param userName
     * @param songId
     * @return
     * @throws SongNotExistsException
     * @throws SongAlreadyDislikedException throw if song is already liked
     * @throws UserNotExistsException  throw if user does not exist
     */
    public Long userDislikeSongs(String userName, Long songId) throws
            SongNotExistsException,
            SongAlreadyDislikedException,
            UserNotExistsException;

    /**
     *
     * @param userName
     * @return
     * @throws UserNotExistsException throws if user does not exist
     */
    public  List<SongEntity> getUsersDislikedSong(String userName)throws
            UserNotExistsException;

    public HashMap<Long,SongEntity> getUsersDislikedSongMap(String userName)throws
            UserNotExistsException;

}


