package TeamProject;

import java.util.Scanner;

class ClassArray {
	String tribe;
	int count = 0;

}

public class Achievement {
	Mosquito Mosquito = new Mosquito(1, 1);
	Mayfly Mayfly = new Mayfly(1, 1);
	Roach Roach = new Roach(1, 1);
	Butterfly Butterfly = new Butterfly(1, 1);
	Honeybee Honeybee = new Honeybee(1, 1);
	Spider Spider = new Spider(1, 1);
	Mouse Mouse = new Mouse(1, 1);
	Cat Cat = new Cat(1, 1);
	Zebra Zebra = new Zebra(1, 1);
	Carp Carp = new Carp(1, 1);
	Alligator_turtle Alligator_turtle = new Alligator_turtle(1, 1);
	Otter Otter = new Otter(1, 1);
	Bat Bat = new Bat(1, 1);
	Pigeon Pigeon = new Pigeon(1, 1);
	Kestrel Kestrel = new Kestrel(1, 1);
	Squirrel Squirrel = new Squirrel(1, 1);
	Goat Goat = new Goat(1, 1);
	Tiger Tiger = new Tiger(1, 1);
	RockFish RockFish = new RockFish(1, 1);
	Squid Squid = new Squid(1, 1);
	Shark Shark = new Shark(1, 1);
	Nightingale Nightingale = new Nightingale(1, 1);
	Owl Owl = new Owl(1, 1);
	Eagle Eagle = new Eagle(1, 1);
	Boar Boar = new Boar(1, 1);
	Carp2 Carp2 = new Carp2(1, 1);
	Mandarin_fish Mandarin_fish = new Mandarin_fish(1, 1);
	Nutria Nutria = new Nutria(1, 1);
	Kingfisher Kingfisher = new Kingfisher(1, 1);
	Crane Crane = new Crane(1, 1);
	Falcon Falcon = new Falcon(1, 1);
	Snake Snake = new Snake(1, 1);
	Raw_Octopus Raw_Octopus = new Raw_Octopus(1, 1);
	BlowFish BlowFish = new BlowFish(1, 1);
	Gray_Whale Gray_Whale = new Gray_Whale(1, 1);
	Red_Dragonfly Red_Dragonfly = new Red_Dragonfly(1, 1);
	Swallow Swallow = new Swallow(1, 1);
	Swan Swan = new Swan(1, 1);
	Flying_Squirrel Flying_Squirrel = new Flying_Squirrel(1, 1);
	Deer Deer = new Deer(1, 1);
	Thibetanus Thibetanus = new Thibetanus(1, 1);
	Ray Ray = new Ray(1, 1);
	Electric_ell Electric_ell = new Electric_ell(1, 1);
	Orca Orca = new Orca(1, 1);
	Gull Gull = new Gull(1, 1);
	Albatross Albatross = new Albatross(1, 1);
	Pelican Pelican = new Pelican(1, 1);
	RentCar RentCar = new RentCar(1, 1);
	Submarine Submarine = new Submarine(1, 1);
	JEJU_airline_plane JEJU_airline_plane = new JEJU_airline_plane(1, 1);
	Human Human = new Human();

	ClassArray[] classList = new ClassArray[51];
	{
		for (int i = 0; i < 51; i++) {
			classList[i] = new ClassArray();
		}
		classList[0].tribe = Mosquito.tribe;
		classList[1].tribe = Mayfly.tribe;
		classList[2].tribe = Roach.tribe;
		classList[3].tribe = Butterfly.tribe;
		classList[4].tribe = Honeybee.tribe;
		classList[5].tribe = Spider.tribe;
		classList[6].tribe = Mouse.tribe;
		classList[7].tribe = Cat.tribe;
		classList[8].tribe = Zebra.tribe;
		classList[9].tribe = Carp.tribe;
		classList[10].tribe = Alligator_turtle.tribe;
		classList[11].tribe = Otter.tribe;
		classList[12].tribe = Bat.tribe;
		classList[13].tribe = Pigeon.tribe;
		classList[14].tribe = Kestrel.tribe;
		classList[15].tribe = Squirrel.tribe;
		classList[16].tribe = Goat.tribe;
		classList[17].tribe = Tiger.tribe;
		classList[18].tribe = RockFish.tribe;
		classList[19].tribe = Squid.tribe;
		classList[20].tribe = Shark.tribe;
		classList[21].tribe = Nightingale.tribe;
		classList[22].tribe = Owl.tribe;
		classList[23].tribe = Eagle.tribe;
		classList[24].tribe = Boar.tribe;
		classList[25].tribe = Carp2.tribe;
		classList[26].tribe = Mandarin_fish.tribe;
		classList[27].tribe = Nutria.tribe;
		classList[28].tribe = Kingfisher.tribe;
		classList[29].tribe = Crane.tribe;
		classList[30].tribe = Falcon.tribe;
		classList[31].tribe = Snake.tribe;
		classList[32].tribe = Raw_Octopus.tribe;
		classList[33].tribe = BlowFish.tribe;
		classList[34].tribe = Gray_Whale.tribe;
		classList[35].tribe = Red_Dragonfly.tribe;
		classList[36].tribe = Swallow.tribe;
		classList[37].tribe = Swan.tribe;
		classList[38].tribe = Flying_Squirrel.tribe;
		classList[39].tribe = Deer.tribe;
		classList[40].tribe = Thibetanus.tribe;
		classList[41].tribe = Ray.tribe;
		classList[42].tribe = Electric_ell.tribe;
		classList[43].tribe = Orca.tribe;
		classList[44].tribe = Gull.tribe;
		classList[45].tribe = Albatross.tribe;
		classList[46].tribe = Pelican.tribe;
		classList[47].tribe = RentCar.tribe;
		classList[48].tribe = Submarine.tribe;
		classList[49].tribe = JEJU_airline_plane.tribe;
		classList[50].tribe = Human.tribe;
	}

	// tribe에 해당하는 몬스터 업적 count 증가
	void count(String tribe) {
		for (int i = 0; i < 51; i++) {
			if (classList[i].tribe == tribe)
				classList[i].count += 1;
		}
	}

	// 진화 가능한 몬스터 목록 출력
	void print_evolution_list() {
		Scanner in = new Scanner(System.in);
		int flag = 0;
		System.out.println("<진화 가능한 몬스터 목록>");
		for (int i = 0; i < 51; i++) { // i 범위 = 몬스터 수
			if (classList[i].count >= 10) { // 업적 달성도 10이상인 경우 진화 가능한 몬스터로 출력
				flag = 1;
				System.out.printf("%d. %s\n", i, classList[i].tribe);
			}
		}
		if (flag == 0) {
			System.out.println("업적이 달성된 몬스터가 없어 진화가 불가능합니다.");
		} else if (flag == 1) {
			System.out.println("진화할 몬스터 번호를 선택해주세요!");
			System.out.print("선택 : ");
			int monster_num = in.nextInt();
		}
	}

	// 현재 업적 현황 출력
	void print_achievement() {
		System.out.println("<몬스터 처치 업적>");
		for (int k = 0; k < 51; k++) {
			System.out.printf("%d. %s : %d/10\n", k, classList[k].tribe, classList[k].count);
		}
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