package com.app.matrix_natali.data.model;

public class DataListObject {

    private int catId;
    private String Title;
    private String STitle;  //כותרת משנה
    private String image;   //url
    private int id;
    private String DataListAddr;

    public DataListObject(int catId, String title,String stitle, String image,int id,String DataListAddr) {
        this.catId = catId;
        this.Title = title;
        this.STitle = stitle;
        this.image = image;
        this.id = id;
        this.DataListAddr = DataListAddr;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataListAddr() {
        return DataListAddr;
    }

    public void setDataListAddr(String dataListAddr) {
        DataListAddr = dataListAddr;
    }

    public String getSTitle() {
        return STitle;
    }

    public void setSTitle(String STitle) {
        this.STitle = STitle;
    }
}
