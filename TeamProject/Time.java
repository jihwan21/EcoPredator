package TeamProject;

class Time {
	int time = 1;
	static int allTime = 1;

	void count() {
		if (time == 12)
			time = 0;
		time += 1;
		allTime++;
	}

	int current_time() {
		return time;
	}
}

