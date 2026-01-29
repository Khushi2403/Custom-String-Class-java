package mystringclass;

public class MyStringDriver {
	public static void main(String[] args) {

		// CONSTRUCTORS

		UserString u1 = new UserString();
		System.out.println("Empty Constructor : '" + u1 + "'");

		UserString u2 = new UserString("Hello");
		System.out.println("String Constructor : " + u2);

		StringBuilder sb = new StringBuilder("Builder");
		UserString u3 = new UserString(sb);
		System.out.println("StringBuilder Constructor : " + u3);

		StringBuffer sbf = new StringBuffer("Buffer");
		UserString u4 = new UserString(sbf);
		System.out.println("StringBuffer Constructor : " + u4);

		byte[] b = { 65, 66, 67, 68 };
		UserString u5 = new UserString(b);
		System.out.println("Byte Array Constructor : " + u5);

		char[] ch = { 'J', 'A', 'V', 'A' };
		UserString u6 = new UserString(ch);
		System.out.println("Char Array Constructor : " + u6);

		// METHODS(LENGTH,CHARAT ISEMPTY)

		System.out.println("Length : " + u2.length());
		System.out.println("charAt(1) : " + u2.charAt(1));
		System.out.println("isEmpty : " + u1.isEmpty());

		// CONCAT

		UserString c1 = new UserString("Hello ");
		UserString c2 = new UserString("World");
		System.out.println(c1.concat(c2));

		// CASE CONVERSION

		UserString s = new UserString("KhUsHi");
		System.out.println("Upper : " + s.toUpperCase());
		System.out.println("Lower : " + s.toLowerCase());

		// CODE POINT

		System.out.println("codePointAt(0) : " + s.codePointAt(0));
		System.out.println("codePointBefore(1) : " + s.codePointBefore(1));

		// EQUALS

		UserString e1 = new UserString("java");
		UserString e2 = new UserString("java");
		UserString e3 = new UserString("JAVA");

		System.out.println(e1.equals(e2));
		System.out.println(e1.equalsIgnoreCase(e3));

		// REPLACE

		UserString r = new UserString("banana");
		System.out.println(r.replace('a', 'o'));

		// INDEX METHODS

		UserString idx = new UserString("programming");
		System.out.println("indexOf('g') : " + idx.indexOf('g'));
		System.out.println("indexOf('g',5) : " + idx.indexOf('g', 5));
		System.out.println("lastIndexOf('g') : " + idx.lastIndexOf('g'));
		System.out.println("lastIndexOf('g',5) : " + idx.lastIndexOf('g', 5));

		// CONTENT EQUALS

		StringBuffer sb1 = new StringBuffer("Hello");
		UserString ce = new UserString("Hello");
		System.out.println(ce.contentEquals(sb1));

		// VALUE OF

		System.out.println(UserString.valueOf(10));
		System.out.println(UserString.valueOf(10.5));
		System.out.println(UserString.valueOf(5.2f));
		System.out.println(UserString.valueOf(true));
		System.out.println(UserString.valueOf('A'));
		System.out.println(UserString.valueOf(123456789L));

		// SUBSTRING

		UserString sub = new UserString("khushi");
		System.out.println(sub.substring(2));
		System.out.println(sub.substring(1, 4));

		// TRIM

		UserString t = new UserString("   hello world   ");
		System.out.println("'" + t.trim() + "'");

		// STARTS WITH / ENDS WITH

		UserString sw = new UserString("programming");
		System.out.println(sw.startsWith(new UserString("pro")));
		System.out.println(sw.endsWith(new UserString("ing")));

	}
}
