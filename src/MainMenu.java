import java.sql.SQLOutput;
import java.util.Scanner;

/**
 *  메인 메뉴에서는 사용자가 상품을 선택하는 로직만을 구현합니다.
 *  비즈니스 로직은 각각의 객체에서 분리하여 구현합니다.
 *
 */
public class MainMenu{
    String name;
    String description;

    public MainMenu(String name, String description){
        this.name = name;
        this.description = description;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("메뉴를 선택하세요");

        // 메인메뉴리스트를 출력합니다.
        // 메인 메뉴가 변경될 때마다 MainMenu 클래스를 변경되지 않도록 클래스를 분리하여 결합도를 낮춥니다.
        MainMenuList mainMenuList = new MainMenuList();
        mainMenuList.mainMenuList();

        // 메인 메뉴판 choice
        int choiceMenu = in.nextInt();

        switch (choiceMenu){
            case 1:
                Buger buger = new Buger();
                System.out.println("[ Bugers MENU ]");
                System.out.println("아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.");
                // 상세 상품 메뉴를 출력합니다.
                buger.detailMenu();
                int choiceDetailMenu = in.nextInt();
                // 메뉴를 선택합니다.
                buger.choiceProduct(choiceDetailMenu);
                int orderOrCancle = in.nextInt();

                break;
            default:
                System.out.println("존재하지 않는 메뉴입니다.");
        }
    }
}