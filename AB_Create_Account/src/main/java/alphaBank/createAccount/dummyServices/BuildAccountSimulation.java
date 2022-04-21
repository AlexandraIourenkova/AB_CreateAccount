package alphaBank.createAccount.dummyServices;

import java.util.Random;

public class BuildAccountSimulation {
	private static Random random = new Random();
	
	public static boolean dummyFunction() {
		return random.nextBoolean();
	}

}
