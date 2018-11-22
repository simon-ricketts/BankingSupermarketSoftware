/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class ElectronicProduct extends Product {

    private int guaranteeDuration;

    public ElectronicProduct() {
        setGuaranteeDuration(guaranteeDuration);
    }

    public void Edit(String strName, String strCategory, String strManufacturerName, double dblWeight, double dblPrice, int intGuaranteeDuration, Date dateExpiryDate, Date dateDateToOrder, int intMinimumStock, int intMaximumStock, String strImageIdentifier) {
        setName(strName);
        setCategory(strCategory);
        setManufacturerName(strManufacturerName);
        setWeight(dblWeight);
        setPrice(dblPrice);
        setGuaranteeDuration(intGuaranteeDuration);
        setExpiryDate(dateExpiryDate);
        setDateToOrder(dateDateToOrder);
        setMinimumStock(intMinimumStock);
        setMaximumStock(intMaximumStock);
        setImageIdentifier(strImageIdentifier);
        JOptionPane.showMessageDialog(null, "Electronic Product Added" + "\n" + "Product ID: " + id);
    }

    public void Display(javax.swing.JTextArea jElectronicProductsTextArea) {
        jElectronicProductsTextArea.setLineWrap(true);
        jElectronicProductsTextArea.append("Product ID: " + id + "\n");
        jElectronicProductsTextArea.append("Product Name: " + name + "\n");
        jElectronicProductsTextArea.append("Product Category: " + category + "\n");
        jElectronicProductsTextArea.append("Product Manufacturer: " + manufacturerName + "\n");
        jElectronicProductsTextArea.append("Product Weight (kg): " + weight + "\n");
        jElectronicProductsTextArea.append("Product Price (£): " + price + "\n");
        jElectronicProductsTextArea.append("Product VAT Price (£): " + vatPrice + "\n");
        jElectronicProductsTextArea.append("Product Guarantee Duration: " + guaranteeDuration + "\n");
        jElectronicProductsTextArea.append("Product Expiry Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(expiryDate) + "\n");
        jElectronicProductsTextArea.append("Product Date to Order (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "\n");
        jElectronicProductsTextArea.append("Minimum Stock: " + minimumStock + "\n");
        jElectronicProductsTextArea.append("Maximum Stock: " + maximumStock + "\n");
        jElectronicProductsTextArea.append("Current Stock: " + stock + "\n");
        jElectronicProductsTextArea.append("Most Recent Order Date: " + mostRecentOrderDate + "\n");
        jElectronicProductsTextArea.append("##" + "\n");
    }

    public String ArrayListToString() {
        StringBuilder result = new StringBuilder();
        result.append(id + "," + name + "," + category + "," + manufacturerName + "," + weight + "," + price + "," + guaranteeDuration + "," + new SimpleDateFormat("dd-MM-yyyy").format(expiryDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "," + minimumStock + "," + maximumStock + "," + stock + "," + imageIdentifier + "," + mostRecentOrderDate + System.getProperty("line.separator"));
        return result.toString();
    }

    public void setGuaranteeDuration(int intGuaranteeDuration) {
        if (intGuaranteeDuration < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Guarantee Duration Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        } else {
            guaranteeDuration = intGuaranteeDuration;
        }
    }

    public int getGuaranteeDuration() {
        return guaranteeDuration;
    }
}
