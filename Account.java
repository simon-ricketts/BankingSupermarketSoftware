/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ee14ssr
 */
public abstract class Account {

    protected String sortCode;
    protected int accountNo;
    protected double balance;
    protected String nameOfBank;
    protected double rate;
    protected Date lastReportedDate;
    protected boolean Joint;
    protected Customer associatedCustomer;
    protected int transactions;
    protected Date accountCreationDate;
    protected String accountType;

    public Account(Customer c) {
        sortCode = "";
        accountNo = 0;
        balance = 0;
        transactions = 0;
        nameOfBank = "";
        rate = 1.2;
        lastReportedDate = new Date(01/01/1900);
        associatedCustomer = c;
        accountCreationDate = new Date();
    }

    protected abstract void deposit(double Amount);

    protected abstract void withdraw(double Amount, Date transactionDate);

    public String getSortCode() {
        return sortCode;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public double getRate() {
        return rate;
    }

    public Date getLastReportedDate() {
        return lastReportedDate;
    }
    
    public String getAccountType() {
        return accountType;
    }

    public void setSortCode(String stringSortCode) {
        sortCode = stringSortCode;
    }

    public void setAccountNo(int intAccountNo) {
        accountNo = intAccountNo;
    }

    public void setBalance(double doubleBalance) {
        balance = doubleBalance;
    }

    public void setNameOfBank(String stringNameOfBank) {
        nameOfBank = stringNameOfBank;
    }

    public void setRate(double doubleRate) {
        rate = doubleRate;
    }

    public void setLastReportedDate(Date transactionDate) {
        lastReportedDate = transactionDate;
    }
    
    public void setAccountType(String strAccountType) {
        accountType = strAccountType;
    }

    public void create(String aSortCode, int aAccountNo, double aBalance, String aNameOfBank, double aRate, Date aAccountCreationDate) {
        sortCode = aSortCode;
        accountNo = aAccountNo;
        balance = aBalance;
        nameOfBank = aNameOfBank;
        rate = aRate;
        accountCreationDate = aAccountCreationDate;
    }

    public void Display(JTextArea jAccountTextArea) {
        jAccountTextArea.setLineWrap(true);
        jAccountTextArea.append("SortCode: " + sortCode + "\n");
        jAccountTextArea.append("Account Number: " + String.valueOf(accountNo) + "\n");
        jAccountTextArea.append("Balance: " + String.valueOf(balance) + "\n");
        jAccountTextArea.append("Bank Name: " + nameOfBank + "\n");
        jAccountTextArea.append("Rate: " + String.valueOf(rate) + "\n");
        String lastDate = new SimpleDateFormat("dd/MM/yyyy").format(lastReportedDate);
        jAccountTextArea.append("Last Reported Date: " +  lastDate + "\n");
    }

    public void saveToFile() {
        FileWriter writer;
        try {
            writer = new FileWriter("Account.txt", true);
            writer.write(sortCode + "," + accountNo + "," + balance + "," + nameOfBank + "," + rate + "," + lastReportedDate + "\n");
            writer.flush();
            writer.close();
            writer = null;
        } catch (IOException ioe) {
        }
    }

    public void calculateCharges() {
        balance = balance + (balance * rate);
    }

    public void printStatement() {
        FileWriter writer;
        try {
            writer = new FileWriter("AccountStatement.txt", true);
            writer.write(sortCode + "," + accountNo + "," + balance + "," + nameOfBank + "," + lastReportedDate + "\n");
            writer.flush();
            writer.close();
            writer = null;
        } catch (IOException ioe) {
        }
    }

    public void LastReportedDate(Date dateLastReportedDate) {
        lastReportedDate = dateLastReportedDate;
    }

    protected abstract void endMonth(Date transactionDate, JTextArea jAccountTextArea);

    protected void endMonthUtil(JTextArea jAccountTextArea) {
        jAccountTextArea.append("Transactions:" + transactions + "\t Balance: " + balance + "\t(" + this + ")");
        transactions = 0;
    }

}
