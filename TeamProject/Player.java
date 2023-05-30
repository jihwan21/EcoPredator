package TeamProject;

import java.util.Random;
import java.util.Scanner;
//플레이어 클래스
class Player {
	static Monster p; // 몬스터 클래스를 전역으로 받았기 때문에 이름 말고 다른 스탯은 Player.p.으로 접근가능
	static Armor a; // 플레이어가 갑옷객체를 받아옴
	static Headpiece h; // 투구

	static String name, style;

	static int hpPotionN, mpPotionN, 수류탄N, 갑옷N, 투구N, 아가미N, 어항N, 날개N, pMoney;//플레이어 인벤토리에 사용되는 변수들은 전역으로 설정

	//강화메서드
	static public void reinforcement() {
		Scanner in = new Scanner(System.in);

		while (true) {
			Random random = new Random();
			double probability = 1.0;//첫 확률 100%
			int randomNumber = random.nextInt(100);
			if (h != null)//플레이어가 투구 객체가 있으면
				System.out.printf("1. 투구 : %dG\n", h.reinforceP);
			if (a != null)//플레이어가 갑옷 객체가 있으면
				System.out.printf("2. 갑옷 : %dG\n", a.reinforceP);
			System.out.println("3. 스킬강화");
			System.out.println("0. 강화소 나가기");
			int select = in.nextInt();

			if (select == 1) {
				if (투구N == 0) {
					System.out.println("장비를 보유하고 있지 않습니다.");
				} else if (h.reinforceP > pMoney) {
					System.out.println("돈이 부족합니다.");

				} else {
					pMoney -= h.reinforceP;//투구 객체의 강화가격 변수만큼 돈 차감
					probability -= 0.05 * h.lv;//100%확률 - 아이템 레벨*5%확률 =>  ex)19레벨이면 강화 성공확률 5%
					if (randomNumber < probability * 100) {
						h.lv++;
						h.reinforceN += h.lv * 20;
						h.reinforceP += h.lv * 100;
						System.out.printf("강화성공!\n%dLv => %dLv\n", h.lv - 1, h.lv);
						System.out.printf("장비방어력: +%d\n\n", h.lv * 20);

					} else {
						System.out.println("강화실패");
						Player.투구N--; Player.h = null;
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
						System.out.printf("강화성공!\n%dLv => %dLv\n", a.lv - 1, a.lv);
						System.out.printf("장비방어력: +%d\n\n", a.lv * 20);

					} else {
						System.out.println("강화실패");
						Player.갑옷N--; Player.a = null;
					}

				}
			}

			if (select == 3) {//스킬강화=>사용한 돈의 10%만큼 스킬을 강화
				Player.p.skill_info();
				int s = in.nextInt();
				int up = 1;
				System.out.print("강화수치를 입력해주세요.");
				while (true) {
					up = in.nextInt();
					if (up > 0)//음수를 적으면 오류발생하기 때문에 
						break;
				}
				pMoney -= up;
				if (s == 1)
					Player.p.upgradeS01 += up / 10;
				else if (s == 2)
					Player.p.upgradeS02 += up / 10;
				else if (s == 3)
					Player.p.upgradeS03 += up / 10;

			}

			if (select == 0)
				break;
		}
	}
}
