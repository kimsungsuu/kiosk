package main;

import main.product.ProductMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 주문한 상품 객체를 담는 클래스
 * 요구사항 : 주문 클래스도 만들어서 상품 객체를 담을 수 있도록 해주세요.
 */
public class OrderList {
    public ArrayList<ProductMenu> orderLists = new ArrayList<>();
    // 제품 주문 수량
    public Map<String, Integer> productCnt = new HashMap<>();

    // 장바구니에 상품 담기
    public void addProduct(ProductMenu productMenu, int addProductCnt){
        orderLists.add(productMenu);

        productCnt.put(productMenu.name, productCnt.getOrDefault(productMenu.name, 0)+1);

        System.out.println(orderLists.get(addProductCnt-1).name + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }

    // 장바구니에 담긴 값 출력
    public void orderProductList() {
        double total = 0;

        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

        // 장바구니 리스트 출력
        if(!orderLists.isEmpty()) {
            System.out.println(String.format("%-15s",orderLists.get(0).name) + " | Won " + orderLists.get(0).price + " | " + productCnt.get(orderLists.get(0).name) + "개 | " + orderLists.get(0).description);
            total = orderLists.get(0).price;

            for (int i = 1; i < orderLists.size(); i++) {
                boolean flag = true;
                total += orderLists.get(i).price;
                for (int j = i - 1; j >= 0; j--) {
                    if (orderLists.get(i).name == orderLists.get(j).name) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(String.format("%-15s",orderLists.get(i).name) + " | Won " + orderLists.get(i).price + " | " + productCnt.get(orderLists.get(i).name) + "개 | " + orderLists.get(i).description);
                }
            }
        }
        System.out.println();

        String resultTotal = String.format("%.1f", total);

        System.out.println("[ Total ]");
        System.out.println("Won " + resultTotal);
        System.out.println();
    }

    // 장바구니, 주문 갯수 clear()
    public void clearOrder(){
        orderLists.clear();
        productCnt.clear();
    }
}
