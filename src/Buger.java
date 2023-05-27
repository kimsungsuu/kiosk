import java.util.ArrayList;

public class Buger{

    public ArrayList<ProductMenu> bugerArr;

    // 상품 메뉴 보여주기
    public void detailMenu(){

        bugerArr = new ArrayList<>();
        bugerArr.add(new ProductMenu("ShackBurger", 6.9, "토마토, 양상추, 토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugerArr.add(new ProductMenu("SmokeBurger", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugerArr.add(new ProductMenu("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));

        for(int i = 0; i < bugerArr.size(); i++){
            System.out.println((i+1) + " " + bugerArr.get(i).name + " | Won "
                    + bugerArr.get(i).price + " | " + bugerArr.get(i).description);
        }


    }

    // 상품 메뉴를 선택했을 시
    public void choiceProduct(int choiceDetailMenu){
        // 장바구니에 상품 메뉴를 추가함.
        System.out.println("\"" + bugerArr.get(choiceDetailMenu-1).name + " | Won" + bugerArr.get(choiceDetailMenu-1).price + " | "
                + bugerArr.get(choiceDetailMenu-1).description + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인         2. 취소");
    }
}
