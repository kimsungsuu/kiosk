package main.product;

import java.util.ArrayList;

public class Drinks implements InterfaceProduct {
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
        ProductService.detailMenuPrint(drinksArr);
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        return ProductService.choiceProductPrint(drinksArr, choiceDetailMenu);

    }

}
