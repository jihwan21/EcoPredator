package TeamProject;

import java.util.Random;

//전략 공격 선택지 클래스
class Strategy_Attack extends Player {
	Random random = new Random();
	int randomNumber = random.nextInt(100); // 확률을 쓰기 위해 0~99 사이 랜덤한 정수 추출
	// 공격 전략 선택지 목록
	String s1 = "전략적 선택지 1번 : 1턴 동안 공격력 1.5배 증가";
	String s2 = "전략적 선택지 2번 : 50% 확률로 1턴 동안 공격력 2배 증가";
	String s3 = "전략적 선택지 3번 : 25% 확률로 1턴 동안 공격력이 5배 증가";
	String s4 = "전략적 선택지 4번 : 70% 확률로 1턴 동안 공격력이 3배 증가 or 30% 확률로 절반 감소";

	// 생성자(전략 선택지 목록 출력)
	public Strategy_Attack() {
		System.out.println("----- <공격 전략적 선택지 목록> -----");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

	// 선택한 번호에 해당하는 전략 효과 적용하는 메서드
	public int Select_attack(int select) {
		int S_power = p.current_power(); // 기존 플레이어 공격력 유지하기 위해 새로운 변수 생성하여 copy
		if (select == 1) {
			System.out.println("1번 전략을 선택하였습니다. 다음 1턴 동안 공격력이 1.5배 증가합니다.");
			S_power *= 1.5; // 공격력 1.5배 증가
		} else if (select == 2) {
			System.out.println("2번 전략을 선택하였습니다. 다음 1턴 동안 50% 확률로 공격력이 2배 증가합니다.");
			if (randomNumber < 50) {
				System.out.println(">> 공격력이 2배 증가합니다!!!");
				S_power *= 2;
			} else {
				System.out.println(">> 아무런 변화가 없었습니다...");
			}
		} else if (select == 3) {
			System.out.println("3번 전략을 선택하였습니다. 25% 확률로 1턴 동안 공격력이 5배 증가합니다.");
			if (randomNumber < 25) {
				System.out.println(">> 공격력이 5배 증가합니다!!!");
				S_power *= 5;
			} else {
				System.out.println(">> 아무런 변화가 없었습니다...");
			}
		} else if (select == 4) {
			System.out.println("4번 전략을 선택하였습니다. 70% 확률로 1턴 동안 공격력이 3배 증가하거나 30% 확률로 절반 감소합니다.");
			if (randomNumber < 70) {
				System.out.println(">> 공격력이 3배 증가합니다!!!");
				S_power *= 3;
			} else {
				System.out.println(">> 공격력이 절반 감소합니다...");
				S_power *= 0.5;
			}
		}
		return S_power; // 전략 효과 반영된 공격력 return
	}
}

//전략 방어 선택지 클래스
class Strategy_Defense extends Player {
	Random random = new Random();
	int randomNumber = random.nextInt(100); // 확률을 쓰기 위해 0~99 사이 랜덤한 정수 추출
	// 방어 전략 선택지 목록
	String s1 = "전략적 선택지 1번 : 1턴 동안 방어력 2배 증가";
	String s2 = "전략적 선택지 2번 : hp 30% 회복";
	String s3 = "전략적 선택지 3번 : 25% 확률로 hp 50% 회복";
	String s4 = "전략적 선택지 4번 : 10% 확률로 1턴 동안 방어력이 10배 증가";

	// 생성자(전략 선택지 목록 출력)
	public Strategy_Defense() {
		System.out.println("----- <방어 전략전 선택지 목록> -----");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

	// 선택한 번호에 해당하는 전략 효과 적용하는 메서드
	public int Select_defense(int select) {
		int S_defense = p.defense; // 기존 플레이어 공격력 유지하기 위해 새로운 변수 생성하여 copy
		if (select == 1) {
			System.out.println("1번 전략을 선택하였습니다. 다음 1턴 동안 방어력이 2배 증가합니다.");
			S_defense *= 2;
			return S_defense; // 전략 효과 반영된 방어력 return
		} else if (select == 2) {
			System.out.println("2번 전략을 선택하였습니다. hp 30% 회복합니다.");
			// 남은 체력이 70% 이상이면 100%로 체력 회복 (100% 체력 초과하는 경우 차단하기 위함)
			if (p.hp > p.hpMax * 0.7) {
				p.hp = p.hpMax;
			} else {
				p.hp += p.hpMax * 0.3; // hpMax의 30%만큼 현재 플레이어의 hp에 더한다.
			}
		} else if (select == 3) {
			System.out.println("3번 전략을 선택하였습니다. 25% 확률로 hp 50% 회복합니다.");
			if (randomNumber < 25) {
				System.out.println(">> hp를 50% 회복!!!");
				// 남은 체력이 50% 이상이면 100%로 체력 회복 (100% 체력 초과하는 경우 차단하기 위함)
				if (p.hp > p.hpMax * 0.5) {
					p.hp = p.hpMax;
				} else {
					p.hp += p.hpMax * 0.5;
				}
			} else {
				System.out.println(">> 아무런 변화가 없었습니다...");
			}
		} else if (select == 4) {
			System.out.println("4번 전략을 선택하였습니다. 10% 확률로 1턴 동안 방어력이 10배 증가합니다.");
			if (randomNumber < 10) {
				System.out.println(">> 방어력이 10배 증가합니다!!!");
				S_defense *= 10;
				return S_defense; // 전략 효과 반영된 방어력 return
			} else {
				System.out.println(">> 아무런 변화가 없었습니다...");
			}
		}
		return 0;
	}
}
