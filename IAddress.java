/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author ee14ssr
 */
public class IAddress {

    private String Name;
    private String Street;
    private String HouseNo;
    private String HouseName;
    private String Area;
    private String PostCode;
    private String Town;
    private String Country;

    public IAddress() {
        Name = "";
        Street = "";
        HouseNo = "";
        HouseName = "";
        Area = "";
        PostCode = "";
        Town = "";
        Country = "";
    }

    public String getName() {
        return Name;
    }

    public String getStreet() {
        return Street;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public String getHouseName() {
        return HouseName;
    }

    public String getArea() {
        return Area;
    }

    public String getPostCode() {
        return PostCode;
    }

    public String getTown() {
        return Town;
    }

    public String getCountry() {
        return Country;
    }

    public void setName(String strName) {
        Name = strName;
    }

    public void setStreet(String strStreet) {
        Street = strStreet;
    }

    public void setHouseNo(String strHouseNo) {
        HouseNo = strHouseNo;
    }

    public void setHouseName(String strHouseName) {
        HouseName = strHouseName;
    }

    public void setArea(String strArea) {
        Area = strArea;
    }

    public void setPostCode(String strPostCode) {
        PostCode = strPostCode;
    }

    public void setTown(String strTown) {
        Town = strTown;
    }

    public void setCountry(String strCountry) {
        Country = strCountry;
    }

}
