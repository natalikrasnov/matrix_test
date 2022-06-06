package com.app.matrix_natali.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

public class convert {

    private Gson gson;
    private Type listType;

    public convert(Type listType){
        gson = new Gson();
        this.listType = listType;
    }

    public  <T, listType> List<listType>  convertArrayToList(Array data){
        return gson.fromJson(String.valueOf(data), listType);
    }

    public <T, listType> List<listType> convertJsonToList(Object data){
         return gson.fromJson((JsonElement) data, listType);
    }

}
