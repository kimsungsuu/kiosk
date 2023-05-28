package main;

import java.util.ArrayList;

public class Chicken {
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
        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < chickenArr.size(); i++){
            System.out.println((i+1) + " " + chickenArr.get(i).name + " | Won "
                    + chickenArr.get(i).price + " | " + chickenArr.get(i).description);
        }
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + chickenArr.get(choiceDetailMenu-1).name + " | Won " + chickenArr.get(choiceDetailMenu-1).price + " | "
                + chickenArr.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        // 상품 메뉴를 주문 리스트에 담기 위해 해당 상품을 반환하고, 반환된 값을 장바구니 객체에 담는다.
        return chickenArr.get(choiceDetailMenu-1);
    }


}
