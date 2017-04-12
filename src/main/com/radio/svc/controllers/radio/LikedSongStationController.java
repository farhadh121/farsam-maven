/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.controllers.radio.jsonentities.LikeSongStationRequest;
import com.radio.svc.controllers.radio.jsonentities.NextSongResult;
import com.radio.svc.controllers.radio.jsonentities.PickSongRequest;
import com.radio.svc.exceptions.SongNotExistsException;
import com.radio.svc.exceptions.UserNotExistsException;
import com.radio.svc.serviceinterface.IGenreServiceProvider;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.serviceinterface.IStationServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fxh155
 */
public class LikedSongStationController {
    
    private IUserServiceProvider userServiceProvider;
    private IGenreServiceProvider genreServiceProvider;
    private ISongServiceProvider songServiceProvider;
    private IStationServiceProvider stationServiceProvider;
    private CommonFile commonFile;

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }



    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }



    public IGenreServiceProvider getGenreServiceProvider() {
        return genreServiceProvider;
    }

    public void setGenreServiceProvider(IGenreServiceProvider genreServiceProvider) {
        this.genreServiceProvider = genreServiceProvider;
    }

    public IStationServiceProvider getStationServiceProvider() {
        return stationServiceProvider;
    }

    public void setStationServiceProvider(IStationServiceProvider stationServiceProvider) {
        this.stationServiceProvider = stationServiceProvider;
    }
    
    
    @RequestMapping(value = "/likedSongStationController.ajax", method = RequestMethod.POST)
    @ResponseBody           
    public String nextSong(@RequestBody String json) throws IOException, UserNotExistsException {

        ObjectMapper objectMapper = new ObjectMapper();
        LikeSongStationRequest likeSongStationRequest = objectMapper.readValue(json, LikeSongStationRequest.class);

        String userName = null;
        List<SongEntity> result;
        String resultSongArtWork = null;
        String resultSongTitle = null;
        String resultSongArtist = null;
        String artistResult = null;
        String artistInfoResult = null;
        String resultArtistInfo = null;
        Long resultSongID = null;
        boolean resultLikeStatus = false;
        boolean resultDislikeStatus = false;
        int dislikeCount = 0;
        int likeCount = 0;
        String resultSongPath = null;

        try {
            //songServiceProvider.getTopSongs();
            userName = likeSongStationRequest.getUsername();
            result = getUserServiceProvider().getUsersLikedSong(userName);
            
            Random rand = new Random();
            int randomNumber = rand.nextInt(result.size());
            SongEntity nextSong = result.get(randomNumber);
            resultSongArtWork = nextSong.getArtworkPath();
            resultSongTitle = nextSong.getName();
            resultSongID = nextSong.getSongID();
            resultSongPath = nextSong.getMp3Path();
            SongEntity temp = songServiceProvider.getSongByName(resultSongTitle);
            List<ArtistEntity> artistEntities = songServiceProvider.getSongArtists(temp.getSongID());
            Iterator i = artistEntities.iterator();



            while (i.hasNext()) {

                ArtistEntity artistEntity =(ArtistEntity) i.next();
                 artistResult = artistEntity.getArtistName();
                 artistInfoResult = artistEntity.getArtistInfo();
                }

            resultSongArtist = artistResult;
            resultArtistInfo = artistInfoResult;

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------- Like
        //boolean likeStatus = false;
        // List<SongEntity> liked = new ArrayList<SongEntity>();
        // try {
        List<SongEntity> liked = userServiceProvider.getUsersLikedSong(userName);

        Iterator b = liked.iterator();


        while (b.hasNext()) {
            SongEntity songEntity = (SongEntity) b.next();

            if (resultSongID.equals(songEntity.getSongID())) {

                resultLikeStatus = true;

            }
        }
        try {
            likeCount = songServiceProvider.getNumberOfLikes(resultSongID);
            dislikeCount = songServiceProvider.getNumberOfDislikes(resultSongID);
        } catch (SongNotExistsException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            System.out.println("Song not exist!");
        }

        List<SongEntity> disliked = userServiceProvider.getUsersDislikedSong(userName);
        //dislikeCount = disliked.size();
        Iterator c = disliked.iterator();


        while (c.hasNext()) {
            SongEntity songEntity = (SongEntity) c.next();
            if (resultSongID.equals(songEntity.getSongID())) {

                resultDislikeStatus = true;

            }
        }
       /* } catch (UserNotExistsException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/

        NextSongResult nextSongResult = new NextSongResult();
        nextSongResult.setUrl(commonFile.getDomain()+ "/songs/" + resultSongPath);
        nextSongResult.setArtWorkUrl(commonFile.getDomain() + "/song-artwork/" + resultSongArtWork);
        nextSongResult.setTitle(resultSongTitle);
        nextSongResult.setArtist(resultSongArtist);
        nextSongResult.setArtistInfo(resultArtistInfo);
        nextSongResult.setSongID(resultSongID);
        nextSongResult.setLikeStatus(resultLikeStatus);
        nextSongResult.setDislikeStatus(resultDislikeStatus);
        nextSongResult.setDislikeCount(dislikeCount);
        nextSongResult.setLikeCount(likeCount);

        return toJson(nextSongResult);

    }

    private String toJson(NextSongResult nextSongResult) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String value = mapper.writeValueAsString(nextSongResult);
            return value;
        } catch (Exception e) {
            return null;
        }
    }
    
}
