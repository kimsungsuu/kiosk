import java.util.Scanner;

public class 입양하세요 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("입양하세요는 무엇입니까?");
        System.out.println("입양하세요는 펫을 키우는 모바일 게임입니다.");

        System.out.println("로블록스에 연결된 게임입니다.");

        System.out.println("입양하세요는 어떤 게임에 연결되어있습니까?");
        System.out.println("1. 로블록스 2. 무한의 계단 3. 말랑이 온라인 4. 냥냥 점프");

        int m = in.nextInt();



        if(m == 1) System.out.println("정답입니다!");
        else System.out.println("땡!");
    }
}
