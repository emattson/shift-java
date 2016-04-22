// Generated by shift-java-gen/ast.JSON

/*
 * Copyright 2016 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package com.shapesecurity.shift.ast;

import org.jetbrains.annotations.NotNull;
import com.shapesecurity.functional.data.HashCodeBuilder;
import com.shapesecurity.shift.ast.operators.BinaryOperator;
import com.shapesecurity.shift.ast.operators.Precedence;

public class BinaryExpression implements Expression {
    @NotNull
    public final Expression left;

    @NotNull
    public final BinaryOperator operator;

    @NotNull
    public final Expression right;


    public BinaryExpression (@NotNull Expression left, @NotNull BinaryOperator operator, @NotNull Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof BinaryExpression && this.left.equals(((BinaryExpression) object).left) && this.operator.equals(((BinaryExpression) object).operator) && this.right.equals(((BinaryExpression) object).right);
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "BinaryExpression");
        code = HashCodeBuilder.put(code, this.left);
        code = HashCodeBuilder.put(code, this.operator);
        code = HashCodeBuilder.put(code, this.right);
        return code;
    }

    @Override
    @NotNull
    public Precedence getPrecedence() {
        return this.operator.getPrecedence();
    }

}
