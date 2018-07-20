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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Simon
 */
public class Customer {

    private String Filename;
    private String FirstName;
    private String Surname;
    private IAddress HomeAddress;
    public String DOB;
    private CurrentAccount OwnedAccounts;
    private ISAAccount ISAAccounts;
    private SavingAccount SavingAccounts;
    public ArrayList<Account> accounts;

    public Customer() {
        Filename = "CustomerDetails.txt";
        FirstName = "";
        Surname = "";
        DOB = "01/01/1900";
        HomeAddress = new IAddress();
        OwnedAccounts = new CurrentAccount(this);
        ISAAccounts = new ISAAccount(this);
        SavingAccounts = new SavingAccount(this);
        accounts = new ArrayList<>();
    }

    public void addAccount(Account src) {
        accounts.add(src);
    }

    public void clearAccount() {
        accounts.clear();
    }

    public void EmptyAccountsFile() {
        FileWriter writer;
        try {
            writer = new FileWriter("Accounts.txt", false);
            writer.write("");
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }

    public void ReadAccountList() {
        String record;
        FileReader reader;
        try {
            reader = new FileReader("Accounts.txt");
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                if (record.split(",")[0].equals(FirstName) & (record.split(",")[1].equals(Surname))) {
                    if (record.split(",")[4].equals("CurrentAccount")) {
                        CurrentAccount TempCurrentAccount = new CurrentAccount(this);
                        TempCurrentAccount.setNameOfBank(record.split(",")[2]);
                        TempCurrentAccount.setSortCode(record.split(",")[3]);
                        TempCurrentAccount.setAccountNo(Integer.valueOf(record.split(",")[5]));
                        TempCurrentAccount.setBalance(Double.valueOf(record.split(",")[6]));
                        TempCurrentAccount.setLastReportedDate(new SimpleDateFormat("dd/MM/yyyy").parse(record.split(",")[7]));
                        accounts.add(TempCurrentAccount);
                    } else if (record.split(",")[4].equals("ISAAccount")) {
                        ISAAccount TempISAAccount = new ISAAccount(this);
                        TempISAAccount.setNameOfBank(record.split(",")[2]);
                        TempISAAccount.setSortCode(record.split(",")[3]);
                        TempISAAccount.setAccountNo(Integer.valueOf(record.split(",")[5]));
                        TempISAAccount.setBalance(Double.valueOf(record.split(",")[6]));
                        TempISAAccount.setLastReportedDate(new SimpleDateFormat("dd/MM/yyyy").parse(record.split(",")[7]));
                        accounts.add(TempISAAccount);
                    } else if (record.split(",")[4].equals("SavingAccount")) {
                        SavingAccount TempSavingAccount = new SavingAccount(this);
                        TempSavingAccount.setNameOfBank(record.split(",")[2]);
                        TempSavingAccount.setSortCode(record.split(",")[3]);
                        TempSavingAccount.setAccountNo(Integer.valueOf(record.split(",")[5]));
                        TempSavingAccount.setBalance(Double.valueOf(record.split(",")[6]));
                        TempSavingAccount.setLastReportedDate(new SimpleDateFormat("dd/MM/yyyy").parse(record.split(",")[7]));
                        accounts.add(TempSavingAccount);
                    }
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        } catch (ParseException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PrintAccountList() {
        FileWriter writer;
        try {
            writer = new FileWriter("Accounts.txt", true);
            for (int i = 0; i < accounts.size(); i++) {
                writer.write(accounts.get(i).associatedCustomer.getFirstName() + "," + accounts.get(i).associatedCustomer.getSurname() + "," + accounts.get(i).getNameOfBank() + "," + accounts.get(i).getSortCode() + "," + accounts.get(i).getAccountType() + "," + accounts.get(i).getAccountNo() + "," + accounts.get(i).getBalance() + "," + new SimpleDateFormat("dd/MM/yyyy").format(accounts.get(i).getLastReportedDate()) + System.getProperty("line.separator"));
            }
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }

    public String ArrayListtoString() {
        StringBuilder result = new StringBuilder();
        result.append(FirstName + "," + Surname + "," + DOB + "," + HomeAddress.getStreet() + "," + HomeAddress.getHouseName() + "," + HomeAddress.getHouseNo() + "," + HomeAddress.getArea() + "," + HomeAddress.getPostCode() + "," + HomeAddress.getTown() + "," + HomeAddress.getCountry() + System.getProperty("line.separator"));
        return result.toString();
    }

    public void Display(javax.swing.JTextArea jAddressTextArea) {
        jAddressTextArea.setLineWrap(true);
        jAddressTextArea.append("First Name: " + FirstName + "\n");
        jAddressTextArea.append("Surname: " + Surname + "\n");
        jAddressTextArea.append("DOB:" + DOB + "\n");
        jAddressTextArea.append("Street: " + getAddress().getStreet() + "\n");
        jAddressTextArea.append("House Name: " + getAddress().getHouseName() + "\n");
        jAddressTextArea.append("House Number: " + getAddress().getHouseNo() + "\n");
        jAddressTextArea.append("Area: " + getAddress().getArea() + "\n");
        jAddressTextArea.append("Postcode: " + getAddress().getPostCode() + "\n");
        jAddressTextArea.append("Town: " + getAddress().getTown() + "\n");
        jAddressTextArea.append("Country: " + getAddress().getCountry() + "\n");
    }

    public void Edit(String strfirstname, String strsurname, String strDOB, String strStreet, String strHouseName, String strHouseNo, String strHouseArea, String strPostCode, String strTown, String strCountry) {
        FirstName = strfirstname;
        Surname = strsurname;
        DOB = strDOB;
        HomeAddress.setStreet(strStreet);
        HomeAddress.setHouseName(strHouseName);
        HomeAddress.setHouseNo(strHouseNo);
        HomeAddress.setArea(strHouseArea);
        HomeAddress.setPostCode(strPostCode);
        HomeAddress.setTown(strTown);
        HomeAddress.setCountry(strCountry);
    }

    public void DisplayFoundCustomer(Customer FoundCustomer, javax.swing.JTextArea jAddressTextArea) {
        jAddressTextArea.setLineWrap(true);
        jAddressTextArea.append("First Name: " + FoundCustomer.FirstName + "\n");
        jAddressTextArea.append("Surname: " + FoundCustomer.Surname + "\n");
        jAddressTextArea.append("DOB:" + FoundCustomer.DOB + "\n");
        jAddressTextArea.append("Street: " + FoundCustomer.getAddress().getStreet() + "\n");
        jAddressTextArea.append("House Name: " + FoundCustomer.getAddress().getHouseName() + "\n");
        jAddressTextArea.append("House Number: " + FoundCustomer.getAddress().getHouseNo() + "\n");
        jAddressTextArea.append("Area: " + FoundCustomer.getAddress().getArea() + "\n");
        jAddressTextArea.append("Postcode: " + FoundCustomer.getAddress().getPostCode() + "\n");
        jAddressTextArea.append("Town: " + FoundCustomer.getAddress().getTown() + "\n");
        jAddressTextArea.append("Country: " + FoundCustomer.getAddress().getCountry() + "\n");
    }

    public void SaveToFile() {
        FileWriter writer;
        try {
            writer = new FileWriter(Filename, false);
            writer.write(FirstName + System.getProperty("line.separator"));
            writer.write(Surname + System.getProperty("line.separator"));
            writer.write(DOB + System.getProperty("line.separator"));
            writer.write(HomeAddress.getStreet() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getHouseName() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getHouseNo() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getArea() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getPostCode() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getTown() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getCountry() + System.getProperty("line.separator"));
            writer.flush();
            writer.close();
            writer = null;
        } catch (IOException ioe) {
        }
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
                    FirstName = record;
                } else if (i == 2) {
                    Surname = record;
                } else if (i == 3) {
                    DOB = record;
                } else if (i == 4) {
                    HomeAddress.setStreet(record);
                } else if (i == 5) {
                    HomeAddress.setHouseName(record);
                } else if (i == 6) {
                    HomeAddress.setHouseNo(record);
                } else if (i == 7) {
                    HomeAddress.setArea(record);
                } else if (i == 8) {
                    HomeAddress.setPostCode(record);
                } else if (i == 9) {
                    HomeAddress.setTown(record);
                } else if (i == 10) {
                    HomeAddress.setCountry(record);
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }

    public boolean checkDOB(String DOB) {
        boolean CheckFormat;
        if (DOB.matches("01/01/1900")) {
            CheckFormat = true;
        } else {
            CheckFormat = false;
        }
        return CheckFormat;
    }

    public void deposit(double aValue, int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNo()) {
                accounts.get(i).deposit(aValue);
            }
        }
    }

    public void withdraw(double aValue, int accountNumber, Date transactionDate) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNo()) {
                accounts.get(i).withdraw(aValue, transactionDate);
            }
        }
    }

    public void updateLastRecordedDate(int accountNumber, Date transactionDate) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNo()) {
                accounts.get(i).setLastReportedDate(transactionDate);
            }
        }
    }

    public void endMonthStatement(Date transactionDate, int accountNumber, JTextArea jAccountTextArea) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNo()) {
                accounts.get(i).endMonth(transactionDate, jAccountTextArea);
            }
        }
    }

    public void DisplayTransaction(JTextArea jTransactionTextArea, int accountNumber, Customer FoundCustomer) {
        for (int i = 0; i < FoundCustomer.accounts.size(); i++) {
            if (accountNumber == FoundCustomer.accounts.get(i).getAccountNo()) {
                FoundCustomer.accounts.get(i).Display(jTransactionTextArea);
            }
        }
    }

    public IAddress getAddress() {
        return HomeAddress;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setFirstName(String strFirstName) {
        FirstName = strFirstName;
    }

    public void setSurname(String strSurname) {
        Surname = strSurname;
    }

    public void setDOB(String strDOB) {
        DOB = strDOB;
    }

    public void setStreet(String strStreet) {
        HomeAddress.setStreet(strStreet);
    }

    public void setHouseName(String strHouseName) {
        HomeAddress.setHouseName(strHouseName);
    }

    public void setHouseNo(String strHouseNo) {
        HomeAddress.setHouseNo(strHouseNo);
    }

    public void setArea(String strArea) {
        HomeAddress.setArea(strArea);
    }

    public void setPostCode(String strPostcode) {
        HomeAddress.setPostCode(strPostcode);
    }

    public void setTown(String strTown) {
        HomeAddress.setTown(strTown);
    }

    public void setCountry(String strCountry) {
        HomeAddress.setCountry(strCountry);
    }

    public void setBalance(double dblValue) {
        OwnedAccounts.setBalance(dblValue);
    }

    public boolean findAccountCheck(int accountNumber) {
        boolean accountCheck = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).accountNo) {
                accountCheck = true;
            }
        }
        return accountCheck;
    }

    public boolean currentAccountCheck(int accountNumber) {
        boolean currentAccountCheck = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).accountNo) {
                if (accounts.get(i).accountType == "CurrentAccount") {
                    currentAccountCheck = true;
                }
            }
        }
        return currentAccountCheck;
    }
}
