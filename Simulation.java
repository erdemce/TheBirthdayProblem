package denemeler;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Simulation {

	public static void main(String[] args) {
		calculate(20, 10000);

	}

	public static void calculate(int groupSize, int simulationCount) {
		
		
        if (groupSize < 2 || groupSize > 365) {
            System.out.println("Group Size must be in the range 2-365.");
        }
        if (simulationCount <= 0) {
        	System.out.println("Simulation Count must be positive.");
        }

		double simulationwithSameBirthday = 0;

		for (int i = 0; i < simulationCount; i++) {

			simulationwithSameBirthday = simulationwithSameBirthday + generateAndKontrolBirthdays(i + 1, groupSize);
		}
		double probabilityMitSimulation = 100 * simulationwithSameBirthday / simulationCount;
		// report results
        System.out.println("For a group of " + groupSize + " people, the percentage");
        System.out.println("of times that two people share the same birthday is");
        System.out.println(String.format("%.2f%% of the time.", probabilityMitSimulation));
	}

	public static int generateAndKontrolBirthdays(int simulationNumber, int size) {
		Random rnd = new Random(simulationNumber);
		Set<Integer> birthdays = new HashSet<Integer>();
		int isThere = 0;
		for (int i = 0; i < size; i++) {
			int randomBirthday = rnd.nextInt(365);
			if (birthdays.add(randomBirthday)) {
				isThere = 0;
			} else {
				isThere = 1;
				break;
			}
		}
		return isThere;
	}
}
