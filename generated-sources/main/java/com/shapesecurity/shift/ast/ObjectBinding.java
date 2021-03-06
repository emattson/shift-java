// Generated by shift-java-gen/ast.js

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
import com.shapesecurity.functional.data.ImmutableList;

public class ObjectBinding implements Node, BindingPattern {
    @NotNull
    public final ImmutableList<BindingProperty> properties;


    public ObjectBinding (@NotNull ImmutableList<BindingProperty> properties) {
        this.properties = properties;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof ObjectBinding && this.properties.equals(((ObjectBinding) object).properties);
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "ObjectBinding");
        code = HashCodeBuilder.put(code, this.properties);
        return code;
    }

}
