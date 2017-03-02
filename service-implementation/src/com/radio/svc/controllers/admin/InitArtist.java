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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author fxh155
 */
public class InitArtist extends AbstractController {
    
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


//Adding Artist
//
//        Map<String, String> nooshafarinFeatures = new HashMap<String, String>();
//        nooshafarinFeatures.put("Genre", "Persian 6/8 Dance");
//        artistServiceProvider.addNewArtist("Nooshafarin", "Fatima Abdi, better known by her stage name Nooshafarin, is an Iranian singer. " +
//                                                          "She initially moved to India in 1986. She then moved to L.A. in 1992. She was " +
//                                                          "born on March 2, 1956 , Gilan Province, Iran",
//                                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "nooshafrin.jpg", nooshafarinFeatures);
//
//        Map<String, String> shahramFeatures  = new HashMap<String, String>();
//        shahramFeatures.put("Genre", "Persian 6/8 Dance");
//        artistServiceProvider.addNewArtist("Shahram Shapareh","He started his career as a drum player in the early 1960s when he was only 13." +
//                                           " In the mid 1960s at the age of 17, he formed a band of his own named Rebells. After the Islamic revolution" +
//                                           " in 1979, Shahram, who had migrated to California a few years earlier, did not have the opportunity to return " +
//                                           "to his homeland. Since then, he has been living in the United States. After a career spanning 50 years, he is a " +
//                                           "one of the most popular artists in the Iranian society and his concerts are well received by Iranians all over the world.",
//                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "shahram-shapareh.jpg", shahramFeatures);
//
//        Map<String,String> ebiFeatures = new HashMap<String, String>();
//        ebiFeatures.put("Genre", "Persian Pop");
//        artistServiceProvider.addNewArtist("Ebi","Ebrahim Hamedi, known better by his stage name Ebi, is one of the most famous and influential Iranian " +
//                                           "singers of his time. He is widely known for his expressive voice and is considered one of the best singers of his generation" +
//                                            "He was born June 19, 1949", commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "ebi.jpg",ebiFeatures);
//
//        Map<String, String> babakFeatures  = new HashMap<String, String>();
//        babakFeatures.put("Genre", "Persian Pop Dance");
//        artistServiceProvider.addNewArtist("Babak Rahnama", "Babak Rahnama is a Persian Trance singer and DJ", commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "babak-rahnama.jpg", babakFeatures);
//
//        Map<String, String> barobaxFeatures =  new HashMap<String, String>();
//        babakFeatures.put("Genre", "Persian Pop Dance");
//        artistServiceProvider.addNewArtist("Baro Bax","Barobax are an underground Iranian pop band with all the three members living in Tehran, Iran. " +
//                                            "Like many other forms of music in Iran, their music is censored domestically.", commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "barobax.jpg", barobaxFeatures);
//
//        Map<String, String > arashFeatures = new HashMap<String, String>();
//        arashFeatures.put("Genre", "Persian Pop Dance");
//        artistServiceProvider.addNewArtist("Arash","Arash Labaf was born in Tehran, Iran. At age ten, he and his family moved to Sweden, where he still resides." +
//                                           " In an interview with BBC Persian Television, he has mentioned that his mother and father are from the Iranian cities of Shiraz and Isfahan, respectively." +
//                                           " Also in one of his interviews, he stated his great grandfather is Iranian Azerbaijani. In an interview with " +
//                                           "Arash emphasized: My great-grandfather was an Azeri so I always feel my Azerbaijani roots.", commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "arash.jpg", arashFeatures);
//
//
//        Map<String,String> hosseinTohiFeatures = new HashMap<String, String>();
//        hosseinTohiFeatures.put("Genre", "Persian Hip-Hop");
//        artistServiceProvider.addNewArtist("Hossein Tohi","Hossein Mousavi or better known with his stage name Hossein Tohi was one of the first artists who introduced Rap/Hip-Hop music.",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "hossein-tohi.jpg" , hosseinTohiFeatures);
//
//        Map<String, String> siavashShamsFeatures = new HashMap<String, String>();
//        siavashShamsFeatures.put("Genre", "Pesian Pop");
//        artistServiceProvider.addNewArtist("Siavash Shams","When Siavash Shams introduced himself to the public with his first album, Hamsayeh Haa (Neighbors) in 1985, many believed that a " +
//                                           "new wave of Iranian popular music had been born. His first public appearance was recorded by members of the Iranian community in the U.S. who had " +
//                                           "fled their homeland after the Islamic Revolution. He was born January 26, 1962 in Ahvaz, Iran", commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "siavash-shams.jpg",siavashShamsFeatures);
//
//
//        Map<String, String> sinaHejaziFeatures = new HashMap<String, String>();
//        sinaHejaziFeatures.put("Genre", "Persian Slow Pop");
//        artistServiceProvider.addNewArtist("Sina Hejazi", "Sine Hejazi was born on 1982. He released his first song on 2007. His extraordinary songs made him very famous among Iranian youth. ",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "sina-hejazi.jpg", sinaHejaziFeatures);
//
//        Map<String, String> xaniarFeatures = new HashMap<String, String>();
//        xaniarFeatures.put("Genre", "Persian Electronic");
//        xaniarFeatures.put("Genre","Persian Pop Dance");
//        artistServiceProvider.addNewArtist("Xaniar", "Xaniar Khosravi (Born in 1986 in Tehran, Iran) is an Iranian Pop/Hip Hop singer, composer, lyricist and actor. He began pursuing music at " +
//                                                    "about the age of 7 at the same time as his older brother Sirvan, who is also a popular singer ",
//                                                    commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "xaniar.jpg", xaniarFeatures);
//
//        Map<String, String> saraNaeiniFeatures = new HashMap<String, String>();
//        saraNaeiniFeatures.put("Genre", "Persian Jazz");
//        artistServiceProvider.addNewArtist("Sara Naeini", "Sara Naeini born on 22nd of Jun 1981.number one champion of Iran in gymnastic since she was 8 years old." +
//                                            "She interred the world of music when she was 18 by performing solo in a private concert held in a house, lasting 3 nights, each night 2 performances." +
//                                            "After that she participated in many albums and concerts as a back vocalist, and worked with some bands as a member. ",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "sara-naeini.jpg", saraNaeiniFeatures);

//////        Map<String, String> benyaminFeatures = new HashMap<String, String>();
//////        benyaminFeatures.put("Genre", "Persian Pop");
//////        artistServiceProvider.addNewArtist("Benyamin", "Benyamin Bahadori is an Iranian singer of Persian pop music from Tehran, Iran. His 2006 album 85 was a commercial" +
//////                                           "success within Iran and with the Iranian diaspora abroad. His most famous songs include Khatereha" +
//////                                           "In September 2006, Bahadori traveled to Sweden to have concerts in Tantolunden, Hornstull and Stockholm." +
//////                                           "Bahadori is also famous for his religious-themed compositions. Bahadori married Nasim Heshmati in February 2003." +
//////                                           " His wife died in a car accident in Tehran on 21 December 2013. The couple had a daughter and her name is Baran. ",
//////                                             commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "benyamin-bahadori.jpg", benyaminFeatures);
//////
//////        Map<String, String> javadBadiZadehFeatures = new HashMap<String, String>();
//////        javadBadiZadehFeatures.put("Genre", "Persian Contemporary Pop");
//////        artistServiceProvider.addNewArtist("Javad BadiZadeh", "Javad Badi'Zadeh was born in 1901 in Tehran. He was one of the first singers who performed at Radio Iran" +
//////                                           " and with the National Music Society Orchestra, conducted by Rouhollah Khaleghi. In the 1940s he recorded many of his songs, " +
//////                                           "including Jelve-ye Gol, shekve-ye Del, Bolbol-e Mahbus, and Jana Hezaran Afarin (accompanied by Morteza Mahjoubi). He had a good" +
//////                                           " command of the Persian traditional music and was one of the first singers who wrote the music for his songs. His most famous melody," +
//////                                           " Khazane Eshgh, has lyrics by Rahi Moayyeri. ",
//////                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "javad-badi-zadeh.jpg", javadBadiZadehFeatures);
//////
//////        Map<String, String> amirAliA2Features = new HashMap<String, String>();
//////        amirAliA2Features.put("Genre", "Persian Rap");
//////        artistServiceProvider.addNewArtist("A2", "Born in Tehran, March 1988, Amirali aka A2  started rapping under alias “Double A” in highschool and continued his career through" +
//////                                           " the highest levels of persian hip hop since releasing his debut “khaterehaye ghabli” in 2007. His style of rhyming and performing affected many " +
//////                                           "rappers since then despite the small number of tracks he has released to the day.",
//////                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "amirali.jpg", amirAliA2Features);
//////
////        Map<String, String> andyFeatures = new HashMap<String, String>();
////        andyFeatures.put("Genre", "Persian 6/8 Dance");
////        artistServiceProvider.addNewArtist("Andy", "Andranik Madadian, better known by his stage name, Andy , was born 1958 is a famous Armenian-Iranian singer-songwriter. Andy made it big when " +
////                                           "he joined Kouros Shahmiri and together formed a successful duo Andy & Kouros.Andy & Kouros released 4 albums together: Khastegary (1985), Parvaz (1988)," +
////                                           " the hugely successful album 'Balla', and finally Goodbye (1991). The two split in 1992. Andy married his longtime girlfriend and artist Shani Rigsbee on" +
////                                           " November 11, 2011.",
////                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "andy-madadian.jpg", andyFeatures);
////
////        Map<String, String> arianFeatures = new HashMap<String, String>();
////        arianFeatures.put("Genre", "Persian Pop");
////        artistServiceProvider.addNewArtist("Arian Band", "On 22 Nov. 1999, the band appeared and performed on the stage. ARIAN performed it’s first overseas concert in Manama (Bahrain) and with its thereof" +
////                                           " success, performed a very successful Concert in Dubai (U.A.E). They recorded their first album on Sep 10th, 2000.",
////                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "arian-band.jpg", arianFeatures);
//
//        Map<String, String> blackCatsFeatures = new HashMap<String, String>();
//        blackCatsFeatures.put("Genre", "Persian Pop Dance");
//        artistServiceProvider.addNewArtist("Black Cats", "Black Cats is the name of an Iranian pop music band founded by Shahbal Shabpareh. The band play a traditional upbeat style of Persian pop music, but " +
//                                           "are also known to bring in Jazz, R&B, Hip-Hop, Rave and Rapcore influences into their music as well. The most famous and successful members were Pyruz and David (1992- 1999).",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "black-cats.jpg", blackCatsFeatures);
//
//        Map<String, String> googooshFeatures = new HashMap<String, String>();
//        googooshFeatures.put("Genre", "Persian Pop");
//        artistServiceProvider.addNewArtist("Googoosh", "Faegheh Atashin, born on 5 May 1950 in Tehran, also known by her stage name Googoosh, is an Iranian singer and actress. She is known for her contributions to Iranian" +
//                                           " pop music, but also starred in a variety of movies from the 1950s to the 1970s. She achieved the pinnacle of her fame and success towards the end of the 1970s. Her overall impact" +
//                                           " and contributions to Middle Eastern and Central Asian pop-music earned her the title of the most iconic female pop-singer from those regions. She has recorded songs in Italian " +
//                                           "and in Spanish language. Due to her great talents and overall endearment to her people, she is a symbol of national pride to the people from Iran.",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "googoosh.jpg", googooshFeatures);
//
//        Map<String, String>paletFeatures = new HashMap<String, String>();
//        paletFeatures.put("Genre", "Persian Fusion");
//        artistServiceProvider.addNewArtist("Pallet", "Formed in November 2010, Pallet is an Iranian Fusion/Jazz band, consisting of Daryoush Azar, Rouzbeh Esfandarmaz, Kaveh Salehi, Mahyar Tahmasebi, Hesam Mohammadinanpour &" +
//                                           " Omid Nemati; with collaborators such as Khatereh Hakimi, Mehdi Saki & Faraz Aghili.",
//                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "pallet.jpg", paletFeatures);

//        Map<String, String>martikFeatures = new HashMap<String, String>();
//        martikFeatures.put("Genre", "Persian Pop");
//        artistServiceProvider.addNewArtist("Martik", "Martik Gharakhanian, was born on July 17, 1949 Abadan/Iran. He began his professional musical career at the age of fifteen, has been at the helm of the contemporary Iranian music " +
//                                           "scene for the past 40 years, and remains one of its most popular and beloved stars.In addition to being a gifted guitarist and songwriter, he is blessed" +
//                                           " with a soulful voice that is endowed with a unique tonality, tenderness, and velvety softness that mesmerizes his audience. In the 1970’s, he helped " +
//                                           "bring the best of Classic Rock and R&B to a thirsty and appreciative audience in Iran. ",
//                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "martik.jpg", martikFeatures);
//
//        Map<String, String>siavashGhomeyshiFeatures = new HashMap<String, String>();
//        siavashGhomeyshiFeatures.put("Genre", "Persian Pop");
//        artistServiceProvider.addNewArtist("Siavash Ghomeyshi", "Siavash Ghomayshi was born 11 June 1945 in Ahvaz, Iran. He is an Iranian musician, singer and song writer. Siavash" +
//                                           " studied music in London where he received his Master's degree from Royal Society of Arts. He left Iran after 1978 and now lives in Los Angeles." +
//                                           "He started his career as a composer when he was just 12. Siavash holds a Master's degree in classical jazz from Royal Society of Arts in London, England,",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "siavash-ghomeyshi.jpg", siavashGhomeyshiFeatures);
//
//        Map<String, String>farhadFeatures = new HashMap<String, String>();
//        farhadFeatures.put("Genre", "Persian Jazz");
//        artistServiceProvider.addNewArtist("Farhad", "Farhad Mehrad was born on January 20, 1944. He was widely known in Iran as Farhad was an award winning Iranian rock singer," +
//                                           " songwriter, guitarist, pianist and icon. He rose to prominence among Iranian rock and folk musicians before the Iranian Revolution, but after" +
//                                           " the revolution he was banned from singing for several years. His first concert after the Iranian Revolution was held in 1993. To this day he is" +
//                                           " considered one of the most influential and respected Iranian artists of all time.",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "farhad.jpg", farhadFeatures);
//
//
//        Map<String, String>haydehFeatures = new HashMap<String, String>();
//        haydehFeatures.put("Genre", "Persian Pop");
//        artistServiceProvider.addNewArtist("Hayedeh", "Hayedeh, Masoumeh Dadehbala, was born on April 10, 1942. She was an Iranian singer with a contralto vocal range. In a career spanning more " +
//                                            "than two decades, she had countless number of hits. Two decades after her death, Hayedeh is considered one of the most influential and iconic Persian" +
//                                           " vocalists of all time and is still recognized as one of the Iran's most famous and distinguished singers of the 20th century. She passed away on January 20, 1990",
//                                             commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "hayedeh.jpg", haydehFeatures);
//
//        Map<String, String>mohsenChavoshiFeatures = new HashMap<String, String>();
//        mohsenChavoshiFeatures.put("Genre", "Persian Slow Pop");
//        artistServiceProvider.addNewArtist("Mohsen Chavoshi", "Mohsen Chavoshi Hosseini was born 30 July 1979 is an Iranian musician, singer, record producer and songwriter. He lives in Tehran " +
//                                           "He has released nine albums including a soundtrack to 2007 film Santouri",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "mohsen-chavoshi.jpg", mohsenChavoshiFeatures);
//
//
//        Map<String, String>chaartarFeatures = new HashMap<String, String>();
//
//        chaartarFeatures.put("Genre", "Persian Electronic");
//        artistServiceProvider.addNewArtist("Chaartaar", "Chaartaar Band",
//                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "chaartaar.jpg", chaartarFeatures);
//
//
//        Map<String, String>sirvanFeatures = new HashMap<String, String>();
//       
//        sirvanFeatures.put("Genre", "Persian Electronic");
//        artistServiceProvider.addNewArtist("Sirvan", "Sirvan Khosravi is an Iranian pop singer, musician, composer, music arranger, voice recorder and recording supervisor." +
//                                            " He is older brother of Xaniar Khosravi, who is also a Pop and Rap singer. ",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "sirvan-khosravi.jpg", sirvanFeatures);
//
//
//        Map<String, String>darisuhFeatures = new HashMap<String, String>();
//        darisuhFeatures.put("Genre", "Persian Pop");
//
//        artistServiceProvider.addNewArtist("Dariush", "Dariush Eghbali better known by his stage name Dariush is an Iranian singer and songwriter best known for his " +
//                                           "warm and poignant bass voice heard in both ballads and socio- political songs.",
//                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "dariush.jpg", darisuhFeatures);
//
//
//
//        Map<String, String>marjanFarsadFeatures = new HashMap<String, String>();
//        marjanFarsadFeatures.put("Genre", "Persian Fusion");
//        artistServiceProvider.addNewArtist("Marjan Farsad", "Born in 1983 in Tehran, Iran, Marjan Farsad is an animation filmmaker, illustrator, " +
//                                           "singer and songwriter. Her first collection of romantic songs from Marjan Farsad which takes a new direction " +
//                                            "in Iranian contemporary music with a dream-like and nostalgic mood.",
//                                             commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "marjan-farsad.jpg", marjanFarsadFeatures);


        Map<String, String>erfanFeatures = new HashMap<String, String>();
        erfanFeatures.put("Genre", "Persian Rap");
        artistServiceProvider.addNewArtist("Erfan", "Erfan Hajrasuliha, better known as Erfan, is an Iranian rapper and producer." +
                                           " His views are a result of his personal experiences and that is reflected in his poems. His songs provide" +
                                           " a mixture of commentary on daily life as well politics, poetry and social issues. Erfan was born in Isfahan," +
                                           " Iran, on August 3, 1983",
                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "erfan.jpg", erfanFeatures);


        Map<String, String>homayounShajarianFeatures = new HashMap<String, String>();
        homayounShajarianFeatures.put("Genre", "Persian Traditional");
        artistServiceProvider.addNewArtist("Homayoun Shajarian", "Homayoun Shajarian was born 21 May 1975 is a renowned Persian classical music vocalist, " +
                                           "as well as a Tombak and Kamancheh player. He was born in Tehran in a music-dedicated family. He is the son of" +
                                           " Mohammad Reza Shajarian, the grand master vocalist of Persian traditional music.",
                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "homayoun-shajarian.jpg", homayounShajarianFeatures);


        Map<String, String>kioskFeatures = new HashMap<String, String>();
        kioskFeatures.put("Genre", "Persian Rock");
        artistServiceProvider.addNewArtist("Kiosk", "Kiosk is an underground Iranian music band founded in 2003 by Arash Sobhani in Tehran. Like many" +
                                           " other bands in Iran, the Islamic Republic's strict censorship laws prohibiting most forms of music, forced" +
                                           " Kiosk to produce and play their music in the secrecy of their friends and families basements. Since Kiosk's" +
                                           " inception their music has been politicised yet humorous. Their political and social commentary, critical of" +
                                           " the clergy and state censorship of music, would often entail band members becoming embroiled in trouble with" +
                                           " the state. As a result, Kiosk - like so many other Iranian bands - stayed underground until their eventual" +
                                           " decision to move overseas; allowing them to finally move overground.",
                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "kiosk-band.jpg", kioskFeatures);


        Map<String, String>mohsenNamjooFeatures = new HashMap<String, String>();
        mohsenNamjooFeatures.put("Genre", "Persian Fusion");
        artistServiceProvider.addNewArtist("Mohsen Namjoo", "Mohsen Namjoo was born in 1976 in Torbat-e Jam, a small town in northeastern Iran. In late 1997 and early 1998, Namjoo had" +
                                           " his first two concerts is an Iranian musician, singer-songwriter. His style of music is influenced by Blues" +
                                           " and Rock as well as Iranian folk music. The lyrics of his songs are also odd combination of Persian classical " +
                                           "poems, his own lyrics, and contemporary poems; and uses the words freely with irony and sarcasm to carry the" +
                                           " music and make a free style of singing. An Iranian correspondent for The New York Times in Iran wrote that " +
                                           "\"some call him a sort of Bob Dylan of Iran\".",
                                           commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "mohsen-namjoo.jpg", mohsenNamjooFeatures);

        Map<String, String>trafficBandFeatures = new HashMap<String, String>();
        trafficBandFeatures.put("Genre", "Persian Rock");
                                            artistServiceProvider.addNewArtist("Traffic Band", "Not Enough Information Available",
                                            commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "traffic.jpg", trafficBandFeatures);

        Map<String, String>mortezaAhmadiFeatures = new HashMap<String, String>();
        mortezaAhmadiFeatures.put("Genre", "Persian Folklore");
        artistServiceProvider.addNewArtist("Morteza Ahmadi", "Morteza Ahmadi is an old Persian actor who is also a Folklore singer.",
                                         commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "morteza-ahmadi.jpg", mortezaAhmadiFeatures);

        Map<String, String>shadmehrAghiliFeatures = new HashMap<String, String>();
        shadmehrAghiliFeatures.put("Genre", "Persian Electronic");
        artistServiceProvider.addNewArtist("Shadmehr Aghili", "Shadmehr Aghili was born 27 January 1973. He is an Iranian pop singer, musician, composer," +
                " music arranger, producer and song-writer, and formerly an actor. Aghili was born in Tehran, Iran. He emigrated to Canada first," +
                " but currently resides in Los Angeles. Aghili started early in music and studied piano, guitar and violin, graduated from the Tehran" +
                " Conservatory of Music.He has worked at the IRIB (the official broadcasting of Iran) for a while. He released his cassette album Bahar" +
                " e Man (Spring of Mine) in 1997, an instrumental music album where he played piano, guitar and violin. The album Fasl e Ashenayi " +
                "(Season of Acquaintance) in 1998",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "shadmehr-aghili.jpg", shadmehrAghiliFeatures);


        Map<String, String>bBandFeatures = new HashMap<String, String>();
        bBandFeatures.put("Genre", "Persian Rock");
        artistServiceProvider.addNewArtist("B-Band", "B-Band is a Persian Rock band. Members:KcRa-Drums\n" +
                "Hamed-Bass \n" +
                "Behzad-Vocals,Guitar,Synths \n" +
                "Khashayar-Backing Vocals,Guitar \n",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "B-band.jpg", bBandFeatures);

        Map<String, String>shahramNazeriFeatures = new HashMap<String, String>();
        shahramNazeriFeatures.put("Genre", "Persian Traditional");
        artistServiceProvider.addNewArtist("Shahram Nazeri","Shahram Nazeri was born in 1951. He is a contemporary Iranian tenor who sings classical from" +
                " Kermanshah. He has been accompanied by some of the authorities of Iranian traditional music such as Jalil Shahnaz, Alizadeh, " +
                "Jalal Zolfonoun and Payvar. He often works with his son Hafez Nazeri, a composer.",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "shahram-nazeri.jpg", shahramNazeriFeatures);

        Map<String, String>omidFeatures = new HashMap<String, String>();
        omidFeatures.put("Genre", "Persian Pop");
        artistServiceProvider.addNewArtist("Omid","Omid Soltani or better known by his stage name Omid is one of the biggest Persian artists." +
                "Omid started his career with his first album Baaraan. His newest album, “Shabe milad” released at 2009 with big hits like " +
                "‘Agar mande boodi’ and ‘Ayenehaye Barani’. He has become very popular with the Iranian people over the years because of his way of singing." +
                " His fans thinks that he sings with heart. his “Baran” is very popular between iranian people.\n",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "omid.jpg", omidFeatures);

        Map<String, String>faramarzaslaniFeatures = new HashMap<String, String>();
        faramarzaslaniFeatures.put("Genre", "Persian Flamenco/Spanish");
        artistServiceProvider.addNewArtist("Faramarz Aslani","Faramarz Aslani is an Iranian guitarist, songwriter and Persian pop" +
                "singer. He was born on July 13th, 1954 in Tehran, Iran and studied in London, England where he attained his bachelor's degree from London" +
                " University's College of Journalism. After his graduation he moved back to Tehran and worked for several publications, including Tehran Journal." +
                " About the same time, he was discovered by a CBS records executive, who signed him up to produce his first album, \"Del Mashghooli'ha\", " +
                "(Occupation of The Heart). That album has remained on many world-wide best sellers charts since its debut.",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "faramarz-aslani.jpg", faramarzaslaniFeatures);

        Map<String, String>farshidAminFeatures = new HashMap<String, String>();
        farshidAminFeatures.put("Genre", "Persian 6/8 Dance");
        artistServiceProvider.addNewArtist("Farshid Amin","Farshid Amin is a Persian singer/song writer. He left Iran at an early age and moved to England" +
                " where he finished his high school and University studies before moving to the U.S.A. permanently. Farshid began his professional music career" +
                " in the American industry in the mid 90`s when he became the lead singer of the renowned east coast progressive pop band `Fear Of Man` playing" +
                " along side acts like `Blondie` and `Julian Lennon`. He was twice nominated by WAMA ( washington area music association) for best vocalist" +
                " before writing and performing his first Persian mega hit `Nastaran`which thrusted him onto the Persian music scene, making him one of the" +
                " fastest growing Persian pop stars of all time!",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "farshid-amin.jpg", farshidAminFeatures);

        Map<String, String>sandyFeatures = new HashMap<String, String>();
        sandyFeatures.put("Genre", "Persian 6/8 Dance");
        artistServiceProvider.addNewArtist("Sandy","Snady band is one of the original musical groups to mix elements of Hip Hop and Rap with their unique brand of " +
                "Bandari with the lead singer, Shahram Azar.",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "sandy.jpg", sandyFeatures);

        //********
       // Map<String, String>sattarFeatures = new HashMap<String, String>();
        //sattarFeatures.put("Genre", "Persian 6/8 Dance");
        //artistServiceProvider.addNewArtist("Sattar","Hassan Sattar is an Iranian Pop-tenor, Oratorio singer with specialization in both Persian Pop and Classical music. He had gained fame before the Islamic Revolution and became Pahlavi Royal Family court singer up until the political upheavals of the late 1970s. He left Iran in 1978 and has taken residence in the United States since then.",
         //       commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "sandy.jpg", sattarFeatures);
        //**************************

        Map<String, String>MaziarFallahiFeatures = new HashMap<String, String>();
        MaziarFallahiFeatures.put("Genre", "Persian Slow Pop");
        artistServiceProvider.addNewArtist("Mazyar Fallahi","Mazyar Fallahi was born on 18th October 1974. He is a Singer, Poet, Guitar Player, Composer of" +
                " pop music and film music and also writer and film director. His songs are used in several movies like: Ghalbe Yakhi, Majnoone Leili and" +
                " Be Donbale Khoshbakhti",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "mazyar-fallahi.jpg", MaziarFallahiFeatures);

        Map<String, String>rezaYazdaniFeatures = new HashMap<String, String>();
        rezaYazdaniFeatures.put("Genre", "Persian Rock");
        artistServiceProvider.addNewArtist("Reza Yazdani","Reza Yazdani was born in October 16, 1973 in Tehran, Iran. He is an Iranian singer, musician, composer," +
                " and actor. He is an Iranian rocker and has released seven albums and numerous single songs till now. His notable instrument is guitar," +
                " especially electric guitar. He has performed live concerts since the release of his third album, Hiss, mainly in Milad Tower Concert Hall.",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "reza-yazdani.jpg", rezaYazdaniFeatures);

        Map<String, String>mohsenYeganehFeatures = new HashMap<String, String>();
        mohsenYeganehFeatures.put("Genre", "Persian Electronic");
        artistServiceProvider.addNewArtist("Mohsen Yeganeh","Mohsen Yeganeh was born on May 13, 1985 in Gonbad-e Qabus. He is a popular Iranian" +
                " vocalist, singer and songwriter and musician, composer, and arranger. He is one of the most popular singers in Iran and sometimes he is even" +
                " compared to Shadmehr Aghili since his style is inspired by Shadmehr Aghili based on what he mentioned in an interview. He performed at the 2008" +
                " Fajr International Music Festival. Mohsen is known as the \"King of Persian Pop\" and His title is \"Mr Genius\"",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "mohsen-yeganeh.jpg", mohsenYeganehFeatures);

        Map<String, String>shahinNajafiFeatures = new HashMap<String, String>();
        shahinNajafiFeatures.put("Genre", "Persian Rap");
        artistServiceProvider.addNewArtist("Shahin Najafi","Shahin Najafi was born in 1980 in Bandar-e Anzali, Gilan, Iran. He is an Iranian musician," +
                " singer, rapper, songwriter currently residing in Germany. He began his music career in Iran before immigrating to Germany in 2005." +
                " He has been referred to as being one of the forefronters in the Iran's modern hip hop scene by several experts and critics.\n" +
                "Najafi's songs mostly deal with issues such as theocracy, poverty, sexism, censorship, child labor, execution, drug addiction and " +
                "homophobia. He strives to use poetic, literary, philosophical and political elements in his music.",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "shahin-najafi.jpg", shahinNajafiFeatures);


        Map<String, String>fereydounFeatures = new HashMap<String, String>();
        fereydounFeatures.put("Genre", "Persian Pop");
        artistServiceProvider.addNewArtist("Fereydoon","Fereydoon Asraei was born in 1965 in Karaj, Iran. He is an Iranian musician," +
                " singer, and songwriter.",
                commonFile.getInitartistartworkpath() + commonFile.getSeparator() + "fereydoun.jpg", fereydounFeatures);
        
        //Adding Album

        List<String> ourNightArtistNames = new LinkedList<String>();
        ourNightArtistNames.add("Nooshafarin");
        Map<String, String> ourNightalbumFeatures = new HashMap<String, String>();
        ourNightalbumFeatures.put("Genre", "Persian Pop");
        Date albumDate = new SimpleDateFormat("yyyyMMdd").parse("20030101");
        albumServiceProvider.addNewAlbum("Our Night", albumDate, "Taraneh", ourNightArtistNames, commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "our-night.jpg",ourNightalbumFeatures);

        List<String> tapeshArtistNames = new LinkedList<String>();
        tapeshArtistNames.add("Shahram Shapareh");
        Map<String, String> tapeshAlbumFeatures = new HashMap<String, String>();
        tapeshAlbumFeatures.put("Genre", "Persian Pop");
        Date tapeshAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20080101");
        albumServiceProvider.addNewAlbum("Tapesh",tapeshAlbumDate,"Tapesh",tapeshArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "tapesh.jpg", tapeshAlbumFeatures );

        List<String> hasratArtistNames = new LinkedList<String>();
        hasratArtistNames.add("Ebi");
        Map<String, String> hasratAlbumFeatures = new HashMap<String, String>();
        hasratAlbumFeatures.put("Genre", "Persian Pop");
        Date hasratAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20060101");
        albumServiceProvider.addNewAlbum("Hasrate Parvaz",hasratAlbumDate,"Avang",hasratArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "hasarate-parvaz.jpg", hasratAlbumFeatures );

        List<String> setarehayeSorbiArtistNames = new LinkedList<String>();
        setarehayeSorbiArtistNames.add("Ebi");
        Map<String, String> setarehayeSorbiAlbumFeatures = new HashMap<String, String>();
        setarehayeSorbiAlbumFeatures.put("Genre", "Persian Pop");
        Date setarehayeSorbiAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19950101");
        albumServiceProvider.addNewAlbum("Setarehaye Sorbi",setarehayeSorbiAlbumDate,"Caltex",setarehayeSorbiArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "setarehaye-sorbi.jpg", setarehayeSorbiAlbumFeatures );

        List<String> delhoreArtistNames = new LinkedList<String>();
        delhoreArtistNames.add("Babak Rahnama");
        Map<String, String> delhoreAlbumFeatures = new HashMap<String, String>();
        delhoreAlbumFeatures.put("Genre", "Persian Electronic");
        Date delhoreAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20080101");
        albumServiceProvider.addNewAlbum("Del Hore",delhoreAlbumDate,"Unknown",delhoreArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "delhore-va-arezooha.jpg", delhoreAlbumFeatures );

        List<String> wagArtistNames = new LinkedList<String>();
        wagArtistNames.add("Baro Bax");
        Map<String, String > wagAlbumFeatures = new HashMap<String, String>();
        wagAlbumFeatures.put("Genre","Persian Pop Dance");
        Date wagAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20070101");
        albumServiceProvider.addNewAlbum("Wag",wagAlbumDate,"M4",wagArtistNames, commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "wag.jpg", wagAlbumFeatures);

        List<String> donyaArtistNames = new LinkedList<String>();
        donyaArtistNames.add("Arash");
        Map<String, String> donyaAlbumFeatures = new HashMap<String, String>();
        donyaAlbumFeatures.put("Genre","Persian Pop Dance");
        Date donyaAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20080101");
        albumServiceProvider.addNewAlbum("Donya",donyaAlbumDate,"Extensive Music AB",donyaArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "donya.jpg",donyaAlbumFeatures);


        List<String> screamArtistNames = new LinkedList<String>();
        screamArtistNames.add("Siavash Shams");
        Map<String,String> screamAlbumFeatures = new HashMap<String, String>();
        screamAlbumFeatures.put("Genre", "Persian Pop Dance");
        Date screamAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19970101");
        albumServiceProvider.addNewAlbum("Scream",screamAlbumDate,"Avang",screamArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "scream.jpg", screamAlbumFeatures);

        List<String> vaAmmaEshghArtistNames = new LinkedList<String>();
        vaAmmaEshghArtistNames.add("Arian Band");
        Map<String,String> vaAmmaEshghAlbumFeatures = new HashMap<String, String>();
        vaAmmaEshghAlbumFeatures.put("Genre", "Persian Pop Dance");
        Date vaAmmaEshghAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20040101");
        albumServiceProvider.addNewAlbum("Va Amma Eshgh",vaAmmaEshghAlbumDate,"Taraneh Sharghi",vaAmmaEshghArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "va-amma-eshgh.jpg", vaAmmaEshghAlbumFeatures);

        List<String> poolArtistNames = new LinkedList<String>();
        poolArtistNames.add("Black Cats");
        Map<String,String> poolAlbumFeatures = new HashMap<String, String>();
        poolAlbumFeatures.put("Genre", "Persian 6/8 Dance");
        Date poolAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19920101");
        albumServiceProvider.addNewAlbum("Pool",poolAlbumDate,"Taraneh",poolArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "pool.jpg", poolAlbumFeatures);

        List<String> kavirArtistNames = new LinkedList<String>();
        kavirArtistNames.add("Googoosh");
        Map<String,String> kavirAlbumFeatures = new HashMap<String, String>();
        kavirAlbumFeatures.put("Genre", "Persian Pop");
        Date kavirAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19900101");
        albumServiceProvider.addNewAlbum("Kavir",kavirAlbumDate,"Caltex",kavirArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "kavir.jpg", kavirAlbumFeatures);

        List<String> mrVioletArtistNames = new LinkedList<String>();
        mrVioletArtistNames.add("Pallet");
        Map<String,String> mrVioletAlbumFeatures = new HashMap<String, String>();
        mrVioletAlbumFeatures.put("Genre", "Persian Pop");
        Date mrVioletAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20120101");
        albumServiceProvider.addNewAlbum("Mr.Violet",mrVioletAlbumDate,"Mahriz",mrVioletArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "mrviolet.jpg", mrVioletAlbumFeatures);

        List<String> baharArtistNames = new LinkedList<String>();
        baharArtistNames.add("Pallet");
        Map<String,String>baharAlbumFeatures = new HashMap<String, String>();
        baharAlbumFeatures.put("Genre", "Persian Pop");
        Date baharAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19920101");
        albumServiceProvider.addNewAlbum("Bahar",baharAlbumDate,"Caltex",baharArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "bahar.jpg", baharAlbumFeatures);

        List<String> khabeBaroonArtistNames = new LinkedList<String>();
        khabeBaroonArtistNames.add("Siavash Ghomeyshi");
        Map<String,String>khabeBaroonAlbumFeatures = new HashMap<String, String>();
        khabeBaroonAlbumFeatures.put("Genre", "Persian Pop");
        Date khabeBaroonAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19930101");
        albumServiceProvider.addNewAlbum("Khabe Baroon",khabeBaroonAlbumDate,"Pars Video",khabeBaroonArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "khabe-baroon.jpg", khabeBaroonAlbumFeatures);

        List<String> khabDarBidariArtistNames = new LinkedList<String>();
        khabDarBidariArtistNames.add("Farhad");
        Map<String,String>khabDarBidariAlbumFeatures = new HashMap<String, String>();
        khabDarBidariAlbumFeatures.put("Genre", "Persian Jazz");
        khabDarBidariAlbumFeatures.put("Genre", "Persian Rock");
        Date khabDarBidariAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19930101");
        albumServiceProvider.addNewAlbum("Khab Dar Bidari",khabDarBidariAlbumDate,"Unknown",khabDarBidariArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "khab-dar-bidari.jpg", khabDarBidariAlbumFeatures);

        List<String> ashenayiArtistNames = new LinkedList<String>();
        ashenayiArtistNames.add("Hayedeh");
        Map<String,String>ashenayiAlbumFeatures = new HashMap<String, String>();
        ashenayiAlbumFeatures.put("Genre", "Persian Contemporary Pop");
        Date ashenayiAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19780101");
        albumServiceProvider.addNewAlbum("Ashenaei",ashenayiAlbumDate,"Caltex",ashenayiArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ashenayi.jpg", ashenayiAlbumFeatures);

        List<String> bezanTarArtistNames = new LinkedList<String>();
        bezanTarArtistNames.add("Hayedeh");
        Map<String,String>bezanTarAlbumFeatures = new HashMap<String, String>();
        bezanTarAlbumFeatures.put("Genre", "Persian Pop");
        Date bezanTarAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19910101");
        albumServiceProvider.addNewAlbum("Bezan Tar",bezanTarAlbumDate,"Taraneh",bezanTarArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "bezan-tar.jpg", bezanTarAlbumFeatures);

        List<String> paroeBiGhayeghArtistNames = new LinkedList<String>();
        paroeBiGhayeghArtistNames.add("Mohsen Chavoshi");
        Map<String,String>paroeBiGhayeghAlbumFeatures = new HashMap<String, String>();
        paroeBiGhayeghAlbumFeatures.put("Genre", "Persian Pop");
        Date paroyebiGhayeghAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20140101");
        albumServiceProvider.addNewAlbum("Paroye Bi Ghayegh",paroyebiGhayeghAlbumDate,"Unknown",paroeBiGhayeghArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "paroye-bi-ghayegh.jpg", paroeBiGhayeghAlbumFeatures);

        List<String> chaartaarArtistNames = new LinkedList<String>();
        chaartaarArtistNames.add("Chaartaar");
        Map<String,String>chaartarAlbumFeatures = new HashMap<String, String>();
        chaartarAlbumFeatures.put("Genre", "Persian Fusion");
        Date chaartaarAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20140101");
        albumServiceProvider.addNewAlbum("Baran Toyi",chaartaarAlbumDate,"Unknown",chaartaarArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "baran-toyi.jpg", chaartarAlbumFeatures);

        List<String> toloKonArtistNames = new LinkedList<String>();
        toloKonArtistNames.add("Ebi");
        Map<String,String>toloKonAlbumFeatures = new HashMap<String, String>();
        toloKonAlbumFeatures.put("Genre", "Persian Pop");
        Date toloKonAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19990101");
        albumServiceProvider.addNewAlbum("Tolo Kon",toloKonAlbumDate,"Avang",toloKonArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "tolo-kon.jpg", toloKonAlbumFeatures);

        List<String> mohtajArtistNames = new LinkedList<String>();
        mohtajArtistNames.add("Ebi");
        mohtajArtistNames.add("Dariush");
        Map<String,String>mohtajAlbumFeatures = new HashMap<String, String>();
        mohtajAlbumFeatures.put("Genre", "Persian Pop");
        Date mohtajAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20000101");
        albumServiceProvider.addNewAlbum("Mohtaj",mohtajAlbumDate,"Avang",mohtajArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "mohtaj.jpg", mohtajAlbumFeatures);


        List<String> blueFlowerArtistNames = new LinkedList<String>();
        blueFlowerArtistNames.add("Marjan Farsad");
        Map<String,String>blueFlowerAlbumFeatures = new HashMap<String, String>();
        blueFlowerAlbumFeatures.put("Genre", "Persian Slow Pop");
        Date blueFlowerAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20140801");
        albumServiceProvider.addNewAlbum("Blue Flowers",blueFlowerAlbumDate,"Unknown",blueFlowerArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "blue-flowers.jpg", blueFlowerAlbumFeatures);

        List<String> sinaHejaziSingleArtistNames = new LinkedList<String>();
        sinaHejaziSingleArtistNames.add("Sina Hejazi");
        Map<String,String>sinaHejaziSingleAlbumFeatures = new HashMap<String, String>();
        sinaHejaziSingleAlbumFeatures.put("Genre", "Persian Pop");
        Date sinaHejaziSingleAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130801");
        albumServiceProvider.addNewAlbum("Sina Hejazi Singles",sinaHejaziSingleAlbumDate,"Unknown",sinaHejaziSingleArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "sina-hejazi-singles.jpg", sinaHejaziSingleAlbumFeatures);

        List<String> saraNaeiniSingleArtistNames = new LinkedList<String>();
        sinaHejaziSingleArtistNames.add("Sara Naeini");
        Map<String,String>saraNaeiniSingleAlbumFeatures = new HashMap<String, String>();
        saraNaeiniSingleAlbumFeatures.put("Genre", "Persian Jazz");
        Date saraNaeiniSingleAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130401");
        albumServiceProvider.addNewAlbum("Sara Naeini Singles",saraNaeiniSingleAlbumDate,"Unknown",saraNaeiniSingleArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "sara-naeini-singles.jpg", saraNaeiniSingleAlbumFeatures);

        List<String> azKhaneTaGoorArtistNames = new LinkedList<String>();
        azKhaneTaGoorArtistNames.add("Erfan");
        Map<String,String>azKhaneTaGoorAlbumFeatures = new HashMap<String, String>();
        azKhaneTaGoorAlbumFeatures.put("Genre", "Persian Jazz");
        Date azKhaneTaGoorAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20070701");
        albumServiceProvider.addNewAlbum("Az Khane Ta Goor",azKhaneTaGoorAlbumDate,"Unknown",azKhaneTaGoorArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "az-khane-ta-goor.jpg", azKhaneTaGoorAlbumFeatures);

        List<String> benyamin93ArtistNames = new LinkedList<String>();
        benyamin93ArtistNames.add("Erfan");
        Map<String,String>benyamin93AlbumFeatures = new HashMap<String, String>();
        benyamin93AlbumFeatures.put("Genre", "Persian Electronic");
        Date benyamin93AlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20140801");
        albumServiceProvider.addNewAlbum("Benyamin 93",benyamin93AlbumDate,"Unknown",benyamin93ArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "benyamin93.jpg", benyamin93AlbumFeatures);

        List<String>naFereshteAmNaSheytanArtistNames = new LinkedList<String>();
        naFereshteAmNaSheytanArtistNames.add("Homayoun Shajarian");
        Map<String,String>naFereshteAmNaSheytanAlbumFeatures = new HashMap<String, String>();
        naFereshteAmNaSheytanAlbumFeatures.put("Genre", "Persian Traditional");
        Date naFereshteAmNaSheytanAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20131001");
        albumServiceProvider.addNewAlbum("Na Fereshteam Na Sheytan",naFereshteAmNaSheytanAlbumDate,"Unknown",naFereshteAmNaSheytanArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "na-fereshteam-na-sheitan.jpg", naFereshteAmNaSheytanAlbumFeatures);

        List<String>tashkilateMovaziArtistNames = new LinkedList<String>();
        tashkilateMovaziArtistNames.add("Kiosk");
        Map<String,String>tashkilateMovaziAlbumFeatures = new HashMap<String, String>();
        tashkilateMovaziAlbumFeatures.put("Genre", "Persian Rock");
        Date tashkilateMovaziAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130201");
        albumServiceProvider.addNewAlbum("Tashkilate Movazi",tashkilateMovaziAlbumDate,"Unknown",tashkilateMovaziArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "tashkilate-movazi.jpg", tashkilateMovaziAlbumFeatures);

        List<String>jadeyeKhoshbakhtiArtistNames = new LinkedList<String>();
        jadeyeKhoshbakhtiArtistNames.add("Sirvan");
        Map<String,String>jadeyeKhoshbakhtiAlbumFeatures = new HashMap<String, String>();
        jadeyeKhoshbakhtiAlbumFeatures.put("Genre", "Persian Electronic");
        Date jadeyeKhoshbakhtiAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20121211");
        albumServiceProvider.addNewAlbum("The Road of Dreams",jadeyeKhoshbakhtiAlbumDate,"Irangaam",jadeyeKhoshbakhtiArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "the-road-of-dreams.jpg", jadeyeKhoshbakhtiAlbumFeatures);

        List<String>jabreJoghrafiaeArtistNames = new LinkedList<String>();
        jabreJoghrafiaeArtistNames.add("Mohsen Namjoo");
        Map<String,String> jabreJoghrafiaeAlbumFeatures = new HashMap<String, String>();
        jabreJoghrafiaeAlbumFeatures.put("Genre", "Persian Rock");
        Date jabreJoghrafiaeAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20080101");
        albumServiceProvider.addNewAlbum("Jabre Joghrafiae",jabreJoghrafiaeAlbumDate,"Unknown",jabreJoghrafiaeArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "jabr-joghrafiae.jpg", jabreJoghrafiaeAlbumFeatures);

        List<String>trafficArtistNames = new LinkedList<String>();
        trafficArtistNames.add("Traffic Band");
        Map<String,String> trafficAlbumFeatures = new HashMap<String, String>();
        trafficAlbumFeatures.put("Genre", "Persian Electronic");
        Date trafficAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20131001");
        albumServiceProvider.addNewAlbum("Traffic",trafficAlbumDate,"Unknown",trafficArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "traffic.jpg", trafficAlbumFeatures);

        List<String>sedayeTehrooneGhadimArtistNames = new LinkedList<String>();
        sedayeTehrooneGhadimArtistNames.add("Morteza Ahmadi");
        Map<String,String> sedayeTehrooneGhadimAlbumFeatures = new HashMap<String, String>();
        sedayeTehrooneGhadimAlbumFeatures.put("Genre", "Persian Folklore");
        Date sedayeTehrooneGhadimAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20120101");
        albumServiceProvider.addNewAlbum("Sedaye Tehroone Ghadim",sedayeTehrooneGhadimAlbumDate,"Unknown",sedayeTehrooneGhadimArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "sedaye-tehroone-ghadim2.jpg", sedayeTehrooneGhadimAlbumFeatures);

        List<String>jadeyeAbrishamArtistNames = new LinkedList<String>();
        jadeyeAbrishamArtistNames.add("Andy");
        Map<String,String> jadeyeAbrishamAlbumFeatures = new HashMap<String, String>();
        jadeyeAbrishamAlbumFeatures.put("Genre", "Persian 6/8 Dance");
        Date jadeyeAbrishamAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19980101");
        albumServiceProvider.addNewAlbum("Jadeye Abrisham",jadeyeAbrishamAlbumDate,"Cheroke",jadeyeAbrishamArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "jadeye-abrisham.jpg", jadeyeAbrishamAlbumFeatures);

        List<String>bighararArtistNames = new LinkedList<String>();
        bighararArtistNames.add("Andy");
        Map<String,String> bighararAlbumFeatures = new HashMap<String, String>();
        bighararAlbumFeatures.put("Genre", "Persian 6/8 Dance");
        Date bighararAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19920101");
        albumServiceProvider.addNewAlbum("Bigharar",bighararAlbumDate,"Caltex",bighararArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "bigharar.jpg", bighararAlbumFeatures);

        List<String>adamForooshArtistNames = new LinkedList<String>();
        adamForooshArtistNames.add("Shadmehr Aghili");
        Map<String,String> adamForooshAlbumFeatures = new HashMap<String, String>();
        adamForooshAlbumFeatures.put("Genre", "Persian Pop");
        Date adamForooshAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20040101");
        albumServiceProvider.addNewAlbum("Adam Foroosh",bighararAlbumDate,"Unknown",adamForooshArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "adam-foroosh.jpg", adamForooshAlbumFeatures);

        List<String>heyraniArtistNames = new LinkedList<String>();
        heyraniArtistNames.add("Shahram Nazeri");
        Map<String,String> heyraniAlbumFeatures = new HashMap<String, String>();
        heyraniAlbumFeatures.put("Genre", "Persian Traditional");
        Date heyraniAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19880101");
        albumServiceProvider.addNewAlbum("Heyrani",heyraniAlbumDate,"Unknown",heyraniArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "heyrani.jpg", heyraniAlbumFeatures);

        List<String>neishnavamSedatoArtistNames = new LinkedList<String>();
        neishnavamSedatoArtistNames.add("B-Band");
        Map<String,String> neishnavamSedatoAlbumFeatures = new HashMap<String, String>();
        neishnavamSedatoAlbumFeatures.put("Genre", "Persian Rock");
        Date neishnavamSedatoAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20120101");
        albumServiceProvider.addNewAlbum("Nemishnavam Sedato",neishnavamSedatoAlbumDate,"Unknown",neishnavamSedatoArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "nemishnavam-sedato.jpg", neishnavamSedatoAlbumFeatures);

        List<String>baranArtistNames = new LinkedList<String>();
        baranArtistNames.add("Omid");
        Map<String,String> baranAlbumFeatures = new HashMap<String, String>();
        baranAlbumFeatures.put("Genre", "Persian Pop");
        Date baranAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19950601");
        albumServiceProvider.addNewAlbum("Baran",baranAlbumDate,"Taraneh",baranArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "baran.jpg", baranAlbumFeatures);

        List<String>ageYeRoozArtistNames = new LinkedList<String>();
        ageYeRoozArtistNames.add("Faramarz Aslani");
        Map<String,String> ageYeRoozAlbumFeatures = new HashMap<String, String>();
        ageYeRoozAlbumFeatures.put("Genre", "Persian Pop");
        Date ageYeRoozAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19930101");
        albumServiceProvider.addNewAlbum("Age Ye Rooz",ageYeRoozAlbumDate,"Taraneh",ageYeRoozArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "age-ye-rooz.jpg", ageYeRoozAlbumFeatures);

        List<String>baShomaArtistNames = new LinkedList<String>();
        baShomaArtistNames.add("Martik");
        Map<String,String> baShomaAlbumFeatures = new HashMap<String, String>();
        baShomaAlbumFeatures.put("Genre", "Persian 6/8 Dance");
        Date baShomaAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20010101");
        albumServiceProvider.addNewAlbum("Ba Shoma",baShomaAlbumDate,"Caltex",baShomaArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ba-shoma.jpg", baShomaAlbumFeatures);

        List<String>banooArtistNames = new LinkedList<String>();
        banooArtistNames.add("Farshid Amin");
        Map<String,String> banooAlbumFeatures = new HashMap<String, String>();
        banooAlbumFeatures.put("Genre", "Persian 6/8 Dance");
        Date banooAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20000101");
        albumServiceProvider.addNewAlbum("Banoo",banooAlbumDate,"Pars Video",banooArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "banoo.jpg", banooAlbumFeatures);

        List<String>dingDangArtistNames = new LinkedList<String>();
        dingDangArtistNames.add("Sandy");
        Map<String,String>dingDangAlbumFeatures = new HashMap<String, String>();
        dingDangAlbumFeatures.put("Genre", "Persian 6/8 Dance");
        Date dingDangAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19950101");
        albumServiceProvider.addNewAlbum("Ding Dang",dingDangAlbumDate,"Caltex",dingDangArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ding-dang.jpg", dingDangAlbumFeatures);

        List<String>maheHaftomArtistNames = new LinkedList<String>();
        maheHaftomArtistNames.add("Mazyar Fallahi");
        Map<String,String>maheHaftomAlbumFeatures = new HashMap<String, String>();
        maheHaftomAlbumFeatures.put("Genre", "Persian Slow Pop");
        Date maheHaftomAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20141015");
        albumServiceProvider.addNewAlbum("Mahe Haftom",maheHaftomAlbumDate,"Unknown",maheHaftomArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "mahe-haftom.jpg", maheHaftomAlbumFeatures);

        List<String>toKhialKardiBeriArtistNames = new LinkedList<String>();
        toKhialKardiBeriArtistNames.add("Sirvan");
        Map<String,String>toKhialKardiBeriAlbumFeatures = new HashMap<String, String>();
        toKhialKardiBeriAlbumFeatures.put("Genre", "Persian Pop");
        Date toKhialKardiBeriAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20050601");
        albumServiceProvider.addNewAlbum("To Khial Kardi Beri",toKhialKardiBeriAlbumDate,"Unknown",toKhialKardiBeriArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "to-khial-kardi-beri.jpg", toKhialKardiBeriAlbumFeatures);



        List<String>khaterateMobhamArtistNames = new LinkedList<String>();
        khaterateMobhamArtistNames.add("Reza Yazdani");
        Map<String,String>khaterateMobhamAlbumFeatures = new HashMap<String, String>();
        khaterateMobhamAlbumFeatures.put("Genre", "Persian Rock");
        Date khaterateMobhamAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130328");
        albumServiceProvider.addNewAlbum("Khaterate Mobham",khaterateMobhamAlbumDate,"Tasvir Gostar Pasargad",khaterateMobhamArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "khaterate-mobham.jpg", khaterateMobhamAlbumFeatures);

        List<String>hobabArtistNames = new LinkedList<String>();
        hobabArtistNames.add("Mohsen Yeganeh");
        Map<String,String>hobabAlbumFeatures = new HashMap<String, String>();
        hobabAlbumFeatures.put("Genre", "Persian Rock");
        Date hobabAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20121001");
        albumServiceProvider.addNewAlbum("Hobab",hobabAlbumDate,"Unknown",hobabArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "hobab.jpg", hobabAlbumFeatures);

        List<String>sizdahHashtArtistNames = new LinkedList<String>();
        sizdahHashtArtistNames.add("Mohsen Namjoo");
        Map<String,String>sizdahHashtAlbumFeatures = new HashMap<String, String>();
        sizdahHashtAlbumFeatures.put("Genre", "Persian Fusion");
        Date sizdahHashtAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20141002");
        albumServiceProvider.addNewAlbum("13/8",sizdahHashtAlbumDate,"Payam Enterprise Inc",sizdahHashtArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "13-8.jpg", sizdahHashtAlbumFeatures);

        List<String>tarafDarArtistNames = new LinkedList<String>();
        tarafDarArtistNames.add("Shadmehr Aghili");
        Map<String,String>tarafDarAlbumFeatures = new HashMap<String, String>();
        tarafDarAlbumFeatures.put("Genre", "Persian Pop");
        Date tarafDarAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130101");
        albumServiceProvider.addNewAlbum("Tarafdar",tarafDarAlbumDate,"Avang",tarafDarArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "tarafdar.jpg", tarafDarAlbumFeatures);

        List<String>a2singlesArtistNames = new LinkedList<String>();
        a2singlesArtistNames.add("A2");
        Map<String,String>a2singlesAlbumFeatures = new HashMap<String, String>();
        a2singlesAlbumFeatures.put("Genre", "Persian Rap");
        Date a2singlesAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130101");
        albumServiceProvider.addNewAlbum("A2 Singles",a2singlesAlbumDate,"unknown",a2singlesArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "a2-singles.jpg", a2singlesAlbumFeatures);


        List<String>forteenForteenArtistNames = new LinkedList<String>();
        forteenForteenArtistNames.add("Shahin Najafi");
        Map<String,String>forteenForteenAlbumFeatures = new HashMap<String, String>();
        forteenForteenAlbumFeatures.put("Genre", "Persian Rap");
        Date forteenForteenAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20140415");
        albumServiceProvider.addNewAlbum("1414",forteenForteenAlbumDate,"unknown",forteenForteenArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "1414.jpg", forteenForteenAlbumFeatures);

        List<String>roozhayeBikhaterehArtistNames = new LinkedList<String>();
        roozhayeBikhaterehArtistNames.add("Siavash Ghomeyshi");
        Map<String,String>roozhayeBikhaterehAlbumFeatures = new HashMap<String, String>();
        roozhayeBikhaterehAlbumFeatures.put("Genre", "Persian Electronic");
        Date roozhayeBikhaterehAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20050910");
        albumServiceProvider.addNewAlbum("Roozhaye Bikhatereh",roozhayeBikhaterehAlbumDate,"Caltex",roozhayeBikhaterehArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "roozhaye-bikhatereh.jpg", roozhayeBikhaterehAlbumFeatures);

        List<String>biSarzaminTarAzBadArtistNames = new LinkedList<String>();
        biSarzaminTarAzBadArtistNames.add("Siavash Ghomeyshi");
        Map<String,String>biSarzaminTarAzBadAlbumFeatures = new HashMap<String, String>();
        biSarzaminTarAzBadAlbumFeatures.put("Genre", "Persian Electronic");
        Date biSarzaminTarAzBadAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20031208");
        albumServiceProvider.addNewAlbum("Bi Sarzamintar Az Bad",biSarzaminTarAzBadAlbumDate,"Caltex",biSarzaminTarAzBadArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "bi-sarzamin-tar-az-bad.jpg", biSarzaminTarAzBadAlbumFeatures);

        List<String>taBinahayatArtistNames = new LinkedList<String>();
        taBinahayatArtistNames.add("Arian Band");
        Map<String,String>taBinahayatAlbumFeatures = new HashMap<String, String>();
        taBinahayatAlbumFeatures.put("Genre", "Persian Pop");
        Date taBinahayatAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20040101");
        albumServiceProvider.addNewAlbum("Ta Binahayat",taBinahayatAlbumDate,"Taraneh Sharghi",taBinahayatArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ta-binahayat.jpg", taBinahayatAlbumFeatures);

        List<String>gharibehFereydounArtistNames = new LinkedList<String>();
        gharibehFereydounArtistNames.add("Fereydoon");
        Map<String,String>gharibehFereydounAlbumFeatures = new HashMap<String, String>();
        gharibehFereydounAlbumFeatures.put("Genre", "Persian Pop");
        Date gharibehFereydounAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20050101");
        albumServiceProvider.addNewAlbum("Gharibe",gharibehFereydounAlbumDate,"Unknown",gharibehFereydounArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "gharibeh.jpg", gharibehFereydounAlbumFeatures);

        List<String>shahramNazeriLikeInConcertArtistNames = new LinkedList<String>();
        shahramNazeriLikeInConcertArtistNames.add("Shahram Nazeri");
        Map<String,String>shahramNazeriLikeInConcerAlbumFeatures = new HashMap<String, String>();
        shahramNazeriLikeInConcerAlbumFeatures.put("Genre", "Persian Classic");
        Date shahramNazeriLikeInConcerAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20130131");
        albumServiceProvider.addNewAlbum("Shahram Nazeri Live In Concert",shahramNazeriLikeInConcerAlbumDate,"Unknown",shahramNazeriLikeInConcertArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "shahram-nazeri-live-in-concert.jpg", shahramNazeriLikeInConcerAlbumFeatures);


        List<String>ebiGharibehArtistNames = new LinkedList<String>();
        ebiGharibehArtistNames.add("Ebi");
        Map<String,String>ebiGharibehAlbumFeatures = new HashMap<String, String>();
        ebiGharibehAlbumFeatures.put("Genre", "Persian Pop");
        Date ebiGharibehAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19890101");
        albumServiceProvider.addNewAlbum("Gharibeh",ebiGharibehAlbumDate,"Pars Video",ebiGharibehArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-haribeh.jpg", ebiGharibehAlbumFeatures);

        List<String>ebiHeseTanhaeeArtistNames = new LinkedList<String>();
        ebiHeseTanhaeeArtistNames.add("Ebi");
        Map<String,String>ebiHeseTanhaeeAlbumFeatures = new HashMap<String, String>();
        ebiHeseTanhaeeAlbumFeatures.put("Genre", "Persian Pop");
        Date ebiHeseTanhaeeAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20110101");
        albumServiceProvider.addNewAlbum("Hesse Tanhae",ebiHeseTanhaeeAlbumDate,"Avang",ebiHeseTanhaeeArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-hesse-tanhaee.jpg", ebiHeseTanhaeeAlbumFeatures);

        List<String>ebiKhorshidKhanoomArtistNames = new LinkedList<String>();
        ebiKhorshidKhanoomArtistNames.add("Ebi");
        Map<String,String>ebiKhorshidKhanoomAlbumFeatures = new HashMap<String, String>();
        ebiKhorshidKhanoomAlbumFeatures.put("Genre", "Persian Pop");
        Date ebiKhorshidKhanoomAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20010101");
        albumServiceProvider.addNewAlbum("Khorshid Khanoom",ebiKhorshidKhanoomAlbumDate,"Avang",ebiKhorshidKhanoomArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-khorshid-khanom.jpg", ebiKhorshidKhanoomAlbumFeatures);

        List<String>ebiKooheYakhArtistNames = new LinkedList<String>();
        ebiKooheYakhArtistNames.add("Ebi");
        Map<String,String>ebiKooheYakhAlbumFeatures = new HashMap<String, String>();
        ebiKooheYakhAlbumFeatures.put("Genre", "Persian Pop");
        Date ebiKooheYakhAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19870101");
        albumServiceProvider.addNewAlbum("Koohe Yakh",ebiKooheYakhAlbumDate,"Taraneh",ebiKooheYakhArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-koohe-yakh.jpg", ebiKooheYakhAlbumFeatures);

        List<String>ebiMoalemeBadArtistNames = new LinkedList<String>();
        ebiMoalemeBadArtistNames.add("Ebi");
        Map<String,String>ebiMoalemeBadAlbumFeatures = new HashMap<String, String>();
        ebiMoalemeBadAlbumFeatures.put("Genre", "Persian Pop");
        Date ebiMoalemeBadAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19930101");
        albumServiceProvider.addNewAlbum("Moaleme Bad",ebiMoalemeBadAlbumDate,"Taraneh",ebiMoalemeBadArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-moaleme-bad.jpg", ebiMoalemeBadAlbumFeatures);

        List<String>ebisetareyeDonbaledarArtistNames = new LinkedList<String>();
        ebisetareyeDonbaledarArtistNames.add("Ebi");
        Map<String,String>ebisetareyeDonbaledarAlbumFeatures = new HashMap<String, String>();
        ebisetareyeDonbaledarAlbumFeatures.put("Genre", "Persian Pop");
        Date ebiSetareyeDonbaleDarAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19920101");
        albumServiceProvider.addNewAlbum("Setareye Donbaledar",ebiSetareyeDonbaleDarAlbumDate,"Unknown",ebisetareyeDonbaledarArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-setareh-donbaledar.jpg", ebisetareyeDonbaledarAlbumFeatures);

        List<String>ebiPirArtistNames = new LinkedList<String>();
        ebiPirArtistNames.add("Ebi");
        Map<String,String>ebiPirAlbumFeatures = new HashMap<String, String>();
        ebiPirAlbumFeatures.put("Genre", "Persian Slow Pop");
        Date ebiPirAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19981012");
        albumServiceProvider.addNewAlbum("Pir",ebiPirAlbumDate,"Unknown",ebiPirArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-pir.jpg", ebiPirAlbumFeatures);

        List<String>ebiShabzadehArtistNames = new LinkedList<String>();
        ebiShabzadehArtistNames.add("Ebi");
        Map<String,String>ebiShabzadehAlbumFeatures = new HashMap<String, String>();
        ebiShabzadehAlbumFeatures.put("Genre", "Persian Slow Pop");
        Date ebiShabZadehAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("19910101");
        albumServiceProvider.addNewAlbum("Shabzadeh",ebiShabZadehAlbumDate,"Unknown",ebiShabzadehArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-shabzadeh.jpg", ebiShabzadehAlbumFeatures);

        List<String>ebiShabeNilofariArtistNames = new LinkedList<String>();
        ebiShabeNilofariArtistNames.add("Ebi");
        Map<String,String>ebiShabeNiloofariAlbumFeatures = new HashMap<String, String>();
        ebiShabeNiloofariAlbumFeatures.put("Genre", "Persian Slow Pop");
        Date ebiShabeNiloofariAlbumDate = new SimpleDateFormat("yyyyMMdd").parse("20030101");
        albumServiceProvider.addNewAlbum("Shabe Niloofari",ebiShabeNiloofariAlbumDate,"Caltex",ebiShabeNilofariArtistNames,commonFile.getInitalbumartworkpath() + commonFile.getSeparator() + "ebi-shabe-niloofari.jpg", ebiShabeNiloofariAlbumFeatures);




    return null;
    }
}
