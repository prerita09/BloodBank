package com.example.adi18.blood;


public class User
{
    private String Name;
    private String Contact;
    private String Age;
    private String Bloodtype;
    private String Address;
    private String City;
    private String IDProofname;
    private String IDProofnumber;

    public User(String namee,String contactt,String age,String bloodtype,String address,String city,String idproofname,String idproofnumber)
    {
        Name=namee;
        Contact=contactt;
        Age=age;
        Bloodtype=bloodtype;
        Address=address;
        City=city;
        IDProofname=idproofname;
        IDProofnumber=idproofnumber;

    }

    public String getName() {
        return Name;
    }



    public String getContact() {
        return Contact;
    }



    public String getAge() {
        return Age;
    }



    public String getBloodtype() {
        return Bloodtype;
    }



    public String getAddress() {
        return Address;
    }



    public String getCity() {
        return City;
    }



    public String getIDProofname() {
        return IDProofname;
    }



    public String getIDProofnumber() {
        return IDProofnumber;
    }

    public void setName(String Name) {
       this.Name = Name;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public void setBloodtype(String Bloodtype) {
        this.Bloodtype = Bloodtype;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setIDProofname(String IDProofname) {
        this.IDProofname = IDProofname;
    }

    public void setIDProofnumber(String IDProofnumber) {
        this.IDProofnumber = IDProofnumber;
    }
}
