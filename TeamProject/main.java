package TeamProject;

import java.util.Scanner;

public class main {

	static Achievement ach = new Achievement();
	static Time time = new Time();

	public static void main(String[] args) { // game start
		Scanner in = new Scanner(System.in);
		
		Print.printMain();
		// 캐릭터 생성 및 선택
		System.out.print("캐릭터 이름을 작성하세요: ");
		Player.name = in.next();
		
		System.out.println("플레이어의 이름은 \"" + Player.name + "\"입니다.");
		
		System.out.println("초기 캐릭터");
		System.out.println("1. 모기");
		System.out.println("2. 하루살이");
		System.out.println("3. 바퀴벌레");
		System.out.println("4. 나비");
		System.out.println("5. 꿀벌");
		System.out.print("원하는 초기 캐릭터를 선택하세요. : ");
		int char_choice = in.nextInt();
		System.out.println("");
		
		if(char_choice == 1) {
			System.out.println("모기를 선택했습니다.\n");
			Player.p = new Mosquito(3,1);
		}
		else if(char_choice == 2) {
			System.out.println("하루살이를 선택했습니다.\n");
			Player.p = new Mayfly(3,1);
		}
		else if(char_choice == 3) {
			System.out.println("바퀴벌레를 선택했습니다.\n");
			Player.p = new Roach(3,1);
		}
		else if(char_choice == 4) {
			System.out.println("나비를 선택했습니다.\n");
			Player.p = new Butterfly(3,1);
		}
		else if(char_choice == 5) {
			System.out.println("꿀벌을 선택했습니다.\n");
			Player.p = new Honeybee(3,1);
		}

		while (true) {
			Print.printMain();// =========================================================================================메인
								// 배경 프린트
			time.count(); // 시간 turn count
			if (time.time < 7) {
				System.out.printf("<현재 시간 : %d/12(낮)>\n", time.time);
			} else {
				System.out.printf("<현재 시간 : %d/12(밤)>\n", time.time);
			}
			System.out.print("1. 탐험, 2. 상점, 3. 가방 4. 스탯, 5.강화, 6. 진화, 0. 게임 종료\n");
			System.out.print("선택 : ");
			int choice = in.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				Exploration exploration = new Exploration();
				exploration.exploration();
				break;

			case 2:
				Print.printStore();// ======================================================================================상점
									// 배경 프린트
				Shop shop = new Shop();//// =================================================================================상점생성
				shop.selectItem();// ========================================================================================상점이용
				break;

			case 3:
				new ShowInventory();// ========================================================================================인벤토리
				break;

			case 4:
				new ShowStatus();// ===========================================================================================스테이터스
				break;

			case 5:
				Player.reinforcement();// ======================================================================================강화
				break;

			case 6:
				ach.process();
				break;

			case 0:
				System.out.println("게임 종료");
				System.exit(0);
			default:
				System.out.println("잘못 입력");
				break;
			}
		}
	}
}
