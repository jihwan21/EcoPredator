package TeamProject;

class Time {
	int time = 1;
	static int allTime = 1;
	
	void count() {
		if (time == 12){
			if (Exploration.Seoul_clear == 1 || Exploration.Gangwon_clear == 1||Chungcheong_clear == 1 ||  Jeolla_clear == 1 || Gyeongsang_clear == 1) {
		    		Player.pMoney += 1000 * Exploration.Seoul_clear + 2000 * Exploration.Gangwon_clear + 3000 * Chungcheong_clear + 4000* Jeolla_clear + 5000 * Gyeongsang_clear;
        		 }	
			time = 0;
		}
		time += 1;
		allTime++;
	}

	int current_time() {
		return time;
	}
}

