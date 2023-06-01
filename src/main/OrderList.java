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

    // 주문 확인 버튼 클릭 시 장바구니에 값을 담는다.
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
        // 장바구니에 같은 상품을 여러개 담았을 때 갯수 증가하고, 중복되는 상품명 출력 x
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

    // 주문 완료 시 장바구니에 담겨있던 객체 clear()
    // 제품 주문 수량도 초기화
    public void clearOrder(){
        orderLists.clear();
        productCnt.clear();
    }
}
