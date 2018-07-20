/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ee14ssr
 */
public class User {

    private String Name;
    private String Role;
    private String Password;
    private String Filename;

    public User() {
        Role = "Bank Employee";
        Filename = "login.txt";
    }

    public void User() {
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

    public void changePassword(String newName, String oldPassword, String newPassword) {
        Name = newName;
        int PasswordLocator = 0;
        int i = 0;
        String record;
        FileReader reader;
        FileWriter writer;
        try {
            PrintWriter tempwriter = new PrintWriter(new BufferedWriter(new FileWriter("login.temp")));
            writer = new FileWriter(Filename, true);
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                i++;
                if (oldPassword.contentEquals(record)) {
                    record.replace(oldPassword, newPassword);
                }
            }

            writer.flush();
            writer.close();
            writer = null;
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
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

    public boolean isManager(String newName) {
        Name = newName;
        boolean isManagerFound = false;
        if (Name.substring(Name.lastIndexOf(":") + 1).matches("Manager")) {
            isManagerFound = true;
        }
        return isManagerFound;
    }

    public boolean isAdvisor(String newName) {
        Name = newName;
        boolean isAdvisorFound = false;
        if (Name.substring(Name.lastIndexOf(":") + 1).matches("Advisor")) {
            isAdvisorFound = true;
        }
        return isAdvisorFound;
    }

    public boolean isClient(String newName) {
        Name = newName;
        boolean isClientFound = false;
        if (Name.substring(Name.lastIndexOf(":") + 1).matches("Client")) {
            isClientFound = true;
        }
        return isClientFound;
    }
}
