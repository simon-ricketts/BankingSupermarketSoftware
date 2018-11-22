/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class Product {

    protected Supplier Manufacturer;
    protected String id;
    protected String name;
    protected String category;
    protected double weight;
    protected double price;
    protected double vatPrice;
    protected double orderPrice;
    protected Date expiryDate;
    protected Date dateToOrder;
    protected int minimumStock;
    protected int maximumStock;
    protected int stock;
    protected String manufacturerName;
    protected String deliveryCompany;
    protected double totalOrderPrice;
    protected int orderedStock;
    protected String imageIdentifier;
    protected Date orderDate;
    protected Date deliveryDate;
    protected String mostRecentOrderDate;

    public Product() {
        Manufacturer = new Supplier();
        id = UUID.randomUUID().toString();
        setName(name);
        setCategory(category);
        setWeight(weight);
        setPrice(price);
        setExpiryDate(expiryDate);
        setDateToOrder(dateToOrder);
        setMinimumStock(minimumStock);
        setMaximumStock(maximumStock);
        setStock(stock);
        setManufacturerName(manufacturerName);
        setDeliveryCompany(deliveryCompany);
        setTotalOrderPrice(totalOrderPrice);
        setOrderedStock(orderedStock);
        mostRecentOrderDate = "N/A";
    }

    public void Edit(String strName, String strCategory, String strManufacturerName, double dblWeight, double dblPrice, Date dateExpiryDate, Date dateDateToOrder, int intMinimumStock, int intMaximumStock, String strImageIdentifier) {
        setName(strName);
        setCategory(strCategory);
        setManufacturerName(strManufacturerName);
        setWeight(dblWeight);
        setPrice(dblPrice);
        setExpiryDate(dateExpiryDate);
        setDateToOrder(dateDateToOrder);
        setMinimumStock(intMinimumStock);
        setMaximumStock(intMaximumStock);
        setImageIdentifier(strImageIdentifier);
        JOptionPane.showMessageDialog(null, "Product Added" + "\n" + "Product ID: " + id);
    }

    public void Display(javax.swing.JTextArea jProductListTextArea) {
        jProductListTextArea.setLineWrap(true);
        jProductListTextArea.append("Product ID: " + id + "\n");
        jProductListTextArea.append("Product Name: " + name + "\n");
        jProductListTextArea.append("Product Category: " + category + "\n");
        jProductListTextArea.append("Product Manufacturer: " + manufacturerName + "\n");
        jProductListTextArea.append("Product Weight (kg): " + weight + "\n");
        jProductListTextArea.append("Product Price (£): " + price + "\n");
        jProductListTextArea.append("Product VAT Price (£): " + vatPrice + "\n");
        jProductListTextArea.append("Product Expiry Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(expiryDate) + "\n");
        jProductListTextArea.append("Product Date to Order (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "\n");
        jProductListTextArea.append("Minimum Stock: " + minimumStock + "\n");
        jProductListTextArea.append("Maximum Stock: " + maximumStock + "\n");
        jProductListTextArea.append("Current Stock: " + stock + "\n");
        jProductListTextArea.append("Most Recent Order Date: " + mostRecentOrderDate + "\n");
        jProductListTextArea.append("##" + "\n");
    }

    public void DisplayOrderedProducts(javax.swing.JTextArea jOrderedProductsTextArea) {
        jOrderedProductsTextArea.setLineWrap(true);
        jOrderedProductsTextArea.append("Product ID: " + id + "\n");
        jOrderedProductsTextArea.append("Product Name: " + name + "\n");
        jOrderedProductsTextArea.append("Product Category: " + category + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer: " + manufacturerName + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer Street: " + Manufacturer.getStreet() + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer House Number: " + Manufacturer.getHouseNo() + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer Town: " + Manufacturer.getTown() + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer Area: " + Manufacturer.getArea() + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer Postcode: " + Manufacturer.getPostcode() + "\n");
        jOrderedProductsTextArea.append("Product Manufacturer Country: " + Manufacturer.getCountry() + "\n");
        jOrderedProductsTextArea.append("Product Delivery Company: " + deliveryCompany + "\n");
        jOrderedProductsTextArea.append("Total Order Price (£): " + totalOrderPrice + "\n");
        jOrderedProductsTextArea.append("Ordered Stock: " + orderedStock + "\n");
        jOrderedProductsTextArea.append("Order Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(orderDate) + "\n");
        jOrderedProductsTextArea.append("Delivery Date (dd-mm-yyyy): " + new SimpleDateFormat("dd-MM-yyyy").format(deliveryDate) + "\n");
        jOrderedProductsTextArea.append("##" + "\n");
    }

    public String ArrayListToString() {
        StringBuilder result = new StringBuilder();
        result.append(id + "," + name + "," + category + "," + manufacturerName + "," + weight + "," + price + "," + new SimpleDateFormat("dd-MM-yyyy").format(expiryDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateToOrder) + "," + minimumStock + "," + maximumStock + "," + stock + "," + imageIdentifier + "," + mostRecentOrderDate + System.getProperty("line.separator"));
        return result.toString();
    }

    public void setID(String strID) {
        id = strID;
    }

    public void setName(String strName) {
        name = strName;
    }

    public void setCategory(String strCategory) {
        category = strCategory;
    }

    public void setManufacturer(String strManufacturer) {
        manufacturerName = strManufacturer;
    }

    public void setWeight(double dblWeight) {
        if (dblWeight < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Weight Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        } else {
            weight = dblWeight;
        }
    }

    public void setPrice(double dblPrice) {
        if (dblPrice < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Price Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        } else {
            price = dblPrice;
            vatPrice = dblPrice * 1.2;
        }
    }

    public void setExpiryDate(Date dateExpiryDate) {
        expiryDate = dateExpiryDate;
    }

    public void setDateToOrder(Date dateDateToOrder) {
        dateToOrder = dateDateToOrder;
    }

    public void setMinimumStock(int intMinimumStock) {
        if (intMinimumStock < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Minimum Stock Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        } else {
            minimumStock = intMinimumStock;
        }
    }

    public void setMaximumStock(int intMaximumStock) {
        if (intMaximumStock < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Maximum Stock Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        } else {
            maximumStock = intMaximumStock;
        }
    }

    public void setStock(int intStock) {
        if (intStock < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Stock Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        }
        {
            stock = stock + intStock;
        }
    }

    public void decrementStock(int intStock) {
        if (intStock < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Stock Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        }
        {
            stock = stock - intStock;
        }
    }

    public void setManufacturerName(String strManufacturerName) {
        manufacturerName = strManufacturerName;
    }

    public void setManufacturerAddress(String strStreet, int intHouseNumber, String strTown, String strArea, String strPostcode, String strCountry) {
        Manufacturer.setAddress(strStreet, intHouseNumber, strTown, strArea, strPostcode, strCountry);
    }

    public void setDeliveryCompany(String strDeliveryCompany) {
        deliveryCompany = strDeliveryCompany;
    }

    public void setTotalOrderPrice(double dblTotalOrderPrice) {
        if (dblTotalOrderPrice < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Order Price Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        }
        {
            totalOrderPrice = dblTotalOrderPrice;
        }
    }

    public void setOrderedStock(int intOrderedStock) {
        if (intOrderedStock < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Ordered Stock Value for Product ID: " + id + "\n" + "Value will remain unchanged, please correct in Edit Products tab");
        } else {
            orderedStock = intOrderedStock;
        }
    }

    public void setImageIdentifier(String strImageIdentifier) {
        imageIdentifier = strImageIdentifier;
    }

    public void setOrderDate(Date dateOrderDate) {
        orderDate = dateOrderDate;
    }

    public void setDeliveryDate(Date dateDeliveryDate) {
        deliveryDate = dateDeliveryDate;
    }

    public void setMostRecentOrderDate(String strMostRecentOrderDate) {
        mostRecentOrderDate = strMostRecentOrderDate;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getVATPrice() {
        return vatPrice;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getDateToOrder() {
        return dateToOrder;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public int getStock() {
        return stock;
    }

    public int getMaximumStock() {
        return maximumStock;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public String getImageIdentifier() {
        return imageIdentifier;
    }

}
