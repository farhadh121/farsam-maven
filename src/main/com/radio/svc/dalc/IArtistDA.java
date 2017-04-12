package com.radio.svc.dalc;



import com.radio.entity.hibernate.ArtistEntity;

import java.util.List;

public interface IArtistDA extends IGenericDA<ArtistEntity, Long> {

    /**
     * @param artistEntity  The artists entity which contains the name to search for
     * @return  returns the artists entity with the same name
     */
	public ArtistEntity getArtistByName( ArtistEntity artistEntity );

    /**
     * Returns a list of artist entities, which has a partial name matches with partialName
     * @param partialName   the partial name that we are going to match with
     * @return  A list of artist entities, which matches this criteria
     */
    public List<ArtistEntity> getArtistsByPartialName( String partialName );

}

