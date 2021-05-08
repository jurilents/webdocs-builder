package org.obrii.fitdocs.entities;

public class Documents {



    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int categotyId;

    public int getcategotyId() {
        return categotyId;
    }

    public void setcategotyId(int id) {
        this.categotyId = categotyId;
    }



    public String name;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }



    public String sourceUrl;

    public String getsourceUrl() {
        return sourceUrl;
    }

    public void setsourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }



    public String creationDate;

    public String getcreationDate() {
        return creationDate;
    }

    public void setcreationDate(String creationDate) {
        this.creationDate = creationDate;
    }



    public byte rate;

    public byte getrate() {
        return rate;
    }

    public void setrate(byte rate) {
        this.rate = rate;
    }



    public boolean isRecommended;

    public boolean getisRecommended() {
        return isRecommended;
    }

    public void setisRecommended(boolean isRecommended) {
        this.isRecommended = isRecommended;
    }
}
