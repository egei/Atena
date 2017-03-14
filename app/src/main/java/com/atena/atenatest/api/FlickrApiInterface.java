package com.atena.atenatest.api;

import android.database.Observable;

import com.atena.atenatest.data.FlickrResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Eric on 3/13/2017.
 */
public interface FlickrApiInterface {

    @GET ("services/feeds/photos_public.gne?tagmode=any&format=json&nojsoncallback=1") //?tagmode=any&format=json&tags={TAG}&nojsoncallback=1")
    Call<FlickrResult> getFlickr(@Query("tags") String tags,
                                 @Query("format") String format,
                                 @Query("nojsoncallback") int nocallback,
                                 @Query("tagmode") String tagmode);

}
