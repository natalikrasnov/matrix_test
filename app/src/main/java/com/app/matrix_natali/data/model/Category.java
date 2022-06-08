package com.app.matrix_natali.data.model;

public class Category {

    private int CatId;
    private String CTitle;


    public Category(int CatId, String cTitle) {
        this.CatId = CatId;
        CTitle = cTitle;
    }

    public Category(Category oldObj){
        this(oldObj.getId(), oldObj.getCTitle());
    }

    public int getId() {
        return CatId;
    }

    public void setId(int id) {
        this.CatId = id;
    }

    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }
}
