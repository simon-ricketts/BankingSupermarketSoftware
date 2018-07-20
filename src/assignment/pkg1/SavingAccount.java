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
public class SavingAccount extends Account {

    private double WithdrawLimit;

    public SavingAccount(Customer cust) {
        super(cust);
        WithdrawLimit = 200;
        accountType = "SavingAccount";
    }

    public void displaySavingsAccount(JTextArea jAccountTextArea) {
        super.Display(jAccountTextArea);
    }

    public void deposit(double Amount) {
        balance = balance + Amount;
        transactions++;
    }

    public void withdraw(double Amount, Date transactionDate) {

        long days = (transactionDate.getTime() - accountCreationDate.getTime()) / (1000 * 60 * 60 * 24);
        if (days <= 90 && Amount > 0) {
            balance = balance - Amount - 10;
            transactions++;
            JOptionPane.showMessageDialog(null, "Withdrawal made within 90 days of opening Account" + "\n" + "A £10.00 Transaction Charge will take effect");
        } else {
            balance = balance - Amount;
            transactions++;
        }
    }

    public void endMonth(Date transactionDate, JTextArea jAccountTextArea) {
        long days = (transactionDate.getTime() - accountCreationDate.getTime()) / (1000 * 60 * 60 * 24);
        if (days >= 90) {
            jAccountTextArea.setText("");
            balance = balance * rate;
            transactions++;
            endMonthUtil(jAccountTextArea);
        }
    }
}
