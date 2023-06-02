package main.product;

import java.util.*;

public class Drinks implements InterfaceProduct {
    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> drinksArr;
    public Map<Integer, ProductOption> drinksMap;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        drinksArr = new ArrayList<>();
        drinksMap = new HashMap<>();
        drinksArr.add(new ProductMenu("콜라", 2.0, "톡 쏘는 시원 상쾌한 펩시콜라"));
        drinksArr.add(new ProductMenu("사이다", 2.0, "톡 쏘는 시원 청량한 칠성사이다"));
        drinksArr.add(new ProductMenu("제로슈거콜라", 2.0, "칼로리 걱정 없는 시원 상쾌한 제로 슈거 콜라"));
        drinksArr.add(new ProductMenu("복숭아 홍차 에이드(R)", 2.7, "코코넛 젤리의 재미있는 식감과 은은한 복숭아 홍차 맛이 조화로운 탄산 에이드"));

        drinksMap.put(0, new ProductOption("얼음(Won 2.0)", "얼음 빼고(Won 2.0)"));
        drinksMap.put(1, new ProductOption("얼음(Won 2.0)", "얼음 빼고(Won 2.0)"));
        drinksMap.put(2, new ProductOption("얼음(Won 2.0)", "얼음 빼고(Won 2.0)"));
        drinksMap.put(3, new ProductOption("Ice(Won 2.7)", "Hot(Won 2.7)"));

        System.out.println();

        System.out.println("[ Drinks MENU ]");
        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        ProductService.detailMenuPrint(drinksArr);
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){

       return ProductService.choiceProductPrint(drinksArr,choiceDetailMenu);
    }

    // 옵션 선택
    public void choiceOption(int choiceDetailMenu) {
        Scanner in = new Scanner(System.in);

        int key = choiceDetailMenu - 1;

        ProductService.choiceOptionPrint(drinksArr,drinksMap,key);

        int choiceOption = in.nextInt();

        setProductOption(choiceOption, choiceDetailMenu);
    }

    public void setProductOption(int choiceOption, int choiceDetailMenu){

        int key = choiceDetailMenu - 1;

        if(choiceDetailMenu == 1 && choiceOption == 2){
            drinksArr.set(key, new ProductMenu("콜라(얼음 빼고)", 2.0, "톡 쏘는 시원 상쾌한 펩시콜라"));
        }else if(choiceDetailMenu == 2 && choiceOption == 2){
            drinksArr.set(key, new ProductMenu("사이다(얼음 빼고)", 2.0, "톡 쏘는 시원 청량한 칠성사이다"));
        }else if(choiceDetailMenu == 3 && choiceOption == 2){
            drinksArr.set(key, new ProductMenu("제로슈거콜라(얼음 빼고)", 2.0, "칼로리 걱정 없는 시원 상쾌한 제로 슈거 콜라"));
        }else if(choiceDetailMenu == 4 && choiceOption == 2){
            drinksArr.set(key, new ProductMenu("복숭아 홍차 에이드(R)(Hot)", 2.7, "코코넛 젤리의 재미있는 식감과 은은한 복숭아 홍차 맛이 조화로운 탄산 에이드"));
        }else{
            System.out.println();
        }
    }
}
