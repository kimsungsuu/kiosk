package main.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chicken implements InterfaceProduct {
    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> chickenArr;
    public Map<Integer, ProductOption> chickenMap;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        chickenArr = new ArrayList<>();
        chickenMap = new HashMap<>();

        chickenArr.add(new ProductMenu("화이어윙", 3.1, "담백한 맛과 매콤한 맛이 잘 조화된 특별한 타입의 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다."));
        chickenArr.add(new ProductMenu("치킨휠레", 3.1, "담백한 안심살의 Chicken fillet와 롯데리아만의 독특한 소스가 어우러진 디저트 메뉴"));
        chickenArr.add(new ProductMenu("치킨", 2.8, "담백함과 매콤한맛의 후라이드 치킨(부위랜덤)"));
        chickenArr.add(new ProductMenu("패밀리팩", 14.8, "신선한 치킨을 사용하여 부드럽고, 담백함과 매콤한 맛이 잘 어우러진 후라이드 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다."));

        chickenMap.put(0, new ProductOption("화이어윙(2 조각)(Won 3.1)", "화이어윙(4 조각)(Won 6.2)"));
        chickenMap.put(1, new ProductOption("치킨휠레(2 조각)(Won 3.1)", "치킨휠레(4 조각)(Won 6.2)"));
        chickenMap.put(2, new ProductOption("치킨(두 조각)(Won 2.8)", "치킨(4 조각)(Won 5.6)"));
        chickenMap.put(3, new ProductOption("패밀리팩(Won 14.8)", "패밀리팩(다리, 날개)(Won 20.0)"));

        System.out.println("[ Chickens MENU ]");
        ProductService.detailMenuPrint(chickenArr);
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){
        return ProductService.choiceProductPrint(chickenArr, choiceDetailMenu);
    }

    public void choiceOption(int choiceDetailMenu){
        Scanner in = new Scanner(System.in);

        int key = choiceDetailMenu - 1;

        ProductService.choiceOptionPrint(chickenArr,chickenMap,key);

        int choiceOption = in.nextInt();

        setProductPrice(choiceOption, choiceDetailMenu);
    }

    public void setProductPrice(int choiceOption, int choiceDetailMenu){

        int key = choiceDetailMenu - 1;

        if(choiceDetailMenu == 1){
            if(choiceOption == 1){
                chickenArr.set(key, new ProductMenu("화이어윙(2 조각)", 3.1, "담백한 맛과 매콤한 맛이 잘 조화된 특별한 타입의 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다."));
            }else{
                chickenArr.set(key, new ProductMenu("화이어윙(4 조각)", 6.2, "담백한 맛과 매콤한 맛이 잘 조화된 특별한 타입의 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다."));
            }
        }else if(choiceDetailMenu == 2){
            if(choiceOption == 1) {
                chickenArr.set(key, new ProductMenu("치킨휠레(2 조각)", 3.1, "담백한 안심살의 Chicken fillet와 롯데리아만의 독특한 소스가 어우러진 디저트 메뉴"));
            }else{
                chickenArr.set(key, new ProductMenu("치킨휠레(4 조각)", 6.2, "담백한 안심살의 Chicken fillet와 롯데리아만의 독특한 소스가 어우러진 디저트 메뉴"));
            }
        }else if(choiceDetailMenu == 3){
            if(choiceOption == 1) {
                chickenArr.set(key, new ProductMenu("치킨(2 조각)", 2.8, "담백함과 매콤한맛의 후라이드 치킨(부위랜덤)"));
            }else{
                chickenArr.set(key, new ProductMenu("치킨(4 조각)", 5.6, "담백함과 매콤한맛의 후라이드 치킨(부위랜덤)"));
            }
        }else{
            if(choiceOption == 1) {
                chickenArr.set(key, new ProductMenu("패밀리팩", 14.8, "담백함과 매콤한맛의 후라이드 치킨(부위랜덤)"));
            }else{
                chickenArr.set(key, new ProductMenu("패밀리팩(다리, 날개)", 20.0, "담백함과 매콤한맛의 후라이드 치킨(다리와, 날개 부위만 포함)"));
            }
        }
    }
}
