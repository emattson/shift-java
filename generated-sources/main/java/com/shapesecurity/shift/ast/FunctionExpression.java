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
import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.shift.ast.operators.Precedence;

public class FunctionExpression extends Function implements Expression {
    @NotNull
    public final Maybe<BindingIdentifier> name;


    public FunctionExpression (boolean isGenerator, @NotNull Maybe<BindingIdentifier> name, @NotNull FormalParameters params, @NotNull FunctionBody body) {
        super(isGenerator, params, body);
        this.name = name;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof FunctionExpression && this.isGenerator == ((FunctionExpression) object).isGenerator && this.name.equals(((FunctionExpression) object).name) && this.params.equals(((FunctionExpression) object).params) && this.body.equals(((FunctionExpression) object).body);
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "FunctionExpression");
        code = HashCodeBuilder.put(code, this.isGenerator);
        code = HashCodeBuilder.put(code, this.name);
        code = HashCodeBuilder.put(code, this.params);
        code = HashCodeBuilder.put(code, this.body);
        return code;
    }

    @Override
    @NotNull
    public Precedence getPrecedence() {
        return Precedence.PRIMARY;
    }

}
