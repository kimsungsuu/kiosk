package main;

import java.util.ArrayList;

public class Bear implements InterfaceProduct{
    public ArrayList<ProductMenu> bearArr;

    // 상품 메뉴 보여주기
    @Override
    public void detailMenu(){
        bearArr = new ArrayList<>();
        bearArr.add(new ProductMenu("생맥주", 4.0, "거품이 일품인 생맥주!"));
        bearArr.add(new ProductMenu("병맥주", 4.0, "마시면 머리까지 시원해지는 병맥주!"));

        System.out.println("[ Bears MENU ]");
        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < bearArr.size(); i++){
            System.out.println((i+1) + " " + bearArr.get(i).name + " | Won "
                    + bearArr.get(i).price + " | " + bearArr.get(i).description);
        }
    }

    // 상품 메뉴를 선택했을 시
    @Override
    public ProductMenu choiceProduct(int choiceDetailMenu){

        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + bearArr.get(choiceDetailMenu-1).name + " | Won " + bearArr.get(choiceDetailMenu-1).price + " | "
                + bearArr.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        // 상품 메뉴를 주문 리스트에 담기 위해 해당 상품을 반환하고, 반환된 값을 장바구니 객체에 담는다.
        return bearArr.get(choiceDetailMenu-1);
    }
}
