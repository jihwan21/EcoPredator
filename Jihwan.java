package test;

import java.util.Scanner;

class Time {
	int time = 1;

	void count() {
		if (time == 12)
			time = 0;
		time += 1;
	}

	int current_time() {
		return time;
	}
}

class Monster extends Time {
	String name;
	String skill_name;
	int skill_power;

	int Nocturnality; // 1 : 야행성, 0 : 주행성
	int hp;
	int hpMax;
	int mp;
	int mpMax;
	int power;
	int defense;
	int experience;
	int money;

	public Monster(String name, int Nocturnality, int hp, int hpMax, int mp, int mpMax, int power, int defense,
			int experience, int money) {
		this.name = name;
		this.Nocturnality = Nocturnality;
		this.hp = hp;
		this.hpMax = hpMax;
		this.mp = mp;
		this.mpMax = mpMax;
		this.power = power;
		this.defense = defense;
		this.experience = experience;
	}

	int current_power() { // 현재 time에 맞는 power return > 전투 공격력 산출 시 활용
		if (super.current_time() <= 6) { // time이 낮인 경우
			if (Nocturnality == 0) { // 낮이면서 주행성 동물
				power *= 1.1;
			} else if (Nocturnality == 1) { // 낮이면서 야행성 동물
				power *= 0.9;
			}
		} else if (super.current_time() > 6) { // time이 밤인 경우
			if (Nocturnality == 0) { // 밤이면서 주행성 동물
				power *= 0.9;
			} else if (Nocturnality == 1) { // 밤이면서 야행성 동물
				power *= 1.1;
			}
		}
		return power;
	}

	void setSkill(String name) {
		this.skill_name = name;
		this.skill_power = power * 2;
	}
}

class Achievement {
	String achievement_name; // 업적 대상 몬스터 이름
	int achivement_count = 0;

	public Achievement(Monster obj) { // monster 객체 call by reference
		this.achievement_name = obj.name;

	}

	void count() {
		achivement_count += 1;
	}

	void print_achievement() {
		System.out.printf("%s 업적 현황 : %d / 5\n", achievement_name, achivement_count);
	}

}

class ClassArray {
	String name;
	int count;
	int hp;
	int hpMax;
	int mp;
	int mpMax;
	int power;
	int defense;

	public ClassArray(Achievement obj, Monster obj_) {
		this.name = obj.achievement_name;
		this.count = obj.achivement_count;
		this.hp = obj_.hp;
		this.hpMax = obj_.hpMax;
		this.mp = obj_.mp;
		this.mpMax = obj_.mpMax;
		this.power = obj_.power;
		this.defense = obj_.defense;

	}

	void setStatus() {// 생물별로 다른 스탯을 플레이어 전역변수에 저장하는 메서드
//		Player.level = level;
		Player.power += power;
		Player.defense += defense;
		Player.hp += hp;
		Player.hpMax += hpMax;
		Player.mp += mp;
		Player.mpMax += mpMax;
//		Player.upgradeS01 = upgradeS01;
	}
}

class Position_Monster {
	String position_name; // 지역 이름(한강, 북한산국립공원 등)
	Monster stage_1;
	Monster stage_2;
	Monster stage_3;
	Monster stage_4;
	Monster stage_5;

	Position_Monster(String name, Monster a, Monster b, Monster c, Monster d, Monster e) {
		this.position_name = name;
		this.stage_1 = a;
		this.stage_2 = b;
		this.stage_3 = c;
		this.stage_4 = d;
		this.stage_5 = e;
	}
}

class Player {
	static int level = 1, power = 10, defense = 100, hp = 1000, hpMax = 1000, mp = 200, mpMax = 200;

	public Player() {
		level = 1;
		power = 10;
		defense = 100;
		hp = 1000;
		hpMax = 1000;
		mp = 200;
		mpMax = 200;

	}
}

public class Jihwan {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

//		Player player = new Player();
		Monster tiger = new Monster("tiger", 1, 1000, 1000, 200, 200, 500, 500, 1000, 500);
		Monster bear = new Monster("bear", 0, 1000, 1000, 200, 200, 500, 500, 1000, 500);
		Monster eagle = new Monster("eagle", 0, 1000, 1000, 200, 200, 500, 500, 1000, 500);
		Monster goldfish = new Monster("goldfish", 0, 1000, 1000, 200, 200, 500, 500, 1000, 500);
		Monster ant = new Monster("ant", 0, 1000, 1000, 200, 200, 500, 500, 1000, 500);
		Achievement tiger_ach = new Achievement(tiger);
		Achievement bear_ach = new Achievement(bear);
		Achievement eagle_ach = new Achievement(eagle);
		// time test
		Time ti = new Time();
		ti.count(); // time + 1
		System.out.println("현재 시간 : " + ti.current_time());
		System.out.println("현재 tiger power : " + tiger.current_power()); // 야행성으로 설정해서 500 -> 450
		System.out.println("현재 bear power : " + bear.current_power()); // 주행성으로 설정해서 500 -> 550
		System.out.println();

		// 스킬 설정 및 출력 테스트
		tiger.setSkill("목덜미 물기");
		System.out.println("스킬 이름 : " + tiger.skill_name);
		System.out.println("스킬 공격력 : " + tiger.skill_power);
		System.out.println();

		// stage에 해당하는 몬스터 객체 리턴 테스트
		Position_Monster Hangang = new Position_Monster("한강", tiger, bear, eagle, goldfish, ant);
		System.out.println("스테이지 1 몬스터 : " + Hangang.stage_1.name);
		System.out.println("스테이지 1 몬스터 : " + Hangang.stage_1.skill_name);
		System.out.println();

		// 업적 카운트 올리기(테스트용)
		for (int i = 0; i < 6; i++) {
			tiger_ach.count();
			eagle_ach.count();
		}
		// 업적 현황 출력
		System.out.println("<몬스터 처치 업적 상태>");
		tiger_ach.print_achievement();
		bear_ach.print_achievement();
		eagle_ach.print_achievement();
		System.out.println();
		// 객체 배열
		ClassArray[] classList = new ClassArray[3];

		classList[0] = new ClassArray(tiger_ach, tiger);
		classList[1] = new ClassArray(bear_ach, bear);
		classList[2] = new ClassArray(eagle_ach, eagle);

		// 메인에서 진화 선택한 경우
		System.out.println("<진화 가능한 몬스터 목록>");
		for (int i = 0; i < 3; i++) { // i 범위 = 몬스터 수
			if (classList[i].count >= 5) // 업적 달성도 5이상인 경우 진화 가능한 몬스터로 출력
				System.out.printf("%d. %s\n", i, classList[i].name);
		}
		System.out.println();
		System.out.print("진화할 몬스터의 번호를 입력하세요 : ");
		int evol_num = in.nextInt();
		System.out.println("--------------------------------");
		System.out.println("<진화 전 스탯>");
		System.out.println("power : " + Player.power);
		System.out.println("defense : " + Player.defense);
		System.out.println("hp : " + Player.hp);
		System.out.println("hpMax : " + Player.hpMax);
		System.out.println("mp : " + Player.mp);
		System.out.println("mpMax : " + Player.mpMax);
		System.out.println("--------------------------------");
		classList[evol_num].setStatus();
		System.out.println("<진화 후 스탯>");
		System.out.println("power : " + Player.power);
		System.out.println("defense : " + Player.defense);
		System.out.println("hp : " + Player.hp);
		System.out.println("hpMax : " + Player.hpMax);
		System.out.println("mp : " + Player.mp);
		System.out.println("mpMax : " + Player.mpMax);
		System.out.println("--------------------------------");
	}

}

//==============================================================================================================================




public class HPPotion {
	String name = "HP포션";
	int price = 15;//가격
	int healA = 30;//힐량

	public void heal() {
		for (int i = 0; i < healA && Player.hp < Player.hpMax; i++)
			Player.hp += 1;
		Player.hpPotionN -= 1;
	}
}
