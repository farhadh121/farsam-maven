/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.controllers.admin;

import com.radio.svc.common.CommonFile;
import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
import com.radio.svc.serviceinterface.IGenreServiceProvider;
import com.radio.svc.serviceinterface.IRecordLabelServiceProvider;
import com.radio.svc.serviceinterface.IRoleServiceProvider;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author fxh155
 */
public class InitSongsOne extends AbstractController {
    
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

    
    
        Set<String> shabSongArtists = new HashSet<String>();
        shabSongArtists.add("Nooshafarin");
        Map<String, String> ShabSongFeatures = new HashMap<String, String>();
        ShabSongFeatures.put( "Genre", "Persian 6/8 Dance" );
       songServiceProvider.addNewSong("Shabe to Shabe Mane",shabSongArtists,"Shabe to shabe mane","Persian 6/8 Dance","Our Night",commonFile.getInitsongpath() + commonFile.getSeparator() + "shabeh-to.mp3",commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "our-night.jpg",ShabSongFeatures);

        Set<String> mimiramsongArtists = new HashSet<String>();
        mimiramsongArtists.add("Shahram Shapareh");
        Map<String, String> songFeatures = new HashMap<String, String>();
        songFeatures.put( "Genre", "Persian 6/8 Dance" );
        songServiceProvider.addNewSong("Barat Mimiram",mimiramsongArtists,"Age to dasteto bedi to dastam","Persian 6/8 Dance","Tapesh",commonFile.getInitsongpath() + commonFile.getSeparator() +"barat-mimiram.mp3",commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tapesh.jpg",songFeatures);

        Set<String> hasratSongArtists = new HashSet<String>();
        hasratSongArtists.add("Ebi");
        Map<String, String > hasratSongFeatures = new HashMap<String, String>();
        hasratSongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Harighe Sabz",hasratSongArtists,"Bia kenaram sarvenaze bi to","Persian Flamenco/Spanish","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "bia-kenaram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg", hasratSongFeatures);

        Set<String > doostSongArtists = new HashSet<String>();
        doostSongArtists.add("Arash");
        Map<String ,String> doostSongFeatures = new HashMap<String, String>();
        doostSongFeatures.put("Genre", "Persian Pop Dance");
        songServiceProvider.addNewSong("Dooset Nadaram",doostSongArtists,"Baba che kashki, baba che dooghi","Persian Pop Dance", "Donya",commonFile.getInitsongpath() + commonFile.getSeparator() + "dooset-nadaram.mp3",commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "donya.jpg",doostSongFeatures);


        Set<String> doosetNadaramSongArtist = new HashSet<String>();
        doosetNadaramSongArtist.add("Siavash Shams");
        Map<String ,String> doosetNadaramSongFeatures = new HashMap<String, String>();
        doosetNadaramSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Dooset Nadaram",doosetNadaramSongArtist,"Boro dige dooset nadaram","Persian Electronic","Scream",commonFile.getInitsongpath() + commonFile.getSeparator() + "boro-dige-dooset-nadaram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "scream.jpg", doosetNadaramSongFeatures);



        Set<String> leyliSongArtist = new HashSet<String>();
        leyliSongArtist.add("Sina Hejazi");
        Map<String ,String> leyliSongFeatures = new HashMap<String, String>();
        leyliSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Leyli",leyliSongArtist,"Ye roozi donya khob bood o aroom bood","Persian Pop","Sina Hejazi Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "sina-hejazi/singles/leyli.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "leyli.jpg", leyliSongFeatures);

        Set<String> jadooeSongArtist = new HashSet<String>();
        jadooeSongArtist.add("Sara Naeini");
        Map<String ,String> jadooeSongFeatures = new HashMap<String, String>();
        jadooeSongFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Jadoo",jadooeSongArtist,"Ey gomshode dar roya jadoo kono peyda sho","Persian Jazz","Sara Naeini Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "sara-naeini/singles/jadoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadoo.jpg", jadooeSongFeatures);

        Set<String> asarateJanebiSongArtist = new HashSet<String>();
        asarateJanebiSongArtist.add("A2");
        Map<String ,String>asarateJanebiSongFeatures = new HashMap<String, String>();
        asarateJanebiSongFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Asarate Janebi",asarateJanebiSongArtist,"unavailable","Persian Rap","A2 Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "asarate-janebi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "asarate-janebi.jpg", asarateJanebiSongFeatures);

        Set<String> goleHamisheBaharSongArtist = new HashSet<String>();
        goleHamisheBaharSongArtist.add("Arian Band");
        Map<String ,String>goleHamisheBaharSongFeatures = new HashMap<String, String>();
        goleHamisheBaharSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Gole Hamishe Bahar",goleHamisheBaharSongArtist,"Doonehaye barf rooye goonehat khoone mikonan dobare","Persian Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() + "gole-hamishe-bahar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", goleHamisheBaharSongFeatures);

        Set<String> parvazSongArtist = new HashSet<String>();
        parvazSongArtist.add("Arian Band");
        Map<String ,String>parvazSongFeatures = new HashMap<String, String>();
        parvazSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Parvaz",parvazSongArtist,"Gofti mikhay ro abra man parie gheseha sham","Persian 6/8 Dance","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() + "parvaz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", parvazSongFeatures);

        Set<String> iranSongArtist = new HashSet<String>();
        iranSongArtist.add("Arian Band");
        Map<String ,String>iranSongFeatures = new HashMap<String, String>();
        iranSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Iran",iranSongArtist,"Unknown","Persian Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() + "iran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", iranSongFeatures);

        Set<String> royayeSepidSongArtist = new HashSet<String>();
        royayeSepidSongArtist.add("Arian Band");
        Map<String ,String>royayeSepidSongFeatures = new HashMap<String, String>();
        royayeSepidSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Royaye Sepid",royayeSepidSongArtist,"Royaye sepide man to ey eshgho omid e man","Persian Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() + "royaye-sepid.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", royayeSepidSongFeatures);

        Set<String> hamrazSongArtist = new HashSet<String>();
        hamrazSongArtist.add("Arian Band");
        Map<String ,String>hamrazSongFeatures = new HashMap<String, String>();
        hamrazSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Hamraz",hamrazSongArtist,"Barghe har negat sholeye cheshat noore donyaye man","Persian Slow Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() + "hamraz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", hamrazSongFeatures);

        Set<String> bemoonTaBemoonamSongArtist = new HashSet<String>();
        bemoonTaBemoonamSongArtist.add("Arian Band");
        Map<String ,String>bemoonTaBemoonamSongFeatures = new HashMap<String, String>();
        bemoonTaBemoonamSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Bemoon ta Bemoonam",bemoonTaBemoonamSongArtist,"Barghe har negat sholeye cheshat noore donyaye man","Persian Slow Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() + "bemoon-ta-bemoonam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", bemoonTaBemoonamSongFeatures);

        Set<String> panjerehSongArtist = new HashSet<String>();
        panjerehSongArtist.add("Arian Band");
        Map<String ,String>panjereSongFeatures = new HashMap<String, String>();
        panjereSongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Panjere",panjerehSongArtist,"Migi donyaye ma por az ranjo ghame","Persian Flamenco/Spanish","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() +  "panjereh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", panjereSongFeatures);

        Set<String> goleManSongArtist = new HashSet<String>();
        goleManSongArtist.add("Arian Band");
        Map<String ,String>goleManSongFeatures = new HashMap<String, String>();
        goleManSongFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Gole Man",goleManSongArtist,"Gole Man too ghalbam shode ghoncheye eshghe to penhoon","Persian Latin","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() +  "gole-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", goleManSongFeatures);

        Set<String> naMehraboonSongArtist = new HashSet<String>();
        naMehraboonSongArtist.add("Arian Band");
        Map<String ,String>naMehraboonSongFeatures = new HashMap<String, String>();
        naMehraboonSongFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Na Mehraboon",naMehraboonSongArtist,"Rafty to ey na mehraboon nazashty hata yek neshoon","Persian Latin","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() +  "na-mehraboon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", naMehraboonSongFeatures);

        Set<String> bahoonehSongArtist = new HashSet<String>();
        bahoonehSongArtist.add("Arian Band");
        Map<String ,String>bahoonehSongFeatures = new HashMap<String, String>();
        bahoonehSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Bahooneh",bahoonehSongArtist,"Nemidoonam, nemidoonam chera emshab parishoonam","Persian Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() +  "bahooneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", bahoonehSongFeatures);

        Set<String> taranehEshghSongArtist = new HashSet<String>();
        taranehEshghSongArtist.add("Arian Band");
        Map<String ,String>taranehEshghSongFeatures = new HashMap<String, String>();
        taranehEshghSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Hamdam e Ghroob",taranehEshghSongArtist,"Siah tarin khatereh to gheseye to boodam","Persian Slow Pop","Va Amma Eshgh",commonFile.getInitsongpath() + commonFile.getSeparator() +  "hamdam-ghroob.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", taranehEshghSongFeatures);

        Set<String> beverlySongArtists = new HashSet<String>();
        beverlySongArtists.add("Baro Bax");
        Map<String, String> beverlySongFeatures = new HashMap<String, String>();
        beverlySongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Beverly Hills",beverlySongArtists,"Yeki pashe ba man beraghseh","Persian Flamenco/Spanish","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "beverly-hills.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", beverlySongFeatures);

        Set<String> dokhtarPesarSongArtists = new HashSet<String>();
        dokhtarPesarSongArtists.add("Baro Bax");
        Map<String, String> dokhtarPesarSongFeatures = new HashMap<String, String>();
        dokhtarPesarSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("2khtar Pesar",dokhtarPesarSongArtists,"Yeki pashe ba man beraghseh","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "2khtar-pesar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", dokhtarPesarSongFeatures);

        Set<String> khodayeAsemoonhaSongArtists = new HashSet<String>();
        khodayeAsemoonhaSongArtists.add("Baro Bax");
        Map<String, String> khodayeAsemoonhaSongFeatures = new HashMap<String, String>();
        khodayeAsemoonhaSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Khodaye Asemoonha",khodayeAsemoonhaSongArtists,"Yeki pashe ba man beraghseh","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "khodaye-asemoonha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", khodayeAsemoonhaSongFeatures);

        Set<String> manMikhamSongArtists = new HashSet<String>();
        manMikhamSongArtists.add("Baro Bax");
        Map<String, String> manMikhamSongFeatures = new HashMap<String, String>();
        manMikhamSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Man Mikham",manMikhamSongArtists,"unknown","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "man-mikham.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", manMikhamSongFeatures);

        Set<String> rahatamBezarSongArtists = new HashSet<String>();
        rahatamBezarSongArtists.add("Baro Bax");
        Map<String, String> rahatamBezarSongFeatures = new HashMap<String, String>();
        rahatamBezarSongFeatures.put("Genre", "Persian 6/8 Club");
        songServiceProvider.addNewSong("Rahatam Bezar",rahatamBezarSongArtists,"unavailable","Persian 6/8 Club","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "rahatam-bezar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", rahatamBezarSongFeatures);

        Set<String> shervinSongArtists = new HashSet<String>();
        shervinSongArtists.add("Baro Bax");
        Map<String, String> shervinSongFeatures = new HashMap<String, String>();
        shervinSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Shervin",shervinSongArtists,"unavailable","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "shervin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", shervinSongFeatures);

        Set<String>adamaSongArtists = new HashSet<String>();
        adamaSongArtists.add("Baro Bax");
        Map<String, String> adammaSongFeatures = new HashMap<String, String>();
        adammaSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Adama",adamaSongArtists,"unavailable","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "adama.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", adammaSongFeatures);

        Set<String>bivafaSongArtists = new HashSet<String>();
        bivafaSongArtists.add("Baro Bax");
        Map<String, String> bivafaSongFeatures = new HashMap<String, String>();
        bivafaSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Wag",bivafaSongArtists,"unavailable","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "wag.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", bivafaSongFeatures);

        Set<String>kasaStaySongArtists = new HashSet<String>();
        kasaStaySongArtists.add("Baro Bax");
        Map<String, String> kasaStaySongFeatures = new HashMap<String, String>();
        kasaStaySongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Kasa Stay",kasaStaySongArtists,"unavailable","Persian Electronic","Wag", commonFile.getInitsongpath() + commonFile.getSeparator() + "kasa-stay.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "wag.jpg", kasaStaySongFeatures);

        Set<String>golToGoldonSongArtists = new HashSet<String>();
        golToGoldonSongArtists.add("Black Cats");
        Map<String, String> golToGoldoonSongFeatures = new HashMap<String, String>();
        golToGoldoonSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Gol To Goldoon",golToGoldonSongArtists,"Goldoone bi goleto mikham to golkhone mikhay chikar","Persian 6/8 Dance","Pool", commonFile.getInitsongpath() + commonFile.getSeparator() + "gol-too-goldoon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "pool.jpg", golToGoldoonSongFeatures);

        Set<String>khoshgeleSongArtists = new HashSet<String>();
        khoshgeleSongArtists.add("Black Cats");
        Map<String, String> khoshgeleSongFeatures = new HashMap<String, String>();
        khoshgeleSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Khoshgeleh",khoshgeleSongArtists,"Daghe daghe tane to tab mikone pirhane to","Persian 6/8 Dance","Pool", commonFile.getInitsongpath() + commonFile.getSeparator() + "khoshgeleh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "pool.jpg", khoshgeleSongFeatures);

        Set<String>biaBiaSongArtists = new HashSet<String>();
        biaBiaSongArtists.add("Black Cats");
        Map<String, String> biaBiaSongFeatures = new HashMap<String, String>();
        biaBiaSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Bia Bia",biaBiaSongArtists,"Bia bia ey gol bia del be to bastam","Persian 6/8 Dance","Pool", commonFile.getInitsongpath() + commonFile.getSeparator() + "bia-bia.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "pool.jpg", biaBiaSongFeatures);

        Set<String>poolSongArtists = new HashSet<String>();
        poolSongArtists.add("Black Cats");
        Map<String, String> poolSongFeatures = new HashMap<String, String>();
        poolSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Pool",poolSongArtists,"Hame harfat vase poole","Persian Pop","Pool", commonFile.getInitsongpath() + commonFile.getSeparator() + "pool.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "pool.jpg", poolSongFeatures);

        Set<String>ryhtmOfLoveSongArtists = new HashSet<String>();
        ryhtmOfLoveSongArtists.add("Black Cats");
        Map<String, String> ryhtmOfLoveSongFeatures = new HashMap<String, String>();
        ryhtmOfLoveSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Rhytm of Love",ryhtmOfLoveSongArtists,"unavailable","Persian Pop","Pool", commonFile.getInitsongpath() + commonFile.getSeparator() + "rhytm-of-love.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "pool.jpg", ryhtmOfLoveSongFeatures);

        Set<String>eshghSalehSongArtists = new HashSet<String>();
        eshghSalehSongArtists.add("Black Cats");
        Map<String, String> eshgheSalehSongFeatures = new HashMap<String, String>();
        eshgheSalehSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Eshghe 17 Saleh",eshghSalehSongArtists,"Eshghe 17 saleye man midoonam yare mani","Persian Slow Pop","Pool", commonFile.getInitsongpath() + commonFile.getSeparator() + "eshghe-17-saleh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "pool.jpg", eshgheSalehSongFeatures);

        Set<String>gharibeashenaSongArtists = new HashSet<String>();
        gharibeashenaSongArtists.add("Googoosh");
        Map<String, String> gharibeAshenaSongFeatures = new HashMap<String, String>();
        gharibeAshenaSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Gharibe Ashena",gharibeashenaSongArtists,"To az shahre gharibe bi bahoone omadi","Persian Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "gharibe-ashena.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", gharibeAshenaSongFeatures);

        Set<String>kaviraSongArtists = new HashSet<String>();
        kaviraSongArtists.add("Googoosh");
        Map<String, String> kavirSongFeatures = new HashMap<String, String>();
        kavirSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Kavir",kaviraSongArtists,"Khodaya kaviram begoo abr bebare mikham joon begiram","Persian Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "kavir.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", kavirSongFeatures);

        Set<String>ageBemooniSongArtists = new HashSet<String>();
        ageBemooniSongArtists.add("Googoosh");
        Map<String, String> ageBemooniSongFeatures = new HashMap<String, String>();
        ageBemooniSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Age Bemooni",ageBemooniSongArtists,"Khodaya kaviram begoo abr bebare mikham joon begiram","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "age-bemooni.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", ageBemooniSongFeatures);

        Set<String>nefrinBeInSongArtists = new HashSet<String>();
        nefrinBeInSongArtists.add("Googoosh");
        Map<String, String> nefrinBeInSongFeatures = new HashMap<String, String>();
        nefrinBeInSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Nefrin Be In Zendegi",nefrinBeInSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "nefrin-be-in-zendegi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", nefrinBeInSongFeatures);

        Set<String>delamTangeSongArtists = new HashSet<String>();
        delamTangeSongArtists.add("Googoosh");
        Map<String, String> delamTangeSongFeatures = new HashMap<String, String>();
        delamTangeSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Delam Tangeh",delamTangeSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "delam-tangeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", delamTangeSongFeatures);

        Set<String>ashkamNazSongArtists = new HashSet<String>();
        ashkamNazSongArtists.add("Googoosh");
        Map<String, String>ashkamNazSongFeatures = new HashMap<String, String>();
        ashkamNazSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ashkam Vase Man Naz Mikone",ashkamNazSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "ashkam-vase-man-naz-mikone.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", ashkamNazSongFeatures);

        Set<String>safarBekheirSongArtists = new HashSet<String>();
        safarBekheirSongArtists.add("Googoosh");
        Map<String, String> safarBekheirSongFeatures = new HashMap<String, String>();
        safarBekheirSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Safar Bekheir",safarBekheirSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "safar-bekheir.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", safarBekheirSongFeatures);

        Set<String>gheseyeVafaSongArtists = new HashSet<String>();
        gheseyeVafaSongArtists.add("Googoosh");
        Map<String, String> gheseyeVafaSongFeatures = new HashMap<String, String>();
        gheseyeVafaSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Gheseye Vafa",gheseyeVafaSongArtists,"unavailable","Persian Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "ghese-vafa.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", gheseyeVafaSongFeatures);

        Set<String>biGhararSongArtists = new HashSet<String>();
        biGhararSongArtists.add("Googoosh");
        Map<String, String> biGhararSongFeatures = new HashMap<String, String>();
        biGhararSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Bi Gharar",biGhararSongArtists,"unavailable","Persian Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "bi-gharar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", biGhararSongFeatures);

        Set<String>nazetoBenazamSongArtists = new HashSet<String>();
        nazetoBenazamSongArtists.add("Googoosh");
        Map<String, String> nazetoBenazamSongFeatures = new HashMap<String, String>();
        nazetoBenazamSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Nazeto Benazam",nazetoBenazamSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "nazeto-benazam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", nazetoBenazamSongFeatures);

        Set<String>delShekasteSongArtists = new HashSet<String>();
        delShekasteSongArtists.add("Googoosh");
        Map<String, String> delShekasteSongFeatures = new HashMap<String, String>();
        delShekasteSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Del Shekaste",delShekasteSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "del-shekaste.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", delShekasteSongFeatures);

        Set<String>naMehrabooonSongArtists = new HashSet<String>();
        naMehrabooonSongArtists.add("Googoosh");
        Map<String, String> naMehrabooonSongFeatures = new HashMap<String, String>();
        naMehrabooonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Na Mehrabooon",naMehrabooonSongArtists,"unavailable","Persian Slow Pop","Kavir", commonFile.getInitsongpath() + commonFile.getSeparator() + "na-mehraboon-googi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "kavir.jpg", naMehrabooonSongFeatures);

        Set<String> akhareGheseSongArtists = new HashSet<String>();
        akhareGheseSongArtists.add("Ebi");
        Map<String, String > akhareGheseSongFeatures = new HashMap<String, String>();
        akhareGheseSongFeatures.put("Genre", "Persian Pop");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Akhare Ghese",akhareGheseSongArtists,"Mishkanam bito vo nisti be kenaram nemiayi","Persian Pop","Setarehaye Sorbi",commonFile.getInitsongpath() + commonFile.getSeparator() + "akhare-gheseh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", akhareGheseSongFeatures);

        Set<String> ghebleSongArtists = new HashSet<String>();
        ghebleSongArtists.add("Ebi");
        Map<String, String > ghebleSongFeatures = new HashMap<String, String>();
        ghebleSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Gheble",ghebleSongArtists,"Ghebleh yani halgheye cheshme mastet","Persian Pop","Setarehaye Sorbi",commonFile.getInitsongpath() + commonFile.getSeparator() + "gheble.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", ghebleSongFeatures);

        Set<String>setarehayeSorbiSongArtists = new HashSet<String>();
        setarehayeSorbiSongArtists.add("Ebi");
        Map<String, String >setarehayeSorbiSongFeatures = new HashMap<String, String>();
        setarehayeSorbiSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Setarehaye Sorbi",setarehayeSorbiSongArtists,"Ghebleh yani halgheye cheshme mastet","Persian Pop","Setarehaye Sorbi",commonFile.getInitsongpath() + commonFile.getSeparator() + "setarehaye-sorbi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", setarehayeSorbiSongFeatures);

        Set<String>ashkatoPakSongArtists = new HashSet<String>();
        ashkatoPakSongArtists.add("Ebi");
        Map<String, String >ashkatoPakSongFeatures = new HashMap<String, String>();
        ashkatoPakSongFeatures.put("Genre", "Persian Slow Pop");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Ki Ashkato Pak Mikone",ashkatoPakSongArtists,"Ki ashkato pak mikone shaba ke ghose dari","Persian Slow Pop","Setarehaye Sorbi",commonFile.getInitsongpath() + commonFile.getSeparator() + "ki-ashkato-pak-mikone.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", ashkatoPakSongFeatures);

        Set<String>shabeGeryeSongArtists = new HashSet<String>();
        shabeGeryeSongArtists.add("Ebi");
        Map<String, String >shabeGeryeFeatures = new HashMap<String, String>();
        shabeGeryeFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shabe Gerye",shabeGeryeSongArtists,"Vazhe range zendegi bood vaghty to fekr e to boodam","Persian Slow Pop","Setarehaye Sorbi",commonFile.getInitsongpath() + commonFile.getSeparator() + "shabe-geryeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", shabeGeryeFeatures);

        Set<String>aghaghiSongArtists = new HashSet<String>();
        aghaghiSongArtists.add("Ebi");
        Map<String, String >aghaghiFeatures = new HashMap<String, String>();
        aghaghiFeatures.put("Genre", "Persian Slow Pop");
       songServiceProvider.addNewSong("Aghaghi",aghaghiSongArtists,"Baghe peyvande mano to pore az atreh aghaghi","Persian Slow Pop","Setarehaye Sorbi",commonFile.getInitsongpath() + commonFile.getSeparator() + "aghaghi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", aghaghiFeatures);

        Set<String>waltzNoSongArtists = new HashSet<String>();
        waltzNoSongArtists.add("Pallet");
        Map<String, String >waltnoFeatures = new HashMap<String, String>();
        waltnoFeatures.put("Genre", "Persian Jazz");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Waltz No. 1",waltzNoSongArtists,"Mara beshno az door delam mikhahadat","Persian Jazz","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "waltz-no-1.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", waltnoFeatures);


        Set<String>khosroShirinIntroSongArtists = new HashSet<String>();
        khosroShirinIntroSongArtists.add("Pallet");
        Map<String, String >khorsoShirinIntroFeatures = new HashMap<String, String>();
        khorsoShirinIntroFeatures.put("Genre", "Persian Fusion");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Khosro & Shirin(intro)",khosroShirinIntroSongArtists,"unavailable","Persian Fusion","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "khosro-shirin-intro.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", khorsoShirinIntroFeatures);


        Set<String>scienceLessonSongArtists = new HashSet<String>();
        scienceLessonSongArtists.add("Pallet");
        Map<String, String >scienceLessonFeatures = new HashMap<String, String>();
        scienceLessonFeatures.put("Genre", "Persian Jazz");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("The Science Lesson",scienceLessonSongArtists,"unavailable","Persian Jazz","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "the-science-lesson.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", scienceLessonFeatures);

        Set<String>mrVioletSongArtists = new HashSet<String>();
        mrVioletSongArtists.add("Pallet");
        Map<String, String >mrVioletFeatures = new HashMap<String, String>();
        mrVioletFeatures.put("Genre", "Persian Jazz");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Mr. Violet",mrVioletSongArtists,"unavailable","Persian Jazz","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "mrviolet.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", mrVioletFeatures);

        Set<String>lookSongArtists = new HashSet<String>();
        lookSongArtists.add("Pallet");
        Map<String, String >lookFeatures = new HashMap<String, String>();
        lookFeatures.put("Genre", "Persian Slow Pop");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Look",lookSongArtists,"unavailable","Persian Slow Pop","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "look.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", lookFeatures);

        Set<String>khosroShirinSongArtists = new HashSet<String>();
        khosroShirinSongArtists.add("Pallet");
        Map<String, String >khosroShirinFeatures = new HashMap<String, String>();
        khosroShirinFeatures.put("Genre", "Persian Fusion");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Khosrow & Shirin",khosroShirinSongArtists,"unavailable","Persian Fusion","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "khosro-shirin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", khosroShirinFeatures);

        Set<String>aThousandTaleSongArtists = new HashSet<String>();
        aThousandTaleSongArtists.add("Pallet");
        Map<String, String >aThousandTaleFeatures = new HashMap<String, String>();
        aThousandTaleFeatures.put("Genre", "Persian Slow Pop");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("A Thousand Tale",aThousandTaleSongArtists,"Khooneye madar bozorge hezarta ghese dare","Persian Slow Pop","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "a-thousand-tales.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", aThousandTaleFeatures);

        Set<String>raingAgainSongArtists = new HashSet<String>();
        raingAgainSongArtists.add("Pallet");
        Map<String, String >raingAgainFeatures = new HashMap<String, String>();
        raingAgainFeatures.put("Genre", "Persian Fusion");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Raing Again",raingAgainSongArtists,"unavailable","Persian Fusion","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "rain-again.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", raingAgainFeatures);

        Set<String>triangleSongArtists = new HashSet<String>();
        triangleSongArtists.add("Pallet");
        Map<String, String >triangleFeatures = new HashMap<String, String>();
        triangleFeatures.put("Genre", "Persian Latin");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Triangle",triangleSongArtists,"unavailable","Persian Latin","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "triangle.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", triangleFeatures);

        Set<String>fromEasternSongArtists = new HashSet<String>();
        fromEasternSongArtists.add("Pallet");
        Map<String, String >fromEasternFeatures = new HashMap<String, String>();
        fromEasternFeatures.put("Genre", "Persian Slow Pop");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("From Eastern Lands",fromEasternSongArtists,"unavailable","Persian Slow Pop","Mr.Violet",commonFile.getInitsongpath() + commonFile.getSeparator() + "from-eastern-lands.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", fromEasternFeatures);

        Set<String>nagodireSongArtists = new HashSet<String>();
        nagodireSongArtists.add("Martik");
        Map<String, String >nagoDirehFeatures = new HashMap<String, String>();
        nagoDirehFeatures.put("Genre", "Persian Pop");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Nago Direh",nagodireSongArtists,"unavailable","Persian Pop","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "nago-direh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", nagoDirehFeatures);

        Set<String>baharSongArtists = new HashSet<String>();
        baharSongArtists.add("Martik");
        Map<String, String >baharFeatures = new HashMap<String, String>();
        baharFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Bahar",baharSongArtists,"Bahar bazam bia eshgho biaresh bede har yario daste negaresh","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "bahar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", baharFeatures);

        Set<String>aroosSongArtists = new HashSet<String>();
        aroosSongArtists.add("Martik");
        Map<String, String >aroosFeatures = new HashMap<String, String>();
        aroosFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Aroos",aroosSongArtists,"unavailable","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "aroos.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", aroosFeatures);

        Set<String>nazYarSongArtists = new HashSet<String>();
        nazYarSongArtists.add("Martik");
        Map<String, String >nazYarFeatures = new HashMap<String, String>();
        nazYarFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Naz Yar",nazYarSongArtists,"unavailable","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "nazyar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", nazYarFeatures);

        Set<String>zoleikhaSongArtists = new HashSet<String>();
        zoleikhaSongArtists.add("Martik");
        Map<String, String >zoleikhaFeatures = new HashMap<String, String>();
        zoleikhaFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Zoleikha",zoleikhaSongArtists,"unavailable","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "zoleikha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", zoleikhaFeatures);

        Set<String>taberSongArtists = new HashSet<String>();
        taberSongArtists.add("Martik");
        Map<String, String >taberFeatures = new HashMap<String, String>();
        taberFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Taber",taberSongArtists,"unavailable","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "taber.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", taberFeatures);

        Set<String>ashoftehSongArtists = new HashSet<String>();
        ashoftehSongArtists.add("Martik");
        Map<String, String >ashoftehFeatures = new HashMap<String, String>();
        ashoftehFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Ashofteh",ashoftehSongArtists,"unavailable","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "asshofteh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", ashoftehFeatures);

        Set<String>boroDivooneSongArtists = new HashSet<String>();
        boroDivooneSongArtists.add("Martik");
        Map<String, String >boroDivooneFeatures = new HashMap<String, String>();
        boroDivooneFeatures.put("Genre", "Persian 6/8 Dance");
        //hasratSongFeatures.put("Mood", "Happy");
        songServiceProvider.addNewSong("Boro Divoone",boroDivooneSongArtists,"unavailable","Persian 6/8 Dance","Bahar",commonFile.getInitsongpath() + commonFile.getSeparator() + "boro-divoone.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bahar.jpg", boroDivooneFeatures);

        Set<String>azMastKeBarMastSongArtists = new HashSet<String>();
        azMastKeBarMastSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >azMastKeBarMastFeatures = new HashMap<String, String>();
        azMastKeBarMastFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Az Mast Ke Bar Mast",azMastKeBarMastSongArtists,"unavailable","Persian Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "az-mast-ke-bar-mast.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", azMastKeBarMastFeatures);

        Set<String>afarangisSongArtists = new HashSet<String>();
        afarangisSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >farangisFeatures = new HashMap<String, String>();
        farangisFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Farangis",afarangisSongArtists,"unavailable","Persian Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "farangis.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", farangisFeatures);

        Set<String>sayehSongArtists = new HashSet<String>();
        sayehSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >sayehFeatures = new HashMap<String, String>();
        sayehFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Sayeh",sayehSongArtists,"unavailable","Persian Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "sayeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", sayehFeatures);

        Set<String>ghorbatSongArtists = new HashSet<String>();
        ghorbatSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >ghorbatFeatures = new HashMap<String, String>();
        ghorbatFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ghorbat",ghorbatSongArtists,"unavailable","Persian Slow Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ghorbat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", ghorbatFeatures);

        Set<String>peyvastegiSongArtists = new HashSet<String>();
        peyvastegiSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >peyvastegiFeatures = new HashMap<String, String>();
        peyvastegiFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Peyvastegi",peyvastegiSongArtists,"unavailable","Persian Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "peyvastegi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", peyvastegiFeatures);

        Set<String>hediehSongArtists = new HashSet<String>();
        hediehSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >hediehFeatures = new HashMap<String, String>();
        hediehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Hedieh",hediehSongArtists,"unavailable","Persian Slow Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "hedieh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", hediehFeatures);

        Set<String>azMastKeBarMastInsSongArtists = new HashSet<String>();
        azMastKeBarMastInsSongArtists.add("Siavash Ghomeyshi");
        Map<String, String >zMastKeBarMastInsFeatures = new HashMap<String, String>();
        zMastKeBarMastInsFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Az Mast Ke Bar Mast (Instrumental)",azMastKeBarMastInsSongArtists,"unavailable","Persian Pop","Khabe Baroon",commonFile.getInitsongpath() + commonFile.getSeparator() + "az-mast-ke-bar-mast(instrumental).mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", zMastKeBarMastInsFeatures);

        Set<String>toraDoostDaramSongArtists = new HashSet<String>();
        toraDoostDaramSongArtists.add("Farhad");
        Map<String, String >toraDoostDaramFeatures = new HashMap<String, String>();
        toraDoostDaramFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Tora Doost Daram",toraDoostDaramSongArtists,"unavailable","Persian Classic","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "tora-doost-daram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", toraDoostDaramFeatures);

        Set<String>khabDarBidariSongArtists = new HashSet<String>();
        khabDarBidariSongArtists.add("Farhad");
        Map<String, String >khabDarBidariFeatures = new HashMap<String, String>();
        khabDarBidariFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Khab Dar Bidari",khabDarBidariSongArtists,"unavailable","Persian Jazz","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "khab-dar-bidari.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", khabDarBidariFeatures);

        Set<String>khialeKhoshiSongArtists = new HashSet<String>();
        khialeKhoshiSongArtists.add("Farhad");
        Map<String, String >khialeKhoshiFeatures = new HashMap<String, String>();
        khialeKhoshiFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Khiale Khoshi",khialeKhoshiSongArtists,"unavailable","Persian Classic","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "khiale-khoshi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", khialeKhoshiFeatures);

        Set<String>gonjoshkakeashimashiSongArtists = new HashSet<String>();
        gonjoshkakeashimashiSongArtists.add("Farhad");
        Map<String, String >gonjeshkakAshiMashiFeatures = new HashMap<String, String>();
        gonjeshkakAshiMashiFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Gonjeshkake Ashi Mashi",gonjoshkakeashimashiSongArtists,"Gonjishkake Ashi Mashi labe boome ma nashin","Persian Jazz","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "gonjishkake-ashi-mashi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", gonjeshkakAshiMashiFeatures);

        Set<String>najvaSongArtists = new HashSet<String>();
        najvaSongArtists.add("Farhad");
        Map<String, String >najvaFeatures = new HashMap<String, String>();
        najvaFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Najva",najvaSongArtists,"Goftani ha kam nist mano to kam goftim","Persian Jazz","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "najva.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", najvaFeatures);

        Set<String>mardeTanhaSongArtists = new HashSet<String>();
        mardeTanhaSongArtists.add("Farhad");
        Map<String, String >mardeTanhaFeatures = new HashMap<String, String>();
        mardeTanhaFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Marde Tanha",mardeTanhaSongArtists,"Ba sedaye bi seda mese ye kooh boland","Persian Jazz","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "marde-tanha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", mardeTanhaFeatures);

        Set<String>kocheBanafshehaSongArtists = new HashSet<String>();
        kocheBanafshehaSongArtists.add("Farhad");
        Map<String, String >kocheBanafshehaFeatures = new HashMap<String, String>();
        kocheBanafshehaFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Kooche Banafsheha",kocheBanafshehaSongArtists,"Ey kash adami vatanash ra hamchoon banafsheha mishod ba khod bebarad har koja ke khast","Persian Jazz","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "koche-banafsheha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", kocheBanafshehaFeatures);

        Set<String>yesterdayWhenIwasYoungSongArtists = new HashSet<String>();
        yesterdayWhenIwasYoungSongArtists.add("Farhad");
        Map<String, String >yesterdayWhenIwasYoungFeatures = new HashMap<String, String>();
        yesterdayWhenIwasYoungFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Yesterday When I was Young",yesterdayWhenIwasYoungSongArtists,"unavailable","Persian Classic","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "yesterday-when-i-was-young.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", yesterdayWhenIwasYoungFeatures);

        Set<String>windMillsOfYourMindSongArtists = new HashSet<String>();
        windMillsOfYourMindSongArtists.add("Farhad");
        Map<String, String >windMillsOfYourMindsFeatures = new HashMap<String, String>();
        windMillsOfYourMindsFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Wind Mills of Your Mind",windMillsOfYourMindSongArtists,"unavailable","Persian Classic","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "windmills-of-your-minds.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", windMillsOfYourMindsFeatures);

        Set<String>unchainMelodySongArtists = new HashSet<String>();
        unchainMelodySongArtists.add("Farhad");
        Map<String, String >unchainMelodyFeatures = new HashMap<String, String>();
        unchainMelodyFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Unchained Melody",unchainMelodySongArtists,"unavailable","Persian Classic","Khab Dar Bidari",commonFile.getInitsongpath() + commonFile.getSeparator() + "unchain-melody.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", unchainMelodyFeatures);


        Set<String>mastiSongArtists = new HashSet<String>();
        mastiSongArtists.add("Hayedeh");
        Map<String, String >mastiFeatures = new HashMap<String, String>();
        mastiFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Masti",mastiSongArtists,"unavailable","Persian Contemporary Pop","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "masti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", mastiFeatures);

        Set<String>ashenaeiSongArtists = new HashSet<String>();
        ashenaeiSongArtists.add("Hayedeh");
        Map<String, String >ashenayiFeatures = new HashMap<String, String>();
        ashenayiFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Ashenaei",ashenaeiSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "ashenaei.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", ashenayiFeatures);

        Set<String>mesleGozashteSongArtists = new HashSet<String>();
        mesleGozashteSongArtists.add("Hayedeh");
        Map<String, String >mesleGozashteFeatures = new HashMap<String, String>();
        mesleGozashteFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Mesle Gozashteh",mesleGozashteSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "mesle-gozashte.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", mesleGozashteFeatures);

        Set<String>barayeToMimiramSongArtists = new HashSet<String>();
        barayeToMimiramSongArtists.add("Hayedeh");
        Map<String, String >barayeToMiiramFeatures = new HashMap<String, String>();
        barayeToMiiramFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Baraye To Mimiram",barayeToMimiramSongArtists,"unavailable","Persian Contemporary Pop","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "baraye-to-mimiram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", barayeToMiiramFeatures);

        Set<String>heifSongArtists = new HashSet<String>();
        heifSongArtists.add("Hayedeh");
        Map<String, String> heifFeatures = new HashMap<String, String>();
        heifFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Heif",heifSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "heif.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", heifFeatures);

        Set<String>atreOudSongArtists = new HashSet<String>();
        atreOudSongArtists.add("Hayedeh");
        Map<String, String> atreOudFeatures = new HashMap<String, String>();
        atreOudFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Atre Oud",atreOudSongArtists,"unavailable","Persian Contemporary Pop","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "atre-oud.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", atreOudFeatures);

        Set<String>ghalbeManSongArtists = new HashSet<String>();
        ghalbeManSongArtists.add("Hayedeh");
        Map<String, String> ghalbeManFeatures = new HashMap<String, String>();
        ghalbeManFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Ghalbe Man",ghalbeManSongArtists,"unavailable","Persian Contemporary Pop","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "ghalbe-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", ghalbeManFeatures);

        Set<String>azizTarinSongArtists = new HashSet<String>();
        azizTarinSongArtists.add("Hayedeh");
        Map<String, String> azizTarinFeatures = new HashMap<String, String>();
        azizTarinFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Aziztarin",azizTarinSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "aziztarin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", azizTarinFeatures);

        Set<String>dashtestaniSongArtists = new HashSet<String>();
        dashtestaniSongArtists.add("Hayedeh");
        Map<String, String>dashtestaniFeatures = new HashMap<String, String>();
        dashtestaniFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Dashtestani",dashtestaniSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "dashtestani.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", dashtestaniFeatures);

        Set<String>shirinJanSongArtists = new HashSet<String>();
        shirinJanSongArtists.add("Hayedeh");
        Map<String, String>shirinJanFeatures = new HashMap<String, String>();
        shirinJanFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Shirin Jan",shirinJanSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "shirin-jan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", shirinJanFeatures);

        Set<String>omadanetMahaleSongArtists = new HashSet<String>();
        omadanetMahaleSongArtists.add("Hayedeh");
        Map<String, String>omadanetMahaleFeatures = new HashMap<String, String>();
        omadanetMahaleFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Omadanet Mahale",omadanetMahaleSongArtists,"unavailable","Persian Folklore","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "omadanet-mahale.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", omadanetMahaleFeatures);

        Set<String>didarSongArtists = new HashSet<String>();
        didarSongArtists.add("Hayedeh");
        Map<String, String>didarFeatures = new HashMap<String, String>();
        didarFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Didar",didarSongArtists,"unavailable","Persian Contemporary Pop","Ashenaei",commonFile.getInitsongpath() + commonFile.getSeparator() + "didar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", didarFeatures);


        Set<String>nagooNemiamSongArtists = new HashSet<String>();
        nagooNemiamSongArtists.add("Hayedeh");
        Map<String, String>nagooNemiamFeatures = new HashMap<String, String>();
        nagooNemiamFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Nagoo Nemiam",nagooNemiamSongArtists,"unavailable","Persian Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "nagoo-nemiam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg", nagooNemiamFeatures);

        Set<String>afsanehHasstiSongArtists = new HashSet<String>();
        afsanehHasstiSongArtists.add("Hayedeh");
        Map<String, String>afsanehHastyFeatures = new HashMap<String, String>();
        afsanehHastyFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Afsaneye Hasti",afsanehHasstiSongArtists,"unavailable","Persian Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "afsaneh-hasti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg", afsanehHastyFeatures);

        Set<String>bezanTarSongArtists = new HashSet<String>();
        bezanTarSongArtists.add("Hayedeh");
        Map<String, String>bezanTarFeatures = new HashMap<String, String>();
        bezanTarFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Bezan Tar",bezanTarSongArtists,"unavailable","Persian Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "bezan-tar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg", bezanTarFeatures);

        Set<String>aroosakJoonSongArtists = new HashSet<String>();
        aroosakJoonSongArtists.add("Hayedeh");
        Map<String, String>aroosakJoonFeatures = new HashMap<String, String>();
        aroosakJoonFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Aroosak Joon",aroosakJoonSongArtists,"unavailable","Persian Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "aroosak-joon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg",aroosakJoonFeatures);

        Set<String>vafayeDelSongArtists = new HashSet<String>();
        vafayeDelSongArtists.add("Hayedeh");
        Map<String, String>vafayeDelFeatures = new HashMap<String, String>();
        vafayeDelFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Vafaye Del",vafayeDelSongArtists,"unavailable","Persian Folklore","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "vafaye-del.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg",vafayeDelFeatures);

        Set<String>saghiSongArtists = new HashSet<String>();
        saghiSongArtists.add("Hayedeh");
        Map<String, String>saghiFeatures = new HashMap<String, String>();
        saghiFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Saghi",saghiSongArtists,"unavailable","Persian Contemporary Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "saghi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg",saghiFeatures);

        Set<String>asalCheshmgArtists = new HashSet<String>();
        asalCheshmgArtists.add("Hayedeh");
        Map<String, String>asalCheshmFeatures = new HashMap<String, String>();
        asalCheshmFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Asal Cheshm",saghiSongArtists,"unavailable","Persian Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "asal-cheshm.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg",asalCheshmFeatures);

        Set<String>nemikhamArtists = new HashSet<String>();
        nemikhamArtists.add("Hayedeh");
        Map<String, String>nemikhamFeatures = new HashMap<String, String>();
        nemikhamFeatures.put("Genre", "Persian Contemporary Pop");
        songServiceProvider.addNewSong("Nemikham",nemikhamArtists,"unavailable","Persian Contemporary Pop","Bezan Tar",commonFile.getInitsongpath() + commonFile.getSeparator() + "nemikham.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg",nemikhamFeatures);

        Set<String>desireArtists = new HashSet<String>();
        desireArtists.add("Mohsen Chavoshi");
        Map<String, String>desireFeatures = new HashMap<String, String>();
        desireFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Desire",desireArtists,"unavailable","Persian Electronic","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "desire.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg", desireFeatures);

        Set<String>ghahvehGhajariArtists = new HashSet<String>();
        ghahvehGhajariArtists.add("Mohsen Chavoshi");
        Map<String, String>ghahvehyeGhajariFeatures = new HashMap<String, String>();
        ghahvehyeGhajariFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ghahveye Ghajari",ghahvehGhajariArtists,"unavailable","Persian Slow Pop","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ghahveye-ghajari.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg", ghahvehyeGhajariFeatures);

        Set<String>jozArtists = new HashSet<String>();
        jozArtists.add("Mohsen Chavoshi");
        Map<String, String>jozFeatures = new HashMap<String, String>();
        jozFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Joz",jozArtists,"unavailable","Persian Pop","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "joz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",jozFeatures);

        Set<String>kalanjarOrKodomArtists = new HashSet<String>();
        kalanjarOrKodomArtists.add("Mohsen Chavoshi");
        Map<String, String>kalanjarOrKodomFeatures = new HashMap<String, String>();
        kalanjarOrKodomFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Kalanjar Or Kodom",kalanjarOrKodomArtists,"unavailable","Persian Rock","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "kalanjar-or-komod.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",kalanjarOrKodomFeatures);

        Set<String>paroyeBiGhayeghArtists = new HashSet<String>();
        paroyeBiGhayeghArtists.add("Mohsen Chavoshi");
        Map<String, String>paroyeBiGhayeghFeatures = new HashMap<String, String>();
        paroyeBiGhayeghFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Paroye Bi Ghayegh",paroyeBiGhayeghArtists,"unavailable","Persian Rock","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",paroyeBiGhayeghFeatures);

        Set<String>tofangSarPorArtists = new HashSet<String>();
        tofangSarPorArtists.add("Mohsen Chavoshi");
        Map<String, String>tofangSarPorFeatures = new HashMap<String, String>();
        tofangSarPorFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Tofange Sar Pot",tofangSarPorArtists,"unavailable","Persian Rock","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "tofange-sar-por.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",tofangSarPorFeatures);

        Set<String>vasyatArtists = new HashSet<String>();
        vasyatArtists.add("Mohsen Chavoshi");
        Map<String, String>vasyatFeatures = new HashMap<String, String>();
        vasyatFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Vasyat",vasyatArtists,"unavailable","Persian Slow Pop","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "vasiyat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",vasyatFeatures);

        Set<String>khoneyeKochikArtists = new HashSet<String>();
        khoneyeKochikArtists.add("Mohsen Chavoshi");
        Map<String, String>khoneyeKochikFeatures = new HashMap<String, String>();
        khoneyeKochikFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khoneye Kochik",khoneyeKochikArtists,"unavailable","Persian Slow Pop","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ye-khooneye-kochik.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",khoneyeKochikFeatures);

        Set<String>yousefArtists = new HashSet<String>();
        yousefArtists.add("Mohsen Chavoshi");
        Map<String, String>yousefFeatures = new HashMap<String, String>();
        yousefFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Yousef",khoneyeKochikArtists,"unavailable","Persian Slow Pop","Paroye Bi Ghayegh",commonFile.getInitsongpath() + commonFile.getSeparator() + "yousef.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg",yousefFeatures);

        Set<String>asheghanehTanhastArtists = new HashSet<String>();
        asheghanehTanhastArtists.add("Chaartaar");
        Map<String, String>asheghanehTanhastFeatures = new HashMap<String, String>();
        asheghanehTanhastFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Asheghane Tanhasst",asheghanehTanhastArtists,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "asheghaaneh-tanhaast.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",asheghanehTanhastFeatures);

        Set<String>ashoobamArtists = new HashSet<String>();
        ashoobamArtists.add("Chaartaar");
        Map<String, String>ashoobamFeatures = new HashMap<String, String>();
        ashoobamFeatures.put("Genre", "Persian Trance");
        songServiceProvider.addNewSong("Ashoobam",ashoobamArtists,"unavailable","Persian Trance","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "ashoobam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",ashoobamFeatures);

        Set<String>baranToyiArtists = new HashSet<String>();
        baranToyiArtists.add("Chaartaar");
        Map<String, String>baranToyiFeatures = new HashMap<String, String>();
        baranToyiFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Baran Toyi",baranToyiArtists,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "baran-toe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg", baranToyiFeatures);

        Set<String>darHasrateMahArtists = new HashSet<String>();
        darHasrateMahArtists.add("Chaartaar");
        Map<String, String>darHasrateMahFeatures = new HashMap<String, String>();
        darHasrateMahFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Dar Hasrate Mah",darHasrateMahArtists,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "dar-hasrate-mah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",darHasrateMahFeatures);

        Set<String>ghatarArtists = new HashSet<String>();
        ghatarArtists .add("Chaartaar");
        Map<String, String>ghatarFeatures = new HashMap<String, String>();
        ghatarFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Ghatar",ghatarArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "ghatar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",ghatarFeatures);

        Set<String>harfiBezanArtists = new HashSet<String>();
        harfiBezanArtists .add("Chaartaar");
        Map<String, String>harfiBezanFeatures = new HashMap<String, String>();
        harfiBezanFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Harfi Bezan",harfiBezanArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "harfi-bezan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",harfiBezanFeatures);

        Set<String>hendesehArtists = new HashSet<String>();
        hendesehArtists .add("Chaartaar");
        Map<String, String>hendesehFeatures = new HashMap<String, String>();
        hendesehFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Hendeseh",hendesehArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "hendeseh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",hendesehFeatures);


        Set<String>kalaghArtists = new HashSet<String>();
        kalaghArtists .add("Chaartaar");
        Map<String, String>kalaghFeatures = new HashMap<String, String>();
        kalaghFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Kalagh",kalaghArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kalagh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",kalaghFeatures);

        Set<String>khoshaBeManArtists = new HashSet<String>();
        khoshaBeManArtists .add("Chaartaar");
        Map<String, String>khoshaBeManFeatures = new HashMap<String, String>();
        khoshaBeManFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Khosha Be Man",khoshaBeManArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "khosha-be-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",khoshaBeManFeatures);

        Set<String>maraBeKhateratNegahDarArtists = new HashSet<String>();
        maraBeKhateratNegahDarArtists .add("Chaartaar");
        Map<String, String>maraBeKhateratNegahDarFeatures = new HashMap<String, String>();
        maraBeKhateratNegahDarFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Mara Be Khaterat Negah Dar",maraBeKhateratNegahDarArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "mara-be-khaterat-negah-dar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",maraBeKhateratNegahDarFeatures);

        Set<String>shabiheYekMordabArtists = new HashSet<String>();
        shabiheYekMordabArtists .add("Chaartaar");
        Map<String, String>shabiheYekMordabFeatures = new HashMap<String, String>();
        shabiheYekMordabFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Shabiheh Yek Mordab",shabiheYekMordabArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "shabihe-yek-mordab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",shabiheYekMordabFeatures);

        Set<String>zaneDivanehArtists = new HashSet<String>();
        zaneDivanehArtists .add("Chaartaar");
        Map<String, String>zaneDivaneFeatures = new HashMap<String, String>();
        zaneDivaneFeatures.put("Genre", "Persian Trance");
        songServiceProvider.addNewSong("Zane Divaneh",zaneDivanehArtists ,"unavailable","Persian Fusion","Baran Toyi",commonFile.getInitsongpath() + commonFile.getSeparator() + "zane-divaneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg",zaneDivaneFeatures);


        Set<String>toloKonArtists = new HashSet<String>();
        toloKonArtists.add("Ebi");
        Map<String, String>toloKonFeatures = new HashMap<String, String>();
        toloKonFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Tolo Kon",toloKonArtists ,"Tolo kon tolo kon dar in setareh mordegi","Persian Pop","Tolo Kon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/tolo-kon/tolo-kon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg",toloKonFeatures);

        Set<String>halaArtists = new HashSet<String>();
        halaArtists.add("Ebi");
        Map<String, String>halaFeatures = new HashMap<String, String>();
        halaFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Hala",halaArtists ,"Tolo kon tolo kon dar in setareh mordegi","Persian Pop","Tolo Kon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/tolo-kon/hala.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg",halaFeatures);

        Set<String>beshkanArtists = new HashSet<String>();
        beshkanArtists.add("Ebi");
        Map<String, String>beshkanFeatures = new HashMap<String, String>();
        beshkanFeatures.put("Genre", "Persian Pop Dance");
        songServiceProvider.addNewSong("Beshkan",beshkanArtists ,"Beshkan bashe mishkanam","Persian Pop Dance","Tolo Kon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/tolo-kon/beshkan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg",beshkanFeatures);

        Set<String>toraNegahMikonamArtists = new HashSet<String>();
        toraNegahMikonamArtists.add("Ebi");
        Map<String, String>toraNegahMikonamFeatures = new HashMap<String, String>();
        toraNegahMikonamFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("To ra Negah Mikonam",toraNegahMikonamArtists ,"To ra negah mikonam ke khofteyi kenare man","Persian Slow Pop","Tolo Kon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/tolo-kon/to-ra-negah-mikonam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg",toraNegahMikonamFeatures);

        Set<String>booseBarMahArtists = new HashSet<String>();
        booseBarMahArtists.add("Ebi");
        Map<String, String>booseBarMahFeatures = new HashMap<String, String>();
        booseBarMahFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Boose Bar Mah",booseBarMahArtists ,"unavailable","Persian Slow Pop","Tolo Kon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/tolo-kon/booseh-bar-mah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg",booseBarMahFeatures);

        Set<String>manAzToYadGereftamArtists = new HashSet<String>();
        manAzToYadGereftamArtists.add("Ebi");
        Map<String, String>manAzToYadGereftamFeatures = new HashMap<String, String>();
        manAzToYadGereftamFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Man Az To Yad Gereftam",manAzToYadGereftamArtists ,"unavailable","Persian Latin","Tolo Kon",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/tolo-kon/man-az-to-yad-gereftam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg",manAzToYadGereftamFeatures);

        Set<String>mohtajArtists = new HashSet<String>();
        mohtajArtists.add("Ebi");
        Map<String, String>mohtajFeatures = new HashMap<String, String>();
        mohtajFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Mohtaj",mohtajArtists ,"Ta ayene raftam ke begiram khabar az to","Persian Slow Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/mohtaj.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",mohtajFeatures);

        Set<String>tekiyeBarBadArtists = new HashSet<String>();
        tekiyeBarBadArtists.add("Dariush");
        Map<String, String>tekiyeBarBadFeatures = new HashMap<String, String>();
        tekiyeBarBadFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Tekiye Bar Bad",tekiyeBarBadArtists ,"Be khialam ke too donya vase to aziztarinam","Persian Slow Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/tekyeh-bar-bad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",tekiyeBarBadFeatures);

        Set<String>setarehDonbalehDarArtists = new HashSet<String>();
        setarehDonbalehDarArtists.add("Ebi");
        Map<String, String>setarehDonbalehDarFeatures = new HashMap<String, String>();
        setarehDonbalehDarFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Setareh Donbaleh Dar",tekiyeBarBadArtists ,"Too asemoone zendegim setareh boode bi shomar","Persian Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/setareh-donbaleh-dar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",setarehDonbalehDarFeatures);

        Set<String>nistiArtists = new HashSet<String>();
        nistiArtists.add("Dariush");
        Map<String, String>nistiFeatures = new HashMap<String, String>();
        nistiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Nisti",nistiArtists ,"unavailable","Persian Slow Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/nisti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",nistiFeatures);

        Set<String>gharibehArtists = new HashSet<String>();
        gharibehArtists.add("Ebi");
        Map<String, String>gharibehFeatures = new HashMap<String, String>();
        gharibehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gharibeh",gharibehArtists ,"Gharibeh ay Gharibeh Ay gharibeh chaghad cheshmaye to ashegh faribe","Persian Slow Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/gharibeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",gharibehFeatures);

        Set<String>mardomeDonyaArtists = new HashSet<String>();
        mardomeDonyaArtists.add("Dariush");
        Map<String, String>mardomeDonyaFeatures = new HashMap<String, String>();
        mardomeDonyaFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Mardome Donya",mardomeDonyaArtists ,"Ahay mardom e donya gele daram gele daram","Persian Slow Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/mardomeh-donya.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",mardomeDonyaFeatures);

        Set<String>hezaroYekShabArtists = new HashSet<String>();
        hezaroYekShabArtists.add("Ebi");
        Map<String, String>hezaroYekShabFeatures = new HashMap<String, String>();
        hezaroYekShabFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Hezaro Yek Shab",hezaroYekShabArtists ,"Agarche Jaye del daryaye khoon dar sineh daram","Persian Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/hezar-o-yek-shab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",hezaroYekShabFeatures);

        Set<String>ayenehArtists = new HashSet<String>();
        ayenehArtists.add("Dariush");
        Map<String, String>ayenehFeatures = new HashMap<String, String>();
        ayenehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ayeneh",ayenehArtists ,"Roo mikonam be ayeneh roo be khodam dad mizanam","Persian Slow Pop","Mohtaj",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/mohtaj/ayneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mohtaj.jpg",ayenehFeatures);

        Set<String>afsanehArtists = new HashSet<String>();
        afsanehArtists.add("Marjan Farsad");
        Map<String, String>afsanehFeatures = new HashMap<String, String>();
        afsanehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Afsaneh",afsanehArtists ,"Unavailable","Persian Slow Pop","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/afsaneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",afsanehFeatures);

        Set<String>cheshmayeTameshkiArtists = new HashSet<String>();
        cheshmayeTameshkiArtists.add("Marjan Farsad");
        Map<String, String>cheshmayeTameshkiFeatures = new HashMap<String, String>();
        cheshmayeTameshkiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Cheshmhaye Tameshki",cheshmayeTameshkiArtists ,"Unavailable","Persian Slow Pop","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/cheshmhaye-tameshki.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",cheshmayeTameshkiFeatures);

        Set<String>dishabArtists = new HashSet<String>();
        dishabArtists.add("Marjan Farsad");
        Map<String, String>dishabFeatures = new HashMap<String, String>();
        dishabFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Dishab",dishabArtists ,"Unavailable","Persian Latin","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/dishab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",dishabFeatures);

        Set<String>golhayeAbiArtists = new HashSet<String>();
        golhayeAbiArtists.add("Marjan Farsad");
        Map<String, String>golhayeAbiFeatures = new HashMap<String, String>();
        golhayeAbiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Golhaye Abi",golhayeAbiArtists ,"Unavailable","Persian Slow Pop","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/golhaye-abi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",golhayeAbiFeatures);

        Set<String>khoneyeMaArtists = new HashSet<String>();
        khoneyeMaArtists.add("Marjan Farsad");
        Map<String, String>khoneyeMaFeatures = new HashMap<String, String>();
        khoneyeMaFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Khooneye MA",khoneyeMaArtists ,"Unavailable","Persian Jazz","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/khooneye-ma.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",khoneyeMaFeatures);

        Set<String>porteghaleManArtists = new HashSet<String>();
        porteghaleManArtists.add("Marjan Farsad");
        Map<String, String>porteghaleManFeatures = new HashMap<String, String>();
        porteghaleManFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Porteghal e Man",porteghaleManArtists ,"Unavailable","Persian Fusion","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/porteghale-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",porteghaleManFeatures);

        Set<String>royahaArtists = new HashSet<String>();
        royahaArtists.add("Marjan Farsad");
        Map<String, String>royahaFeatures = new HashMap<String, String>();
        royahaFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Royaha",royahaArtists ,"Unavailable","Persian Slow Pop","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/royaha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",royahaFeatures);

        Set<String>setareyeSohielArtists = new HashSet<String>();
        setareyeSohielArtists.add("Marjan Farsad");
        Map<String, String>setareyeSoheilFeatures = new HashMap<String, String>();
        setareyeSoheilFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Setareye Soheil",setareyeSohielArtists ,"Unavailable","Persian Fusion","Blue Flowers",commonFile.getInitsongpath() + commonFile.getSeparator() + "marjan-farsad/blue-flowers/setareye-soheil.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg",setareyeSoheilFeatures);

        Set<String>MoghadameArtists = new HashSet<String>();
        MoghadameArtists.add("Erfan");
        Map<String, String>moghadameFeatures = new HashMap<String, String>();
        moghadameFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Moghadame",MoghadameArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/moghadameh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",moghadameFeatures);

        Set<String>khateManArtists = new HashSet<String>();
        khateManArtists.add("Erfan");
        Map<String, String>khateManFeatures = new HashMap<String, String>();
        khateManFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Khate Man",khateManArtists ,"Unavailable","Persian Hip-Hop","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/khate-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",khateManFeatures);

        Set<String>sadGhasamArtists = new HashSet<String>();
        sadGhasamArtists.add("Erfan");
        Map<String, String>sadGhashamFeatures = new HashMap<String, String>();
        sadGhashamFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Sad Ghasam",sadGhasamArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/sad-ghasam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",sadGhashamFeatures);

        Set<String>jaddehArtists = new HashSet<String>();
        jaddehArtists.add("Erfan");
        Map<String, String>jaddehFeatures = new HashMap<String, String>();
        jaddehFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Jaddeh",jaddehArtists ,"Unavailable","Persian Hip-Hop","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/jaddeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",jaddehFeatures);

        Set<String>mayehArtists = new HashSet<String>();
        mayehArtists.add("Erfan");
        Map<String, String>mayehFeatures = new HashMap<String, String>();
        mayehFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Mayeh",mayehArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/mayeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",mayehFeatures);

        Set<String>emshabArtists = new HashSet<String>();
        emshabArtists.add("Erfan");
        Map<String, String>emshabFeatures = new HashMap<String, String>();
        emshabFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Emshab",emshabArtists ,"Unavailable","Persian Hip-Hop","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/emshab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",emshabFeatures);

        Set<String>biaBiaArtists = new HashSet<String>();
        biaBiaArtists.add("Erfan");
        Map<String, String>biaBiaFeatures = new HashMap<String, String>();
        biaBiaFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Bia Bia",biaBiaArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/bia-bia.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",biaBiaFeatures);

        Set<String>koorArtists = new HashSet<String>();
        koorArtists.add("Erfan");
        Map<String, String>koorFeatures = new HashMap<String, String>();
        koorFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Koor",koorArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/koor.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",koorFeatures);

        Set<String>jodaArtists = new HashSet<String>();
        jodaArtists.add("Erfan");
        Map<String, String>jodaFeatures = new HashMap<String, String>();
        jodaFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Joda",jodaArtists ,"Unavailable","Persian Hip-Hop","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/joda.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",jodaFeatures);

        Set<String>bezaBeganArtists = new HashSet<String>();
        bezaBeganArtists.add("Erfan");
        Map<String, String>bezaBeganFeatures = new HashMap<String, String>();
        bezaBeganFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Beza Began",bezaBeganArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/bezar-began.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",bezaBeganFeatures);

        Set<String>jazebeArtists = new HashSet<String>();
        jazebeArtists.add("Erfan");
        Map<String, String>jazebeFeatures = new HashMap<String, String>();
        jazebeFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Jazebe",jazebeArtists ,"Unavailable","Persian Rap","Az Khane Ta Goor",commonFile.getInitsongpath() + commonFile.getSeparator() + "erfan/az-khaneh-ta-goor/jazebeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg",jazebeFeatures);

        Set<String>ghahvehArtists = new HashSet<String>();
        ghahvehArtists.add("Benyamin");
        Map<String, String>ghahveFeatures = new HashMap<String, String>();
        ghahveFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Ghahve",ghahvehArtists ,"Unavailable","Persian Electronic","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/ghahve.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",ghahveFeatures);

        Set<String>jadoogareGisooArtists = new HashSet<String>();
        jadoogareGisooArtists.add("Benyamin");
        Map<String, String>jadoogareGisooFeatures = new HashMap<String, String>();
        jadoogareGisooFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Jadoogare Gisoo",jadoogareGisooArtists ,"Unavailable","Persian Slow Pop","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/jadoogare-gisoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",jadoogareGisooFeatures);

        Set<String>madarArtists = new HashSet<String>();
        madarArtists.add("Benyamin");
        Map<String, String>madarFeatures = new HashMap<String, String>();
        madarFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Maadar",madarArtists ,"Unavailable","Persian Electronic","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/maadar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",madarFeatures);

        Set<String>dobarehCheshatArtists = new HashSet<String>();
        dobarehCheshatArtists.add("Benyamin");
        Map<String, String>dobarehCheshatFeatures = new HashMap<String, String>();
        dobarehCheshatFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Dobareh Cheshat",dobarehCheshatArtists ,"Unavailable","Persian Pop","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/dobareh-cheshmat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",dobarehCheshatFeatures);

        Set<String>hafteyeEshghArtists = new HashSet<String>();
        hafteyeEshghArtists.add("Benyamin");
        Map<String, String>hafteyeEshghFeatures = new HashMap<String, String>();
        hafteyeEshghFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Hafteye Eshgh",hafteyeEshghArtists ,"Unavailable","Persian Electronic","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/hafte-eshgh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",hafteyeEshghFeatures);

        Set<String>dastNegahDarArtists = new HashSet<String>();
        dastNegahDarArtists.add("Benyamin");
        Map<String, String>dastNegahDarFeatures = new HashMap<String, String>();
        dastNegahDarFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Dast Negah Dar",dastNegahDarArtists ,"Unavailable","Persian Slow Pop","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/dast-negah-dar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",dastNegahDarFeatures);

        Set<String>eshgheDagheManArtists = new HashSet<String>();
        eshgheDagheManArtists.add("Benyamin");
        Map<String, String>eshgheDagheManFeatures = new HashMap<String, String>();
        eshgheDagheManFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Eshghe Daghe Man",eshgheDagheManArtists ,"Unavailable","Persian Electronic","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/eshghe-dasghe-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",eshgheDagheManFeatures);

        Set<String>yeKhooneArtists = new HashSet<String>();
        yeKhooneArtists.add("Benyamin");
        Map<String, String>yeKhooneFeatures = new HashMap<String, String>();
        yeKhooneFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ye Khoone",yeKhooneArtists ,"Unavailable","Persian Slow Pop","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/ye-khooneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",yeKhooneFeatures);

        Set<String>faghatShabiheKhodetiArtists = new HashSet<String>();
        faghatShabiheKhodetiArtists.add("Benyamin");
        Map<String, String>faghatShabiheKhodetiFeatures = new HashMap<String, String>();
        faghatShabiheKhodetiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Faghat Shabihe Khodeti",faghatShabiheKhodetiArtists ,"Unavailable","Persian Electronic","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/faghat-shabihe-khodeti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",faghatShabiheKhodetiFeatures);

        Set<String>goleYas2Artists = new HashSet<String>();
        goleYas2Artists.add("Benyamin");
        Map<String, String>goleYas2Features = new HashMap<String, String>();
        goleYas2Features.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gole Yas 2",goleYas2Artists ,"Unavailable","Persian Slow Pop","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/gole-yas-2.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",goleYas2Features);

        Set<String>eshghDarRoozeGhiamatArtists = new HashSet<String>();
        eshghDarRoozeGhiamatArtists.add("Benyamin");
        Map<String, String>eshghDarRoozeGhiamatFeatures = new HashMap<String, String>();
        eshghDarRoozeGhiamatFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Eshgh Dar Rooze Ghiyamat",eshghDarRoozeGhiamatArtists ,"Unavailable","Persian Electronic","Benyamin 93",commonFile.getInitsongpath() + commonFile.getSeparator() + "benyamin/benyamin-93/eshgh-dar-rooze-ghiyamat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "benyamin93.jpg",eshghDarRoozeGhiamatFeatures);

        Set<String>cheraRaftyArtists = new HashSet<String>();
        cheraRaftyArtists.add("Homayoun Shajarian");
        Map<String, String>cheraRaftyFeatures = new HashMap<String, String>();
        cheraRaftyFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Chera Rafty",cheraRaftyArtists ,"Unavailable","Persian Fusion","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/chera-rafti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",cheraRaftyFeatures);

        Set<String>darooneAyenehArtists = new HashSet<String>();
        darooneAyenehArtists.add("Homayoun Shajarian");
        Map<String, String>darooneAyenehFeatures = new HashMap<String, String>();
        darooneAyenehFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Daroone Ayeneh",darooneAyenehArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/daroone-ayeneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",darooneAyenehFeatures);

        Set<String>delBeDelArtists = new HashSet<String>();
        delBeDelArtists.add("Homayoun Shajarian");
        Map<String, String>delBeDelFeatures = new HashMap<String, String>();
        delBeDelFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Del Be Del",delBeDelArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/del-be-del.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",delBeDelFeatures);

        Set<String>shajarianKuliArtists = new HashSet<String>();
        shajarianKuliArtists.add("Homayoun Shajarian");
        Map<String, String>shajarianKuliFeatures = new HashMap<String, String>();
        shajarianKuliFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Shajarian Kuli",shajarianKuliArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/shajarian-kouli.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",shajarianKuliFeatures);

        Set<String>hameHichamArtists = new HashSet<String>();
        hameHichamArtists.add("Homayoun Shajarian");
        Map<String, String>hameHichamFeatures = new HashMap<String, String>();
        hameHichamFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Hame Hicham",hameHichamArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/hame-hicham.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",hameHichamFeatures);

        Set<String>choouniBiManArtists = new HashSet<String>();
        choouniBiManArtists.add("Homayoun Shajarian");
        Map<String, String>choouniBiManFeatures = new HashMap<String, String>();
        choouniBiManFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Chouni Bi Man",choouniBiManArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/chouni-bi-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",choouniBiManFeatures);

        Set<String>shatakArtists = new HashSet<String>();
       shatakArtists.add("Homayoun Shajarian");
        Map<String, String>shatakFeatures = new HashMap<String, String>();
        shatakFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Shatak",shatakArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/shatak.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",shatakFeatures);

        Set<String>darHesareShabArtists = new HashSet<String>();
        darHesareShabArtists.add("Homayoun Shajarian");
        Map<String, String>darHesareShabFeatures = new HashMap<String, String>();
        darHesareShabFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Dar hesare Shab",darHesareShabArtists ,"Unavailable","Persian Traditional","Na Fereshteam Na Sheytan",commonFile.getInitsongpath() + commonFile.getSeparator() + "homayoun-shajarian/na-fereshteam-na-sheytan/dar-hesare-shab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg",darHesareShabFeatures);

         // >>>
        Set<String>roozhayeKootahArtists = new HashSet<String>();
        roozhayeKootahArtists.add("Kiosk");
        Map<String, String>roozhayeKootahFeatures = new HashMap<String, String>();
        roozhayeKootahFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Roozhaye Kootah",roozhayeKootahArtists ,"Unavailable","Persian Rock","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/roozhaye-kootah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",roozhayeKootahFeatures);

        Set<String>mamnooeArtists = new HashSet<String>();
        mamnooeArtists.add("Kiosk");
        Map<String, String>mamnooeFeatures = new HashMap<String, String>();
        mamnooeFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Mamnooe",mamnooeArtists ,"Unavailable","Persian Rock","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/mamnooe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",mamnooeFeatures);

        Set<String>varDarBiarArtists = new HashSet<String>();
        varDarBiarArtists.add("Kiosk");
        Map<String, String>varDarBiarFeatures = new HashMap<String, String>();
        varDarBiarFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Var Dar Biar",varDarBiarArtists ,"Unavailable","Persian Rock","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/varda-biar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",varDarBiarFeatures);

        Set<String>faslArtists = new HashSet<String>();
        faslArtists.add("Kiosk");
        Map<String, String>faslFeatures = new HashMap<String, String>();
        faslFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Fasl",faslArtists ,"Unavailable","Persian Rock","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/fasl.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",faslFeatures);

        Set<String>ounoNadidiArtists = new HashSet<String>();
        ounoNadidiArtists.add("Kiosk");
        Map<String, String>ounoNadidiFeatures = new HashMap<String, String>();
        ounoNadidiFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Oono Nadidi",ounoNadidiArtists ,"Unavailable","Persian Fusion","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/oono-nadidi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",ounoNadidiFeatures);

        Set<String>rahaeArtists = new HashSet<String>();
        rahaeArtists.add("Kiosk");
        Map<String, String>rahaeFeatures = new HashMap<String, String>();
        rahaeFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Rahae",rahaeArtists ,"Unavailable","Persian Slow Pop","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/rahaee.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",rahaeFeatures);

        Set<String>mottahamArtists = new HashSet<String>();
        mottahamArtists.add("Kiosk");
        Map<String, String>mottahamFeatures = new HashMap<String, String>();
        mottahamFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Mottaham",mottahamArtists ,"Unavailable","Persian Latin","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/mottaham.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",mottahamFeatures);

        Set<String>tashkilatMovaziArtists = new HashSet<String>();
        tashkilatMovaziArtists.add("Kiosk");
        Map<String, String>tashkilatMovaziFeatures = new HashMap<String, String>();
        tashkilatMovaziFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Tashkilate Movazi",tashkilatMovaziArtists ,"Unavailable","Persian Rock","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/tashkilate-movazi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",tashkilatMovaziFeatures);

        Set<String>toKenistyArtists = new HashSet<String>();
        toKenistyArtists.add("Kiosk");
        Map<String, String>toKeNistyFeatures = new HashMap<String, String>();
        toKeNistyFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("To Ke Nisti",toKenistyArtists ,"Unavailable","Persian Fusion","Tashkilate Movazi",commonFile.getInitsongpath() + commonFile.getSeparator() + "kiosk/tashkilate-movazi/to-ke-nisti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg",toKeNistyFeatures);

        Set<String>naNaroArtists = new HashSet<String>();
        naNaroArtists.add("Sirvan");
        Map<String, String>naNaroFeatures = new HashMap<String, String>();
        naNaroFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Na Naro",naNaroArtists ,"Unavailable","Persian Electronic","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/na-naro.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",naNaroFeatures);

        Set<String>inamMigzareArtists = new HashSet<String>();
        inamMigzareArtists.add("Sirvan");
        Map<String, String>inamMigzareFeatures = new HashMap<String, String>();
        inamMigzareFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Inam Migzare",inamMigzareArtists ,"Unavailable","Persian Electronic","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/inam-migzare.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",inamMigzareFeatures);

        Set<String>bighararArtists = new HashSet<String>();
        bighararArtists.add("Sirvan");
        Map<String, String>bighararFeatures = new HashMap<String, String>();
        bighararFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Bigharar",bighararArtists ,"Unavailable","Persian Slow Pop","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/bigharar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",bighararFeatures);

        Set<String>rozayeRoyayiArtists = new HashSet<String>();
        rozayeRoyayiArtists.add("Sirvan");
        Map<String, String>roozayeRoyayiFeatures = new HashMap<String, String>();
        roozayeRoyayiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Roozaye Royayi",rozayeRoyayiArtists ,"Unavailable","Persian Electronic","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/roozaye-royayi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",roozayeRoyayiFeatures);

        Set<String>doosetDaramArtists = new HashSet<String>();
        doosetDaramArtists.add("Sirvan");
        Map<String, String>doosetDaramFeatures = new HashMap<String, String>();
        doosetDaramFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Dooset Daram",doosetDaramArtists ,"Unavailable","Persian Slow Pop","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/dooset-daram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",doosetDaramFeatures);

        Set<String>jaadehSirvanArtists = new HashSet<String>();
        jaadehSirvanArtists.add("Sirvan");
        Map<String, String>jaadehSirvanFeatures = new HashMap<String, String>();
        jaadehSirvanFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Jaadeh",jaadehSirvanArtists ,"Unavailable","Persian Electronic","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/jaadeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",jaadehSirvanFeatures);

        Set<String>ageToMaleManNistyArtists = new HashSet<String>();
        ageToMaleManNistyArtists.add("Sirvan");
        Map<String, String>ageToMaleManNistyFeatures = new HashMap<String, String>();
        ageToMaleManNistyFeatures.put("Genre", "Persian 6/8 Club");
        songServiceProvider.addNewSong("Age To Male Man Nisti",ageToMaleManNistyArtists ,"Unavailable","Persian 6/8 Club","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/age-to-male-man-nisti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",ageToMaleManNistyFeatures);

        Set<String>baroonPayiziArtists = new HashSet<String>();
        baroonPayiziArtists.add("Sirvan");
        Map<String, String>baroonePayiziFeatures = new HashMap<String, String>();
        baroonePayiziFeatures.put("Genre", "Persian Trance");
        songServiceProvider.addNewSong("Baroone Payizi",baroonPayiziArtists ,"Unavailable","Persian Trance","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/baroone-payizi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",baroonePayiziFeatures);

        Set<String>akharinRoozArtists = new HashSet<String>();
        akharinRoozArtists.add("Sirvan");
        Map<String, String>akharinRoozFeatures = new HashMap<String, String>();
        akharinRoozFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Akharin Rooz",akharinRoozArtists ,"Unavailable","Persian Latin","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/akharin-rooz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",akharinRoozFeatures);

    return null;
    }
}
