package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.controllers.radio.jsonentities.NextSongRequest;
import com.radio.svc.controllers.radio.jsonentities.NextSongResult;
import com.radio.svc.controllers.radio.jsonentities.StationRequest;
import com.radio.svc.exceptions.SongNotExistsException;
import com.radio.svc.exceptions.UserNotExistsException;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by farhad on 8/24/14.
 */

@Controller
public class NextSongController {

    private ISongServiceProvider songServiceProvider;
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

    @RequestMapping(value = "/nextSong.ajax", method = RequestMethod.POST)
    @ResponseBody
    public String nextSong(@RequestBody String json) throws IOException, UserNotExistsException {

        ObjectMapper objectMapper = new ObjectMapper();
        NextSongRequest nextSongRequest = objectMapper.readValue(json, NextSongRequest.class);
        String userName = null;
        String result = null;
        String resultSongArtWork = null;
        String resultSongTitle = null;
        String resultSongArtist = null;
        String resultArtistInfo = null;
        Long resultSongID = null;
        boolean resultLikeStatus = false;
        boolean resultDislikeStatus = false;
        int dislikeCount = 0;
        int likeCount = 0;

        try {
            //songServiceProvider.getTopSongs();
            result = songServiceProvider.getNextSong(Long.valueOf(nextSongRequest.getStationid()));
            userName = nextSongRequest.getUsername();
            /**
             * TODO: Change the result so it will bring back the object instead of mp3 filename.
             */
            String breakResult = result;
            //FH split result (MP3 file name) so it will return song name.
            String[] split = breakResult.split("-");
            String firstSubString = split[0];
            String secondSubString = split[1];
            SongEntity temp = songServiceProvider.getSongByName(firstSubString);
            String artistResult = null;
            String artistInfoResult = null;
            List<ArtistEntity> artistEntities = songServiceProvider.getSongArtists(temp.getSongID());
            Iterator i = artistEntities.iterator();


            while (i.hasNext()) {
                ArtistEntity art = (ArtistEntity) i.next();
                artistResult = art.getArtistName();
                artistInfoResult = art.getArtistInfo();


            }

            resultSongArtist = artistResult;
            resultArtistInfo = artistInfoResult;
            //System.out.println("artist info" + resultArtistInfo);
            resultSongArtWork = temp.getArtworkPath();
            //get Song ID
            resultSongID = temp.getSongID();

            resultSongTitle = firstSubString;

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
        nextSongResult.setUrl(commonFile.getDomain()+"/songs/" + result);
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
