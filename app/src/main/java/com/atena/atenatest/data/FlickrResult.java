package com.atena.atenatest.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Eric on 3/13/2017.
 */
public class FlickrResult {
    /*
    "title": "Recent Uploads tagged dog",
            "link": "http:\/\/www.flickr.com\/photos\/tags\/dog\/",
            "description": "",
            "modified": "2017-03-13T17:00:02Z",
            "generator": "http:\/\/www.flickr.com",
            "items": [ ....}
            */

    @SerializedName("items")
    private ArrayList<FlickrBase> flickArray;
    private String title;
    private String description;
    private Date modified;
    private String generator;


    public void setFlickArray(ArrayList<FlickrBase> inArrray) {
        flickArray = inArrray;
    }

    public ArrayList<FlickrBase> getFlickArray() {
        return flickArray;
    }

    public void setTitle(String inTitle) {
        title = inTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String inDescription) {
        description = inDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setModified(Date inModified) {
        modified = inModified;
    }

    public Date getModified() {
        return modified;
    }

    public void setGenerator(String inGenerator) {
        generator = inGenerator;
    }

    public String getGenerator() {
        return generator;
    }
}
