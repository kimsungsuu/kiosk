package main;

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
    // ex ) 첫번째 장바구니 담기
    // 치즈스틱이 장바구니에 추가되었습니다.
    // 두번째 장바구니 담기
    // 양념감자가 장바구니에 추가되었습니다.
    static int addProductCnt;

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

        // 가게 명 설정
        // 메인 메뉴에 출력될 이름 설정 ex ) "name에 오신걸 환영합니다."
        String menuName = "롯데리아";

        // 주문 상품을 담을 장바구니 역할인 orderList 인스턴스화
        orderList = new OrderList();

        // 총 Order 수(대기번호수)
        int totalOrderCnt = 0;

        // 6번 버튼 클릭 시 프로그램 종료
        while (true) {

            // 메인 메뉴리스트를 출력합니다.
            // 메인 메뉴가 변경될 때마다 main.MainMenu 클래스를 변경되지 않도록 클래스를 분리하여 결합도를 낮춥니다.
            MainMenuList mainMenuList = new MainMenuList();
            mainMenuList.mainMenuList(menuName);

            // 메인 메뉴판 초이스 버거, 디저트, 음료, 치킨 중...
            int choiceMenu = in.nextInt();

            // 화면 전환 효과를 위해 공백을 입력합니다.
            T.clearScreen();

            // 상세 메뉴를 추상화한 Product
            // Product 객체를 통해 case 문마다 객체를 갈아끼워주지 않아도 됨.
            Product product;

            switch (choiceMenu) {
                case 1:
                    product = new Product(new Buger());

                    System.out.println("롯데리아에 오신걸 환영합니다.");
                    System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                    System.out.println();

                    // 상세 상품 메뉴를 출력합니다.
                    product.detailMenu();

                    // 상세 상품 선택
                    choiceDetailMenu = in.nextInt();

                    T.clearScreen();

                    // 메뉴를 선택합니다.
                    choiceProduct = product.choiceProduct(choiceDetailMenu);

                    // 장바구니에 담을지 말지 결정합니다.
                    // 1. 확인   2. 취소
                    orderOrCancel = in.nextInt();

                    T.clearScreen();

                    // 확인 버튼 클릭 시 장바구니에 상품 메뉴가 담긴다.
                    // 취소 버튼 클릭 시 장바구니에 상품이 담기지 않고 메인 메뉴로 돌아간다.
                    if (orderOrCancel == 1) {
                        // 선택한 상품 추가
                        addProductCnt++;
                        orderList.addProduct(choiceProduct, addProductCnt);
                    } // case Buger end
                    break;
                case 2:
                    product = new Product(new Dessert());

                    System.out.println("롯데리아에 오신걸 환영합니다.");
                    System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                    System.out.println();

                    product.detailMenu();

                    choiceDetailMenu = in.nextInt();

                    T.clearScreen();

                    choiceProduct = product.choiceProduct(choiceDetailMenu);

                    orderOrCancel = in.nextInt();

                    T.clearScreen();

                    if (orderOrCancel == 1) {
                        addProductCnt++;
                        orderList.addProduct(choiceProduct, addProductCnt);
                    } // case Dessert end
                    break;
                case 3:
                    product = new Product(new Drinks());

                    System.out.println("롯데리아에 오신걸 환영합니다.");
                    System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                    System.out.println();

                    product.detailMenu();

                    choiceDetailMenu = in.nextInt();

                    T.clearScreen();

                    choiceProduct = product.choiceProduct(choiceDetailMenu);

                    orderOrCancel = in.nextInt();

                    T.clearScreen();

                    if (orderOrCancel == 1) {
                        addProductCnt++;
                        orderList.addProduct(choiceProduct, addProductCnt);
                    } // case Drinks end
                    break;
                case 4:
                    product = new Product(new Chicken());

                    System.out.println("롯데리아에 오신걸 환영합니다.");
                    System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                    System.out.println();

                    product.detailMenu();

                    choiceDetailMenu = in.nextInt();

                    T.clearScreen();

                    choiceProduct = product.choiceProduct(choiceDetailMenu);

                    orderOrCancel = in.nextInt();

                    T.clearScreen();

                    if (orderOrCancel == 1) {
                        addProductCnt++;
                        orderList.addProduct(choiceProduct, addProductCnt);
                    } // case chicken end
                    break;
                case 5: // 최종 주문
                    // 최종 주문 (나중에 5번 입력했을 시로 변경되어야함 임시적으로 테스트해보기 위해 선언)
                    orderList.orderProductList();
                    //최종적으로 주문할지 취소할지 결정
                    System.out.println();
                    System.out.println("1. 주문      2. 메뉴판");
                    int order = in.nextInt();
                    T.clearScreen();

                    if (order == 1) {
                        // addProductCnt = 0 주문과 함께 장바구니를 초기화함.
                        // 주문 했는데, 장바구니를 비우지 않으면, 다음 이용자에게 전 이용자가 사용한 장바구니 기록이 남게되어서
                        // 예상치 못한 결과가 발생함.
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

                        T.clearScreen();
                    }
                    break; // case 5 end
                case 6: // 주문 취소
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
                    break;
                default:
                    System.out.println("존재하지 않는 메뉴입니다.");
                    System.out.println();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}