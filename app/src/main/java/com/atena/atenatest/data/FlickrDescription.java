package com.atena.atenatest.data;

import android.util.Log;

/**
 * Created by Eric on 3/13/2017.
 */
public class FlickrDescription {
    /*
    			"description": " <p><a href=\"http:\/\/www.flickr.com\/people\/saccophoto\/\">tonysacco.photo<\/a> posted a photo:<\/p> <p><a href=\"http:\/\/www.flickr.com\/photos\/saccophoto\/33292799811\/\" title=\"2017_03_12_Dog_Portriats (5 of 9)\"><img src=\"http:\/\/farm4.staticflickr.com\/3953\/33292799811_fa630ca58b_m.jpg\" width=\"240\" height=\"160\" alt=\"2017_03_12_Dog_Portriats (5 of 9)\" \/><\/a><\/p> ",
     */

   String nonHtmlEscape;
    int height;
    int width;

    public FlickrDescription(String staringValue) {
       nonHtmlEscape = staringValue.replace("\\","");
        int heightStartingPoint = nonHtmlEscape.indexOf("height");
        heightStartingPoint = nonHtmlEscape.indexOf("\"", heightStartingPoint); // After the Tag locate "
        int heightEndingPoint = nonHtmlEscape.indexOf("\"", heightStartingPoint + 1) + 1; // And go to the first character after that
        String heightString = nonHtmlEscape.substring(heightStartingPoint+1, heightEndingPoint-1);
        height = Integer.parseInt(heightString);
        int widthStartingPoint = nonHtmlEscape.indexOf("width");
        widthStartingPoint = nonHtmlEscape.indexOf("\"", widthStartingPoint);
        int widthEndingPoint = nonHtmlEscape.indexOf("\"", widthStartingPoint + 1) + 1;
        width = Integer.parseInt(nonHtmlEscape.substring(widthStartingPoint+1, widthEndingPoint-1));

   }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
