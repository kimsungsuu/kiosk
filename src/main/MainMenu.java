package main;

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

    // 장바구니 객체
    static OrderList orderList;

    public static void main(String[] args) {
        MainMenu T = new MainMenu();
        Scanner in = new Scanner(System.in);

        // 주문 상품을 담을 장바구니 역할인 orderList 인스턴스화
        orderList = new OrderList();

        // 메인 메뉴리스트를 출력합니다.
        // 메인 메뉴가 변경될 때마다 main.MainMenu 클래스를 변경되지 않도록 클래스를 분리하여 결합도를 낮춥니다.
        MainMenuList mainMenuList = new MainMenuList();
        mainMenuList.mainMenuList();

        // 메인 메뉴판 choice
        int choiceMenu = in.nextInt();

        // 화면 전환 효과를 위해 공백을 입력합니다.
        T.clearScreen();

        // 메인 메뉴 선택 시 콘솔 창을 지웁니다.
        System.out.flush();
        switch (choiceMenu) {
            case 1:
                Buger buger = new Buger();
                // 상세 상품 메뉴를 출력합니다.
                buger.detailMenu();

                // 상세 상품 선택
                int choiceDetailMenu = in.nextInt();

                T.clearScreen();

                // 메뉴를 선택합니다.
                ProductMenu choiceProduct = buger.choiceProduct(choiceDetailMenu);

                // 장바구니에 담을지 말지 결정합니다.
                int orderOrCancel = in.nextInt();

                T.clearScreen();

                // 확인 버튼 클릭 시 장바구니에 상품 메뉴가 담긴다.
                // 상품 메뉴를
                // 취소 버튼 클릭 시 메인 메뉴로 돌아간다.
                switch (orderOrCancel) {
                    case 1:
                        // 선택한 상품 추가
                        orderList.addProduct(choiceProduct);
                        // 최종 주문 (나중에 5번 입력했을 시로 변경되어야함 임시적으로 테스트해보기 위해 선언)
                        orderList.orderProductList();
                        break;
                    case 2:
                        mainMenuList.mainMenuList();
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다");
                        break;
                }
                break;
            default:
                System.out.println("존재하지 않는 메뉴입니다.");
                break;
        }
    }



    // 화면 전환 효과
    // 나중에 전역 메소드로 설정하기 위해 상속 기능이나, 기타 기능을 이용해보면 좋을 듯.
    public void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}