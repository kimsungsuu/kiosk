package main;

import java.util.ArrayList;

public class Buger{

    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> bugerArr;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        bugerArr = new ArrayList<>();
        bugerArr.add(new ProductMenu("ShackBurger", 6.9, "토마토, 양상추, 토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugerArr.add(new ProductMenu("SmokeBurger", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugerArr.add(new ProductMenu("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));

        System.out.println("[ Bugers MENU ]");
        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < bugerArr.size(); i++){
            System.out.println((i+1) + " " + bugerArr.get(i).name + " | Won "
                    + bugerArr.get(i).price + " | " + bugerArr.get(i).description);
        }


    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + bugerArr.get(choiceDetailMenu-1).name + " | Won" + bugerArr.get(choiceDetailMenu-1).price + " | "
                + bugerArr.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        // 상품 메뉴를 주문 리스트에 담기 위해 해당 상품을 반환하고, 반환된 값을 장바구니 객체에 담는다.
        return bugerArr.get(choiceDetailMenu-1);
    }


}
