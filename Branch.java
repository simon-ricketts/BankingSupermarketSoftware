/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Simon
 */
public class Branch {

    private IAddress BranchAddress;
    private String WorkingHours;
    private String SortCode;
    private String Manager;
    private String Filename;

    public Branch() {
        Filename = "HeadOffice.txt";
        BranchAddress = new IAddress();
    }

    public String ArrayListtoString() {
        StringBuilder result = new StringBuilder();
        result.append(BranchAddress.getName() + "," + BranchAddress.getStreet() + "," + BranchAddress.getArea() + "," + BranchAddress.getPostCode() + "," + BranchAddress.getTown() + "," + BranchAddress.getCountry() + "," + SortCode + "," + Manager + "," + WorkingHours + System.getProperty("line.separator"));
        return result.toString();
    }

    public void Display(javax.swing.JTextArea jAddressTextArea) {
        jAddressTextArea.setLineWrap(true);
        jAddressTextArea.append("Branch Name: " + BranchAddress.getName() + "\n");
        jAddressTextArea.append("Street: " + BranchAddress.getStreet() + "\n");
        jAddressTextArea.append("Area: " + BranchAddress.getArea() + "\n");
        jAddressTextArea.append("Postcode: " + BranchAddress.getPostCode() + "\n");
        jAddressTextArea.append("Town: " + BranchAddress.getTown() + "\n");
        jAddressTextArea.append("Country: " + BranchAddress.getCountry() + "\n");
        jAddressTextArea.append("Sort Code: " + SortCode + "\n");
        jAddressTextArea.append("Manager: " + Manager + "\n");
        jAddressTextArea.append("Opening Hours: " + WorkingHours + "\n");
    }

    public void Edit(String AddressName, String StreetName, String AreaName, String PostCodeName, String TownName, String CountryName, String SortCodeName, String ManagerName, String WorkingHoursName) {
        BranchAddress.setName(AddressName);
        BranchAddress.setStreet(StreetName);
        BranchAddress.setArea(AreaName);
        BranchAddress.setPostCode(PostCodeName);
        BranchAddress.setTown(TownName);
        BranchAddress.setCountry(CountryName);;
        SortCode = SortCodeName;
        Manager = ManagerName;
        WorkingHours = WorkingHoursName;
    }

    public void LoadFromFile() {

        int i = 0;
        String record;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                i++;
                if (i == 1) {
                    BranchAddress.setName(record);
                } else if (i == 2) {
                    BranchAddress.setStreet(record);
                } else if (i == 3) {
                    BranchAddress.setArea(record);
                } else if (i == 4) {
                    BranchAddress.setPostCode(record);
                } else if (i == 5) {
                    BranchAddress.setTown(record);
                } else if (i == 6) {
                    BranchAddress.setCountry(record);
                } else if (i == 7) {
                    SortCode = record;
                } else if (i == 8) {
                    Manager = record;
                } else if (i == 9) {
                    WorkingHours = record;
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }

    public void SaveToFile() {
        FileWriter writer;
        try {
            writer = new FileWriter(Filename, false);
            writer.write(BranchAddress.getName() + System.getProperty("line.separator"));
            writer.write(BranchAddress.getStreet() + System.getProperty("line.separator"));
            writer.write(BranchAddress.getArea() + System.getProperty("line.separator"));
            writer.write(BranchAddress.getPostCode() + System.getProperty("line.separator"));
            writer.write(BranchAddress.getTown() + System.getProperty("line.separator"));
            writer.write(BranchAddress.getCountry() + System.getProperty("line.separator"));
            writer.write(SortCode + System.getProperty("line.separator"));
            writer.write(Manager + System.getProperty("line.separator"));
            writer.write(WorkingHours + System.getProperty("line.separator"));
            writer.flush();
            writer.close();
            writer = null;
        } catch (IOException ioe) {
        }
    }
    
    public String getBranchName() {
        return BranchAddress.getName();
    }

    public void setBranchName(String strBranchName) {
        BranchAddress.setName(strBranchName);
    }

    public void setStreet(String strStreet) {
        BranchAddress.setStreet(strStreet);
    }

    public void setArea(String strArea) {
        BranchAddress.setArea(strArea);
    }

    public void setPostCode(String strPostCode) {
        BranchAddress.setPostCode(strPostCode);
    }

    public void setTown(String strTown) {
        BranchAddress.setTown(strTown);
    }

    public void setCountry(String strCountry) {
        BranchAddress.setCountry(strCountry);
    }

    public void setSortCode(String strSortCode) {
        SortCode = strSortCode;
    }

    public void setManager(String strManager) {
        Manager = strManager;
    }

    public void setWorkingHours(String strWorkingHours) {
        WorkingHours = strWorkingHours;
    }

}
