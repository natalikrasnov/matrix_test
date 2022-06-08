package com.app.matrix_natali.data.model;

public class DataListObject {

//    {
//        "CatId": 1,
//            "Title": "טרקטורוני היער והגולן",
//            "STitle": "הנחות ליחיד",
//            "Imag": "https://mobile.leumi-card.co.il/ImgHandler/GetImag.ashx?origpath=/he-il/Benefits/BenefitsPlus/Atractions/PublishingImags/arnak/TractoroniHayaar/טרקטרוני_הגולן_big.jpg&format=webp&type=b",
//            "Id": 101069,
//            "DataListAddr": [
//        {
//            "Addr": "רמת נפתלי",
//                "DAd": "מושב רמת נפתלי"
//        }
//        ]
//    }
    
    private int CatId;
    private String Title;
    private String STitle;  //כותרת משנה
    private String Imag;   //url
    private int Id;
    private Address[] DataListAddr;

    public DataListObject(int CatId, String title,String stitle, String Imag,int id,Object[] DataListAddr) {
        this.CatId = CatId;
        this.Title = title;
        this.STitle = stitle;
        this.Imag = Imag;
        this.Id = id;
        this.DataListAddr = (Address[]) DataListAddr;
    }

    public DataListObject(DataListObject oldObj){
        this(oldObj.getCatId(), oldObj.getTitle(), oldObj.getSTitle(), oldObj.getImag(), oldObj.getId(), oldObj.getDataListAddr());
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int CatId) {
        this.CatId = CatId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImag() {
        return Imag;
    }

    public void setImag(String Imag) {
        this.Imag = Imag;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Address[] getDataListAddr() {
        return DataListAddr;
    }

    public void setDataListAddr(Address[] dataListAddr) {
        DataListAddr = dataListAddr;
    }

    public String getSTitle() {
        return STitle;
    }

    public void setSTitle(String STitle) {
        this.STitle = STitle;
    }
}
