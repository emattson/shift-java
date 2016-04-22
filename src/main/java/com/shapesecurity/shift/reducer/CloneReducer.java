// Generated by shift-spec-java/reducer.js

/**
 * Copyright 2016 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shapesecurity.shift.reducer;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.shift.ast.*;
import com.shapesecurity.shift.visitor.Reducer;
import org.jetbrains.annotations.NotNull;

public class CloneReducer implements Reducer<Node> {
    @NotNull
    @Override
    public AssignmentTarget reduceArrayAssignmentTarget(
            @NotNull ArrayAssignmentTarget node,
            @NotNull ImmutableList<Maybe<Node>> elements,
            @NotNull Maybe<Node> rest) {
        return new ArrayAssignmentTarget(elements.map(x -> x.map(y -> (AssignmentTargetAssignmentTargetWithDefault) y)), rest.map(x -> (AssignmentTarget) x));
    }

    @NotNull
    @Override
    public Binding reduceArrayBinding(
            @NotNull ArrayBinding node,
            @NotNull ImmutableList<Maybe<Node>> elements,
            @NotNull Maybe<Node> rest) {
        return new ArrayBinding(elements.map(x -> x.map(y -> (BindingBindingWithDefault) y)), rest.map(x -> (Binding) x));
    }

    @NotNull
    @Override
    public Expression reduceArrayExpression(
            @NotNull ArrayExpression node,
            @NotNull ImmutableList<Maybe<Node>> elements) {
        return new ArrayExpression(elements.map(x -> x.map(y -> (SpreadElementExpression) y)));
    }

    @NotNull
    @Override
    public Expression reduceArrowExpression(
            @NotNull ArrowExpression node,
            @NotNull Node params,
            @NotNull Node body) {
        return new ArrowExpression((FormalParameters) params, (FunctionBodyExpression) body);
    }

    @NotNull
    @Override
    public Expression reduceAssignmentExpression(
            @NotNull AssignmentExpression node,
            @NotNull Node binding,
            @NotNull Node expression) {
        return new AssignmentExpression((AssignmentTarget) binding, (Expression) expression);
    }

    @NotNull
    @Override
    public AssignmentTargetIdentifier reduceAssignmentTargetIdentifier(@NotNull AssignmentTargetIdentifier node) {
        return new AssignmentTargetIdentifier(node.name);
    }

    @NotNull
    @Override
    public AssignmentTargetProperty reduceAssignmentTargetPropertyIdentifier(
            @NotNull AssignmentTargetPropertyIdentifier node,
            @NotNull Node binding,
            @NotNull Maybe<Node> init) {
        return new AssignmentTargetPropertyIdentifier((AssignmentTargetIdentifier) binding, init.map(x -> (Expression) x));
    }

    @NotNull
    @Override
    public AssignmentTargetProperty reduceAssignmentTargetPropertyProperty(
            @NotNull AssignmentTargetPropertyProperty node,
            @NotNull Node name,
            @NotNull Node binding) {
        return new AssignmentTargetPropertyProperty((PropertyName) name, (AssignmentTargetAssignmentTargetWithDefault) binding);
    }

    @NotNull
    @Override
    public AssignmentTargetAssignmentTargetWithDefault reduceAssignmentTargetWithDefault(
            @NotNull AssignmentTargetWithDefault node,
            @NotNull Node binding,
            @NotNull Node init) {
        return new AssignmentTargetWithDefault((AssignmentTarget) binding, (Expression) init);
    }

    @NotNull
    @Override
    public Expression reduceBinaryExpression(
            @NotNull BinaryExpression node,
            @NotNull Node left,
            @NotNull Node right) {
        return new BinaryExpression((Expression) left, node.operator, (Expression) right);
    }

    @NotNull
    @Override
    public BindingIdentifier reduceBindingIdentifier(@NotNull BindingIdentifier node) {
        return new BindingIdentifier(node.name);
    }

    @NotNull
    @Override
    public BindingProperty reduceBindingPropertyIdentifier(
            @NotNull BindingPropertyIdentifier node,
            @NotNull Node binding,
            @NotNull Maybe<Node> init) {
        return new BindingPropertyIdentifier((BindingIdentifier) binding, init.map(x -> (Expression) x));
    }

    @NotNull
    @Override
    public BindingProperty reduceBindingPropertyProperty(
            @NotNull BindingPropertyProperty node,
            @NotNull Node name,
            @NotNull Node binding) {
        return new BindingPropertyProperty((PropertyName) name, (BindingBindingWithDefault) binding);
    }

    @NotNull
    @Override
    public BindingBindingWithDefault reduceBindingWithDefault(
            @NotNull BindingWithDefault node,
            @NotNull Node binding,
            @NotNull Node init) {
        return new BindingWithDefault((Binding) binding, (Expression) init);
    }

    @NotNull
    @Override
    public Block reduceBlock(
            @NotNull Block node,
            @NotNull ImmutableList<Node> statements) {
        return new Block(statements.map(x -> (Statement) x));
    }

    @NotNull
    @Override
    public Statement reduceBlockStatement(
            @NotNull BlockStatement node,
            @NotNull Node block) {
        return new BlockStatement((Block) block);
    }

    @NotNull
    @Override
    public Statement reduceBreakStatement(@NotNull BreakStatement node) {
        return new BreakStatement(node.label);
    }

    @NotNull
    @Override
    public Expression reduceCallExpression(
            @NotNull CallExpression node,
            @NotNull Node callee,
            @NotNull ImmutableList<Node> arguments) {
        return new CallExpression((ExpressionSuper) callee, arguments.map(x -> (SpreadElementExpression) x));
    }

    @NotNull
    @Override
    public CatchClause reduceCatchClause(
            @NotNull CatchClause node,
            @NotNull Node binding,
            @NotNull Node body) {
        return new CatchClause((Binding) binding, (Block) body);
    }

    @NotNull
    @Override
    public ClassDeclaration reduceClassDeclaration(
            @NotNull ClassDeclaration node,
            @NotNull Node name,
            @NotNull Maybe<Node> _super,
            @NotNull ImmutableList<Node> elements) {
        return new ClassDeclaration((BindingIdentifier) name, _super.map(x -> (Expression) x), elements.map(x -> (ClassElement) x));
    }

    @NotNull
    @Override
    public ClassElement reduceClassElement(
            @NotNull ClassElement node,
            @NotNull Node method) {
        return new ClassElement(node.isStatic, (MethodDefinition) method);
    }

    @NotNull
    @Override
    public ClassExpression reduceClassExpression(
            @NotNull ClassExpression node,
            @NotNull Maybe<Node> name,
            @NotNull Maybe<Node> _super,
            @NotNull ImmutableList<Node> elements) {
        return new ClassExpression(name.map(x -> (BindingIdentifier) x), _super.map(x -> (Expression) x), elements.map(x -> (ClassElement) x));
    }

    @NotNull
    @Override
    public Expression reduceCompoundAssignmentExpression(
            @NotNull CompoundAssignmentExpression node,
            @NotNull Node binding,
            @NotNull Node expression) {
        return new CompoundAssignmentExpression((SimpleAssignmentTarget) binding, node.operator, (Expression) expression);
    }

    @NotNull
    @Override
    public SimpleAssignmentTarget reduceComputedMemberAssignmentTarget(
            @NotNull ComputedMemberAssignmentTarget node,
            @NotNull Node object,
            @NotNull Node expression) {
        return new ComputedMemberAssignmentTarget((ExpressionSuper) object, (Expression) expression);
    }

    @NotNull
    @Override
    public Expression reduceComputedMemberExpression(
            @NotNull ComputedMemberExpression node,
            @NotNull Node object,
            @NotNull Node expression) {
        return new ComputedMemberExpression((ExpressionSuper) object, (Expression) expression);
    }

    @NotNull
    @Override
    public PropertyName reduceComputedPropertyName(
            @NotNull ComputedPropertyName node,
            @NotNull Node expression) {
        return new ComputedPropertyName((Expression) expression);
    }

    @NotNull
    @Override
    public Expression reduceConditionalExpression(
            @NotNull ConditionalExpression node,
            @NotNull Node test,
            @NotNull Node consequent,
            @NotNull Node alternate) {
        return new ConditionalExpression((Expression) test, (Expression) consequent, (Expression) alternate);
    }

    @NotNull
    @Override
    public Statement reduceContinueStatement(@NotNull ContinueStatement node) {
        return new ContinueStatement(node.label);
    }

    @NotNull
    @Override
    public ObjectProperty reduceDataProperty(
            @NotNull DataProperty node,
            @NotNull Node name,
            @NotNull Node expression) {
        return new DataProperty((PropertyName) name, (Expression) expression);
    }

    @NotNull
    @Override
    public Statement reduceDebuggerStatement(@NotNull DebuggerStatement node) {
        return new DebuggerStatement();
    }

    @NotNull
    @Override
    public Directive reduceDirective(@NotNull Directive node) {
        return new Directive(node.rawValue);
    }

    @NotNull
    @Override
    public Statement reduceDoWhileStatement(
            @NotNull DoWhileStatement node,
            @NotNull Node body,
            @NotNull Node test) {
        return new DoWhileStatement((Statement) body, (Expression) test);
    }

    @NotNull
    @Override
    public Statement reduceEmptyStatement(@NotNull EmptyStatement node) {
        return new EmptyStatement();
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExport(
            @NotNull Export node,
            @NotNull Node declaration) {
        return new Export((FunctionDeclarationClassDeclarationVariableDeclaration) declaration);
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportAllFrom(@NotNull ExportAllFrom node) {
        return new ExportAllFrom(node.moduleSpecifier);
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportDefault(
            @NotNull ExportDefault node,
            @NotNull Node body) {
        return new ExportDefault((FunctionDeclarationClassDeclarationExpression) body);
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportFrom(
            @NotNull ExportFrom node,
            @NotNull ImmutableList<Node> namedExports) {
        return new ExportFrom(namedExports.map(x -> (ExportFromSpecifier) x), node.moduleSpecifier);
    }

    @NotNull
    @Override
    public ExportFromSpecifier reduceExportFromSpecifier(@NotNull ExportFromSpecifier node) {
        return new ExportFromSpecifier(node.name, node.exportedName);
    }

    @NotNull
    @Override
    public ExportLocalSpecifier reduceExportLocalSpecifier(
            @NotNull ExportLocalSpecifier node,
            @NotNull Node name) {
        return new ExportLocalSpecifier((IdentifierExpression) name, node.exportedName);
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportLocals(
            @NotNull ExportLocals node,
            @NotNull ImmutableList<Node> namedExports) {
        return new ExportLocals(namedExports.map(x -> (ExportLocalSpecifier) x));
    }

    @NotNull
    @Override
    public Statement reduceExpressionStatement(
            @NotNull ExpressionStatement node,
            @NotNull Node expression) {
        return new ExpressionStatement((Expression) expression);
    }

    @NotNull
    @Override
    public Statement reduceForInStatement(
            @NotNull ForInStatement node,
            @NotNull Node left,
            @NotNull Node right,
            @NotNull Node body) {
        return new ForInStatement((VariableDeclarationAssignmentTarget) left, (Expression) right, (Statement) body);
    }

    @NotNull
    @Override
    public Statement reduceForOfStatement(
            @NotNull ForOfStatement node,
            @NotNull Node left,
            @NotNull Node right,
            @NotNull Node body) {
        return new ForOfStatement((VariableDeclarationAssignmentTarget) left, (Expression) right, (Statement) body);
    }

    @NotNull
    @Override
    public Statement reduceForStatement(
            @NotNull ForStatement node,
            @NotNull Maybe<Node> init,
            @NotNull Maybe<Node> test,
            @NotNull Maybe<Node> update,
            @NotNull Node body) {
        return new ForStatement(init.map(x -> (VariableDeclarationExpression) x), test.map(x -> (Expression) x), update.map(x -> (Expression) x), (Statement) body);
    }

    @NotNull
    @Override
    public FormalParameters reduceFormalParameters(
            @NotNull FormalParameters node,
            @NotNull ImmutableList<Node> items,
            @NotNull Maybe<Node> rest) {
        return new FormalParameters(items.map(x -> (Parameter) x), rest.map(x -> (Binding) x));
    }

    @NotNull
    @Override
    public FunctionBody reduceFunctionBody(
            @NotNull FunctionBody node,
            @NotNull ImmutableList<Node> directives,
            @NotNull ImmutableList<Node> statements) {
        return new FunctionBody(directives.map(x -> (Directive) x), statements.map(x -> (Statement) x));
    }

    @NotNull
    @Override
    public FunctionDeclaration reduceFunctionDeclaration(
            @NotNull FunctionDeclaration node,
            @NotNull Node name,
            @NotNull Node params,
            @NotNull Node body) {
        return new FunctionDeclaration(node.isGenerator, (BindingIdentifier) name, (FormalParameters) params, (FunctionBody) body);
    }

    @NotNull
    @Override
    public FunctionExpression reduceFunctionExpression(
            @NotNull FunctionExpression node,
            @NotNull Maybe<Node> name,
            @NotNull Node params,
            @NotNull Node body) {
        return new FunctionExpression(node.isGenerator, name.map(x -> (BindingIdentifier) x), (FormalParameters) params, (FunctionBody) body);
    }

    @NotNull
    @Override
    public MethodDefinition reduceGetter(
            @NotNull Getter node,
            @NotNull Node name,
            @NotNull Node body) {
        return new Getter((PropertyName) name, (FunctionBody) body);
    }

    @NotNull
    @Override
    public IdentifierExpression reduceIdentifierExpression(@NotNull IdentifierExpression node) {
        return new IdentifierExpression(node.name);
    }

    @NotNull
    @Override
    public Statement reduceIfStatement(
            @NotNull IfStatement node,
            @NotNull Node test,
            @NotNull Node consequent,
            @NotNull Maybe<Node> alternate) {
        return new IfStatement((Expression) test, (Statement) consequent, alternate.map(x -> (Statement) x));
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceImport(
            @NotNull Import node,
            @NotNull Maybe<Node> defaultBinding,
            @NotNull ImmutableList<Node> namedImports) {
        return new Import(defaultBinding.map(x -> (BindingIdentifier) x), namedImports.map(x -> (ImportSpecifier) x), node.moduleSpecifier);
    }

    @NotNull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceImportNamespace(
            @NotNull ImportNamespace node,
            @NotNull Maybe<Node> defaultBinding,
            @NotNull Node namespaceBinding) {
        return new ImportNamespace(defaultBinding.map(x -> (BindingIdentifier) x), (BindingIdentifier) namespaceBinding, node.moduleSpecifier);
    }

    @NotNull
    @Override
    public ImportSpecifier reduceImportSpecifier(
            @NotNull ImportSpecifier node,
            @NotNull Node binding) {
        return new ImportSpecifier(node.name, (BindingIdentifier) binding);
    }

    @NotNull
    @Override
    public Statement reduceLabeledStatement(
            @NotNull LabeledStatement node,
            @NotNull Node body) {
        return new LabeledStatement(node.label, (Statement) body);
    }

    @NotNull
    @Override
    public Expression reduceLiteralBooleanExpression(@NotNull LiteralBooleanExpression node) {
        return new LiteralBooleanExpression(node.value);
    }

    @NotNull
    @Override
    public Expression reduceLiteralInfinityExpression(@NotNull LiteralInfinityExpression node) {
        return new LiteralInfinityExpression();
    }

    @NotNull
    @Override
    public Expression reduceLiteralNullExpression(@NotNull LiteralNullExpression node) {
        return new LiteralNullExpression();
    }

    @NotNull
    @Override
    public Expression reduceLiteralNumericExpression(@NotNull LiteralNumericExpression node) {
        return new LiteralNumericExpression(node.value);
    }

    @NotNull
    @Override
    public Expression reduceLiteralRegExpExpression(@NotNull LiteralRegExpExpression node) {
        return new LiteralRegExpExpression(node.pattern, node.global, node.ignoreCase, node.multiLine, node.sticky, node.unicode);
    }

    @NotNull
    @Override
    public Expression reduceLiteralStringExpression(@NotNull LiteralStringExpression node) {
        return new LiteralStringExpression(node.value);
    }

    @NotNull
    @Override
    public MethodDefinition reduceMethod(
            @NotNull Method node,
            @NotNull Node name,
            @NotNull Node params,
            @NotNull Node body) {
        return new Method(node.isGenerator, (PropertyName) name, (FormalParameters) params, (FunctionBody) body);
    }

    @NotNull
    @Override
    public Program reduceModule(
            @NotNull Module node,
            @NotNull ImmutableList<Node> directives,
            @NotNull ImmutableList<Node> items) {
        return new Module(directives.map(x -> (Directive) x), items.map(x -> (ImportDeclarationExportDeclarationStatement) x));
    }

    @NotNull
    @Override
    public Expression reduceNewExpression(
            @NotNull NewExpression node,
            @NotNull Node callee,
            @NotNull ImmutableList<Node> arguments) {
        return new NewExpression((Expression) callee, arguments.map(x -> (SpreadElementExpression) x));
    }

    @NotNull
    @Override
    public Expression reduceNewTargetExpression(@NotNull NewTargetExpression node) {
        return new NewTargetExpression();
    }

    @NotNull
    @Override
    public AssignmentTarget reduceObjectAssignmentTarget(
            @NotNull ObjectAssignmentTarget node,
            @NotNull ImmutableList<Node> properties) {
        return new ObjectAssignmentTarget(properties.map(x -> (AssignmentTargetProperty) x));
    }

    @NotNull
    @Override
    public Binding reduceObjectBinding(
            @NotNull ObjectBinding node,
            @NotNull ImmutableList<Node> properties) {
        return new ObjectBinding(properties.map(x -> (BindingProperty) x));
    }

    @NotNull
    @Override
    public Expression reduceObjectExpression(
            @NotNull ObjectExpression node,
            @NotNull ImmutableList<Node> properties) {
        return new ObjectExpression(properties.map(x -> (ObjectProperty) x));
    }

    @NotNull
    @Override
    public Parameter reduceParameter(
            @NotNull Parameter node,
            @NotNull Node binding,
            @NotNull Maybe<Node> init) {
        return new Parameter((Binding) binding, init.map(x -> (Expression) x));
    }

    @NotNull
    @Override
    public Statement reduceReturnStatement(
            @NotNull ReturnStatement node,
            @NotNull Maybe<Node> expression) {
        return new ReturnStatement(expression.map(x -> (Expression) x));
    }

    @NotNull
    @Override
    public Program reduceScript(
            @NotNull Script node,
            @NotNull ImmutableList<Node> directives,
            @NotNull ImmutableList<Node> statements) {
        return new Script(directives.map(x -> (Directive) x), statements.map(x -> (Statement) x));
    }

    @NotNull
    @Override
    public MethodDefinition reduceSetter(
            @NotNull Setter node,
            @NotNull Node name,
            @NotNull Node param,
            @NotNull Node body) {
        return new Setter((PropertyName) name, (Parameter) param, (FunctionBody) body);
    }

    @NotNull
    @Override
    public ObjectProperty reduceShorthandProperty(
            @NotNull ShorthandProperty node,
            @NotNull Node name) {
        return new ShorthandProperty((IdentifierExpression) name);
    }

    @NotNull
    @Override
    public SpreadElementExpression reduceSpreadElement(
            @NotNull SpreadElement node,
            @NotNull Node expression) {
        return new SpreadElement((Expression) expression);
    }

    @NotNull
    @Override
    public SimpleAssignmentTarget reduceStaticMemberAssignmentTarget(
            @NotNull StaticMemberAssignmentTarget node,
            @NotNull Node object) {
        return new StaticMemberAssignmentTarget((ExpressionSuper) object, node.property);
    }

    @NotNull
    @Override
    public Expression reduceStaticMemberExpression(
            @NotNull StaticMemberExpression node,
            @NotNull Node object) {
        return new StaticMemberExpression((ExpressionSuper) object, node.property);
    }

    @NotNull
    @Override
    public PropertyName reduceStaticPropertyName(@NotNull StaticPropertyName node) {
        return new StaticPropertyName(node.value);
    }

    @NotNull
    @Override
    public ExpressionSuper reduceSuper(@NotNull Super node) {
        return new Super();
    }

    @NotNull
    @Override
    public SwitchCase reduceSwitchCase(
            @NotNull SwitchCase node,
            @NotNull Node test,
            @NotNull ImmutableList<Node> consequent) {
        return new SwitchCase((Expression) test, consequent.map(x -> (Statement) x));
    }

    @NotNull
    @Override
    public SwitchDefault reduceSwitchDefault(
            @NotNull SwitchDefault node,
            @NotNull ImmutableList<Node> consequent) {
        return new SwitchDefault(consequent.map(x -> (Statement) x));
    }

    @NotNull
    @Override
    public Statement reduceSwitchStatement(
            @NotNull SwitchStatement node,
            @NotNull Node discriminant,
            @NotNull ImmutableList<Node> cases) {
        return new SwitchStatement((Expression) discriminant, cases.map(x -> (SwitchCase) x));
    }

    @NotNull
    @Override
    public Statement reduceSwitchStatementWithDefault(
            @NotNull SwitchStatementWithDefault node,
            @NotNull Node discriminant,
            @NotNull ImmutableList<Node> preDefaultCases,
            @NotNull Node defaultCase,
            @NotNull ImmutableList<Node> postDefaultCases) {
        return new SwitchStatementWithDefault((Expression) discriminant, preDefaultCases.map(x -> (SwitchCase) x), (SwitchDefault) defaultCase, postDefaultCases.map(x -> (SwitchCase) x));
    }

    @NotNull
    @Override
    public ExpressionTemplateElement reduceTemplateElement(@NotNull TemplateElement node) {
        return new TemplateElement(node.rawValue);
    }

    @NotNull
    @Override
    public Expression reduceTemplateExpression(
            @NotNull TemplateExpression node,
            @NotNull Maybe<Node> tag,
            @NotNull ImmutableList<Node> elements) {
        return new TemplateExpression(tag.map(x -> (Expression) x), elements.map(x -> (ExpressionTemplateElement) x));
    }

    @NotNull
    @Override
    public Expression reduceThisExpression(@NotNull ThisExpression node) {
        return new ThisExpression();
    }

    @NotNull
    @Override
    public Statement reduceThrowStatement(
            @NotNull ThrowStatement node,
            @NotNull Node expression) {
        return new ThrowStatement((Expression) expression);
    }

    @NotNull
    @Override
    public Statement reduceTryCatchStatement(
            @NotNull TryCatchStatement node,
            @NotNull Node body,
            @NotNull Node catchClause) {
        return new TryCatchStatement((Block) body, (CatchClause) catchClause);
    }

    @NotNull
    @Override
    public Statement reduceTryFinallyStatement(
            @NotNull TryFinallyStatement node,
            @NotNull Node body,
            @NotNull Maybe<Node> catchClause,
            @NotNull Node finalizer) {
        return new TryFinallyStatement((Block) body, catchClause.map(x -> (CatchClause) x), (Block) finalizer);
    }

    @NotNull
    @Override
    public Expression reduceUnaryExpression(
            @NotNull UnaryExpression node,
            @NotNull Node operand) {
        return new UnaryExpression(node.operator, (Expression) operand);
    }

    @NotNull
    @Override
    public Expression reduceUpdateExpression(
            @NotNull UpdateExpression node,
            @NotNull Node operand) {
        return new UpdateExpression(node.isPrefix, node.operator, (SimpleAssignmentTarget) operand);
    }

    @NotNull
    @Override
    public VariableDeclaration reduceVariableDeclaration(
            @NotNull VariableDeclaration node,
            @NotNull ImmutableList<Node> declarators) {
        return new VariableDeclaration(node.kind, declarators.map(x -> (VariableDeclarator) x));
    }

    @NotNull
    @Override
    public Statement reduceVariableDeclarationStatement(
            @NotNull VariableDeclarationStatement node,
            @NotNull Node declaration) {
        return new VariableDeclarationStatement((VariableDeclaration) declaration);
    }

    @NotNull
    @Override
    public VariableDeclarator reduceVariableDeclarator(
            @NotNull VariableDeclarator node,
            @NotNull Node binding,
            @NotNull Maybe<Node> init) {
        return new VariableDeclarator((Binding) binding, init.map(x -> (Expression) x));
    }

    @NotNull
    @Override
    public Statement reduceWhileStatement(
            @NotNull WhileStatement node,
            @NotNull Node test,
            @NotNull Node body) {
        return new WhileStatement((Expression) test, (Statement) body);
    }

    @NotNull
    @Override
    public Statement reduceWithStatement(
            @NotNull WithStatement node,
            @NotNull Node object,
            @NotNull Node body) {
        return new WithStatement((Expression) object, (Statement) body);
    }

    @NotNull
    @Override
    public Expression reduceYieldExpression(
            @NotNull YieldExpression node,
            @NotNull Maybe<Node> expression) {
        return new YieldExpression(expression.map(x -> (Expression) x));
    }

    @NotNull
    @Override
    public Expression reduceYieldGeneratorExpression(
            @NotNull YieldGeneratorExpression node,
            @NotNull Node expression) {
        return new YieldGeneratorExpression((Expression) expression);
    }
}