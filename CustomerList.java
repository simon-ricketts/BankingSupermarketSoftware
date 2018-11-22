/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ee14ssr
 */
public class CustomerList {

    public ArrayList<Customer> Clients;
    private String Filename;

    public CustomerList() {
        Clients = new ArrayList<>();
        Filename = "ListOfCustomers.txt";
        Clients.clear();
        ReadClientList();
    }

    public void add(Customer src) {
        Clients.add(src);
    }

    public void remove(Customer src) {
        Clients.remove(src);
    }

    public void clear() {
        Clients.clear();
    }

    public void PrintCustomerAccounts() {
        for (int i = 0; i < Clients.size(); i++) {
            Clients.get(i).PrintAccountList();
        }
    }
    
    public void ReadCustomerAccounts() {
        for (int i = 0; i < Clients.size(); i++) {
            Clients.get(i).ReadAccountList();
        }
    }

    public void ClearCustomerAccounts() {
        for (int i = 0; i < Clients.size(); i++) {
            Clients.get(i).clearAccount();
        }
    }

    public void RemoveSpecificCustomer(String strFirstName, String strSurname) {
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getFirstName().equals(strFirstName) && Clients.get(i).getSurname().equals(strSurname)) {
                Clients.remove(i);
                JOptionPane.showMessageDialog(null, "Client Removed");
            }
        }
    }

    public void ClearTextFile() {
        try {
            PrintWriter writer = new PrintWriter(Filename);
            writer.print("");
            writer.close();
        } catch (Exception ioe) {
        }
    }

    public void PrintClientList() {
        FileWriter writer;

        try {
            writer = new FileWriter(Filename, false);
            for (int i = 0; i < Clients.size(); i++) {
                writer.write(Clients.get(i).ArrayListtoString());
            }
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }

    public void ReadClientList() {
        String record;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                Customer TempCustomer = new Customer();
                TempCustomer.setFirstName(record.split(",")[0]);
                TempCustomer.setSurname(record.split(",")[1]);
                TempCustomer.setDOB(record.split(",")[2]);
                TempCustomer.setStreet(record.split(",")[3]);
                TempCustomer.setHouseName(record.split(",")[4]);
                TempCustomer.setHouseNo(record.split(",")[5]);
                TempCustomer.setArea(record.split(",")[6]);
                TempCustomer.setPostCode(record.split(",")[7]);
                TempCustomer.setTown(record.split(",")[8]);
                TempCustomer.setCountry(record.split(",")[9]);
                Clients.add(TempCustomer);
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }

    public void Display(JTextArea jClientsTextArea) {
        for (int i = 0; i < Clients.size(); i++) {
            Clients.get(i).Display(jClientsTextArea);
        }
    }

    public void EditByName(String FirstNameIdentifier, String SurnameIdentifier, String FirstName, String Surname, String DOB, String Street, String HouseName, String HouseNumber, String Area, String PostCode, String Town, String Country) {
        for (int i = 0; i < Clients.size(); i++) {
            if (FirstNameIdentifier.equals(Clients.get(i).getFirstName()) && SurnameIdentifier.equals(Clients.get(i).getSurname())) {
                Clients.get(i).setFirstName(FirstName);
                Clients.get(i).setSurname(Surname);
                Clients.get(i).setDOB(DOB);
                Clients.get(i).setStreet(Street);
                Clients.get(i).setHouseName(HouseName);
                Clients.get(i).setHouseNo(HouseNumber);
                Clients.get(i).setArea(Area);
                Clients.get(i).setPostCode(PostCode);
                Clients.get(i).setTown(Town);
                Clients.get(i).setCountry(Country);
                JOptionPane.showMessageDialog(null, "Client Edited");
            }
        }
    }

    public Customer find(Customer src, String firstNameIdentifier, String surnameIdentifier) {
        src.setFirstName(firstNameIdentifier);
        src.setSurname(surnameIdentifier);
        Customer FoundCustomer = new Customer();
        for (int i = 0; i < Clients.size(); i++) {
            if (src.getFirstName().equals(Clients.get(i).getFirstName()) && src.getSurname().equals(Clients.get(i).getSurname())) {
                FoundCustomer = Clients.get(i);
            }
        }
        return FoundCustomer;
    }

    public boolean findCustomerCheck(String FirstNameIdentifier, String SurnameIdentifier) {
        boolean nameCheck = false;
        for (int i = 0; i < Clients.size(); i++) {
            if (FirstNameIdentifier.equals(Clients.get(i).getFirstName()) && SurnameIdentifier.equals(Clients.get(i).getSurname())) {
                nameCheck = true;
            }
        }
        return nameCheck;
    }

    public Customer findByName(String FirstNameIdentifier, String SurnameIdentifier) {
        Customer FoundCustomer = new Customer();
        for (int i = 0; i < Clients.size(); i++) {
            if (FirstNameIdentifier.equals(Clients.get(i).getFirstName()) && SurnameIdentifier.equals(Clients.get(i).getSurname())) {
                FoundCustomer = Clients.get(i);
            }
        }
        return FoundCustomer;
    }

    public void DisplayTransaction(String FirstNameIdentifier, String SurnameIdentifier, JTextArea jTransactionTextArea, int accountNumber, Customer FoundCustomer) {
        for (int i = 0; i < Clients.size(); i++) {
            if (FirstNameIdentifier.equals(Clients.get(i).getFirstName()) && SurnameIdentifier.equals(Clients.get(i).getSurname())) {
                Clients.get(i).DisplayTransaction(jTransactionTextArea, accountNumber, FoundCustomer);
            }
        }
    }
}
