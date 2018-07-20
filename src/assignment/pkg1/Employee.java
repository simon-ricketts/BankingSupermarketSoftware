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

public class Employee {

    private String Name;
    private String Password;
    private String Filename;

    public Employee() {
        Filename = "RegisteredUsers.txt";
    }

    public boolean isRegistered(String newName, String newPassword) {
        boolean isRegistered;
        Name = newName;
        Password = newPassword;
        FileWriter writer;
        try {
            writer = new FileWriter(Filename, true);
            writer.write(Name + System.getProperty("line.separator"));
            writer.write(Password + System.getProperty("line.separator"));
            writer.write("##" + System.getProperty("line.separator"));
            isRegistered = true;
            writer.flush();
            writer.close();
            writer = null;
        } catch (IOException ioe) {
            isRegistered = false;
        }
        return isRegistered;
    }

    public boolean isUser(String newName, String newPassword) {
        Name = newName;
        Password = newPassword;
        boolean isNameFound = false;
        boolean isPasswordFound = false;
        boolean isFound = false;
        int NameLocator = 0;
        int i = 0;
        String record;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                i++;
                if (Name.contentEquals(record)) {
                    isNameFound = true;
                    NameLocator = i;
                }
                if (i == NameLocator + 1) {
                    if (Password.contentEquals(record)) {
                        isPasswordFound = true;
                    }
                }
            }
            bin.close();
            bin = null;
            if (isNameFound == true && isPasswordFound == true) {
                isFound = true;
            }

        } catch (IOException ioe) {
            isFound = false;
        }
        return isFound;
    }

    public boolean isEmployee(String newName) {
        Name = newName;
        boolean isEmployeeFound = false;
        if (Name.substring(Name.lastIndexOf(":") + 1).matches("Employee")) {
            isEmployeeFound = true;
        }
        return isEmployeeFound;
    }

    public boolean isAdministrator(String newName) {
        Name = newName;
        boolean isAdministratorFound = false;
        if (Name.substring(Name.lastIndexOf(":") + 1).matches("Administrator")) {
            isAdministratorFound = true;
        }
        return isAdministratorFound;
    }

    public boolean isCustomer(String newName) {
        Name = newName;
        boolean isCustomerFound = false;
        if (Name.substring(Name.lastIndexOf(":") + 1).matches("Customer")) {
            isCustomerFound = true;
        }
        return isCustomerFound;
    }
}
