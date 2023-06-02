package main.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bear implements InterfaceProduct {
    public ArrayList<ProductMenu> bearArr;
    public Map<Integer, ProductOption> bearMap;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        bearArr = new ArrayList<>();
        bearMap = new HashMap<>();
        bearArr.add(new ProductMenu("생맥주", 4.0, "거품이 일품인 생맥주!"));
        bearArr.add(new ProductMenu("병맥주", 4.0, "마시면 머리까지 시원해지는 병맥주!"));

        bearMap.put(0, new ProductOption("기본(Won 4.0)", "거품 가득 생맥주(Won 4.0)"));
        bearMap.put(1, new ProductOption("카스(Won 4.0)", "테라(Won 4.0)", "KGB(Won 6.0)", "하이네켄(Won 4.5)"));

        System.out.println("[ Bears MENU ]");
        ProductService.detailMenuPrint(bearArr);
    }

    // 상품 메뉴를 선택했을 시
    public ProductMenu choiceProduct(int choiceDetailMenu){

        // 장바구니에 상품 메뉴를 추가함.
        return ProductService.choiceProductPrint(bearArr, choiceDetailMenu);
    }

    public void choiceOption(int choiceDetailMenu){
        Scanner in = new Scanner(System.in);

        int key = choiceDetailMenu - 1;

        ProductService.choiceOptionPrint(bearArr,bearMap,key);

        int choiceOption = in.nextInt();

        setProductOption(choiceOption, choiceDetailMenu);
    }

    public void setProductOption(int choiceOption, int choiceDetailMenu){

        int key = choiceDetailMenu - 1;

        if(choiceDetailMenu == 1 && choiceOption == 2){
            bearArr.set(key, new ProductMenu("생맥주(거품 가득 생맥주)", 4.0, "거품이 일품인 생맥주!"));
        }else if(choiceDetailMenu == 2){
            if(choiceOption == 1) {
                bearArr.set(key, new ProductMenu("카스", 4.0, "마시면 머리까지 시원해지는 카스!"));
            }else if(choiceOption == 2){
                bearArr.set(key, new ProductMenu("테라", 4.0, "마시면 머리까지 시원해지는 테라!"));
            }else if(choiceOption == 3){
                bearArr.set(key, new ProductMenu("KGB", 6.0, "상큼한 맛과 톡쏘는 알코올 KGB!"));
            }else{
                bearArr.set(key, new ProductMenu("하이네켄", 4.5, "깊은 맛이 일품인 하이네켄!"));
            }
        }else{
            System.out.println();
        }
    }
}
