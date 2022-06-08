package com.app.matrix_natali.data.api;

import android.content.Context;
import android.util.Log;
import com.app.matrix_natali.data.model.DataObject;
import com.app.matrix_natali.utils.FileFormat;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Api_ServiceImpl implements Api_Service{

    private MainService service;
    private Context mContext;
    private  Gson gson;



    @Override
    public DataObject getDataObjectFromServer(Context context) {
        service = new MainService();
        gson = new Gson();
        mContext = context;
        try{
//            return this.getFromServer();
            return getFromLocalFile();
        }catch (Exception e){
            Log.e("Api_ServiceImpl: ", "getDataListObject: ",e );
            return null;
        }
    }

    private DataObject getFromLocalFile() throws IOException {
        BufferedReader reader = FileFormat.getFile(mContext,"jsonObject.json");
        DataObject result = gson.fromJson(FileFormat.getStringifyFileContent(reader),DataObject.class);
        return result;
    }

    private DataObject getFromServer(){
        Reader jsonObjectS = service.getJsonSOFromUrl("");
        return gson.fromJson(jsonObjectS, DataObject.class);
    }
}
