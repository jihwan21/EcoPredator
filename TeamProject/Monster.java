package TeamProject;

class Monster extends Time {
	// 종족
	String tribe;
	
	// 레벨, 공격력, 방어력, 돈, 체력, 최대체력, 마나, 최대마나, 경험치
	int level, power, defense, money, hp, hpMax, mp, mpMax, exp;
	
	// 스킬강화1/2/3
	int upgradeS01, upgradeS02, upgradeS03;
	
	// 지역
	int location;
	
	// 공격시 피해
	int attack;
	int expMax = 100;
	int expGive = 10;
	int clear = 0; // 0이면 한 번도 잡지 않은 상태, 1이면 한 번 이상 잡은 상태
	int count = 0; // 업적 처치 횟수 카운트
	int Nocturnality; // 1 : 야행성, 0 : 주행성
	int 기절상태;

	// 몬스터 스킬 정보
	void skill_info() {
		;
	}
	
	// 스킬1 메서드
	public int skill01() {
		return 0;
	};
	
	// 스킬2 메서드
	public int skill02() {
		return 0;
	};

	// 스킬3 메서드
	public int skill03() {
		return 0;
	};

	// 공격 메서드
	int attack() {
		return attack;
	}
	
	// 현재 time에 맞는 power return > 전투 공격력 산출 시 활용
	int current_power() { 
		int power_copy = power;
		if (super.current_time() <= 6) { // time이 낮인 경우
			if (Nocturnality == 0) { // 낮이면서 주행성 동물
				power_copy = (int) (power_copy * 1.1);
			} else if (Nocturnality == 1) { // 낮이면서 야행성 동물
				power_copy = (int) (power_copy * 0.9);
			}
		} else if (super.current_time() > 6) { // time이 밤인 경우
			if (Nocturnality == 0) { // 밤이면서 주행성 동물
				power_copy = (int) (power_copy * 0.9);
			} else if (Nocturnality == 1) { // 밤이면서 야행성 동물
				power_copy = (int) (power_copy * 1.1);
			}
		}
		return power_copy;
	}
}

// location: 지역 (1: 서울, 2: 강원도, 3: 충청도, 4: 전라도, 5: 경상도, 6: 제주도)
// 기본 능력치: 1,2 지역 기준 3,4 = 기준 * 10, 5,6 * 100

// 몬스터 클래스를 상속받는 하위 몬스터별 클래스
// 모기
class Mosquito extends Monster {
	Mosquito(int level, int location) {
		this.tribe = "모기";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 5 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 스킬 리스트
	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 흡혈공격: 피해량만큼 체력 회복, 사용 mp: 10");
	}
	
	// 일반 공격
	int attack() {
		return attack;
	}
	
	// 몬스터 고유스킬 흡혈공격
	public int skill01() {
		int attack_upgrade = attack + upgradeS01;
		this.mp -= 10;
		this.hp += attack_upgrade / 2; // 입힌피해만큼 회복
		if (this.hp > this.hpMax)
			this.hp = this.hpMax;
		return attack_upgrade;// 데미지 리턴
	}
}

// 하루살이
class Mayfly extends Monster {
	Mayfly(int level, int location) {
		this.tribe = "하루살이";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 분신술: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬 분신술
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

// 바퀴벌레
class Roach extends Monster {
	Roach(int level, int location) {
		this.tribe = "바퀴벌레";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 거대화: 체력 +50, 사용 mp: 10");
	}

	// 최대체력 증가, 체력 회복
	public int skill01() {
		this.hp += (50 + upgradeS01);
		this.mp -= 10;
		return 0;
	}
}

//나비
class Butterfly extends Monster {
	Butterfly(int level, int location) {
		this.tribe = "나비";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 날아다니기: 방어력 +1, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬 도망다니기
		this.defense += 1;
		this.mp -= 10;
		return 0;
	}
}

//꿀벌 
class Honeybee extends Monster {
	Honeybee(int level, int location) {
		this.tribe = "꿀법";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 벌침쏘기: 공격력 3배 피해, 체력 -25, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬 벌침쏘기
		int attack_upgrade = (3 * attack) + upgradeS01;
		this.hp -= 25;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//거미
class Spider extends Monster {
	Spider(int level, int location) {
		this.tribe = "거미";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 거미줄치기: 방어력 +2, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (2 + upgradeS01);
		this.mp -= 10;
		return 0;
	}
}

//쥐
class Mouse extends Monster {
	Mouse(int level, int location) {
		this.tribe = "쥐";
		this.Nocturnality = 1;
		this.level = level;
		if (location == 1) {
			this.power = 10 * level * location;
			this.defense = 10 * level * location;
			this.money = 10 * location;
			this.hp = this.hpMax = 100 * level * location;
		} else if (location == 3 || location == 4) {
			this.power = 100 * level * location;
			this.defense = 100 * level * location;
			this.money = 100 * location;
			this.hp = this.hpMax = 1000 * level * location;
		}
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 물어뜯기: 공격력 2배 피해, 사용 mp: 10");
		if (location == 1) {
			System.out.println("2. 쥐구멍 숨기: 방어력 +4, 사용 mp: 20");
		}
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.defense += (4 + upgradeS02);
		this.mp -= 20;
		return 0;
	}
}

//고양이
class Cat extends Monster {
	Cat(int level, int location) {
		this.tribe = "고양이";
		this.Nocturnality = 1;
		this.level = level;
		if (location == 1) {
			this.power = 10 * level * location;
			this.defense = 10 * level * location;
			this.money = 10 * location;
			this.hp = this.hpMax = 100 * level * location;
		} else if (location == 3 || location == 4) {
			this.power = 100 * level * location;
			this.defense = 100 * level * location;
			this.money = 100 * location;
			this.hp = this.hpMax = 1000 * level * location;
		}
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 할퀴기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 쥐잡기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//얼룩말
class Zebra extends Monster {
	Zebra(int level, int location) {
		this.tribe = "얼룩말";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 숙면: 체력 +75, 사용 mp: 10");
		System.out.println("2. 짓밟기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 뒷발차기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		this.hp += 75;
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//붕어
class Carp extends Monster {
	Carp(int level, int location) {
		this.tribe = "붕어";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 죽은척하기: 방어력 +3, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (3 + upgradeS01);
		this.mp -= 10;
		return 0;
	}
}

//악어거북
class Alligator_turtle extends Monster {
	Alligator_turtle(int level, int location) {
		this.tribe = "악어거북";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 등껍질에 숨기: 방어력 +6, 사용 mp: 10");
		System.out.println("2. 깨물기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (6 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//수달
class Otter extends Monster {
	Otter(int level, int location) {
		this.tribe = "수달";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 물고기먹기: 체력 +100, 사용 mp: 20");
		System.out.println("3. 사냥: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.hp += (100 + upgradeS02);
		this.mp -= 20;
		return 0;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//박쥐
class Bat extends Monster {
	Bat(int level, int location) {
		this.tribe = "박쥐";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 초음파 공격: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//비둘기
class Pigeon extends Monster {
	Pigeon(int level, int location) {
		this.tribe = "비둘기";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 바람 일으키기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 똥싸기: 공격력 4배 피해, 체력 -50, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS02;
		this.hp -= (50 - upgradeS02);
		this.mp -= 20;
		return attack_upgrade;
	}
}

//황조롱이
class Kestrel extends Monster {
	Kestrel(int level, int location) {
		this.tribe = "황조롱이";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 바람 일으키기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 똥싸기: 공격력 4배 피해, 체력 -50, 사용 mp: 20");
		System.out.println("3. 사냥: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS02;
		this.hp -= (50 - upgradeS02);
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//다람쥐 클래스
class Squirrel extends Monster {
	Squirrel(int level, int location) {
		this.tribe = "다람쥐";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 도토리던지기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//산양 클래스
class Goat extends Monster {
	Goat(int level, int location) {
		this.tribe = "산양";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 10 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 뒷발차기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 뿔로 박치기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//호랑이 클래스
class Tiger extends Monster {
	Tiger(int level, int location) {
		this.tribe = "호랑이";
		this.Nocturnality = 1;
		this.level = level;
		if (location == 2) {
			this.power = 10 * level * location;
			this.defense = 10 * level * location;
			this.money = 10 * location;
			this.hp = this.hpMax = 100 * level * location;
		} else if (location == 4) {
			this.power = 100 * level * location;
			this.defense = 100 * level * location;
			this.money = 100 * location;
			this.hp = this.hpMax = 1000 * level * location;
		}
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		if (location == 1) {
			System.out.println("1. 핥기: 방어력 +10, 사용 mp: 10");
		} else if (location == 5) {
			System.out.println("1. 핥기: 방어력 +35, 사용 mp: 10");
		}
		System.out.println("2. 앞발치기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 잡아먹기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		if (location == 1) {
			this.defense += (10 + upgradeS01);
		} else if (location == 5) {
			this.defense += (35 + upgradeS01);
		}
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//우럭 클래스
class RockFish extends Monster {
	RockFish(int level, int location) {
		this.tribe = "우럭";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 헤엄치기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//오징어 클래스
class Squid extends Monster {
	Squid(int level, int location) {
		this.tribe = "오징어";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 헤엄치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 먹물뿌리기: 공격력 4배 피해, 체력 - 100, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS02;
		this.hp -= (100 - upgradeS02);
		this.mp -= 20;
		return attack_upgrade;
	}
}

//상어 클래스
class Shark extends Monster {
	Shark(int level, int location) {
		this.tribe = "상어";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 입벌리고 위협하기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 잡아먹기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//꾀꼬리 클래스
class Nightingale extends Monster {
	Nightingale(int level, int location) {
		this.tribe = "꾀꼬리";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 노래부르기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//부엉이 클래스
class Owl extends Monster {
	Owl(int level, int location) {
		this.tribe = "부엉이";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 탐색: 체력 +200, 사용 mp: 10");
		System.out.println("2. 사냥: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		this.hp += (200 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//독수리 클래스
class Eagle extends Monster {
	Eagle(int level, int location) {
		this.tribe = "독수리";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 10 * level * location;
		this.defense = 10 * level * location;
		this.money = 10 * location;
		this.hp = this.hpMax = 100 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 높이 날기: 방어력 +15, 사용 mp: 10");
		System.out.println("2. 발톱으로 잡기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 사냥: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (15 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//멧돼지 클래스
class Boar extends Monster {
	Boar(int level, int location) {
		this.tribe = "멧돼지";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 울음소리내기: 방어력 +20, 사용 mp: 10");
		System.out.println("2. 몸통박치기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 짓밟기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (20 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//잉어 클래스
class Carp2 extends Monster {
	Carp2(int level, int location) {
		this.tribe = "잉어";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 1000;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 죽은척하기: 방어력 +25, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (25 + upgradeS01);
		this.mp -= 10;
		return 0;
	}
}

//쏘가리 클래스
class Mandarin_fish extends Monster {
	Mandarin_fish(int level, int location) {
		this.tribe = "쏘가리";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 요리조리 헤엄치기: 방어력 +30, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.defense += (30 + upgradeS02);
		this.mp -= 20;
		return 0;
	}
}

//뉴트리아 클래스
class Nutria extends Monster {
	Nutria(int level, int location) {
		this.tribe = "뉴트리아";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 헤엄치기: 방어력 +30, 공격x, 사용 mp: 20");
		System.out.println("3. 집어삼키기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.defense += (30 + upgradeS02);
		this.mp -= 10;
		return 0;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//물총새 클래스
class Kingfisher extends Monster {
	Kingfisher(int level, int location) {
		this.tribe = "물총새";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 빠르게 날기: 방어력 +25, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (25 + upgradeS01);
		this.mp -= 10;
		return 0;
	}
}

//두루미 클래스
class Crane extends Monster {
	Crane(int level, int location) {
		this.tribe = "두루미";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 날개펼치기: 방어력 +30, 사용 mp: 10");
		System.out.println("2. 사냥: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (30 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//매 클래스
class Falcon extends Monster {
	Falcon(int level, int location) {
		this.tribe = "매";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 높이 날기: 방어력 +25, 사용 mp: 10");
		System.out.println("2. 발톱으로 잡기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 사냥: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (25 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//구렁이 클래스
class Snake extends Monster {
	Snake(int level, int location) {
		this.tribe = "구렁이";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 혓바닥 내밀기: 방어력 +30, 사용 mp: 10");
		System.out.println("2. 집어삼키기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (35 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//세발낙지 클래스
class Raw_Octopus extends Monster {
	Raw_Octopus(int level, int location) {
		this.tribe = "세발낙지";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 달라붙기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//복어 클래스
class BlowFish extends Monster {
	BlowFish(int level, int location) {
		this.tribe = "복어";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸집키우기: 체력 +300, 사용 mp: 10");
		System.out.println("2. 독 뿜기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		this.hp += (300 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//귀신고래 클래스
class Gray_Whale extends Monster {
	Gray_Whale(int level, int location) {
		this.tribe = "귀신고래";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 사라지기: 방어력 +45, 사용 mp: 10");
		System.out.println("2. 꼬리치기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 집어삼키기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (45 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//고추잠자리 클래스
class Red_Dragonfly extends Monster {
	Red_Dragonfly(int level, int location) {
		this.tribe = "고추잠자리";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 바람일으키기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//제비 클래스
class Swallow extends Monster {
	Swallow(int level, int location) {
		this.tribe = "제비";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 빠르게 날기: 방어력 +45, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.defense += (45 + upgradeS02);
		this.mp -= 20;
		return 0;
	}
}

//백조 클래스
class Swan extends Monster {
	Swan(int level, int location) {
		this.tribe = "백조";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 100 * level * location;
		this.defense = 100 * level * location;
		this.money = 100 * location;
		this.hp = this.hpMax = 1000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 부리찍기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 날개펼치기: 방어력 +50, 사용 mp: 20");
		System.out.println("3. 사냥: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.defense += (50 + upgradeS02);
		this.mp -= 20;
		return 0;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//하늘다림쥐 클래스
class Flying_Squirrel extends Monster {
	Flying_Squirrel(int level, int location) {
		this.tribe = "하늘다람쥐";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 도토리던지기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//노루 클래스
class Deer extends Monster {
	Deer(int level, int location) {
		this.tribe = "노루";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 뛰어다니기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 짓밟기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//반달가슴곰 클래스
class Thibetanus extends Monster {
	Thibetanus(int level, int location) {
		this.tribe = "반달가슴곰";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 물기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 꿀 먹기: 체력 +450, 사용 mp: 20");
		System.out.println("3. 후려치기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.hp += (450 + upgradeS02);
		this.mp -= 20;
		return 0;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//가오리 클래스
class Ray extends Monster {
	Ray(int level, int location) {
		this.tribe = "가오리";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 꼬리찌르기: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//전기뱀장어 클래스
class Electric_ell extends Monster {
	Electric_ell(int level, int location) {
		this.tribe = "전기뱀장어";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 헤엄치기: 방어력 +55, 사용 mp: 10");
		System.out.println("2. 전기방출: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		this.defense += (55 + upgradeS01);
		this.mp -= 10;
		return 0;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//범고래 클래스
class Orca extends Monster {
	Orca(int level, int location) {
		this.tribe = "범고래";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 장난치기: 체력 +500, 사용 mp: 20");
		System.out.println("3. 사냥: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		this.hp += (500 + upgradeS02);
		this.mp -= 20;
		return 0;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//갈매기 클래스
class Gull extends Monster {
	Gull(int level, int location) {
		this.tribe = "갈매기";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 끼룩끼룩: 공격력 2배 피해, 사용 mp: 10");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}
}

//알바트로스 클래스
class Albatross extends Monster {
	Albatross(int level, int location) {
		this.tribe = "알바트로스";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 바람 일으키기: 공격력 3배 피해, 사용 mp: 20");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS02;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}
}

//펠리컨 클래스
class Pelican extends Monster {
	Pelican(int level, int location) {
		this.tribe = "펠리컨";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 몸통박치기: 공격력 2배 피해, 사용 mp: 10");
		System.out.println("2. 부리찍기: 공격력 3배 피해, 사용 mp: 20");
		System.out.println("3. 꿀꺽 삼키기: 공격력 4배 피해, 사용 mp: 30");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (2 * attack) + upgradeS01;
		this.mp -= 10;
		return attack_upgrade;
	}

	public int skill02() {// 몬스터 고유스킬
		int attack_upgrade = (3 * attack) + upgradeS02;
		this.mp -= 20;
		return attack_upgrade;
	}

	public int skill03() {// 몬스터 고유스킬
		int attack_upgrade = (4 * attack) + upgradeS03;
		this.mp -= 30;
		return attack_upgrade;
	}
}

//렌트카 클래스
class RentCar extends Monster {
	RentCar(int level, int location) {
		this.tribe = "렌트카";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 50km 주행: 공격력 50배 피해, 사용 mp: 100");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (50 * attack) + upgradeS01;
		this.mp -= 100;
		return attack_upgrade;
	}
}

// 관광용 잠수함 클래스
class Submarine extends Monster {
	Submarine(int level, int location) {
		this.tribe = "관광용 잠수함";
		this.Nocturnality = 1;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 관광객의 카메라 flash: 공격력 50배 피해, 사용 mp: 100");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (50 * attack) + upgradeS01;
		this.mp -= 100;
		return attack_upgrade;
	}
}

//제주항공 여객기 클래스
class JEJU_airline_plane extends Monster {
	JEJU_airline_plane(int level, int location) {
		this.tribe = "제주항공 여객기";
		this.Nocturnality = 0;
		this.level = level;
		this.power = 1000 * level * location;
		this.defense = 1000 * level * location;
		this.money = 1000 * location;
		this.hp = this.hpMax = 10000 * level * location;
		this.mp = this.mpMax = 100;
		this.expMax = 50 * level * location;
		this.expGive = 10;
		this.upgradeS01 = 0;
		this.attack = current_power();
	}

	// 일반 공격
	int attack() {
		return attack;
	}

	void skill_info() {
		System.out.println("0. 일반공격");
		System.out.println("1. 이륙: 공격력 50배 피해, 사용 mp: 100");
	}

	public int skill01() {// 몬스터 고유스킬
		int attack_upgrade = (50 * attack) + upgradeS01;
		this.mp -= 100;
		return attack_upgrade;
	}
}

//인간 클래스
class Human extends Monster {
	Human() {
		this.tribe = "인간";
		this.Nocturnality = 1;
		this.level = 999999999;
		this.power = 999999999;
		this.defense = 999999999;
		this.money = 999999999;
		this.hp = this.hpMax = 999999999;
	}

	// 일반 공격
	int attack() {
		return power;
	}

	void skill_info() {
		System.out.println("0. 멸종");
	}
}
