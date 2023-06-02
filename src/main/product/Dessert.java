package main.product;

import java.util.ArrayList;

public class Dessert implements InterfaceProduct {
    public ArrayList<ProductMenu> dessertArr;

    public void detailMenu(){
        dessertArr = new ArrayList<>();
        dessertArr.add(new ProductMenu("포테이토", 1.8, "바로 튀겨낸 바삭바삭한 후렌치 포테이토"));
        dessertArr.add(new ProductMenu("양념감자", 2.3, "시즈닝(오니언, 치즈, 칠리)을 한가지를 선택해 뿌려먹는 포테이토"));
        dessertArr.add(new ProductMenu("치즈스틱", 2.4, "통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 롯데리아 대표 디저트 메뉴"));
        dessertArr.add(new ProductMenu("치킨너겟", 2.7, "닭안심살과 닭가슴살로 만든 담백하고 촉촉한 치킨너겟 - 5조각"));

        System.out.println("[ Dessert MENU ]");
        ProductService.detailMenuPrint(dessertArr);
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        return ProductService.choiceProductPrint(dessertArr, choiceDetailMenu);
    }

    public void choiceOption(int choiceDetailMenu){

    }

}
