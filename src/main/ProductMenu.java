package main;

public class ProductMenu {
    //- 상품 클래스는 이름, 가격, 설명 필드를 가지는 클래스로 만들어주세요.
    public String name;
    public double price;
    public String description;
    //- 상품 클래스의 이름, 가격 필드는 메뉴 클래스를 상속받아 사용하는 구조로 개발해주세요.

    public ProductMenu(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductMenu(){};
}
