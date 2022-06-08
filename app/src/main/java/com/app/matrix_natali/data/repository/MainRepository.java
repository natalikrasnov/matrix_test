package com.app.matrix_natali.data.repository;

import android.content.Context;
import com.app.matrix_natali.data.api.Api_helper;
import com.app.matrix_natali.data.model.DataObject;

public class MainRepository {

    private Api_helper api_helper;

    public MainRepository(Api_helper api_helper){
        this.api_helper = api_helper;
    }

    public DataObject getDataObject(Context context){
        return this.api_helper.getDataListCat(context);
    }
}
