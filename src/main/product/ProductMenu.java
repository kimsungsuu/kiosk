package main.product;

// 상품 클래스는 메뉴 클래스를 상속 받는다.
public class ProductMenu{
    public double price;
    public String name;
    public String description;

    public ProductMenu(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductMenu(double price, String description){
        this.price = price;
        this.description = description;
    }

    public ProductMenu(){};
}
