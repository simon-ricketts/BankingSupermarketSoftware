/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class Supplier {

    private String street;
    private int houseNo;
    private String town;
    private String area;
    private String postcode;
    private String country;

    public Supplier() {
        street = "";
        houseNo = 0;
        area = "";
        postcode = "";
        town = "";
        country = "";
    }

    public void setAddress(String strStreet, int intHouseNumber, String strTown, String strArea, String strPostcode, String strCountry) {
        street = strStreet;
        if (houseNo < 0) {
            JOptionPane.showMessageDialog(null, "Invalid House Number Value" + "\n" + "Value will remain unchanged");
        } else {
            houseNo = intHouseNumber;
        }
        town = strTown;
        area = strArea;
        postcode = strPostcode;
        country = strCountry;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getArea() {
        return area;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }

}
