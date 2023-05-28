package TeamProject;

import java.util.Scanner;

public class Battle {
	public static void brank() {
		for (int k = 0; k < 1; k++)
			System.out.println();
	}

	private static void printHp(Monster m1, Monster m2) {
		int N = 1000, N1 = 100;// 수치

		String blueHeart = "🟥";// 🔲
		String blankS = "🔲";
		String spade = "🞠";// "🜸";// "\u2664";
		String attack = "🜸";

		for (int k = 0; k < 150; k++)
			System.out.print("█");

		System.out.println("\n");
		System.out.print(m1.tribe + "체력 |");
		int i = 1;
		for (i = 1; i <= (int) (((float) m1.hp / (float) m1.hpMax) * 71); i++) {
			System.out.print(blueHeart);
		}
		for (int j = i + 1; j <= 71 + 1; j++)
			System.out.print(blankS);
		System.out.printf("|%d/%d\n", m1.hp, m1.hpMax);

		System.out.print(m1.tribe + "공격력|");
		for (i = 1; i <= (int) ((float) m1.attack / N * N1); i++) {
			if (0 == i % 116)
				System.out.println();
			System.out.print(attack);
		}
		System.out.printf("|%d\n", m1.attack);

		System.out.print(m1.tribe + "방어력|");
		for (i = 1; i <= (int) ((float) m1.defense / N * N1); i++) {
			if (0 == i % 116)
				System.out.println();
			System.out.print(spade);
		}
		System.out.printf("|%d\n\n", m1.defense);
//==========================================================================================
		System.out.print(Player.name + "체력 |");
		for (i = 1; i <= (int) (((float) m2.hp / (float) m2.hpMax) * 71); i++) {
			System.out.print(blueHeart);
		}
		for (int j = i + 1; j <= 71 + 1; j++)
			System.out.print(blankS);
		System.out.printf("|%d/%d\n", m2.hp, m2.hpMax);

		System.out.print(Player.name + "공격력|");
		for (i = 1; i <= (int) ((float) m2.attack / N * N1); i++) {
			if (0 == i % 116)
				System.out.println();
			System.out.print(attack);
		}
		System.out.printf("|%d\n", m2.attack);

		System.out.print(Player.name + "방어력|");
		for (i = 1; i <= (int) ((float) m2.defense / N * N1); i++) {
			if (0 == i % 116)
				System.out.println();
			System.out.print(spade);
		}
		System.out.printf("|%d\n\n", m2.defense);

		System.out.println();
	}

//🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰
	public static void battle(Monster m1, Monster m2, Achievement ach) {// 배틀 메서드

		Scanner in = new Scanner(System.in);
		System.out.println("\n" + m1.tribe + "와의 전투를 시작합니다.\n");

		if (Player.a != null)
			Player.a.use();
		if (Player.h != null)
			Player.h.use();
		int select;
		Monster m = Player.p;
		int attack_copy = m.attack;
		int defense_copy = m.defense;
		int demage = 0;

		while (true) {
			if (m.기절상태 == 0) {
				printHp(m1, Player.p);
				System.out.println("----- <공격턴> -----");
				m.skill_info();
				System.out.println("4. 공격 전략적 선택지 사용");
				System.out.println("5. 가방");
				System.out.println("6. 스탯");
				System.out.print("선택 : ");
				while (true) {
					select = in.nextInt();
					if (select == 0) {
						demage = m.attack();
						break;
					} else if (select == 1) {
						demage = m.skill01();
						break;
					} else if (select == 2) {
						demage = m.skill02();
						break;
					} else if (select == 3) {
						demage = m.skill03();
						break;
					} else if (select == 4) {
						Strategy_Attack sa = new Strategy_Attack();
						System.out.print("선택 : ");
						int select_num = in.nextInt();
						m.attack = sa.Select_attack(select_num);
						System.out.println("----- <공격턴> -----");
						m.skill_info();
						System.out.print("선택 : ");
						select = in.nextInt();
						if (select == 0) {
							demage = m.attack();
							m.attack = attack_copy; // 원래 공격력으로 복구
							break;
						} else if (select == 1) {
							demage = m.skill01();
							m.attack = attack_copy;
							break;
						} else if (select == 2) {
							demage = m.skill02();
							m.attack = attack_copy;
							break;
						} else if (select == 3) {
							demage = m.skill03();
							m.attack = attack_copy;
							break;
						}
					} else if (select == 5) {
						new ShowInventory();
						continue;
					} else if (select == 6) {
						new ShowStatus();
						continue;
					} else {
						System.out.println("잘못된 숫자를 입력하셨습니다.");
						continue;
					}
				} // 공격턴 while끝
					// ======================================================데미지 적용
				if (m1.defense / 10 < demage) {
					m1.hp -= (demage - m1.defense / 10);
					System.out.println("\"" + (demage - m1.defense / 10) + "\"" + "만큼의 피해를 입혔습니다.");
					brank();
				} else {
					System.out.println("공격이 통하지 않았습니다.");
				}
				printHp(m1, Player.p);// 간단한 체력, 공격력, 방어력 현황

				// =================================================몬스터가 죽으면
				if (m1.hp < 1) {
					System.out.println(m1.tribe + "가 쓰러졌습니다.");
					System.out.println(m1.money + "G를 얻었습니다.");
					System.out.println(m1.expGive + "EXP를 얻었습니다.");
					ach.count(m2.tribe); // 몬스터 처치 시 해당 몬스터 업적 count
					m2.clear = 1; // 몬스터 처치 시 해당 몬스터(level, location) clear 처리
					Player.pMoney += m1.money;
					Player.p.exp += m1.expGive;
					Achievement.count(m1.tribe);
					if (Player.p.exp >= Player.p.expMax)// ==================레벨업
					{
						System.out.printf("\n레벨이 올랐습니다.\n" + "%dLv => %dLv\n\n", Player.p.level, Player.p.level + 1);
						Player.p.level += 1;
						Player.p.attack += Player.p.level * 10;
						Player.p.defense += Player.p.level * 5;
						Player.p.hpMax += 100;
					}
					break;
				}
				// ===============================================플레이어의 방어와 몬스터의 공격
				System.out.println("----- <방어턴> -----");
				System.out.println("1. 체력 포션사용: " + Player.hpPotionN);
				System.out.println("2. 마나 포션사용: " + Player.mpPotionN);
				System.out.println("3. 수류탄 사용 : " + Player.수류탄N);
				System.out.println("4. 방어 전략적 선택지 사용");
				System.out.println("5. 가방");
				System.out.println("6. 스탯");
				System.out.println("0. 턴 넘기기");
				System.out.print("선택 : ");
				while (true) {
					select = in.nextInt();
					demage = 0;
					if (select == 1) {
						if (Player.hpPotionN > 0) {
							HpPotion p1 = new HpPotion();
							p1.use();
							break;
						} else {
							System.out.println("포션이 없습니다.");
							continue;
						}
					} else if (select == 2) {
						if (Player.mpPotionN > 0) {
							MpPotion p2 = new MpPotion();
							p2.use();
							break;
						} else {
							System.out.println("포션이 없습니다.");
							continue;
						}
					} else if (select == 3) {
						if (Player.수류탄N > 0) {
							Grenade p3 = new Grenade();
							p3.use(m1);
						} else {
							System.out.println("수류탄이 없습니다.");
							continue;
						}
						break;
					} else if (select == 4) {
						Strategy_Defense sd = new Strategy_Defense();
						System.out.print("선택 : ");
						int select_num = in.nextInt();
						m.defense = sd.Select_defense(select_num);
						System.out.println("----- <방어턴> -----");
						System.out.println("1. 체력 포션사용: " + Player.hpPotionN);
						System.out.println("2. 마나 포션사용: " + Player.mpPotionN);
						System.out.println("3. 수류탄 사용 : " + Player.수류탄N);
						System.out.println("4. 가방");
						System.out.println("5. 스탯");
						System.out.println("0. 턴 넘기기");
						System.out.print("선택 : ");
						select = in.nextInt();
						if (select == 1) {
							if (Player.hpPotionN > 0) {
								HpPotion p1 = new HpPotion();
								p1.use();
								break;
							} else {
								System.out.println("포션이 없습니다.");
								continue;
							}
						} else if (select == 2) {
							if (Player.mpPotionN > 0) {
								MpPotion p2 = new MpPotion();
								p2.use();
								break;
							} else {
								System.out.println("포션이 없습니다.");
								continue;
							}
						} else if (select == 3) {
							if (Player.수류탄N > 0) {
								Grenade p3 = new Grenade();
								p3.use(m1);
							} else {
								System.out.println("수류탄이 없습니다.");
								continue;
							}
							break;
						} else if (select == 4) {
							new ShowInventory();
							continue;
						} else if (select == 5) {
							new ShowStatus();
							continue;
						} else if (select == 0) {
							break;
						} else {
							System.out.println("잘못된 숫자를 입력하셨습니다.");
							continue;
						}
					} else if (select == 5) {
						new ShowInventory();
						continue;
					} else if (select == 6) {
						new ShowStatus();
						continue;
					} else if (select == 0) {
						break;
					} else {
						System.out.println("잘못된 숫자를 입력하셨습니다.");
						continue;
					}
				} // 방어턴 While끝
			} // 기절상태0

			else// 기절상태 1
			{
				System.out.println("플레이어가 기절했습니다. 아무런 행동도 할 수 없습니다.");
				m.기절상태 = 1;
			}
			// -=-=-=-=-=-=--===================================================플레이어의 공격과
			// 방어까지
			if (m1.기절상태 == 0) {
				System.out.println(m1.tribe + "가 공격합니다.");
				demage = m1.attack();
				if (m.defense / 10 < demage * 10) {
					m.hp -= (demage - (m.defense) / 10);
					System.out.println("\"" + (demage - (m.defense) / 10) + "\"" + "만큼의 피해를 입었습니다.\n");
					m.defense = defense_copy; // 원래 방어력으로 복구
				} else
					System.out.printf("공격이 통하지 않았습니다.\n\n");
				if (m.hp < 1) {
					System.out.println("플레이어가 죽었습니다.");
					Player.p.hp = Player.p.hpMax / 5; // 1/5 회복
					Player.p.exp -= Player.p.expMax / 2;
					if (Player.p.exp < 0)
						Player.p.exp = 0;
					Player.pMoney -= m1.money;
					break;
				}

			} else {
				System.out.println(m1.tribe + "가 기절상태입니다. 턴이 넘어갑니다.");
				m1.기절상태 = 0;
			}
		}
		if (Player.a != null)
			Player.a.unUse();
		if (Player.h != null)
			Player.h.unUse();

		new ShowStatus();
	}

	public static void end1() {
		String message = "인간과 눈이 마주쳤습니다....\n" + "인간이 공격합니다.\n";
		int delay = 100; // 1초 딜레이

		for (int i = 0; i < message.length(); i++) {
			System.out.print(message.charAt(i));

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void end2() {
		String message = "서식지가 파괴되었습니다....      " + "\n종족의 개체수가 빠르게 감소합니다.              "
				+ "\n대기오염으로 인해 더이상 이곳에서 숨을 쉴 수 없습니다...              " + "\n플레이어가 죽었습니다.          "
				+ "\n해당 종이 멸종하여 더이상 부활할 수 없습니다.        " + "\n.............                            "
				+ "\n게임이 종료됩니다.\n";
		int delay = 100; // 1초 딜레이

		for (int i = 0; i < message.length(); i++) {
			System.out.print(message.charAt(i));

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void 공백() {
		String message = " ";
		int delay = 1500; // 1초 딜레이

		for (int i = 0; i < message.length(); i++) {
			System.out.print(message.charAt(i));

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static void battleEnding(Human m1) {
		Scanner in = new Scanner(System.in);
		Print.printBar();
		ImageOutputExample.사람눈();

		System.out.print("Enter를 누르세요.");
		String n = in.nextLine();

		end1();
		공백();
		ImageOutputExample.환경파괴();
		공백();
		ImageOutputExample.공장연기();

		System.out.print("Enter를 누르세요.");
		n = in.nextLine();
		end2();

		System.out.println("전체 플레이 타임: " + Time.allTime);
		Print.printBar();
		new ShowStatus();
		new ShowInventory();
	}
}
