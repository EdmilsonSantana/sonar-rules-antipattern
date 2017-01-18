package org.sonar.template.java;

import java.util.Arrays;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.template.java.checks.EmptySemiTrucksCheck;

public class PatternCheckRegistrar implements CheckRegistrar {

	@Override
	public void register(RegistrarContext context) {
		context.registerClassesForRepository(PatternsRuleDefinition.REPOSITORY_KEY, Arrays.asList(checkClasses()),
				Arrays.asList(testCheckClasses()));
	}

	public static Class<? extends JavaCheck>[] checkClasses() {
		return new Class[] { EmptySemiTrucksCheck.class };
	}

	public static Class<? extends JavaCheck>[] testCheckClasses() {
		return new Class[] {};
	}
}
