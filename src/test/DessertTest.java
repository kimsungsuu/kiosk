package test;

import main.product.Dessert;
import main.OrderList;
import main.product.ProductMenu;

import java.util.Scanner;

public class DessertTest {
    public static void main(String[] args) {
        Dessert dessert = new Dessert();
        OrderList orderList = new OrderList();
        Scanner in = new Scanner(System.in);
        dessert.detailMenu();

        int detailChoice = in.nextInt();

        ProductMenu productMenu = dessert.choiceProduct(detailChoice);

        int addProduct = in.nextInt();
        int addProductCnt = 0;

        if(addProduct == 1){
            addProductCnt++;
            orderList.addProduct(productMenu, addProductCnt);
        }

        orderList.orderProductList();
    }
}
