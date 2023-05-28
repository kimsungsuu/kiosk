package test;

import main.OrderList;
import main.ProductMenu;

import java.util.ArrayList;

/**
 * 장바구니 기능을 테스트합니다.
 */
public class OrderTest {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();

        int addProductCnt = 0;
        ProductMenu productMenu = new ProductMenu("버거", 5.5, "양파,불고기,겨자소스가 들어갔습니다");
        addProductCnt++;

        orderList.addProduct(productMenu, addProductCnt);
        ProductMenu productMenu2 = new ProductMenu("버거2", 6.6, "겨자 소스, 간장 소스, 치킨 패티");
        addProductCnt++;

        orderList.addProduct(productMenu2,addProductCnt);
        ProductMenu productMenu3 = new ProductMenu("버거3", 7.6, "소스 소스 소 ㅡ소스 ");
        addProductCnt++;
        orderList.addProduct(productMenu3, addProductCnt);

        orderList.orderProductList();

    }

}
