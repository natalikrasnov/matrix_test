package com.app.matrix_natali.ui.main;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import com.app.matrix_natali.data.api.Api_Service;
import com.app.matrix_natali.data.api.Api_helper;
import com.app.matrix_natali.data.model.DataListObject;
import com.app.matrix_natali.data.model.DataObject;
import com.app.matrix_natali.data.model.DataObjectCategory;
import com.app.matrix_natali.data.repository.MainRepository;
import com.app.matrix_natali.utils.Mapping;

public class MainViewModel extends ViewModel {

    //get list from server
    private DataObject mDataObject;
    private Api_helper mApi_helper;
    private Api_Service mApi_service;
    private MainRepository mainRepository;

    public MainViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }
    public DataObject getmDataObject() {
        return mDataObject;
    }

    public void setmDataObject(DataObject mDataObject) {
        this.mDataObject = mDataObject;
    }

    public void initDataObject(Context context){
        mDataObject = mainRepository.getDataObject(context);
    }

    public Object[] getDataObjectCategories(){
        return this.mDataObject.getDataListCat();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  DataObjectCategory[] getDataObjectByCategory(){
        if(this.mDataObject == null) return null;
        DataObjectCategory[] objectsSorted = new DataObjectCategory[this.mDataObject.getDataListCat().length];
        for (int i = 0; i < this.mDataObject.getDataListCat().length; i++) {
            objectsSorted[i] = new DataObjectCategory(new DataListObject[this.mDataObject.getListDataListObject().length]
                    , this.mDataObject.getDataListCat()[i], this.mDataObject.getDataListCat()[i].getId());
        }
        for (int i = 0; i < this.mDataObject.getListDataListObject().length; i++) {
            int objectCatId = this.mDataObject.getListDataListObject()[i].getCatId();
            int objectSortedIndex = Mapping.findIndex( objectsSorted,  o -> ((DataObjectCategory)o).getCatId() == objectCatId);
            objectsSorted[objectSortedIndex].addDataListObject(this.mDataObject.getListDataListObject()[i]);
        }
        return objectsSorted;
    }

}