package com.app.matrix_natali.data.api;

import android.content.Context;

import com.app.matrix_natali.data.model.DataObject;


public class Api_helper {

    private Api_Service apiService;

    public Api_helper(Api_Service apiService){
        this.apiService = apiService;
    }

    public DataObject getDataListCat(Context context) {
        return  apiService.getDataObjectFromServer(context);
    }
}
