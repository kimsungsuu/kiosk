package main.product;

import java.util.ArrayList;

public class Buger implements InterfaceProduct {

    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> bugerArr;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        bugerArr = new ArrayList<>();
        bugerArr.add(new ProductMenu("마라로드 새우", 5.4, "새우살 가득한 오리지널 새우패티에 이색적인 사천풍 마라 소스를 결합한 차별성 있는 새우버거"));
        bugerArr.add(new ProductMenu("마라로드 치킨", 5.4, "두툼한 통다리살 치킨패티에 중독성 강한 사천풍의 마라 소스로 맛을 낸 이색적인 치킨버거"));
        bugerArr.add(new ProductMenu("불고기 버거", 4.7, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
        bugerArr.add(new ProductMenu("모짜렐라 인 더 버거 베이컨", 7.4, "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거"));

        System.out.println("[ Bugers MENU ]");
        ProductService.detailMenuPrint(bugerArr);
    }

    public ProductMenu choiceProduct(int choiceDetailMenu){
        return ProductService.choiceProductPrint(bugerArr, choiceDetailMenu);
    }
}
