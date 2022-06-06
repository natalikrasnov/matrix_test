package com.app.matrix_natali.data.model;

import com.app.matrix_natali.utils.convert;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.List;
import java.lang.reflect.Type;

public class DataObject {

    private category[] DataListCat;
    private List<DataListObject> DataObject; //DataListObject

    private final Type listType;

    public DataObject(Object[] DataListCat,Object DataObject) {
        listType = new TypeToken<List<DataListObject>>(){}.getType();

        this.DataListCat = (category[]) DataListCat;
        this.DataObject = (new convert(listType)).convertJsonToList(DataObject);
    }

    public List<DataListObject> getDataObject() {
        return DataObject;
    }

    public void setDataObject(List<DataListObject> dataObject) {
        DataObject = dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.DataObject = (new convert(listType)).convertJsonToList(dataObject);
    }

    public void setDataObject(Object[] dataObject) {
        this.DataObject = (new convert(listType)).convertArrayToList(dataObject);
    }

    public category[] getDataListCat() {
        return DataListCat;
    }

    public void setDataListCat(Object[] dataListCat) {
        DataListCat = (category[]) dataListCat;
    }
}
