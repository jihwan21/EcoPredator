package TeamProject;

import java.util.Random;
import java.util.Scanner;

class Player {
	static Monster p; // 몬스터 클래스를 전역으로 받았기 때문에 이름 말고 다른 스탯은 Player.p.으로 접근가능
	static Armor a; // 플레이어가 갑옷객체를 받아옴
	static Headpiece h; // 투구

	static String name, style;

	static int hpPotionN, mpPotionN, 수류탄N, 갑옷N, 투구N, pMoney = 100000;
	
	static int 아가미N = 0;
	static int 어항N = 0;
	static int 날개N = 0;

	
	static public void reinforcement() {
		Scanner in = new Scanner(System.in);
		int select = in.nextInt();

		Random random = new Random();
		double probability = 1.0;
		int randomNumber = random.nextInt(100);

		if (select == 1) {
			if (투구N == 0) {
				System.out.println("장비를 보유하고 있지 않습니다.");
			} else if (a.reinforceP > pMoney) {
				System.out.println("돈이 부족합니다.");

			} else {
				pMoney -= h.reinforceP;
				probability -= 0.05 * h.lv;
				if (randomNumber < probability * 100) {
					h.lv++;
					h.reinforceN += h.lv * 20;
					h.reinforceP += h.lv * 100;
					System.out.println("강화성공!");
					System.out.println("장비레벨: " + h.lv);
					System.out.println("장비방어력: " + (h.defense + h.reinforceN));
					System.out.println("사용한 돈: " + h.reinforceP);
				} else {
					System.out.println("강화실패");
					투구N--;
				}
			}
		}

		if (select == 2) {
			if (갑옷N == 0) {
				System.out.println("장비를 보유하고 있지 않습니다.");
			} else if (a.reinforceP > pMoney) {
				System.out.println("돈이 부족합니다.");

			} else {
				pMoney -= a.reinforceP;
				probability -= 0.05 * a.lv;
				if (randomNumber < probability * 100) {
					a.lv++;
					a.reinforceN += a.lv * 20;
					a.reinforceP += a.lv * 100;
					System.out.println("강화성공!");
					System.out.println("장비레벨: " + a.lv);
					System.out.println("장비방어력: " + (a.defense + a.reinforceN));
					System.out.println("사용한 돈: " + a.reinforceP);
				} else {
					System.out.println("강화실패");
					갑옷N--;
				}

			}
		}
	}
}
