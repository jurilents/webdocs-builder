package org.obrii.fitdocs.entities;

public class FieldKeys {



    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int docId;

    public int getdocId() {
        return docId;
    }

    public void setdocId(int docId) {
        this.docId = docId;
    }



    public Integer minLenght;

    public Integer getminLenght() {
        return minLenght;
    }

    public void setminLenght(Integer minLenght) {
        this.minLenght = minLenght;
    }



    public Integer maxLenght;

    public Integer getmaxLenght() {
        return minLenght;
    }

    public void setmaxLenght(Integer maxLenght) {
        this.maxLenght = maxLenght;
    }



    public boolean isRequired;

    public int getisRequired() {
        return minLenght;
    }

    public void setisRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }



    public byte type;

    public int gettype() {
        return type;
    }

    public void settype(byte type) {
        this.type = type;
    }
}
