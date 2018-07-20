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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Simon
 */
public class BranchList {

    private String Filename;
    public ArrayList<Branch> Branches;

    public BranchList() {
        Filename = "ListOfBranches.txt";
        Branches = new ArrayList<>();
    }

    public void add(Branch src) {
        Branches.add(src);
    }

    public void remove(Branch src) {
        Branches.remove(src);
    }

    public void clear() {
        Branches.clear();
    }

    public void ClearTextFile() {
        try {
            PrintWriter writer = new PrintWriter(Filename);
            writer.print("");
            writer.close();
        } catch (Exception ioe) {
        }
    }

    public void PrintBranchesList() {
        FileWriter writer;

        try {
            writer = new FileWriter(Filename, false);
            for (int i = 0; i < Branches.size(); i++) {
                writer.write(Branches.get(i).ArrayListtoString());
            }
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }

    public void EditByName(String BranchNameIdentifier, String AddressName, String StreetName, String AreaName, String PostCodeName, String TownName, String CountryName, String SortCodeName, String ManagerName, String WorkingHoursName) {
        for (int i = 0; i < Branches.size(); i++) {
            if (BranchNameIdentifier.equals(Branches.get(i).getBranchName())) {
                Branches.get(i).setBranchName(AddressName);
                Branches.get(i).setStreet(StreetName);
                Branches.get(i).setArea(AreaName);
                Branches.get(i).setPostCode(PostCodeName);
                Branches.get(i).setTown(TownName);
                Branches.get(i).setCountry(CountryName);
                Branches.get(i).setSortCode(SortCodeName);
                Branches.get(i).setManager(ManagerName);
                Branches.get(i).setWorkingHours(WorkingHoursName);
                JOptionPane.showMessageDialog(null, "Branch Edited");
            }
        }
    }
    
        public void RemoveSpecificBranch(String strBranchName) {
        for (int i = 0; i < Branches.size(); i++) {
            if (Branches.get(i).getBranchName().equals(strBranchName)) {
                Branches.remove(i);
                JOptionPane.showMessageDialog(null, "Branch Removed");
            }
        }
    }

    public void ReadBranchesList() {
        String record;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                Branch TempBranch = new Branch();
                TempBranch.setBranchName(record.split(",")[0]);
                TempBranch.setStreet(record.split(",")[1]);
                TempBranch.setArea(record.split(",")[2]);
                TempBranch.setPostCode(record.split(",")[3]);
                TempBranch.setTown(record.split(",")[4]);
                TempBranch.setCountry(record.split(",")[5]);
                TempBranch.setSortCode(record.split(",")[6]);
                TempBranch.setManager(record.split(",")[7]);
                TempBranch.setWorkingHours(record.split(",")[8]);
                Branches.add(TempBranch);
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }

    public void Display(JTextArea jClientsTextArea) {
        for (int i = 0; i < Branches.size(); i++) {
            Branches.get(i).Display(jClientsTextArea);
        }
    }

    public void find(Branch src, String branchIdentifier, JTextArea jFindBranchTextArea) {
        src.setBranchName(branchIdentifier);
        for (int i = 0; i < Branches.size(); i++) {
            if (src.getBranchName().equals(Branches.get(i).getBranchName())) {
                Branches.get(i).Display(jFindBranchTextArea);
            }
        }
    }
}
