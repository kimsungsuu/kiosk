package test;

import main.product.Buger;
import main.OrderList;
import main.product.ProductMenu;

import java.util.Scanner;
//test
public class BugerTest {
    public static void main(String[] args) {
        Buger buger = new Buger();
        OrderList orderList = new OrderList();
        Scanner in = new Scanner(System.in);
        buger.detailMenu();

        int detailChoice = in.nextInt();

        ProductMenu productMenu = buger.choiceProduct(detailChoice);

        int addProduct = in.nextInt();
        int addProductCnt = 0;

        if(addProduct == 1){
            addProductCnt++;
            orderList.addProduct(productMenu, addProductCnt);
        }

        orderList.orderProductList();
    }
}
