package ucodeacademy.com.pojo;

import java.util.List;

public class Products {

    //instance variable that matches with json values, including name, and data type
    private String name;
    private double price;
    private List<Products> allProducts;

    //No arg Constuctor
    public Products(){

    }


    //with arg Constructor


    public List<Products> getAllProducts() {
        return allProducts;
    }


    public void setAllProducts(List<Products> allProducts) {
        this.allProducts = allProducts;
    }


    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
}
