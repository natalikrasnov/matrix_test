package com.app.matrix_natali.data.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.app.matrix_natali.utils.Mapping;

public class DataObjectCategory {

    private int catId;
    private DataListObject[] DataListCat;
    private com.app.matrix_natali.data.model.Category Category;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public DataObjectCategory(DataListObject[] DataListCat, com.app.matrix_natali.data.model.Category Category, int id){
        this.catId = id;
        this.DataListCat = Mapping.map(DataListCat, o -> new DataListObject((DataListObject) o));
        this.Category = new Category(Category);
    }

    public DataListObject[] getDataListCat() {
        return DataListCat;
    }

    public void setDataListCat(DataListObject[] dataListCat) {
        DataListCat = dataListCat;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addDataListObject(DataListObject data) {
        for (int i = 0; i < this.DataListCat.length; i++) {
            if(this.DataListCat[i] == null) {
                DataListCat[i] = data;
                break;
            }
        }
    }

    public com.app.matrix_natali.data.model.Category getCategory() {
        return Category;
    }

    public void setCategory(com.app.matrix_natali.data.model.Category category) {
        Category = category;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

}
