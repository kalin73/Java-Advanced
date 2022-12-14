
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Robotics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LinkedHashMap<String, int[]> robots = new LinkedHashMap<>();
		ArrayDeque<String> tasks = new ArrayDeque<>();

		addRobots(sc, robots);
		Time time = setCurrTime(sc);
		addTasks(sc, tasks);

		while (!tasks.isEmpty() && !robots.isEmpty()) {
			time.setTime();
			String currTask = tasks.remove();
			boolean taskDone = doTask(robots, currTask, time);

			if (!taskDone) {
				tasks.offer(currTask);
			}
		}
	}

	private static void addTasks(Scanner sc, ArrayDeque<String> tasks) {
		String product = sc.nextLine();

		while (!"End".equals(product)) {
			tasks.offer(product);
			product = sc.nextLine();
		}
	}

	private static void addRobots(Scanner sc, LinkedHashMap<String, int[]> robots) {
		String[] input = sc.nextLine().split(";");
		for (int i = 0; i < input.length; i++) {

			String[] robot = input[i].split("-");
			String name = robot[0];
			int workTime = Integer.parseInt(robot[1]);

			robots.put(name, new int[] { workTime, 0 });

		}
	}

	private static Time setCurrTime(Scanner sc) {
		int[] currTime = Arrays.stream(sc.nextLine().split(":")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int h = currTime[0];
		int m = currTime[1];
		int s = currTime[2];
		Time time = new Time(h, m, s);

		return time;
	}

	private static boolean doTask(LinkedHashMap<String, int[]> robots, String currTask, Time time) {
		boolean taskDone = false;

		for (String key : robots.keySet()) {
			int[] robotTimes = robots.get(key);
			int workTime = robotTimes[0];
			int cooldown = robotTimes[1];

			if (!taskDone) {
				boolean isFree = cooldown == 0;

				if (isFree) {
					taskDone = true;
					System.out.printf("%s - %s [%s]%n", key, currTask, time.getTime());

					if (workTime != 0) {
						robotTimes[1] = workTime - 1;
						robots.put(key, robotTimes);
					}
				}
			}
			if (cooldown != 0) {
				robotTimes[1]--;
				robots.put(key, robotTimes);

			}
		}
		return taskDone;
	}
}

class Time {
	int hours;
	int minutes;
	int seconds;

	public Time(int h, int m, int s) {
		this.hours = h;
		this.minutes = m;
		this.seconds = s;
	}

	public String getTime() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	public void setTime(int sec) {
		int newSec = sec + seconds;

		if (newSec > 59) {
			if (minutes == 59 && hours < 23) {
				seconds = newSec - 60;
				minutes = 0;
				hours++;

			} else if (minutes == 59 && hours == 23) {
				seconds = newSec - 60;
				minutes = 0;
				hours = 0;

			} else {
				minutes++;
				seconds = newSec - 60;
			}
			return;
		}
		seconds = newSec;
	}

	public void setTime() {
		setTime(1);
	}
}
