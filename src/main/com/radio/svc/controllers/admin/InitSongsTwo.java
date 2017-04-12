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
public class InitSongsTwo extends AbstractController {
    
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
    
Set<String>manAsheghetShodamArtists = new HashSet<String>();
        manAsheghetShodamArtists.add("Sirvan");
        Map<String, String>manAsheghetShodamFeatures = new HashMap<String, String>();
        manAsheghetShodamFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Man Asheghet Shodam",manAsheghetShodamArtists ,"Unavailable","Persian Slow Pop","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/man-asheghet-shodam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",manAsheghetShodamFeatures);

        Set<String>khodafeziArtists = new HashSet<String>();
        khodafeziArtists.add("Sirvan");
        Map<String, String>khodafeziFeatures = new HashMap<String, String>();
        khodafeziFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khodafezi",khodafeziArtists ,"Unavailable","Persian Slow Pop","The Road of Dreams",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/road-of-dreams/khodafezi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg",khodafeziFeatures);

        Set<String>ahKeIntoArtists = new HashSet<String>();
        ahKeIntoArtists.add("Mohsen Namjoo");
        Map<String, String>ahKeintorFeatures = new HashMap<String, String>();
        ahKeintorFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Ah Ke Intor",ahKeIntoArtists ,"Unavailable","Persian Rock","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/ah-ke-intor.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",ahKeintorFeatures);

        Set<String>biabanArtists = new HashSet<String>();
        biabanArtists.add("Mohsen Namjoo");
        Map<String, String>biabanFeatures = new HashMap<String, String>();
        biabanFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Biaban",biabanArtists ,"Unavailable","Persian Rock","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/biaban.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",biabanFeatures);

        Set<String>buddahArtists = new HashSet<String>();
        buddahArtists.add("Mohsen Namjoo");
        Map<String, String>buddahFeatures = new HashMap<String, String>();
        buddahFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Buddah",buddahArtists ,"Unavailable","Persian Traditional","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/buddah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",buddahFeatures);

        Set<String>eyKashArtists = new HashSet<String>();
        eyKashArtists.add("Mohsen Namjoo");
        Map<String, String>eyKashFeatures = new HashMap<String, String>();
        eyKashFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Ey Kash",eyKashArtists ,"Unavailable","Persian Fusion","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/ey-kash.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",eyKashFeatures);

        Set<String>jabrArtists = new HashSet<String>();
        jabrArtists.add("Mohsen Namjoo");
        Map<String, String>jabrFeatures = new HashMap<String, String>();
        jabrFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Jabr",jabrArtists ,"Unavailable","Persian Rock","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/jabr.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",jabrFeatures);

        Set<String>morgheSheydaArtists = new HashSet<String>();
        morgheSheydaArtists.add("Mohsen Namjoo");
        Map<String, String>morgheSheydaFeatures = new HashMap<String, String>();
        morgheSheydaFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Morghe Sheyda",morgheSheydaArtists ,"Unavailable","Persian Rock","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/morghe-sheyda.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",morgheSheydaFeatures);

        Set<String>shirinShirinamArtists = new HashSet<String>();
        shirinShirinamArtists.add("Mohsen Namjoo");
        Map<String, String>shirinShirinamFeatures = new HashMap<String, String>();
        shirinShirinamFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Shirin",shirinShirinamArtists ,"Unavailable","Persian Fusion","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/shirin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",shirinShirinamFeatures);

        Set<String>simeBandArtists = new HashSet<String>();
        simeBandArtists.add("Mohsen Namjoo");
        Map<String, String>simeBandFeatures = new HashMap<String, String>();
        simeBandFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Sime Band",simeBandArtists ,"Unavailable","Persian Fusion","Jabre Joghrafiae",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/jabre-joghrafiaie/sim-e-band.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg",simeBandFeatures);

        Set<String>deltangtardArtists = new HashSet<String>();
        deltangtardArtists.add("Traffic Band");
        Map<String, String>deltangtarFeatures = new HashMap<String, String>();
        deltangtarFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Deltang Tar",deltangtardArtists ,"Unavailable","Persian Electronic","Traffic",commonFile.getInitsongpath() + commonFile.getSeparator() + "traffic-band/traffic/deltang-tar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "traffic.jpg",deltangtarFeatures);

        Set<String>biraheArtists = new HashSet<String>();
        biraheArtists.add("Traffic Band");
        Map<String, String>biraheFeatures = new HashMap<String, String>();
        biraheFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Bi Rahe",biraheArtists ,"Unavailable","Persian Electronic","Traffic",commonFile.getInitsongpath() + commonFile.getSeparator() + "traffic-band/traffic/bi-rahe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "traffic.jpg",biraheFeatures);

        Set<String>gheseyeDokhtaroKhiaboonArtists = new HashSet<String>();
        gheseyeDokhtaroKhiaboonArtists.add("Traffic Band");
        Map<String, String>gheseyeDokhtaroKhiaboonFeatures = new HashMap<String, String>();
        gheseyeDokhtaroKhiaboonFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Gheseye Dokhtaro Khiaboon",gheseyeDokhtaroKhiaboonArtists ,"Unavailable","Persian Electronic","Traffic",commonFile.getInitsongpath() + commonFile.getSeparator() + "traffic-band/traffic/ghesse-dokhtaro-khiaboon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "traffic.jpg",gheseyeDokhtaroKhiaboonFeatures);

        Set<String>trafficArtists = new HashSet<String>();
        trafficArtists.add("Traffic Band");
        Map<String, String>trafficFeatures = new HashMap<String, String>();
        trafficFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Traffic",trafficArtists ,"Unavailable","Persian Rock","Traffic",commonFile.getInitsongpath() + commonFile.getSeparator() + "traffic-band/traffic/traffic.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "traffic.jpg",trafficFeatures);

        Set<String>bedooneToArtists = new HashSet<String>();
        bedooneToArtists.add("Traffic Band");
        Map<String, String>bedooneToFeatures = new HashMap<String, String>();
        bedooneToFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Bedoone To",trafficArtists ,"Unavailable","Persian Rock","Traffic",commonFile.getInitsongpath() + commonFile.getSeparator() + "traffic-band/traffic/bedoone-to.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "traffic.jpg",bedooneToFeatures);

        Set<String>tryArtists = new HashSet<String>();
        tryArtists.add("Traffic Band");
        Map<String, String>tryFeatures = new HashMap<String, String>();
        tryFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("TRY",tryArtists ,"Unavailable","Persian Rock","Traffic",commonFile.getInitsongpath() + commonFile.getSeparator() + "traffic-band/traffic/TRY.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "traffic.jpg",tryFeatures);

        Set<String>ayadBaroonArtists = new HashSet<String>();
        ayadBaroonArtists.add("Morteza Ahmadi");
        Map<String, String>ayadBaroonFeatures = new HashMap<String, String>();
        ayadBaroonFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Ayad Baroon",ayadBaroonArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/ayad-boroon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",ayadBaroonFeatures);

        Set<String>labeGonchehArtists = new HashSet<String>();
        labeGonchehArtists.add("Morteza Ahmadi");
        Map<String, String>labeGhonchehFeatures = new HashMap<String, String>();
        labeGhonchehFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Labe Goncheh",labeGonchehArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/labe-ghonche.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",labeGhonchehFeatures);

        Set<String>shaterAliMamadArtists = new HashSet<String>();
        shaterAliMamadArtists.add("Morteza Ahmadi");
        Map<String, String>shaterAliMammadFeatures = new HashMap<String, String>();
        shaterAliMammadFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Shater Ali Mammad",shaterAliMamadArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/shater-ali-mammad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",shaterAliMammadFeatures);

        Set<String>mahsooleShahreEsfehanArtists = new HashSet<String>();
        mahsooleShahreEsfehanArtists.add("Morteza Ahmadi");
        Map<String, String>mahsooleShahreEsfehanFeatures = new HashMap<String, String>();
        mahsooleShahreEsfehanFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Mahsoole Shahre Esfehan",mahsooleShahreEsfehanArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/mahsool-shahr-esfahan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",mahsooleShahreEsfehanFeatures);

        Set<String>sonhKeAzKhabPamishamArtists = new HashSet<String>();
        sonhKeAzKhabPamishamArtists.add("Morteza Ahmadi");
        Map<String, String>sonhKeAzKhabPamishamFeatures = new HashMap<String, String>();
        sonhKeAzKhabPamishamFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Sonha Ke Az Khab Pa Misham",sonhKeAzKhabPamishamArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/sobha-ke-az-khab-pa-misham.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",sonhKeAzKhabPamishamFeatures);

        Set<String>sareShabArtists = new HashSet<String>();
        sareShabArtists.add("Morteza Ahmadi");
        Map<String, String>sareShabFeatures = new HashMap<String, String>();
        sareShabFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Sare Shab",sareShabArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/sare-shab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",sareShabFeatures);

        Set<String>aroosiArtists = new HashSet<String>();
        aroosiArtists.add("Morteza Ahmadi");
        Map<String, String>aroosiFeatures = new HashMap<String, String>();
        aroosiFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Aroosi",aroosiArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/aroosi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",aroosiFeatures);

        Set<String>dameGarageBoodamArtists = new HashSet<String>();
        dameGarageBoodamArtists.add("Morteza Ahmadi");
        Map<String, String>dameGarageBoodamFeatures = new HashMap<String, String>();
        dameGarageBoodamFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Dame Garage Boodam",dameGarageBoodamArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/dame-garazh-boodam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",dameGarageBoodamFeatures);

        Set<String>ozraKhanoomArtists = new HashSet<String>();
        ozraKhanoomArtists.add("Morteza Ahmadi");
        Map<String, String>ozraKhanoomFeatures = new HashMap<String, String>();
        ozraKhanoomFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Ozra Khanoom",ozraKhanoomArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/ozra-khanoom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",ozraKhanoomFeatures);

        Set<String>shaheKajKollahArtists = new HashSet<String>();
        shaheKajKollahArtists.add("Morteza Ahmadi");
        Map<String, String>shaheKajKollahFeatures = new HashMap<String, String>();
        shaheKajKollahFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Shahe Kaj Kollah",shaheKajKollahArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/shah-kaj-kolah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",shaheKajKollahFeatures);

        Set<String>shamsolEmareArtists = new HashSet<String>();
        shamsolEmareArtists.add("Morteza Ahmadi");
        Map<String, String>shamsolEmareFeatures = new HashMap<String, String>();
        shamsolEmareFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Delbare Man",shamsolEmareArtists ,"Unavailable","Persian Folklore","Sedaye Tehroone Ghadim",commonFile.getInitsongpath() + commonFile.getSeparator() + "morteza-ahmadi/sedaye-tehroon-ghadim/shamsolemareh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg",shamsolEmareFeatures);

        Set<String>azKhodGozashteArtists = new HashSet<String>();
        azKhodGozashteArtists.add("Andy");
        Map<String, String>azKhodGozashteFeatures = new HashMap<String, String>();
        azKhodGozashteFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Az Khod Gozashte",azKhodGozashteArtists ,"Unavailable","Persian Pop","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/az-khod-gozashteh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",azKhodGozashteFeatures);

        Set<String>beKasiNagooArtists = new HashSet<String>();
        beKasiNagooArtists.add("Andy");
        Map<String, String>beKasiNagooFeatures = new HashMap<String, String>();
        beKasiNagooFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Be Kasi Nagoo",beKasiNagooArtists ,"Unavailable","Persian 6/8 Dance","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/be-kasi-nagoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",beKasiNagooFeatures);

        Set<String>chiBegamRemixArtists = new HashSet<String>();
        chiBegamRemixArtists.add("Andy");
        Map<String, String>chiBegamRemixFeatures = new HashMap<String, String>();
        chiBegamRemixFeatures.put("Genre", "mix");
        songServiceProvider.addNewSong("Chi Begam (Remix)",chiBegamRemixArtists ,"Unavailable","mix","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/chie-begam(remix).mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",chiBegamRemixFeatures);

        Set<String>chiBegamArtists = new HashSet<String>();
        chiBegamArtists.add("Andy");
        Map<String, String>chiBegamFeatures = new HashMap<String, String>();
        chiBegamFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Chi Begam",chiBegamArtists ,"Unavailable","Persian Pop","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/chie-begam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",chiBegamFeatures);

        Set<String>closeToYourHeartArtists = new HashSet<String>();
        closeToYourHeartArtists.add("Andy");
        Map<String, String>closeToYourHeartFeatures = new HashMap<String, String>();
        closeToYourHeartFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Close To Your Heart",closeToYourHeartArtists ,"Unavailable","Persian Flamenco/Spanish","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/close-to-your-heart.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",closeToYourHeartFeatures);

        Set<String>eyIranArtists = new HashSet<String>();
        eyIranArtists.add("Andy");
        Map<String, String>eyIranFeatures = new HashMap<String, String>();
        eyIranFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ey Iran",eyIranArtists ,"Unavailable","Persian Slow Pop","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/ey-iran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",eyIranFeatures);

        Set<String>goleNazArtists = new HashSet<String>();
        goleNazArtists.add("Andy");
        Map<String, String>goleNazFeatures = new HashMap<String, String>();
        goleNazFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Gole Naz",goleNazArtists ,"Unavailable","Persian 6/8 Dance","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/gole-naz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",goleNazFeatures);

        Set<String>ketabeAfarineshArtists = new HashSet<String>();
        ketabeAfarineshArtists.add("Andy");
        Map<String, String>ketabeAfarineshFeatures = new HashMap<String, String>();
        ketabeAfarineshFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Ketabe Afarinesh",ketabeAfarineshArtists ,"Unavailable","Persian 6/8 Dance","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/ketabeh-afarinesh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",ketabeAfarineshFeatures);

        Set<String>melliPooshanArtists = new HashSet<String>();
        melliPooshanArtists.add("Andy");
        Map<String, String>melliPooshanFeatures = new HashMap<String, String>();
        melliPooshanFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Melli Pooshan",melliPooshanArtists ,"Unavailable","Persian 6/8 Dance","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/melli-poosh-ha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",melliPooshanFeatures);

        Set<String>oreraSeeroArtists = new HashSet<String>();
        oreraSeeroArtists.add("Andy");
        Map<String, String>oreraSeeroFeatures = new HashMap<String, String>();
        oreraSeeroFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Orera Seero",oreraSeeroArtists ,"Unavailable","Persian Electronic","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/orera-seero.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",oreraSeeroFeatures);

        Set<String>sepidehArtists = new HashSet<String>();
        sepidehArtists.add("Andy");
        Map<String, String>sepidehFeatures = new HashMap<String, String>();
        sepidehFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Sepideh",sepidehArtists ,"Unavailable","Persian Electronic","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/sepideh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",sepidehFeatures);

        Set<String>shabeManArtists = new HashSet<String>();
        shabeManArtists.add("Andy");
        Map<String, String>shabeManFeatures = new HashMap<String, String>();
        shabeManFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shabe Man",shabeManArtists ,"Unavailable","Persian Slow Pop","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/shabe-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",shabeManFeatures);

        Set<String>tokehRaftiArtists = new HashSet<String>();
        tokehRaftiArtists.add("Andy");
        Map<String, String>tokehRaftiFeatures = new HashMap<String, String>();
        tokehRaftiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Tokeh Rafti",tokehRaftiArtists ,"Unavailable","Persian Electronic","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/tokeh-rafti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",tokehRaftiFeatures);

        Set<String>yareSabzehRemixArtists = new HashSet<String>();
        yareSabzehRemixArtists.add("Andy");
        Map<String, String>yareSabzehRemixFeatures = new HashMap<String, String>();
        yareSabzehRemixFeatures.put("Genre", "mix");
        songServiceProvider.addNewSong("Yare Sabzeh (Remix)",yareSabzehRemixArtists ,"Unavailable","mix","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/yareh-sabzeh(remix).mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",yareSabzehRemixFeatures);

        Set<String>yareSabzehArtists = new HashSet<String>();
        yareSabzehArtists.add("Andy");
        Map<String, String>yareSabzehFeatures = new HashMap<String, String>();
        yareSabzehFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Yare Sabzeh",yareSabzehArtists ,"Unavailable","Persian 6/8 Dance","Jadeye Abrisham",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/jade-abrisham/yare-sabzeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg",yareSabzehFeatures);

        Set<String>dokhtarIrooniArtists = new HashSet<String>();
        dokhtarIrooniArtists.add("Andy");
        Map<String, String>dokhtarIrooniFeatures = new HashMap<String, String>();
        dokhtarIrooniFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Dokhtar Irooni",dokhtarIrooniArtists ,"Unavailable","Persian 6/8 Dance","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/dokhtar-irooni.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",dokhtarIrooniFeatures);

        Set<String>sheitanatArtists = new HashSet<String>();
        sheitanatArtists.add("Andy");
        Map<String, String>sheutanatFeatures = new HashMap<String, String>();
        sheutanatFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Sheitanat",sheitanatArtists ,"Unavailable","Persian 6/8 Dance","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/sheitanat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",sheutanatFeatures);

        Set<String>entezarArtists = new HashSet<String>();
        entezarArtists.add("Andy");
        Map<String, String>entezarFeatures = new HashMap<String, String>();
        entezarFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Entezar",entezarArtists ,"Unavailable","Persian Electronic","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/entezar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",entezarFeatures);

        Set<String>beeghararArtists = new HashSet<String>();
        beeghararArtists.add("Andy");
        Map<String, String>beeghararFeatures = new HashMap<String, String>();
        beeghararFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Beegharar",beeghararArtists ,"Unavailable","Persian Electronic","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/beegharar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",beeghararFeatures);

        Set<String>eshgheAvalArtists = new HashSet<String>();
        eshgheAvalArtists.add("Andy");
        Map<String, String>eshgheAvalFeatures = new HashMap<String, String>();
        eshgheAvalFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Eshghe Aval",eshgheAvalArtists ,"Unavailable","Persian Electronic","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/eshgheh-aval.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",eshgheAvalFeatures);

        Set<String>ghasreKaghaziArtists = new HashSet<String>();
        ghasreKaghaziArtists.add("Andy");
        Map<String, String>ghasreKaghaziFeatures = new HashMap<String, String>();
        ghasreKaghaziFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ghasre Kaghazi",ghasreKaghaziArtists ,"Unavailable","Persian Slow Pop","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/ghasreh-kaghazi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",ghasreKaghaziFeatures);

        Set<String>shabGardArtists = new HashSet<String>();
        shabGardArtists.add("Andy");
        Map<String, String>shabgardFeatures = new HashMap<String, String>();
        shabgardFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shab Gard",shabGardArtists ,"Unavailable","Persian Slow Pop","Bigharar",commonFile.getInitsongpath() + commonFile.getSeparator() + "andy/bigharar/shabgard.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bigharar.jpg",shabgardFeatures);

        Set<String>adamForooshArtists = new HashSet<String>();
        adamForooshArtists.add("Shadmehr Aghili");
        Map<String, String>adamForooshFeatures = new HashMap<String, String>();
        adamForooshFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Adam Foroosh",adamForooshArtists ,"Unavailable","Persian Electronic","Adam Foroosh",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/adam-foroosh/adam-forosh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg",adamForooshFeatures);

        Set<String>ashkeManArtists = new HashSet<String>();
        ashkeManArtists.add("Shadmehr Aghili");
        Map<String, String>ashkeManFeatures = new HashMap<String, String>();
        ashkeManFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Ashke Man",ashkeManArtists ,"Unavailable","Persian Pop","Adam Foroosh",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/adam-foroosh/ashke-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg",ashkeManFeatures);

        Set<String>deleDivooneArtists = new HashSet<String>();
        deleDivooneArtists.add("Shadmehr Aghili");
        Map<String, String>deleDivooneFeatures = new HashMap<String, String>();
        deleDivooneFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Dele Divoone",deleDivooneArtists ,"Unavailable","Persian Slow Pop","Adam Foroosh",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/adam-foroosh/dele-divoone.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg",deleDivooneFeatures);

        Set<String>kalKalArtists = new HashSet<String>();
        kalKalArtists.add("Shadmehr Aghili");
        Map<String, String>kalKalFeatures = new HashMap<String, String>();
        kalKalFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Kal Kal",kalKalArtists ,"Unavailable","Persian Pop","Adam Foroosh",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/adam-foroosh/kal-kal.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg",kalKalFeatures);

        Set<String>omranArtists = new HashSet<String>();
        omranArtists.add("Shadmehr Aghili");
        Map<String, String>omranFeatures = new HashMap<String, String>();
        omranFeatures.put("Genre", "Persian Pop Dance");
        songServiceProvider.addNewSong("Omran",omranArtists ,"Unavailable","Persian Pop Dance","Adam Foroosh",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/adam-foroosh/omran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg",omranFeatures);

        Set<String>vaghtiGoftyNaroArtists = new HashSet<String>();
        vaghtiGoftyNaroArtists.add("Shadmehr Aghili");
        Map<String, String>vaghtiGoftyNaroFeatures = new HashMap<String, String>();
        vaghtiGoftyNaroFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Vaghti Gofti Naro",vaghtiGoftyNaroArtists ,"Unavailable","Persian Latin","Adam Foroosh",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/adam-foroosh/vaghti-gofti-naro.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg",vaghtiGoftyNaroFeatures);

        Set<String>bNomArtists = new HashSet<String>();
        bNomArtists.add("B-Band");
        Map<String, String>bNomFeatures = new HashMap<String, String>();
        bNomFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("B Nom",bNomArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/b-nom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",bNomFeatures);

        Set<String>bekhoonNegaranamBekhoonArtists = new HashSet<String>();
        bekhoonNegaranamBekhoonArtists.add("B-Band");
        Map<String, String>bekhoonNegaranamBekhoonFeatures = new HashMap<String, String>();
        bekhoonNegaranamBekhoonFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Bekhoon Negaranam Bekhoon",bekhoonNegaranamBekhoonArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/bekhoon-negaram-bekhoon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",bekhoonNegaranamBekhoonFeatures);

        Set<String>biaBeDonbaleManArtists = new HashSet<String>();
        biaBeDonbaleManArtists.add("B-Band");
        Map<String, String>biaBeDonbaleManFeatures = new HashMap<String, String>();
        biaBeDonbaleManFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Bia Be Donbale Man",biaBeDonbaleManArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/biya-be-donbale-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",biaBeDonbaleManFeatures);

        Set<String>capavVerArtists = new HashSet<String>();
        capavVerArtists.add("B-Band");
        Map<String, String>capavVerFeatures = new HashMap<String, String>();
        capavVerFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Capav Ver",capavVerArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/cavap-ver.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",capavVerFeatures);

        Set<String>dobareJangArtists = new HashSet<String>();
        dobareJangArtists.add("B-Band");
        Map<String, String>dobareJangFeatures = new HashMap<String, String>();
        dobareJangFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Dobare Jang",dobareJangArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/dobare-jang.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",dobareJangFeatures);

        Set<String>gomshodeArtists = new HashSet<String>();
        gomshodeArtists.add("B-Band");
        Map<String, String>gomshodeFeatures = new HashMap<String, String>();
        gomshodeFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Gomshode",gomshodeArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/gomshodeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",gomshodeFeatures);

        Set<String>hamisheHamineArtists = new HashSet<String>();
        hamisheHamineArtists.add("B-Band");
        Map<String, String>hamisheHamineFeatures = new HashMap<String, String>();
        hamisheHamineFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Hamishe Hamine",hamisheHamineArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/hamishe-hamineh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",hamisheHamineFeatures);

        Set<String>jabeSiahArtists = new HashSet<String>();
        jabeSiahArtists.add("B-Band");
        Map<String, String>jabeSiahFeatures = new HashMap<String, String>();
        jabeSiahFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Jabe Siah",jabeSiahArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/jabe-siyah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",jabeSiahFeatures);

        Set<String>javabBedeArtists = new HashSet<String>();
        javabBedeArtists.add("B-Band");
        Map<String, String>javabBedeFeatures = new HashMap<String, String>();
        javabBedeFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Javab Bede",javabBedeArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/javab-bedeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",javabBedeFeatures);

        Set<String>kojayiArtists = new HashSet<String>();
        kojayiArtists.add("B-Band");
        Map<String, String>kojayiFeatures = new HashMap<String, String>();
        kojayiFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Kojayi",kojayiArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/kojaie.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",kojayiFeatures);

        Set<String>panjarehaArtists = new HashSet<String>();
        panjarehaArtists.add("B-Band");
        Map<String, String>panjarehaFeatures = new HashMap<String, String>();
        panjarehaFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Panjareha",panjarehaArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/panjereha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",panjarehaFeatures);

        Set<String>shabahArtists = new HashSet<String>();
        shabahArtists.add("B-Band");
        Map<String, String>shabahFeatures = new HashMap<String, String>();
        shabahFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Shabah",shabahArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/shabah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",shabahFeatures);

        Set<String>tarsArtists = new HashSet<String>();
        tarsArtists.add("B-Band");
        Map<String, String>tarsFeatures = new HashMap<String, String>();
        tarsFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Tars ",tarsArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/tars.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",tarsFeatures);

        Set<String>tehranArtists = new HashSet<String>();
        tehranArtists.add("B-Band");
        Map<String, String>tehranFeatures = new HashMap<String, String>();
        tehranFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("TehRan ",tehranArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/tehran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",tehranFeatures);

        Set<String>yechiziBedeManArtists = new HashSet<String>();
        yechiziBedeManArtists.add("B-Band");
        Map<String, String>yechiziBedeManFeatures = new HashMap<String, String>();
        yechiziBedeManFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Ye Chizi Bede Be Man ",yechiziBedeManArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/yechizi-bede-be-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",yechiziBedeManFeatures);

        Set<String>yeRooziYeJayiYeJoriArtists = new HashSet<String>();
        yeRooziYeJayiYeJoriArtists.add("B-Band");
        Map<String, String>yeRooziYeJayiYeJoriFeatures = new HashMap<String, String>();
        yeRooziYeJayiYeJoriFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Ye Roozi Ye Jayi Ye Jori ",yeRooziYeJayiYeJoriArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/yeruzi-yejaei-yejoori.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",yeRooziYeJayiYeJoriFeatures);

        Set<String>bekhoonNegaranamArtists = new HashSet<String>();
        bekhoonNegaranamArtists.add("B-Band");
        Map<String, String>bekhoonNegaranamFeatures = new HashMap<String, String>();
        bekhoonNegaranamFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Bekhoon Negaram Bekhoon ",bekhoonNegaranamArtists ,"Unavailable","Persian Rock","Nemishnavam Sedato",commonFile.getInitsongpath() + commonFile.getSeparator() + "b-band/nemishnavam-sedato/bekhoon-negaram-bekhoon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg",bekhoonNegaranamFeatures);

        Set<String>ahangeHeyraniArtists = new HashSet<String>();
        ahangeHeyraniArtists.add("Shahram Nazeri");
        Map<String, String>ahangeHeyraniFeatures = new HashMap<String, String>();
        ahangeHeyraniFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Pish Dar Amad",ahangeHeyraniArtists ,"Unavailable","Persian Traditional","Heyrani",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/heyrani/pish-daramad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "heyrani.jpg",ahangeHeyraniFeatures);

        Set<String>ahangeYavaraneMasemArtists = new HashSet<String>();
        ahangeYavaraneMasemArtists.add("Shahram Nazeri");
        Map<String, String>ahangeYavaraneMasemFeatures = new HashMap<String, String>();
        ahangeYavaraneMasemFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Heyrani",ahangeYavaraneMasemArtists ,"Unavailable","Persian Traditional","Heyrani",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/heyrani/heyrani.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "heyrani.jpg",ahangeYavaraneMasemFeatures);

        Set<String>takNavazieTanboorArtists = new HashSet<String>();
        takNavazieTanboorArtists.add("Shahram Nazeri");
        Map<String, String>takNavazieTanboorFeatures = new HashMap<String, String>();
        takNavazieTanboorFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Yavaran Masem",takNavazieTanboorArtists ,"Unavailable","Persian Traditional","Heyrani",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/heyrani/yavaran-masem.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "heyrani.jpg",takNavazieTanboorFeatures);

        Set<String>serreMagooArtists = new HashSet<String>();
        serreMagooArtists.add("Shahram Nazeri");
        Map<String, String>serreMagooFeatures = new HashMap<String, String>();
        serreMagooFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Serre Magoo",serreMagooArtists ,"Unavailable","Persian Traditional","Heyrani",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/heyrani/serre-magoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "heyrani.jpg",serreMagooFeatures);

        Set<String>shodZeGhamatKhaneyiSodeArtists = new HashSet<String>();
        shodZeGhamatKhaneyiSodeArtists.add("Shahram Nazeri");
        Map<String, String>shodZeGhamatKhaneyiSodeFeatures = new HashMap<String, String>();
        shodZeGhamatKhaneyiSodeFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Shod Ze Ghamat Khaneyi Soda",shodZeGhamatKhaneyiSodeArtists ,"Unavailable","Persian Traditional","Heyrani",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/heyrani/shod-ze-ghamat-khaneyi-soda.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "heyrani.jpg",shodZeGhamatKhaneyiSodeFeatures);

        Set<String>avazRahaArtists = new HashSet<String>();
        avazRahaArtists.add("Shahram Nazeri");
        Map<String, String>avazRahaFeatures = new HashMap<String, String>();
        avazRahaFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Avaz Raha",avazRahaArtists ,"Unavailable","Persian Traditional","Heyrani",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/heyrani/avaze-raha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "heyrani.jpg",avazRahaFeatures);

        Set<String>baranArtists = new HashSet<String>();
        baranArtists.add("Omid");
        Map<String, String>baranFeatures = new HashMap<String, String>();
        baranFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Baran",baranArtists ,"Unavailable","Persian Slow Pop","Baran",commonFile.getInitsongpath() + commonFile.getSeparator() + "omid/baran/baran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran.jpg",baranFeatures);

        Set<String>biToKhastamArtists = new HashSet<String>();
        biToKhastamArtists.add("Omid");
        Map<String, String>biToKhastamFeatures = new HashMap<String, String>();
        biToKhastamFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Bi To Khasstam",biToKhastamArtists ,"Unavailable","Persian Pop","Baran",commonFile.getInitsongpath() + commonFile.getSeparator() + "omid/baran/bi-to-khastam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran.jpg",biToKhastamFeatures);

        Set<String>ghesmatArtists = new HashSet<String>();
        ghesmatArtists.add("Omid");
        Map<String, String>ghesmatFeatures = new HashMap<String, String>();
        ghesmatFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Ghesmat",ghesmatArtists ,"Unavailable","Persian Pop","Baran",commonFile.getInitsongpath() + commonFile.getSeparator() + "omid/baran/ghesmat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran.jpg",ghesmatFeatures);

        Set<String>doosetDaramOmidArtists = new HashSet<String>();
        doosetDaramOmidArtists.add("Omid");
        Map<String, String>doosetDaramOmidFeatures = new HashMap<String, String>();
        doosetDaramOmidFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Dooset Daram",doosetDaramOmidArtists ,"Unavailable","Persian Folklore","Baran",commonFile.getInitsongpath() + commonFile.getSeparator() + "omid/baran/doost-daram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran.jpg",doosetDaramOmidFeatures);

        Set<String>labetGoleAnareArtists = new HashSet<String>();
        labetGoleAnareArtists.add("Omid");
        Map<String, String>labetGoleAnareFeatures = new HashMap<String, String>();
        labetGoleAnareFeatures.put("Genre", "Persian Folklore");
        songServiceProvider.addNewSong("Labet Gole Anare",labetGoleAnareArtists ,"Unavailable","Persian Folklore","Baran",commonFile.getInitsongpath() + commonFile.getSeparator() + "omid/baran/labet-gole-anare.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran.jpg",labetGoleAnareFeatures);

        Set<String>ghamSazArtists = new HashSet<String>();
        ghamSazArtists.add("Omid");
        Map<String, String>ghamSazFeatures = new HashMap<String, String>();
        ghamSazFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Gham Saaz",ghamSazArtists ,"Unavailable","Persian Pop","Baran",commonFile.getInitsongpath() + commonFile.getSeparator() + "omid/baran/gham-saaz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "baran.jpg",ghamSazFeatures);


        Set<String>ageYeRoozArtists = new HashSet<String>();
        ageYeRoozArtists.add("Faramarz Aslani");
        Map<String, String>ageYeRoozFeatures = new HashMap<String, String>();
        ghamSazFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Age Ye Rooz",ageYeRoozArtists ,"Unavailable","Persian Flamenco/Spanish","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/age-ye-rooz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",ageYeRoozFeatures);

        Set<String>divarArtists = new HashSet<String>();
        divarArtists.add("Faramarz Aslani");
        Map<String, String>divarFeatures = new HashMap<String, String>();
        divarFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Divar",divarArtists ,"Unavailable","Persian Slow Pop","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/divar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",divarFeatures);

        Set<String>MidooniDelAsireArtists = new HashSet<String>();
        MidooniDelAsireArtists.add("Faramarz Aslani");
        Map<String, String>MidooniDelAsireFeatures = new HashMap<String, String>();
        MidooniDelAsireFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Del Asire",MidooniDelAsireArtists ,"Unavailable","Persian Flamenco/Spanish","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/del-asire.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",MidooniDelAsireFeatures);

        Set<String>oboorArtists = new HashSet<String>();
        oboorArtists.add("Faramarz Aslani");
        Map<String, String>oboorFeatures = new HashMap<String, String>();
        oboorFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Oboor",oboorArtists ,"Unavailable","Persian Slow Pop","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/oboor.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",oboorFeatures);

        Set<String>yaramKoArtists = new HashSet<String>();
        yaramKoArtists.add("Faramarz Aslani");
        Map<String, String>yaramKoFeatures = new HashMap<String, String>();
        yaramKoFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Yaram Ko",yaramKoArtists ,"Unavailable","Persian Flamenco/Spanish","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/yaram-ko.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",yaramKoFeatures);

        Set<String>ahooyeVahshiArtists = new HashSet<String>();
        ahooyeVahshiArtists.add("Faramarz Aslani");
        Map<String, String>ahooyeVahshiFeatures = new HashMap<String, String>();
        ahooyeVahshiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ala Ey Ahooye Vahshi",ahooyeVahshiArtists ,"Unavailable","Persian Slow Pop","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/ahooye-vahshi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",ahooyeVahshiFeatures);

        Set<String>darighArtists = new HashSet<String>();
        darighArtists.add("Faramarz Aslani");
        Map<String, String>darighFeatures = new HashMap<String, String>();
        darighFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Darigh",darighArtists ,"Unavailable","Persian Slow Pop","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/darigh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",darighFeatures);

        Set<String>parastoohayeKhasteArtists = new HashSet<String>();
        parastoohayeKhasteArtists.add("Faramarz Aslani");
        Map<String, String>parastoohayeKhasteFeatures = new HashMap<String, String>();
        parastoohayeKhasteFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Parastoohaye Khaste",parastoohayeKhasteArtists ,"Unavailable","Persian Slow Pop","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/parastoohaye-khasteh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",parastoohayeKhasteFeatures);

        Set<String>shaadiArtists = new HashSet<String>();
        shaadiArtists.add("Faramarz Aslani");
        Map<String, String>shaadiFeatures = new HashMap<String, String>();
        shaadiFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Shaadi",shaadiArtists ,"Unavailable","Persian Flamenco/Spanish","Age Ye Rooz",commonFile.getInitsongpath() + commonFile.getSeparator() + "faramarz-aslani/age-ye-rooz/shaadi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg",shaadiFeatures);

        Set<String>ahooyePorKereshmeArtists = new HashSet<String>();
        ahooyePorKereshmeArtists.add("Martik");
        Map<String, String>ahooyePorKereshmeFeatures = new HashMap<String, String>();
        ahooyePorKereshmeFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Ahooye Por Kereshme",ahooyePorKereshmeArtists ,"Unavailable","Persian 6/8 Dance","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/ahooyeh-por-kereshmeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",ahooyePorKereshmeFeatures);

        Set<String>baShomaArtists = new HashSet<String>();
        baShomaArtists.add("Martik");
        Map<String, String>baShomaFeatures = new HashMap<String, String>();
        baShomaFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Ba Shoma",baShomaArtists ,"Unavailable","Persian 6/8 Dance","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/ba-shoma.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",baShomaFeatures);

        Set<String>dastayeManArtists = new HashSet<String>();
        dastayeManArtists.add("Martik");
        Map<String, String>dastayeManFeatures = new HashMap<String, String>();
        dastayeManFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Dasthaye Man",dastayeManArtists ,"Unavailable","Persian Pop","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/dastaye-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",dastayeManFeatures);

        Set<String>shanehArtists = new HashSet<String>();
        shanehArtists.add("Martik");
        Map<String, String>shanehFeatures = new HashMap<String, String>();
        shanehFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Shaneh",shanehArtists ,"Unavailable","Persian Flamenco/Spanish","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/shaneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",shanehFeatures);

        Set<String>nagooBedroodArtists = new HashSet<String>();
        nagooBedroodArtists.add("Martik");
        Map<String, String>nagooBedroodFeatures = new HashMap<String, String>();
        nagooBedroodFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Nagoo Bedroud",nagooBedroodArtists ,"Unavailable","Persian Pop","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/nagoo-bedoroud.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",nagooBedroodFeatures);

        Set<String>manoBebakhshArtists = new HashSet<String>();
        manoBebakhshArtists.add("Martik");
        Map<String, String>manoBebakhshFeatures = new HashMap<String, String>();
        manoBebakhshFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Mano Bebakhsh",manoBebakhshArtists ,"Unavailable","Persian Pop","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/mano-bebakhsh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",manoBebakhshFeatures);

        Set<String>khoshArtists = new HashSet<String>();
        khoshArtists.add("Martik");
        Map<String, String>khoshFeatures = new HashMap<String, String>();
        khoshFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khosh",khoshArtists ,"Unavailable","Persian Slow Pop","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/khosh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",khoshFeatures);

        Set<String>geryehArtists = new HashSet<String>();
        geryehArtists.add("Martik");
        Map<String, String>geryehFeatures = new HashMap<String, String>();
        geryehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Geryeh",geryehArtists ,"Unavailable","Persian Slow Pop","Ba Shoma",commonFile.getInitsongpath() + commonFile.getSeparator() + "martik/ba-shoma/geryeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg",geryehFeatures);

        Set<String>nanazArtists = new HashSet<String>();
        nanazArtists.add("Farshid Amin");
        Map<String, String>nanazFeatures = new HashMap<String, String>();
        nanazFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Nanaz",nanazArtists ,"Unavailable","Persian 6/8 Dance","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/nanaz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",nanazFeatures);

        Set<String>nastaranArtists = new HashSet<String>();
        nastaranArtists.add("Farshid Amin");
        Map<String, String>nastaranFeatures = new HashMap<String, String>();
        nastaranFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Nastaran",nastaranArtists ,"Unavailable","Persian 6/8 Dance","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/nastaran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",nastaranFeatures);

        Set<String>leylaFarshiAminArtists = new HashSet<String>();
        leylaFarshiAminArtists.add("Farshid Amin");
        Map<String, String>leylaFarshiAminFeatures = new HashMap<String, String>();
        leylaFarshiAminFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Leila",leylaFarshiAminArtists ,"Unavailable","Persian Flamenco/Spanish","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/leila.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",leylaFarshiAminFeatures);

        Set<String>royaFarshiAminArtists = new HashSet<String>();
        royaFarshiAminArtists.add("Farshid Amin");
        Map<String, String>royaFarshiAminFeatures = new HashMap<String, String>();
        royaFarshiAminFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Roya",royaFarshiAminArtists ,"Unavailable","Persian Electronic","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/roya.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",royaFarshiAminFeatures);

        Set<String>lalehFarshiAminArtists = new HashSet<String>();
        lalehFarshiAminArtists.add("Farshid Amin");
        Map<String, String>lalehFarshiAminFeatures = new HashMap<String, String>();
        lalehFarshiAminFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Laleh",lalehFarshiAminArtists ,"Unavailable","Persian Latin","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/laleh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",lalehFarshiAminFeatures);

        Set<String>leilaSlowSpanishArtists = new HashSet<String>();
        leilaSlowSpanishArtists.add("Farshid Amin");
        Map<String, String>leilaSlowSpanishFeatures = new HashMap<String, String>();
        leilaSlowSpanishFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Leila (Slow Spanish)",leilaSlowSpanishArtists ,"Unavailable","Persian Latin","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/leila-slow-spanish.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",leilaSlowSpanishFeatures);

        Set<String>leilaSpanishArtists = new HashSet<String>();
        leilaSpanishArtists.add("Farshid Amin");
        Map<String, String>leilaSpanishFeatures = new HashMap<String, String>();
        leilaSpanishFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Leila (Spanish)",leilaSpanishArtists ,"Unavailable","Persian Flamenco/Spanish","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/leila-spanish.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",leilaSpanishFeatures);

        Set<String>leilaRemixArtists = new HashSet<String>();
        leilaRemixArtists.add("Farshid Amin");
        Map<String, String>leilaRemixFeatures = new HashMap<String, String>();
        leilaRemixFeatures.put("Genre", "Persian Pop Dance");
        songServiceProvider.addNewSong("Leila (Remix)",leilaRemixArtists ,"Unavailable","Persian Pop Dance","Banoo",commonFile.getInitsongpath() + commonFile.getSeparator() + "farshid-amin/banoo/leila-remix.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "banoo.jpg",leilaRemixFeatures);

        Set<String>pariArtists = new HashSet<String>();
        pariArtists.add("Sandy");
        Map<String, String>pariFeatures = new HashMap<String, String>();
        pariFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Pari",pariArtists ,"Unavailable","Persian Hip-Hop","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/pari.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",pariFeatures);

        Set<String>nazarEshghBeparehArtists = new HashSet<String>();
        nazarEshghBeparehArtists.add("Sandy");
        Map<String, String>nazarEshghBeparehFeatures = new HashMap<String, String>();
        nazarEshghBeparehFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Nazar Eshgh Bepareh",nazarEshghBeparehArtists ,"Unavailable","Persian 6/8 Dance","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/nazar-eshgh-bepareh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",nazarEshghBeparehFeatures);

        Set<String>ahvaziArtists = new HashSet<String>();
        ahvaziArtists.add("Sandy");
        Map<String, String>ahvaziFeatures = new HashMap<String, String>();
        ahvaziFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Emsho Sho She",ahvaziArtists ,"Unavailable","Persian 6/8 Dance","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/ahvazi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",ahvaziFeatures);

        Set<String>biTaghsirArtists = new HashSet<String>();
        biTaghsirArtists.add("Sandy");
        Map<String, String>biTaghsirFeatures = new HashMap<String, String>();
        biTaghsirFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Bi Taghsir",biTaghsirArtists ,"Unavailable","Persian Hip-Hop","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/bi-taghsir.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",biTaghsirFeatures);

        Set<String>sigehArtists = new HashSet<String>();
        sigehArtists.add("Sandy");
        Map<String, String>sigehFeatures = new HashMap<String, String>();
        sigehFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Sighe",sigehArtists ,"Unavailable","Persian 6/8 Dance","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/sigheh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",sigehFeatures);

        Set<String>yarArtists = new HashSet<String>();
        yarArtists.add("Sandy");
        Map<String, String>yaarFeatures = new HashMap<String, String>();
        yaarFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Yar",yarArtists ,"Unavailable","Persian Electronic","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/yaar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",yaarFeatures);

        Set<String>byeByeArtists = new HashSet<String>();
        byeByeArtists.add("Sandy");
        Map<String, String>byeByeFeatures = new HashMap<String, String>();
        byeByeFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Bye Bye",byeByeArtists ,"Unavailable","Persian Pop","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/bye-bye.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",byeByeFeatures);

        Set<String>bikariArtists = new HashSet<String>();
        bikariArtists.add("Sandy");
        Map<String, String>bikariFeatures = new HashMap<String, String>();
        bikariFeatures.put("Genre", "Persian Hip-Hop");
        songServiceProvider.addNewSong("Bikari",bikariArtists ,"Unavailable","Persian Hip-Hop","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/bikari.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",bikariFeatures);

        Set<String>sandyMedleyDanceArtists = new HashSet<String>();
        sandyMedleyDanceArtists.add("Sandy");
        Map<String, String>sandyMedleyDanceFeatures = new HashMap<String, String>();
        sandyMedleyDanceFeatures.put("Genre", "mix");
        songServiceProvider.addNewSong("Medley Dance (Mix)",sandyMedleyDanceArtists ,"Unavailable","mix","Ding Dang",commonFile.getInitsongpath() + commonFile.getSeparator() + "sandy/ding-dang/medley-dance-mix.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ding-dang.jpg",sandyMedleyDanceFeatures);

        Set<String>sargardoonArtists = new HashSet<String>();
        sargardoonArtists.add("Mazyar Fallahi");
        Map<String, String>sargardoonFeatures = new HashMap<String, String>();
        sargardoonFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Sargardoon",sargardoonArtists ,"Unavailable","Persian Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/sargardoon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",sargardoonFeatures);

        Set<String>taghateGhamArtists = new HashSet<String>();
        taghateGhamArtists.add("Mazyar Fallahi");
        Map<String, String>taghateGhamFeatures = new HashMap<String, String>();
        taghateGhamFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Taghate Gham",taghateGhamArtists ,"Unavailable","Persian Electronic","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/taghate-gham.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",taghateGhamFeatures);

        Set<String>aroosakMaziarArtists = new HashSet<String>();
        aroosakMaziarArtists.add("Mazyar Fallahi");
        Map<String, String>aroosakMaziarFeatures = new HashMap<String, String>();
        aroosakMaziarFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Aroosak",aroosakMaziarArtists ,"Unavailable","Persian Slow Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/aroosak.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",aroosakMaziarFeatures);

        Set<String>tamameDonyaArtists = new HashSet<String>();
        tamameDonyaArtists.add("Mazyar Fallahi");
        Map<String, String>tamameDonyaFeatures = new HashMap<String, String>();
        tamameDonyaFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Tamame Donya",tamameDonyaArtists ,"Unavailable","Persian Slow Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/tamame-donyam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",tamameDonyaFeatures);

        Set<String>maheHaftomArtists = new HashSet<String>();
        maheHaftomArtists.add("Mazyar Fallahi");
        Map<String, String>maheHaftomFeatures = new HashMap<String, String>();
        maheHaftomFeatures.put("Genre", "Persian 6/8 Club");
        songServiceProvider.addNewSong("Mahe Haftom",maheHaftomArtists ,"Unavailable","Persian 6/8 Club","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/mahe-haftom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",maheHaftomFeatures);

        Set<String>gandomMaziarArtists = new HashSet<String>();
        gandomMaziarArtists.add("Mazyar Fallahi");
        Map<String, String>gandomMaziarFeatures = new HashMap<String, String>();
        gandomMaziarFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gandom",gandomMaziarArtists ,"Unavailable","Persian Slow Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/gandom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",gandomMaziarFeatures);

        Set<String>azatMoteshakeramArtists = new HashSet<String>();
        azatMoteshakeramArtists.add("Mazyar Fallahi");
        Map<String, String>azatMoteshakeramFeatures = new HashMap<String, String>();
        azatMoteshakeramFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Azat Moteshakeram",azatMoteshakeramArtists ,"Unavailable","Persian Slow Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/azat-moteshakeram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",azatMoteshakeramFeatures);

        Set<String>baGeryeMikhandamArtists = new HashSet<String>();
        baGeryeMikhandamArtists.add("Mazyar Fallahi");
        Map<String, String>baGeryeMikhandamFeatures = new HashMap<String, String>();
        baGeryeMikhandamFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Ba Gerye Mikhandam",baGeryeMikhandamArtists ,"Unavailable","Persian Electronic","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/ba-geryeh-mikhandam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",baGeryeMikhandamFeatures);

        Set<String>shonehayeBiLebasArtists = new HashSet<String>();
        shonehayeBiLebasArtists.add("Mazyar Fallahi");
        Map<String, String>shonehayeBiLebasFeatures = new HashMap<String, String>();
        shonehayeBiLebasFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shoonehaye Bi Lebas",shonehayeBiLebasArtists ,"Unavailable","Persian Slow Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/shoonehaye-bi-lebas.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",shonehayeBiLebasFeatures);

        Set<String>manNemidoonamArtists = new HashSet<String>();
        manNemidoonamArtists.add("Mazyar Fallahi");
        Map<String, String>manNemidoonamFeatures = new HashMap<String, String>();
        manNemidoonamFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Man Nemidoonam",manNemidoonamArtists ,"Unavailable","Persian Slow Pop","Mahe Haftom",commonFile.getInitsongpath() + commonFile.getSeparator() + "mazyiar-fallahi/mahe-haftom/man-nemidoonam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg",manNemidoonamFeatures);

        Set<String>bahareManArtists = new HashSet<String>();
        bahareManArtists.add("Sirvan");
        Map<String, String>bahareManFeatures = new HashMap<String, String>();
        bahareManFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Bahare Man",bahareManArtists ,"Unavailable","Persian 6/8 Dance","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/bahare-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",bahareManFeatures);

        Set<String>toKhialKardiBeriArtists = new HashSet<String>();
        toKhialKardiBeriArtists.add("Sirvan");
        Map<String, String>toKhialKardiBeriFeatures = new HashMap<String, String>();
        toKhialKardiBeriFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("To Khial Kardi Beri",toKhialKardiBeriArtists ,"Unavailable","Persian Electronic","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/to-khial-kardi-beri.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",toKhialKardiBeriFeatures);

        Set<String>lahzeyeBatoBoodanArtists = new HashSet<String>();
        lahzeyeBatoBoodanArtists.add("Sirvan");
        Map<String, String>lahzeyeBatoBoodanFeatures = new HashMap<String, String>();
        lahzeyeBatoBoodanFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Lahzehaye Bi To Boodan",lahzeyeBatoBoodanArtists ,"Unavailable","Persian Pop","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/lahzehaye-bi-to-boodan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",lahzeyeBatoBoodanFeatures);

        Set<String>harfeAkharArtists = new HashSet<String>();
        harfeAkharArtists.add("Sirvan");
        Map<String, String>harfeAkharFeatures = new HashMap<String, String>();
        harfeAkharFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Harfe Akhar",harfeAkharArtists ,"Unavailable","Persian Electronic","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/harfe-akhar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",harfeAkharFeatures);

        Set<String>takDerakhteTanhaArtists = new HashSet<String>();
        takDerakhteTanhaArtists.add("Sirvan");
        Map<String, String>takDerakhteTanhaFeatures = new HashMap<String, String>();
        takDerakhteTanhaFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Tak Derakhte Tanha",takDerakhteTanhaArtists ,"Unavailable","Persian Electronic","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/tak-derakhte-tanha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",takDerakhteTanhaFeatures);

        Set<String>baroonArtists = new HashSet<String>();
        baroonArtists.add("Sirvan");
        Map<String, String>baroonFeatures = new HashMap<String, String>();
        baroonFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Baroon",baroonArtists ,"Unavailable","Persian Electronic","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/baroon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",baroonFeatures);

        Set<String>rasmeDonyaHasratArtists = new HashSet<String>();
        rasmeDonyaHasratArtists.add("Sirvan");
        Map<String, String>rasmeDonyaFeatures = new HashMap<String, String>();
        rasmeDonyaFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Rasme Donya",rasmeDonyaHasratArtists ,"Unavailable","Persian Electronic","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/rasme-donya-hasrat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",rasmeDonyaFeatures);

        Set<String>nemeheiAzAsemoonArtists = new HashSet<String>();
        nemeheiAzAsemoonArtists.add("Sirvan");
        Map<String, String>nemeheiAzAsemoonFeatures = new HashMap<String, String>();
        nemeheiAzAsemoonFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Nimeyi Az Aseman",nemeheiAzAsemoonArtists ,"Unavailable","Persian Slow Pop","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/nemehei-az-aseman.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",nemeheiAzAsemoonFeatures);

        Set<String>toKhialKardiBeriRemixArtists = new HashSet<String>();
        toKhialKardiBeriRemixArtists.add("Sirvan");
        Map<String, String>toKhialKardiBeriRemixFeatures = new HashMap<String, String>();
        toKhialKardiBeriRemixFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("To Khial Kardi Beri (Remix)",toKhialKardiBeriRemixArtists ,"Unavailable","Persian Electronic","To Khial Kardi Beri",commonFile.getInitsongpath() + commonFile.getSeparator() + "sirvan-khosravi/to-khial-kardi-beri/to-khial-kardi-beri-remix.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg",toKhialKardiBeriRemixFeatures);

        Set<String>belaTaklifArtists = new HashSet<String>();
        belaTaklifArtists.add("Reza Yazdani");
        Map<String, String>belaTaklifFeatures = new HashMap<String, String>();
        belaTaklifFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Bela Taklif",belaTaklifArtists ,"Unavailable","Persian Rock","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/bela-taklif.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",belaTaklifFeatures);

        Set<String>filmeKootahArtists = new HashSet<String>();
        filmeKootahArtists.add("Reza Yazdani");
        Map<String, String>filmeKootahFeatures = new HashMap<String, String>();
        filmeKootahFeatures.put("Genre", "Persian Jazz");
        songServiceProvider.addNewSong("Filme Kootah",filmeKootahArtists ,"Unavailable","Persian Jazz","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/filme-kotah.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",filmeKootahFeatures);

        Set<String>kojaGometKardamArtists = new HashSet<String>();
        kojaGometKardamArtists.add("Reza Yazdani");
        Map<String, String>kojaGometKardamFeatures = new HashMap<String, String>();
        kojaGometKardamFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Koja Gomet Kardam",kojaGometKardamArtists ,"Unavailable","Persian Slow Pop","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/koja-gomet-kardam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",kojaGometKardamFeatures);

        Set<String>edameBedeArtists = new HashSet<String>();
        edameBedeArtists.add("Reza Yazdani");
        Map<String, String>edameBedeFeatures = new HashMap<String, String>();
        edameBedeFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Edame Bede",edameBedeArtists ,"Unavailable","Persian Rock","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/edame-bede.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",edameBedeFeatures);

        Set<String>harfayeBiMokhatabArtists = new HashSet<String>();
        harfayeBiMokhatabArtists.add("Reza Yazdani");
        Map<String, String>harfayeBiMokhatabFeatures = new HashMap<String, String>();
        harfayeBiMokhatabFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Harfhaye Bi Mokhatab",harfayeBiMokhatabArtists ,"Unavailable","Persian Fusion","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/harf-haye-bi-mokhatab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",harfayeBiMokhatabFeatures);

        Set<String>geramafonbArtists = new HashSet<String>();
        geramafonbArtists.add("Reza Yazdani");
        Map<String, String>geramafonFeatures = new HashMap<String, String>();
        geramafonFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Geramafon",geramafonbArtists ,"Unavailable","Persian Slow Pop","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/geramafon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",geramafonFeatures);

        Set<String>navarArtists = new HashSet<String>();
        navarArtists.add("Reza Yazdani");
        Map<String, String>navarFeatures = new HashMap<String, String>();
        navarFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Navar",navarArtists ,"Unavailable","Persian Rock","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/navar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",navarFeatures);

        Set<String>harfeAkharRezaYazdaniArtists = new HashSet<String>();
        harfeAkharRezaYazdaniArtists.add("Reza Yazdani");
        Map<String, String>harfeAkharRezaYazdaniFeatures = new HashMap<String, String>();
        harfeAkharRezaYazdaniFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Harfe Akhar",harfeAkharRezaYazdaniArtists ,"Unavailable","Persian Rock","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/harfe-akhar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",harfeAkharRezaYazdaniFeatures);

        Set<String>tehranTehranArtists = new HashSet<String>();
        tehranTehranArtists.add("Reza Yazdani");
        Map<String, String>tehranTehranFeatures = new HashMap<String, String>();
        tehranTehranFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Tehran Tehran",tehranTehranArtists ,"Unavailable","Persian Rock","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/tehran-tehran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",tehranTehranFeatures);

        Set<String>shakMikonamArtists = new HashSet<String>();
        shakMikonamArtists.add("Reza Yazdani");
        Map<String, String>shakMikonamFeatures = new HashMap<String, String>();
        shakMikonamFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shak Mikonam",shakMikonamArtists ,"Unavailable","Persian Slow Pop","Khaterate Mobham",commonFile.getInitsongpath() + commonFile.getSeparator() + "reza-yazdani/khaterate-mobham/shak-mikonam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg",shakMikonamFeatures);

        Set<String>bavarKonamArtists = new HashSet<String>();
        bavarKonamArtists.add("Mohsen Yeganeh");
        Map<String, String>bavarKonamFeatures = new HashMap<String, String>();
        bavarKonamFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Bavar Konam",bavarKonamArtists ,"Unavailable","Persian Electronic","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/bavaram-kon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",bavarKonamFeatures);

        Set<String>nemisheArtists = new HashSet<String>();
        nemisheArtists.add("Mohsen Yeganeh");
        Map<String, String>nemisheFeatures = new HashMap<String, String>();
        nemisheFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Nemishe",nemisheArtists ,"Unavailable","Persian Electronic","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/nemishe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",nemisheFeatures);

        Set<String>toHataArtists = new HashSet<String>();
        toHataArtists.add("Mohsen Yeganeh");
        Map<String, String>toHataFeatures = new HashMap<String, String>();
        toHataFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("To Hata",toHataArtists ,"Unavailable","Persian Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/to-hata.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",toHataFeatures);

        Set<String>yadeteArtists = new HashSet<String>();
        yadeteArtists.add("Mohsen Yeganeh");
        Map<String, String>yadeteFeatures = new HashMap<String, String>();
        yadeteFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Yadete",yadeteArtists ,"Unavailable","Persian Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/yadete.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",yadeteFeatures);

        Set<String>doosetDaramYeganehArtists = new HashSet<String>();
        doosetDaramYeganehArtists.add("Mohsen Yeganeh");
        Map<String, String>doosetDaramYeganehFeatures = new HashMap<String, String>();
        doosetDaramYeganehFeatures.put("Genre", "Persian 6/8 Club");
        songServiceProvider.addNewSong("Dooset Daram",doosetDaramYeganehArtists ,"Unavailable","Persian 6/8 Club","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/dooset-daram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",doosetDaramYeganehFeatures);

        Set<String>naroMohsenYeganehArtists = new HashSet<String>();
        naroMohsenYeganehArtists.add("Mohsen Yeganeh");
        Map<String, String>naroMohsenYeganehFeatures = new HashMap<String, String>();
        naroMohsenYeganehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Naro",naroMohsenYeganehArtists ,"Unavailable","Persian Slow Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/naro.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",naroMohsenYeganehFeatures);

        Set<String>hobabArtists = new HashSet<String>();
        hobabArtists.add("Mohsen Yeganeh");
        Map<String, String>hobabFeatures = new HashMap<String, String>();
        hobabFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Hobab",hobabArtists ,"Unavailable","Persian Electronic","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/hobab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",hobabFeatures);

        Set<String>nemizaramKhasteShiArtists = new HashSet<String>();
        nemizaramKhasteShiArtists.add("Mohsen Yeganeh");
        Map<String, String>nemizaramKhasteShiFeatures = new HashMap<String, String>();
        nemizaramKhasteShiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Nemizaram Khaste Shi",nemizaramKhasteShiArtists ,"Unavailable","Persian Slow Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/nemizaram-khaste-shi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",nemizaramKhasteShiFeatures);

        Set<String>kiJayeManOmadeArtists = new HashSet<String>();
        kiJayeManOmadeArtists.add("Mohsen Yeganeh");
        Map<String, String>kiJayeManOmadeFeatures = new HashMap<String, String>();
        kiJayeManOmadeFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ki Jaye Man Omade",kiJayeManOmadeArtists ,"Unavailable","Persian Slow Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/ki-jaye-man-omade.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",kiJayeManOmadeFeatures);

        Set<String>bekhandMohsenYeganehArtists = new HashSet<String>();
        bekhandMohsenYeganehArtists.add("Mohsen Yeganeh");
        Map<String, String>bekhandMohsenYeganehFeatures = new HashMap<String, String>();
        bekhandMohsenYeganehFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Bekhand",bekhandMohsenYeganehArtists ,"Unavailable","Persian Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/bekhand.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",bekhandMohsenYeganehFeatures);

        Set<String>tanhaiMohsenYeganehArtists = new HashSet<String>();
        tanhaiMohsenYeganehArtists.add("Mohsen Yeganeh");
        Map<String, String>tanhaiMohsenYeganehFeatures = new HashMap<String, String>();
        tanhaiMohsenYeganehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Tanhai",tanhaiMohsenYeganehArtists ,"Unavailable","Persian Slow Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/tanhaei.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",tanhaiMohsenYeganehFeatures);

        Set<String>toKeMidooniMohsenYeganehArtists = new HashSet<String>();
        toKeMidooniMohsenYeganehArtists.add("Mohsen Yeganeh");
        Map<String, String>toKeMidooniMohsenYeganehFeatures = new HashMap<String, String>();
        toKeMidooniMohsenYeganehFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("To Ke Midooni",toKeMidooniMohsenYeganehArtists ,"Unavailable","Persian Slow Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/to-ke-midooni.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",toKeMidooniMohsenYeganehFeatures);

        Set<String>havaiArtists = new HashSet<String>();
        havaiArtists.add("Mohsen Yeganeh");
        Map<String, String>havaiFeatures = new HashMap<String, String>();
        havaiFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Havai",havaiArtists ,"Unavailable","Persian 6/8 Dance","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/havai-shodi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",havaiFeatures);

        Set<String>beatAkharArtists = new HashSet<String>();
        beatAkharArtists.add("Mohsen Yeganeh");
        Map<String, String>beatAkharFeatures = new HashMap<String, String>();
        beatAkharFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Beat Akhar",beatAkharArtists ,"Unavailable","Persian Slow Pop","Hobab",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-yeganeh/Hobab/beat-akhar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hobab.jpg",beatAkharFeatures);

        Set<String>tehranNamjooArtists = new HashSet<String>();
        tehranNamjooArtists.add("Mohsen Namjoo");
        Map<String, String>tehranNamjooFeatures = new HashMap<String, String>();
        tehranNamjooFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Tehran",tehranNamjooArtists ,"Unavailable","Persian Fusion","13/8",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/13-8/tehran.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "13-8.jpg",tehranNamjooFeatures);

        Set<String>biyayidArtists = new HashSet<String>();
        biyayidArtists.add("Mohsen Namjoo");
        Map<String, String>biyayidFeatures = new HashMap<String, String>();
        biyayidFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Biyayid",biyayidArtists ,"Unavailable","Persian Fusion","13/8",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/13-8/biyaid.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "13-8.jpg",biyayidFeatures);

        Set<String>bigahShodArtists = new HashSet<String>();
        bigahShodArtists.add("Mohsen Namjoo");
        Map<String, String>bigahShodFeatures = new HashMap<String, String>();
        bigahShodFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Bigah Shod",bigahShodArtists ,"Unavailable","Persian Fusion","13/8",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/13-8/bigah-shod.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "13-8.jpg",bigahShodFeatures);

        Set<String>khatBekeshArtists = new HashSet<String>();
        khatBekeshArtists.add("Mohsen Namjoo");
        Map<String, String>khatBekeshFeatures = new HashMap<String, String>();
        khatBekeshFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Khat Bekesh",khatBekeshArtists ,"Unavailable","Persian Fusion","13/8",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/13-8/khat-bekesh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "13-8.jpg",khatBekeshFeatures);

        Set<String>sizdahHashtArtists = new HashSet<String>();
        sizdahHashtArtists.add("Mohsen Namjoo");
        Map<String, String>sizdahHashtFeatures = new HashMap<String, String>();
        sizdahHashtFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("13/8",sizdahHashtArtists ,"Unavailable","Persian Fusion","13/8",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/13-8/13-8.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "13-8.jpg",sizdahHashtFeatures);

        Set<String>sanamaArtists = new HashSet<String>();
        sanamaArtists.add("Mohsen Namjoo");
        Map<String, String>sanamaFeatures = new HashMap<String, String>();
        sanamaFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Sanama",sanamaArtists ,"Unavailable","Persian Fusion","13/8",commonFile.getInitsongpath() + commonFile.getSeparator() + "mohsen-namjoo/13-8/sanama.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "13-8.jpg",sanamaFeatures);

        Set<String>entekhabArtists = new HashSet<String>();
        entekhabArtists.add("Shadmehr Aghili");
        Map<String, String>entekhabFeatures = new HashMap<String, String>();
        entekhabFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Entekhab",entekhabArtists ,"Unavailable","Persian Slow Pop","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/entekhab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",entekhabFeatures);

        Set<String>esmamDareYadamMireArtists = new HashSet<String>();
        esmamDareYadamMireArtists.add("Shadmehr Aghili");
        Map<String, String>esmamDareYadamMireFeatures = new HashMap<String, String>();
        esmamDareYadamMireFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Esmam Dare Yadam Mire",esmamDareYadamMireArtists ,"Unavailable","Persian Latin","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/esmam-dare-yadam-mire.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",esmamDareYadamMireFeatures);

        Set<String>halamAvazMisheArtists = new HashSet<String>();
        halamAvazMisheArtists.add("Shadmehr Aghili");
        Map<String, String>halamAvazMisheFeatures = new HashMap<String, String>();
        halamAvazMisheFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Halam Avaz Mishe",halamAvazMisheArtists ,"Unavailable","Persian Electronic","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/halam-avaz-mishe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",halamAvazMisheFeatures);

        Set<String>tarafdaarArtists = new HashSet<String>();
        tarafdaarArtists.add("Shadmehr Aghili");
        Map<String, String>tarafdaarFeatures = new HashMap<String, String>();
        tarafdaarFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Tarafdar",tarafdaarArtists ,"Unavailable","Persian Slow Pop","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/tarafdaar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",tarafdaarFeatures);

        Set<String>ayandehArtists = new HashSet<String>();
        ayandehArtists.add("Shadmehr Aghili");
        Map<String, String>ayandehFeatures = new HashMap<String, String>();
        ayandehFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Ayandeh",ayandehArtists ,"Unavailable","Persian Electronic","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/ayandeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",ayandehFeatures);

        Set<String>kheyliaArtists = new HashSet<String>();
        kheyliaArtists.add("Shadmehr Aghili");
        Map<String, String>kheyliaFeatures = new HashMap<String, String>();
        kheyliaFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Kheylia",kheyliaArtists ,"Unavailable","Persian Electronic","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/kheylia.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",kheyliaFeatures);

        Set<String>cheKhabHayeeArtists = new HashSet<String>();
        cheKhabHayeeArtists.add("Shadmehr Aghili");
        Map<String, String>cheKhabHayeeFeatures = new HashMap<String, String>();
        cheKhabHayeeFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Che Khabhayee",cheKhabHayeeArtists ,"Unavailable","Persian Electronic","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/che-khab-hayee.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",cheKhabHayeeFeatures);

        Set<String>zoodTamoomMisheArtists = new HashSet<String>();
        zoodTamoomMisheArtists.add("Shadmehr Aghili");
        Map<String, String>zoodTamoomMisheFeatures = new HashMap<String, String>();
        zoodTamoomMisheFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Amoon Az To",zoodTamoomMisheArtists ,"Unavailable","Persian Latin","Tarafdar",commonFile.getInitsongpath() + commonFile.getSeparator() + "shadmehr-aghili/tarafdar/zood-tamoom-mishe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "tarafdar.jpg",zoodTamoomMisheFeatures);

        Set<String>khaterehayeGhabliArtists = new HashSet<String>();
        khaterehayeGhabliArtists.add("A2");
        Map<String, String>khaterehayeGhabliFeatures = new HashMap<String, String>();
        khaterehayeGhabliFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Khaterehaye Ghabli",khaterehayeGhabliArtists ,"Unavailable","Persian Rap","A2 Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "a2/singles/khaterhaye-ghabli.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "a2-singles.jpg",khaterehayeGhabliFeatures);
         
        Set<String>lashBaziArtists = new HashSet<String>();
        lashBaziArtists.add("A2");
        Map<String, String>lashBaziFeatures = new HashMap<String, String>();
        lashBaziFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Lash Bazi",lashBaziArtists ,"Unavailable","Persian Rap","A2 Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "a2/singles/lash-bazi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "a2-singles.jpg",lashBaziFeatures);

        Set<String>tehranAjibeArtists = new HashSet<String>();
        tehranAjibeArtists.add("A2");
        Map<String, String>tehranAjibeFeatures = new HashMap<String, String>();
        tehranAjibeFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Tehran Ajibe",tehranAjibeArtists ,"Unavailable","Persian Rap","A2 Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "a2/singles/tehran-ajibe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "a2-singles.jpg",tehranAjibeFeatures);

        Set<String>illStoriesArtists = new HashSet<String>();
        illStoriesArtists.add("A2");
        Map<String, String>illStoriesFeatures = new HashMap<String, String>();
        illStoriesFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Ill Stories",illStoriesArtists ,"Unavailable","Persian Rap","A2 Singles",commonFile.getInitsongpath() + commonFile.getSeparator() + "a2/singles/ill-stories.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "a2-singles.jpg",illStoriesFeatures);

        Set<String>aghooshShahinNajafiArtists = new HashSet<String>();
        aghooshShahinNajafiArtists.add("Shahin Najafi");
        Map<String, String>aghooshShahinNajafiFeatures = new HashMap<String, String>();
        aghooshShahinNajafiFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Aghoosh",aghooshShahinNajafiArtists ,"Unavailable","Persian Fusion","1414",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahin-najafi/1414/aghoosh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "1414.jpg",aghooshShahinNajafiFeatures);

        Set<String>leiliShahinNajafiArtists = new HashSet<String>();
        leiliShahinNajafiArtists.add("Shahin Najafi");
        Map<String, String>leiliShahinNajafiFeatures = new HashMap<String, String>();
        leiliShahinNajafiFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Leili",leiliShahinNajafiArtists ,"Unavailable","Persian Fusion","1414",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahin-najafi/1414/leili.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "1414.jpg",leiliShahinNajafiFeatures);

        Set<String>mahramaneShahinNajafiArtists = new HashSet<String>();
        mahramaneShahinNajafiArtists.add("Shahin Najafi");
        Map<String, String>mahramanehShahinNajafiFeatures = new HashMap<String, String>();
        mahramanehShahinNajafiFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Mahramane",mahramaneShahinNajafiArtists ,"Unavailable","Persian Slow Pop","1414",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahin-najafi/1414/mahramaneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "1414.jpg",mahramanehShahinNajafiFeatures);

        Set<String>motenaferamShahinNajafiArtists = new HashSet<String>();
        motenaferamShahinNajafiArtists.add("Shahin Najafi");
        Map<String, String>motenaferamShahinNajafiFeatures = new HashMap<String, String>();
        motenaferamShahinNajafiFeatures.put("Genre", "Persian Rap");
        songServiceProvider.addNewSong("Motenaferam",motenaferamShahinNajafiArtists ,"Unavailable","Persian Rap","1414",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahin-najafi/1414/motenaferam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "1414.jpg",motenaferamShahinNajafiFeatures);

        Set<String>begooNaEbiArtists = new HashSet<String>();
        begooNaEbiArtists.add("Ebi");
        Map<String, String>begooNaEbiFeatures = new HashMap<String, String>();
        begooNaEbiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Begoo Na",begooNaEbiArtists ,"Unavailable","Persian Electronic","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/bego-na.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",begooNaEbiFeatures);

        Set<String>sedamKardiEbiArtists = new HashSet<String>();
        sedamKardiEbiArtists.add("Ebi");
        Map<String, String>sedamKardiEbiFeatures = new HashMap<String, String>();
        sedamKardiEbiFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Sedam Kardi",sedamKardiEbiArtists ,"Unavailable","Persian Flamenco/Spanish","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/sedam-kardi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",sedamKardiEbiFeatures);

        Set<String>vaghtiToNistiEbiArtists = new HashSet<String>();
        vaghtiToNistiEbiArtists.add("Ebi");
        Map<String, String>vaghtiToNistiEbiFeatures = new HashMap<String, String>();
        vaghtiToNistiEbiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Vaghti To Nisty",vaghtiToNistiEbiArtists ,"Unavailable","Persian Slow Pop","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/vaghti-to-nisti.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",vaghtiToNistiEbiFeatures);

        Set<String>hanaKhanoomEbiArtists = new HashSet<String>();
        hanaKhanoomEbiArtists.add("Ebi");
        Map<String, String>hanaKhanoomEbiFeatures = new HashMap<String, String>();
        hanaKhanoomEbiFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Hana Khanoom",hanaKhanoomEbiArtists ,"Unavailable","Persian 6/8 Dance","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/hana-khanom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",hanaKhanoomEbiFeatures);

        Set<String>razeghiEbiArtists = new HashSet<String>();
        razeghiEbiArtists.add("Ebi");
        Map<String, String>razeghiEbiFeatures = new HashMap<String, String>();
        razeghiEbiFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Razeghi",razeghiEbiArtists ,"Unavailable","Persian Pop","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/razeghi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",razeghiEbiFeatures);

        Set<String>manAgeKhodaBoodamEbiArtists = new HashSet<String>();
        manAgeKhodaBoodamEbiArtists.add("Ebi");
        Map<String, String>manAgeKhodaBoodamEbiFeatures = new HashMap<String, String>();
        manAgeKhodaBoodamEbiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Man Age Khoda Boodam",manAgeKhodaBoodamEbiArtists ,"Unavailable","Persian Slow Pop","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/man-ageh-khoda-bodam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",manAgeKhodaBoodamEbiFeatures);

        Set<String>parvaneyiDarMoshtEbiArtists = new HashSet<String>();
        parvaneyiDarMoshtEbiArtists.add("Ebi");
        Map<String, String>parvaneyiDarMoshtEbiFeatures = new HashMap<String, String>();
        parvaneyiDarMoshtEbiFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Parvaneyi Dar Mosht",parvaneyiDarMoshtEbiArtists ,"Unavailable","Persian Latin","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/parvaneie-dar-mosht.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",parvaneyiDarMoshtEbiFeatures);

        Set<String>raheManEbiArtists = new HashSet<String>();
        raheManEbiArtists.add("Ebi");
        Map<String, String>raheManEbiFeatures = new HashMap<String, String>();
        raheManEbiFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Rahe Man",raheManEbiArtists ,"Unavailable","Persian Pop","Hasrate Parvaz",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hasrate-parvaz/raahe-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg",raheManEbiFeatures);

        Set<String>booseyeBadArtists = new HashSet<String>();
        booseyeBadArtists.add("Siavash Ghomeyshi");
        Map<String, String>booseyeBadFeatures = new HashMap<String, String>();
        booseyeBadFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Booseye Bad",booseyeBadArtists ,"Unavailable","Persian Electronic","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/boosaye-baad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",booseyeBadFeatures);

        Set<String>panjerehSiavashGhomeyshiArtists = new HashSet<String>();
        panjerehSiavashGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>panjerehSiavashGhomeyshiFeatures = new HashMap<String, String>();
        panjerehSiavashGhomeyshiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Panjere",panjerehSiavashGhomeyshiArtists ,"Unavailable","Persian Electronic","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/panjereh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",panjerehSiavashGhomeyshiFeatures);

        Set<String>tasavorKonSiavashGhomeyshiArtists = new HashSet<String>();
        tasavorKonSiavashGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>tasavorKonGhomeyshiFeatures = new HashMap<String, String>();
        tasavorKonGhomeyshiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Tasavor Kon",tasavorKonSiavashGhomeyshiArtists ,"Unavailable","Persian Slow Pop","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/tassavore-kon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",tasavorKonGhomeyshiFeatures);

        Set<String>mahboobeyeShabGhomeyshiArtists = new HashSet<String>();
        mahboobeyeShabGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>mahboobeyeShabGhomeyshiFeatures = new HashMap<String, String>();
        mahboobeyeShabGhomeyshiFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Mahboobeye Shab",mahboobeyeShabGhomeyshiArtists ,"Unavailable","Persian Pop","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/mahboobaye-shab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",mahboobeyeShabGhomeyshiFeatures);

        Set<String>hanoozGhomeyshiArtists = new HashSet<String>();
        hanoozGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>hanoozGhomeyshiFeatures = new HashMap<String, String>();
        hanoozGhomeyshiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Hanooz",hanoozGhomeyshiArtists ,"Unavailable","Persian Slow Pop","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/hanooz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",hanoozGhomeyshiFeatures);

        Set<String>yadeManBashGhomeyshiArtists = new HashSet<String>();
        yadeManBashGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>yadeManBashGhomeyshiFeatures = new HashMap<String, String>();
        yadeManBashGhomeyshiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Yade Man Bash",yadeManBashGhomeyshiArtists ,"Unavailable","Persian Electronic","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/yaade-man-baash.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",yadeManBashGhomeyshiFeatures);

        Set<String>booseyeBadRemixGhomeyshiArtists = new HashSet<String>();
        booseyeBadRemixGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>booseyeBadRemixGhomeyshiFeatures = new HashMap<String, String>();
        booseyeBadRemixGhomeyshiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Booseye Bad (Club Remix)",booseyeBadRemixGhomeyshiArtists ,"Unavailable","Persian Electronic","Roozhaye Bikhatereh",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/roozhaye-bikhatere/bosaye-bad(clubmix).mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg",booseyeBadRemixGhomeyshiFeatures);

        Set<String>asalBanooGhomeyshiArtists = new HashSet<String>();
        asalBanooGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>asalBanooGhomeyshiFeatures = new HashMap<String, String>();
        asalBanooGhomeyshiFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Asal Banoo",asalBanooGhomeyshiArtists ,"Unavailable","Persian Slow Pop","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/asal-banoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",asalBanooGhomeyshiFeatures);

        Set<String>ageToBeriGhomeyshiArtists = new HashSet<String>();
        ageToBeriGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>ageToBeriGhomeyshiFeatures = new HashMap<String, String>();
        ageToBeriGhomeyshiFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Age To Beri",ageToBeriGhomeyshiArtists ,"Unavailable","Persian Rock","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/ageh-to-beri.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",ageToBeriGhomeyshiFeatures);

        Set<String>daryayeMaghrebGhomeyshiArtists = new HashSet<String>();
        daryayeMaghrebGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>daryayeMaghrebGhomeyshiFeatures = new HashMap<String, String>();
        daryayeMaghrebGhomeyshiFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Daryaye Maghreb",daryayeMaghrebGhomeyshiArtists ,"Unavailable","Persian Pop","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/daryaye-maghreb.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",daryayeMaghrebGhomeyshiFeatures);

        Set<String>lanatGhomeyshiArtists = new HashSet<String>();
        lanatGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>lanatGhomeyshiFeatures = new HashMap<String, String>();
        lanatGhomeyshiFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Lanat",lanatGhomeyshiArtists ,"Unavailable","Persian Rock","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/lanat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",lanatGhomeyshiFeatures);

        Set<String>nafasBekeshGhomeyshiArtists = new HashSet<String>();
        nafasBekeshGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>nafasBekeshGhomeyshiFeatures = new HashMap<String, String>();
        nafasBekeshGhomeyshiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Nafas Bekesh",nafasBekeshGhomeyshiArtists ,"Unavailable","Persian Electronic","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/nafas-bekesh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",nafasBekeshGhomeyshiFeatures);

        Set<String>parseGhomeyshiArtists = new HashSet<String>();
        parseGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>parseGhomeyshiFeatures = new HashMap<String, String>();
        parseGhomeyshiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Parse",parseGhomeyshiArtists ,"Unavailable","Persian Electronic","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/parse.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",parseGhomeyshiFeatures);

        Set<String>biSarZaminTarAzBadGhomeyshiArtists = new HashSet<String>();
        biSarZaminTarAzBadGhomeyshiArtists.add("Siavash Ghomeyshi");
        Map<String, String>biSarZaminTarAzBadGhomeyshiFeatures = new HashMap<String, String>();
        biSarZaminTarAzBadGhomeyshiFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Bi Sarnamin Tar Az Bad",biSarZaminTarAzBadGhomeyshiArtists ,"Unavailable","Persian Electronic","Bi Sarzamintar Az Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "siavash-ghomeishi/bi-sarzamintar-az-bad/bi-sarzamin-tar-az-bad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg",biSarZaminTarAzBadGhomeyshiFeatures);

        Set<String> afsoongarSongArtist = new HashSet<String>();
        afsoongarSongArtist.add("Arian Band");
        Map<String ,String>afsoongarSongFeatures = new HashMap<String, String>();
        afsoongarSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Afsoongar",afsoongarSongArtist,"To hichvaght vase man mese ye shakhe gol naboodi","Persian 6/8 Dance","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/afsoongar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", afsoongarSongFeatures);

        Set<String> aroomAroomArianSongArtist = new HashSet<String>();
        aroomAroomArianSongArtist.add("Arian Band");
        Map<String ,String>aroomAroomArianSongFeatures = new HashMap<String, String>();
        aroomAroomArianSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Aroom Aroom",aroomAroomArianSongArtist,"Unavailable","Persian 6/8 Dance","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/aroom-aroom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", aroomAroomArianSongFeatures);

        Set<String> bezarBeramArianSongArtist = new HashSet<String>();
        bezarBeramArianSongArtist.add("Arian Band");
        Map<String ,String>bezarBeramSongFeatures = new HashMap<String, String>();
        bezarBeramSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Bezar Beram",bezarBeramArianSongArtist,"Unavailable","Persian Electronic","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/bezar-beram.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", bezarBeramSongFeatures);

        Set<String> ghasreSheniArianSongArtist = new HashSet<String>();
        ghasreSheniArianSongArtist.add("Arian Band");
        Map<String ,String>ghasreSheniSongFeatures = new HashMap<String, String>();
        ghasreSheniSongFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Ghasre Sheni",ghasreSheniArianSongArtist,"Unavailable","Persian Latin","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/ghasre-sheni.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", ghasreSheniSongFeatures);

        Set<String> ghomshodeyeManArianSongArtist = new HashSet<String>();
        ghomshodeyeManArianSongArtist.add("Arian Band");
        Map<String ,String>ghomshodeyeManArianSongFeatures = new HashMap<String, String>();
        ghomshodeyeManArianSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Gomshedeye Man",ghomshodeyeManArianSongArtist,"Unavailable","Persian Pop","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/gomshodeye-man.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", ghomshodeyeManArianSongFeatures);

        Set<String> kabootarayeSepidArianSongArtist = new HashSet<String>();
        kabootarayeSepidArianSongArtist.add("Arian Band");
        Map<String ,String>kabootarayeSepidArianSongFeatures = new HashMap<String, String>();
        kabootarayeSepidArianSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Kabotaraye Sepid",kabootarayeSepidArianSongArtist,"Unavailable","Persian Pop","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/kabootarhaye-sepid.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", kabootarayeSepidArianSongFeatures);

        Set<String> kashkiArianSongArtist = new HashSet<String>();
        kashkiArianSongArtist.add("Arian Band");
        Map<String ,String>kashkiArianSongFeatures = new HashMap<String, String>();
        kashkiArianSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Kashki",kashkiArianSongArtist,"Unavailable","Persian Electronic","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/kashki.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", kashkiArianSongFeatures);

        Set<String> khorshidMashreghArianSongArtist = new HashSet<String>();
        khorshidMashreghArianSongArtist.add("Arian Band");
        Map<String ,String>khorshidMashreghSongFeatures = new HashMap<String, String>();
        khorshidMashreghSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Khorshide Eshgh",khorshidMashreghArianSongArtist,"Unavailable","Persian Electronic","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/khorshide-eshgh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", khorshidMashreghSongFeatures);

        Set<String> mageMisheArianSongArtist = new HashSet<String>();
        mageMisheArianSongArtist.add("Arian Band");
        Map<String ,String>mageMisheArianSongFeatures = new HashMap<String, String>();
        mageMisheArianSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Mage Mishe",mageMisheArianSongArtist,"Unavailable","Persian Slow Pop","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/mage-mishe.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", mageMisheArianSongFeatures);

        Set<String> shaparakArianSongArtist = new HashSet<String>();
        shaparakArianSongArtist.add("Arian Band");
        Map<String ,String>shaparakArianSongFeatures = new HashMap<String, String>();
        shaparakArianSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Shaparak",shaparakArianSongArtist,"Unavailable","Persian Electronic","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/shaparak.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", shaparakArianSongFeatures);

        Set<String> sokootArianSongArtist = new HashSet<String>();
        sokootArianSongArtist.add("Arian Band");
        Map<String ,String>sokootArianSongFeatures = new HashMap<String, String>();
        sokootArianSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Sokoot",sokootArianSongArtist,"Unavailable","Persian Pop","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/sokoot.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", sokootArianSongFeatures);

        Set<String> telesmArianSongArtist = new HashSet<String>();
        telesmArianSongArtist.add("Arian Band");
        Map<String ,String>telesmArianSongFeatures = new HashMap<String, String>();
        telesmArianSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Telesm",telesmArianSongArtist,"Unavailable","Persian Pop","Ta Binahayat",commonFile.getInitsongpath() + commonFile.getSeparator() + "arian/ta-binahayat/telesm.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", telesmArianSongFeatures);

        Set<String> baManBemoonFereydoonSongArtist = new HashSet<String>();
        baManBemoonFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>baManBemoonFereydoonSongFeatures = new HashMap<String, String>();
        baManBemoonFereydoonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Ba Man Bemoon",baManBemoonFereydoonSongArtist,"Unavailable","Persian Slow Pop","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/ba-man-bemoon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", baManBemoonFereydoonSongFeatures);

        Set<String> biaBerimFereydoonSongArtist = new HashSet<String>();
        biaBerimFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>biaBerimFereydoonSongFeatures = new HashMap<String, String>();
        biaBerimFereydoonSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Bia Berim",biaBerimFereydoonSongArtist,"Unavailable","Persian Electronic","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/bia-berim.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", biaBerimFereydoonSongFeatures);

        Set<String> booyeSibFereydoonSongArtist = new HashSet<String>();
        booyeSibFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>booyeSibFereydoonSongFeatures = new HashMap<String, String>();
        booyeSibFereydoonSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Booye Sib",booyeSibFereydoonSongArtist,"Unavailable","Persian Pop","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/booye-sib.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", booyeSibFereydoonSongFeatures);

        Set<String> djMixFereydoonSongArtist = new HashSet<String>();
        djMixFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>djMixFereydoonSongFeatures = new HashMap<String, String>();
        djMixFereydoonSongFeatures.put("Genre", "mix");
        songServiceProvider.addNewSong("Fereydoon Remix",djMixFereydoonSongArtist,"Unavailable","mix","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/dj-mix.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", djMixFereydoonSongFeatures);

        Set<String> faselehaFereydoonSongArtist = new HashSet<String>();
        faselehaFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>faselehaSongFeatures = new HashMap<String, String>();
        faselehaSongFeatures.put("Genre", "Persian Latin");
        songServiceProvider.addNewSong("Faseleha",faselehaFereydoonSongArtist,"Unavailable","Persian Latin","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/faseleha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", faselehaSongFeatures);

        Set<String> gharibehFereydoonSongArtist = new HashSet<String>();
        gharibehFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>gharibehFereydoonSongFeatures = new HashMap<String, String>();
        gharibehFereydoonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gharibeh",gharibehFereydoonSongArtist,"Unavailable","Persian Slow Pop","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/gharibeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", gharibehFereydoonSongFeatures);

        Set<String> goleHayahooFereydoonSongArtist = new HashSet<String>();
        goleHayahooFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>goleHayahoofereydoonSongFeatures = new HashMap<String, String>();
        goleHayahoofereydoonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gole Hayahoo",goleHayahooFereydoonSongArtist,"Unavailable","Persian Slow Pop","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/gole-hayahoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", goleHayahoofereydoonSongFeatures);

        Set<String> khaterehFereydoonSongArtist = new HashSet<String>();
        khaterehFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>khaterehfereydoonSongFeatures = new HashMap<String, String>();
        khaterehfereydoonSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Kabootar",khaterehFereydoonSongArtist,"Unavailable","Persian Electronic","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/khatereh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", khaterehfereydoonSongFeatures);

        Set<String>khoneBeKhoneFereydoonSongArtist = new HashSet<String>();
        khoneBeKhoneFereydoonSongArtist.add("Fereydoon");
        Map<String ,String>khoneBeKhonefereydoonSongFeatures = new HashMap<String, String>();
        khoneBeKhonefereydoonSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Khoone Be Khoone",khoneBeKhoneFereydoonSongArtist,"Unavailable","Persian Pop","Gharibe",commonFile.getInitsongpath() + commonFile.getSeparator() + "fereydoon/gharibe/khooneh-be-khooneh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", khoneBeKhonefereydoonSongFeatures);

        Set<String>abeHayatShahramNazeriSongArtist = new HashSet<String>();
        abeHayatShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>abeHayatShahramNazeriSongFeatures = new HashMap<String, String>();
        abeHayatShahramNazeriSongFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Abe Hayat",abeHayatShahramNazeriSongArtist,"Unavailable","Persian Traditional","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/abe-hayat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", abeHayatShahramNazeriSongFeatures);

        Set<String>avazBaChangShahramNazeriSongArtist = new HashSet<String>();
        avazBaChangShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>avazBaChangShahramNazeriSongFeatures = new HashMap<String, String>();
        avazBaChangShahramNazeriSongFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Avaz Ba Chang",avazBaChangShahramNazeriSongArtist,"Unavailable","Persian Traditional","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/avaz-ba-chang.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", avazBaChangShahramNazeriSongFeatures);

        Set<String>larzanLarzanShahramNazeriSongArtist = new HashSet<String>();
        larzanLarzanShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>larzanLarzanShahramNazeriSongFeatures = new HashMap<String, String>();
        larzanLarzanShahramNazeriSongFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Larzan Larzan",larzanLarzanShahramNazeriSongArtist,"Unavailable","Persian Classic","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/larzan-larzan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", larzanLarzanShahramNazeriSongFeatures);

        Set<String>laylalyShahramNazeriSongArtist = new HashSet<String>();
        laylalyShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>laylalyShahramNazeriSongFeatures = new HashMap<String, String>();
        laylalyShahramNazeriSongFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Lay Laly",laylalyShahramNazeriSongArtist,"Unavailable","Persian Classic","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/lay-laly.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", laylalyShahramNazeriSongFeatures);

        Set<String>separiShahramNazeriSongArtist = new HashSet<String>();
        separiShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>separiShahramNazeriSongFeatures = new HashMap<String, String>();
        separiShahramNazeriSongFeatures.put("Genre", "Persian Classic");
        songServiceProvider.addNewSong("Separi",separiShahramNazeriSongArtist,"Unavailable","Persian Classic","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/separi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", separiShahramNazeriSongFeatures);

        Set<String>sheydaShodamShahramNazeriSongArtist = new HashSet<String>();
        sheydaShodamShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>sheydaShodamShahramNazeriSongFeatures = new HashMap<String, String>();
        sheydaShodamShahramNazeriSongFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Sheyda Shodam",sheydaShodamShahramNazeriSongArtist,"Unavailable","Persian Traditional","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/sheida-shodam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", sheydaShodamShahramNazeriSongFeatures);

        Set<String>shirinShirinShahramNazeriSongArtist = new HashSet<String>();
        shirinShirinShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>shirinShirinShodamShahramNazeriSongFeatures = new HashMap<String, String>();
        shirinShirinShodamShahramNazeriSongFeatures.put("Genre", "Persian Fusion");
        songServiceProvider.addNewSong("Shirin Shirin",shirinShirinShahramNazeriSongArtist,"Unavailable","Persian Fusion","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/shirin-shirin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", shirinShirinShodamShahramNazeriSongFeatures);

        Set<String>varanVaranShahramNazeriSongArtist = new HashSet<String>();
        varanVaranShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>varanVaranShodamShahramNazeriSongFeatures = new HashMap<String, String>();
        varanVaranShodamShahramNazeriSongFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Varan Varan",varanVaranShahramNazeriSongArtist,"Unavailable","Persian Traditional","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/varan-varan.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", varanVaranShodamShahramNazeriSongFeatures);

        Set<String>zeinDoHezaranManoMaShahramNazeriSongArtist = new HashSet<String>();
        zeinDoHezaranManoMaShahramNazeriSongArtist.add("Shahram Nazeri");
        Map<String ,String>zeinDoHezaranManoMaShodamShahramNazeriSongFeatures = new HashMap<String, String>();
        zeinDoHezaranManoMaShodamShahramNazeriSongFeatures.put("Genre", "Persian Traditional");
        songServiceProvider.addNewSong("Zein Do Hezaran Man o Ma",zeinDoHezaranManoMaShahramNazeriSongArtist,"Unavailable","Persian Traditional","Shahram Nazeri Live In Concert",commonFile.getInitsongpath() + commonFile.getSeparator() + "shahram-nazeri/live-in-concert/zein-do-hezaran-man-o-ma.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", zeinDoHezaranManoMaShodamShahramNazeriSongFeatures);

        Set<String>ebihamdamSongArtist = new HashSet<String>();
        ebihamdamSongArtist.add("Ebi");
        Map<String ,String>ebiHamdamSongFeatures = new HashMap<String, String>();
        ebiHamdamSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Delbar",ebihamdamSongArtist,"Unavailable","Persian 6/8 Dance","Gharibeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/gharibeh/hamdam.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-haribeh.jpg", ebiHamdamSongFeatures);

        Set<String>ebiGharibehSongArtist = new HashSet<String>();
        ebiGharibehSongArtist.add("Ebi");
        Map<String ,String>ebiGharibehSongFeatures = new HashMap<String, String>();
        ebiGharibehSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gharibeh-Ebi",ebiGharibehSongArtist,"Unavailable","Persian Slow Pop","Gharibeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/gharibeh/gharibeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-haribeh.jpg", ebiGharibehSongFeatures);

        Set<String>ebiKhorshideBihejabSongArtist = new HashSet<String>();
        ebiKhorshideBihejabSongArtist.add("Ebi");
        Map<String ,String>ebiKhorshideBihejabSongFeatures = new HashMap<String, String>();
        ebiKhorshideBihejabSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Khorshide Bihejab",ebiKhorshideBihejabSongArtist,"Unavailable","Persian Pop","Gharibeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/gharibeh/khorshide-bihejaab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-haribeh.jpg", ebiKhorshideBihejabSongFeatures);

        Set<String>ebiAabiSongArtist = new HashSet<String>();
        ebiAabiSongArtist.add("Ebi");
        Map<String ,String>ebiaabiSongFeatures = new HashMap<String, String>();
        ebiaabiSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Aabi",ebiAabiSongArtist,"Unavailable","Persian Pop","Gharibeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/gharibeh/aabi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-haribeh.jpg", ebiaabiSongFeatures);

        Set<String>ebiGhasedSongArtist = new HashSet<String>();
        ebiGhasedSongArtist.add("Ebi");
        Map<String ,String>ebiGhasedSongFeatures = new HashMap<String, String>();
        ebiGhasedSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Ghased",ebiGhasedSongArtist,"Unavailable","Persian Pop","Gharibeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/gharibeh/ghaased.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-haribeh.jpg", ebiGhasedSongFeatures);


        Set<String>ebiYeAsheghSongArtist = new HashSet<String>();
        ebiYeAsheghSongArtist.add("Ebi");
        Map<String ,String>ebiYeAsheghSongFeatures = new HashMap<String, String>();
        ebiYeAsheghSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Ye AShegh",ebiYeAsheghSongArtist,"Unavailable","Persian Pop","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/yeh-ashegh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiYeAsheghSongFeatures);

        Set<String>ebiHesseTanhaeeSongArtist = new HashSet<String>();
        ebiHesseTanhaeeSongArtist.add("Ebi");
        Map<String ,String>ebiHesseTanhaeeSongFeatures = new HashMap<String, String>();
        ebiHesseTanhaeeSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Hesse Tanhaee",ebiHesseTanhaeeSongArtist,"Unavailable","Persian Electronic","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/hesse-tanhee.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiHesseTanhaeeSongFeatures);

        Set<String>ebiBadBinSongArtist = new HashSet<String>();
        ebiBadBinSongArtist.add("Ebi");
        Map<String ,String>ebiBadbinSongFeatures = new HashMap<String, String>();
        ebiBadbinSongFeatures.put("Genre", "Persian Pop Dnace");
        songServiceProvider.addNewSong("Bad Bin",ebiBadBinSongArtist,"Unavailable","Persian Pop Dance","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/badbin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiBadbinSongFeatures);

        Set<String>ebiAsheghaneSongArtist = new HashSet<String>();
        ebiAsheghaneSongArtist.add("Ebi");
        Map<String ,String>ebiAsheghaneSongFeatures = new HashMap<String, String>();
        ebiAsheghaneSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Asheghane",ebiAsheghaneSongArtist,"Unavailable","Persian Electronic","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/asheghane.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiAsheghaneSongFeatures);

        Set<String>ebiKhodaBeMastSongArtist = new HashSet<String>();
        ebiKhodaBeMastSongArtist.add("Ebi");
        Map<String ,String>ebiKhodaBeMastSongFeatures = new HashMap<String, String>();
        ebiKhodaBeMastSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khoda Be Mast",ebiKhodaBeMastSongArtist,"Unavailable","Persian Slow Pop","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/khoda-ba-mast.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiKhodaBeMastSongFeatures);

        Set<String>ebiYeRooziSongArtist = new HashSet<String>();
        ebiYeRooziSongArtist.add("Ebi");
        Map<String ,String>ebiYeRooziSongFeatures = new HashMap<String, String>();
        ebiYeRooziSongFeatures.put("Genre", "Persian Rock");
        songServiceProvider.addNewSong("Ye Roozi",ebiYeRooziSongArtist,"Unavailable","Persian Rock","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/yeh-roozi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiYeRooziSongFeatures);

        Set<String>ebiNavazeshSongArtist = new HashSet<String>();
        ebiNavazeshSongArtist.add("Ebi");
        Map<String ,String>ebiNavazeshSongFeatures = new HashMap<String, String>();
        ebiNavazeshSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Navazesh",ebiNavazeshSongArtist,"Unavailable","Persian Slow Pop","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/navazesh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiNavazeshSongFeatures);

        Set<String>ebiBoghziBaroonSongArtist = new HashSet<String>();
        ebiBoghziBaroonSongArtist.add("Ebi");
        Map<String ,String>ebiBoghziBaroonSongFeatures = new HashMap<String, String>();
        ebiBoghziBaroonSongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Boghzo Baroon",ebiBoghziBaroonSongArtist,"Unavailable","Persian Flamenco/Spanish","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/boghz-o-baroon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiBoghziBaroonSongFeatures);

        Set<String>ebiPelkSongArtist = new HashSet<String>();
        ebiPelkSongArtist.add("Ebi");
        Map<String ,String>ebiPelkSongFeatures = new HashMap<String, String>();
        ebiPelkSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Pelk",ebiPelkSongArtist,"Unavailable","Persian Slow Pop","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/pelk.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiPelkSongFeatures);

        Set<String>ebijahanBiniSongArtist = new HashSet<String>();
        ebijahanBiniSongArtist.add("Ebi");
        Map<String ,String>ebijahanBiniSongFeatures = new HashMap<String, String>();
        ebijahanBiniSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Jahan Bini",ebijahanBiniSongArtist,"Unavailable","Persian Slow Pop","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/jahanbini.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebijahanBiniSongFeatures);

        Set<String>ebiTasmimSongArtist = new HashSet<String>();
        ebiTasmimSongArtist.add("Ebi");
        Map<String ,String>ebiTasmimSongSongFeatures = new HashMap<String, String>();
        ebiTasmimSongSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Tasmim",ebiTasmimSongArtist,"Unavailable","Persian Electronic","Hesse Tanhae",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/hesse-tanhae/tasmim.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiTasmimSongSongFeatures);

        Set<String>ebiKhorshiKhanoomSongArtist = new HashSet<String>();
        ebiKhorshiKhanoomSongArtist.add("Ebi");
        Map<String ,String>ebiKhorshidKhanoomSongFeatures = new HashMap<String, String>();
        ebiKhorshidKhanoomSongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Khorshid Khanoom",ebiKhorshiKhanoomSongArtist,"Unavailable","Persian Flamenco/Spanish","Khorshid Khanoom",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/khorshid-khanoom/khorshid-khanom.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-khorshid-khanom.jpg", ebiKhorshidKhanoomSongFeatures);

        Set<String>ebiCheBayadKardSongArtist = new HashSet<String>();
        ebiCheBayadKardSongArtist.add("Ebi");
        Map<String ,String>ebiCheBayadKardSongFeatures = new HashMap<String, String>();
        ebiCheBayadKardSongFeatures.put("Genre", "Persian Pop Dance");
        songServiceProvider.addNewSong("Che Bayad Kard",ebiCheBayadKardSongArtist,"Unavailable","Persian Pop Dance","Khorshid Khanoom",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/khorshid-khanoom/che-bayad-kard.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-khorshid-khanom.jpg", ebiCheBayadKardSongFeatures);

        Set<String>ebiGheseEshghSongArtist = new HashSet<String>();
        ebiGheseEshghSongArtist.add("Ebi");
        Map<String ,String>ebiGheseEshghSongFeatures = new HashMap<String, String>();
        ebiGheseEshghSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Ghese Eshgh",ebiGheseEshghSongArtist,"Unavailable","Persian 6/8 Dance","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/gheseh-eshgh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiGheseEshghSongFeatures);

        Set<String>ebiKooheYakhSongArtist = new HashSet<String>();
        ebiKooheYakhSongArtist.add("Ebi");
        Map<String ,String>ebiKooheYakhSongFeatures = new HashMap<String, String>();
        ebiKooheYakhSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Koohe Yakh",ebiKooheYakhSongArtist,"Unavailable","Persian Slow Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/kooh-yakh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiKooheYakhSongFeatures);

        Set<String>ebiBorjSongArtist = new HashSet<String>();
        ebiBorjSongArtist.add("Ebi");
        Map<String ,String>ebiBorjSongFeatures = new HashMap<String, String>();
        ebiBorjSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Borj",ebiBorjSongArtist,"Unavailable","Persian Slow Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/borj.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiBorjSongFeatures);

        Set<String>ebiPayizSongArtist = new HashSet<String>();
        ebiPayizSongArtist.add("Ebi");
        Map<String ,String>ebiPayizSongFeatures = new HashMap<String, String>();
        ebiPayizSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Paeiz",ebiPayizSongArtist,"Unavailable","Persian Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/paeiz.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiPayizSongFeatures);

        Set<String>ebiRahmKonSongArtist = new HashSet<String>();
        ebiRahmKonSongArtist.add("Ebi");
        Map<String ,String>ebiRahmKonSongFeatures = new HashMap<String, String>();
        ebiRahmKonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Rahm Kon",ebiRahmKonSongArtist,"Unavailable","Persian Slow Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/rahm-kon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiRahmKonSongFeatures);

        Set<String>ebiGoVajeSongArtist = new HashSet<String>();
        ebiGoVajeSongArtist.add("Ebi");
        Map<String ,String>ebiGoVajeSongFeatures = new HashMap<String, String>();
        ebiGoVajeSongFeatures.put("Genre", "Persian Pop Dance");
        songServiceProvider.addNewSong("Gol Vaje",ebiGoVajeSongArtist,"Unavailable","Persian Pop Dance","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/gole-vajeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiGoVajeSongFeatures);

        Set<String>ebiSafarSongArtist = new HashSet<String>();
        ebiSafarSongArtist.add("Ebi");
        Map<String ,String>ebiSafarSongFeatures = new HashMap<String, String>();
        ebiSafarSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Safar",ebiSafarSongArtist,"Unavailable","Persian Slow Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/safar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiSafarSongFeatures);

        Set<String>ebigharibehKooheYakhSongArtist = new HashSet<String>();
        ebigharibehKooheYakhSongArtist.add("Ebi");
        Map<String ,String>ebigharibehKooheYakhSongFeatures = new HashMap<String, String>();
        ebigharibehKooheYakhSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Gharibeeh",ebigharibehKooheYakhSongArtist,"Unavailable","Persian 6/8 Dance","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/gharibeh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebigharibehKooheYakhSongFeatures);

        Set<String>ebiJabeyeJavaherSongArtist = new HashSet<String>();
        ebiJabeyeJavaherSongArtist.add("Ebi");
        Map<String ,String>ebiJabeyeJavaherSongFeatures = new HashMap<String, String>();
        ebiJabeyeJavaherSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Jabeye Javaher",ebiJabeyeJavaherSongArtist,"Unavailable","Persian 6/8 Dance","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/javaher.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiJabeyeJavaherSongFeatures);

        Set<String>ebiManoBebakhshSongArtist = new HashSet<String>();
        ebiManoBebakhshSongArtist.add("Ebi");
        Map<String ,String>ebiManoBebakhshSongFeatures = new HashMap<String, String>();
        ebiManoBebakhshSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Mano Bebakhsh",ebiManoBebakhshSongArtist,"Unavailable","Persian Slow Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/mano-bebakhsh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiManoBebakhshSongFeatures);

        Set<String>ebiKhakestriSongArtist = new HashSet<String>();
        ebiKhakestriSongArtist.add("Ebi");
        Map<String ,String>ebiKhakestriSongFeatures = new HashMap<String, String>();
        ebiKhakestriSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khakerstari",ebiKhakestriSongArtist,"Unavailable","Persian Slow Pop","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/khakestari.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiKhakestriSongFeatures);

        Set<String>ebiGozashtehSongArtist = new HashSet<String>();
        ebiGozashtehSongArtist.add("Ebi");
        Map<String ,String>ebiGozashtehSongFeatures = new HashMap<String, String>();
        ebiGozashtehSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Gozashteh",ebiGozashtehSongArtist,"Unavailable","Persian 6/8 Dance","Koohe Yakh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/koohe-yakh/gozashteh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiGozashtehSongFeatures);

        Set<String>ebiMoalemeBadSongArtist = new HashSet<String>();
        ebiMoalemeBadSongArtist.add("Ebi");
        Map<String ,String>ebiMoalemeBadSongFeatures = new HashMap<String, String>();
        ebiMoalemeBadSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Moaleme Bad",ebiMoalemeBadSongArtist,"Unavailable","Persian Pop","Moaleme Bad",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/moaleme-bad/moaleme-bad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-moaleme-bad.jpg", ebiMoalemeBadSongFeatures);

        Set<String>ebiSadeghSongArtist = new HashSet<String>();
        ebiSadeghSongArtist.add("Ebi");
        Map<String ,String>ebiSadeghSongFeatures = new HashMap<String, String>();
        ebiSadeghSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Sadeghi",ebiSadeghSongArtist,"Unavailable","Persian Electronic","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/sadeg.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiSadeghSongFeatures);

        Set<String>ebiSetaryeDonbaledarSongArtist = new HashSet<String>();
        ebiSetaryeDonbaledarSongArtist.add("Ebi");
        Map<String ,String>ebiSetaryeDonbaledarSongFeatures = new HashMap<String, String>();
        ebiSetaryeDonbaledarSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Setareye Donbaledar",ebiSetaryeDonbaledarSongArtist,"Unavailable","Persian Pop","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/setareh-donbalehdar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiSetaryeDonbaledarSongFeatures);


        Set<String>ebiRazeghiSongArtist = new HashSet<String>();
        ebiRazeghiSongArtist.add("Ebi");
        Map<String ,String>ebiRazeghiSongFeatures = new HashMap<String, String>();
        ebiRazeghiSongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Razeghy",ebiRazeghiSongArtist,"Unavailable","Persian Flamenco/Spanish","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/razeghi.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiRazeghiSongFeatures);

        Set<String>ebiArezuSongArtist = new HashSet<String>();
        ebiArezuSongArtist.add("Ebi");
        Map<String ,String>ebiArezuSongFeatures = new HashMap<String, String>();
        ebiArezuSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Arezou",ebiArezuSongArtist,"Unavailable","Persian Slow Pop","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/arezoo.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiArezuSongFeatures);

        Set<String>ebiBavaramKonSongArtist = new HashSet<String>();
        ebiBavaramKonSongArtist.add("Ebi");
        Map<String ,String>ebiBavaramKonSongFeatures = new HashMap<String, String>();
        ebiBavaramKonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Bavaram Kon",ebiBavaramKonSongArtist,"Unavailable","Persian Slow Pop","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/bavaram-kon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiBavaramKonSongFeatures);

        Set<String>ebiKhaneSorkhSongArtist = new HashSet<String>();
        ebiKhaneSorkhSongArtist.add("Ebi");
        Map<String ,String>ebiKhaneSorkhSongFeatures = new HashMap<String, String>();
        ebiKhaneSorkhSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khane Sorkh",ebiKhaneSorkhSongArtist,"Unavailable","Persian Slow Pop","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/khaneh-sorkh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiKhaneSorkhSongFeatures);

        Set<String>ebiRoozegarSongArtist = new HashSet<String>();
        ebiRoozegarSongArtist.add("Ebi");
        Map<String ,String>ebiRoozegarSongFeatures = new HashMap<String, String>();
        ebiRoozegarSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Roozegar",ebiRoozegarSongArtist,"Unavailable","Persian Pop","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/roozegar.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiRoozegarSongFeatures);

        Set<String>ebiGoleSorkhSongArtist = new HashSet<String>();
        ebiGoleSorkhSongArtist.add("Ebi");
        Map<String ,String>ebiGoleSorkhSongFeatures = new HashMap<String, String>();
        ebiGoleSorkhSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Gole Sorkh",ebiGoleSorkhSongArtist,"Unavailable","Persian Slow Pop","Setareye Donbaledar",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/setare-donbale-dar/gole-sorkh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebiGoleSorkhSongFeatures);

        Set<String>ebiShabSongArtist = new HashSet<String>();
        ebiShabSongArtist.add("Ebi");
        Map<String ,String>ebiShabSongFeatures = new HashMap<String, String>();
        ebiShabSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shab",ebiShabSongArtist,"Unavailable","Persian Slow Pop","Pir",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/pir/shab.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-pir.jpg", ebiShabSongFeatures);

        Set<String>ebiShabZadehSongArtist = new HashSet<String>();
        ebiShabZadehSongArtist.add("Ebi");
        Map<String ,String>ebiShabZadehSongFeatures = new HashMap<String, String>();
        ebiShabZadehSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Shabzadeh",ebiShabZadehSongArtist,"Unavailable","Persian Slow Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/shabzade.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiShabZadehSongFeatures);

        Set<String>ebiAsalSongArtist = new HashSet<String>();
        ebiAsalSongArtist.add("Ebi");
        Map<String ,String>ebiAsalSongFeatures = new HashMap<String, String>();
        ebiAsalSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Asal",ebiAsalSongArtist,"Unavailable","Persian Slow Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/asal.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiAsalSongFeatures);

        Set<String>ebiPichakSongArtist = new HashSet<String>();
        ebiPichakSongArtist.add("Ebi");
        Map<String ,String>ebiPichakSongFeatures = new HashMap<String, String>();
        ebiPichakSongFeatures.put("Genre", "Persian Flamenco/Spanish");
        songServiceProvider.addNewSong("Pichak",ebiPichakSongArtist,"Unavailable","Persian Flamenco/Spanish","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/pichak.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiPichakSongFeatures);

        Set<String>ebiGhorbatSongArtist = new HashSet<String>();
        ebiGhorbatSongArtist.add("Ebi");
        Map<String ,String>ebiGhorbatSongFeatures = new HashMap<String, String>();
        ebiGhorbatSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Ghorbat",ebiGhorbatSongArtist,"Unavailable","Persian Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/ghorbat.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiGhorbatSongFeatures);

        Set<String>ebiKhorjinSongArtist = new HashSet<String>();
        ebiKhorjinSongArtist.add("Ebi");
        Map<String ,String>ebiKhorjinSongFeatures = new HashMap<String, String>();
        ebiKhorjinSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khorjin",ebiKhorjinSongArtist,"Unavailable","Persian Slow Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/khorjin.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiKhorjinSongFeatures);

        Set<String>ebiKhatoonSongArtist = new HashSet<String>();
        ebiKhatoonSongArtist.add("Ebi");
        Map<String ,String>ebiKhatoonSongFeatures = new HashMap<String, String>();
        ebiKhatoonSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khatoon",ebiKhatoonSongArtist,"Unavailable","Persian Slow Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/khatoon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiKhatoonSongFeatures);

        Set<String>ebiSabadSabadSongArtist = new HashSet<String>();
        ebiSabadSabadSongArtist.add("Ebi");
        Map<String ,String>ebiSabadSabadSongFeatures = new HashMap<String, String>();
        ebiSabadSabadSongFeatures.put("Genre", "Persian 6/8 Dance");
        songServiceProvider.addNewSong("Sabad Sabad",ebiSabadSabadSongArtist,"Unavailable","Persian 6/8 Dance","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/sabad-sabad.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiSabadSabadSongFeatures);

        Set<String>ebiKhaliSongArtist = new HashSet<String>();
        ebiKhaliSongArtist.add("Ebi");
        Map<String ,String>ebiKhaaliSongFeatures = new HashMap<String, String>();
        ebiKhaaliSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Khaali",ebiKhaliSongArtist,"Unavailable","Persian Slow Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/khaali.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiKhaaliSongFeatures);

        Set<String>ebiRazeHameshegiSongArtist = new HashSet<String>();
        ebiRazeHameshegiSongArtist.add("Ebi");
        Map<String ,String>ebiRazeHameshegiSongFeatures = new HashMap<String, String>();
        ebiRazeHameshegiSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Raze Hameshegi",ebiRazeHameshegiSongArtist,"Unavailable","Persian Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/raz-hamishegi.MP3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiRazeHameshegiSongFeatures);

        Set<String>ebiMolayeSabzPooshSongArtist = new HashSet<String>();
        ebiMolayeSabzPooshSongArtist.add("Ebi");
        Map<String ,String>ebiMolayeSabzPooshSongFeatures = new HashMap<String, String>();
        ebiMolayeSabzPooshSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Molaye Sabz Pooosh",ebiMolayeSabzPooshSongArtist,"Unavailable","Persian Pop","Shabzadeh",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shab-zadeh/molay-sabz-posh.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiMolayeSabzPooshSongFeatures);

        Set<String>ebiDerakhtSongArtist = new HashSet<String>();
        ebiDerakhtSongArtist.add("Ebi");
        Map<String ,String>ebiDerakhtSongFeatures = new HashMap<String, String>();
        ebiDerakhtSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Derakht",ebiDerakhtSongArtist,"Unavailable","Persian Slow Pop","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/derakht.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiDerakhtSongFeatures);

        Set<String>ebiTahamolKonSongArtist = new HashSet<String>();
        ebiTahamolKonSongArtist.add("Ebi");
        Map<String ,String>ebiTahamolKonSongFeatures = new HashMap<String, String>();
        ebiTahamolKonSongFeatures.put("Genre", "Persian Pop");
        songServiceProvider.addNewSong("Tahamol Kon",ebiTahamolKonSongArtist,"Unavailable","Persian Pop","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/tahamol-kon.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiTahamolKonSongFeatures);

        Set<String>ebiVaghtyToGeryeMikoniSongArtist = new HashSet<String>();
        ebiVaghtyToGeryeMikoniSongArtist.add("Ebi");
        Map<String ,String>ebiVaghtyToGeryeMikoniSongFeatures = new HashMap<String, String>();
        ebiVaghtyToGeryeMikoniSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Vaghti To Gerye Mikoni",ebiVaghtyToGeryeMikoniSongArtist,"Unavailable","Persian Slow Pop","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/vaghti-to-gerye-mikoni.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiVaghtyToGeryeMikoniSongFeatures);

        Set<String>ebiShabeNiloofariSongArtist = new HashSet<String>();
        ebiShabeNiloofariSongArtist.add("Ebi");
        Map<String ,String>ebiShabeNiloofariSongFeatures = new HashMap<String, String>();
        ebiShabeNiloofariSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Shabe Niloofari",ebiShabeNiloofariSongArtist,"Unavailable","Persian Electronic","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/shabe-niloufari.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiShabeNiloofariSongFeatures);

        Set<String>ebiChiziBegooSongArtist = new HashSet<String>();
        ebiChiziBegooSongArtist.add("Ebi");
        Map<String ,String>ebiChiziBegooSongFeatures = new HashMap<String, String>();
        ebiChiziBegooSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Chizi Begoo",ebiChiziBegooSongArtist,"Unavailable","Persian Electronic","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/chizi-begu.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiChiziBegooSongFeatures);

        Set<String>ebiTandisSongArtist = new HashSet<String>();
        ebiTandisSongArtist.add("Ebi");
        Map<String ,String>ebiTandisSongFeatures = new HashMap<String, String>();
        ebiTandisSongFeatures.put("Genre", "Persian Slow Pop");
        songServiceProvider.addNewSong("Tandis",ebiTandisSongArtist,"Unavailable","Persian Slow Pop","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/tandis.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiTandisSongFeatures);

        Set<String>ebiSiahPooshaSongArtist = new HashSet<String>();
        ebiSiahPooshaSongArtist.add("Ebi");
        Map<String ,String>ebiSiahPooshaSongFeatures = new HashMap<String, String>();
        ebiSiahPooshaSongFeatures.put("Genre", "Persian Electronic");
        songServiceProvider.addNewSong("Siah Poosha",ebiSiahPooshaSongArtist,"Hanoozam mishe ghorbanie in","Persian Electronic","Shabe Niloofari",commonFile.getInitsongpath() + commonFile.getSeparator() + "ebi/shabe-niloofari/siah-pousha.mp3", commonFile.getInitsongartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiSiahPooshaSongFeatures);
        
        return null;
    }

}
