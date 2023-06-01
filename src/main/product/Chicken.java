package main.product;

import java.util.ArrayList;

public class Chicken implements InterfaceProduct {
    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> chickenArr;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        chickenArr = new ArrayList<>();
        chickenArr.add(new ProductMenu("화이어윙", 3.1, "담백한 맛과 매콤한 맛이 잘 조화된 특별한 타입의 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다."));
        chickenArr.add(new ProductMenu("치킨휠레", 3.1, "담백한 안심살의 Chicken fillet와 롯데리아만의 독특한 소스가 어우러진 디저트 메뉴"));
        chickenArr.add(new ProductMenu("치킨 1조각", 2.8, "담백함과 매콤한맛의 후라이드 치킨(부위랜덤)"));
        chickenArr.add(new ProductMenu("패밀리팩", 14.8, "신선한 치킨을 사용하여 부드럽고, 담백함과 매콤한 맛이 잘 어우러진 후라이드 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다."));

        System.out.println("[ Chickens MENU ]");
        ProductService.detailMenuPrint(chickenArr);
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        return ProductService.choiceProductPrint(chickenArr, choiceDetailMenu);
    }
}
