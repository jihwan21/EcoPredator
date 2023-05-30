package TeamProject;

import java.util.Scanner;

public class Exploration {
	// 지역 몬스터 모두 클리어했을 경우 구별 변수
	static int Seoul_clear = 0, Gangwon_clear = 0, Chungcheong_clear = 0, Jeolla_clear = 0, Gyeongsang_clear = 0,
			Jeju_clear = 0;

	// 영역 선택 변수(지상, 수중, 공중)
	int area;

	// 전투 가능한 몬스터 목록 출력을 위한 변수
	String 모기, 거미, 쥐, 고양이, 얼룩말, 붕어, 악어거북, 수달, 박쥐, 비둘기, 황조롱이, 다람쥐, 산양, 호랑이, 우럭, 오징어, 상어, 꾀꼬리, 부엉이, 독수리, 멧돼지, 쏘가리, 뉴트리아,
			물총새, 두루미, 매, 구렁이, 세발낙지, 복어, 귀신고래, 고추잠자리, 제비, 백조, 하늘다람쥐, 노루, 반달가슴곰, 가오리, 전기뱀장어, 범고래, 갈매기, 알바트로스, 펠리컨, 렌트카,
			관광용잠수함, 제주항공여객기, 인간;
	private Achievement ach;

// 서울 지역을 제외한 영역 선택 매서드  -- 지상 선택 
	public int area_choice() {
		Scanner in = new Scanner(System.in);
		System.out.println("----- <진입 가능 영역> -----");
		if (Player.어항N != 0) {
			System.out.println("1. 지상");
		} else {
			System.out.println("1. 지상(선택 불가능)");
		}
		if (Player.아가미N != 0) {
			System.out.println("2. 수중");
		} else {
			System.out.println("2. 수중(선택 불가능)");
		}
		if (Player.날개N != 0) {
			System.out.println("3. 공중");
		} else {
			System.out.println("3. 공중(선택 불가능)");
		}
		System.out.println();
		System.out.print("진입할 영역을 선택하세요 : ");

		int area = in.nextInt();
		return area;
	}

// 서울 지역의 영역 선택 매서드 -- 지상 선택 
	public int area_choice2() {
		Scanner in = new Scanner(System.in);
		System.out.println("----- <진입 가능 영역> -----");
		System.out.println("1. 지상");
		if (Player.아가미N != 0) { // 특수장비 존재 여부 확인
			System.out.println("2. 수중");
		} else {
			System.out.println("2. 수중(선택 불가능)");
		}
		if (Player.날개N != 0) { // 특수장비 존재 여부 확인
			System.out.println("3. 공중");
		} else {
			System.out.println("3. 공중(선택 불가능)");
		}
		System.out.print("진입할 영역을 선택하세요 : ");
		int area = in.nextInt();
		System.out.println();
		return area;
	}

// 스테이지 선택 매서드 -- 사냥 가능 몬스터 1마리
	public int stage_choice(String a) {
		Scanner in = new Scanner(System.in);
		System.out.println("----- <스테이지 선택> -----");
		System.out.println("1. " + a);
		System.out.print("입장할 스테이지를 선택하세요 : ");
		int stage = in.nextInt();
		return stage;
	}

// 스테이지 선택 매서드 -- 사냥 가능 몬스터 3마리
	public int stage_choice(String a, String b, String c) {
		Scanner in = new Scanner(System.in);
		System.out.println("----- <스테이지 선택> -----");
		System.out.println("1. " + a);
		System.out.println("2. " + b);
		System.out.println("3. " + c);
		System.out.print("입장할 스테이지를 선택하세요 : ");
		int stage = in.nextInt();
		return stage;
	}

// 스테이지 선택 매서드 -- 사냥 가능 몬스터 5마리
	public int stage_choice(String a, String b, String c, String d, String e) {
		Scanner in = new Scanner(System.in);
		System.out.println("----- <스테이지 선택> -----");
		System.out.println("1. " + a);
		System.out.println("2. " + b);
		System.out.println("3. " + c);
		System.out.println("4. " + d);
		System.out.println("5. " + e);
		System.out.print("입장할 스테이지를 선택하세요 : ");
		int stage = in.nextInt();
		return stage;
	}

// 해당 지역 clear 여부 판단 메서드 -- 1마리일 경우
	public int judgment_clear(Monster m1) {
		int all_clear = 0;
		if (m1.clear == 1)
			all_clear = 1;
		return all_clear;
	}

// 해당 지역 clear 여부 판단 메서드 -- 3마리일 경우
	public int judgment_clear(Monster m1, Monster m2, Monster m3) {
		int all_clear = 0;
		if (m1.clear == 1 && m2.clear == 1 && m3.clear == 1)
			all_clear = 1;
		return all_clear;
	}

// 해당 지역 clear 여부 판단 메서드 -- 5마리일 경우
	public int judgment_clear(Monster m1, Monster m2, Monster m3, Monster m4, Monster m5) {
		int all_clear = 0;
		if (m1.clear == 1 && m2.clear == 1 && m3.clear == 1 && m4.clear == 1 & m5.clear == 1) {
			all_clear = 1;
		}
		return all_clear;
	}

	// 탐험 진행 메서드
	public void exploration() {
		Scanner in = new Scanner(System.in);

		// 지역 선택
		System.out.println("----- <탐험 지역> -----");
		System.out.println("1. 서울");

		// 서울 육,해,공 모든 스테이지 클리어 시 강원도, 충청도 탐험 가능
		if (judgment_clear(Achievement.Mosquito, Achievement.Spider, Achievement.Mouse, Achievement.Cat,
				Achievement.Zebra) == 1
				&& judgment_clear(Achievement.Carp, Achievement.Alligator_turtle, Achievement.Otter) == 1
				&& judgment_clear(Achievement.Bat, Achievement.Pigeon, Achievement.Kestrel) == 1) {

			// 서울 모든 스테이지 클리어 check
			Seoul_clear = 1;
			System.out.println("2. 강원도");
			System.out.println("3. 충청도");
		} else {
			System.out.println("2. 강원도(접근 불가능)");
			System.out.println("3. 충청도(접근 불가능)");
		}

		// 충청도 육,해,공 모든 스테이지 클리어 시 전라도 탐험 가능
		if (judgment_clear(Achievement.Mouse3, Achievement.Cat3, Achievement.Boar) == 1
				&& judgment_clear(Achievement.Carp2, Achievement.Mandarin_fish, Achievement.Nutria) == 1
				&& judgment_clear(Achievement.Kingfisher, Achievement.Crane, Achievement.Falcon) == 1) {

			// 충청도 모든 스테이지 클리어 check
			Chungcheong_clear = 1;
			System.out.println("4. 전라도");
		} else {
			System.out.println("4. 전라도(접근 불가능)");
		}

		// 강원도 육,해,공 모든 스테이지 클리어 시 경상도 탐험 가능
		if (judgment_clear(Achievement.Squirrel, Achievement.Goat, Achievement.Tiger) == 1
				&& judgment_clear(Achievement.RockFish, Achievement.Squid, Achievement.Shark) == 1
				&& judgment_clear(Achievement.Nightingale, Achievement.Owl, Achievement.Eagle) == 1) {

			// 강원도 모든 스테이지 클리어 check
			Gangwon_clear = 1;
			System.out.println("5. 경상도");
		} else {
			System.out.println("5. 경상도(접근 불가능)");
		}

		// 서울, 강원도, 충청도, 경상도, 전라도 육,해,공 모든 스테이지 클리어 시 제주도 탐험 가능
		if (judgment_clear(Achievement.Flying_Squirrel, Achievement.Deer, Achievement.Thibetanus) == 1
				&& judgment_clear(Achievement.Ray, Achievement.Electric_ell, Achievement.Orca) == 1
				&& judgment_clear(Achievement.Gull, Achievement.Albatross, Achievement.Pelican) == 1
				&& judgment_clear(Achievement.Mouse4, Achievement.Snake, Achievement.Tiger4) == 1
				&& judgment_clear(Achievement.Raw_Octopus, Achievement.BlowFish, Achievement.Gray_Whale) == 1
				&& judgment_clear(Achievement.Red_Dragonfly, Achievement.Swallow, Achievement.Swan) == 1) {

			// 전라도 모든 스테이지 클리어 check
			// 경상도 모든 스테이지 클리어 check
			Jeolla_clear = 1;
			Gyeongsang_clear = 1;
			System.out.println("6. 제주도");
		} else {
			System.out.println("6. 제주도(접근 불가능)");
		}
		// 제주도 몬스터 전부 클리어한 경우
		if (judgment_clear(Achievement.RentCar, Achievement.Submarine, Achievement.JEJU_airline_plane) == 1) {
			Jeju_clear = 1;
		}
		// 엔딩 장소 출
		if (Jeju_clear == 1) {
			System.out.println("7. ???");
		}

		// 지역별 영역 선택
		System.out.print("탐험 지역을 선택하세요. ");
		int location = in.nextInt();

		switch (location) {
		case 1: {
			System.out.println("서울 지역을 선택했습니다.");
			System.out.println();
			area = area_choice2();
			if (area == 1) {
				System.out.println("국민대 뒤 북한산(지상) 영역에 들어왔습니다.");
				int stage = stage_choice("모기", "거미", "쥐", "고양이", "얼룩말");

				switch (stage) {
				case 1: {
					Monster m1 = new Mosquito(1, location);
					Battle.battle(m1, Achievement.Mosquito, ach);
					;
					System.out.println(Achievement.Mosquito.clear);
					break;
				}
				case 2: {
					Monster m1 = new Spider(1, location);
					Battle.battle(m1, Achievement.Spider, ach);
					System.out.println(Achievement.Spider.clear);
					break;
				}
				case 3: {
					Monster m1 = new Mouse(1, location);
					Battle.battle(m1, Achievement.Mouse, ach);
					System.out.println(Achievement.Mouse.clear);
					break;
				}
				case 4: {
					Monster m1 = new Cat(1, location);
					Battle.battle(m1, Achievement.Cat, ach);
					System.out.println(Achievement.Cat.clear);
					break;
				}
				case 5: {
					Monster m1 = new Zebra(1, location);
					Battle.battle(m1, Achievement.Zebra, ach);
					System.out.println(Achievement.Zebra.clear);
					break;
				}
				}
			}
			if (area == 2) {
				if (Player.아가미N == 0) { // 특수장비 존재 여부 확인
					System.out.println("특수장비 <아가미>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("한강(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("붕어", "악어거북", "수달");

				switch (stage) {
				case 1: {
					Monster m1 = new Carp(1, location);
					Battle.battle(m1, Achievement.Carp, ach);
					break;
				}
				case 2: {
					Monster m1 = new Alligator_turtle(1, location);
					Battle.battle(m1, Achievement.Alligator_turtle, ach);
					break;
				}
				case 3: {
					Monster m1 = new Otter(1, location);
					Battle.battle(m1, Achievement.Otter, ach);
					break;
				}
				}
			}
			if (area == 3) {
				if (Player.날개N == 0) { // 특수장비 존재 여부 확인
					System.out.println("특수장비 <날개>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("남산타워(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("박쥐", "비둘기", "황조롱이");

				switch (stage) {
				case 1: {
					Monster m1 = new Bat(1, location);
					Battle.battle(m1, Achievement.Bat, ach);
					break;
				}
				case 2: {
					Monster m1 = new Pigeon(1, location);
					Battle.battle(m1, Achievement.Pigeon, ach);
					break;
				}
				case 3: {
					Monster m1 = new Kestrel(1, location);
					Battle.battle(m1, Achievement.Kestrel, ach);
					break;
				}
				}
			}
			break;
		}

		case 2: {
			if (Seoul_clear == 0) { // 이전 지역 클리어해야 접근가능하도록 조건문 설정
				System.out.println(">> 현재 접근할 수 없는 지역입니다.");
				break;
			}
			System.out.println(">> 강원도 지역을 선택했습니다.");
			System.out.println();
			area = area_choice();
			if (area == 1) {
				System.out.println("설악산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("다람쥐", "산양", "호랑이");

				switch (stage) {
				case 1: {
					Monster m1 = new Squirrel(5, location);
					Battle.battle(m1, Achievement.Squirrel, ach);
					break;
				}
				case 2: {
					Monster m1 = new Goat(5, location);
					Battle.battle(m1, Achievement.Goat, ach);
					break;
				}
				case 3: {
					Monster m1 = new Tiger(5, location);
					Battle.battle(m1, Achievement.Tiger, ach);
					break;
				}
				}
			}
			if (area == 2) {
				if (Player.아가미N == 0) {
					System.out.println("특수장비 <아가미>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("강릉 경포대(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("우럭", "오징어", "상어");

				switch (stage) {
				case 1: {
					Monster m1 = new RockFish(5, location);
					Battle.battle(m1, Achievement.RockFish, ach);
					break;
				}
				case 2: {
					Monster m1 = new Squid(5, location);
					Battle.battle(m1, Achievement.Squid, ach);
					break;
				}
				case 3: {
					Monster m1 = new Shark(5, location);
					Battle.battle(m1, Achievement.Shark, ach);
					break;
				}
				}
			}
			if (area == 3) {
				if (Player.날개N == 0) {
					System.out.println("특수장비 <날개>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("백두산부대 GOP(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("꾀꼬리", "부엉이", "독수리");

				switch (stage) {
				case 1: {
					Monster m1 = new Nightingale(5, location);
					Battle.battle(m1, Achievement.Nightingale, ach);
					break;
				}
				case 2: {
					Monster m1 = new Owl(5, location);
					Battle.battle(m1, Achievement.Owl, ach);
					break;
				}
				case 3: {
					Monster m1 = new Eagle(5, location);
					Battle.battle(m1, Achievement.Eagle, ach);
					break;
				}
				}
			}
			break;
		}

		case 3: {
			if (Seoul_clear == 0) {
				System.out.println(">> 현재 접근할 수 없는 지역입니다.");
				break;
			}
			System.out.println("충청도 지역을 선택했습니다.");
			System.out.println();
			area = area_choice();
			if (area == 1) {
				System.out.println("진천선수촌 뒤 무이산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("쥐", "고양이", "멧돼지");

				switch (stage) {
				case 1: {
					Monster m1 = new Mouse(10, location);
					Battle.battle(m1, Achievement.Mouse3, ach);
					break;
				}
				case 2: {
					Monster m1 = new Cat(10, location);
					Battle.battle(m1, Achievement.Cat3, ach);
					break;
				}
				case 3: {
					Monster m1 = new Boar(10, location);
					Battle.battle(m1, Achievement.Boar, ach);
					break;
				}
				}
			}
			if (area == 2) {
				if (Player.아가미N == 0) {
					System.out.println("특수장비 <아가미>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("충주호(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("우럭", "오징어", "상어");

				switch (stage) {
				case 1: {
					Monster m1 = new Carp2(10, location);
					Battle.battle(m1, Achievement.Carp2, ach);
					break;
				}
				case 2: {
					Monster m1 = new Mandarin_fish(10, location);
					Battle.battle(m1, Achievement.Mandarin_fish, ach);
					break;
				}
				case 3: {
					Monster m1 = new Nutria(10, location);
					Battle.battle(m1, Achievement.Nutria, ach);
					break;
				}
				}
			}
			if (area == 3) {
				if (Player.날개N == 0) {
					System.out.println("특수장비 <날개>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("탄금호철새조망대(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("물총새", "두루미", "매");

				switch (stage) {
				case 1: {
					Monster m1 = new Kingfisher(10, location);
					Battle.battle(m1, Achievement.Kingfisher, ach);
					break;
				}
				case 2: {
					Monster m1 = new Crane(10, location);
					Battle.battle(m1, Achievement.Crane, ach);
					break;
				}
				case 3: {
					Monster m1 = new Falcon(10, location);
					Battle.battle(m1, Achievement.Falcon, ach);
					break;
				}
				}
			}
			break;
		}

		case 4: {
			if (Chungcheong_clear == 0) {
				System.out.println(">> 현재 접근할 수 없는 지역입니다.");
				break;
			}
			System.out.println("전라도 지역을 선택했습니다.");
			System.out.println();
			area = area_choice();
			if (area == 1) {
				System.out.println("전주 한옥마을(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("쥐", "구렁이", "호랑이");

				switch (stage) {
				case 1: {
					Monster m1 = new Mouse(15, location);
					Battle.battle(m1, Achievement.Mouse4, ach);
					break;
				}
				case 2: {
					Monster m1 = new Snake(15, location);
					Battle.battle(m1, Achievement.Snake, ach);
					break;
				}
				case 3: {
					Monster m1 = new Tiger(15, location);
					Battle.battle(m1, Achievement.Tiger4, ach);
					break;
				}
				}
			}
			if (area == 2) {
				if (Player.아가미N == 0) {
					System.out.println("특수장비 <아가미>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("목포 앞바다(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("세발낙지", "복어", "귀신고래");

				switch (stage) {
				case 1: {
					Monster m1 = new Raw_Octopus(15, location);
					Battle.battle(m1, Achievement.Raw_Octopus, ach);
					break;
				}
				case 2: {
					Monster m1 = new BlowFish(15, location);
					Battle.battle(m1, Achievement.BlowFish, ach);
					break;
				}
				case 3: {
					Monster m1 = new Gray_Whale(15, location);
					Battle.battle(m1, Achievement.Gray_Whale, ach);
					break;
				}
				}
			}
			if (area == 3) {
				if (Player.날개N == 0) {
					System.out.println("특수장비 <날개>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("나주평야(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("고추잠자리", "제비", "백조");

				switch (stage) {
				case 1: {
					Monster m1 = new Red_Dragonfly(15, location);
					Battle.battle(m1, Achievement.Red_Dragonfly, ach);
					break;
				}
				case 2: {
					Monster m1 = new Swallow(15, location);
					Battle.battle(m1, Achievement.Swallow, ach);
					break;
				}
				case 3: {
					Monster m1 = new Swan(15, location);
					Battle.battle(m1, Achievement.Swan, ach);
					break;
				}
				}
			}
			break;
		}
		case 5: {
			if (Gangwon_clear == 0) {
				System.out.println(">> 현재 접근할 수 없는 지역입니다.");
				break;
			}
			System.out.println("경상도 지역을 선택했습니다.");
			System.out.println();
			area = area_choice();
			if (area == 1) {
				System.out.println("지리산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("하늘다람쥐", "노루", "반달가슴곰");

				switch (stage) {
				case 1: {
					Monster m1 = new Flying_Squirrel(20, location);
					Battle.battle(m1, Achievement.Flying_Squirrel, ach);
					break;
				}
				case 2: {
					Monster m1 = new Deer(20, location);
					Battle.battle(m1, Achievement.Deer, ach);
					break;
				}
				case 3: {
					Monster m1 = new Thibetanus(20, location);
					Battle.battle(m1, Achievement.Thibetanus, ach);
					break;
				}
				}
			}
			if (area == 2) {
				if (Player.아가미N == 0) {
					System.out.println("특수장비 <아가미>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("부산 아쿠아리움(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("가오리", "전기뱀장어", "범고래");

				switch (stage) {
				case 1: {
					Monster m1 = new Ray(20, location);
					Battle.battle(m1, Achievement.Ray, ach);
					break;
				}
				case 2: {
					Monster m1 = new Electric_ell(20, location);
					Battle.battle(m1, Achievement.Electric_ell, ach);
					break;
				}
				case 3: {
					Monster m1 = new Orca(20, location);
					Battle.battle(m1, Achievement.Orca, ach);
					break;
				}
				}
			}
			if (area == 3) {
				if (Player.날개N == 0) {
					System.out.println("특수장비 <날개>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("오륙도스카이워크(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("갈매기", "알바트로스", "펠리컨");

				switch (stage) {
				case 1: {
					Monster m1 = new Gull(20, location);
					Battle.battle(m1, Achievement.Gull, ach);
					break;
				}
				case 2: {
					Monster m1 = new Albatross(20, location);
					Battle.battle(m1, Achievement.Albatross, ach);
					break;
				}
				case 3: {
					Monster m1 = new Pelican(20, location);
					Battle.battle(m1, Achievement.Pelican, ach);
					break;
				}
				}
			}
			break;
		}

		case 6: {
			if (Jeolla_clear == 0 || Gyeongsang_clear == 0) {
				System.out.println(">> 현재 접근할 수 없는 지역입니다.");
				break;
			}
			System.out.println("제주도 지역을 선택했습니다.");
			System.out.println();
			area = area_choice();
			if (area == 1) {
				System.out.println("한라산(지상) 영역에 들어왔습니다.");

				int stage = stage_choice("렌트카");

				switch (stage) {
				case 1: {
					Monster m1 = new RentCar(30, location);
					Battle.battle(m1, Achievement.RentCar, ach);
					break;
				}
				}
			}
			if (area == 2) {
				if (Player.아가미N == 0) {
					System.out.println("특수장비 <아가미>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("서귀포 앞바다(수중) 영역에 들어왔습니다.");

				int stage = stage_choice("관광용잠수함");

				switch (stage) {
				case 1: {
					Monster m1 = new Submarine(20, location);
					Battle.battle(m1, Achievement.Submarine, ach);
					break;
				}
				}
			}
			if (area == 3) {
				if (Player.날개N == 0) {
					System.out.println("특수장비 <날개>가 없어서 접근이 불가합니다.");
					break;
				}
				System.out.println("제주공항(공중) 영역에 들어왔습니다.");

				int stage = stage_choice("제주항공여객기");

				switch (stage) {
				case 1: {
					Monster m1 = new JEJU_airline_plane(20, location);
					Battle.battle(m1, Achievement.JEJU_airline_plane, ach);
					break;
				}
				}
			}
			break;
		}
		case 7: {
			System.out.println("??? 지역에 입장했습니다.");
			System.out.println("??? 영역에 들어왔습니다.");
			Human m1 = new Human();
			Battle.battleEnding(m1);
			System.exit(0);
			break;
		}
				
		}
	}
}
