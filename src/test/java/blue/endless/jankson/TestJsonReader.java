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

package blue.endless.jankson;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import blue.endless.jankson.api.Jankson;
import blue.endless.jankson.api.SyntaxError;
import blue.endless.jankson.api.document.PrimitiveElement;
import blue.endless.jankson.api.document.ValueElement;

public class TestJsonReader {
	
	@Test
	public void testBareValues() throws IOException, SyntaxError {
		ValueElement bareTrue = Jankson.readJson("true");
		if (bareTrue instanceof PrimitiveElement p) {
			Assertions.assertEquals(Boolean.TRUE, p.asBoolean().get());
		} else {
			Assertions.fail("Should parse to a PrimitiveElement");
		}
		
		ValueElement bareFalse = Jankson.readJson("false");
		if (bareFalse instanceof PrimitiveElement p) {
			Assertions.assertEquals(Boolean.FALSE, p.asBoolean().get());
		} else {
			Assertions.fail("Should parse to a PrimitiveElement");
		}
		
		ValueElement bareFortyTwo = Jankson.readJson("42");
		if (bareFortyTwo instanceof PrimitiveElement p) {
			Assertions.assertEquals(42, p.asInt().getAsInt());
		} else {
			Assertions.fail("Should parse to a PrimitiveElement");
		}
		
		ValueElement bareFoo = Jankson.readJson("\"foo\"");
		if (bareFoo instanceof PrimitiveElement p) {
			Assertions.assertEquals("foo", p.asString().get());
		} else {
			Assertions.fail("Should parse to a PrimitiveElement");
		}
		
		ValueElement barePi = Jankson.readJson("3.1415926535897932384626433832795028841972");
		if (barePi instanceof PrimitiveElement p) {
			Assertions.assertEquals(3.1415926535897932384626433832795028841972, p.asDouble().getAsDouble(), 0.00000000000001);
		} else {
			Assertions.fail("Should parse to a PrimitiveElement");
		}
		
		ValueElement bareNull = Jankson.readJson("null");
		if (bareNull instanceof PrimitiveElement p) {
			Assertions.assertTrue(p.isNull());
		} else {
			Assertions.fail("Should parse to a PrimitiveElement");
		}
	}
}
