package main;

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

    // 상세 상품 선택
    static int choiceDetailMenu;

    // 상세 상품 장바구니에 담기 위해 선언
    static ProductMenu choiceProduct;

    //장바구나 획인 or 취소
    static int orderOrCancel;

    // 주문 횟수로 어떤 상품이 장바구니에 담기는지 파악
    static int addProductCnt;

    // 장바구니 객체
    static OrderList orderList;

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
        menuMap.put(1,new Product(new Buger()));
        menuMap.put(2,new Product(new Dessert()));
        menuMap.put(3,new Product(new Drinks()));
        menuMap.put(4,new Product(new Chicken()));
        menuMap.put(5,new Product(new Bear()));


        // 가게 명 설정
        // 메인 메뉴에 출력될 이름 설정 ex ) "name에 오신걸 환영합니다."
        String menuName = "롯데리아";

        // 주문 상품을 담을 장바구니 역할인 orderList 인스턴스화
        orderList = new OrderList();

        // 총 Order 수(대기번호수)
        int totalOrderCnt = 0;

        while (true) {
            // 메인 메뉴리스트를 출력합니다.
            // 메인 메뉴가 변경될 때마다 MainMenu 클래스를 변경하지 않도록 클래스를 분리하여 결합도를 낮춥니다.
            MainMenuList mainMenuList = new MainMenuList();
            mainMenuList.mainMenuList(menuName);

            // 메인 메뉴판 선택 버거, 디저트, 음료, 치킨 중...
            int choiceMenu = in.nextInt();

            // 화면 전환 효과를 위해 공백을 입력합니다.
            clearScreen();


            // 상세 메뉴를 추상화한 Product
            // Product 객체를 통해 객체를 갈아끼워주기만 하면 됨.
            Product product = menuMap.get(choiceMenu);

            if(product != null){
                addProductCnt = KioskApp.start(product,choiceDetailMenu, choiceProduct, orderOrCancel, addProductCnt, orderList);
            }else if(choiceMenu == menuMap.size()+1){
                                    // 장바구니에 담긴 상품 목록 출력
                    orderList.orderProductList();
                    //최종적으로 주문할지 취소할지 결정
                    System.out.println();
                    System.out.println("1. 주문      2. 메뉴판");

                    int order = in.nextInt();

                    clearScreen();

                    if (order == 1) {
                        // addProductCnt = 0, 주문과 함께 장바구니를 초기화함.
                        // 주문 했는데, 장바구니를 비우지 않으면, 다음 이용자에게 전 이용자가 사용한 장바구니 기록이 남게되어서 예상치 못한 결과가 발생
                        addProductCnt = 0;

                        orderList.clearOrder();

                        long delay = 3000;

                        totalOrderCnt++;

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
            }else if(choiceMenu == menuMap.size()+2) {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    // 진행하던 주문 확인(1) 또는 취소(2)
                    int orderCancel = in.nextInt();
                    if (orderCancel == 1) {
                        // 장바구니 비우기
                        orderList.clearOrder();
                        // 진행하던 주문 취소 시 장바구니를 비워야 하므로 addProductCnt = 0
                        addProductCnt = 0;
                        System.out.println("진행하던 주문이 취소되었습니다.");
                    }
                    System.out.println();
                    System.out.println();
            }else{
                System.out.println("존재하지 않는 메뉴입니다.");
                System.out.println();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }

//            switch (choiceMenu) {
//                case 1: // buger case
//                    product = new Product(new Buger());
//
//                    addProductCnt = KioskApp.start(product,choiceDetailMenu, choiceProduct, orderOrCancel, addProductCnt, orderList);
//
//                    break;
//                case 2: // Dessert case
//                    product = new Product(new Dessert());
//
//                    addProductCnt = KioskApp.start(product,choiceDetailMenu, choiceProduct, orderOrCancel, addProductCnt, orderList);
//
//                    break;
//                case 3: // Drinks case
//                    product = new Product(new Drinks());
//
//                    addProductCnt = KioskApp.start(product,choiceDetailMenu, choiceProduct, orderOrCancel, addProductCnt, orderList);
//
//                    break;
//                case 4: // Chicken case
//                    product = new Product(new Chicken());
//
//                    addProductCnt = KioskApp.start(product,choiceDetailMenu, choiceProduct, orderOrCancel, addProductCnt, orderList);
//
//                    break;
//                case 5: // 최종 주문
//                    // 장바구니에 담긴 상품 목록 출력
//                    orderList.orderProductList();
//                    //최종적으로 주문할지 취소할지 결정
//                    System.out.println();
//                    System.out.println("1. 주문      2. 메뉴판");
//
//                    int order = in.nextInt();
//
//                    clearScreen();
//
//                    if (order == 1) {
//                        // addProductCnt = 0, 주문과 함께 장바구니를 초기화함.
//                        // 주문 했는데, 장바구니를 비우지 않으면, 다음 이용자에게 전 이용자가 사용한 장바구니 기록이 남게되어서 예상치 못한 결과가 발생
//                        addProductCnt = 0;
//
//                        orderList.clearOrder();
//
//                        long delay = 3000;
//
//                        totalOrderCnt++;
//
//                        System.out.println();
//                        System.out.println("주문이 완료되었습니다!");
//                        System.out.println();
//                        System.out.println("대기번호는 [ " + totalOrderCnt + " ] 번 입니다.");
//                        System.out.println("(" + delay / 1000 + "초 후 메뉴판으로 돌아갑니다.)");
//
//                        for (int i = 0; i < 3; i++) {
//                            try {
//                                Thread.sleep(1000);
//                                System.out.print(i + 1 + " ");
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        clearScreen();
//                    }
//                    break; // case 5 end
//                case 6: // 주문 취소
//                    System.out.println("진행하던 주문을 취소하시겠습니까?");
//                    System.out.println("1. 확인      2. 취소");
//                    // 진행하던 주문 확인(1) 또는 취소(2)
//                    int orderCancel = in.nextInt();
//                    if (orderCancel == 1) {
//                        // 장바구니 비우기
//                        orderList.clearOrder();
//                        // 진행하던 주문 취소 시 장바구니를 비워야 하므로 addProductCnt = 0
//                        addProductCnt = 0;
//                        System.out.println("진행하던 주문이 취소되었습니다.");
//                    }
//                    System.out.println();
//                    System.out.println();
//                    break;
//                default:
//                    System.out.println("존재하지 않는 메뉴입니다.");
//                    System.out.println();
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}