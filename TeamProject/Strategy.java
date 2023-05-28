package TeamProject;

import java.util.Random;

//전략 공격 선택지 클래스
class Strategy_Attack extends Player {
	Random random = new Random();
	int randomNumber = random.nextInt(100);

	String s1 = "전략적 선택지 1번 : 1턴 동안 공격력 2배 증가, 다음턴 사용한 스킬 1회 봉인";
	String s2 = "전략적 선택지 2번 : 공격력 3배 증가, 이후 1턴 받는 데미지 3배 증가";
	String s3 = "전략적 선택지 3번 : 25% 확률로 1턴 동안 공격력이 5배 증가";
	String s4 = "전략적 선택지 4번 : 50% 확률로 1턴 동안 공격력이 2배 증가 or 절반 감소";

	public Strategy_Attack() {
		System.out.println("<공격 전략전 선택지 목록>");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

	@SuppressWarnings("static-access")
	public int Sattack(int select) {
		if (select == 1) {
			System.out.println("1번 전략을 선택하였습니다. 다음 1턴 동안 공격력이 2배 증가하며, 1턴 동안 사용한 스킬이 봉인됩니다.");
			int S_power = p.power; // 기존 플레이어 공격력 유지하기 위해 새로운 변수 생성하여 공격력 증가
			S_power *= 2; // 100%증가
			return S_power; // 100% 증가된 공격력을 리턴하여 최종 공격 산출식에 활용 or 스킬 공격력 계산에 활용하는 방식으로 적용
			// 봉인 어떻게 구현하지...?
		} else if (select == 2) {
			System.out.println("2번 전략을 선택하였습니다. 다음 1턴 동안 공격력이 3배 증가합니다. 그러나 이후 1턴 동안 받는 데미지 또한 3배 증가합니다.");
			int S_power = p.power;
			S_power *= 3; //
			return S_power;
		} else if (select == 3) {
			System.out.println("3번 전략을 선택하였습니다. 25% 확률로 1턴 동안 공격력이 5배 증가합니다!");
			int S_power = p.power;
			if (randomNumber < 25) {
				S_power *= 5;
			}
			return S_power;
		} else if (select == 4) {
			System.out.println("4번 전략을 선택하였습니다. 50% 확률로 1턴 동안 공격력이 2배 증가하거나 절반 감소합니다.");
			int S_power = p.power;
			if (randomNumber < 50) {
				S_power *= 2;
			} else {
				S_power *= 0.5;
			}
			return S_power;
		}
		return 0;
	}
}

//전략 방어 선택지 클래스
class Strategy_Defense extends Player {
	Random random = new Random();
	int randomNumber = random.nextInt(100);

	String s1 = "전략적 선택지 1번 : 1턴 동안 방어력 2배 증가";
	String s2 = "전략적 선택지 2번 : hp 30% 회복";
	String s3 = "전략적 선택지 3번 : 25% 확률로 hp 50% 회복";
	String s4 = "전략적 선택지 4번 : 10% 확률로 1턴 동안 방어력이 10배 증가";

	public Strategy_Defense() {
		System.out.println("<방어 전략전 선택지 목록>");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

	@SuppressWarnings("static-access")
	public int Sdefense(int select) {
		if (select == 1) {
			System.out.println("1번 전략을 선택하였습니다. 다음 1턴 동안 방어력이 2배 증가합니다.");
			int S_defense = p.defense;
			S_defense *= 2;
			return S_defense;
		} else if (select == 2) {
			System.out.println("2번 전략을 선택하였습니다. hp 30% 회복합니다.");
			if (p.hp > p.hpMax * 0.7) {
				p.hp = p.hpMax;
			} else {
				p.hp += p.hpMax * 0.3; // hpMax의 30%만큼 현재 플레이어의 hp에 더한다.
			}
		} else if (select == 3) {
			System.out.println("3번 전략을 선택하였습니다. 50% 확률로 hp 50% 회복합니다.");
			if (randomNumber < 25) {
				if (p.hp > p.hpMax * 0.5) {
					p.hp = p.hpMax;
				} else {
					p.hp += p.hpMax * 0.5;
				}
			}
		} else if (select == 4) {
			System.out.println("4번 전략을 선택하였습니다. 10% 확률로 1턴 동안 방어력이 10배 증가합니다.");
			if (randomNumber < 10) {
				int S_defense = p.defense;
				S_defense *= 10;
				return S_defense;
			}
		}
		return 0;
	}
}
