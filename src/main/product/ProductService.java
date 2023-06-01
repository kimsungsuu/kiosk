package main.product;

import java.util.ArrayList;

/**
 * Product 객체 내부 공통 로직
 */
public class ProductService {

    public ProductService(){

    }

    // 상품 메뉴 보여주기
    public static void detailMenuPrint(ArrayList<ProductMenu> object){

        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < object.size(); i++){
            System.out.println((i+1) + " " + String.format("%-15s", object.get(i).name)+ " | Won "
                    + object.get(i).price + " | " + object.get(i).description);
        }
    }

    // 상품 메뉴를 선택했을 시
    public static ProductMenu choiceProductPrint(ArrayList<ProductMenu> object, int choiceDetailMenu){

        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + object.get(choiceDetailMenu-1).name + " | Won " + object.get(choiceDetailMenu-1).price + " | "
                + object.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        // 상품 메뉴를 주문 리스트에 담기 위해 해당 상품을 반환하고, 반환된 값을 장바구니 객체에 담는다.
        return object.get(choiceDetailMenu-1);
    }
}
