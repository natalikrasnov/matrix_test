package com.app.matrix_natali.data.model;

public class category {

    private int id;
    private String CTitle;


    public category(int id, String cTitle) {
        this.id = id;
        CTitle = cTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }
}
