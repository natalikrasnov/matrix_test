package com.app.matrix_natali.data.api;

import android.content.Context;

import com.app.matrix_natali.data.model.DataListObject;

import java.util.List;

public interface Api_Service {

    List <DataListObject> getDataListObject(Context context);
}
