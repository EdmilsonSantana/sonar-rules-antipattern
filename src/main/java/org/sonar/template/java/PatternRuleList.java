package org.sonar.template.java;

import java.util.List;

import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.template.java.checks.EmptySemiTrucksCheck;
import org.sonar.template.java.checks.MyFirstCustomCheck;

import com.google.common.collect.ImmutableList;

public class PatternRuleList {

	public static List<Class> getChecks() {
		return ImmutableList.<Class> builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
	}

	public static List<Class<? extends JavaCheck>> getJavaChecks() {
		return ImmutableList.<Class<? extends JavaCheck>> builder().add(EmptySemiTrucksCheck.class).build();
	}

	public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
		return ImmutableList.<Class<? extends JavaCheck>> builder().build();
	}

}
