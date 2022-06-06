package com.app.matrix_natali.data.api;

import android.content.Context;
import android.util.Log;

import com.app.matrix_natali.data.model.DataListObject;
import com.app.matrix_natali.data.model.DataObject;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class Api_ServiceImpl implements Api_Service{

    private MainService service;
    private Context mContext;
    private  Gson gson;

    @Override
    public List<DataListObject> getDataListObject(Context context) {
        service = new MainService();
        gson = new Gson();
        mContext = context;
        try{

//            String jsonObjectS = service.getJsonSOFromUrl("");
//            DataObject dataObject = gson.fromJson(jsonObjectS, DataObject.class);

            DataObject dataObject = gson.fromJson(String.valueOf(mContext.getAssets().open("jsonObject.json")),DataObject.class);
            return dataObject.getDataObject();
        }catch (Exception e){
            Log.e("Api_ServiceImpl: ", "getDataListObject: ",e );
            return null;
        }
    }
}
