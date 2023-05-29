package TeamProject;

import java.util.Scanner;

public class main {
	// 업적 클래스 객체 생성 / 시간 클래스 객체 생성
	static Achievement ach = new Achievement();
	static Time time = new Time();
	
	// game start
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in);
		
		// 게임 포스터 출력
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

		// 캐릭터 선택
		if (char_choice == 1) {
			System.out.println("모기를 선택했습니다.");
			Player.p = new Mosquito(3, 1);
		} else if (char_choice == 2) {
			System.out.println("하루살이를 선택했습니다.");
			Player.p = new Mayfly(3, 1);
		} else if (char_choice == 3) {
			System.out.println("바퀴벌레를 선택했습니다.");
			Player.p = new Roach(3, 1);
		} else if (char_choice == 4) {
			System.out.println("나비를 선택했습니다.");
			Player.p = new Butterfly(3, 1);
		} else if (char_choice == 5) {
			System.out.println("꿀벌을 선택했습니다.");
			Player.p = new Honeybee(3, 1);
		}

		// 엔딩 장면 출력
		while (true) {
			if (Exploration.Jeju_clear == 1) {
				System.out.println("??? 지역에 입장했습니다.");
				System.out.println("??? 영역에 들어왔습니다.");
				Human m1 = new Human();
				Battle.battleEnding(m1);
				System.exit(0);
			}
			
			// 메인 게임 시작 
			Print.printMain();
			
			// 시간 turn 출력
			time.count();
			if (time.time < 7) {
				System.out.printf("<현재 시간 : %d/12(낮)>\n", time.time);
			} else {
				System.out.printf("<현재 시간 : %d/12(밤)>\n", time.time);
			}
			
			// 게임 내에서 플레이어가 선택할 수 있는 목록 출력 / 선택
			System.out.print("1. 탐험, 2. 상점, 3. 가방 4. 스탯, 5.강화, 6. 진화, 0. 게임 종료\n");
			System.out.print("선택 : ");
			int choice = in.nextInt();
			System.out.println();

			switch (choice) {
			// 탐험
			case 1:
				Exploration exploration = new Exploration();
				exploration.exploration();
				break;
			
			// 상점
			case 2:
				Print.printStore();
				
				// 상점 객체 생성
				Shop shop = new Shop();
				shop.selectItem();
				break;
					
			// 가방
			case 3:
				new ShowInventory();
				break;
			
			// 스탯
			case 4:
				new ShowStatus();
				break;

			// 강화
			case 5:
				Player.reinforcement();
				break;
			
			// 진화
			case 6:
				ach.process();
				break;

			// 게임 종료
			case 0:
				System.out.println("게임 종료");
				System.exit(0);
					
			// default
			default:
				System.out.println("잘못 입력");
				break;
			}
		}
	}
}
