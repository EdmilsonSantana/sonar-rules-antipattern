package org.sonar.template.java;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.plugins.java.Java;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

public class PatternsRuleDefinition implements RulesDefinition {

	  public static final String REPOSITORY_KEY = "patterns-java";

	@Override
	public void define(Context context) {
		NewRepository repository = context
				.createRepository(REPOSITORY_KEY, Java.KEY)
				.setName("Patterns Java Repository");
		
		new AnnotationBasedRulesDefinition(repository, Java.KEY)
			.addRuleClasses(false, PatternRuleList.getChecks());
		
		for (NewRule rule : repository.rules()) {
			String metadataKey = rule.key();
			
			rule.setInternalKey(metadataKey);
		}
		repository.done();
	}

}
