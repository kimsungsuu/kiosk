package main;

import main.product.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 메인 메뉴에서는 사용자가 상품을 선택하는 로직만을 구현합니다.
 * 비즈니스 로직은 각각의 객체에서 분리하여 구현합니다.
 */
public class MainMenu {
    String name;
    String description;

    public MainMenu() {
    }

    public MainMenu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 메뉴를 값을 저장해놓음으로써 동적으로 메뉴를 확장하거나 축소할 수 있다.
        Map<Integer, Product> menuMap = new HashMap<>();
        menuMap.put(1, new Product(new Buger()));
        menuMap.put(2, new Product(new Dessert()));
        menuMap.put(3, new Product(new Drinks()));
        menuMap.put(4, new Product(new Chicken()));
        menuMap.put(5, new Product(new Bear()));

        ProductMenu choiceProduct = new ProductMenu();

        OrderList orderList = new OrderList();

        int choiceDetailMenu = 0;

        int orderOrCancel = 0;

        int addProductCnt = 0;

        int totalOrderCnt = 0;

        while (true) {
            MainMenuList mainMenuList = new MainMenuList();
            // 메인 화면
            mainMenuList.mainMenuList();

            int choiceMenu = in.nextInt();

            clearScreen();

            Product product = menuMap.get(choiceMenu);

            if (product != null) { // 상품 선택
                addProductCnt = KioskApp.start(product, choiceDetailMenu, choiceProduct, orderOrCancel, addProductCnt, orderList);
            } else if (choiceMenu == menuMap.size() + 1) { // 주문 Order
                // 장바구니에 담긴 상품 목록 출력
                orderList.orderProductList();

                System.out.println();
                System.out.println("1. 주문      2. 메뉴판");

                int order = in.nextInt();

                clearScreen();

                if (order == 1) {
                    addProductCnt = 0;

                    orderList.clearOrder();

                    totalOrderCnt++;

                    // 전체 주문 수
                    afterOrder(totalOrderCnt);
                }
            } else if (choiceMenu == menuMap.size() + 2) { // 주문 취소 Cancel
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인      2. 취소");
                // 진행하던 주문 확인(1) 또는 취소(2)
                int orderCancel = in.nextInt();
                if (orderCancel == 1) {
                    // 장바구니 비우기
                    orderList.clearOrder();
                    addProductCnt = 0;
                    System.out.println("진행하던 주문이 취소되었습니다.");
                }
                System.out.println();
            } else {
                System.out.println("존재하지 않는 메뉴입니다.");
                System.out.println();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }

    public static void afterOrder(int totalOrderCnt){
        int delay = 3000;

        System.out.println();
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + totalOrderCnt + " ] 번 입니다.");
        System.out.println("(" + delay / 1000 + "초 후 메뉴판으로 돌아갑니다.)");

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(i + 1 + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clearScreen();
    }
}