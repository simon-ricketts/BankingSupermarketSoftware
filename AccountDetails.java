/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author Simon
 */
public class AccountDetails {

    private int accountNumber;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String postcode;
    private String country;
    private long phoneNumber;

    public AccountDetails() {
        setAccountNumber(accountNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);
        setAddress(address);
        setPostcode(postcode);
        setCountry(country);
        setPhoneNumber(phoneNumber);
    }

    public void EditAccountInfo(int intAccountNumber, String strFirstName, String strLastName, String strCity, String strAddress, String strPostcode, String strCountry, long intPhoneNumber) {
        setAccountNumber(intAccountNumber);
        setFirstName(strFirstName);
        setLastName(strLastName);
        setCity(strCity);
        setAddress(strAddress);
        setPostcode(strPostcode);
        setCountry(strCountry);
        setPhoneNumber(intPhoneNumber);
    }

    public void setAccountNumber(int intAccountNumber) {
        accountNumber = intAccountNumber;
    }

    public void setFirstName(String strFirstName) {
        firstName = strFirstName;
    }

    public void setLastName(String strLastName) {
        lastName = strLastName;
    }

    public void setCity(String strCity) {
        city = strCity;
    }

    public void setAddress(String strAddress) {
        address = strAddress;
    }

    public void setPostcode(String strPostcode) {
        postcode = strPostcode;
    }

    public void setCountry(String strCountry) {
        country = strCountry;
    }

    public void setPhoneNumber(long longPhoneNumber) {
        phoneNumber = longPhoneNumber;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
