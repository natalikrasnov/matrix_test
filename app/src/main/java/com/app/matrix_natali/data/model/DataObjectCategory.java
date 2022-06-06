package com.app.matrix_natali.data.model;

public class DataObjectCategory {

    private DataListObject DataListCat;
    private category Category;

    public DataObjectCategory(DataListObject DataListCat,category Category){
        this.DataListCat = DataListCat;
        this.Category = Category;
    }

    public DataListObject getDataListCat() {
        return DataListCat;
    }

    public void setDataListCat(DataListObject dataListCat) {
        DataListCat = dataListCat;
    }

    public category getCategory() {
        return Category;
    }

    public void setCategory(category category) {
        Category = category;
    }
}
