package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.controllers.radio.jsonentities.BitrateStationRequest;
import com.radio.svc.controllers.radio.jsonentities.NextSongResult;
import com.radio.svc.exceptions.SongNotExistsException;
import com.radio.svc.exceptions.UserNotExistsException;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.serviceinterface.IStationServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by farhad on 11/25/2015
 */

public class BitrateSongsStationController {

    private ISongServiceProvider songServiceProvider;
    private IStationServiceProvider stationServicePropvider;

   
    private IUserServiceProvider userServiceProvider;
    private CommonFile commonFile;

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }
    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }
    
     public IStationServiceProvider getStationServicePropvider() {
        return stationServicePropvider;
    }

    public void setStationServicePropvider(IStationServiceProvider stationServicePropvider) {
        this.stationServicePropvider = stationServicePropvider;
    }

    @RequestMapping(value = "/bitRateSongsStationController.ajax", method = RequestMethod.POST)
    @ResponseBody
    public String nextSong(@RequestBody String json) throws IOException, UserNotExistsException {

        ObjectMapper objectMapper = new ObjectMapper();
        BitrateStationRequest bitrateStationRequest = objectMapper.readValue(json, BitrateStationRequest.class);
        String userName = null;
        SongEntity result;
        String resultSongArtWork = null;
        String resultSongTitle = null;
        String resultSongArtist = null;
        String resultArtistInfo = null;
        String resultSongPath = null;
        Long resultSongID = null;
        boolean resultLikeStatus = false;
        boolean resultDislikeStatus = false;
        int dislikeCount = 0;
        int likeCount = 0;

        try {
            //songServiceProvider.getTopSongs();
            result = songServiceProvider.getSongsByBitrate(bitrateStationRequest.getBitRate());
                                 
            String artistResult = null;
            String artistInfoResult = null;
            List<ArtistEntity> artistEntities = songServiceProvider.getSongArtists(result.getSongID());
            Iterator i = artistEntities.iterator();


            while (i.hasNext()) {
                ArtistEntity art = (ArtistEntity) i.next();
                artistResult = art.getArtistName();
                artistInfoResult = art.getArtistInfo();


            }

            resultSongArtist = artistResult;
            resultArtistInfo = artistInfoResult;
            //System.out.println("artist info" + resultArtistInfo);
            resultSongArtWork = result.getArtworkPath();
            //get Song ID
            resultSongID = result.getSongID();

            resultSongTitle = result.getName();
            resultSongPath = result.getMp3Path();
            //System.out.print(temp.getArtists());


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
        nextSongResult.setUrl(commonFile.getDomain()+"/songs/" + resultSongPath);
        nextSongResult.setArtWorkUrl(commonFile.getDomain()+"/song-artwork/" + resultSongArtWork);
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
