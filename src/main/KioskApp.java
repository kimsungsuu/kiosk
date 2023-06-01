package main;

import main.product.Product;
import main.product.ProductMenu;

import java.util.Scanner;

public class KioskApp {

    public static int start(Product product, int choiceDetailMenu, ProductMenu choiceProduct, int orderOrCancel, int addProductCnt, OrderList orderList){

        Scanner in = new Scanner(System.in);

        System.out.println("롯데리아에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();

        // 상세 상품 메뉴를 출력합니다.
        product.detailMenu();

        // 상세 상품 선택

        choiceDetailMenu = in.nextInt();

        clearScreen();

        boolean flag = true;

        // 메뉴를 선택합니다.
        // 존재하지 않는 메뉴를 선택할 시에 다시 상품을 선택해야합니다.
        while (flag) {
            try {
                choiceProduct = product.choiceProduct(choiceDetailMenu);
                flag = false;
            } catch (Exception e) {
                System.out.println("****존재하지 않는 상품입니다. 다시 선택해주세요****");
                System.out.println();
                product.detailMenu();
                choiceDetailMenu = in.nextInt();
                clearScreen();
            }
        }

        // 장바구니에 담을지 말지 결정합니다.
        // 1. 확인   2. 취소
        orderOrCancel = in.nextInt();

        clearScreen();

        // 확인 버튼 클릭 시 장바구니에 상품 메뉴가 담긴다.
        // 취소 버튼 클릭 시 장바구니에 상품이 담기지 않고 메인 메뉴로 돌아간다.
        if (orderOrCancel == 1) {
            // 선택한 상품 추가
            addProductCnt++;
            orderList.addProduct(choiceProduct, addProductCnt);
        } // case Buger end

        return addProductCnt;
    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}
