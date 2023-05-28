package TeamProject;

import java.util.Scanner;

class Shop extends Item {
	private UseItem HpPotion, MpPotion, Grenade;
	private Equipment 아가미, 날개, 어항, Headpiece, Armor;
	private Gaho 가호;

	Shop() {
		this.HpPotion = new HpPotion();
		this.MpPotion = new MpPotion();
		this.Grenade = new Grenade();

		this.Headpiece = new Headpiece();
		this.Armor = new Armor();

		this.날개 = new 날개();
		this.아가미 = new 아가미();
		this.어항 = new 어항();

		this.가호 = new Gaho();

	}

	void selectItem() {// 아이템 선택

		Scanner in = new Scanner(System.in);
		System.out.println("구매할 품목을 선택해주세요.");
		showItemList();
		int s = in.nextInt(), num = 1;
		if (s == 1 || s == 2 || s == 3) {
			System.out.println("구매 수량을 선택해 주세요.");
			num = in.nextInt();
		}
		if (s == 1) {
			purchase(HpPotion, num);// 구매
			Player.hpPotionN += num;// 물건 넣어주기
		} else if (s == 2) {
			purchase(MpPotion, num);
			Player.mpPotionN += num;
		} else if (s == 3) {
			if (Player.수류탄N == 5 || Player.수류탄N + num > 5)
				System.out.println("수류탄은 최대 5개까지 소지가능합니다.");
			else {
				purchase(Grenade, num);
				Player.수류탄N += num;
			}
		} else if (s == 4 && Player.투구N == 0) {
			purchase(Headpiece, num);
			Player.투구N += num;
			Player.h = new Headpiece();
		} else if (s == 5 && Player.갑옷N == 0) {
			purchase(Armor, num);
			Player.갑옷N += num;
			Player.a = new Armor();
		} else if (s == 6 && Player.날개N == 0) {
			purchase(날개, num);
			Player.날개N += num * 10;
		} else if (s == 7 && Player.아가미N == 0) {
			purchase(아가미, num);
			Player.아가미N += num * 10;
		} else if (s == 8 && Player.어항N == 0) {
			purchase(어항, num);
			Player.어항N += num * 10;
		} else if (s == 9) {
			purchase(가호, num);
			가호.use();
		} else
			System.out.println("상점에서 나갑니다.");
		new ShowInventory();
	}

	private void showItemList() {
		System.out.println("1.HP포션: " + HpPotion.price + "G");
		System.out.println("2.MP포션: " + MpPotion.price + "G");
		System.out.println("3.수류탄: " + Grenade.price + "G");
		System.out.println("4.투구: " + Headpiece.price + "G");
		System.out.println("5.갑옷: " + Armor.price + "G");
		System.out.println("6.날개: " + 날개.price + "G");
		System.out.println("7.아가미: " + 아가미.price + "G");
		System.out.println("8.어항: " + 어항.price + "G");
		System.out.println("9.가호: " + 가호.price + "G");
		System.out.println("0.상점 나가기");
	}

	private void purchase(Item i, int num) {// 아이템과 구매수량
		if ((i.price * num) > Player.pMoney)
			System.out.println("돈이 부족합니다.");
		else {
			Player.pMoney -= i.price * num;
		}
		System.out.println("사용한 돈 : " + i.price * num + "G");
		System.out.println(i.name + "구매완료\n");
	}

}
