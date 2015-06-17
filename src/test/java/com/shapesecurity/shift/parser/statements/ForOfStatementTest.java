package com.shapesecurity.shift.parser.statements;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.shift.ast.*;
import com.shapesecurity.shift.parser.Assertions;
import com.shapesecurity.shift.parser.JsError;
import org.junit.Test;

/**
 * Created by u478 on 6/11/15.
 */
public class ForOfStatementTest extends Assertions {
  @Test
  public void testForOfStatement() throws JsError {
    testScript("for (var x of list) process(x);", new ForOfStatement(new VariableDeclaration(VariableDeclarationKind.Var,
            ImmutableList.list(new VariableDeclarator(new BindingIdentifier("x"), Maybe.nothing()))),
            new IdentifierExpression("list"), new ExpressionStatement(new CallExpression(
            new IdentifierExpression("process"), ImmutableList.list(new IdentifierExpression("x"))))));

    testScript("for(var a of b);", new ForOfStatement(new VariableDeclaration(VariableDeclarationKind.Var,
            ImmutableList.list(new VariableDeclarator(new BindingIdentifier("a"), Maybe.nothing()))),
            new IdentifierExpression("b"), new EmptyStatement()));

    testScript("for(a of b);", new ForOfStatement(new BindingIdentifier("a"), new IdentifierExpression("b"),
        new EmptyStatement()));

    testScript("for(let [a] of b);", new ForOfStatement(new VariableDeclaration(VariableDeclarationKind.Let,
        ImmutableList.list(new VariableDeclarator(new ArrayBinding(ImmutableList.list(Maybe.just(
            new BindingIdentifier("a"))), Maybe.nothing()), Maybe.nothing()))), new IdentifierExpression("b"),
        new EmptyStatement()));

    testScript("for(let of of b);", new ForOfStatement(new VariableDeclaration(VariableDeclarationKind.Let,
            ImmutableList.list(new VariableDeclarator(new BindingIdentifier("of"), Maybe.nothing()))),
            new IdentifierExpression("b"), new EmptyStatement()));

    testScript("for(const a of b);", new ForOfStatement(new VariableDeclaration(VariableDeclarationKind.Const,
            ImmutableList.list(new VariableDeclarator(new BindingIdentifier("a"), Maybe.nothing()))),
            new IdentifierExpression("b"), new EmptyStatement()));

    testScriptFailure("for(let of 0);", 0, "Unexpected number");
    testScriptFailure("for(this of 0);", 0, "Invalid left-hand side in for-of");
    testScriptFailure("for(var a = 0 of b);", 0, "Invalid variable declaration in for-of statement");
    testScriptFailure("for(let a = 0 of b);", 0, "Invalid variable declaration in for-of statement");
    testScriptFailure("for(const a = 0 of b);", 0, "Invalid variable declaration in for-of statement");
  }
}