package com.app.matrix_natali.data.model;

public class DataObject {

    private DataObjectO DataObject; //DataListObject

    public DataObject(Object DataObject) {
        this.DataObject = (DataObjectO) DataObject;
    }

    public DataObjectO getDataObject() {
        return DataObject;
    }

    public void setDataObject(DataObjectO DataObject) {
        this.DataObject = DataObject;
    }

    public void setListDataListObject(DataListObject[] ListDataListObject) {
        this.DataObject.setList(ListDataListObject);
    }

    public DataListObject[] getListDataListObject() {
        return this.DataObject.getList();
    }

    public Category[] getDataListCat() {
        return this.getDataObject().DataListCat;
    }

    public void setDataListCat(Object[] dataListCat) {
        this.DataObject.setDataListCat((Category[]) dataListCat);
    }

    private class DataObjectO {

        private DataListObject[] DataListObject;
        private Category[] DataListCat;//DataListCat


        public DataObjectO(Object[] list){
            this.DataListObject = (DataListObject[]) list;
        }

        public DataListObject[] getList() {
            return DataListObject;
        }

        public void setList(DataListObject[] list) {
            this.DataListObject = list;
        }

        public void setDataListCat(Category[] dataListCat) {
            DataListCat = dataListCat;
        }

        public Category[] getDataListCat() {
            return DataListCat;
        }
    }
}
