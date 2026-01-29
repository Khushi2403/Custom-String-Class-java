package mystringclass;

import java.io.Serializable;

class MyStringIndexOutOfBoundsException extends RuntimeException {
	public MyStringIndexOutOfBoundsException(String desc) {
		super(desc);
	}
}

public final class UserString {
	private char[] arr;
	private int indx;

	public UserString() {
		arr = new char[0];

	}

	public UserString(StringBuilder sb) {
		this(sb.toString());

	}

	public UserString(StringBuffer sb) {

		this(sb.toString());

	}

	public UserString(String str) {
		arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[indx++] = str.charAt(i);
		}

	}

	public UserString(byte[] arr) {
		this(arr, 0, arr.length);
	}

	public UserString(byte[] arr, int offset, int count) {
		if ((offset + count) > arr.length) {
			throw new MyStringIndexOutOfBoundsException("Index out of bounds");
		}
		this.arr = new char[count];
		for (int i = offset, j = 0; i < (offset + count); i++) {
			this.arr[j++] = (char) arr[i];
		}
	}

	public UserString(char[] arr, int offset, int count) {
		if ((offset + count) > arr.length) {
			throw new MyStringIndexOutOfBoundsException("Index out of bounds");
		}
		this.arr = new char[count];
		for (int i = offset, j = 0; i < (offset + count); i++) {
			this.arr[j++] = arr[i];
		}
	}

	public UserString(char[] arr) {
		this(arr, 0, arr.length);
	}

	public int length() {
		return arr.length;
	}

	public String toString() {
		if (arr.length == 0) {
			return "";
		}
		String output = "";
		for (char ele : arr) {
			output += ele;
		}
		return output;
	}

	public char charAt(int indx) {
		if (indx < 0 || indx > arr.length - 1) {
			throw new MyStringIndexOutOfBoundsException("INVALID INDEX");

		}
		return this.arr[indx];
	}

	public UserString concat(UserString str) {
		char[] newArr = new char[this.arr.length + str.length()];
		int indx = 0;
		for (char ele : this.arr)
			newArr[indx++] = ele;

		for (int i = 0; i < str.length(); i++)
			newArr[indx++] = str.charAt(i);

		return new UserString(newArr);
	}

	public UserString toUpperCase() {
		UserString newStr = new UserString();
		char[] newArr = new char[this.arr.length];

		int indx = 0;

		for (char ele : this.arr)
			newArr[indx++] = ele;

		int indx1 = 0;
		for (char ele : newArr) {
			if (ele >= 97 && ele <= 122) {
				newArr[indx1] = (char) (ele - 32);
			}
			indx1++;
		}
		return new UserString(newArr);

	}

	public UserString toLowerCase() {
		UserString newStr = new UserString();
		char[] newArr = new char[this.arr.length];

		int indx = 0;

		for (char ele : this.arr)
			newArr[indx++] = ele;

		int indx1 = 0;
		for (char ele : newArr) {
			if (ele >= 65 && ele <= 90) {
				newArr[indx1] = (char) (ele + 32);
			}
			indx1++;
		}
		return new UserString(newArr);

	}

	public int codePointAt(int indx) {
		if (indx < 0 || indx > arr.length)
			throw new MyStringIndexOutOfBoundsException("invalid index");
		return this.arr[indx] + 0;
	}

	public int codePointBefore(int indx) {
		if (indx <= 0 || indx > arr.length)
			throw new MyStringIndexOutOfBoundsException("invalid index");
		return this.arr[indx - 1] + 0;
	}

	public boolean isEmpty() {
		return this.arr.length == 0;
	}

	public char[] toCharArray() {
		char[] newArr = new char[this.arr.length];
		int indx = 0;
		for (char ele : this.arr)
			newArr[indx++] = ele;
		return newArr;

	}

	public boolean equals(Object obj) {
		UserString str = (UserString) obj;
		if (str.length() != this.length())
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (this.charAt(i) != str.charAt(i))
				return false;

		}
		return true;
	}

	public boolean equalsIgnoreCase(UserString comp) {
		return comp.toUpperCase().equals(this.toUpperCase());
	}

	public UserString replace(char oldChar, char newChar) {

		int indx = 0;
		while (this.arr.length > indx) {
			if (arr[indx] == oldChar) {
				break;
			}
			indx++;
		}
		if (indx == arr.length) {
			return this;
		} else {
			char[] newArr = new char[this.arr.length];
			int indx1 = 0;
			for (char ele : this.arr)
				newArr[indx1++] = ele;

			for (int i = 0; i < newArr.length; i++) {
				if (newArr[i] == oldChar) {
					newArr[i] = newChar;
				}
			}
			return new UserString(newArr);
		}

	}

	public int lastIndexOf(int ch) {

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(int ch, int start) {

		if (start >= this.arr.length) {
			start = this.arr.length - 1;
		}

		if (start < 0) {
			return -1;
		}

		for (int i = start; i >= 0; i--) {
			if (arr[i] == ch) {
				return i;
			}
		}
		return -1;

	}

	public int indexOf(int ch) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(int ch, int start) {

		if (start < 0) {
			start = 0;
		}

		if (start >= arr.length) {
			return -1;
		}

		for (int i = start; i < arr.length; i++) {
			if (arr[i] == ch) {
				return i;
			}
		}
		return -1;

	}

	public boolean contentEquals(StringBuffer sb) {
		if (sb == null)
			return false;
		if (arr.length != sb.length())
			return false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != sb.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static UserString valueOf(int i) {
		Integer integer = new Integer(i);
		String s = integer.toString();
		char[] ch = s.toCharArray();

		return new UserString(ch);
	}

	public static UserString valueOf(char c) {
		Character character = new Character(c);
		String s = character.toString();
		char[] ch = s.toCharArray();

		return new UserString(ch);
	}

	public static UserString valueOf(long l) {
		Long l1 = new Long(l);
		String s = l1.toString();
		char[] ch = s.toCharArray();

		return new UserString(ch);
	}

	public static UserString valueOf(double d) {
		Double d1 = new Double(d);
		String s = d1.toString();
		char[] ch = s.toCharArray();

		return new UserString(ch);
	}

	public static UserString valueOf(float f) {
		Float f1 = new Float(f);
		String s = f1.toString();
		char[] ch = s.toCharArray();

		return new UserString(ch);
	}

	public static UserString valueOf(boolean b) {
		Boolean b1 = new Boolean(b);
		String s = b1.toString();
		char[] ch = s.toCharArray();

		return new UserString(ch);
	}

	public UserString substring(int indx) {
		return substring(indx, arr.length);

	}

	public UserString substring(int start, int end) {
		if (start < 0 || start > arr.length - 1 || start > end) {
			throw new MyStringIndexOutOfBoundsException(null);
		}

		UserString str = new UserString();

		for (int i = start; i < end; i++) {
			char ch = this.arr[i];
			str = str.concat(new UserString(ch + ""));
		}
		return str;

	}

	public UserString trim() {
		UserString str = new UserString();
		int i = 0;
		for (; i < this.arr.length; i++) {
			if (arr[i] != ' ') {
				break;
			}
		}

		str = substring(i);
		int j = str.length() - 1;
		for (; j >= 0; j--) {
			if (str.charAt(j) != ' ')
				break;
		}

		str = str.substring(0, j + 1);
		return str;

	}

	public boolean startsWith(UserString str) {
		return startsWith(str, 0);
	}

	private boolean startsWith(UserString str, int index) {
		if (str.length() > this.arr.length)
			return false;

		for (int i = 0, j = index; i < str.length(); i++, j++) {
			if (this.arr[j] != str.charAt(i))
				return false;
		}
		return true;
	}

	public boolean endsWith(UserString str) {
		if (str.length() > this.arr.length)
			return false;
		for (int i = str.length(), j = this.arr.length - 1; i >= 0; i--, j--) {
			if (this.arr[j] != str.charAt(i))
				return false;
		}
		return true;
	}

}
