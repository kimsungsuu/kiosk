import java.util.ArrayList;

/**
 * 메인 메뉴에 출력될 메뉴 리스트
 */
public class MainMenuList {
    ArrayList<MainMenu> mainMenuArr;
    public void mainMenuList(){

        mainMenuArr = new ArrayList<>();

        mainMenuArr.add(new MainMenu("Bugers", "앵거스 비프 통살을 다져만든 버거"));
        mainMenuArr.add(new MainMenu("ForzenCustard", "매장에서 신선하게 만드는 아이스크림"));
        mainMenuArr.add(new MainMenu("Drinks", "매장에서 직접 만드는 음료"));
        mainMenuArr.add(new MainMenu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));

        for(int i = 0; i < mainMenuArr.size(); i++){
            System.out.println((i+1) + " " + mainMenuArr.get(i).name + " | " + mainMenuArr.get(i).description);
        }
    }
}
