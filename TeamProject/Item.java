package TeamProject;

public class Item {//아이템 클래스(슈퍼클래스)
	int price;
	String name;
	int 개수;
}

class Equipment extends Item {//아이템을 장비아이템과 사용아이템으로 나누기 위해 만듦
	String name;
}

class UseItem extends Item {//아이템을 장비아이템과 사용아이템으로 나누기 위해 만듦
	String name;// 이름
	int amount;// 힐량
}

class Gaho extends Item {//가호아이템
	int amount;

	Gaho() {
		this.name = "가호";
		this.price = 1000000;
		this.amount = 2100000000;
	}
	
	//아이템 사용  메서드
	public void use() {
		//공격력 방어력 체력을 크게줌올려줌
		Player.p.attack = amount;
		Player.p.defense = amount;
		Player.p.hpMax = amount;
		Player.pMoney = 1000;
		Player.style = "가호를 받는";
		Print.printBar();
		System.out.println("가호가 내려 옵니다.");
		System.out.println("당신은 무지무지 쎄졌습니다.");
		System.out.println("당신의 칭호가 \"가호를 받는\"으로 변경되었습니다.");

	}
}

//////===================================================================================================체력 포션
class HpPotion extends UseItem {
	HpPotion() {
		name = "HP포션";
		price = 15;// 임의 가격
		amount = Player.p.hpMax / 5;// 체력의 약 1/5회복
	}

	public void use() {//사용시 최대체력의 1/복회복
		for (int i = 0; i < amount && Player.p.hp < Player.p.hpMax; i++)
			Player.p.hp += 1;
		Player.hpPotionN--;// 포션개수
	}
}

//////===================================================================================================마나 포션
class MpPotion extends UseItem {
	MpPotion() {
		name = "MP포션";
		price = 15;// 임의 가격
		amount = 15;
	}

	public void use() {//사용시 amount변수만큼 마나 복회복
		for (int i = 0; i < amount && Player.p.mp < Player.p.mpMax; i++)
			Player.p.mp += 1;
		Player.mpPotionN--;// 포션개수
	}
}

//////===================================================================================================기절 수류탄
class Grenade extends UseItem {//

	int demage;

	Grenade() {
		name = "수류탄";
		price = 15;
		demage = 10;
	}

	public int use(Monster m1) {//몬스터 객체를 받아옴//전투메서드에서 사용
		m1.hp -= demage;
		Player.수류탄N--;
		m1.attack = m1.attack * 3;//어드벤티지로 몬스터의 공격력 3배배
		m1.기절상태 = 1;//몬스터를 기절상태로 만듦
		return demage;//데미지를 주고
	}

}
//////==================================================================================================옷갑옷

class Armor extends Equipment {//
	//방어력, 아이템 레벨, 강화가격, 강화수치 등이 있음
	int defense;
	int lv;
	int reinforceP;
	int reinforceN;

	Armor() {
		this.lv = 1;
		this.name = "갑옷";
		this.defense = 100;
		this.price = 100;
		this.reinforceP = 50;
		this.reinforceN = 10;
	}

	void use() {//전투 메서드에서 사용// 사용시 플레이어 방어력 증가
		Player.p.defense += this.defense + this.reinforceN;
	}

	void unUse() {//전투 메서드에서 사용// 사용시 플레이어 방어력 원래대로 되돌려 음놓음
		Player.p.defense -= this.defense + this.reinforceN;
	}
}

//////===================================================================================================투구
class Headpiece extends Armor {//갑옷과 기본 능력치 강화가격 말고 거의 동일

	Headpiece() {
		this.lv = 1;
		this.name = "투구";
		this.defense = 50;
		this.price = 100;
		this.reinforceP = 20;
		this.reinforceN = 5;
	}
}

//////===================================================================================================아가미
class 아가미 extends Equipment {
	int flag;

	아가미() {
		this.name = "아가미";
		this.flag = 0;
		this.price = 100;
	}
}

//////===================================================================================================날개
class 날개 extends Equipment {
	int flag;

	날개() {
		this.name = "날개";
		this.flag = 0;
		this.price = 100;
	}
}

//////===================================================================================================
class 어항 extends Equipment {
	int flag;

	어항() {
		this.name = "어항";
		this.flag = 0;
		this.price = 100;
	}
}
