
package org.sonar.template.java.checks;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.resolve.JavaSymbol.TypeJavaSymbol;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.google.common.collect.ImmutableList;

@Rule(key = "EmptySemiTrucksRule", name = "List method inside a for loop", description = "Don't make a request to database inside a loop", priority = Priority.CRITICAL, tags = {
																																													"bug"})
public class EmptySemiTrucksCheck
				extends IssuableSubscriptionVisitor {

	private final String OWNER = "org.hibernate.Query";

	private final String METHOD_NAME = "list";

	private final String RULE_MESSAGE = "Don't make a request to database inside a loop";

	@Override
	public List<Kind> nodesToVisit() {

		return ImmutableList.of(Kind.METHOD_INVOCATION);
	}

	@Override
	public void visitNode(Tree tree) {

		MethodInvocationTree methodInvocationTree = (MethodInvocationTree) tree;
		Boolean isQueryInvocationMethod = isQueryInvocationMethod(methodInvocationTree);
		if (isQueryInvocationMethod) {
			Boolean nodeInsideForStatement = isNodeInsideForStatement(methodInvocationTree);
			if (nodeInsideForStatement) {
				reportIssue(methodInvocationTree, RULE_MESSAGE);
			}
		}

	}

	/**
	 * @return
	 */
	public Boolean isQueryInvocationMethod(MethodInvocationTree methodInvocationTree) {

		MethodSymbol methodSymbol = (MethodSymbol) methodInvocationTree.symbol();
		TypeJavaSymbol ownerSymbol = (TypeJavaSymbol) methodSymbol.owner();

		return METHOD_NAME.equals(methodSymbol.name()) && OWNER.equals(ownerSymbol.getFullyQualifiedName());

	}

	/**
	 * @param node
	 * @return
	 */
	public Boolean isNodeInsideForStatement(Tree node) {

		Boolean insideForStatement = Boolean.FALSE;

		if (node != null && node.parent() != null) {
			Tree parent = node.parent();
			insideForStatement = isKindForStatement(parent);
			insideForStatement = insideForStatement || isNodeInsideForStatement(parent);
		}
		return insideForStatement;
	}

	/**
	 * @param tree
	 * @return
	 */
	public Boolean isKindForStatement(Tree node) {

		return node.is(Kind.FOR_STATEMENT);
	}

}
