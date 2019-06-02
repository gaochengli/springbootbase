package java疯狂讲义;

public class StringBufferTest {

	public static void main(String[] args) {
	
		StringBuffer sb = new StringBuffer();
		sb.append("java");
		System.out.println(sb.toString());
		sb.insert(0, "hello ");
		System.out.println(sb);
		sb.replace(5, 6, ",");
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb.length());
		System.out.println(sb.capacity());
	}

}
