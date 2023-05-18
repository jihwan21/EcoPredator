package TeamProject;

import java.util.*;
// branch test1
//캐릭터 클래스
class Character {
	 private String name;
	 private int health;
	 private int mana;
	 private int attack;
	 private int defense;
	 private int experience;
	 private int currency;

	 public Character(String name, int health, int mana, int attack, int defense) {
	     this.name = name;
	     this.health = health;
	     this.mana = mana;
	     this.attack = attack;
	     this.defense = defense;
	     this.experience = 0;
	     this.currency = 0;
	 }
}

class Exploration {
	private List<String> areas; // 탐험 가능한 영역 리스트(position 개념)
	private List<String> stages; // 각 영역의 스테이지 리스트
	private Map<String, List<Monster>> stageMonsters; // 스테이지에 등장하는 몬스터 리스트

	public Exploration() {
		this.areas = Arrays.asList("지상", "수중", "공중");
		this.stages = Arrays.asList("1단계", "2단계", "3단계", "4단계", "5단계");
		this.stageMonsters = new HashMap<>();

     // 각 스테이지에 등장하는 몬스터 초기화
     initializeStageMonsters();
	}
	 private void initializeStageMonsters() {
		List<Monster> groundmonster = new ArrayList<>();
		// 몬스터 추가
		List<Monster> watermonster = new ArrayList<>();
		// 몬스터 추가
		List<Monster> airmonster = new ArrayList<>();
		// 몬스터 추가
	
	stageMonsters.put("지상", groundmonster);
	stageMonsters.put("수중", watermonster);
	stageMonsters.put("공중", airmonster);
	 }


	public void explore(Player player) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("탐험할 영역을 선택하세요.");
		System.out.println("1. 지상");
		if (player.hasSpecial("gill")) {
			System.out.println("2. 수중");
		 }
		if (player.hasSpecial("wing")) {
		    System.out.println("3. 공중");
		 }
		System.out.print("선택: ");
		int areaChoice = scanner.nextInt();
	
		String selectedArea = "";
		switch (areaChoice) {
			case 1:
				selectedArea = "지상";
				break;
			case 2:
				if (player.hasSpecial("gill")) { // hasSpecial == 특수 장비 유무
					selectedArea = "수중";
				} 
				else {
					System.out.println("수중 영역 장비가 없음");
				}
				break;
			case 3:
				if (player.hasSpecial("wing")) {
					selectedArea = "공중";
				} 
				else {
					System.out.println("공중 영역 장비 없음");
				}
				break;
				
			default:
				System.out.println("x");
		}
		// 선택 영ㅇ역 스테이지 목록 표시
		List<Monster> stageMonsters = this.stageMonsters.get(selectedArea);
		if (stageMonsters != null) {
			System.out.println(selectedArea + " 탐험 영역의 스테이지 목록:");
			
			for (int i = 0; i < stages.size(); i++) {
				System.out.println((i + 1) + ". " + stages.get(i));
			}
	
			System.out.print("스테이지 선택: ");
			int stageChoice = scanner.nextInt();
	
			if (stageChoice >= 1 && stageChoice <= stages.size()) {
				// 선택한 스테이지 몬스터 리스트 가져오기
				List<Monster> monsters = stageMonsters.subList(0, stageChoice);
	
				// 전투 클래스 구현
	
				} 
			} 
	}
}


// 플레이어 클래스
class Player {
   private Character character;
   private List<Item> inventory;

   public Player(Character character) {
       this.character = character;
       this.inventory = new ArrayList<>();
   }


   // 인벤토리에 아이템 추가
   public void addToInventory(Item item) {
       inventory.add(item);
   }

   // 상점에서 아이템 구매
   public void buyItem(Item item) {
  	 
   }

   public boolean hasSpecial(String Special) {
	   for (Item item : inventory) {
		   if (item instanceof Special && item.getName().equalsIgonoreCase(Special)) {
			   return true;
		   }
		   else {
			   return false;
		   }
	   }
   }
   
   
   // 탐험 영역 선택
   public void chooseArea() {
  	 
   }

   // 스테이지 선택
   public void chooseStage() {
   }
   

   // 전투 진행
   public void battle(Monster monster) {
  	 
   }

   // 스탯 보기
   public void viewStats() {
  	 
   }

   // 진화
   public void evolve() {
  	 
   }
}

// 아이템 클래스
class Item {
	 
}

// 몬스터 클래스
class Monster {
	 private String name;
	 private int health;
	 private int mana;
	 private int attack;
	 private int defense;
	 private int experience;
	 private int currency;

	 public Monster(String name, int health, int mana, int attack, int defense, 
			 		int experience, int currency) {
	     this.name = name;
	     this.health = health;
	     this.mana = mana;
	     this.attack = attack;
	     this.defense = defense;
	     this.experience = experience;
	     this.currency = currency;
	 }
}


public class kang {

	// 게임 메인 메소드
		 public static void main(String[] args) { // game start
		     Scanner in = new Scanner(System.in);
		     Random random = new Random();
			 // 게임 초기화
		
		     // 캐릭터 생성 및 선택
			 
		     // 게임 메뉴 루프
		     while (true) {
		         // 메인 화면 표시 및 사용자 입력 받기
		    	 System.out.print("1. 탐험, 2. 상점, 3. 강화, 4. 스탯 보기, 5. 진화, 0. 게임 종료");
		    	 int userInput = in.nextInt();
		         // 사용자 입력에 따른 동작 수행
		         switch (userInput) {
		             case 1: // 탐험
		                 // 탐험 메뉴 표시
		                 // 영역 선택
		
		                 // 스테이지 선택
		
		                 // 전투 시작
		                 break;
		                 
		             case 2: // 상점
		             // 상점 메뉴 표시
		             // 아이템 구매
		
		             // 인벤토리 확인
		             break;
		             
			         case 3: // 강화
		
			        	 
			             break;
			             
			         case 4: // 스탯보기
			             // 스탯 확인
			             break;
			             
			         case 5: // 진화
			             // 진화 수행
			             break;
			             
			         case 0: // 게임 종료
			        	 break;
			         default: 
			        	 // 잘못된 입력 처리
			             break;
			     }
		
		     }
		 }
}


