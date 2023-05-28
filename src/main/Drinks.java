package main;

import java.util.ArrayList;

public class Drinks {
    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> drinksArr;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        drinksArr = new ArrayList<>();
        drinksArr.add(new ProductMenu("콜라", 2.0, "톡 쏘는 시원 상쾌한 펩시콜라"));
        drinksArr.add(new ProductMenu("사이다", 2.0, "톡 쏘는 시원 청량한 칠성사이다"));
        drinksArr.add(new ProductMenu("제로슈거콜라", 2.0, "칼로리 걱정 없는 시원 상쾌한 제로 슈거 콜라"));
        drinksArr.add(new ProductMenu("복숭아 홍차 에이드(R)", 2.7, "코코넛 젤리의 재미있는 식감과 은은한 복숭아 홍차 맛이 조화로운 탄산 에이드"));

        System.out.println("[ Drinks MENU ]");
        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < drinksArr.size(); i++){
            System.out.println((i+1) + " " + drinksArr.get(i).name + " | Won "
                    + drinksArr.get(i).price + " | " + drinksArr.get(i).description);
        }
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + drinksArr.get(choiceDetailMenu-1).name + " | Won " + drinksArr.get(choiceDetailMenu-1).price + " | "
                + drinksArr.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        // 상품 메뉴를 주문 리스트에 담기 위해 해당 상품을 반환하고, 반환된 값을 장바구니 객체에 담는다.
        return drinksArr.get(choiceDetailMenu-1);
    }

}
