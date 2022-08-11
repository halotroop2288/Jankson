/*
 * MIT License
 *
 * Copyright (c) 2018-2022 Falkreon (Isaac Ellingson)
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

package blue.endless.jankson.api.document;

public class CommentElement implements DocumentElement {
	protected String value;
	//protected boolean lineEnd;
	protected CommentType commentType;
	
	public CommentElement(String comment) {
		value = comment;
		commentType = CommentType.MULTILINE;
	}
	
	public CommentElement(String comment, CommentType commentType) {
		value = comment;
		this.commentType = commentType;
	}
	
	public String getValue() { return value; }
	
	public String setValue(String value) {
		String result = this.value;
		this.value = value;
		return result;
	}
	
	public CommentType getCommentType() {
		return commentType;
	}
	
	@Override
	public boolean isCommentElement() {
		return true;
	}

	@Override
	public CommentElement asCommentElement() {
		return this;
	}
	
	public CommentElement clone() {
		CommentElement result = new CommentElement(this.value);
		result.value = this.value;
		result.commentType = this.commentType;
		return result;
	}
}
