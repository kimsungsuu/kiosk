package main;

import java.util.ArrayList;

/**
 * 주문한 상품 객체를 담는 클래스
 * 요구사항 : 주문 클래스도 만들어서 상품 객체를 담을 수 있도록 해주세요.
 */
public class OrderList {

    public ArrayList<ProductMenu> orderLists = new ArrayList<>();

    // 주문 확인 버튼 클릭 시 장바구니에 값을 담는다.
    public void addProduct(ProductMenu productMenu, int addProductCnt){

        orderLists.add(productMenu);

        System.out.println(orderLists.get(addProductCnt-1).name + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }

    // 장바구니에 담긴 값 출력
    public void orderProductList() {
        double total = 0;

        System.out.println("아래와 같이 주문하시겠습니까?");

        System.out.println();

        System.out.println("[ Orders ]");

        for (ProductMenu productMenu : orderLists){
            System.out.println(productMenu.name + " | Won " + productMenu.price + " |" + productMenu.description);
            total += productMenu.price;
        }

        System.out.println();

        String resultTotal = String.format("%.1f", total);

        System.out.println("[ Total ]");
        System.out.println("Won " + resultTotal);
        System.out.println();
    }

    // 주문 완료 시 장바구니에 담겨있던 객체 clear()
    public void clearOrder(){
        orderLists.clear();
    }
}
