/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ee14ssr
 */
public class CurrentAccount extends Account {

    private double Overdraft;

    public CurrentAccount(Customer cust) {
        super(cust);
        Overdraft = 100;
        accountType = "CurrentAccount";
    }

    public void displayCurrentAccount(JTextArea jAccountTextArea) {
        super.Display(jAccountTextArea);
    }

    public void deposit(double Amount) {
        balance = balance + Amount;
    }

    public void withdraw(double Amount, Date transactionDate) {
        if (Amount > balance + Overdraft) {
            JOptionPane.showMessageDialog(null, "Overdraft is greater than £100" + "\n" + "A £25.00 Transaction Charge will take effect until Overdraft decreases below £100");
            balance = balance - Amount - 25;
            transactions++;
        } else {
            balance = balance - Amount;
            transactions++;
        }
    }

    public void endMonth(Date transactionDate, JTextArea jAccountTextArea) {
        long days = (transactionDate.getTime() - accountCreationDate.getTime()) / (1000 * 60 * 60 * 24);
        if (days >= 31) {
            jAccountTextArea.setText("");
            balance = balance * rate;
            transactions++;
            endMonthUtil(jAccountTextArea);
        }
    }
}
