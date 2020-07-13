package com.example.adi18.blood;

public class Account {

    private int SNo;
    private String Name;
    private String Area;
    private String City;

    public Account(int sno,String name,String area,String city){
        SNo=sno;
        Name=name;
        Area=area;
        City=city;

    }

    public int getSNo() {

        return SNo;
    }

    public void setSNo(int sno) {
        SNo=sno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
