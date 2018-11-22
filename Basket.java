/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class Basket extends Product {

    private int amount;

    Basket() {
        setAmount(amount);
    }

    public void Edit(String strID, String strName, double dblPrice, int intStock, int intAmount, int intCurrentAmount) {
        int intNewAmount = intAmount + intCurrentAmount;
        setID(strID);
        setName(strName);
        setAmount(intNewAmount);
        setPrice(dblPrice);
        setStock(intStock);
    }

    public void Display(javax.swing.JTextArea jBasketProductsTextArea) {
        jBasketProductsTextArea.setLineWrap(true);
        jBasketProductsTextArea.append("Product ID: " + id + "\n");
        jBasketProductsTextArea.append("Product Name: " + name + "\n");
        jBasketProductsTextArea.append("Quantity: " + amount + "\n");
        jBasketProductsTextArea.append("Product Price (£): " + vatPrice + "\n");
        jBasketProductsTextArea.append("Total Price (£): " + (amount * vatPrice) + "\n");
        jBasketProductsTextArea.append("##" + "\n");
    }

    public String ArrayListToString() {
        StringBuilder result = new StringBuilder();
        result.append(id + "," + name + "," + amount + "," + vatPrice + "," + stock + "," + (amount * vatPrice) + System.getProperty("line.separator"));
        return result.toString();
    }

    public void setAmount(int intAmount) {
            amount = intAmount;
    }

    public int getAmount() {
        return amount;
    }
}
