package TeamProject;

public class Item {
	int price;
	String name;
	int 개수;
}

class Equipment extends Item {
	String name;
}

class UseItem extends Item {
	String name;// 이름
	int amount;// 힐량
}

class Gaho extends Item {
	int amount;

	Gaho() {
		this.name = "가호";
		this.price = 1000000;
		this.amount = 2100000000;
	}

	public void use() {
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

//////===================================================================================================
class HpPotion extends UseItem {
	HpPotion() {
		name = "HP포션";
		price = 15;// 임의 가격
		amount = Player.p.hpMax / 5;// 체력의 약 1/5회복
	}

	public void use() {
		for (int i = 0; i < amount && Player.p.hp < Player.p.hpMax; i++)
			Player.p.hp += 1;
		Player.hpPotionN--;// 포션개수
	}
}

//////===================================================================================================
class MpPotion extends UseItem {
	MpPotion() {
		name = "MP포션";
		price = 15;// 임의 가격
		amount = 15;
	}

	public void use() {
		for (int i = 0; i < amount && Player.p.mp < Player.p.mpMax; i++)
			Player.p.mp += 1;
		Player.mpPotionN--;// 포션개수
	}
}

//////===================================================================================================
class Grenade extends UseItem {

	int demage;

	Grenade() {
		name = "수류탄";
		price = 15;
		demage = 10;
	}

	public int use(Monster m1) {
		m1.hp -= demage;
		Player.수류탄N--;
		m1.attack = m1.attack * 3;
		m1.기절상태 = 1;
		return demage;
	}

}
//////===================================================================================================

class Armor extends Equipment {
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

	void use() {
		Player.p.defense += this.defense + this.reinforceN;
	}

	void unUse() {
		Player.p.defense -= this.defense + this.reinforceN;
	}
}

//////===================================================================================================
class Headpiece extends Armor {

	Headpiece() {
		this.lv = 1;
		this.name = "투구";
		this.defense = 50;
		this.price = 100;
		this.reinforceP = 20;
		this.reinforceN = 5;
	}
}

//////===================================================================================================
class 아가미 extends Equipment {
	int flag;

	아가미() {
		this.name = "아가미";
		this.flag = 0;
		this.price = 100;
	}
}

//////===================================================================================================
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
