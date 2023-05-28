package TeamProject;

import java.util.Scanner;

class ClassArray {
	Monster m;
}

public class Achievement {
	static Mosquito Mosquito = new Mosquito(1, 1);
	static Mayfly Mayfly = new Mayfly(1, 1);
	static Roach Roach = new Roach(1, 1);
	static Butterfly Butterfly = new Butterfly(1, 1);
	static Honeybee Honeybee = new Honeybee(1, 1);
	static Spider Spider = new Spider(1, 1);
	static Mouse Mouse = new Mouse(1, 1);
	static Cat Cat = new Cat(1, 1);
	static Zebra Zebra = new Zebra(1, 1);
	static Carp Carp = new Carp(1, 1);
	static Alligator_turtle Alligator_turtle = new Alligator_turtle(1, 1);
	static Otter Otter = new Otter(1, 1);
	static Bat Bat = new Bat(1, 1);
	static Pigeon Pigeon = new Pigeon(1, 1);
	static Kestrel Kestrel = new Kestrel(1, 1);
	static Squirrel Squirrel = new Squirrel(1, 1);
	static Goat Goat = new Goat(1, 1);
	static Tiger Tiger = new Tiger(1, 1);
	static RockFish RockFish = new RockFish(1, 1);
	static Squid Squid = new Squid(1, 1);
	static Shark Shark = new Shark(1, 1);
	static Nightingale Nightingale = new Nightingale(1, 1);
	static Owl Owl = new Owl(1, 1);
	static Eagle Eagle = new Eagle(1, 1);
	static Boar Boar = new Boar(1, 1);
	static Carp2 Carp2 = new Carp2(1, 1);
	static Mandarin_fish Mandarin_fish = new Mandarin_fish(1, 1);
	static Nutria Nutria = new Nutria(1, 1);
	static Kingfisher Kingfisher = new Kingfisher(1, 1);
	static Crane Crane = new Crane(1, 1);
	static Falcon Falcon = new Falcon(1, 1);
	static Snake Snake = new Snake(1, 1);
	static Raw_Octopus Raw_Octopus = new Raw_Octopus(1, 1);
	static BlowFish BlowFish = new BlowFish(1, 1);
	static Gray_Whale Gray_Whale = new Gray_Whale(1, 1);
	static Red_Dragonfly Red_Dragonfly = new Red_Dragonfly(1, 1);
	static Swallow Swallow = new Swallow(1, 1);
	static Swan Swan = new Swan(1, 1);
	static Flying_Squirrel Flying_Squirrel = new Flying_Squirrel(1, 1);
	static Deer Deer = new Deer(1, 1);
	static Thibetanus Thibetanus = new Thibetanus(1, 1);
	static Ray Ray = new Ray(1, 1);
	static Electric_ell Electric_ell = new Electric_ell(1, 1);
	static Orca Orca = new Orca(1, 1);
	static Gull Gull = new Gull(1, 1);
	static Albatross Albatross = new Albatross(1, 1);
	static Pelican Pelican = new Pelican(1, 1);
	static RentCar RentCar = new RentCar(1, 1);
	static Submarine Submarine = new Submarine(1, 1);
	static JEJU_airline_plane JEJU_airline_plane = new JEJU_airline_plane(1, 1);
	static Human Human = new Human();

	// 지역 선택 판별을 위해서 사용할 객체(중복 몬스터들)
	static Mouse Mouse3 = new Mouse(1, 3);
	static Mouse Mouse4 = new Mouse(1, 4);
	static Cat Cat3 = new Cat(1, 3);
	static Cat Cat4 = new Cat(1, 4);
	static Tiger Tiger4 = new Tiger(1, 4);

	static ClassArray[] classList = new ClassArray[51];
	{
		for (int i = 0; i < 51; i++) {
			classList[i] = new ClassArray();
		}
		classList[0].m = Mosquito;
		classList[1].m = Mayfly;
		classList[2].m = Roach;
		classList[3].m = Butterfly;
		classList[4].m = Honeybee;
		classList[5].m = Spider;
		classList[6].m = Mouse;
		classList[7].m = Cat;
		classList[8].m = Zebra;
		classList[9].m = Carp;
		classList[10].m = Alligator_turtle;
		classList[11].m = Otter;
		classList[12].m = Bat;
		classList[13].m = Pigeon;
		classList[14].m = Kestrel;
		classList[15].m = Squirrel;
		classList[16].m = Goat;
		classList[17].m = Tiger;
		classList[18].m = RockFish;
		classList[19].m = Squid;
		classList[20].m = Shark;
		classList[21].m = Nightingale;
		classList[22].m = Owl;
		classList[23].m = Eagle;
		classList[24].m = Boar;
		classList[25].m = Carp2;
		classList[26].m = Mandarin_fish;
		classList[27].m = Nutria;
		classList[28].m = Kingfisher;
		classList[29].m = Crane;
		classList[30].m = Falcon;
		classList[31].m = Snake;
		classList[32].m = Raw_Octopus;
		classList[33].m = BlowFish;
		classList[34].m = Gray_Whale;
		classList[35].m = Red_Dragonfly;
		classList[36].m = Swallow;
		classList[37].m = Swan;
		classList[38].m = Flying_Squirrel;
		classList[39].m = Deer;
		classList[40].m = Thibetanus;
		classList[41].m = Ray;
		classList[42].m = Electric_ell;
		classList[43].m = Orca;
		classList[44].m = Gull;
		classList[45].m = Albatross;
		classList[46].m = Pelican;
		classList[47].m = RentCar;
		classList[48].m = Submarine;
		classList[49].m = JEJU_airline_plane;
		classList[50].m = Human;
	}

	// tribe에 해당하는 몬스터 업적 count 증가
	static void count(String tribe) {
		for (int i = 0; i < 51; i++) {
			if (classList[i].m.tribe == tribe)
				classList[i].m.count += 1;
		}
	}

	// 진화 가능한 몬스터 목록 출력
	void print_evolution_list() {
		Scanner in = new Scanner(System.in);
		int flag = 0;
		System.out.println("----- <진화 가능한 몬스터 목록> -----");
		for (int i = 0; i < 51; i++) { // i 범위 = 몬스터 수
			if (classList[i].m.count >= 10) { // 업적 달성도 10이상인 경우 진화 가능한 몬스터로 출력
				flag = 1;
				System.out.printf("%d. %s\n", i, classList[i].m.tribe);
			}
		}
		if (flag == 0) {
			System.out.println("업적이 달성된 몬스터가 없어 진화가 불가능합니다.");
		} else if (flag == 1) {
			System.out.println("진화할 몬스터 번호를 선택해주세요!");
			System.out.print("선택 : ");
			int monster_num = in.nextInt();
			Player.p = classList[monster_num].m;
			System.out.println(classList[monster_num].m.tribe + "로 진화하였습니다.");
		}
	}

	// 현재 업적 현황 출력
	void print_achievement() {
		System.out.println("----- <몬스터 처치 업적 달성도> -----");
		for (int k = 0; k < 51; k++) {
			System.out.printf("%d. %s : %d/10\n", k, classList[k].m.tribe, classList[k].m.count);
		}
		System.out.println();
	}

	void process() {
		Scanner in = new Scanner(System.in);

		System.out.println("1. 몬스터 처치 업적 현황 ");
		System.out.println("2. 진화");
		System.out.print("선택 : ");
		int select_num = in.nextInt();

		switch (select_num) {
		case 1: {
			print_achievement();
			break;
		}
		case 2: {
			print_evolution_list();
			break;
		}
		}
	}
}
