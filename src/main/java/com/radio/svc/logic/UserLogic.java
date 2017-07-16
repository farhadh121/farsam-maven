package com.radio.svc.logic;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.common.EmailValidator;
import com.radio.svc.dalc.IRoleDA;
import com.radio.svc.dalc.ISongDA;
import com.radio.svc.dalc.IUserDA;
import com.radio.svc.exceptions.*;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 6/22/14
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserLogic {

    private IUserDA userDA;
    private EmailValidator emailValidator;
    private IRoleDA roleDA;
    private String defaultRoal;
    private ISongDA songDA;

    public ISongDA getSongDA() {
        return songDA;
    }

    public void setSongDA(ISongDA songDA) {
        this.songDA = songDA;
    }

    public EmailValidator getEmailValidator() {
        return emailValidator;
    }

    public void setEmailValidator(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    public IUserDA getUserDA() {
        return userDA;
    }

    public void setUserDA(IUserDA userDA) {
        this.userDA = userDA;
    }

    public IRoleDA getRoleDA() {
        return roleDA;
    }

    public void setRoleDA(IRoleDA roleDA) {
        this.roleDA = roleDA;
    }

    ////////////////////////////////////////////////////////////

    public List<UserEntity> getAllUsers(){

        return userDA.get();

    }

    public List<RoleEntity> getUserRoles( UserEntity userEntity ) throws
            UserNotExistsException{

        UserEntity realUserEntity = userDA.get( userEntity.getUserID() );
        if( realUserEntity == null )
            throw new UserNotExistsException( "There is no user with id " + userEntity.getUserID() );

        List<RoleEntity> roles = new LinkedList<RoleEntity>();

        Iterator itr = realUserEntity.getRoles().iterator();
        while( itr.hasNext() ){
            RoleEntity roleEntity = (RoleEntity)itr.next();
            roles.add( roleEntity );
        }

        return roles;
    }


    public void addUser( UserEntity userEntity ) throws
            UserExistsException,
            EmailNotValidException,
            DateFormatWrongException,
            RoleNotExistsException{

        // First check for existence of the user
        if( userDA.getUserByUserName( userEntity ) != null )
            throw new UserExistsException( "User " + userEntity.getEmail() + " does exist in the system!" );

        if( !emailValidator.validate( userEntity.getEmail() )  )
            throw new EmailNotValidException( "Not valid email " + userEntity.getEmail() );

        // We should check for date format

        // Checking validity of assigned roles
        Set<RoleEntity> realRoles = new HashSet<RoleEntity>();
        Iterator itr = userEntity.getRoles().iterator();
        while( itr.hasNext() ){

            RoleEntity roleEntity = (RoleEntity)itr.next();
            RoleEntity realRoleEntity = roleDA.getRoleByName( roleEntity );
            if( realRoleEntity == null )
                throw new RoleNotExistsException( "Role with name " + roleEntity.getName() + " does not exist in the system!" );

            realRoles.add(realRoleEntity);
            realRoleEntity.getUsers().add(userEntity);

        }

        userDA.insert( userEntity );
        userEntity.setRoles( realRoles );
        userDA.update( userEntity );

        itr = userEntity.getRoles().iterator();
        while( itr.hasNext() ){
            RoleEntity roleEntity = (RoleEntity)itr.next();
            roleDA.update(roleEntity);
        }

    }

    public void editPassword( UserEntity userEntity, String newPassword, String newPasswordConfirmed ) throws
            UserNotExistsException,
            PasswordNotMatchException{

        // Check existence of the user
        UserEntity realUserEntity = userDA.getUserByUserName( userEntity );
        if( realUserEntity == null )
            throw new UserNotExistsException( "There is no user with user name " + userEntity.getEmail() );

        if( !realUserEntity.getPassword().equals( userEntity.getPassword() ) )
            throw new PasswordNotMatchException( "Old password is not match!" );

        if( !newPassword.equals(newPasswordConfirmed) )
            throw new PasswordNotMatchException( "New password is not match with it's confirmation!" );


        realUserEntity.setPassword(newPassword);
        userDA.update(realUserEntity);

    }

    public UserEntity getUserByUsername(UserEntity userEntity) throws
            UserNotExistsException {

        UserEntity realUserEntity = userDA.getUserByUserName( userEntity );
        if( realUserEntity == null )
            throw new UserNotExistsException( "User with username " + userEntity.getEmail() + " does not exist in the system!" );

        return realUserEntity;

    }

    public String editUsername(UserEntity userEntity) throws
            UserNotExistsException {

        UserEntity realUserEntity = userDA.get( userEntity.getUserID() );
        if( realUserEntity == null )
            throw new UserNotExistsException( "User with used id " + userEntity.getUserID() + " does not exist in the system!" );

        realUserEntity.setEmail( userEntity.getEmail() );
        userDA.update( realUserEntity );

        return userEntity.getEmail();

    }

    public String editBirthdate( UserEntity userEntity ) throws
            UserNotExistsException{

        UserEntity realUserEntity = userDA.get( userEntity.getUserID() );
        if( realUserEntity == null )
            throw new UserNotExistsException( "User with user id " + userEntity.getUserID() + " does not exist in the system!" );

        realUserEntity.setBornDate( userEntity.getBornDate() );
        userDA.update( userEntity );

        return userEntity.getBornDate().toString();

    }

    public String editUserFirstName( UserEntity userEntity ) throws
            UserNotExistsException{

        UserEntity realUserEntity = userDA.get( userEntity.getUserID() );
        if( realUserEntity == null )
            throw new UserNotExistsException( "User with user id " + userEntity.getUserID() + " does not exist in the system!" );

        realUserEntity.setFirstName( userEntity.getFirstName() );
        userDA.update( realUserEntity );

        return userEntity.getFirstName();

    }

    public String editUserLastName( UserEntity userEntity ) throws
            UserNotExistsException{

        UserEntity realUserEntity = userDA.get( userEntity.getUserID() );
        if( realUserEntity == null )
            throw new UserNotExistsException( "User with user id " + userEntity.getUserID() + " does not exist in the system!" );

        realUserEntity.setLastName( userEntity.getLastName() );
        userDA.update( realUserEntity );

        return userEntity.getLastName();

    }

    public Long userLikesSong(UserEntity userEntity, SongEntity songEntity)throws
            SongNotExistsException,
            SongAlreadyLikedException,
            UserNotExistsException{

        UserEntity realUserEntity = userDA.getUserByUserName(userEntity);
        if(realUserEntity == null){
            throw new UserNotExistsException("User with user id " + userEntity.getUserID() + " does not exist in the system!");
        }

        //System.out.println( "khayemal" );
        SongEntity realSongEntity = songDA.get(songEntity.getSongID());  // getSongByID(songEntity);
        if(realSongEntity == null){
            throw new UserNotExistsException("Song with song id " + songEntity.getSongID() + " does not exist in the system!");
        }

        realUserEntity.getLikedSongs().add(realSongEntity);
        realSongEntity.getLikers().add(realUserEntity);

        songDA.update(realSongEntity);
        userDA.update(realUserEntity);

        return null;
    }

    public List<SongEntity> getUsersLikedSong(UserEntity userEntity) throws UserNotExistsException{
        UserEntity realUserEntity = userDA.getUserByUserName(userEntity);
        if(realUserEntity == null){
            throw new UserNotExistsException("User with user id " + userEntity.getUserID() + " does not exist in the system!");
        }


        List<SongEntity> songs = new LinkedList<SongEntity>();
                  int ss = realUserEntity.getLikedSongs().size();
        if(realUserEntity.getLikedSongs().size()==0){
            System.out.println("User has not liked any song!");
        }
        Iterator itr = realUserEntity.getLikedSongs().iterator();
        while( itr.hasNext() ){
            SongEntity songEntity = (SongEntity)itr.next();
            songs.add( songEntity );
        }

        return songs;
    }

    public Long userDislikesSong(UserEntity userEntity, SongEntity songEntity)throws
            SongNotExistsException,
            SongAlreadyDislikedException,
            UserNotExistsException{

        UserEntity realUserEntity = userDA.getUserByUserName(userEntity);
        if(realUserEntity == null){
            throw new UserNotExistsException("User with user id " + userEntity.getUserID() + " does not exist in the system!");
        }

        //System.out.println( "khayemal" );
        SongEntity realSongEntity = songDA.get(songEntity.getSongID());  // getSongByID(songEntity);
        if(realSongEntity == null){
            throw new UserNotExistsException("Song with song id " + songEntity.getSongID() + " does not exist in the system!");
        }

        realUserEntity.getDislikedSongs().add(realSongEntity);
        realSongEntity.getDislikers().add(realUserEntity);

        songDA.update(realSongEntity);
        userDA.update(realUserEntity);

        return null;
    }

    public List<SongEntity> getUsersDislikedSong(UserEntity userEntity) throws
            UserNotExistsException{
        UserEntity realUserEntity = userDA.getUserByUserName(userEntity);
        if(realUserEntity == null){
            throw new UserNotExistsException("User with user id " + userEntity.getUserID() + " does not exist in the system!");
        }


        List<SongEntity> songs = new LinkedList<SongEntity>();
        int ss = realUserEntity.getDislikedSongs().size();
        if(realUserEntity.getDislikedSongs().size()==0){
            System.out.println("User has not disliked any song!");
        }
        Iterator itr = realUserEntity.getDislikedSongs().iterator();
        while( itr.hasNext() ){
            SongEntity songEntity = (SongEntity)itr.next();
            songs.add( songEntity );
        }

        return songs;
    }


    public HashMap<Long, SongEntity> getUsersDislikedSongMap(UserEntity userEntity) throws UserNotExistsException{
        UserEntity realUserEntity = userDA.getUserByUserName(userEntity);
        if(realUserEntity == null){
            throw new UserNotExistsException("User with user id " + userEntity.getUserID() + " does not exist in the system!");
        }
        HashMap<Long, SongEntity> dislikedSongsMapOfUser = new HashMap<Long,SongEntity>();

        //List<SongEntity> songs = new LinkedList<SongEntity>();
        //int ss = realUserEntity.getDislikedSongs().size();
        /*if(realUserEntity.getDislikedSongs().size()==0){
            System.out.println("User has not disliked any song!");
        } */
        Iterator itr = realUserEntity.getDislikedSongs().iterator();
        while( itr.hasNext() ){
            SongEntity songEntity = (SongEntity)itr.next();
            dislikedSongsMapOfUser.put(songEntity.getSongID(), songEntity );
        }
        return dislikedSongsMapOfUser;
    }
}
