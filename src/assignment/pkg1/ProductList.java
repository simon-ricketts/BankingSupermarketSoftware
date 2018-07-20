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
import static java.lang.String.valueOf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Simon
 */
public class ProductList {

    private ArrayList<Product> Products;
    private ArrayList<Product> OrderedProducts;
    private ArrayList<FoodProduct> FoodProducts;
    private ArrayList<ElectronicProduct> ElectronicProducts;
    private ArrayList<Basket> BasketProducts;
    private ArrayList<Basket> WishlistProducts;
    private String Filename;
    private String FoodFilename;
    private String ElectronicFilename;
    private String OrderFilename;
    private String BasketFilename;
    private String WishlistFilename;
    private String PurchaseHistoryFilename;

    public ProductList() {
        Products = new ArrayList<>();
        OrderedProducts = new ArrayList<>();
        FoodProducts = new ArrayList<>();
        ElectronicProducts = new ArrayList<>();
        BasketProducts = new ArrayList<>();
        WishlistProducts = new ArrayList<>();
        Filename = "ListOfProducts.txt";
        FoodFilename = "ListOfFoodProducts.txt";
        ElectronicFilename = "ListOfElectronicProducts.txt";
        OrderFilename = "OrderHistory.txt";
        BasketFilename = "Basket.txt";
        WishlistFilename = "Wishlist.txt";
        PurchaseHistoryFilename = "PurchaseHistory.txt";
        ReadProductFile("Product");
        ReadProductFile("Food");
        ReadProductFile("Electronic");
        ReadProductFile("Basket");
        ReadProductFile("Wishlist");
        ReadOrderFile();
    }

    public void add(Product src) {
        Products.add(src);
    }

    public void addFoodProduct(FoodProduct src) {
        FoodProducts.add(src);
    }

    public void addElectronicProduct(ElectronicProduct src) {
        ElectronicProducts.add(src);
    }

    public void addBasketProduct(Basket src, String strArrayList) {
        switch (strArrayList) {
            case "Basket":
                BasketProducts.add(src);
                break;
            case "Wishlist":
                WishlistProducts.add(src);
                break;
        }
    }

    public void remove(Product src) {
        Products.remove(src);
    }

    public void removeFoodProduct(FoodProduct src) {
        FoodProducts.remove(src);
    }

    public void removeElectronicProduct(ElectronicProduct src) {
        ElectronicProducts.remove(src);
    }

    public void removeBasketProduct(Basket src, String strArrayList) {
        switch (strArrayList) {
            case "Basket":
                BasketProducts.remove(src);
                break;
            case "Wishlist":
                WishlistProducts.remove(src);
                break;
        }
    }

    public void clear(String strArrayList) {
        switch (strArrayList) {
            case "Product":
                Products.clear();
                break;
            case "Ordered":
                OrderedProducts.clear();
                break;
            case "Food":
                FoodProducts.clear();
                break;
            case "Electronic":
                ElectronicProducts.clear();
                break;
            case "Basket":
                BasketProducts.clear();
                break;
            case "Wishlist":
                WishlistProducts.clear();
                break;
        }
    }

    public void EditByID(String strEditProductID, String strEditProductName, String strEditProductCategory, double dblEditProductWeight, double dblEditProductPrice, Date dateEditProductExpiryDate, Date dateEditProductDateToOrder, int intEditProductMinimumStock) {
        boolean idCheck = false;
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getID().equals(strEditProductID)) {
                int ProductIdentifier = i;
                Products.get(ProductIdentifier).setName(strEditProductName);
                Products.get(ProductIdentifier).setCategory(strEditProductCategory);
                Products.get(ProductIdentifier).setWeight(dblEditProductWeight);
                Products.get(ProductIdentifier).setPrice(dblEditProductPrice);
                Products.get(ProductIdentifier).setExpiryDate(dateEditProductExpiryDate);
                Products.get(ProductIdentifier).setDateToOrder(dateEditProductDateToOrder);
                Products.get(ProductIdentifier).setMinimumStock(intEditProductMinimumStock);
                JOptionPane.showMessageDialog(null, "Product: " + strEditProductID + "\n" + "Product Name: " + Products.get(ProductIdentifier).getName() + "\n" + "\n" + "Updated");
                idCheck = true;
            }
        }
        if (idCheck == false) {
            JOptionPane.showMessageDialog(null, "No Product with that ID found");
        }
    }

    public void EditByID(String strEditProductID, String strEditProductName, String strEditProductCategory, String strEditProductWeightCategory, double dblEditProductWeight, double dblEditProductPrice, Date dateEditProductExpiryDate, Date dateEditProductDateToOrder, Date dateEditProductUseByDate, Date dateEditProductSoldByDate, int intEditProductMinimumStock) {
        boolean idCheck = false;
        for (int i = 0; i < FoodProducts.size(); i++) {
            if (FoodProducts.get(i).getID().equals(strEditProductID)) {
                int ProductIdentifier = i;
                FoodProducts.get(ProductIdentifier).setName(strEditProductName);
                FoodProducts.get(ProductIdentifier).setCategory(strEditProductCategory);
                FoodProducts.get(ProductIdentifier).setWeightCategory(strEditProductWeightCategory);
                FoodProducts.get(ProductIdentifier).setWeight(dblEditProductWeight);
                FoodProducts.get(ProductIdentifier).setPrice(dblEditProductPrice);
                FoodProducts.get(ProductIdentifier).setExpiryDate(dateEditProductExpiryDate);
                FoodProducts.get(ProductIdentifier).setDateToOrder(dateEditProductDateToOrder);
                FoodProducts.get(ProductIdentifier).setUseByDate(dateEditProductUseByDate);
                FoodProducts.get(ProductIdentifier).setSoldByDate(dateEditProductSoldByDate);
                FoodProducts.get(ProductIdentifier).setMinimumStock(intEditProductMinimumStock);
                JOptionPane.showMessageDialog(null, "Food Product: " + strEditProductID + "\n" + "Food Product Name: " + FoodProducts.get(ProductIdentifier).getName() + "\n" + "\n" + "Updated");
                idCheck = true;
            }
        }
        if (idCheck == false) {
            JOptionPane.showMessageDialog(null, "No Food Product with that ID found");
        }
    }

    public void EditByID(String strEditProductID, String strEditProductName, String strEditProductCategory, double dblEditProductWeight, double dblEditProductPrice, int intEditProductGuaranteeDuration, Date dateEditProductExpiryDate, Date dateEditProductDateToOrder, int intEditProductMinimumStock) {
        boolean idCheck = false;
        for (int i = 0; i < ElectronicProducts.size(); i++) {
            if (ElectronicProducts.get(i).getID().equals(strEditProductID)) {
                int ProductIdentifier = i;
                ElectronicProducts.get(ProductIdentifier).setName(strEditProductName);
                ElectronicProducts.get(ProductIdentifier).setCategory(strEditProductCategory);
                ElectronicProducts.get(ProductIdentifier).setWeight(dblEditProductWeight);
                ElectronicProducts.get(ProductIdentifier).setPrice(dblEditProductPrice);
                ElectronicProducts.get(ProductIdentifier).setGuaranteeDuration(intEditProductGuaranteeDuration);
                ElectronicProducts.get(ProductIdentifier).setExpiryDate(dateEditProductExpiryDate);
                ElectronicProducts.get(ProductIdentifier).setDateToOrder(dateEditProductDateToOrder);
                ElectronicProducts.get(ProductIdentifier).setMinimumStock(intEditProductMinimumStock);
                JOptionPane.showMessageDialog(null, "Electronic Product: " + strEditProductID + "\n" + "Electronic Product Name: " + ElectronicProducts.get(ProductIdentifier).getName() + "\n" + "\n" + "Updated");
                idCheck = true;
            }
        }
        if (idCheck == false) {
            JOptionPane.showMessageDialog(null, "No Electronic Product with that ID found");
        }
    }

    public boolean OrderByID(String strOrderProductID, int intOrderStock, Date dateOrderDate, String strArrayList) {
        boolean orderConfirmation = false;
        boolean idCheck = false;
        switch (strArrayList) {
            case "Product":
                for (int i = 0; i < Products.size(); i++) {
                    if (Products.get(i).getID().equals(strOrderProductID)) {
                        int ProductIdentifier = i;
                        idCheck = true;
                        if (Products.get(ProductIdentifier).getStock() + intOrderStock > Products.get(ProductIdentifier).getMaximumStock()) {
                            JOptionPane.showMessageDialog(null, "Exceeded Maximum Stock of Product ID: " + strOrderProductID + "\n" + "Product Name: " + Products.get(ProductIdentifier).getName() + "\n" + "Maximum Product Stock: " + Products.get(ProductIdentifier).getMaximumStock() + "\n" + "Only " + (Products.get(i).getMaximumStock() - Products.get(i).getStock()) + " more Units may be ordered");
                        } else {
                            int response = JOptionPane.showConfirmDialog(null, "Ordering " + intOrderStock + " units of Product: " + strOrderProductID + "\n" + "Product Name: " + Products.get(ProductIdentifier).getName() + "\n" + "Total Price: £" + (intOrderStock * Products.get(ProductIdentifier).getPrice()) + "\n" + "\n" + "Continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.NO_OPTION) {
                                JOptionPane.showMessageDialog(null, "Order Cancelled");
                            } else if (response == JOptionPane.YES_OPTION) {
                                String strMostRecentOrderDate = new SimpleDateFormat("dd-MM-yyyy").format(dateOrderDate);
                                Products.get(ProductIdentifier).setStock(intOrderStock);
                                getBasketProductInfoByID(strOrderProductID, "Basket").setStock(intOrderStock);
                                getBasketProductInfoByID(strOrderProductID, "Wishlist").setStock(intOrderStock);
                                Products.get(ProductIdentifier).setMostRecentOrderDate(strMostRecentOrderDate);
                                JOptionPane.showMessageDialog(null, intOrderStock + " units of Product ID: " + strOrderProductID + "\n" + "Product Name: " + Products.get(ProductIdentifier).getName() + "\n" + "\n" + "Ordered");
                                orderConfirmation = true;
                            } else if (response == JOptionPane.CLOSED_OPTION) {
                            }
                        }
                    }
                }
                if (idCheck == false) {
                    JOptionPane.showMessageDialog(null, "No Product with that ID found");
                }
                break;
            case "Food":
                for (int i = 0; i < FoodProducts.size(); i++) {
                    if (FoodProducts.get(i).getID().equals(strOrderProductID)) {
                        int ProductIdentifier = i;
                        idCheck = true;
                        if (FoodProducts.get(ProductIdentifier).getStock() + intOrderStock > FoodProducts.get(ProductIdentifier).getMaximumStock()) {
                            JOptionPane.showMessageDialog(null, "Exceeded Maximum Stock of Food Product ID: " + strOrderProductID + "\n" + "Product Name: " + FoodProducts.get(ProductIdentifier).getName() + "\n" + "Maximum Food Product Stock: " + FoodProducts.get(ProductIdentifier).getMaximumStock() + "\n" + "Only " + (FoodProducts.get(i).getMaximumStock() - FoodProducts.get(i).getStock()) + " more Units may be ordered");
                        } else {
                            int response = JOptionPane.showConfirmDialog(null, "Ordering " + intOrderStock + " units of Food Product: " + strOrderProductID + "\n" + "Food Product Name: " + FoodProducts.get(ProductIdentifier).getName() + "\n" + "Total Price: £" + (intOrderStock * FoodProducts.get(ProductIdentifier).getPrice()) + "\n" + "\n" + "Continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.NO_OPTION) {
                                JOptionPane.showMessageDialog(null, "Order Cancelled");
                            } else if (response == JOptionPane.YES_OPTION) {
                                String strMostRecentOrderDate = new SimpleDateFormat("dd-MM-yyyy").format(dateOrderDate);
                                FoodProducts.get(ProductIdentifier).setStock(intOrderStock);
                                getBasketProductInfoByID(strOrderProductID, "Basket").setStock(intOrderStock);
                                getBasketProductInfoByID(strOrderProductID, "Wishlist").setStock(intOrderStock);
                                FoodProducts.get(ProductIdentifier).setMostRecentOrderDate(strMostRecentOrderDate);
                                JOptionPane.showMessageDialog(null, intOrderStock + " units of Food Product ID: " + strOrderProductID + "\n" + "Food Product Name: " + FoodProducts.get(ProductIdentifier).getName() + "\n" + "\n" + "Ordered");
                                orderConfirmation = true;
                            } else if (response == JOptionPane.CLOSED_OPTION) {
                            }
                        }
                    }
                }
                if (idCheck == false) {
                    JOptionPane.showMessageDialog(null, "No Food Product with that ID found");
                }
                break;
            case "Electronic":
                for (int i = 0; i < ElectronicProducts.size(); i++) {
                    if (ElectronicProducts.get(i).getID().equals(strOrderProductID)) {
                        int ProductIdentifier = i;
                        idCheck = true;
                        if (ElectronicProducts.get(ProductIdentifier).getStock() + intOrderStock > ElectronicProducts.get(ProductIdentifier).getMaximumStock()) {
                            JOptionPane.showMessageDialog(null, "Exceeded Maximum Stock of Electronic Product ID: " + strOrderProductID + "\n" + "Electronic Product Name: " + ElectronicProducts.get(ProductIdentifier).getName() + "\n" + "Maximum Electronic Product Stock: " + ElectronicProducts.get(ProductIdentifier).getMaximumStock() + "\n" + "Only " + (ElectronicProducts.get(i).getMaximumStock() - ElectronicProducts.get(i).getStock()) + " more Units may be ordered");
                        } else {
                            int response = JOptionPane.showConfirmDialog(null, "Ordering " + intOrderStock + " units of Electronic Product: " + strOrderProductID + "\n" + "Electronic Product Name: " + ElectronicProducts.get(ProductIdentifier).getName() + "\n" + "Total Price: £" + (intOrderStock * ElectronicProducts.get(ProductIdentifier).getPrice()) + "\n" + "\n" + "Continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.NO_OPTION) {
                                JOptionPane.showMessageDialog(null, "Order Cancelled");
                            } else if (response == JOptionPane.YES_OPTION) {
                                String strMostRecentOrderDate = new SimpleDateFormat("dd-MM-yyyy").format(dateOrderDate);
                                ElectronicProducts.get(ProductIdentifier).setStock(intOrderStock);
                                getBasketProductInfoByID(strOrderProductID, "Basket").setStock(intOrderStock);
                                getBasketProductInfoByID(strOrderProductID, "Wishlist").setStock(intOrderStock);
                                ElectronicProducts.get(ProductIdentifier).setMostRecentOrderDate(strMostRecentOrderDate);
                                JOptionPane.showMessageDialog(null, intOrderStock + " units of Electronic Product ID: " + strOrderProductID + "\n" + "Electronic Product Name: " + ElectronicProducts.get(ProductIdentifier).getName() + "\n" + "\n" + "Ordered");
                                orderConfirmation = true;
                            } else if (response == JOptionPane.CLOSED_OPTION) {
                            }
                        }
                    }
                }
                if (idCheck == false) {
                    JOptionPane.showMessageDialog(null, "No Electronic Product with that ID found");
                }
                break;
        }
        return orderConfirmation;
    }

    public void RemoveByID(String strEditProductID, String strArrayList) {
        boolean idCheck = false;
        switch (strArrayList) {
            case "Product":
                for (int i = 0; i < Products.size(); i++) {
                    if (Products.get(i).getID().equals(strEditProductID)) {
                        int ProductIdentifier = i;
                        idCheck = true;
                        JOptionPane.showMessageDialog(null, "Product: " + strEditProductID + "\n" + "Product Name: " + Products.get(ProductIdentifier).getName() + "\n" + "Removed");
                        Products.remove(ProductIdentifier);
                    }
                }
                if (idCheck == false) {
                    JOptionPane.showMessageDialog(null, "No product with that ID found");
                }
                break;
            case "Food":
                for (int i = 0; i < FoodProducts.size(); i++) {
                    if (FoodProducts.get(i).getID().equals(strEditProductID)) {
                        int ProductIdentifier = i;
                        idCheck = true;
                        JOptionPane.showMessageDialog(null, "Food Product: " + strEditProductID + "\n" + "Food Product Name: " + FoodProducts.get(ProductIdentifier).getName() + "\n" + "Removed");
                        FoodProducts.remove(ProductIdentifier);
                    }
                }
                if (idCheck == false) {
                    JOptionPane.showMessageDialog(null, "No Food Product with that ID found");
                }
                break;
            case "Electronic":
                for (int i = 0; i < ElectronicProducts.size(); i++) {
                    if (ElectronicProducts.get(i).getID().equals(strEditProductID)) {
                        int ProductIdentifier = i;
                        idCheck = true;
                        JOptionPane.showMessageDialog(null, "Electronic Product: " + strEditProductID + "\n" + "Electronic Product Name: " + ElectronicProducts.get(ProductIdentifier).getName() + "\n" + "Removed");
                        ElectronicProducts.remove(ProductIdentifier);
                    }
                }
                if (idCheck == false) {
                    JOptionPane.showMessageDialog(null, "No Electronic Product with that ID found");
                }
                break;
        }
    }

    public void CheckForMinimalStock(String strArrayList) {
        switch (strArrayList) {
            case "Product":
                for (int i = 0; i < Products.size(); i++) {
                    if (Products.get(i).getStock() < Products.get(i).getMinimumStock()) {
                        JOptionPane.showMessageDialog(null, "Product ID: " + Products.get(i).getID() + "\n" + "Product Name: " + Products.get(i).getName() + "\n" + "Is below minimum stock" + "\n" + "\n" + "Order " + (Products.get(i).getMinimumStock() - Products.get(i).getStock()) + " to achieve Minimum Required Stock");
                    }
                }
                break;
            case "Food":
                for (int i = 0; i < FoodProducts.size(); i++) {
                    if (FoodProducts.get(i).getStock() < FoodProducts.get(i).getMinimumStock()) {
                        JOptionPane.showMessageDialog(null, "Food Product ID: " + FoodProducts.get(i).getID() + "\n" + "Food Product Name: " + FoodProducts.get(i).getName() + "\n" + "Is below minimum stock" + "\n" + "\n" + "Order " + (FoodProducts.get(i).getMinimumStock() - FoodProducts.get(i).getStock()) + " to achieve Minimum Required Stock");
                    }
                }
                break;
            case "Electronic":
                for (int i = 0; i < ElectronicProducts.size(); i++) {
                    if (ElectronicProducts.get(i).getStock() < ElectronicProducts.get(i).getMinimumStock()) {
                        JOptionPane.showMessageDialog(null, "Electronic Product ID: " + ElectronicProducts.get(i).getID() + "\n" + "Electronic Product Name: " + ElectronicProducts.get(i).getName() + "\n" + "Is below minimum stock" + "\n" + "\n" + "Order " + (ElectronicProducts.get(i).getMinimumStock() - ElectronicProducts.get(i).getStock()) + " to achieve Minimum Required Stock");
                    }
                }
                break;
        }
    }

    public void PrintOrderFile(String strOrderProductID, String strManufacturerStreet, int intManufacturerHouseNo, String strManufacturerTown, String strManufacturerArea, String strManufacturerPostcode, String strManufacturerCountry, int intOrderStock, String strDeliveryCompany, Date dateOrderDate, Date dateDeliveryDate, String strArrayList) {
        FileWriter writer;
        switch (strArrayList) {
            case "Product":
                try {
                    String totalPrice = valueOf(this.getProductInfoByID(strOrderProductID).getPrice() * intOrderStock);
                    String orderedAmount = valueOf(intOrderStock);
                    writer = new FileWriter(OrderFilename, true);
                    writer.write(strOrderProductID + "," + this.getProductInfoByID(strOrderProductID).getName() + "," + this.getProductInfoByID(strOrderProductID).getCategory() + "," + this.getProductInfoByID(strOrderProductID).getManufacturerName() + "," + strManufacturerStreet + "," + intManufacturerHouseNo + "," + strManufacturerTown + "," + strManufacturerArea + "," + strManufacturerPostcode + "," + strManufacturerCountry + "," + strDeliveryCompany + "," + orderedAmount + "," + totalPrice + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateOrderDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateDeliveryDate) + System.getProperty("line.separator"));
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
            case "Food":
                try {
                    String totalPrice = valueOf(this.getFoodProductInfoByID(strOrderProductID).getPrice() * intOrderStock);
                    String orderedAmount = valueOf(intOrderStock);
                    writer = new FileWriter(OrderFilename, true);
                    writer.write(strOrderProductID + "," + this.getFoodProductInfoByID(strOrderProductID).getName() + "," + this.getFoodProductInfoByID(strOrderProductID).getCategory() + "," + this.getFoodProductInfoByID(strOrderProductID).getManufacturerName() + "," + strManufacturerStreet + "," + intManufacturerHouseNo + "," + strManufacturerTown + "," + strManufacturerArea + "," + strManufacturerPostcode + "," + strManufacturerCountry + "," + strDeliveryCompany + "," + orderedAmount + "," + totalPrice + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateOrderDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateDeliveryDate) + System.getProperty("line.separator"));
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
            case "Electronic":
                try {
                    String totalPrice = valueOf(this.getElectronicProductInfoByID(strOrderProductID).getPrice() * intOrderStock);
                    String orderedAmount = valueOf(intOrderStock);
                    writer = new FileWriter(OrderFilename, true);
                    writer.write(strOrderProductID + "," + this.getElectronicProductInfoByID(strOrderProductID).getName() + "," + this.getElectronicProductInfoByID(strOrderProductID).getCategory() + "," + this.getElectronicProductInfoByID(strOrderProductID).getManufacturerName() + "," + strManufacturerStreet + "," + intManufacturerHouseNo + "," + strManufacturerTown + "," + strManufacturerArea + "," + strManufacturerPostcode + "," + strManufacturerCountry + "," + strDeliveryCompany + "," + orderedAmount + "," + totalPrice + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateOrderDate) + "," + new SimpleDateFormat("dd-MM-yyyy").format(dateDeliveryDate) + System.getProperty("line.separator"));
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
        }
    }

    public void ReadOrderFile() {
        String record;
        FileReader reader;
        try {
            reader = new FileReader(OrderFilename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                Product TempOrder = new Product();
                TempOrder.setID(record.split(",")[0]);
                TempOrder.setName(record.split(",")[1]);
                TempOrder.setCategory(record.split(",")[2]);
                TempOrder.setManufacturerName(record.split(",")[3]);
                TempOrder.setManufacturerAddress(record.split(",")[4], Integer.valueOf(record.split(",")[5]), record.split(",")[6], record.split(",")[7], record.split(",")[8], record.split(",")[9]);
                TempOrder.setDeliveryCompany(record.split(",")[10]);
                TempOrder.setOrderedStock(Integer.valueOf(record.split(",")[11]));
                TempOrder.setTotalOrderPrice(Double.valueOf(record.split(",")[12]));
                TempOrder.setOrderDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[13]));
                TempOrder.setDeliveryDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[14]));
                OrderedProducts.add(TempOrder);
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        } catch (ParseException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ClearOrderFile() {
        try {
            PrintWriter writer = new PrintWriter(OrderFilename);
            writer.print("");
            writer.close();
        } catch (Exception ioe) {
        }
    }

    public void PrintPurchaseHistory(Date datePurchaseDate) {
        FileWriter writer;
        try {
            writer = new FileWriter(PurchaseHistoryFilename, true);
            for (int i = 0; i < BasketProducts.size(); i++) {
                writer.write("Product ID: " + BasketProducts.get(i).getID() + System.getProperty("line.separator"));
                writer.write("Product Name: " + BasketProducts.get(i).getName() + System.getProperty("line.separator"));
                writer.write("Quantity: " + BasketProducts.get(i).getAmount() + System.getProperty("line.separator"));
                writer.write("Product Price (£): " + BasketProducts.get(i).getVATPrice() + System.getProperty("line.separator"));
                writer.write("Total Price (£): " + (BasketProducts.get(i).getAmount() * BasketProducts.get(i).getVATPrice()) + System.getProperty("line.separator"));
                writer.write("##" + System.getProperty("line.separator"));
            }
            writer.write("Purchase Date: " + new SimpleDateFormat("dd-MM-yyyy").format(datePurchaseDate) + System.getProperty("line.separator"));
            writer.write("Total Quantity: " + getTotalQuantity() + System.getProperty("line.separator"));
            writer.write("Unique Product Count: " + getUniqueProductCount() + System.getProperty("line.separator"));
            writer.write("Sum Total (£): " + getTotalPrice() + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator"));
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }

    public void PrintWishlistFile(String strUsername) {
        String Filename = strUsername + WishlistFilename;
        FileWriter writer;
        try {
            writer = new FileWriter(Filename, false);
            for (int i = 0; i < WishlistProducts.size(); i++) {
                writer.write(WishlistProducts.get(i).ArrayListToString());
            }
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }

    public void ReadWishlistFile(String strUsername) {
        String record;
        FileReader reader;
        try {
            reader = new FileReader(strUsername + WishlistFilename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                Basket TempBasketProduct = new Basket();
                TempBasketProduct.setID(record.split(",")[0]);
                TempBasketProduct.setName(record.split(",")[1]);
                TempBasketProduct.setAmount(Integer.valueOf(record.split(",")[2]));
                TempBasketProduct.setPrice(Double.valueOf(record.split(",")[3]) / 1.2);
                TempBasketProduct.setStock(Integer.valueOf(record.split(",")[4]));
                WishlistProducts.add(TempBasketProduct);
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }

    public void PrintProductFile(String strArrayList) {
        FileWriter writer;
        switch (strArrayList) {
            case "Product":
                try {
                    writer = new FileWriter(Filename, false);
                    for (int i = 0; i < Products.size(); i++) {
                        writer.write(Products.get(i).ArrayListToString());
                    }
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
            case "Food":
                try {
                    writer = new FileWriter(FoodFilename, false);
                    for (int i = 0; i < FoodProducts.size(); i++) {
                        writer.write(FoodProducts.get(i).ArrayListToString());
                    }
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
            case "Electronic":
                try {
                    writer = new FileWriter(ElectronicFilename, false);
                    for (int i = 0; i < ElectronicProducts.size(); i++) {
                        writer.write(ElectronicProducts.get(i).ArrayListToString());
                    }
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
            case "Basket":
                try {
                    writer = new FileWriter(BasketFilename, false);
                    for (int i = 0; i < BasketProducts.size(); i++) {
                        writer.write(BasketProducts.get(i).ArrayListToString());
                    }
                    writer.flush();
                    writer.close();
                    writer = null;
                } catch (Exception ioe) {
                }
                break;
        }
    }

    public void ReadProductFile(String strArrayList) {
        String record;
        FileReader reader;
        switch (strArrayList) {
            case "Product":
                try {
                    reader = new FileReader(Filename);
                    BufferedReader bin = new BufferedReader(reader);
                    record = new String();
                    while ((record = bin.readLine()) != null) {
                        Product TempProduct = new Product();
                        TempProduct.setID(record.split(",")[0]);
                        TempProduct.setName(record.split(",")[1]);
                        TempProduct.setCategory(record.split(",")[2]);
                        TempProduct.setManufacturerName(record.split(",")[3]);
                        TempProduct.setWeight(Double.valueOf(record.split(",")[4]));
                        TempProduct.setPrice(Double.valueOf(record.split(",")[5]));
                        TempProduct.setExpiryDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[6]));
                        TempProduct.setDateToOrder(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[7]));
                        TempProduct.setMinimumStock(Integer.valueOf(record.split(",")[8]));
                        TempProduct.setMaximumStock(Integer.valueOf(record.split(",")[9]));
                        TempProduct.setStock(Integer.valueOf(record.split(",")[10]));
                        TempProduct.setImageIdentifier(record.split(",")[11]);
                        TempProduct.setMostRecentOrderDate(record.split(",")[12]);
                        Products.add(TempProduct);
                    }
                    bin.close();
                    bin = null;

                } catch (IOException ioe) {
                } catch (ParseException ex) {
                    Logger.getLogger(ProductList.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Food":
                try {
                    reader = new FileReader(FoodFilename);
                    BufferedReader bin = new BufferedReader(reader);
                    record = new String();
                    while ((record = bin.readLine()) != null) {
                        FoodProduct TempFoodProduct = new FoodProduct();
                        TempFoodProduct.setID(record.split(",")[0]);
                        TempFoodProduct.setName(record.split(",")[1]);
                        TempFoodProduct.setCategory(record.split(",")[2]);
                        TempFoodProduct.setManufacturerName(record.split(",")[3]);
                        TempFoodProduct.setWeightCategory(record.split(",")[4]);
                        TempFoodProduct.setWeight(Double.valueOf(record.split(",")[5]));
                        TempFoodProduct.setPrice(Double.valueOf(record.split(",")[6]));
                        TempFoodProduct.setExpiryDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[7]));
                        TempFoodProduct.setDateToOrder(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[8]));
                        TempFoodProduct.setUseByDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[9]));
                        TempFoodProduct.setSoldByDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[10]));
                        TempFoodProduct.setMinimumStock(Integer.valueOf(record.split(",")[11]));
                        TempFoodProduct.setMaximumStock(Integer.valueOf(record.split(",")[12]));
                        TempFoodProduct.setStock(Integer.valueOf(record.split(",")[13]));
                        TempFoodProduct.setImageIdentifier(record.split(",")[14]);
                        TempFoodProduct.setMostRecentOrderDate(record.split(",")[15]);
                        FoodProducts.add(TempFoodProduct);
                    }
                    bin.close();
                    bin = null;

                } catch (IOException ioe) {
                } catch (ParseException ex) {
                    Logger.getLogger(ProductList.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Electronic":
                try {
                    reader = new FileReader(ElectronicFilename);
                    BufferedReader bin = new BufferedReader(reader);
                    record = new String();
                    while ((record = bin.readLine()) != null) {
                        ElectronicProduct TempElectronicProduct = new ElectronicProduct();
                        TempElectronicProduct.setID(record.split(",")[0]);
                        TempElectronicProduct.setName(record.split(",")[1]);
                        TempElectronicProduct.setCategory(record.split(",")[2]);
                        TempElectronicProduct.setManufacturerName(record.split(",")[3]);
                        TempElectronicProduct.setWeight(Double.valueOf(record.split(",")[4]));
                        TempElectronicProduct.setPrice(Double.valueOf(record.split(",")[5]));
                        TempElectronicProduct.setGuaranteeDuration(Integer.valueOf(record.split(",")[6]));
                        TempElectronicProduct.setExpiryDate(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[7]));
                        TempElectronicProduct.setDateToOrder(new SimpleDateFormat("dd-MM-yyyy").parse(record.split(",")[8]));
                        TempElectronicProduct.setMinimumStock(Integer.valueOf(record.split(",")[9]));
                        TempElectronicProduct.setMaximumStock(Integer.valueOf(record.split(",")[10]));
                        TempElectronicProduct.setStock(Integer.valueOf(record.split(",")[11]));
                        TempElectronicProduct.setImageIdentifier(record.split(",")[12]);
                        TempElectronicProduct.setMostRecentOrderDate(record.split(",")[13]);
                        ElectronicProducts.add(TempElectronicProduct);
                    }
                    bin.close();
                    bin = null;

                } catch (IOException ioe) {
                } catch (ParseException ex) {
                    Logger.getLogger(ProductList.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Basket":
                try {
                    reader = new FileReader(BasketFilename);
                    BufferedReader bin = new BufferedReader(reader);
                    record = new String();
                    while ((record = bin.readLine()) != null) {
                        Basket TempBasketProduct = new Basket();
                        TempBasketProduct.setID(record.split(",")[0]);
                        TempBasketProduct.setName(record.split(",")[1]);
                        TempBasketProduct.setAmount(Integer.valueOf(record.split(",")[2]));
                        TempBasketProduct.setPrice(Double.valueOf(record.split(",")[3]) / 1.2);
                        TempBasketProduct.setStock(Integer.valueOf(record.split(",")[4]));
                        BasketProducts.add(TempBasketProduct);
                    }
                    bin.close();
                    bin = null;
                } catch (IOException ioe) {
                }
                break;
        }
    }

    public void ClearProductFile(String strArrayList) {
        switch (strArrayList) {
            case "Product":
                try {
                    PrintWriter writer = new PrintWriter(Filename);
                    writer.print("");
                    writer.close();
                } catch (Exception ioe) {
                }
                break;
            case "Food":
                try {
                    PrintWriter writer = new PrintWriter(FoodFilename);
                    writer.print("");
                    writer.close();
                } catch (Exception ioe) {
                }
                break;
            case "Electronic":
                try {
                    PrintWriter writer = new PrintWriter(ElectronicFilename);
                    writer.print("");
                    writer.close();
                } catch (Exception ioe) {
                }
                break;
            case "Basket":
                try {
                    PrintWriter writer = new PrintWriter(BasketFilename);
                    writer.print("");
                    writer.close();
                } catch (Exception ioe) {
                }
                break;
        }
    }

    public void Display(JTextArea jProductListTextArea, String strArrayList) {
        switch (strArrayList) {
            case "Product":
                for (int i = 0; i < Products.size(); i++) {
                    Products.get(i).Display(jProductListTextArea);
                }
                break;
            case "Ordered":
                for (int i = 0; i < OrderedProducts.size(); i++) {
                    OrderedProducts.get(i).DisplayOrderedProducts(jProductListTextArea);
                }
                break;
            case "Food":
                for (int i = 0; i < FoodProducts.size(); i++) {
                    FoodProducts.get(i).Display(jProductListTextArea);
                }
                break;
            case "Electronic":
                for (int i = 0; i < ElectronicProducts.size(); i++) {
                    ElectronicProducts.get(i).Display(jProductListTextArea);
                }
                break;
            case "Basket":
                for (int i = 0; i < BasketProducts.size(); i++) {
                    BasketProducts.get(i).Display(jProductListTextArea);
                }
                break;
            case "Wishlist":
                for (int i = 0; i < WishlistProducts.size(); i++) {
                    WishlistProducts.get(i).Display(jProductListTextArea);
                }
                break;
        }
    }

    public Product getProductInfoByID(String strEditProductID) {
        Product productInfo = new Product();
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).getID().equals(strEditProductID)) {
                int ProductIdentifier = i;
                productInfo = Products.get(ProductIdentifier);
            }
        }
        return productInfo;
    }

    public FoodProduct getFoodProductInfoByID(String strEditProductID) {
        FoodProduct foodProductInfo = new FoodProduct();
        for (int i = 0; i < FoodProducts.size(); i++) {
            if (FoodProducts.get(i).getID().equals(strEditProductID)) {
                int ProductIdentifier = i;
                foodProductInfo = FoodProducts.get(ProductIdentifier);
            }
        }
        return foodProductInfo;
    }

    public ElectronicProduct getElectronicProductInfoByID(String strEditProductID) {
        ElectronicProduct electronicProductInfo = new ElectronicProduct();
        for (int i = 0; i < ElectronicProducts.size(); i++) {
            if (ElectronicProducts.get(i).getID().equals(strEditProductID)) {
                int ProductIdentifier = i;
                electronicProductInfo = ElectronicProducts.get(ProductIdentifier);
            }
        }
        return electronicProductInfo;
    }

    public Basket getBasketProductInfoByID(String strEditProductID, String strArrayList) {
        Basket basketProductInfo = new Basket();
        switch (strArrayList) {
            case "Basket":
                for (int i = 0; i < BasketProducts.size(); i++) {
                    if (BasketProducts.get(i).getID().equals(strEditProductID)) {
                        int ProductIdentifier = i;
                        basketProductInfo = BasketProducts.get(ProductIdentifier);
                    }
                }
                break;
            case "Wishlist":
                for (int i = 0; i < WishlistProducts.size(); i++) {
                    if (WishlistProducts.get(i).getID().equals(strEditProductID)) {
                        int ProductIdentifier = i;
                        basketProductInfo = WishlistProducts.get(ProductIdentifier);
                    }
                }
                break;
        }
        return basketProductInfo;
    }

    public boolean checkForProduct(String strEditProductID, String strArrayList) {
        boolean idCheck = false;
        switch (strArrayList) {
            case "Product":
                for (int i = 0; i < Products.size(); i++) {
                    if (Products.get(i).getID().equals(strEditProductID)) {
                        idCheck = true;
                    }
                }
                break;
            case "Food":
                for (int i = 0; i < FoodProducts.size(); i++) {
                    if (FoodProducts.get(i).getID().equals(strEditProductID)) {
                        idCheck = true;
                    }
                }
            case "Electronic":
                for (int i = 0; i < ElectronicProducts.size(); i++) {
                    if (ElectronicProducts.get(i).getID().equals(strEditProductID)) {
                        idCheck = true;
                    }
                }
                break;
            case "Basket":
                for (int i = 0; i < BasketProducts.size(); i++) {
                    if (BasketProducts.get(i).getID().equals(strEditProductID)) {
                        idCheck = true;
                    }
                }
                break;
            case "Wishlist":
                for (int i = 0; i < WishlistProducts.size(); i++) {
                    if (WishlistProducts.get(i).getID().equals(strEditProductID)) {
                        idCheck = true;
                    }
                }
                break;
        }
        return idCheck;
    }

    public double getTotalPrice() {
        double Total = 0;
        for (int i = 0; i < BasketProducts.size(); i++) {
            Total = Total + (BasketProducts.get(i).getVATPrice() * BasketProducts.get(i).getAmount());
        }
        return Total;
    }

    public int getUniqueProductCount() {
        int intCount = 0;
        for (int i = 0; i < BasketProducts.size(); i++) {
            intCount++;
        }
        return intCount;
    }

    public int getTotalQuantity() {
        int Total = 0;
        for (int i = 0; i < BasketProducts.size(); i++) {
            Total = Total + (BasketProducts.get(i).getAmount());
        }
        return Total;
    }

    public void decrementStock() {
        for (int i = 0; i < BasketProducts.size(); i++) {
            String strProductID = BasketProducts.get(i).getID();
            int intAmount = BasketProducts.get(i).getAmount();
            getProductInfoByID(strProductID).decrementStock(intAmount);
            getFoodProductInfoByID(strProductID).decrementStock(intAmount);
            getElectronicProductInfoByID(strProductID).decrementStock(intAmount);
        }
    }
}
