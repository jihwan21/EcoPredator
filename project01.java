// 3-15
// 데미지 리턴 // 무기상점에서 무기 구매 = 공격 번호 선택 / 포션상점 추가 + 레벨업 시스템
package project_01;

import java.util.Random;
import java.util.Scanner;

public class project01 {
	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();
	// 전역 변수 설정
	static int hero_hp, hero_mp, hero_level, hero_power, hero_weaphon_power, hero_defense, hero_money, hero_experience;
	static int monster_hp, monster_mp, monster_Level, monster_power, monster_defense, monster_money, monster_experience;
	static String hero_name, monster_name;

	public static void main(String[] args) {
		System.out.println("*******RPG GAME*******");
		System.out.println("1. 전사");
		System.out.println("2. 마법사");
		System.out.println("3. 암살자");
		System.out.printf("직업의 번호를 입력하세요. : ");
		int class_num = sc.nextInt();
		// 직업 : 전사
		if (class_num == 1) {
			System.out.println("전사가 선택되었습니다.");
			hero_defense = 25;
			hero_power = 15;
			hero_weaphon_power = 5;
			hero_level = 1;
			hero_hp = 80;
			hero_mp = 0;
			hero_money = 0;
			hero_experience = 0;
		}
		// 직업 : 마법사
		else if (class_num == 2) {
			System.out.println("마법사가 선택되었습니다.");
			hero_defense = 15;
			hero_power = 20;
			hero_weaphon_power = 5;
			hero_level = 1;
			hero_hp = 80;
			hero_mp = 50;
			hero_money = 0;
			hero_experience = 0;
		}
		// 직업 : 암살자
		else if (class_num == 3) {
			System.out.println("암살자가 선택되었습니다.");
			hero_defense = 20;
			hero_power = 15;
			hero_weaphon_power = 10;
			hero_level = 1;
			hero_hp = 80;
			hero_mp = 0;
			hero_money = 0;
			hero_experience = 0;
		}

		System.out.printf("영웅의 이름을 입력하세요. : ");
		hero_name = sc.next();
		System.out.println("이름이 입력되었습니다. ");
		System.out.println("게임에 입장하였습니다. ");

		while (true) {
			// 턴이 돌아올 때마다 유저캐릭터 정보 출력 >> 변화 부분 파랑색으로 + 5 해당 항목 옆에 출력되게 구현
			System.out.println("*********************");
			System.out.println("현재 Hero의 이름 : " + hero_name);
			System.out.println("현재 " + hero_name + "의 레벨 : " + hero_level);
			System.out.println("현재 " + hero_name + "의 힘 : " + hero_power);
			System.out.println("현재 " + hero_name + "의 무기 공격력 : " + hero_weaphon_power);
			System.out.println("현재 " + hero_name + "의 방어력 : " + hero_defense);
			System.out.println("현재 " + hero_name + "의 HP : " + hero_hp);
			System.out.println("현재 " + hero_name + "의 MP : " + hero_mp);
			System.out.println("현재 " + hero_name + "의 경험치 : " + hero_experience);
			System.out.println("현재 " + hero_name + "의 돈 : " + hero_money + "원");
			System.out.println("*********************");

			// 입장 장소 선택
			System.out.println("1. 사냥터");
			System.out.println("2. 포션 상점");
			System.out.println("3. 재련소");
			System.out.printf("입장할 장소를 입력하세요 : ");
			int ground = sc.nextInt(); // 장소
			int phaseNum = 1;

			// 사냥터
			if (ground == 1) {
				System.out.println("------ <사냥터> ------");
				System.out.println("사냥터에 입장하였습니다.");
				// 전투할 상대 선택
				System.out.println("1. 너구리");
				System.out.println("2. 살쾡이");
				System.out.println("3. 스켈레톤");
				System.out.println("4. 와이번");
				System.out.println("5. 블랙 드래곤");
				System.out.print("전투할 상대를 입력하세요. : ");
				int monster_num = sc.nextInt();

				System.out.print("반복 전투 횟수를 입력하세요. : ");
				int repeat_num = sc.nextInt(); // 반복 전투 횟수 입력

				if (monster_num == 1) {
					monster_name = "너구리";
					monster_hp = 100;
					monster_Level = 1;
					monster_power = 20;
					monster_defense = 5;
					monster_money = 10;
					monster_experience = 10;
				} else if (monster_num == 2) {
					monster_name = "살쾡이";
					monster_hp = 200;
					monster_Level = 5;
					monster_power = 100;
					monster_defense = 20;
					monster_money = 30;
					monster_experience = 50;
				} else if (monster_num == 3) {
					monster_name = "스켈레톤";
					monster_hp = 4000;
					monster_Level = 10;
					monster_power = 200;
					monster_defense = 50;
					monster_money = 70;
					monster_experience = 100;
				} else if (monster_num == 4) {
					monster_name = "와이번";
					monster_hp = 20000;
					monster_Level = 30;
					monster_power = 700;
					monster_defense = 250;
					monster_money = 500;
					monster_experience = 1000;
				} else if (monster_num == 5) {
					monster_name = "블랙 드래곤";
					monster_hp = 500000;
					monster_Level = 500;
					monster_power = 5000;
					monster_defense = 2000;
					monster_money = 5000;
					monster_experience = 10000;
				}
				System.out.println(monster_name + "와(과) 전투를 시작합니다.");
				// 반복 전투 구현
				while (repeat_num != 0) {
					repeat_num -= 1;
					while (true) {
						System.out.println("------ Battle Phase " + phaseNum + " ------"); // Phase 단계 출력
						phaseNum += 1;
						// 히어로 공격, 몬스터 방어
						System.out.println(hero_name + "의 공격입니다.");
						monster_attacked(hero_attack(class_num));
						// 몬스터 사망
						if (monster_hp <= 0) {
							hero_experience += monster_experience;
							hero_money += monster_money;
							System.out.println(monster_name + "가 사망했습니다.");
							break;
						}
						// 몬스터 공격, 히어로 방어
						System.out.println(monster_name + "의 공격입니다.");
						hero_attacked(monster_attack());
						// 히어로 사망
						if (hero_hp <= 0) {
							hero_hp = 1;
							System.out.println(hero_name + "가 사망했습니다.");
							System.out.println("히어로가 부활하였습니다.");
							break;
						}
					} // 전투 종료
					if (hero_experience >= hero_level * 80) {
						hero_level += 1;
						System.out.println(hero_name + "의 레벨이 " + hero_level + "이 되었습니다.");
						hero_money += hero_level * 50;
						hero_experience = 0;
						System.out.println("레벨업 보상 : power + 5, defense + 5, money + 100");
						hero_power += 5;
						hero_defense += 5;
						hero_money += 100;
					}
				}
				// 전투 시작
//				while (true) {
//					System.out.println("------ Battle Phase " + phaseNum + " ------"); // Phase 단계 출력
//					phaseNum += 1;
//					// 히어로 공격, 몬스터 방어
//					System.out.println(hero_name + "의 공격입니다.");
//					monster_attacked(hero_attack(class_num));
//					// 몬스터 사망
//					if (monster_hp <= 0) {
//						hero_experience += monster_experience;
//						hero_money += monster_money;
//						System.out.println(monster_name + "가 사망했습니다.");
//						break;
//					}
//					// 몬스터 공격, 히어로 방어
//					System.out.println(monster_name + "의 공격입니다.");
//					hero_attacked(monster_attack());
//					// 히어로 사망
//					if (hero_hp <= 0) {
//						hero_hp = 1;
//						System.out.println(hero_name + "가 사망했습니다.");
//						System.out.println("히어로가 부활하였습니다.");
//						break;
//					}
//				} // 전투 종료
				// 히어로 레벨업 프로세스
//				if (hero_experience >= hero_level * 80) {
//					hero_level += 1;
//					System.out.println(hero_name + "의 레벨이 " + hero_level + "이 되었습니다.");
//					hero_money += hero_level * 50;
//					hero_experience = 0;
//					System.out.println("레벨업 보상 : power + 5, defense + 5, money + 100");
//					hero_power += 5;
//					hero_defense += 5;
//					hero_money += 100;
//				}
			}
			// 포션 상점
			else if (ground == 2) {
				System.out.println("------ <포션 상점> ------");
				System.out.println("포션 상점에 입장하였습니다.");
				System.out.println("1. 힘 증강 포션(小) (30원)");
				System.out.println("2. 힘 증강 포션(中) (50원)");
				System.out.println("3. 힘 증강 포션(大) (70원)");
				System.out.println("4. 방어력 증강 포션(小) (30원)");
				System.out.println("5. 방어력 증강 포션(中) (50원)");
				System.out.println("6. 방어력 증강 포션(大) (70원)");
				System.out.println("7. 경험치 증강 포션 (100원)");
				System.out.println("8. HP 증강 포션(小) (10원)");
				System.out.println("9. HP 증강 포션(中) (20원)");
				System.out.println("10. HP 증강 포션(大) (30원)");
				System.out.println("11. MP 증강 포션(小) (10원)");
				System.out.println("12. MP 증강 포션(中) (20원)");
				System.out.println("13. MP 증강 포션(大) (30원)");
				System.out.print("원하시는 물건 번호를 입력하세요. : ");
				int potion_num = sc.nextInt();
				System.out.println("포션 상점에서 물건 구매 시도 중입니다.");
				System.out.println("구매 완료되었습니다.");

				switch (potion_num) {
				case 1 -> hero_power += 2;
				case 2 -> hero_power += 4;
				case 3 -> hero_power += 6;
				case 4 -> hero_defense += 2;
				case 5 -> hero_defense += 4;
				case 6 -> hero_defense += 6;
				case 7 -> hero_experience += 40;
				case 8 -> hero_hp += 20;
				case 9 -> hero_hp += 40;
				case 10 -> hero_hp += 60;
				case 11 -> hero_mp += 10;
				case 12 -> hero_mp += 20;
				case 13 -> hero_mp += 30;
				}

				int kind = switch (potion_num) {
				case 8, 11 -> 10;
				case 9, 12 -> 20;
				case 1, 4, 10, 13 -> 30;
				case 2, 5 -> 50;
				case 3, 6 -> 70;
				case 7 -> 100;
				default -> 0;
				};
				hero_money -= kind;
				System.out.println(hero_money + "원 남았습니다.");
			}
			// 재련소 : 돈을 이용해 hero_weaphon_power 수치 강화
			else if (ground == 3) {
				System.out.println("------ <재련소> ------");
				System.out.println("재련소에 입장하였습니다.");
				System.out.println("강화 비용 : 50원");
				System.out.print("강화를 시도하겠습니까? y/n : ");
				String permission = sc.next();
				// 강화 시도를 선택한 경우
				if (permission.equals("y") && hero_money >= 50) {// 강화 시도를 선택하였을때 돈이 50원 이상일때만 강화 가능하도록 조건 설정
					if (random.nextInt(10) == 0) { // random_num가 0이면 hero_weaphon_power 5만큼 강화, 50원 차감
						hero_weaphon_power += 5;
						hero_money -= 50;
						System.out.println("강화에 성공하였습니다!");
						System.out.println("무기 공격력 : " + (hero_weaphon_power - 5) + " -> " + hero_weaphon_power);
					} else {
						hero_money -= 50;
						System.out.println("강화에 실패하였습니다.");
					}
				}
				// 강화 시도를 선택하였으나 돈이 부족한 경우
				else if (permission.equals("y") && hero_money < 50) {
					System.out.println("강화 비용이 부족합니다.");
				}
				// 강화 시도를 선택하지 않은 경우
				else
					System.out.println("재련소를 벗어났습니다.");
			}
		}
	}

	// 히어로 공격 정적 메소드
	static int hero_attack(int class_num) {
		int damage_sum = 0;
		if (class_num == 1) { // 전사 스킬
			System.out.println("<전사 스킬 목록>");
			System.out.println("1. 쓰러스트(공격력 10)");
			System.out.println("2. 허리케인 소드(공격력 15)");
			System.out.println("3. 길로틴(공격력 20)");
			System.out.print("스킬 번호를 입력하세요. : ");
			int attack_num = sc.nextInt();
			int kind = switch (attack_num) {
			case 1 -> 10;
			case 2 -> 15;
			case 3 -> 20;
			default -> 0;
			};
			// 선택한 스킬의 공격력 반영
			// 데지미 계산식에 무기 공격력과 스킬 공격력 추가
			damage_sum = (hero_level * 10) + ((hero_power + hero_weaphon_power + kind) * 30);
			System.out.println("데미지 : " + damage_sum);
		} // 마법사 스킬
		else if (class_num == 2) {
			System.out.println("<마법사 스킬 목록>");
			System.out.println("1. 인페르노(공격력 10 / mp 5 소모)");
			System.out.println("2. 블레이즈(공격력 15 / mp 7 소모)");
			System.out.println("3. 종말의 날(공격력 30 / mp 10 소모)");
			if (hero_mp <= 0) {
				System.out.println("MP가 부족합니다.");
			} else {
				System.out.print("스킬 번호를 입력하세요. : ");
				int attack_num = sc.nextInt();
				// 공격력 switch문
				int power = switch (attack_num) {
				case 1 -> 10;
				case 2 -> 15;
				case 3 -> 30;
				default -> 0;
				};
				// mp switch문
				int mp = switch (attack_num) {
				case 1 -> 5;
				case 2 -> 7;
				case 3 -> 10;
				default -> 0;
				};
				hero_mp -= mp; // 선택한 스킬 사용시 mp 소모
				damage_sum = (hero_level * 10) + ((hero_power + hero_weaphon_power + power) * 30);
				System.out.println("데미지 : " + damage_sum);
			}
		} // 암살자 스킬
		else {
			System.out.println("<암살자 스킬 목록>");
			System.out.println("1. 슬래쉬(공격력 7)");
			System.out.println("2. 폴스타(공격력 17)");
			System.out.println("3. 버스트(공격력 25)");
			System.out.print("스킬 번호를 입력하세요. : ");
			int attack_num = sc.nextInt();
			int kind = switch (attack_num) {
			case 1 -> 7;
			case 2 -> 17;
			case 3 -> 25;
			default -> 0;
			};
			damage_sum = (hero_level * 10) + ((hero_power + hero_weaphon_power + kind) * 30);
			System.out.println("데미지 : " + damage_sum);
		}
		return damage_sum;
	}

	// 히어로 방어 정적 메소드
	static void hero_attacked(int monster_power) {
		if (hero_defense >= monster_power) {
			System.out.println(monster_name + "의 공격이 빗나갔습니다.");
		} else {
			hero_hp = hero_hp + hero_defense - monster_power;
		}
	}

	// 몬스터 공격 정적 메소드
	static int monster_attack() {
		System.out.println("데미지 : " + monster_power);
		return monster_power;
	}

	// 몬스터 방어 정적 메소드
	static void monster_attacked(int damage_sum) {
		if (monster_defense >= damage_sum) {
			System.out.println(hero_name + "의 공격이 빗나갔습니다.");
		} else {
			monster_hp = monster_hp + monster_defense - damage_sum;
		}
	}
}
