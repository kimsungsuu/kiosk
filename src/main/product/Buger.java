package main.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Buger implements InterfaceProduct {

    // 멤버 필드로 선언하여 외부에서 접근 가능.
    public ArrayList<ProductMenu> bugerArr;
    public Map<Integer, ProductOption> bugerMap;

    // 상품 메뉴 보여주기
    public void detailMenu(){
        bugerArr = new ArrayList<>();
        bugerMap = new HashMap<>();

        bugerArr.add(new ProductMenu("마라로드 새우", 5.4, "새우살 가득한 오리지널 새우패티에 이색적인 사천풍 마라 소스를 결합한 차별성 있는 새우버거"));
        bugerArr.add(new ProductMenu("마라로드 치킨", 5.4, "두툼한 통다리살 치킨패티에 중독성 강한 사천풍의 마라 소스로 맛을 낸 이색적인 치킨버거"));
        bugerArr.add(new ProductMenu("불고기 버거", 4.7, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
        bugerArr.add(new ProductMenu("모짜렐라 인 더 버거 베이컨", 7.4, "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거"));

        bugerMap.put(0, new ProductOption("Single 패티(Won 5.4)", "Double 패티(Won 7.0)", "피클 추가(Won 5.9)"));
        bugerMap.put(1, new ProductOption("Single 패티(Won 5.4)", "Double 패티(Won 7.0)", "피클 추가(Won 5.9)"));
        bugerMap.put(2, new ProductOption("Single 패티(Won 4.7)", "Double 패티(Won 6.0)", "치즈 추가(Won 5.2)", "피클 추가(Won 5.2)", "계란 후라이 추가(Won 5.7)"));
        bugerMap.put(3, new ProductOption("기본(Won 7.4)", "베이컨 추가(Won 8.2)"));

        System.out.println("[ Bugers MENU ]");
        ProductService.detailMenuPrint(bugerArr);
    }

    public ProductMenu choiceProduct(int choiceDetailMenu){
        return ProductService.choiceProductPrint(bugerArr, choiceDetailMenu);
    }

    public void choiceOption(int choiceDetailMenu){
        Scanner in = new Scanner(System.in);

        int key = choiceDetailMenu - 1;

        ProductService.choiceOptionPrint(bugerArr,bugerMap,key);

        int choiceOption = in.nextInt();

        setProductPrice(choiceOption, choiceDetailMenu);
    }

    public void setProductPrice(int choiceOption, int choiceDetailMenu) {

        int key = choiceDetailMenu - 1;

        if (choiceDetailMenu == 1) {
            if (choiceOption == 1) {
                bugerArr.set(key, new ProductMenu("마라로드 새우(Single)", 5.4, "새우살 가득한 오리지널 새우패티에 이색적인 사천풍 마라 소스를 결합한 차별성 있는 새우버거"));
            } else if (choiceOption == 2) {
                bugerArr.set(key, new ProductMenu("마라로드 새우(Double)", 7.0, "새우살 가득한 오리지널 새우패티에 이색적인 사천풍 마라 소스를 결합한 차별성 있는 새우버거"));
            } else {
                bugerArr.set(key, new ProductMenu("마라로드 새우(피클 추가)", 5.9, "새우살 가득한 오리지널 새우패티에 이색적인 사천풍 마라 소스를 결합한 차별성 있는 새우버거"));
            }
        } else if (choiceDetailMenu == 2) {
            if (choiceOption == 1) {
                bugerArr.set(key, new ProductMenu("마라로드 치킨(Single)", 5.4, "두툼한 통다리살 치킨패티에 중독성 강한 사천풍의 마라 소스로 맛을 낸 이색적인 치킨버거"));
            } else if (choiceOption == 2) {
                bugerArr.set(key, new ProductMenu("마라로드 치킨(Double)", 7.0, "두툼한 통다리살 치킨패티에 중독성 강한 사천풍의 마라 소스로 맛을 낸 이색적인 치킨버거"));
            } else {
                bugerArr.set(key, new ProductMenu("마라로드 치킨(피클 추가)", 5.9, "두툼한 통다리살 치킨패티에 중독성 강한 사천풍의 마라 소스로 맛을 낸 이색적인 치킨버거"));
            }
        } else if (choiceDetailMenu == 3) {
            if (choiceOption == 1) {
                bugerArr.set(key, new ProductMenu("불고기 버거(Single)", 4.7, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
            } else if (choiceOption == 2) {
                bugerArr.set(key, new ProductMenu("불고기 버거(Double)", 6.0, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
            } else if (choiceOption == 3) {
                bugerArr.set(key, new ProductMenu("불고기 버거(치즈 추가)", 5.2, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
            } else if (choiceOption == 4){
                bugerArr.set(key, new ProductMenu("불고기 버거(피클 추가)", 5.2, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
            } else{
                bugerArr.set(key, new ProductMenu("불고기 버거(계란 후라이 추가)", 5.7, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거"));
            }
        } else {
            if (choiceOption == 1) {
                bugerArr.set(key, new ProductMenu("모짜렐라 인 더 버거(기본)", 7.4, "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거"));
            } else {
                bugerArr.set(key, new ProductMenu("모짜렐라 인 더 버거(베이컨 추가)",8.2 , "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거"));
            }
        }
    }
}
