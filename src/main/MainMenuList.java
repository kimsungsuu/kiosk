package main;

import java.util.ArrayList;

/**
 * 메인 메뉴에 출력될 메뉴 리스트
 */
public class MainMenuList {
    ArrayList<MainMenu> mainMenuArr;
    public void mainMenuList(){

        mainMenuArr = new ArrayList<>();

        mainMenuArr.add(new MainMenu("Bugers", "앵거스 비프 통살을 다져만든 버거"));
        mainMenuArr.add(new MainMenu("Dessert", "맛있는 식사 후에 먹는 음식"));
        mainMenuArr.add(new MainMenu("Drinks", "매장에서 직접 만드는 음료"));
        mainMenuArr.add(new MainMenu("Chicken", "바삭한 껍질과 촉촉하고 부드러운 속살이 일품인 치킨"));

        System.out.println("메뉴를 선택하세요");

        for(int i = 0; i < mainMenuArr.size(); i++){
            System.out.println((i+1) + " " + mainMenuArr.get(i).name + " | " + mainMenuArr.get(i).description);
        }

        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order");
        // 6번 버튼 클릭시 메인 프로그램 종료
        System.out.println("6. Cancel");
    }
}
