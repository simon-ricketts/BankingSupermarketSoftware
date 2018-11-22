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
public class FoodProduct extends Product {

    private String weightCategory;
    private Date useByDate;
    private Date soldByDate;

    public FoodProduct() {
        setWeightCategory(weightCategory);
        setUseByDate(useByDate);
        setSoldByDate(soldByDate);
    }

    public void Edit(String strName, String strCategory, String strManufacturerName, String strWeightCategory, double dblWeight, double dblPrice, Date dateExpiryDate, Date dateDateToOrder, Date dateUseByDate, Date dateSoldByDate, int intMinimumStock, int intMaximumStock, String strImageIdentifier) {
        setName(strName);
        setCategory(strCategory);
        setManufacturerName(strManufacturerName);
        setWeightCategory(strWeightCategory);
        setWeight(dblWeight);
        setPrice(dblPrice);
        setExpiryDate(dateExpiryDate);
        setDateToOrder(dateDateToOrder);
        setUseByDate(dateUseByDate);
        setSoldByDate(dateSoldByDate);
        setMinimumStock(intMinimumStock);
        setMaximumStock(intMaximumStock);
        setImageIdentifier(strImageIdentifier);
        JOptionPane.showMessageDialog(null, "Food Product Added" + "\n" + "Product ID: " + id);
    }

    public void Display(javax.swing.JTextArea jFoodProductsTextArea) {
        jFoodProductsTextArea.setLineWrap(true);
        jFoodProductsTextArea.append("Product ID: " + id + "\n");
        jFoodProductsTextArea.append("Product Name: " + name + "\n");
        jFoodProductsTextArea.append("Product Category: " + category + "\n");
        jFoodProductsTextArea.append("Product Manufacturer: " + manufacturerName + "\n");
        jFoodProductsTextArea.append("Product Weight Category: " + weightCategory + "\n");
        jFoodProductsTextArea.append("Product Weight: " + weight + "\n");
        jFoodProductsTextArea.append("Product Price (£): " + price + "\n");
        jFoodProductsTextArea.append("Product VAT Price (£): " + vatPrice + "\n");
        jFoodProductsTextArea.append("Product Expiry Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(expiryDate) + "\n");
        jFoodProductsTextArea.append("Product Date to Order (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "\n");
        jFoodProductsTextArea.append("Product Use By Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "\n");
        jFoodProductsTextArea.append("Product Sold By Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "\n");
        jFoodProductsTextArea.append("Minimum Stock: " + minimumStock + "\n");
        jFoodProductsTextArea.append("Maximum Stock: " + maximumStock + "\n");
        jFoodProductsTextArea.append("Current Stock: " + stock + "\n");
        jFoodProductsTextArea.append("Most Recent Order Date: " + mostRecentOrderDate + "\n");
        jFoodProductsTextArea.append("##" + "\n");
    }

    public String ArrayListToString() {
        StringBuilder result = new StringBuilder();
        result.append(id + "," + name + "," + category + "," + manufacturerName + "," + weightCategory + "," + weight + "," + price + "," + new SimpleDateFormat("dd-MM-yyyy").format(expiryDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "," + new SimpleDateFormat("dd-MM-yyyy").format(useByDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(soldByDate) + "," + minimumStock + "," + maximumStock + "," + stock + "," + imageIdentifier + "," + mostRecentOrderDate + System.getProperty("line.separator"));
        return result.toString();
    }

    public void setWeightCategory(String strWeightCategory) {
        weightCategory = strWeightCategory;
    }

    public void setUseByDate(Date dateUseByDate) {
        useByDate = dateUseByDate;
    }

    public void setSoldByDate(Date dateSoldByDate) {
        soldByDate = dateSoldByDate;
    }
    
    public Date getUseByDate(){
        return useByDate;
    }
    
    public Date getSoldByDate(){
        return soldByDate;
    }    
}
