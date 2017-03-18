package com.radio.svc.songengine;

import com.radio.entity.hibernate.SongEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.controllers.radio.NextSongController;
import com.radio.svc.controllers.radio.jsonentities.NextSongRequest;
import com.radio.svc.controllers.radio.jsonentities.NextSongResult;
import com.radio.svc.dalc.hibernate.UserDA;
import com.radio.svc.exceptions.GenreNotExistsException;
import com.radio.svc.exceptions.UserNotExistsException;
import com.radio.svc.facade.UserFacade;
import com.radio.svc.logic.SongLogic;
import com.radio.svc.logic.UserLogic;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.radio.svc.facade.UserFacade;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.User;
 import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.serviceinterface.IStationServiceProvider;
import com.radio.entity.hibernate.StationEntity;

import java.util.*;

import com.radio.svc.common.CommonFile;
import com.radio.svc.common.ImageFormat;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;

import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Created by farhad on 8/22/14.
 */
public class SongSelectorByGenre implements ISongSelector {

    private SongLogic songLogic;
    private UserLogic userLogic;
    
    public UserLogic getUserLogic() {
        return userLogic;
    }

    public void setUserLogic(UserLogic userLogic) {
        this.userLogic = userLogic;
    }

    private CommonFile commonFile;

    public SongLogic getSongLogic() {
        return songLogic;
    }

    public void setSongLogic(SongLogic songLogic) {
        this.songLogic = songLogic;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    @Override
    public String getNextSongByFeature(Map<String, String> features) throws
            GenreNotExistsException,
            UserNotExistsException {

        String genreName;
        if( !features.containsKey( "Genre" ) ){
            throw new GenreNotExistsException( "There is no key \"genre\" in the features map." );
        }


       // Get list of songs


        genreName = features.get( "Genre" );
        List<SongEntity> songEntities = songLogic.listSongsByGenre( genreName );


        // Genrate random number
        /**TODO: Add each song ID to session and verify that it had not been played

         *
         */
        Set<Integer> randomNumbersStorage = new HashSet<Integer>();
        int size = songEntities.size();
        Random random = new Random();
        //added a 1 as minimum and size as maximum
        int randomNumber = random.nextInt(size);

        Authentication frontAuthentication = SecurityContextHolder.getContext().getAuthentication();
        HashMap<Long, SongEntity> dislikedSongsOfUser = new HashMap<Long, SongEntity>();
        if( !(frontAuthentication instanceof AnonymousAuthenticationToken) ){
            //UserEntity currentLoggedInUser = (UserEntity)authentication.getPrincipal();
            User frontUser = (User)frontAuthentication.getPrincipal();
            UserEntity frontUserEntity = new UserEntity();
            frontUserEntity.setEmail(frontUser.getUsername());
            dislikedSongsOfUser = userLogic.getUsersDislikedSongMap(frontUserEntity);//userServiceProvider.getUsersDislikedSongMap(frontUser.getUsername());
        }
        int counter = 0;
       while (counter <  songEntities.size()) {
            counter ++;
            randomNumber = random.nextInt(size);
            randomNumbersStorage.add(randomNumber);
            Long toBe = songEntities.get(randomNumber).getSongID();
            
            if(!dislikedSongsOfUser.containsKey(toBe)) {
                break;
            }
            if(!randomNumbersStorage.contains(randomNumber)){
                break;
            }
        }

       
        return songEntities.get(randomNumber).getMp3Path();

    }

}
