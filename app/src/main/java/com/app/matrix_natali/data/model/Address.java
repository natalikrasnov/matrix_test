package com.app.matrix_natali.data.model;

public class Address {

    private String Addr;
    private String DAd;


    public Address(String addr, String dAd) {
        Addr = addr;
        DAd = dAd;
    }


    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getDAd() {
        return DAd;
    }

    public void setDAd(String DAd) {
        this.DAd = DAd;
    }
}
