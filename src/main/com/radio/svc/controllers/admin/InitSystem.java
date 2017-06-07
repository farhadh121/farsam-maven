package com.radio.svc.controllers.admin;

import com.radio.svc.common.CommonFile;
import com.radio.svc.serviceinterface.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 10/3/14
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class InitSystem extends AbstractController  {

    private CommonFile commonFile;
    private IGenreServiceProvider genreServiceProvider;
    private IRecordLabelServiceProvider recordLabelServiceProvider;
    private IRoleServiceProvider roleServiceProvider;
    private IUserServiceProvider userServiceProvider;
    private IArtistServiceProvider artistServiceProvider;
    private IAlbumServiceProvider albumServiceProvider;
    private ISongServiceProvider songServiceProvider;


    public IGenreServiceProvider getGenreServiceProvider() {
        return genreServiceProvider;
    }

    public void setGenreServiceProvider(IGenreServiceProvider genreServiceProvider) {
        this.genreServiceProvider = genreServiceProvider;
    }

    public IRecordLabelServiceProvider getRecordLabelServiceProvider() {
        return recordLabelServiceProvider;
    }

    public void setRecordLabelServiceProvider(IRecordLabelServiceProvider recordLabelServiceProvider) {
        this.recordLabelServiceProvider = recordLabelServiceProvider;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public IRoleServiceProvider getRoleServiceProvider() {
        return roleServiceProvider;
    }

    public void setRoleServiceProvider(IRoleServiceProvider roleServiceProvider) {
        this.roleServiceProvider = roleServiceProvider;
    }

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    public IArtistServiceProvider getArtistServiceProvider() {
        return artistServiceProvider;
    }

    public void setArtistServiceProvider(IArtistServiceProvider artistServiceProvider) {
        this.artistServiceProvider = artistServiceProvider;
    }

    public IAlbumServiceProvider getAlbumServiceProvider() {
        return albumServiceProvider;
    }

    public void setAlbumServiceProvider(IAlbumServiceProvider albumServiceProvider) {
        this.albumServiceProvider = albumServiceProvider;
    }

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {



        //Adding Role


        //roleServiceProvider.addRole("ROLE_ADMIN");

        //Adding User
    	List<String> roles = new LinkedList<String>();
        roles.add("ROLE_ADMIN");
        Date date = new SimpleDateFormat("yyyyMMdd").parse("20140101");
        userServiceProvider.addUser("farhadh121@gmail.com","123456","admin", "admin", date,roles);


        // Adding Genres
       /* genreServiceProvider.addNewGenre("Persian Rock");
        genreServiceProvider.addNewGenre("Persian Jazz");
        genreServiceProvider.addNewGenre("Persian Latin");
        genreServiceProvider.addNewGenre("Persian 6/8 Dance");
        genreServiceProvider.addNewGenre("Persian 6/8 Club");
        genreServiceProvider.addNewGenre("Persian Classic");
        genreServiceProvider.addNewGenre("Persian Traditional");
        genreServiceProvider.addNewGenre("Persian Flamenco/Spanish");
        genreServiceProvider.addNewGenre("Persian Slow Pop");
        genreServiceProvider.addNewGenre("Persian Rap");
        genreServiceProvider.addNewGenre("Persian Pop");
        genreServiceProvider.addNewGenre("Persian Pop Dance");
        genreServiceProvider.addNewGenre("Persian Electronic");
        genreServiceProvider.addNewGenre("Persian Hip-Hop");
        //used for the singles album
        genreServiceProvider.addNewGenre("mix");
        genreServiceProvider.addNewGenre("Persian Contemporary Pop");
        //Persian new age which is mixture of sonati and other genres
        genreServiceProvider.addNewGenre("Persian Fusion");
        genreServiceProvider.addNewGenre("Persian Folklore");
        genreServiceProvider.addNewGenre("Persian Trance");*/




        /*Adding Record Label*/
       /* recordLabelServiceProvider.addNewRecordLabel("Unknown", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "no-image.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Taraneh", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "taraneh.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Tapesh",commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "no-image.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Caltex",commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "caltex.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Avang", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "avang.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Radio Javan", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "rj.jpg");
        recordLabelServiceProvider.addNewRecordLabel("M4", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "no-image.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Extensive Music AB", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "extensive-music.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Taraneh Sharghi", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "taraneh-sharghi.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Mahriz", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "mahriz.jpg");
        recordLabelServiceProvider.addNewRecordLabel("Pars Video", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "pars-video.jpg");

        recordLabelServiceProvider.addNewRecordLabel("Irangaam", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "iran-gam.jpg");

        recordLabelServiceProvider.addNewRecordLabel("Cheroke", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "cherokeemusicgroup.jpg");


        recordLabelServiceProvider.addNewRecordLabel("Tasvir Gostar Pasargad", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "tasvir-gostare-pasargad.jpg");

        recordLabelServiceProvider.addNewRecordLabel("Payam Enterprise Inc", commonFile.getInitrecordlabelartworkpath() + commonFile.getSeparator() + "no-image.jpg");
  


*/

        //Adding Song


       
        
        return null;  //To change body of implemented methods use File | Settings | File Templates.

    }

}
