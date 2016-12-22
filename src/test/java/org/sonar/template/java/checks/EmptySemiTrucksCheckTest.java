package org.sonar.template.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class EmptySemiTrucksCheckTest {

	@Test
	public void test() {
		JavaCheckVerifier.verify("src/test/files/EmptySemiTrucks.java", new EmptySemiTrucksCheck());
	}
}
