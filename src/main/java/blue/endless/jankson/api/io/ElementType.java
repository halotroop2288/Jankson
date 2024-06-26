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

package blue.endless.jankson.api.io;

/**
 * Represents states that the parser can find itself in. Returned by {@link blue.endless.jankson.api.io.JsonReader#next() JsonReader.next()}.
 */
public enum ElementType {
	
	/**
	 * The parser has encountered a PrimitiveElement in a valid location.
	 */
	PRIMITIVE(true, true),
	
	/**
	 * The parser encountered an opening bracket ('[') in a valid location. Any elements that occur before the matching
	 * ARRAY_END are within the array.
	 */
	ARRAY_START(true, false),
	
	/**
	 * The parser encountered a closing bracket (']') in a valid location. Any elements that follow are not part of the
	 * immediately preceding array.
	 */
	ARRAY_END(true, false),
	
	/**
	 * The parser encountered an opening brace ('{') in a valid location. Any elements that occur before the matching
	 * OBJECT_END are within the object.
	 */
	OBJECT_START(true, false),
	
	/**
	 * The parser encountered a closing brace ('}') in a valid location. Any elements that follow are not part of the
	 * immediately preceding object.
	 */
	OBJECT_END(true, false),
	
	/**
	 * The parser encountered a key-value pair in a valid location, and is ready to report the entire key. The next
	 * semantic object will be the delimiter between this key and its associated value.
	 */
	OBJECT_KEY(true, true),
	
	/**
	 * The parser encountered the separator between a key and its associated value - for json, a colon.
	 */
	//OBJECT_KEY_VALUE_SEPARATOR(true, false),
	
	/**
	 * The parser encountered a comment in a valid location, and is ready to report its full contents.
	 */
	COMMENT(false, true),
	
	/**
	 * The parser encountered a run of whitespace and consumed it all. The immediately following element will not be
	 * whitespace.
	 */
	WHITESPACE(false, true),
	
	/**
	 * The parser encountered a newline.
	 */
	NEWLINE(false, true),
	
	/**
	 * The parser encountered the end of the file.
	 */
	EOF(true, false);
	
	private final boolean semantic;
	private final boolean hasValue;
	ElementType(boolean semantic, boolean hasValue) {
		this.semantic = semantic;
		this.hasValue = hasValue;
	}
	
	public boolean isSemantic() { return this.semantic; }
	/**
	 * When we encounter this value from {@link StructuredDataReader#next()}, can we call
	 * {@link StructuredDataReader#getLatestValue() getLatestValue()} and get meaningful information?
	 * @return
	 */
	public boolean hasValue() { return this.hasValue; }
	
}
