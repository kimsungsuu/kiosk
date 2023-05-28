package test;


import main.Buger;
import main.Chicken;
import main.OrderList;
import main.ProductMenu;

import java.util.Scanner;

public class ChickenTest {

    public static void main(String[] args) {
        Chicken chicken = new Chicken();
        OrderList orderList = new OrderList();
        Scanner in = new Scanner(System.in);
        chicken.detailMenu();

        int detailChoice = in.nextInt();

        ProductMenu productMenu = chicken.choiceProduct(detailChoice);

        int addProduct = in.nextInt();
        int addProductCnt = 0;

        if(addProduct == 1){
            addProductCnt++;
            orderList.addProduct(productMenu, addProductCnt);
        }

        orderList.orderProductList();
    }
}
