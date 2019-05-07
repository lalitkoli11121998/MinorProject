package com.example.dell.minorproject;

/**
 * Created by dell on 2/25/2019.
 */

public class UserData {
   public String article;
   public String disease;
   public String imageurl;
   public String remedies;
   public String symptoms;
   public String  youtube;
// harish n bola tha ki empty hona chahiye nhi to baap manega and i loss it

   public UserData(){


   }
    public UserData(String disease, String article, String imageurl, String remedies, String symptoms, String youtube) {

        this.disease= disease;
        this.article = article;
        this.imageurl = imageurl;
        this.remedies = remedies;
        this.symptoms = symptoms;
        this.youtube = youtube;
    }
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getRemedies() {
        return remedies;
    }

    public void setRemedies(String remedies) {
        this.remedies = remedies;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }


}
