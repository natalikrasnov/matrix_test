
package com.app.matrix_natali.ui.main;

import androidx.lifecycle.ViewModel;

import com.app.matrix_natali.data.model.DataListObject;
import com.app.matrix_natali.data.model.DataObject;
import com.app.matrix_natali.data.model.DataObjectCategory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    //get list from server
    private DataObject mDataObject;

    public DataObject getmDataObject() {
        return mDataObject;
    }

    public void setmDataObject(DataObject mDataObject) {
        this.mDataObject = mDataObject;
    }

    public Object[] getDataObjectCategories(){
        return this.mDataObject.getDataListCat();
    }

    public Object[] getDataObjectByCategory(){
        DataObjectCategory[] objectsSorted = new DataObjectCategory[this.mDataObject.getDataListCat().length];
        for (int i = 0; i < this.mDataObject.getDataObject().size(); i++) {
            DataListObject object = this.mDataObject.getDataObject().get(i);
            objectsSorted[object.getCatId()] = new DataObjectCategory(object, this.mDataObject.getDataListCat()[i]); ///TODO: create deap copy!!!!
        }
        return objectsSorted;

    }

}