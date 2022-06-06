package com.app.matrix_natali.data.api;

import android.content.Context;

import com.app.matrix_natali.data.model.DataListObject;

import java.util.List;

public class Api_helper {

    private Api_Service apiService;

    Api_helper(Api_Service apiService){
        this.apiService = apiService;
    }

    public List<DataListObject> getDataListCat(Context context) {
        return apiService.getDataListObject(context);
    }
}
