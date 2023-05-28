package TeamProject;

//시간 클래스
class Time {
	int time = 1;

	void count() {
		if (time == 12)
			time = 0;
		time += 1;
	}

	int current_time() {
		return time;
	}
}
