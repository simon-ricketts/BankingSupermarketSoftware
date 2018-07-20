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
public class ISAAccount extends Account {

    private double MaximumLimitPerYear;
    private double DepositedThisYear;

    public ISAAccount(Customer cust) {
        super(cust);
        DepositedThisYear = 0;
        MaximumLimitPerYear = 3250;
        accountType = "ISAAccount";
    }

    public void displayISAAccount(JTextArea jAccountTextArea) {
        super.Display(jAccountTextArea);
    }

    public void deposit(double Amount) {
        if (Amount + DepositedThisYear > MaximumLimitPerYear) {
            JOptionPane.showMessageDialog(null, "Maximum Deposit Limit per Year of £3250 reached");
        } else {
            balance = balance + Amount;
            DepositedThisYear = DepositedThisYear + Amount;
            transactions++;
        }
    }

    public void withdraw(double Amount, Date transactionDate) {
        if (Amount > balance) {
            JOptionPane.showMessageDialog(null, "Amount withdrawn cannot be greater than current Balance");
        } else {
            balance = balance - Amount;
            transactions++;
        }
    }

    public void endMonth(Date transactionDate, JTextArea jAccountTextArea) {
        long days = (transactionDate.getTime() - accountCreationDate.getTime())/(1000*60*60*24);
        if(days >= 365){
            jAccountTextArea.setText("");
            balance = balance * rate;
            transactions++;
            endMonthUtil(jAccountTextArea);
        }
    }

}
