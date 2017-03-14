package com.atena.atenatest.data;

import java.util.Date;

/**
 * Created by Eric on 3/13/2017.
 */
public class FlickrBase {

    /*

			"title": "2017_03_12_Dog_Portriats (5 of 9)",
			"link": "http:\/\/www.flickr.com\/photos\/saccophoto\/33292799811\/",
			"media": {"m":"http:\/\/farm4.staticflickr.com\/3953\/33292799811_fa630ca58b_m.jpg"},
			"date_taken": "2017-03-13T07:34:37-08:00",
			"description": " <p><a href=\"http:\/\/www.flickr.com\/people\/saccophoto\/\">tonysacco.photo<\/a> posted a photo:<\/p> <p><a href=\"http:\/\/www.flickr.com\/photos\/saccophoto\/33292799811\/\" title=\"2017_03_12_Dog_Portriats (5 of 9)\"><img src=\"http:\/\/farm4.staticflickr.com\/3953\/33292799811_fa630ca58b_m.jpg\" width=\"240\" height=\"160\" alt=\"2017_03_12_Dog_Portriats (5 of 9)\" \/><\/a><\/p> ",
			"published": "2017-03-13T16:53:55Z",
			"author": "nobody@flickr.com (\"tonysacco.photo\")",
			"author_id": "130430865@N08",
			"tags": "animal d500 dog honey layla nikon puppy sacco saccophoto tony tonysacco dogs pet petphotography photo"

     */
    private String title;
    private String link;
    //private String media;
    private Date date_taken;
    private String description;
    private Date published;
    private String author;
    private String authorId;
    private String tags;
    private FlickrDescription flickrDescription = null;

    public void setTitle(String inTitle) {
        title = inTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setDate_taken(Date inDate) {
        date_taken = inDate;
    }

    public Date getDate_taken() {
        return date_taken;
    }

    public void setPublished(Date inDate) {
        published = inDate;
    }

    public Date getPublished() {
        return published;
    }

    public void setLink(String inLink) {
        link = inLink;
    }

    public String getLink() {
        return link;
    }

    public void setDescription(String inDescription) {
        description = inDescription;
    }

    public void setFlickrDescription() {
        flickrDescription = new FlickrDescription(description);
    }

    public FlickrDescription getFlickrDescription() {
        if (flickrDescription == null && !description.isEmpty()) {
            setFlickrDescription();
        }
        return flickrDescription;
    }

    public class Media {
        private String m;

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }
    }
}
