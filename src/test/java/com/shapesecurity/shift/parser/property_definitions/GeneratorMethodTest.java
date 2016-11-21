package com.shapesecurity.shift.parser.property_definitions;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.shift.ast.*;
import com.shapesecurity.shift.parser.ParserTestCase;
import com.shapesecurity.shift.parser.JsError;

import org.junit.Test;

public class GeneratorMethodTest extends ParserTestCase {
    @Test
    public void testGeneratorMethod() throws JsError {
        testScript("({*a(){}})", new ObjectExpression(ImmutableList.of(new Method(true, new StaticPropertyName("a"), new FormalParameters(
                ImmutableList.empty(), Maybe.empty()), new FunctionBody(ImmutableList.empty(), ImmutableList.empty())
                ))));

        testScript("({*yield(){}})", new ObjectExpression(ImmutableList.of(new Method(true, new StaticPropertyName("yield"), new FormalParameters(
                ImmutableList.empty(), Maybe.empty()), new FunctionBody(ImmutableList.empty(), ImmutableList.empty())
                ))));

        testScript("({*[yield](){}})", new ObjectExpression(ImmutableList.of(new Method(true, new ComputedPropertyName(new IdentifierExpression("yield")), new FormalParameters(
                ImmutableList.empty(), Maybe.empty()), new FunctionBody(ImmutableList.empty(), ImmutableList.empty())
                ))));
    }
}
