package TeamProject;

import java.util.Scanner;

public class main {

	public static void main(String[] args) { // game start
		Scanner in = new Scanner(System.in);

		// 캐릭터 생성 및 선택
		Player.p = new Mosquito(3, 1);//==============================================================================전투를 위해 임의로 3레벨 모기로 플레이어 설정
		// 게임 메뉴 루프

		while (true) {
			Print.printMain();//=========================================================================================메인 배경 프린트
			System.out.print("1. 탐험, 2. 상점, 3. 가방 4. 스탯, 5.강화, 6. 진화, 0. 게임 종료\n");
			System.out.print("선택 : ");

			int choice = in.nextInt();

			switch (choice) {
			case 1:
				Exploration exploration = new Exploration();
				exploration.exploration();
				break;

			case 2:
				Print.printStore();//======================================================================================상점 배경 프린트
				Shop shop = new Shop();////=================================================================================상점생성
				shop.selectItem();//========================================================================================상점이용
				break;

			case 3:
				new ShowInventory();//========================================================================================인벤토리
				break;

			case 4:
				new ShowStatus();//===========================================================================================스테이터스
				break;

			case 5:
				Player.reinforcement();//======================================================================================강화
				break;

			case 6:
				Achievement ach = new Achievement();
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