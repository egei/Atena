package com.atena.atenatest.api;

import android.database.Observable;

import com.atena.atenatest.data.FlickrResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eric on 3/13/2017.
 */
public class FlickrController {
    static final String BASE_URL = "http://api.flickr.com";
    Retrofit retrofit;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public Call<FlickrResult> getFlickrResult(String tags) {
        FlickrApiInterface flickrApiInterface = retrofit.create(FlickrApiInterface.class);

        Call<FlickrResult> flickApiInterfaceResult =  flickrApiInterface.getFlickr(tags, "json", 1, "any");
        return  flickApiInterfaceResult;
    }

}
