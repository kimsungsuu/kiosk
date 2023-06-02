package main.product;

import main.product.InterfaceProduct;
import main.product.ProductMenu;

/**
 * 상세 메뉴들을 추상화하여 작업하기 위한 클래스
 */
public class Product {
    private InterfaceProduct orderProduct;

    public Product(InterfaceProduct orderProduct){
        this.orderProduct = orderProduct;
    }

    public void detailMenu(){
        orderProduct.detailMenu();
    }

    public ProductMenu choiceProduct(int choiceDetailMenu){
        ProductMenu result;
        result = orderProduct.choiceProduct(choiceDetailMenu);
        return result;
    }

    public void choiceOption(int choiceDetailMenu){
        orderProduct.choiceOption(choiceDetailMenu);
    }
}
