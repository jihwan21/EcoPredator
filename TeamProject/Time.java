package TeamProject;

//시간 클래스
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
	String tribe;
	int level, power, defense, money, hp, hpMax, mp, mpMax, exp;
	// 체력/최대체력, 마나/최대마나
	int upgradeS01, upgradeS02, upgradeS03;
	int location;
	int attack;
	int expMax = 100;
	int expGive = 10;
	int clear = 0; // 0이면 한 번도 잡지 않은 상태, 1이면 한 번 이상 잡은 상태
	int count = 0;
	int Nocturnality; // 1 : 야행성, 0 : 주행성
	int 기절상태;

	int 아가미N;
	int 어항N;
	int 날개N;

	// 몬스터 스킬 정보
	void skill_info() {
		;
	}

	public int skill01() {
		return 0;
	};

	public int skill02() {
		return 0;
	};

	public int skill03() {
		return 0;
	};

	int attack() {
		return attack;
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
}

// location: 지역 (1: 서울, 2: 강원도, 3: 충청도, 4: 전라도, 5: 경상도, 6: 제주도)
// 기본 능력치: 1,2 지역 기준 3,4 = 기준 * 10, 5,6 * 100
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

	int attack() {
		return attack;
	}

	public int skill01() {// 몬스터 고유스킬 흡혈공격
		int attack_upgrade = attack + upgradeS01;
		this.mp -= 10;
		if (this.hp > this.hpMax)
			this.hp = this.hpMax;
		else
			this.hp += attack_upgrade / 2;// 입힌피해만큼 회복
		return attack_upgrade;// 데미지 리턴
	}

	public void printM() {
		;
	}
}
