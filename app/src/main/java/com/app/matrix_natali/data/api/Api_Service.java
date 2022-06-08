package com.app.matrix_natali.data.api;

import android.content.Context;

import com.app.matrix_natali.data.model.DataObject;

public interface Api_Service {

    DataObject getDataObjectFromServer(Context context);
}
