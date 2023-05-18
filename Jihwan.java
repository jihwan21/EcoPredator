package test;

import java.util.Scanner;

class Monster {
	String name;
	int hp;
	int hpMax;
	int mp;
	int mpMax;
	int power;
	int defense;
	int experience;

	public Monster(String name, int hp, int hpMax, int mp, int mpMax, int power, int defense, int experience) {
		this.name = name;
		this.hp = hp;
		this.hpMax = hpMax;
		this.mp = mp;
		this.mpMax = mpMax;
		this.power = power;
		this.defense = defense;
		this.experience = experience;
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
	int experience;

	public ClassArray(Achievement obj, Monster obj_) {
		this.name = obj.achievement_name;
		this.count = obj.achivement_count;
		this.hp = obj_.hp;
		this.hpMax = obj_.hpMax;
		this.mp = obj_.mp;
		this.mpMax = obj_.mpMax;
		this.power = obj_.power;
		this.defense = obj_.defense;
		this.experience = obj_.experience;

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
		Monster tiger = new Monster("tiger", 1000, 1000, 200, 200, 500, 500, 1000);
		Monster bear = new Monster("bear", 1000, 1000, 200, 200, 500, 500, 1000);
		Monster eagle = new Monster("eagle", 1000, 1000, 200, 200, 500, 500, 1000);
		Achievement tiger_ach = new Achievement(tiger);
		Achievement bear_ach = new Achievement(bear);
		Achievement eagle_ach = new Achievement(eagle);
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
