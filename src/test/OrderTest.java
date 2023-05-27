package test;

import main.OrderList;
import main.ProductMenu;

/**
 * 장바구니 기능을 테스트합니다.
 */
public class OrderTest {
    public static void main(String[] args) {
        // 임의로 값 넣기
        ProductMenu productMenu = new ProductMenu("버거", 5.5, "양파,불고기,겨자소스가 들어갔습니다");
        OrderList orderList = new OrderList();

        orderList.addProduct(productMenu);

        orderList.orderProductList();
    }

}
