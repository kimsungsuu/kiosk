package main;

// 상품 클래스는 메뉴 클래스를 상속 받는다.
public class ProductMenu extends MainMenu{
    public double price;

    public ProductMenu(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductMenu(){};
}
