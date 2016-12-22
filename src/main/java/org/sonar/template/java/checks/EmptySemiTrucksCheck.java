package org.sonar.template.java.checks;

import java.util.List;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.google.common.collect.ImmutableList;

@Rule(key = "EmptySemiTrucksRule")
public class EmptySemiTrucksCheck extends IssuableSubscriptionVisitor {

	@Override
	public List<Kind> nodesToVisit() {
		
		return ImmutableList.of(Kind.METHOD);
	}
	
	@Override
	public void visitNode(Tree tree) {
		MethodTree methodTree = (MethodTree) tree;
		MethodSymbol symbol = methodTree.symbol();
	}

}
