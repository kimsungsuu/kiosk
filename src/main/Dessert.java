package main;

import java.util.ArrayList;

public class Dessert extends AbstractProduct{
    public ArrayList<ProductMenu> dessertArr;

    public void detailMenu(){
        dessertArr = new ArrayList<>();
        dessertArr.add(new ProductMenu("포테이토", 1.8, "바로 튀겨낸 바삭바삭한 후렌치 포테이토"));
        dessertArr.add(new ProductMenu("양념감자", 2.3, "시즈닝(오니언, 치즈, 칠리)을 한가지를 선택해 뿌려먹는 포테이토"));
        dessertArr.add(new ProductMenu("치즈스틱", 2.4, "통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 롯데리아 대표 디저트 메뉴"));
        dessertArr.add(new ProductMenu("치킨너겟", 2.7, "닭안심살과 닭가슴살로 만든 담백하고 촉촉한 치킨너겟 - 5조각"));



        System.out.println("[ Dessert MENU ]");
        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < dessertArr.size(); i++){
            System.out.println((i+1) + " " + dessertArr.get(i).name + " | Won "
                    + dessertArr.get(i).price + " | " + dessertArr.get(i).description);
        }
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + dessertArr.get(choiceDetailMenu-1).name + " | Won " + dessertArr.get(choiceDetailMenu-1).price + " | "
                + dessertArr.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        // 상품 메뉴를 주문 리스트에 담기 위해 해당 상품을 반환하고, 반환된 값을 장바구니 객체에 담는다.
        return dessertArr.get(choiceDetailMenu-1);
    }

}
