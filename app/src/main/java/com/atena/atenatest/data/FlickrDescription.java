package com.atena.atenatest.data;

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
        int heightEndingPoint = nonHtmlEscape.indexOf("\"", heightStartingPoint + 9);
        height = Integer.getInteger(nonHtmlEscape.substring(heightStartingPoint, heightEndingPoint));
        int widthStartingPoint = nonHtmlEscape.indexOf("height");
        int widthEndingPoint = nonHtmlEscape.indexOf("\"", widthStartingPoint + 9);
        height = Integer.getInteger(nonHtmlEscape.substring(widthStartingPoint, widthEndingPoint));

   }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
