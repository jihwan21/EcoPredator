package TeamProject;

// 시간 클래스
class Time {
	int time = 1; // 초기 시간 1로 설정
	static int allTime = 1; // 전체 게임 시간 기록을 위한 변수

	// 시간 카운트하는 메서드
	void count() {
		if (time == 12) { // 시간이 12이면 다시 0으로 초기화, 하루를 12로 설정하였음
			// 각 지역 클리어 시 주기적으로 수입이 발생 (서울 클리어 시 하루(12턴)가 지날때마다 1000원씩 수입 발생, 강원도까지 클리어 시
			// 3000원 수입 발생, 이런 식으로 점점 수입 증가)
			if (Exploration.Seoul_clear == 1 || Exploration.Gangwon_clear == 1 || Exploration.Chungcheong_clear == 1
					|| Exploration.Jeolla_clear == 1 || Exploration.Gyeongsang_clear == 1) {
				Player.pMoney += 1000 * Exploration.Seoul_clear + 2000 * Exploration.Gangwon_clear
						+ 3000 * Exploration.Chungcheong_clear + 4000 * Exploration.Jeolla_clear
						+ 5000 * Exploration.Gyeongsang_clear;
			}
			time = 0;
		}
		time++; // 시간 +1 증가
		allTime++; // 전체 게임 시간 +1 증가
	}

	// 현재 시간 return
	int current_time() {
		return time;
	}
}
