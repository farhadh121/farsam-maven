package com.radio.svc.dalc;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import org.apache.commons.fileupload.FileItem;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/14/14
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IAlbumDA extends IGenericDA<AlbumEntity, Long> {

    public AlbumEntity getAlbumByName( AlbumEntity albumEntity );

    public AlbumEntity getAlbumByAlbumNameAndArtistNames( AlbumEntity albumEntity, Set<ArtistEntity> artistEntitySet);

    public List<AlbumEntity> getAlbumsByPartialName( String partialName );

}
