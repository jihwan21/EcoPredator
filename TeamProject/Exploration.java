package TeamProject;

import java.util.Scanner;

public class Exploration {
	int area;
	String 모기, 거미, 쥐, 고양이, 얼룩말, 붕어, 악어거북, 수달, 박쥐, 비둘기, 황조롱이, 다람쥐,산양, 호랑이,
	       우럭, 오징어, 상어, 꾀꼬리, 부엉이, 독수리, 멧돼지, 쏘가리, 뉴트리아, 물총새, 두루미, 매, 구렁이,
	       세발낙지, 복어, 귀신고래, 고추잠자리, 제비, 백조, 하늘다람쥐, 노루, 반달가슴곰, 가오리, 전기뱀장어,
	       범고래, 갈매기, 알바트로스, 펠리컨, 렌트카, 관광용잠수함, 제주항공여객기, 인간; 
// 영역 선택 매서드----------------------------------------------------
	public int area_choice() {
		Scanner in = new Scanner(System.in);
		System.out.println("진입 가능 영역");
		if (Player.p.어항N != 0) {System.out.println("1. 지상");}
		else {System.out.println("1. 지상(선택 불가능)");}
		if (Player.p.아가미N != 0) {System.out.println("2. 수중");}
		else {System.out.println("2. 수중(선택 불가능)");}
		if (Player.p.날개N != 0) {System.out.println("3. 공중");}
		else {System.out.println("3. 공중(선택 불가능)");}
		System.out.print("진입할 영역을 선택하세요.");
		
		int area = in.nextInt();
		return area;
	}
	
// 스테이지 선택 매서드1----------------------------------------------------
	public int stage_choice(String a) {
		Scanner in = new Scanner(System.in);
		System.out.println("스테이지 선택");
		System.out.println("1. "+ a);
		System.out.print("입장할 스테이지를 선택하세요. ");
		int stage = in.nextInt();
		return stage;
	}
// 스테이지 선택 매서드1----------------------------------------------------
	public int stage_choice(String a,String b,String c) {
		Scanner in = new Scanner(System.in);
		System.out.println("스테이지 선택");
		System.out.println("1. "+ a);
		System.out.println("2. "+ b);
		System.out.println("3. "+ c);
		System.out.print("입장할 스테이지를 선택하세요. ");
		int stage = in.nextInt();
		return stage;
	}
// 스테이지 선택 매서드2----------------------------------------------------
	public int stage_choice(String a,String b,String c, String d, String e) {
		Scanner in = new Scanner(System.in);
		System.out.println("스테이지 선택");
		System.out.println("1. "+ a);
		System.out.println("2. "+ b);
		System.out.println("3. "+ c);
		System.out.println("4. "+ d);
		System.out.println("5. "+ e);
		System.out.print("입장할 스테이지를 선택하세요. ");
		int stage = in.nextInt();
		return stage;
	}
	
	public void exploration() {
		Scanner in = new Scanner(System.in);
		
// 지역 선택 ---------------------------------------------------------------------------
		System.out.println("탐험 지역 ");
		System.out.println("1. 서울");
		
//		if (Player.p.(업적) == 1) {System.out.println("2. 강원도");}
//		else {System.out.println("2. 강원도(접근 불가능)");}
//		if (Player.p.(업적) == 1) {System.out.println("3. 충청도");}
//		else {System.out.println("3. 충청도(접근 불가능)");}
//		if (Player.p.(업적) == 1) {System.out.println("4. 전라도");}
//		else {System.out.println("4. 전라도(접근 불가능)");}
//		if (Player.p.(업적) == 1) {System.out.println("5. 경상도");}
//		else {System.out.println("5. 경상도(접근 불가능)");}
//		if (Player.p.(업적) == 1) {System.out.println("6. 제주도");}
//		else {System.out.println("6. 제주도(접근 불가능)");}
		
		System.out.print("탐험 지역을 선택하세요. ");
		int location = in.nextInt(); 
		
// 지역별 영역 선택-------------------------------------------------------------------------

		// 쥐, 고양이, 호랑이, 붕어
		switch(location) {
		case 1: {
			System.out.println("서울 지역을 선택했습니다.");
			area = area_choice();
			if (area == 1) {
				System.out.println("국민대 뒤 북한산(지상) 영역에 들어왔습니다.");
				int stage = stage_choice("모기","거미","쥐","고양이","얼룩말");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Mosquito(1, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Spider(1, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Mouse(1, location);
						Battle.battle(m1);
						break;
					}
					case 4: {
						Monster m1 = new Cat(1, location);
						Battle.battle(m1);
						break;
					}
					case 5: {
						Monster m1 = new Zebra(1, location);
						Battle.battle(m1);
						break;}}}
			if (area == 2) {
				System.out.println("한강(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("붕어", "악어거북", "수달");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Carp(1, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Alligator_turtle(1, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Otter(1, location);
						Battle.battle(m1);
						break;}}}
			if (area == 3) {
				System.out.println("남산타워(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("박쥐", "비둘기", "황조롱이");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Bat(1, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Pigeon(1, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Kestrel(1, location);
						Battle.battle(m1);
						break;}}}
			break;
		}
		
		case 2: {
			System.out.println("강원도 지역을 선택했습니다.");
			area = area_choice();
			if (area == 1) {
				System.out.println("설악산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("다람쥐","산양","호랑이");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Squirrel(5, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Goat(5, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Tiger(5, location);
						Battle.battle(m1);
						break;}}}
			if (area == 2) {
				System.out.println("강릉 경포대(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("우럭", "오징어", "상어");
				
				switch(stage) {
					case 1: {
						Monster m1 = new RockFish(5, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Squid(5, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Shark(5, location);
						Battle.battle(m1);
						break;}}}
			if (area == 3) {
				System.out.println("백두산부대 GOP(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("꾀꼬리", "부엉이", "독수리");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Nightingale(5, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Owl(5, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Eagle(5, location);
						Battle.battle(m1);
						break;}}}
				break;
			}
		
		case 3: {
			System.out.println("충청도 지역을 선택했습니다.");
			area = area_choice();
			if (area == 1) {
				System.out.println("진천선수촌 뒤 무이산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("쥐","고양이","멧돼지");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Mouse(10, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Cat(10, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Boar(10, location);
						Battle.battle(m1);
						break;}}}
			if (area == 2) {
				System.out.println("충주호(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("우럭", "오징어", "상어");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Carp2(10, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Mandarin_fish(10, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Nutria(10, location);
						Battle.battle(m1);
						break;}}}
			if (area == 3) {
				System.out.println("탄금호철새조망대(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("물총새", "두루미", "매");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Kingfisher(10, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Crane(10, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Falcon(10, location);
						Battle.battle(m1);
						break;}}}
				break;
			}

		
		case 4: {
			System.out.println("전라도 지역을 선택했습니다.");
			area = area_choice();
			if (area == 1) {
				System.out.println("전주 한옥마을(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("쥐","구렁이","호랑이");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Mouse(15, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Snake(15, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Tiger(15, location);
						Battle.battle(m1);
						break;}}}
			if (area == 2) {
				System.out.println("목포 앞바다(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("세발낙지", "복어", "귀신고래");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Raw_Octopus(15, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new BlowFish(15, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Gray_Whale(15, location);
						Battle.battle(m1);
						break;}}}
			if (area == 3) {
				System.out.println("나주평야(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("고추잠자리", "제비", "백조");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Red_Dragonfly(15, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Swallow(15, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Swan(15, location);
						Battle.battle(m1);
						break;}}}
				break;
			}
		case 5: {
			System.out.println("경상도 지역을 선택했습니다.");
			area = area_choice();
			if (area == 1) {
				System.out.println("지리산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("하늘다람쥐","노루","반달가슴곰");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Flying_Squirrel(20, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Deer(20, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Thibetanus(20, location);
						Battle.battle(m1);
						break;}}}
			if (area == 2) {
				System.out.println("부산 아쿠아리움(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("가오리", "전기뱀장어", "범고래");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Ray(20, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Electric_ell(20, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Orca(20, location);
						Battle.battle(m1);
						break;}}}
			if (area == 3) {
				System.out.println("오륙도스카이워크(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("갈매기", "알바트로스", "펠리컨");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Gull(20, location);
						Battle.battle(m1);
						break;
					}
					case 2: {
						Monster m1 = new Albatross(20, location);
						Battle.battle(m1);
						break;
					}
					case 3: {
						Monster m1 = new Pelican(20, location);
						Battle.battle(m1);
						break;}}}
				break;
			}
		
		case 6: {
			System.out.println("제주도 지역을 선택했습니다.");
			area = area_choice();
			if (area == 1) {
				System.out.println("한라산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("렌트카");
				
				switch(stage) {
					case 1: {
						Monster m1 = new RentCar(30, location);
						Battle.battle(m1);
						break;}}}
			if (area == 2) {
				System.out.println("서귀포 앞바다(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("관광용잠수함");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Ray(20, location);
						Battle.battle(m1);
						break;}}}
			if (area == 3) {
				System.out.println("제주공항(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("제주항공여객기");
				
				switch(stage) {
					case 1: {
						Monster m1 = new Gull(20, location);
						Battle.battle(m1);
						break;}}}
				break;
			}
		case 7: {
			System.out.println("??? 지역에 입장했습니다.");
			System.out.println("??? 영역에 들어왔습니다.");
			System.out.println("인간과 눈이 마주쳤습니다.");
			Monster m1 = new Human();
			Battle.battle(m1);
			break;			
			}
		}
	}
}
