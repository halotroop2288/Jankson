/*
 * MIT License
 *
 * Copyright (c) 2018-2024 Falkreon (Isaac Ellingson)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package blue.endless.jankson.impl.document;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import blue.endless.jankson.api.document.NonValueElement;
import blue.endless.jankson.api.document.PrimitiveElement;
import blue.endless.jankson.api.document.ValueElement;
import blue.endless.jankson.api.io.StructuredData;
import blue.endless.jankson.api.io.StructuredDataWriter;

public class DoubleElementImpl extends PrimitiveElement {
	private final double value;
	
	public DoubleElementImpl(double value) {
		this.value = value;
	}
	
	@Override
	public ValueElement clone() {
		DoubleElementImpl result = new DoubleElementImpl(value);
		result.copyNonValueElementsFrom(this);
		return result;
	}

	@Override
	public void write(StructuredDataWriter writer) throws IOException {
		for(NonValueElement elem : prologue) elem.write(writer);
		writer.write(StructuredData.primitive(this));
		for(NonValueElement elem : epilogue) elem.write(writer);
	}

	@Override
	public Optional<Object> getValue() {
		return Optional.of(value);
	}

	@Override
	public Optional<String> asString() {
		return Optional.empty();
	}

	@Override
	public Optional<Boolean> asBoolean() {
		return Optional.empty();
	}

	@Override
	public OptionalDouble asDouble() {
		return OptionalDouble.of(value);
	}

	@Override
	public OptionalLong asLong() {
		return OptionalLong.empty();
	}

	@Override
	public OptionalInt asInt() {
		return OptionalInt.empty();
	}

	@Override
	public Optional<BigInteger> asBigInteger() {
		return Optional.empty();
	}

	@Override
	public Optional<BigDecimal> asBigDecimal() {
		return Optional.of(BigDecimal.valueOf(value));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DoubleElementImpl v) {
			return super.equals(obj) && v.value == this.value;
		} else {
			return false;
		}
	}
}
