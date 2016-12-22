package org.sonar.template.java;

import org.sonar.api.Plugin;

public class PatternRulePlugin implements Plugin {

	@Override
	public void define(Context context) {
	    // server extensions -> objects are instantiated during server startup
		context.addExtension(PatternsRuleDefinition.class);
		// objects are instantiated during code analysis
		context.addExtension(PatternCheckRegistrar.class);
	}

}
