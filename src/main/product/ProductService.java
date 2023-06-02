package main.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Product 객체 내부 공통 로직
 */
public class ProductService {

    public ProductService(){

    }

    // 상품 메뉴 보여주기
    public static void detailMenuPrint(ArrayList<ProductMenu> object){

        System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");

        for(int i = 0; i < object.size(); i++){
            System.out.println((i+1) + " " + String.format("%-15s", object.get(i).name)+ " | Won "
                    + object.get(i).price + " | " + object.get(i).description);
        }
    }

    // 상품 메뉴를 선택했을 시
    public static ProductMenu choiceProductPrint(ArrayList<ProductMenu> object, int choiceDetailMenu){

        System.out.println("\"" + object.get(choiceDetailMenu-1).name + " | Won " + object.get(choiceDetailMenu-1).price + " | "
                + object.get(choiceDetailMenu-1).description + "\"");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println();
        System.out.println("1. 확인         2. 취소");

        return object.get(choiceDetailMenu-1);
    }

    public static void choiceOptionPrint(ArrayList<ProductMenu> object, Map<Integer, ProductOption> objectMap, int key){

        ProductOption productOption = objectMap.get(key);

        List<String> options =  productOption.getOptions();

        System.out.println("\"" + object.get(key).name + " | Won " + object.get(key).price + " | "
                + object.get(key).description + "\"");

        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");

        for (int i = 0; i < options.size(); i++){
            System.out.print((i+1) + ". " + options.get(i) + "      ");
        }
        System.out.println();
    }
}
