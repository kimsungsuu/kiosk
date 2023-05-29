package main;

/**
 * 상세 메뉴에서 공통적으로 존재하는 메서드를 추상화
 */
public abstract class AbstractProduct {
    public abstract void detailMenu();
    public abstract ProductMenu choiceProduct(int choiceDetailMenu);
}
