package test;

import main.product.Drinks;
import main.OrderList;
import main.product.ProductMenu;

import java.util.Scanner;

public class DrinksTest {
    public static void main(String[] args) {
        Drinks drinks = new Drinks();
        OrderList orderList = new OrderList();
        Scanner in = new Scanner(System.in);
        drinks.detailMenu();

        int detailChoice = in.nextInt();

        ProductMenu productMenu = drinks.choiceProduct(detailChoice);

        int addProduct = in.nextInt();
        int addProductCnt = 0;

        if(addProduct == 1){
            addProductCnt++;
            orderList.addProduct(productMenu, addProductCnt);
        }

        orderList.orderProductList();
    }
}
