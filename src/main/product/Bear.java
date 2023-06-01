package main.product;

import java.util.ArrayList;

public class Bear implements InterfaceProduct {
    public ArrayList<ProductMenu> bearArr;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        bearArr = new ArrayList<>();
        bearArr.add(new ProductMenu("생맥주", 4.0, "거품이 일품인 생맥주!"));
        bearArr.add(new ProductMenu("병맥주", 4.0, "마시면 머리까지 시원해지는 병맥주!"));

        System.out.println("[ Bears MENU ]");
        ProductService.detailMenuPrint(bearArr);
    }



    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){

        // 장바구니에 상품 메뉴를 추가함.
        return ProductService.choiceProductPrint(bearArr, choiceDetailMenu);
    }

}
